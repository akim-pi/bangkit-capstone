import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

import io
import tensorflow as tf
from tensorflow import keras
import numpy as np
from PIL import Image
import matplotlib.pyplot as plt
import matplotlib.image as mpimg
from flask import Flask, request, jsonify
from keras.models import load_model

model = keras.models.load_model("pollum-model.h5")

def transform_image(pillow_image):
    pillow_img = pillow_image.convert('RGB')
    data = np.asarray(pillow_img)
    data = data / 255.0
    data = data[np.newaxis, ...]
    # --> [1, x, y, 3]
    data = tf.image.resize(data, [100, 100])
    return data

class_name = [
    'Varroa, Small Hive Beetles', 
    'ant problems',
    'few varrao, hive beetles', 
    'healthy', 
    'hive being robbed',
    'missing queen'
]

def predict(x):
    predictions = model.predict(x)
    pred_index = np.argmax(predictions, axis=1)
    labels = [class_name[i] for i in pred_index]
    return labels

app = Flask(__name__)

@app.route("/", methods=["GET"])
def index():
    return jsonify({"message": "Welcome"})

@app.route("/bee", methods=["GET", "POST"])
def predict_bee():
    file = request.files.get('file')
    if file is None or file.filename == "":
        return jsonify({"error": "no file"})

    try:
        image_bytes = file.read()
        pillow_img = Image.open(io.BytesIO(image_bytes)).convert('RGB')
        tensor = transform_image(pillow_img)
        predictions = predict(tensor)
        data = {"Prediction": predictions}
        return jsonify(data)
    except Exception as e:
        return jsonify({"error": str(e)})
    
    return "OK"

if __name__ == "__main__":
    app.run(debug=True)
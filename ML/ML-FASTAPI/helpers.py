import skimage
import numpy as np
from PIL import Image
from io import BytesIO
from keras.models import load_model

image_shape = (100, 100)

def read_image(file) -> Image.Image:
    image = Image.open(BytesIO(file))
    image = np.asarray(image)
    return image

def preprocess_image(image: np.ndarray):
    image = skimage.transform.resize(image, image_shape, mode='reflect')
    image = np.expand_dims(image, 0)

    return image

model = load_model("model/")

class_name = [
    'Varroa, Small Hive Beetles', 
    'ant problems',
    'few varrao, hive beetles', 
    'healthy', 
    'hive being robbed',
    'missing queen'
]


def predict_image_class(image: np.ndarray):
    prediction = model.predict(image)
    idx = np.argmax(prediction)

    return class_name[idx]
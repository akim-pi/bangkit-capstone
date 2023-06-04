from fastapi import FastAPI, File, UploadFile
from helpers import *

app = FastAPI()

@app.post("/predict")
async def predict_api(file: UploadFile = File(...)):
    image = read_image(await file.read())
    image = preprocess_image(image)

    prediction = predict_image_class(image)
    return {'prediction': prediction}
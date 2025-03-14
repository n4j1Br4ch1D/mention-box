from typing import List
from fastapi import FastAPI
from sentence_transformers import SentenceTransformer
import torch
from pydantic import BaseModel  

app = FastAPI()


model = SentenceTransformer("sentence-transformers/all-MiniLM-L6-v2")



@app.post("/embed/")
async def embed_text(request: dict):
    text = request["text"]
    embedding = model.encode(text, convert_to_tensor=True).tolist()
    return {"embedding": embedding}


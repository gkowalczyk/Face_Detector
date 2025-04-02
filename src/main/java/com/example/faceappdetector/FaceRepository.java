package com.example.faceappdetector;

import com.example.faceappdetector.model.FaceObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FaceRepository extends MongoRepository<FaceObject, String> {
}

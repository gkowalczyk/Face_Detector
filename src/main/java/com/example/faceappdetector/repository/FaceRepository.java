package com.example.faceappdetector.repository;

import com.example.faceappdetector.model.FaceObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaceRepository extends ReactiveMongoRepository<FaceObject, String> {
}

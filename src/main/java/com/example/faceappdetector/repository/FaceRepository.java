package com.example.faceappdetector.repository;


import com.example.faceappdetector.entity.FaceObjectEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaceRepository extends ReactiveMongoRepository<FaceObjectEntity, String> {
}

package com.kaavsoft.gis.web.viewer.mongoDBLeafletViewer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kaavsoft.gis.web.viewer.mongoDBLeafletViewer.model.UndergroundLine;

@Repository
public interface UndergroundLineRepository extends MongoRepository<UndergroundLine, String>{
}
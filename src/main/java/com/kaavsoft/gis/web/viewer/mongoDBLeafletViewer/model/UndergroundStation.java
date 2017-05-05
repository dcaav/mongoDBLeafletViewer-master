package com.kaavsoft.gis.web.viewer.mongoDBLeafletViewer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.BasicDBObject;

@Document(collection = "underground_stations")
public class UndergroundStation {

	@Id
	private String id;
	/** Document Fields (Map) */
	private BasicDBObject properties;
	/** Document Geometry */
	private BasicDBObject geometry;

	/** Constructor */
	public UndergroundStation(final BasicDBObject properties, final BasicDBObject geometry) {
		super();
		this.properties = properties;
		this.geometry = geometry;
	}
	
	
	/** Getter for id */
	public String getId() {
		return id;
	}
	
	/** Setter for id */
	public void setId(String id) {
		this.id = id;
	}
	
	/** Getter for properties */
	public BasicDBObject getProperties() {
		return properties;
	}

	/** Setter for properties */
	public void setProperties(BasicDBObject properties) {
		this.properties = properties;
	}

	/** Getter for geometry */
	public BasicDBObject getGeometry() {
		return geometry;
	}

	/** Setter for geometry */
	public void setGeometry(BasicDBObject geometry) {
		this.geometry = geometry;
	}

	/** toString overwritten function */
	@Override
	public String toString() {
		return "UndergroundStation [id=" + id + "]";
	}

}
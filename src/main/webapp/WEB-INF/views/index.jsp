<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="iso-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<meta name="language" content="en" />
	<!--<link rel="shortcut icon" type="image/png"  href="resources/kaavsoft/img/leafletViewer.ico" />-->
	<title>leafletViewer (https://github.com/kaavsoft/gis/web/viewer/leafletViewer-master/)</title>

    <!-- OPENLAYERS -->
    <link rel="stylesheet" href="resources/vendor/leaflet/1.0.3/leaflet.css">
   	   	
	<!-- kaavsoft -->
	<link rel="stylesheet" href="resources/kaavsoft/css/main.css">

</head>
   
<body>
 	
	<!--<div class="map-container">-->
  	
  	<div id="map" class="map"></div>
  	  	
	<!--</div>-->
	
	    
	<!-- JQUERY -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/1.11.3/jquery-1.11.3.min.js" ></script>  	

	<!-- OPENLAYERS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/leaflet/1.0.3/leaflet.js" ></script>  

	<!-- kaavsoft -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/kaavsoft/js/main.js" ></script>  

	<script type="text/javascript"> 
		//Loading Underground Lines
 		<c:forEach var="undergroundLine" items="${undergroundLinesList}" varStatus="loop">
			L.geoJson({
    			"type": "Feature",
    			"properties": {
    		    	"tag": "${undergroundLine.properties.tag}",
    		    	"color": "${undergroundLine.properties.color}"        			
    			},
    			"geometry": ${undergroundLine.geometry} 
			}, {
             	style: function(feature) {
        			return {color: feature.properties.color};
    			},
   				onEachFeature: function (feature, layer) {
       				layer.bindPopup(feature.properties.tag);
   				}
			}).addTo(map);
		</c:forEach>
		
		//Loading Underground Stations
 		<c:forEach var="undergroundStation" items="${undergroundStationsList}" varStatus="loop">
			L.geoJson({
    			"type": "Feature",
    			"properties": {
    		    	"tag": "${undergroundStation.properties.tag}",
    		    	"address": "${undergroundStation.properties.address}",
    		    	"info": "${undergroundStation.properties.info}",
     		   		"search": "${undergroundStation.properties.search}",
     		   		"city": "${undergroundStation.properties.city}"        			
    			},
    			"geometry": ${undergroundStation.geometry} 
			}, {
             	/*style: function (feature) {
       				return {};
   				},*/
				pointToLayer: function(feature, latlng) {
   					var smallIcon = L.icon({
                      	iconSize: [40, 25],
                      	popupAnchor:  [1, -24],
                      	iconUrl: 'resources/kaavsoft/img/underground.png'
   					});
   					return L.marker(latlng, {icon: smallIcon});
				},
   				onEachFeature: function (feature, layer) {
       				layer.bindPopup(feature.properties.info);
   				}
			}).addTo(map);
		</c:forEach>
 	
 	</script>

</body>
</html> 
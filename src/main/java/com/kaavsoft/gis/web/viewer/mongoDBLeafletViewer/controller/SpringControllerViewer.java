package com.kaavsoft.gis.web.viewer.mongoDBLeafletViewer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kaavsoft.gis.web.viewer.mongoDBLeafletViewer.model.UndergroundLine;
import com.kaavsoft.gis.web.viewer.mongoDBLeafletViewer.model.UndergroundStation;
import com.kaavsoft.gis.web.viewer.mongoDBLeafletViewer.repository.UndergroundLineRepository;
import com.kaavsoft.gis.web.viewer.mongoDBLeafletViewer.repository.UndergroundStationRepository;

@Controller
public class SpringControllerViewer implements ErrorController{

    private static final String PATH = "/error";
	
	@Autowired
	private UndergroundLineRepository undergroundLinesRepository;
	
	@Autowired
	private UndergroundStationRepository undergroundStationsRepository;
	
	@RequestMapping(value = "/")
	public ModelAndView IndexView( ModelMap model ) {
		List<UndergroundLine> undergroundLinesList = undergroundLinesRepository.findAll();
		List<UndergroundStation> undergroundStationsList = undergroundStationsRepository.findAll();

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("undergroundLinesList", undergroundLinesList);
		modelAndView.addObject("undergroundStationsList", undergroundStationsList);
		
		return modelAndView;
	}

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
    
}

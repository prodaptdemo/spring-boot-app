package com.prodapt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.app.model.AppResponse;
import com.prodapt.app.service.AppService;

@RestController
public class AppController {

	@Autowired
	private AppService appService;

	public void setEaseYourWorkService(AppService appService) {
		this.appService = appService;
	}

	@RequestMapping(value = "/getAnalysis", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public AppResponse getResult(String appname) {
		return appService.getResult(appname);
	}
}

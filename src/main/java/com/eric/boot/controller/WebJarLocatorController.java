package com.eric.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;
import org.webjars.WebJarAssetLocator;

@Controller
public class WebJarLocatorController {

	private final WebJarAssetLocator locator = new WebJarAssetLocator();
	
	@RequestMapping("/webjarlocator/{webjar}/**")
	public ResponseEntity<?> locateWebjarAsset(@PathVariable String webjar, HttpServletRequest request) {
		try {
			String prefix = "/webjarlocator/"+webjar+"/";
			System.out.println("prefix:"+prefix);
			String path = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			System.out.println("path:"+path);
			String fullPath = locator.getFullPath(webjar, path.substring(prefix.length()));
			System.out.println("fullPath:"+fullPath);
			return new ResponseEntity<>(new ClassPathResource(fullPath), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

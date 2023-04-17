package com.bluebird.jsonmate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebird.jsonmate.entity.Template;
import com.bluebird.jsonmate.repository.TemplateRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class TemplateService {
	
	@Autowired
	private TemplateRepository templateRepository;
	
	ObjectMapper objectMapper = new ObjectMapper();


	public Template modify(long x){
		Optional<Template> templateOptional = templateRepository.findById(x);
		if (templateOptional.isPresent()) {
		    Template template = templateOptional.get();
		    System.out.println(template.toString());
		    JsonNode templateJson = template.getData();

		 // Modify simple fields
		    if(templateJson.has("make"))
		    	((ObjectNode) templateJson).put("make", "Bugati");
		    else
		    	System.out.println("The make field is not present in the JSON.");
		    template.setData(templateJson);
		    System.out.println(template.toString());
		    
		 // Modify field inside fields
		    if (templateJson.has("location")) {
		        ObjectNode location = (ObjectNode) templateJson.get("location");
		        if (location.has("latitude")) {
		            location.put("latitude", "22.6754");
		        } else {
		        	location.put("latitude", "22.6754");
		        }
		    }

		 // Modify array fields
		    if (templateJson.has("readings") && templateJson.get("readings").isArray()) {
		        ArrayNode readings = (ArrayNode) templateJson.get("readings");
		        for (JsonNode reading : readings) {
		            ObjectNode readingNode = (ObjectNode) reading;
		            if (readingNode.has("value")) {
		                readingNode.put("value", 10.05);
		            }
		        }
		    }
		    System.out.println(template.toString());
		    return template;
		}
		return new Template();
	}
}

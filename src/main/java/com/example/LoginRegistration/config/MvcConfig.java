package com.example.LoginRegistration.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	
	
	  @Override 
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  
	  Path photoUploadDir = Paths.get("./img/stuImg");
	  String PhotoUploadPath =photoUploadDir.toFile().getAbsolutePath();
	  System.out.println(PhotoUploadPath);
	  registry.addResourceHandler("/img/stuImg/**").addResourceLocations("file:/"+
	  PhotoUploadPath+"/"); }
	 
}

package com.jorge.drogaria.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//http://localhost:8080/Drogaria/rest
@ApplicationPath("rest")
public class DrogariaResourceConfig extends ResourceConfig {
	public DrogariaResourceConfig(){
		packages("com.jorge.drogaria.service");
	}
}



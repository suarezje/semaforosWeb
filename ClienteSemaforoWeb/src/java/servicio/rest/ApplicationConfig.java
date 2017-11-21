/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.rest;
import java.util.Set;

import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application{

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourcesClasses(resources);
		return resources;
	}
	
	private void addRestResourcesClasses(Set<Class<?>> resources){
		resources.add(servicio.rest.ClienteSemaforoImpl.class);
	}
}

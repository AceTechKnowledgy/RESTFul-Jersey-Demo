package com.ace.restdemo.test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ace.restdemo.model.Test;

@Path("/test") //This class with be called when the URI(contextpath/test) is request from the client.
public class TestResource {
	
	/*When the URI<contextpath/test/hi> is requested as GET, this method will be called and return(produces)
	 *the string to the client as a plain text format.
	*/
	@GET
	@Path("/hi")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Welcome to RestFul Webservices using Jersey";
	}
	
	/*When the URI<contextpath/test/students> is requested as GET, this method will be called and return(produces)
	 *all the students to the client as a JSON format.
	*/
	@GET
	@Path("/students")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Test> getAllStudents() {
		List<Test> students = new ArrayList<>();
		
		students.add(new Test(1, "Siva"));
		students.add(new Test(2, "Kumar"));
		students.add(new Test(3, "Prakash"));
		students.add(new Test(4, "Sankar"));
		students.add(new Test(5, "Surya"));
		
		return students;
	}
}

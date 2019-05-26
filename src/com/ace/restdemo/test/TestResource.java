package com.ace.restdemo.test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	
	/* When the URI<ontextpath/test/insertdata> is requested as GET, the client will pass the input data and will
	 * receive the inputs in server as "PathParam" and will manipulate these inputs and will return the results
	 * to the client as a plain text.
	 * Eg URL. http://localhost:8080/Rest-Jersey-Demo/rs/test/insertdata/100/Siva
	 */
	@GET
	@Path("/insertdata/{id}/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPath(@PathParam("id") int id, @PathParam("name") String name) {
		return "Inserted data Successfully \n" +
			   "************************** \n" +
			   "Id: " +id                      +
			   "\nName: "+name;
	}
	
	/* When the URI<ontextpath/test/query> is requested as GET, the client will pass the input data delimited by & and will
	 * receive the inputs in server as "QueryParam" and will manipulate these inputs and will return the results
	 * to the client as a XML text.
	 * Eg URL. http://localhost:8080/Rest-Jersey-Demo/rs/test/query?id=1&name=Siva
	 */
	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_XML)
	public String insertQuery(@QueryParam("id") int id, @QueryParam("name") String name) {
		return "<result><status>success</status></result>";
	}
}

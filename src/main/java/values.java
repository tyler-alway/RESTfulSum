package com.alway.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
 
@Path("/")
public class values {
	
	String fileName = "values.txt"; // Name of the external file

	@GET
	@Path("/sum/values")
	@Produces("text/html")
	// getResponse method retrieves all values from the external file and adds them together
	// and returns this value
	// if the file does not exist or is empty zero will be returned
	public Response getRequest() {
		
		int sum = 0; // Integer to hold the sum of all values store in the file
		String curr; // String to store the current Integer retrieved from the file

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((curr = br.readLine()) != null) {
				sum += Integer.parseInt(curr); 
			}
			br.close();
						
		} catch(IOException ex) {
			System.out.println("Error could not read from" + fileName);
		}

		return Response.status(200).entity(Integer.toString(sum) + '\n').build();
	}
	
	@POST
	@Path("/values")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("text/html")
	//Adds a single value to the external file
	public Response postRequest(@FormParam("value") int value) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            // Write the value to the file
            bw.append(Integer.toString(value) + '\n');
            bw.close();
        }
        catch(IOException ex) {
           // Return a server error 
           return Response.status(500).entity("falied to add value").build();
        }
        
		return Response.status(200).entity("ok\n").build();
	}
	
	@DELETE
	@Path("/values")
	@Produces("text/html")
	//Removes all values from external file
	public Response delestRequest() {
		PrintWriter pw;
		try {
			//clears file contents without deleting file
			pw = new PrintWriter(fileName);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		return Response.status(200).entity("ok\n").build();
	}
}

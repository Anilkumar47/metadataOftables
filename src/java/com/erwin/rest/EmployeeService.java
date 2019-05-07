/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erwin.rest;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.internal.util.Base64;

/**
 *
 * @author Keerthi
 */
@Path("/employeeService")
public class EmployeeService {

    public static ArrayList<Employee> allEmployees = new ArrayList<Employee>();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Object getEmployee(@HeaderParam("Authorization") String credentials) {
        Response response = null;
        if (validate(credentials) && credentials != null) {
            return allEmployees;
        }
        response = Response.status(401).entity("Access is denied due to invalid credentials").build();
        return response;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response setEmployee(Employee e, @HeaderParam("Authorization") String credentials) {
        if (validate(credentials) && credentials != null) {
            allEmployees.add(e);
            return null;
        }
        Response response = Response.status(401).entity("Access is denied due to invalid credentials").build();
        return response;
    }

    public boolean validate(String credentials) {
        if (credentials != null) {
            String usernameNPassword = credentials.replaceFirst("Basic ", "");
            String decodedUserNPassword = Base64.decodeAsString(usernameNPassword);
            StringTokenizer st = new StringTokenizer(decodedUserNPassword, ":");
            final String userName = st.nextToken();
            final String password = st.nextToken();
            if (userName.equalsIgnoreCase("anil") && password.equalsIgnoreCase("anil123")) {
                return true;
            }
        }
        return false;
    }
}

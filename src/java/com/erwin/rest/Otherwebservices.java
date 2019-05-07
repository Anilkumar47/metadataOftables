/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erwin.rest;

//import com.sun.jersey.api.client.Client;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
/**
 *
 * @author Keerthi
 */
public class Otherwebservices {

    public static void main(String args[]) {

//        Client client = Client.create();
//        WebResource web = client.resource("http://192.168.1.14:9090/RestfulWebServices/rest/erwin/employees?user=shiva&pass=shiva");
//        ClientResponse response = web.accept("application/json").get(ClientResponse.class);
//        if (response.getStatus() == 200) {
//            String res = response.getEntity(String.class);
//            System.out.println(res);
//        } else {
//            System.out.println("Failed");
//        }
        Employee e = new Employee();
        e.setId(0);
        e.setName("ajay");
        Client client = ClientBuilder.newClient();
        String s = client.target("http://localhost:8090/webservicesApp/rest/employeeService")
                .request(MediaType.APPLICATION_JSON).header("Authorization","Basic YW5pbDphbmlsMTIz")
                .get(String.class);
        System.out.println(s);
    }

}

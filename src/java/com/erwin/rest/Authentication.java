///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.erwin.rest;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.StringTokenizer;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.ext.Provider;
//import org.glassfish.jersey.internal.util.Base64;
//
///**
// *
// * @author Keerthi
// */
//@Provider
//public class Authentication implements ContainerRequestFilter {
//
//    public static String auth;
//
//    @Override
//    public void filter(ContainerRequestContext requestContext) throws IOException {
//        List<String> ls = requestContext.getHeaders().get("Authorization");
//        auth = ls.get(0);
//        String token = auth.split(" ")[1];
//        String t = Base64.decodeAsString(token);
//        StringTokenizer s = new StringTokenizer(t, ":");
//        System.out.println(s.nextToken());
//        System.out.println(s.nextToken());
//
//    }
//
//}

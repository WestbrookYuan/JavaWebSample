package com.yty.javaweb.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ReflactAnnoation {
    public static void main(String[] args) throws Exception {
        Class<?> welcomeServletClass = Class.forName("com.yty.javaweb.servlet.WelcomeServlet");
        if (welcomeServletClass.isAnnotationPresent(WebServlet.class)){
            Annotation[] annotations = welcomeServletClass.getAnnotations();
            System.out.println(Arrays.toString(annotations));
            WebServlet annotation = welcomeServletClass.getAnnotation(WebServlet.class);
            String[] strings = annotation.urlPatterns();
            System.out.println(Arrays.toString(strings));
        }
    }
}

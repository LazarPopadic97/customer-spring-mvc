/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.application.customerspringmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author korisnik
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    
    public MyWebApplicationInitializer() {
        System.out.println("======================================================");
        System.out.println("MyWebApplicationInitializer...");
        System.out.println("======================================================");
    }
    
    @Override
    public void onStartup(ServletContext sc) throws ServletException {

        //kreiraj root application kontekst
        AnnotationConfigWebApplicationContext rootApplicationContext = new AnnotationConfigWebApplicationContext();
        rootApplicationContext.register(RootAppConfig.class);
        sc.addListener(new ContextLoaderListener(rootApplicationContext));
        //kreiraj web application kontekst koji se vezuje za dispatcher servlet
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(MvcConfig.class);//klasa u kojoj se definisu odgvarujuci bean-ovi

        //konfigurisanje dispatcher servlet-a
        ServletRegistration.Dynamic dispatcher = sc
                .addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1); //1-true
    }
    
}

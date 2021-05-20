/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.application.customerspringmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author korisnik Sluzi za konfigurisanje svih komponenti koje ucestvuju u
 * obradi zahteva
 */
@Configuration
@ComponentScan(basePackages = {
    "rs.fon.silab.application.customerspringmvc.controller"
})
@EnableWebMvc
public class MvcConfig {
    //handler mappera
    //controller-a
    //view resolver-a

    @Bean
    public ViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }

    @Bean(name = "city-list")
    public View cityList() {
        JstlView view = new JstlView();
        view.setUrl("/pages/city/city-list.jsp");
        return view;
    }

    @Bean(name = "city-add")
    public View cityAdd() {
        JstlView view = new JstlView();
        view.setUrl("/pages/city/city-add.jsp");
        return view;
    }

    @Bean(name = "city-add-model")
    public View cityAddModel() {
        JstlView view = new JstlView();
        view.setUrl("/pages/city/city-add-model.jsp");
        return view;
    }
}

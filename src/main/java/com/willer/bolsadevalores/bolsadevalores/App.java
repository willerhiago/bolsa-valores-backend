package com.willer.bolsadevalores.bolsadevalores;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.willer.bolsadevalores.bolsadevalores.controllers.AcaoController;
import com.willer.bolsadevalores.bolsadevalores.routes.AcaoRoute;
import com.willer.bolsadevalores.bolsadevalores.controllers.CorretoraController;
import com.willer.bolsadevalores.bolsadevalores.routes.CorretoraRoute;
import com.willer.bolsadevalores.bolsadevalores.controllers.AcaoCorretoraController;
import com.willer.bolsadevalores.bolsadevalores.routes.AcaoCorretoraRoute;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Configuration
public class App {

    public static AnnotationConfigApplicationContext getContext() {
        return new AnnotationConfigApplicationContext(App.class);
    }

    @Bean
    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("bolsavalores").createEntityManager();
    }

    @Bean
    public AcaoController acaoController() {
        return new AcaoController(this.getEntityManager());
    }    
    @Bean
    public AcaoRoute AcaoRoute() {
        return new AcaoRoute(acaoController());
    }
    
    @Bean
    public CorretoraController corretoraController() {
        return new CorretoraController(this.getEntityManager());
    }    
    @Bean
    public CorretoraRoute CorretoraRoute() {
        return new CorretoraRoute (corretoraController());
    }
    
    @Bean
    public AcaoCorretoraController acaoCorretoraController() {
        return new AcaoCorretoraController(this.getEntityManager());
    }    
    @Bean
    public AcaoCorretoraRoute AcaoCorretoraRoute() {
        return new AcaoCorretoraRoute(acaoCorretoraController());
    }


}

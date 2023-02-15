package com.bekirdogan.bean;

import com.bekirdogan.controller.BeanController;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@Controller
public class PostContructTutorials {
    /*@Autowired
    Logger LOG;*/

    // parametresiz constructor
    /*public BeanController(){
        LOG.info("Log info called");
    }*/

    // bean henüz başlamadığından null alıyoruz ve burada bağımlılığı enjecte edemiyoruz.
    // görevi: bir bean nesenesi oluşturdupunda hemen oluşur.
    /*@PostConstruct
    public void init() {
        LOG.info("Log info called");
    }*/

    /*public static void main(String[] args) {
        BeanController beanController = new BeanController();
        System.out.println(beanController);
    }*/
}

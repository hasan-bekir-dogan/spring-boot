package com.bekirdogan.tutorials.controller;

import com.bekirdogan.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    // option: root {}
    // http://localhost:8080
    @GetMapping({"/", "index"})
    public String index() {
        return "index";
    }

    // @ResponseBody
    // http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody
    public String getThymeleaf1() {
        return "thymeleaf1";
    }


    // Model
    // http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    //@ResponseBody
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model1", "I am coming from model-1");
        model.addAttribute("key_model2", "I am coming from model-2");
        return "thymeleaf1";
    }


    // Model
    // http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    //@ResponseBody
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model1", "I am coming from model-3");
        model.addAttribute("key_model2", "I am coming from model-2");
        return "thymeleaf_file/thymeleaf3";
    }


    // Model
    // http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    //@ResponseBody
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "I am coming from model-4");
        return "thymeleaf4";
    }


    ///////////////////////////////////////////////////////////////////////////////////////
    // Send Model Object
    // http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    //@ResponseBody
    public String getThymeleaf5Model(Model model) {
        model.addAttribute("key_model1", "text");

        ProductDto productDto = ProductDto
                .builder()
                .productId(0L)
                .productName("Honda Civic")
                .productPrice(15000.0)
                .build();

        model.addAttribute("key_model2", productDto);

        return "thymeleaf5";
    }


    ///////////////////////////////////////////////////////////////////////////////////////
    // Send Model Object
    // http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    //@ResponseBody
    public String getThymeleaf6ModelList(Model model) {
        model.addAttribute("key_model1", "text");

        List<ProductDto> myList = new ArrayList<>();

        myList.add(ProductDto.builder().productId(1L).productName("Honda Civic").productPrice(15000.0).build());
        myList.add(ProductDto.builder().productId(2L).productName("BMW 3 Series").productPrice(25000.0).build());
        myList.add(ProductDto.builder().productId(3L).productName("BMW 5 Series").productPrice(45000.0).build());
        myList.add(ProductDto.builder().productId(4L).productName("Porsche Panamera").productPrice(65000.0).build());

        model.addAttribute("product_list", myList);

        return "thymeleaf6";
    }


    ///////////////////////////////////////////////////////////////////////////////////////
    // Send Model Object
    // http://localhost:8080/thymeleaf7/4
    // http://localhost:8080/thymeleaf7/
    @GetMapping({"/thymeleaf7", "/thymeleaf7/{id}"})
    //@ResponseBody
    public String getThymeleaf7Model(Model model, @PathVariable(name = "id", required = false) Long id) {
        if (id != null)
            model.addAttribute("key_model1", "id: " + id);
        else
            model.addAttribute("key_model1", "id is not found");


        return "thymeleaf7";
    }



    ///////////////////////////////////////////////////////////////////////////////////////
    // Send Model Object
    // http://localhost:8080/thymeleaf8?id=4
    @GetMapping("/thymeleaf8")
    //@ResponseBody
    public String getThymeleaf8Model(Model model,
                                     @RequestParam(name = "id", required = false, defaultValue = "0") Long id,
                                     @RequestParam(name = "name") String name) {
        if(id != null)
            model.addAttribute("key_model1", "id: " + id + " name: " + name);
        else
            model.addAttribute("key_model1", "id is not found");

        return "thymeleaf8";
    }

}

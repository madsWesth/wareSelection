package com.example.wareselection.Controller;

import com.example.wareselection.product.Products;
import com.example.wareselection.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.fetchAll());
        return "index";
    }

    @GetMapping("/createProduct")
    public String createProduct() {
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Products product) {
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, Model model) {
        productService.findById(id)
                .ifPresent(value -> model.addAttribute("product", value));
        return "updateProduct";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, @ModelAttribute Products product) {
        productService.update(id, product);
        return "redirect:/";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/";
    }


}

package com.example.wareselection.Controller;

import com.example.wareselection.product.Product;
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
    public String createProduct(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "updateProduct";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, @ModelAttribute Product product) {
        productService.update(id, product);
        return "redirect:/";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/";
    }


}

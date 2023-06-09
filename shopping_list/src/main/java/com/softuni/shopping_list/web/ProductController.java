package com.softuni.shopping_list.web;

import com.softuni.shopping_list.model.binding.ProductAddBindingModel;
import com.softuni.shopping_list.model.entity.Product;
import com.softuni.shopping_list.model.service.ProductServiceModel;
import com.softuni.shopping_list.model.service.UserServiceModel;
import com.softuni.shopping_list.service.ProductService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model){
        if (!model.containsAttribute("productAddBindingModel")){
            model.addAttribute("productAddBindingModel", new ProductAddBindingModel());
            model.addAttribute("isAdded", false);
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productAddBindingModel",productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel",
                    bindingResult);
            return "redirect:add";
        }
        ProductServiceModel productServiceModel = this.productService.findByName
                (productAddBindingModel.getName());

        if (productServiceModel != null){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("isAdded", true);
            return "redirect:add";
        }
        this.productService.addProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable Long id){
        productService.buyById(id);
        return "redirect:/";
    }

    @GetMapping("buy/all")
    public String buyAllProducts(){
        productService.buyAllProducts();
        return "redirect:/";
    }
}

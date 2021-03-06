package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    OutfitRepository outfitRepository;


    @RequestMapping("/secure")
    public String secure(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("currentuser", userRepository.findByUsername(username));
        Set<Role> roles = new HashSet<Role>();
        model.addAttribute("roles", roleRepository.findAllByUsername(username));
        model.addAttribute("allusers", userRepository.findAll());
        model.addAttribute("currentrole", roleRepository.findByUsername(username));
        model.addAttribute("roles",roleRepository.findAll());

        return "secure";
    }

    @RequestMapping("/")
    public String index(Principal principal, Model model){
        Outfit outfit =outfitRepository.findByCurrentoutfit(true);
        outfit.setItems(null);
        outfitRepository.save(outfit);
        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }
    @PostMapping("/processsignup")
    public String processSignup(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "signup";
        } else {
            model.addAttribute("message", "You have successfully created an account!");
            user.setEnabled(true);
            Role role = new Role(user.getUsername(), "ROLE_USER");
            Set<Role> roles = new HashSet<Role>();
            roles.add(role);

            roleRepository.save(role);
            userRepository.save(user);
        }
        return "redirect:/login";
    }


    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/login?logout=true";
    }

    @RequestMapping("/admin")
    public String admin(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("currentuser", userRepository.findByUsername(username));
        model.addAttribute("allusers", userRepository.findAll());
        model.addAttribute("currentrole", roleRepository.findByUsername(username));
        model.addAttribute("roles",roleRepository.findAll());

        return "admin";
    }

    @GetMapping("/register")
    public String register(Model model, Principal principal){
        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, Principal principal){
        model.addAttribute("user", user);
        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
        if(result.hasErrors()){
            return "register";
        } else {
            model.addAttribute("message", "User Account Created");
            user.setEnabled(true);
            Role role = new Role(user.getUsername(), "ROLE_USER");
            Set<Role> roles = new HashSet<Role>();
            roles.add(role);

            roleRepository.save(role);
            userRepository.save(user);
        }
        return "index";
    }

    @GetMapping("/add")
    public String addItem(Model model){
        model.addAttribute("item", new Item());
        model.addAttribute("allcategories", categoryRepository.findAll());
        return "add";
    }

//<<<<<<< Updated upstream
    @PostMapping("/processItem")
    public String processItem(@ModelAttribute Item item, @RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "redirect:/add";
        }
        try { Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype","auto"));
            item.setImages(uploadResult.get("url").toString());
            itemRepository.save(item);
        }
        catch (IOException e){
            e.printStackTrace();
            return "redirect:/add";
        }
        return "redirect:/";
    }
    @GetMapping("/wardrobe")
    public String listItem(Model model){

      model.addAttribute("items",itemRepository.findAll());

      model.addAttribute("outfit",outfitRepository.findByCurrentoutfit(true));

      model.addAttribute("category", categoryRepository.findAll());

      return "wardrobe";
    }

    @PostMapping("/wardrobe")
    public String processWardrobe(Model model,@RequestParam String[] checkedItems){
        Outfit outfit=outfitRepository.findByCurrentoutfit(true);
        for(String s: checkedItems){
            Item i=itemRepository.findById(Long.parseLong(s)).get();
            i.setOutfit(outfit);
            itemRepository.save(i);
            System.out.println("built relationship: "+ i.getItemName()+ " outfit id"+ i.getOutfit().getId());
        }


        model.addAttribute("outfit", outfit);
        return "redirect:/outfit";
    }

    @RequestMapping("/select/{id}")
    public String detail(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("item", itemRepository.findById(id).get());
        return "outfit";
    }
    @RequestMapping("/outfit")
    public String showoutfit( Model model){
        model.addAttribute("outfit", outfitRepository.findByCurrentoutfit(true));
        Outfit o=outfitRepository.findByCurrentoutfit(true);

        //model.addAttribute("item", itemRepository.findAll());
        return "outfit";
    }



    //TAK added this
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){

        model.addAttribute("task", itemRepository.findById(id).get());
        Item i=itemRepository.findById(id).get();
        i.setCategory(null);
        itemRepository.deleteById(id);
        return "redirect:/wardrobe";
    }
}

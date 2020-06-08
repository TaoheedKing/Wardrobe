package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/secure")
    public String secure(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));

        return "secure";
    }

    @RequestMapping("/")
    public String index(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/login?logout=true";
    }

    @RequestMapping("/admin")
    public String admin(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
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


}

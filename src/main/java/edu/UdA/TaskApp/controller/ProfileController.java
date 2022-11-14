package edu.UdA.TaskApp.controller;

import edu.UdA.TaskApp.models.Profile;
import edu.UdA.TaskApp.models.Profile;
import edu.UdA.TaskApp.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProfileController {


    @Autowired
    ProfileService profileService;

    @GetMapping("/ViewProfiles")
    public String viewProfiles(Model model){
        List<Profile> profileList = profileService.getProfiles();
        model.addAttribute("profileList", profileList);
        return "viewProfiles";
    }

    //SERVICIO PARA AGREGAR Profile
    @GetMapping("/AddProfile")
    public String newProfile(Model model){
        Profile profile = new Profile();
        model.addAttribute("profile",profile);
        return "addProfile";
    }

    //SERVICIO PARA GUARDAR Profile
    @PostMapping("/SaveProfile")
    public String saveProfile(Profile profile, RedirectAttributes redirectAttributes){
        try{
            profileService.insert(profile);
        }catch (Exception e){
            return "redirect:/ViewProfiles";
        }
        return "redirect:AddProfiles";
    }

    //SERVICIO PARA EDITAR Profile
    @GetMapping("/EditProfile/{id}")
    public String editProfile(Model model, @PathVariable Long id){
        Profile profile = profileService.getProfileById(id);
        model.addAttribute("profile",profile);
        return "editProfile";

    }

    //SERVICIO PARA ACTUALIZAR Profile
    @PostMapping("/UpdateProfile")
    public String updateProfile(Long id, Profile profile){
        try{
            profileService.updateProfile(id, profile);
        }catch (Exception e){
            return "redirect:/ViewProfiles";
        }
        return "redirect:EditProfiles";
    }

    //SERVICIO PARA ELIMINAR Profile
    @GetMapping("/DeleteProfile/{id}")
    public String deleteProfile(@PathVariable Long id){
        try{
            profileService.deleteProfile(id);
        }catch (Exception e){
            return "redirect:/ViewProfiles";
        }
        return "redirect:ViewProfiles";
    }




}

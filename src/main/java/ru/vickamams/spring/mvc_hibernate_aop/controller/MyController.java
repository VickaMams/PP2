package ru.vickamams.spring.mvc_hibernate_aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vickamams.spring.mvc_hibernate_aop.entity.User;
import ru.vickamams.spring.mvc_hibernate_aop.service.UserService;

import java.util.List;

@Controller
public class MyController {
    public static boolean checkUpdate = false;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String  showAllEmployees(Model model){

        List<User> allEmployees = userService.getAllUsers();
        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){

        User user = new User();
        model.addAttribute("employee", user);

        return "employee-info";
    }
    @RequestMapping ("/saveEmployee")
    public  String saveEmployee(@ModelAttribute("employee") User employee){

        userService.saveUser(employee);

        return "redirect:/";
    }

   @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        checkUpdate=true;
        User employee = userService.getUser(id);
        model.addAttribute("employee", employee);
        return"employee-info";
    }
    @RequestMapping("/deleteEmployee")
    public  String deleteEmployee(@RequestParam("empId") int id){

        userService.deleteUser(id);


        return "redirect:/";
    }
}

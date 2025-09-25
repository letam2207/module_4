package com.example.ss7_bai_1.controller;

import com.example.ss7_bai_1.dto.UserDto;
import com.example.ss7_bai_1.entity.User;
import com.example.ss7_bai_1.service.IUserService;
import com.example.ss7_bai_1.validation.UserValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String getAllUser(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("user", users);
        return "user/list";
    }

    @GetMapping("/create")
    public String createUser(ModelMap model) {
        model.addAttribute("userDto", new UserDto()); // dùng userDto
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("userDto") UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirect ,Model model) {
        UserValidation userValidation = new UserValidation();
        userValidation.validate(userDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/user";
    }

}

package com.example.commerce;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

//    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index() {


        return "index";
    }


}

package com.px.sp_boot.web;

import com.px.sp_boot.oxm.pojo.AuthorizePayInfo;
import com.px.sp_boot.service.AuthorizeTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class Home {

    private Logger logger = LoggerFactory.getLogger(Home.class);

    @Resource
    private AuthorizeTransactionService authorizeTransactionService;

    @GetMapping(value = "/home")
    public String home(Model model){
        List<AuthorizePayInfo> authorizePayInfoList = authorizeTransactionService.list();
        logger.info(authorizePayInfoList.toString());
        model.addAttribute("day", authorizePayInfoList.get(0).getClientKey());
        model.addAttribute("authorizePayInfoList", "authorizePayInfoList");
        return "home";
    }
}

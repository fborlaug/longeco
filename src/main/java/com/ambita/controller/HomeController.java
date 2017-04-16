package com.ambita.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ambita.report.UserDistance;
import com.ambita.service.ReportService;

@Controller
public class HomeController {

  private ReportService reportService;

  public HomeController(ReportService reportService) {
    this.reportService = reportService;
  }

  @GetMapping(value= {"/home", "/"})
  public String home(Model model) {

    List<UserDistance> total = reportService.getTotal();

    model.addAttribute("total", total);

    return "home";
  }
}
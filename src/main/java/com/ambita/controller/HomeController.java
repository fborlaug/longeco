package com.ambita.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ambita.model.report.UserSum;
import com.ambita.service.ReportService;

@Controller
public class HomeController {

  private ReportService reportService;

  public HomeController(ReportService reportService) {
    this.reportService = reportService;
  }

  @GetMapping(value= {"/home", "/"})
  public String home(Model model) {

    List<UserSum> totalUserDistances = reportService.getTotalUserDistances();
    model.addAttribute("totalUserDistances", totalUserDistances);

    List<UserSum> totalUserCounts = reportService.getTotalUserCounts();
    model.addAttribute("totalUserCounts", totalUserCounts);

    return "home";
  }
}
package com.ambita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambita.report.ReportQuery;
import com.ambita.report.UserDistance;

@Service
public class ReportService {

  private ReportQuery reportQuery;

  @Autowired
  public ReportService(ReportQuery reportQuery) {
    this.reportQuery = reportQuery;
  }

  public List<UserDistance> getTotal(){
    return reportQuery.getTotal();
  }
}

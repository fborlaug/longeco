package com.ambita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambita.repository.ReportRepository;
import com.ambita.model.report.UserSum;

@Service
public class ReportService {

  private ReportRepository reportQuery;

  @Autowired
  public ReportService(ReportRepository reportQuery) {
    this.reportQuery = reportQuery;
  }

  public List<UserSum> getTotalUserDistances(){
    return reportQuery.getTotalUserDistances();
  }

  public List<UserSum> getTotalUserCounts(){
    return reportQuery.getTotalUserCounts();
  }
}

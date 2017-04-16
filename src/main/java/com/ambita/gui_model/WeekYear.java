package com.ambita.gui_model;

import lombok.Getter;

import static com.ambita.util.DateUtil.getCurrentWeekNumber;
import static com.ambita.util.DateUtil.getCurrentYear;
import static com.ambita.util.DateUtil.isWeekYearValid;

@Getter
public class WeekYear {

  private int week = 0;
  private int year = 0;

  public WeekYear(String weekYear) {

    if (weekYear == null || weekYear.trim().isEmpty()) {
      week = getCurrentWeekNumber();
      year = getCurrentYear();
      return;
    }

    try {
      week = Integer.parseInt(weekYear.substring(0, weekYear.indexOf('.')));
      year = Integer.parseInt(weekYear.substring(weekYear.indexOf('.') + 1));
    }
    catch (Exception ignore) {
      //ignore
    }
    if (!isWeekYearValid(week, year)) {
      week = getCurrentWeekNumber();
      year = getCurrentYear();
    }
  }

  public static WeekYear today() {
    return new WeekYear(null);
  }
}
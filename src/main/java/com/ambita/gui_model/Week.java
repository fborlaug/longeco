package com.ambita.gui_model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Calendar.WEEK_OF_YEAR;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

@Data
@NoArgsConstructor
public class Week {

  private int weekNumber;
  private int year;

  private int previousWeekNumber;
  private int previousYear;

  private int nextWeekNumber;
  private int nextYear;

  private List<Day> days = new ArrayList<>();

  public Week(int weekNumber, int year, List<Day> days) {
    this.weekNumber = weekNumber;
    this.year = year;

    this.calculateNextAndPreviousWeek();

    this.days = new ArrayList<>(days);
  }

  private void calculateNextAndPreviousWeek() {
    Calendar cal = getInstance();
    cal.set(YEAR, this.year);
    cal.set(WEEK_OF_YEAR, this.weekNumber);
    cal.add(WEEK_OF_YEAR, 1);
    this.nextWeekNumber = cal.get(WEEK_OF_YEAR);
    this.nextYear = cal.get(YEAR);

    cal.add(WEEK_OF_YEAR, -2);
    this.previousWeekNumber = cal.get(WEEK_OF_YEAR);
    this.previousYear = cal.get(YEAR);
  }
}
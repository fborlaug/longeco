package com.ambita.gui_model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ambita.gui_model.Day;
import com.ambita.gui_model.Week;

import static java.util.stream.IntStream.range;

public class WeekValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return Week.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    Week week = (Week) target;

    range(0, week.getDays().size())
        .forEach(idx -> {
          Day day = week.getDays().get(idx);
          if (day.getDistance() == null) {
            errors.rejectValue("days[" + idx + "].distance", "distance", "The distance must be an positive integer");
          }

          if (day.getDistance() != null && (day.getDistance() < 0 || day.getDistance() > 999)) {
            errors.rejectValue("days[" + idx + "].distance", "distance", "The distance should be between 0 and 999");
          }
        });
    System.out.println(errors);
  }
}
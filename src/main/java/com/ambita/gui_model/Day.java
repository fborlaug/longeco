package com.ambita.gui_model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Day {

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;
  private Integer distance;
}

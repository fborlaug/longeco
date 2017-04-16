package com.ambita.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReportQuery {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ReportQuery(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<UserDistance> getTotal() {

    return jdbcTemplate.query("select sum(l.distance) as distance, u.name \n" +
        "from log l\n" +
        "left join event e on l.event_id = e.id and e.uid = 'evt-01'\n" +
        "full join \"user\" u on l.user_id  = u.id\n" +
        "group by u.id", (rs, rowNum) -> new UserDistance(rs.getString("name"), rs.getInt("distance"))
    );
  }
}
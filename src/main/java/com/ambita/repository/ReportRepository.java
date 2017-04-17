package com.ambita.repository;

import javax.sql.DataSource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ambita.model.report.UserSum;

@Service
public class ReportRepository {

  private JdbcTemplate jdbcTemplate;
  private String currentEventUid;

  @Autowired
  public void setCurrentEventUid(@Value("${longeco.current.eventuid}") String currentEventUid) {
    this.currentEventUid = currentEventUid;
  }

  @Autowired
  public void setDataSource(@Qualifier("dataSource") DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public List<UserSum> getTotalUserDistances() {
    return jdbcTemplate.query("select sum(l.distance) as distance, u.name " +
        "from log l " +
        "left join event e on l.event_id = e.id and e.uid = '" + currentEventUid + "' " +
        "full join \"user\" u on l.user_id  = u.id " +
        "group by u.id", (rs, rowNum) -> new UserSum(rs.getString("name"), rs.getInt("distance"))
    );
  }

  public List<UserSum> getTotalUserCounts() {
    return jdbcTemplate.query("select count(1) as count, u.name " +
        "from log l " +
        "left join event e on l.event_id = e.id and e.uid = '" + currentEventUid + "' " +
        "full join \"user\" u on l.user_id  = u.id " +
        "group by u.id", (rs, rowNum) -> new UserSum(rs.getString("name"), rs.getInt("count"))
    );
  }
}
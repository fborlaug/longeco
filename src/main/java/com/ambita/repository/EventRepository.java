package com.ambita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ambita.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
  Event findByUid(String uid);
}

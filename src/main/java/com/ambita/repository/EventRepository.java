package com.ambita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambita.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
  Event findByUid(String uid);
}

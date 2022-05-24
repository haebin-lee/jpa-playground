package com.playground.jpa.streamer.repository;

import com.playground.jpa.streamer.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findAllByTitleStartingWith(String title);
}

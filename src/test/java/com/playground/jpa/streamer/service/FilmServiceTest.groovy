package com.playground.jpa.streamer.service

import com.playground.jpa.streamer.entity.Film
import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

import java.util.stream.Collectors

class FilmServiceTest extends Specification {

    @Autowired
    FilmService filmService;

    def "setup"() {

    }

    def "FindAll"() {
        when:
        List<Film> films = filmService.findAll();

        then:
        films.size() == 1000;
        films.get(0).title == 'ACADEMY DINOSAUR';
    }

    def "FindAllStartWithUsingStreamer"() {
        when:
        List<Film> films = filmService.findAllStartWithUsingStreamer("A");

        then:
        films.size() == 46;
    }

    def "FindAllStartWithUsingJavaStream"() {
        when:
        List<Film> films = filmService.findAllStartWithUsingJavaStream("A");

        then:
        films.size() == 46;
    }

    def "FindAllStartWithUsingRepository"() {
        when:
        List<Film> films = filmService.findAllStartWithUsingRepository("A");

        then:
        films.size() == 46;
    }

    def "FindGroupByRatingUsingStreamer"() {
        when:

        Map<String, List<Film>> map = filmService.findGroupByRatingUsingStreamer();
        map.entrySet().forEach({m ->
            System.out.println(m.key + ": " + m.getValue().stream().map({f -> f.getTitle()}).collect(Collectors.toList()));
        })

        then:
        map.size() == 5;
    }
}

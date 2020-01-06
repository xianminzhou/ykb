package com.seecen.dd.xxxsys.dao.mapper;

import com.seecen.dd.xxxsys.dao.domain.Movie;

import java.util.List;


public interface MovieFrontMapper {

    List<Movie> selectFive();

    List<Movie> selectpaixu();
}

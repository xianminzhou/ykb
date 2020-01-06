package com.seecen.dd.xxxsys.service;

import com.github.pagehelper.PageInfo;
import com.seecen.dd.xxxsys.dao.domain.JsonResult;
import com.seecen.dd.xxxsys.dao.domain.Movie;
import org.springframework.stereotype.Component;

@Component
public interface MovieService {
    PageInfo<Movie> findMovieByPage(Integer pageNum, Integer pageSize, Movie movie);

    Movie findMovieId(Integer id);

    Boolean update(Movie movie);

    Boolean delete(Integer id);

    Boolean addMovie(Movie movie);
}

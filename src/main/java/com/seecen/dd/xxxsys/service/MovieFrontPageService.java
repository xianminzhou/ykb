package com.seecen.dd.xxxsys.service;

import com.seecen.dd.xxxsys.dao.domain.*;

import java.util.List;

public interface MovieFrontPageService {
    List<Movie> selectMaxFive();

    List<Category> selectCategoryById(Integer id);

    List<Movie> selectMovieByCId(List<Category> list);

    List<Projection> selectProByMovieId(Integer id);

    List<ProjectionExpand> showFangYing(List<Projection> list);

    List<Movie> selectMovieByCategoryId(Integer id);

    List<Seat> selectSeatByHallId(Integer id);

    Movie selectMovieByPid(Integer id);

    List<Seat> selectBySeatNane(String seatInfo, Integer projectionId);

    List<Cinematicket> addCinematicket(Integer userId, List<Seat> list, Integer projectionId);

    boolean updateSeat(List<Seat> list);

    List<Seat> selectSeatByProjectionId(Integer id);

    List<Integer> selectCidBySeatId(List<Cinematicket> cinematickets);

    List<Product> addProduct(List<Integer> list);

    List<Cinematicket> selectCinematicketByUserId(Integer userId);

    List<Projection> selectProByCid(List<Cinematicket> list);
}

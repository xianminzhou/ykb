package com.seecen.dd.xxxsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seecen.dd.xxxsys.dao.domain.Movie;
import com.seecen.dd.xxxsys.dao.mapper.MovieMapper;
import com.seecen.dd.xxxsys.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public PageInfo<Movie> findMovieByPage(Integer pageNum, Integer pageSize, Movie movie) {
        if (pageNum == null)pageNum=1;
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(Movie.class);
        example.setOrderByClause("movie_id desc");
        if (movie != null) {
            Example.Criteria cri = example.createCriteria();
            if (!StringUtils.isEmpty(movie.getMovieName())) {
                cri.andLike("movieName","%" + movie.getMovieName() + "%");
            }
            if (!StringUtils.isEmpty(movie.getTostar())){
                cri.andLike("tostar","%" + movie.getTostar() + "%");
            }
            if (!StringUtils.isEmpty(movie.getLanguage())){
                cri.andLike("language","%" + movie.getLanguage() + "%");
            }
        }
        List<Movie>list = movieMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public Movie findMovieId(Integer id) {
        return movieMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Movie movie) {
        return movieMapper.updateByPrimaryKeySelective(movie)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return movieMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean addMovie(Movie movie) {
        StringBuffer sb = new StringBuffer(movie.getMovieImg());
        String sb2 = sb.substring(12);
        String sb3 = new String(sb2);
        movie.setMovieImg(sb3);
        return movieMapper.insertSelective(movie)>0;
    }
}

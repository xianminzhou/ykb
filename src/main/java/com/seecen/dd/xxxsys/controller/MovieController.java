package com.seecen.dd.xxxsys.controller;

import com.github.pagehelper.PageInfo;
import com.seecen.dd.xxxsys.dao.domain.JsonResult;
import com.seecen.dd.xxxsys.dao.domain.Movie;
import com.seecen.dd.xxxsys.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("movie/list")
    public String movieList(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum, Movie movie, Model model){
        PageInfo<Movie> pageInfo = movieService.findMovieByPage(pageNum,4,movie);
        model.addAttribute("pageInfo",pageInfo);
        return "movie/member-list";
    }

    @RequestMapping("movie/update/{id}")
    public String movieId(@PathVariable("id") Integer id,Model model){
        model.addAttribute("mo",movieService.findMovieId(id));
        return "movie/member-edit";
    }

    @RequestMapping(value = "movie/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult movieUpdate(Movie movie){
        if (movieService.update(movie)){
            return new JsonResult(200,"修改成功");
        }
        return new JsonResult(500,"修改失败");
    }

    @RequestMapping("movie/delete")
    @ResponseBody
    public JsonResult del(@RequestParam("id") Integer id){
        if (movieService.delete(id)) {
            return new JsonResult(200,"删除成功");
        }
        return new JsonResult(500,"删除失败");
    }
    @RequestMapping("movie/delAll")
    @ResponseBody
    public String delAll(@RequestParam("ids[]")List<Integer>ids){
        for (Integer id : ids) {
            movieService.delete(id);
        }
        return "1";
    }

    @RequestMapping(value = "movie/add",method = RequestMethod.GET)
    public String add(){
        return "movie/member-add";
    }

    @RequestMapping(value = "movie/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult movieAdd(Movie movie){
        if (movieService.addMovie(movie)) {
            return new JsonResult(200,"添加成功");
        }
        return new JsonResult(500,"添加失败");
    }
    @RequestMapping("movie/qwer")
    public String show(){
        return "movie/index2";
    }


    /*电影场次页面*/
    @RequestMapping(value = "/moviceSession", method = RequestMethod.GET)
    public String pay() {
        return "/movie/moviceSession";
    }
}

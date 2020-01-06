package com.seecen.dd.xxxsys.controller;

import com.seecen.dd.xxxsys.dao.domain.*;
import com.seecen.dd.xxxsys.dao.mapper.*;
import com.seecen.dd.xxxsys.service.MovieFrontPageService;
import com.seecen.dd.xxxsys.service.ProductService;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MovieFrontPageController {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private CategoryMapper categoryMapper;


    @Autowired
    private MovieFrontPageService movieFrontPageService;

    @Autowired
    private MovieFrontMapper movieFrontMapper;

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private ProjectionMapper projectionMapper;

    @Autowired
    private HallMapper hallMapper;

    @Autowired
    private ProductService productService;

    @RequestMapping("movie/index")
    public String show(Model model){
        List<Movie> list = movieFrontPageService.selectMaxFive();
        model.addAttribute("list",list);
        List<Category> categoryList = categoryMapper.selectByExample(null);
        model.addAttribute("categoryList",categoryList);
        return "movieFrontPage/index";
    }

    @RequestMapping("movie/bangdan")
    public String showAll(Model model){
        List<Movie> list = movieFrontMapper.selectpaixu();
        model.addAttribute("list",list);
        return "movieFrontPage/bangdan";
    }

    @RequestMapping("movie/xiangqing")
    public String xiangqing(Integer id,Model model){
        Movie movie = movieMapper.selectByPrimaryKey(id);
        model.addAttribute("movie",movie);
        List<Category> list = movieFrontPageService.selectCategoryById(id);
        model.addAttribute("list",list);
        List<Movie> list1 = movieFrontPageService.selectMovieByCId(list);
        model.addAttribute("movies",list1);
        return "movieFrontPage/xiangqing";
    }

    @RequestMapping("movie/fangying")
    public String fangying(Integer id,Model model){
        Movie movie = movieMapper.selectByPrimaryKey(id);
        model.addAttribute("movie",movie);
        List<Category> clist = movieFrontPageService.selectCategoryById(id);
        model.addAttribute("list",clist);
        List<Projection> list = movieFrontPageService.selectProByMovieId(id);
        List<ProjectionExpand> list1 = movieFrontPageService.showFangYing(list);
        model.addAttribute("projections",list1);
        return "movieFrontPage/fangying";
    }

    @RequestMapping("movie/classification")
    public String classification(Integer id,Model model){
        List<Category> categoryList = categoryMapper.selectByExample(null);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("cid",id);
        List<Movie> movies = movieFrontPageService.selectMovieByCategoryId(id);
        model.addAttribute("movies",movies);
        return "movieFrontPage/dianyin";
    }

    @RequestMapping("movie/xuanZuo")
    public String xuanzuo(Model model,Integer id){
        List<Seat> list = movieFrontPageService.selectSeatByProjectionId(id);
        List<Seat> seats = movieFrontPageService.selectSeatByHallId(id);
        for (Seat seat : list) {
            for (Seat seat1 : seats) {
                if (seat.getSeatId() == seat1.getSeatId()){
                    seat1.setSeatState(1);
                }
            }
        }
        model.addAttribute("seats",seats);
        Movie movie = movieFrontPageService.selectMovieByPid(id);
        model.addAttribute("movie",movie);
        Projection projection = projectionMapper.selectByPrimaryKey(id);
        model.addAttribute("projection",projection);
        List<Category> categories = movieFrontPageService.selectCategoryById(movie.getMovieId());
        model.addAttribute("categories",categories);
        Hall hall = hallMapper.selectByPrimaryKey(projection.getHallId());
        model.addAttribute("hall",hall);
        return "movieFrontPage/index2";
    }

    @RequestMapping(value = "movie/yingpiao",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Integer> xuanzuo(String seatInfo, Integer projectionId, HttpSession session, Model model){
        Projection projection = projectionMapper.selectByPrimaryKey(projectionId);
        Yuser yuser = (Yuser) session.getAttribute("yuser");
        Integer userId = yuser.getUserId();
        List<Seat> list = movieFrontPageService.selectBySeatNane(seatInfo,projectionId);
        List<Cinematicket> cinematickets =  movieFrontPageService.addCinematicket(userId,list,projectionId);
        if (cinematickets.size()>0){
            List<Integer> ids = movieFrontPageService.selectCidBySeatId(cinematickets);

            session.setAttribute("abc",ids);
            return new JsonResult(200,"成功");
        }
        return new JsonResult(500,"失败");
    }

    @RequestMapping(value = "/movie/zhifu",method = RequestMethod.GET)
    public String zhifu(HttpSession session, Model model, Map map, HttpServletRequest request){
        List<Integer> list = (List<Integer>) session.getAttribute("abc");
        System.out.println(list.size());
        session.removeAttribute("abc");
        List<Product> list1 = movieFrontPageService.addProduct(list);
        if (list1.size()>0){
            map.put("pList",list1);
            return "aplipay/index";
        }else {
            return "movieFrontPage/index";
        }
    }
    @RequestMapping("/movie/pcenter")
    public String geren(Model model,HttpSession session){
        Yuser yuser = (Yuser) session.getAttribute("yuser");
        model.addAttribute("user",yuser);
        List<Cinematicket> list = movieFrontPageService.selectCinematicketByUserId(yuser.getUserId());
        model.addAttribute("list",list);
        if (list == null){
            return "movieFrontPage/list";
        }
        List<Projection> projections = movieFrontPageService.selectProByCid(list);
        model.addAttribute("projections",projections);
        List<ProjectionExpand> expandList =movieFrontPageService.showFangYing(projections);
        model.addAttribute("expandList",expandList);
        List<Seat> seats = seatMapper.selectByExample(null);
        model.addAttribute("seats",seats);
        return "movieFrontPage/list";
    }
}

package com.seecen.dd.xxxsys.service.impl;

import com.seecen.dd.xxxsys.dao.domain.*;
import com.seecen.dd.xxxsys.dao.mapper.*;
import com.seecen.dd.xxxsys.service.MovieFrontPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
@Service
public class MovieFrontPageServiceImpl implements MovieFrontPageService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieFrontMapper movieFrontMapper;

    @Autowired
    private McategoryMapper mcategoryMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProjectionMapper projectionMapper;

    @Autowired
    private HallMapper hallMapper;

    @Autowired
    private SeatMapper seatMapper;
    
    @Autowired
    private CinematicketMapper cinematicketMapper;

    @Autowired
    private IProductdao iProductdao;

    @Override
    public List<Movie> selectMaxFive() {
        List<Movie> list = movieFrontMapper.selectFive();
        return list;
    }

    @Override
    public List<Category> selectCategoryById(Integer id) {
        List<Mcategory> list = mcategoryMapper.selectByExample(null);
        List<Integer> list1 = new ArrayList<>();
        for (Mcategory mcategory : list) {
            if (mcategory.getMovieId() == id){
                list1.add(mcategory.getCateporyId());
            }
        }
        Example example = new Example(Category.class);
        Example.Criteria cri = example.createCriteria();
        cri.andIn("cateporyId",list1);
        List<Category> list2 = categoryMapper.selectByExample(example);
        return list2;
    }

    @Override
    public List<Movie> selectMovieByCId(List<Category> list) {
        List<Integer> list1 = new ArrayList<>();
        for (Category category : list) {
            list1.add(category.getCateporyId());
        }
        Example example = new Example(Mcategory.class);
        Example.Criteria cri = example.createCriteria();
        cri.andIn("cateporyId",list1);
        List<Mcategory> list2 = mcategoryMapper.selectByExample(example);
        List<Integer> list3 = new ArrayList<>();
        for (Mcategory mcategory : list2) {
            list3.add(mcategory.getMovieId());
        }
        List<Integer> list4 = new ArrayList<>();
        for (Integer integer : list3) {
            if (!list4.contains(integer)){
                list4.add(integer);
            }
        }
        Example example1 = new Example(Movie.class);
        Example.Criteria cri1 = example1.createCriteria();
        cri1.andIn("movieId",list4);
        List<Movie> movies = movieMapper.selectByExample(example1);
        return movies;
    }

    @Override
    public List<Projection> selectProByMovieId(Integer id) {
        Example example = new Example(Projection.class);
        Example.Criteria cri = example.createCriteria();
        cri.andEqualTo("movieId",id);
        List<Projection> list = projectionMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<ProjectionExpand> showFangYing(List<Projection> list) {
        List<ProjectionExpand> expandList = new ArrayList<>();
        List<Hall> hallList = hallMapper.selectByExample(null);
        List<Movie> movieList = movieMapper.selectByExample(null);
        for (Projection projection : list) {
            ProjectionExpand expand = new ProjectionExpand();
            expand.setProjectionId(projection.getProjectionId());
            expand.setProjectionDate(projection.getProjectionDate());
            expand.setTicketprice(projection.getTicketprice());
            expand.setSurplusSeat(projection.getSurplusSeat());
            for (Hall hall : hallList) {
                if (projection.getHallId() == hall.getHallId()){
                    expand.setHallName(hall.getHallName());
                }
            }
            for (Movie movie : movieList) {
                if (projection.getMovieId() == movie.getMovieId()){
                    expand.setMovieName(movie.getMovieName());
                    expand.setLanguage(movie.getLanguage());
                }
            }
            expandList.add(expand);
        }
        return expandList;
    }

    @Override
    public List<Movie> selectMovieByCategoryId(Integer id) {
        Example example = new Example(Mcategory.class);
        Example.Criteria cri = example.createCriteria();
        cri.andEqualTo("cateporyId",id);
        List<Mcategory> list = mcategoryMapper.selectByExample(example);
        List<Integer> list1 = new ArrayList<>();
        for (Mcategory mcategory : list) {
            list1.add(mcategory.getMovieId());
        }
        if (list1.size() ==0){
            return null;
        }
        Example example1 = new Example(Movie.class);
        Example.Criteria criteria = example1.createCriteria();
        criteria.andIn("movieId",list1);
        List<Movie> movies = movieMapper.selectByExample(example1);
        return movies;
    }

    @Override
    public List<Seat> selectSeatByHallId(Integer id) {
        Example example = new Example(Seat.class);
        Example.Criteria cri = example.createCriteria();
        cri.andEqualTo("hallId",id);
        List<Seat> seats = seatMapper.selectByExample(example);
        return seats;
    }

    @Override
    public Movie selectMovieByPid(Integer id) {
        Projection projection = projectionMapper.selectByPrimaryKey(id);
        Movie movie = movieMapper.selectByPrimaryKey(projection.getMovieId());
        return movie;
    }

    @Override
    public List<Seat> selectBySeatNane(String seatInfo, Integer projectionId) {
        Projection projection = projectionMapper.selectByPrimaryKey(projectionId);
        Example example = new Example(Seat.class);
         Example.Criteria cri = example.createCriteria();
         cri.andEqualTo("hallId",projection.getHallId());
         List<Seat> list = seatMapper.selectByExample(example);
        String str[] = seatInfo.split(",");
        List<Seat> seats = new ArrayList<>();
        for (String s : str) {
            for (Seat seat : list) {
                if (s.equals(seat.getSeatName())){
                    seats.add(seat);
                }
            }
        }
        return seats;
    }

    @Override
    public List<Cinematicket> addCinematicket(Integer userId, List<Seat> list, Integer projectionId) {
        Projection projection = projectionMapper.selectByPrimaryKey(projectionId);
        List<Cinematicket> cinematickets = new ArrayList<>();
        for (Seat seat : list) {
            Cinematicket cinematicket = new Cinematicket();
            cinematicket.setUserId(userId);
            cinematicket.setMoney(projection.getTicketprice());
            cinematicket.setProjectionId(projectionId);
            cinematicket.setSeatId(seat.getSeatId());
            cinematickets.add(cinematicket);
        }
        Example example = new Example(Cinematicket.class);
        Example.Criteria cri = example.createCriteria();
        int row =0;
        for (Cinematicket cinematicket : cinematickets) {
            row = cinematicketMapper.insert(cinematicket);
        }
        if (row>0){
            return cinematickets;
        }else {
            return null;
        }
    }

    @Override
    public boolean updateSeat(List<Seat> list) {
        int row =0;
        for (Seat seat : list) {
            row =seatMapper.updateByPrimaryKey(seat);
        }

        return row>0;
    }

    @Override
    public List<Seat> selectSeatByProjectionId(Integer id) {
        Example example = new Example(Cinematicket.class);
        Example.Criteria cri = example.createCriteria();
        cri.andEqualTo("projectionId",id);
        List<Cinematicket> cinematickets = cinematicketMapper.selectByExample(example);
        List<Seat> list = new ArrayList<>();
        for (Cinematicket cinematicket : cinematickets) {
            Seat seat = seatMapper.selectByPrimaryKey(cinematicket.getSeatId());
            list.add(seat);
        }
        return list;
    }

    @Override
    public List<Integer> selectCidBySeatId(List<Cinematicket> cinematickets) {
        List<Integer> list = new ArrayList<>();
        for (Cinematicket cinematicket : cinematickets) {
            list.add(cinematicket.getSeatId());
        }
        Example example = new Example(Cinematicket.class);
        Example.Criteria cri = example.createCriteria();
        cri.andIn("seatId",list);
        List<Cinematicket> list1 = cinematicketMapper.selectByExample(example);
        List<Integer> cids = new ArrayList<>();
        for (Cinematicket cinematicket : list1) {
            cids.add(cinematicket.getCinematicketId());
        }
        return cids;
    }

    @Override
    public List<Product> addProduct(List<Integer> list) {
        List<Product> products = new ArrayList<>();
        List<Cinematicket> cinematickets = new ArrayList<>();
        for (Integer integer : list) {
            Cinematicket cinematicket = cinematicketMapper.selectByPrimaryKey(integer);
            cinematickets.add(cinematicket);
        }
        Product product = new Product();
        Double money = 0.0;
        for (Cinematicket cinematicket : cinematickets) {

            Projection projection = projectionMapper.selectByPrimaryKey(cinematicket.getProjectionId());
            Movie movie = movieMapper.selectByPrimaryKey(projection.getMovieId());
            String productName = movie.getMovieName();
            money  = money+ cinematicket.getMoney();
            product.setName(productName);
            product.setId(Integer.toString(cinematicket.getCinematicketId()));
        }
        product.setPrice(Double.toString(money));
        products.add(product);
        int row = 0;
        for (Product product1 : products) {
            row = iProductdao.Insert(product1);
        }
        if (row>0){
            return products;
        }
        return null;
    }

    @Override
    public List<Cinematicket> selectCinematicketByUserId(Integer userId) {
        Example example = new Example(Cinematicket.class);
        Example.Criteria cri = example.createCriteria();
        cri.andEqualTo("userId",userId);
        List<Cinematicket> list = cinematicketMapper.selectByExample(example);
        if (list.size() == 0){
            return null;
        }
        return list;
    }

    @Override
    public List<Projection> selectProByCid(List<Cinematicket> list) {
        Example example = new Example(Projection.class);
        List<Integer> ids = new ArrayList<>();
        for (Cinematicket cinematicket : list) {
            Integer pid = cinematicket.getProjectionId();
            ids.add(pid);
        }
        Example.Criteria cri = example.createCriteria();
        cri.andIn("projectionId",ids);
        List<Projection> projections = projectionMapper.selectByExample(example);
        return projections;
    }
}

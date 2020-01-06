package com.seecen.dd.xxxsys;




import com.seecen.dd.xxxsys.dao.domain.*;
import com.seecen.dd.xxxsys.dao.mapper.YHotelMapper;
import com.seecen.dd.xxxsys.dao.mapper.ZOrderMapper;
import com.seecen.dd.xxxsys.dao.mapper.ZRoomMapper;
import org.crazycake.shiro.RedisManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSSMSApplicationTests {

	@Autowired
	private YHotelMapper yHotelMapper;

	@Test
	public void test1(){
		Example example = new Example(YHotel.class);
		example.createCriteria().andEqualTo("hotelId",1);
		List<YHotel> hotels = yHotelMapper.selectByExample(example);
		System.out.println(hotels);
	}
	@Autowired
	private ZRoomMapper zRoomMapper;
	@Test
	public void test2(){
		/*ZRoom zRoom = new ZRoom();
		YHotel yHotel = new YHotel();
		yHotel.setHotelName("天");
		zRoom.setYHotel(yHotel);*/
		List<ZRoom> all = zRoomMapper.findAll(null);
		System.out.println(all);
	}
	@Autowired
	private ZOrderMapper zOrderMapper;
	@Test
	public void test3(){
		List<ZOrder> all = zOrderMapper.findOrderAll(null);
		System.out.println(all);
	}
	/*房间添加测试*/
	@Test
	public void test4(){
		ZRoom zRoom = new ZRoom();
		BigDecimal bigDecimal = new BigDecimal(1000);
		//zRoom.setRoomId(19);
		zRoom.setRoomName(1019);
		zRoom.setPrice(bigDecimal);
		zRoom.setRoomtypeId(1);
		int roomAdd = zRoomMapper.roomAdd(zRoom);
		System.out.println(roomAdd);
	}


	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test(){
		redisTemplate.opsForValue().set("17770568622","1111");
	}

	@Test
	public void test6(){

		System.out.println(redisTemplate.opsForValue().get("17770568622"));
	}
	@Test
	public void sum(){
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i%3==0){
				sum = sum-i;
			}else {
				sum = sum+i;
			}
		}
		System.out.println(sum);
	}

}

package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test {

	/**
	 * 测试函数
	 * 
	 * @param args
	 * @throws Exception
	 */
	static MorphiaUtil morphiaUtil;
	public static void main(String[] args) throws Exception {
		morphiaUtil = new MorphiaUtil();
		// test();
		test1();
		test2();

	}

	private static void test2() {
		
		String id = "5a3c834402338018d00ffd21";
		System.out.println(morphiaUtil.getHotelCnt());
		List<Hotel> hotels = morphiaUtil.getHotelList();
		for (int i = 0; i < hotels.size(); i++) {
			System.out.println(hotels.get(i));
		}
		morphiaUtil.update(id);
		System.out.println(morphiaUtil.getHotel(id));
		morphiaUtil.delete(id);
		//morphiaUtil.deleteAll();

	}

	// 增加一条记录
	private static void test1() throws Exception {
		
		Hotel hotel = new Hotel();
		// hotel.setId(ObjectId.get()); // 主键也可以由数据库自动生成
		hotel.setHotelName("自如");
		hotel.setAddress(new Address("国投", 98));
		hotel.setPrice(99);
		hotel.setCreateTime(new Date());
		hotel.setEquipment(Arrays.asList("a", "b", "c"));
		morphiaUtil.add(hotel);
	}

	private static void test() {

		MongoCredential credential = MongoCredential.createCredential("lzy", "admin", "123456".toCharArray()); // 用户名
		ServerAddress addr = new ServerAddress("127.0.0.1", 27017); // IP port
		MongoClient client = new MongoClient(addr, Arrays.asList(credential));
		// 得到数据库
		MongoDatabase mdb = client.getDatabase("admin");
		// 得到Table
		MongoCollection<?> table = mdb.getCollection("msg");
		// 查询所有
		FindIterable<?> fi = table.find();
		// 遍历结果
		for (Object o : fi) {
			System.out.println(o);
		}

	}

}

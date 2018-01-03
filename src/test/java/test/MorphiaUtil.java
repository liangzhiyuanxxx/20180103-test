package test;

import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * CURD的常用函数
 */

public class MorphiaUtil {
	private Datastore ds;		// 数据库
	
	/**
	 * 构造函数
	 */
	public MorphiaUtil() throws Exception {
		MongoCredential credential = MongoCredential.createCredential("lzy", "admin", "123456".toCharArray()); // 用户名 数据库 密码   
        ServerAddress addr = new ServerAddress("127.0.0.1", 27017); //IP port  
        MongoClient  client = new MongoClient(addr,Arrays.asList(credential));  
		Morphia morphia = new Morphia();
		ds = morphia.createDatastore(client, "admin");	// 当数据库带有账号和密码时，使用这个定义
		ds.ensureIndexes();
	}
	
	
	// 增加一条记录(增加记录，一般情况下由mongoDB自动生成主键的值)
	public void add(Hotel hotel) {
		ds.save(hotel);
	}
	
	// 删除一条记录
	public void delete(Hotel hotel) {
		ds.delete(hotel);
	}
	
	// 删除某个表下的所有记录
	public void deleteAll() {
		Query<Hotel> query = ds.createQuery(Hotel.class);		// 建立一个查询器
		ds.delete(query);
	}
	
	// 根据条件删除一条记录
	public void delete(String id) {
		Query<Hotel> query = ds.createQuery(Hotel.class);
		query.field(Mapper.ID_KEY).equal(new ObjectId(id));		// 主键必须由String转为ObjectId
		ds.delete(query);
	}
	
	// 查询记录个数
	public int getHotelCnt() {
		Query<Hotel> query = ds.createQuery(Hotel.class);
		// 如果带条件查询
//		query.field("hotelName").equal("如家酒店");
		return (int) query.countAll();
	}
	
	// 查询结果（明确知道只有一条记录，比如通过主键查询）
	public Hotel getHotel(String id) {
		Query<Hotel> query = ds.createQuery(Hotel.class).retrievedFields(true, "hotelName", "min_price");	// 查询结果中只关注名称和地址
		query.field(Mapper.ID_KEY).equal(new ObjectId(id));		// 主键必须由String转为ObjectId
		return query.get();
	}
	
	// 查询结果 (不明确结果的个数，可以用list返回)
	public List<Hotel> getHotelList() {
		Query<Hotel> query = ds.createQuery(Hotel.class);
		query.field("hotelName").equal("如家酒店");		// 此处是精确查询
//		query.field("hotelName").contains("如家");		// 此处是模糊查询,酒店名称包含'如家' 
		query.field("price").greaterThan(100);			// 查询价格大于100的酒店
		query.field("price").lessThan(500);				// 查询价格小于500的酒店、
		
//		query.and(query.criteria("hotelName").contains("如家"),query.criteria("hotelAddress").contains("建设"));	// 与查询
//		query.or(query.criteria("hotelName").contains("如家"), query.criteria("hotelName").contains("汉庭"));		// 或查询
		
		query.order("min_price");							// 查询结果按价格正序排列
//		query.order("-createTime");						// 查询结果按时间倒序排序
		
		// 分页相关,如果没有offset和limit,则一次性取出所有结果
		query.offset(0);								// 先得到查询结果集,然后从第0个开始取数据
		query.limit(10);								// 先得到查询结果集,一次最多从结果集中获取10个结果
		
		return query.asList();
	}
	
	// 修改记录
	public void update(String id) {
		Query<Hotel> query = ds.createQuery(Hotel.class);
		query.field(Mapper.ID_KEY).equal(new ObjectId(id));		// 确定修改的记录集
		
		UpdateOperations<Hotel> ops = ds.createUpdateOperations(Hotel.class);	// 建立一个修改器
		ops.set("hotelName", "如家酒店（光谷软件园路）");
		
		ds.update(query, ops);
	}
}

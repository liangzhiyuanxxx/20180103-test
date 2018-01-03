package test;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.utils.IndexDirection;

/**
 * 酒店实体类
 */
//morphia向数据库中存入对象时，会默认添加className的问题
@Entity(value="m_hotel",noClassnameStored=true)
public class Hotel {
	@Id
	private ObjectId id;				// 主键
	
	@Indexed(value=IndexDirection.ASC, name="hotelName", unique=true, dropDups=true)
	private String hotelName;			// 酒店名称
	
	@Property("min_price")
	private int price;					// 酒店最低价格
	private Date createTime;			// 实体类创建时间
	private List<String> equipment;
	
	@Embedded
    private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getEquipment() {
		return equipment;
	}
	public void setEquipment(List<String> equipment) {
		this.equipment = equipment;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", hotelName=" + hotelName + ", price=" + price + ", createTime=" + createTime
				+ ", equipment=" + equipment + ", address=" + address + "]";
	}
	
}

package demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order 
{
	private Integer id;
	private String userName;
	private String password;
	private String orderNumber;
	private Date createTime;
	private String level;
	private float price;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public String getLevel() {
		return level;
	}
	public float getPrice() {
		return price;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
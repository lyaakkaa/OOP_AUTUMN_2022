package main;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
* @generated
*/
public class Order implements Serializable, Cloneable {

    private OrderStatus orderStatus;
    private String text;
    private Date date;
    private Employee sender;
    
    public Order() {}
    
    public Order(OrderStatus orderStatus, String text, Date date, Employee sender) {
		this.orderStatus = orderStatus;
		this.text = text;
		this.date = date;
		this.sender = sender;
	}
    
    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}

    //                          Operations                                  
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderStatus);
    }

	@Override
	public String toString() {
		return "Order [orderStatus=" + orderStatus + ", text=" + text + ", date=" + date + ", sender=" + sender + "]";
	}
}
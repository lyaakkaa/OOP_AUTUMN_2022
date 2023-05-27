package main;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Vector;

/**
* @generated
*/
public class TechSupportGuy extends Employee {

	
    private Vector<Order> orders;
////    private Order order;
//    private OrderStatus orderStatus;

    public TechSupportGuy() {}

	public TechSupportGuy(String firstName, String lastName, String email, Integer salary) {
		super(firstName, lastName, email, salary);
		orders = new Vector<Order>();
	}

//	public OrderStatus getOrderStatus() {
//		return orderStatus;
//	}
//	
//	public void setOrderStatus(OrderStatus orderStatus) {
//		this.orderStatus = orderStatus;
//	}

    public Vector<Order> getOrders() {
        return this.orders;
    }
    public void setOrders(Vector<Order> orders) {
        this.orders = orders;
    }
    
//    public Order getOrder() {
//        return this.order;
//    }
//    
//    public void setOrder(Order order) {
//        this.order = order;
//    }
    

    public void acceptOrder(Order order) {
        orders.add(order);
        order.setOrderStatus(OrderStatus.ACCEPTED);
    }
    
    public void updateOrder(OrderStatus status, Order order) {
        order.setOrderStatus(status);
    }
    
    public void clearOrders(){
        orders.clear();
    }

    public int numberOfOrders(){
        return orders.size();
    }
    
    public void addOrder(Order order) {
    	orders.add(order);
    }
     
    public void rejectOrder(Order order) {
    	orders.add(order);
        order.setOrderStatus(OrderStatus.REJECTED);
    }

    public String view0rdersInfo(){
    	Database.load();
        String str = "";
        for(int i = 0; i < orders.size(); i++){
            str += orders.get(i).toString() + "\n"; 
        }
        return str;
    }
    
    public String view0rderByStatus(OrderStatus status){
    	Database.load();
        String str = "";
        if (orders.size() == 0) {
			return "You have 0 orders:(";
		}
        for(Order order: this.orders){
        	if (order.getOrderStatus().equals(status)) {
        		 str += order + "\n"; 
        	}
        }
        return str;
    }
    
    public String showInfo() {
		String s = "";
		s += "\nFull name: " + this.getFirstName() + " " + this.getLastName() + "\nWork Experience: " + this.getWorkExperience()
		 + "\n0rders: " + this.orders;
		return s;
	 }
    
     @Override
    public boolean equals(Object o) {
    	 TechSupportGuy guy= (TechSupportGuy) o;
		 return super.equals(guy) && orders.equals(guy.orders);
	}
     
    @Override
	public int hashCode() {
		 return Objects.hash(orders);
	}

	@Override
	public int compareTo(Object o) {
		 TechSupportGuy t = (TechSupportGuy)o;
		 if (t.getSalary() > this.getSalary()) return -1;
		 if (t.getSalary() < this.getSalary()) return 1;
		 return 0;
	}
    
}
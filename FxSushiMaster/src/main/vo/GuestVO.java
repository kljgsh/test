package main.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GuestVO {
	private StringProperty guestNo;
	private StringProperty tableNo;
	private StringProperty cost;
	
	public GuestVO(){
		this(null,null,null);
	}
	//������
	public GuestVO(String guestNo, String tableNo, String cost) {
		this.guestNo = new SimpleStringProperty(guestNo);
		this.tableNo = new SimpleStringProperty(tableNo);
		this.cost = new SimpleStringProperty(cost);
	}
	
	public String getGuestNo() {
		return guestNo.get();
	}
	public void setGuestNo(String guestNo) {
		this.guestNo.set(guestNo);
	}
	public StringProperty GuestNoProperty() {
		return guestNo;
	}
	//////////////////////////////////////////////
	public String getTableNo() {
		return tableNo.get();
	}
	public void setTableNo(String tableNo) {
		this.tableNo.set(tableNo);
	}
	public StringProperty TableNoProperty() {
		return tableNo;
	}
	//////////////////////////////////////////////
	public String getCost() {
		return cost.get();
	}
	public void setCost(String cost) {
		this.cost.set(cost);
	}
	public StringProperty CostProperty() {
		return cost;
	}
	@Override
	public String toString() {
		return "&�Խ�Ʈ��ȣ:" + guestNo + " ���̺��ȣ:" + tableNo + " �ݾ�:"+cost;
	}
	
}

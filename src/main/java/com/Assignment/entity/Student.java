package com.example.Assignment.entity;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {
 @Id 
 	  Integer id = 0;
	  String name;
	  String standard ;
	  Integer attendance ;
	  String gender;
	  String phoneNumber;
	  String parentName ;
	  String remarks ;
	public List<String> toFields(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("name");
		list.add("standard");
		list.add("attendance");
		list.add("gender");
		list.add("phoneNumber");
		list.add("parentName");
		list.add("remarks");
		return list;
	}
	public List<String> toList(){
		ArrayList<String> list = new ArrayList<String>();
		list.add(this.name);
		list.add(this.standard);
		list.add(this.attendance.toString());
		list.add(this.gender);
		list.add(this.phoneNumber);
		list.add(this.parentName);
		list.add(this.remarks);
		return list;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + id + ", name=" + name + ", standard=" + standard  + ", attendance=" + attendance + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", parentName=" + parentName + ", remarks=" + remarks + "]";
	}
	public Integer getStudentId() {
		return id;
	}
	public void setStudentId(Integer studentId) {
		this.id = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	public Integer getAttendance() {
		return attendance;
	}
	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer id, String name, String standard, Integer attendance,
			String gender, String phoneNumber, String parentName, String remarks) {
		super();
		if (id != 0) {
			this.id = id;
		}
		this.name = name;
		this.standard = standard;
		this.attendance = attendance;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.parentName = parentName;
		this.remarks = remarks;
	}
}

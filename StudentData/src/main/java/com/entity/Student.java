package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
@Id
private int roll_number;
private String name;
private int  physics;
private int maths;
private int chemistry;
private int hindi;
private int english;
public int getRoll_number() {
	return roll_number;
}
public void setRoll_number(int roll_number) {
	this.roll_number = roll_number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPhysics() {
	return physics;
}
public void setPhysics(int physics) {
	this.physics = physics;
}
public int getMaths() {
	return maths;
}
public void setMaths(int maths) {
	this.maths = maths;
}
public int getChemistry() {
	return chemistry;
}
public void setChemistry(int chemistry) {
	this.chemistry = chemistry;
}
public int getHindi() {
	return hindi;
}
public void setHindi(int hindi) {
	this.hindi = hindi;
}
public int getEnglish() {
	return english;
}
public void setEnglish(int english) {
	this.english = english;
}
@Override
public String toString() {
	return "Student [roll_number=" + roll_number + ", name=" + name + ", physics=" + physics + ", maths=" + maths
			+ ", chemistry=" + chemistry + ", hindi=" + hindi + ", english=" + english + ", toString()="
			+ super.toString() + "]";
}
public Student(int roll_number, String name, int physics, int maths, int chemistry, int hindi, int english) {
	super();
	this.roll_number = roll_number;
	this.name = name;
	this.physics = physics;
	this.maths = maths;
	this.chemistry = chemistry;
	this.hindi = hindi;
	this.english = english;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}



}

package com.dto;

import java.util.Date;

public class DTO {
	
	int id;
	String name;
	String title;
	String content;
	Date ddate;
	int hit;
	int group;
	int step;
	int indent;
	
	
	public DTO(int id, String name, String title, String content, Date ddate, int hit, int group, int step, int indent) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.ddate = ddate;
		this.hit = hit;
		this.group = group;
		this.step = step;
		this.indent = indent;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getdDate() {
		return ddate;
	}


	public void setdDate(Date ddate) {
		this.ddate = ddate;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public int getGroup() {
		return group;
	}


	public void setGroup(int group) {
		this.group = group;
	}


	public int getStep() {
		return step;
	}


	public void setStep(int step) {
		this.step = step;
	}


	public int getIndent() {
		return indent;
	}


	public void setIndent(int indent) {
		this.indent = indent;
	}
	
	
	
	
	
	

}



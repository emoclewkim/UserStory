package com.apc.userstory.dto;


public class todo implements Comparable<todo> {
	private String task; // 제목 - 인덱스
	private String execDate; // 실행할날짜 - 중복가능
	private String importance; // 중요도 - 중복가능
	private Integer seq; // 순서 - 중복 x
	private String descript; // 설명
	private String status; // 상태
	
	public todo() {
		super();
	}
	
	public todo( String task, String execDate, String importance, Integer seq, String descript, String status) {
		this.task = task;
		this.execDate = execDate;
		this.importance = importance;
		this.seq = seq;
		this.descript = descript;
		this.status = status;
	}
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}	
	public String getExecDate() {
		return execDate;
	}
	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public int compareTo(todo o) {
		int other; // 비교대상자		
		if(o.importance.charAt(0)=='S') other = -1;
		else other = o.importance.charAt(0)-'A';

		int me; // 기준
		if(importance.charAt(0)=='S') me = -1;
		else me = importance.charAt(0)-'A';	
		
		if(other < me) return 1; //
		else if(other > me) return -1;
		else {
			if(o.seq < seq) return 1;
			else return -1;				
		}
	}
	
	@Override
	public String toString() {
		return "task: "+task+" execDate: "+execDate+" importance: "+importance+
			   " seq: "+seq+" secript: "+descript+" status: "+status;
	}
}


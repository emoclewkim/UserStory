package com.apc.userstory.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.apc.userstory.dto.todo;

@Component
public class todoDao {
	
	ArrayList<todo> todoList = new ArrayList<>();
	
	
	// 날짜에 맞는 모든 todo들을  return
	public ArrayList<todo> findAllByDate(String execDate){
		ArrayList<todo> list = new ArrayList<todo>();
		System.out.println("찾기"+ execDate);
		for(todo todoItem : todoList) {
			if(todoItem.getExecDate().equals(execDate)) list.add(todoItem);
		}
		System.out.println("보내는크기: "+list.size());
		System.out.println("크기: "+todoList.size());
		return list;
	}
	
	// todo 신규생성
	public void createToDo(todo ToDo){
		System.out.println("만들기"+ToDo.toString());
		todoList.add(ToDo);
		System.out.println("크기: "+todoList.size());
	}
	
	// 제목으로  특정 todo 변경
	public boolean updateToDo(String task,String execDate, String importance,Integer seq, String descript, String status){
		boolean isUpdate=false;
		
		for(todo todoItem : todoList) {
			if(todoItem.getTask().equals(task) && todoItem.getExecDate().equals(execDate)){
				todoItem.setTask(task);
				todoItem.setImportance(importance);
				todoItem.setSeq(seq);
				todoItem.setDescript(descript);
				todoItem.setStatus(status);
				isUpdate=true;
				System.out.println("변경"+todoItem.toString());
				break;
			}
		}
		
		return isUpdate;
	}
	
	// 제목으로 특정 todo 삭제
	public boolean deleteToDo(String task) {
		boolean isRemove=false;
		
		for(todo todoItem : todoList) {
			if(todoItem.getTask().equals(task)) {
				System.out.println("삭제"+todoItem.toString());
				isRemove = todoList.remove(todoItem);
				break;
			}
		}
		
		return isRemove;
	}
}

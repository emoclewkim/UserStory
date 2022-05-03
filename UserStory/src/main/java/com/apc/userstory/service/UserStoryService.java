package com.apc.userstory.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apc.userstory.dao.todoDao;
import com.apc.userstory.dto.todo;

@Service
public class UserStoryService {
	
	@Autowired
	todoDao tododao; 
	
	
	public ArrayList<todo> findAllByDate(String execDate){
		ArrayList<todo> todoList = tododao.findAllByDate(execDate);
		// 우선순위대로 정렬		
		Collections.sort(todoList);
	
		return todoList;
	}

	
	public todo createToDo(String task, String execDate, String descript) {
		ArrayList<todo> todoList = tododao.findAllByDate(execDate);
		
		String inputImportance;
		Integer inputSeq;
		
		if(todoList.size()==0) {
			inputImportance ="B";
			inputSeq=0;
		}
		else {
			inputImportance = todoList.get(todoList.size()-1).getImportance();
			inputSeq = todoList.get(todoList.size()-1).getSeq() + 1;
		}
		
		todo ToDo= new todo(task,execDate,inputImportance,inputSeq,descript,"진행중");	
		tododao.createToDo(ToDo);
		
		return ToDo;		
	}

	
	public String updateToDo(String task,String execDate, String importance, Integer seq, String descript, String status) {
		String msg;
		ArrayList<todo> todoList = tododao.findAllByDate(execDate);
		
		for(todo todoItem : todoList) {
			if(todoItem.getImportance().equals(importance) && todoItem.getSeq().equals(seq)) {
				msg ="동일 날짜, 동일 중요도 내에서 중복될 수 없습니다.";
				return msg;
			}
		}
		
		if( tododao.updateToDo(task,execDate,importance,seq,descript,status)) msg="변경되었습니다.";
		else msg="해당 todo는 존재하지 않습니다.";
		
		return msg;
	}

	
	public String deleteToDo(String task) {
		String msg;
		if(tododao.deleteToDo(task)) {
			msg = "["+task+"]가 삭제되었습니다.";
		}else{
			msg = "["+task+"]제목을 가진 todo는 없습니다."; 
		}
		
		return msg;
	}

}

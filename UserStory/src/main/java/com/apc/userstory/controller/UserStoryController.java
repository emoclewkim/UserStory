package com.apc.userstory.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apc.userstory.dao.todoDao;
import com.apc.userstory.dto.todo;
import com.apc.userstory.service.UserStoryService;

@RestController
@RequestMapping("/userStory")
public class UserStoryController {
	
	@Autowired
	private UserStoryService userstoryservice;
	
	@GetMapping("/findAllByDate")
	public ArrayList<todo> findAllByDate(String execDate){		
		return userstoryservice.findAllByDate(execDate);		
	}
	
	@PostMapping("/createToDo")
	public todo createToDo(String task, String execDate, @RequestParam(required = false)String descript) {
		return userstoryservice.createToDo(task, execDate, descript);
	}
	
	@PutMapping("/updateToDo")
	public String updateToDo(String task,String execDate, String importance, Integer seq, String descript, String status) {
		return userstoryservice.updateToDo(task,execDate, importance, seq, descript, status);				
	}
	
	@DeleteMapping("/deleteToDo")
	public String deleteToDo(String task) {
		return userstoryservice.deleteToDo(task);
	}
	
	
	
	
	
}

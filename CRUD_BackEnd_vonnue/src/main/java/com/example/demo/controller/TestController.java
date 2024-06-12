package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CounterService;

@RestController
@RequestMapping("counter")
@CrossOrigin(origins = "http://localhost:3000")
public class TestController {
	
	@Autowired
	public CounterService counterService;
	
	//API for submitting value which will be saved in backend.
	@GetMapping("submit/{submitValue}")
	public List<String> submit(@PathVariable("submitValue") String submitValue) {
		return counterService.submitVal(submitValue);		
	}
	//API for removing  value which is added last to the list.If the list is empty no change. undoed value will be added in stack if list is not empty
	@GetMapping("/undo")
	public  List<String> undo() {
		return counterService.undoVal();
	}
	
	//API to delete the entire list of data.
	@DeleteMapping("/delete")
	public  List<String> deleteData() {
		return counterService.deleteData();
	}
	
	//API to redo the undo.if there is no undo redo will not work.Value is added from stack if the stack is not empty 
	@GetMapping("/redo")
	public  List<String> redo() {
		return counterService.redoVal();
	}
}

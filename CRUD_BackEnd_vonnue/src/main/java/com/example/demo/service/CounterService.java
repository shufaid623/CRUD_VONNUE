package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class CounterService {

	public List<String> submittedValue=new ArrayList<>();
	private int size=-1;
	
	public Stack<String> undoStack=new Stack<>();
	
	
	public List<String> submitVal(String val) {
		this.submittedValue.add(val); //adding value to list
		size++;   //increment the list size
		return submittedValue;
	}
	
	public List<String> undoVal() {
		if(size>=0) {               //check whether there is value to remove
			undoStack.push(this.submittedValue.get(size)); //add the value to stack
			this.submittedValue.remove(this.submittedValue.size()-1);  //remove the value from list
			size--;
		}
		 return submittedValue;
	}
	
	public List<String> deleteData() {
		this.submittedValue=new ArrayList<>();  //delete the entire list of data
		this.size=-1;
		return this.submittedValue;

	}
	
	public List<String> redoVal() {
		if(undoStack.size()>0) {
			this.submittedValue.add(undoStack.pop()); //add to the list from stack if not empty
			size++;
		 }
		return this.submittedValue;
		
	}
}

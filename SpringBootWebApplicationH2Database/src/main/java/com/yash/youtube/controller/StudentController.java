package com.yash.youtube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yash.youtube.dao.Repositary;
import com.yash.youtube.dto.Student;

@Controller
public class StudentController 
{
	@Autowired
	Repositary repo;
	
	@Autowired
	private Environment environment;
	
	
	@RequestMapping(value = "/")
	public String welcomePage()
	{
		String data=environment.getProperty("spring.datasource.url");
		System.out.println("hi.........."+data);
		return "addStudent.jsp";
	}
	@RequestMapping("/addStudent")
	public String addStudent(Student student)
	{
		repo.save(student);
		return "addStudent.jsp";
	}
	@RequestMapping(value = "/students")
	@ResponseBody
	public String fetchStudent()
	{
		
		return repo.findAll().toString();
		//return "fetchStudent.jsp";
	}
	@RequestMapping(value = "/student/{rno}")
	@ResponseBody
	public String findStudent(@PathVariable(value = "rno") int rno1)
	{
		
		return repo.findById(rno1).toString();
		//return "fetchStudent.jsp";
	}
}

package com.yash.youtube.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yash.youtube.dto.Student;

public interface Repositary extends CrudRepository<Student,Integer>{
	
	List<Student> findByTech(String tech);
	
	List<Student> findBySname(String sname);
	
	@Query("from Student where tech=?1 order by sname desc")
	List<Student> findBySnameSorted(String sname);

}

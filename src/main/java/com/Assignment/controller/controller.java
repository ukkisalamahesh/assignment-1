package com.example.Assignment.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment.Service.Servicess;
import com.example.Assignment.entity.Student;

@RestController
@RequestMapping("/api/students")
public class controller {
    @Autowired
    private Servicess studentService;
    @GetMapping("/createDataBase")
    public ResponseEntity<String> createDataBase(){
		return ResponseEntity.ok(studentService.dataBaseCreator());
    }
    
    @PostMapping("/insertStudent")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student){
    	studentService.insertStudentInfo(student);
    	return ResponseEntity.ok(student);
    }
    
    @PostMapping("/updateStudent/{studentId}")
    public ResponseEntity<HashMap<String, String>> updateStudent(@PathVariable Integer studentId,@RequestBody HashMap<String, String> student){
    	return ResponseEntity.ok(studentService.updateStudent(studentId,student));
    }
    @PostMapping("/fetchStudentsByFilter")
    public ResponseEntity<List<HashMap<String, String>>> fetchStudentsByfilter(@RequestParam(value ="page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "5") int size,@RequestBody HashMap<String, String> filters){
    	return ResponseEntity.ok(studentService.fetchStudentsByFilter(page, size, filters));
    }
    
    @GetMapping("/fetchStudents")
    public ResponseEntity<List<HashMap<String, String>>> fetchStudents(@RequestParam(value ="page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "5") int size){
    	return ResponseEntity.ok(studentService.fetchStudents(page, size));
    }

    @GetMapping("/fetchStudent")
    public ResponseEntity<List<HashMap<String, String>>> fetchStudent(@RequestParam(value ="id") Integer student){
    	return ResponseEntity.ok(studentService.fetchStudentInfo(student));
    }
    
    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<HashMap<String, String>> deleteStudentInfo(@PathVariable Integer studentId){
    	return ResponseEntity.ok(studentService.deleteStudent(studentId));
    }
}
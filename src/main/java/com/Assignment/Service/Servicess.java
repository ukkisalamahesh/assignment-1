package com.example.Assignment.Service;
import com.Assignment.DataBaseHandler.DatabaseHandler;
import com.example.Assignment.entity.Student;
import com.example.Assignment.repository.StudentRepo;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class Servicess {
	StudentRepo rr;
	final DatabaseHandler handler = new DatabaseHandler(); //
	final String StudentTable = "students";
	final String MarksheetTable = "";
	public String dataBaseCreator() {
		if(handler.createStudentTable() && handler.createSubjectTable()) {
			System.out.println("Successfully Create");
			return "Successfully Created";
		}else {
			System.out.println("Failed Create");
			return "Failed to Create";
		}
	}
	public Student insertStudentInfo(Student student) {
		try {
			
			handler.insertData(StudentTable, student.toFields(), student.toList());
			System.out.println("Created");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
		public HashMap<String, String> updateStudent(Integer studentId, HashMap<String, String> student) {
		try {
			Student s = new Student();
			handler.updateData(StudentTable,"id", studentId.toString(), student);
			return (handler.fetchData(StudentTable,s.toFields(),"id", studentId.toString(),5,1).get(0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return  null;
	}
		
	public List<HashMap<String, String>> fetchStudents(Integer page, Integer size) {
		List<HashMap<String, String>> student = new ArrayList<>();
		try {
			Student s = new Student();
			return(handler.fetchData(StudentTable,s.toFields(),"","",size,page));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;

	}
	public List<HashMap<String, String>> fetchStudentInfo(Integer id) {
		List<HashMap<String, String>> student = new ArrayList<>();
		try {
			Student s = new Student();
			return(handler.fetchData(StudentTable,s.toFields(),"id", id.toString(),5,1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;

	}
		public List<HashMap<String, String>> fetchStudentsByFilter(Integer page, Integer size, 
				HashMap<String, String> filters) {
		List<HashMap<String, String>> student = new ArrayList<>();
		try {
			Student s = new Student();
			return(handler.fetchDataFilter(StudentTable,s.toFields(),filters,size,page));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;

	}
	
	public HashMap<String, String> deleteStudent(Integer id) {
		try {
			Student student = new Student();
			HashMap<String, String> data = handler.fetchData(StudentTable,student.toFields(),"id", id.toString(),5,1).get(0);
			handler.deleteData(StudentTable, "id" , id.toString());
			return data;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
   
}

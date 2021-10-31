package com.example.LoginRegistration.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.LoginRegistration.model.Student;
import com.example.LoginRegistration.service.StudentService;



@Controller
public class studentController {
	private StudentService studentService;

	public studentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//Handler method to handle list of student and return mode of view
	@GetMapping("/students")
	public String listStudents(Model model)
	{
		model.addAttribute("students", studentService.getAllStudent());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentFrom(Model model)
	{
		Student student = new Student();
		model.addAttribute("students",student);
		return "createstudent";
	}
	@PostMapping("/saveStudent")
	public String SaveStudent(@ModelAttribute("students") Student student,@RequestParam("imgInp") MultipartFile multipartFile) throws IOException
	{
		String imageFileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		student.setImage(imageFileName);
		Student savedStudent =  studentService.saveStudent(student);
		
		String uploadDir = "./img/stuImg/" + savedStudent.getId();
		Path UploadPath = Paths.get(uploadDir);
		if(!Files.exists(UploadPath))
		{
			try {
				Files.createDirectories(UploadPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try(InputStream inputStream = multipartFile.getInputStream() )
		{
			Path filePath=UploadPath.resolve(imageFileName);
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
			System.out.println(filePath.toFile().getAbsolutePath());
		}
		catch(IOException e)
		{
			throw new IOException("Could not save file" + imageFileName);
		}
		
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model)
	{
		model.addAttribute("student",studentService.getStudentById(id));
		return "editStudent";
	}
	
	@PostMapping("/editStudent/{id}")
	public String editStudentForm(@PathVariable Long id, @ModelAttribute("student") Student student  ,Model model)
	{
		Student existingStudent = studentService.getStudentById(id);
		
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		studentService.delectStudentById(id);
		return "redirect:/students";
	}
	
}

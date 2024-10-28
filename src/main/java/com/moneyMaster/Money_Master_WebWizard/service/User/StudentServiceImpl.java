package com.moneyMaster.Money_Master_WebWizard.service.User;

import com.moneyMaster.Money_Master_WebWizard.repository.User.StudentRepository;
import com.moneyMaster.Money_Master_WebWizard.model.User.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    // Constructor injection of the StudentRepository
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {return studentRepository.findAll();}

    @Override
    public Student createStudent(Student student) {
        // Business logic for creating a new student (e.g., saving to the database)
        return studentRepository.save(student);
    }
}

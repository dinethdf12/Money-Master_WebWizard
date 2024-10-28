package com.moneyMaster.Money_Master_WebWizard.service.User;

import com.moneyMaster.Money_Master_WebWizard.model.User.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
}

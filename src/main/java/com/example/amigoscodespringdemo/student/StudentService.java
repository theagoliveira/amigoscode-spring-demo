package com.example.amigoscodespringdemo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("E-mail taken!");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(UUID studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with ID " + studentId + " does not exist.");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(UUID studentId, String name, String email) {
        Optional<Student> optStudent = studentRepository.findById(studentId);
        if (optStudent.isEmpty()) {
            throw new IllegalStateException("Student with ID " + studentId + " does not exist.");
        }

        Student student = optStudent.get();
        if (name != null && !name.isEmpty() && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> optStudentByEmail = studentRepository.findStudentByEmail(email);
            if (optStudentByEmail.isPresent()) {
                throw new IllegalStateException("E-mail taken!");
            }

            student.setEmail(email);
        }
    }

}

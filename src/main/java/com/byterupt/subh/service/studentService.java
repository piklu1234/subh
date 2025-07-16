package com.byterupt.subh.service;

import com.byterupt.subh.model.studentDetails;
import com.byterupt.subh.repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    @Autowired
    private studentRepo repo;

    public List<studentDetails> getAllStudentDetails() {
        return repo.findAll();
    }

    public studentDetails getStudentDetailsById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public studentDetails addStudentDetails(studentDetails student) {
        return repo.save(student);
    }

    public studentDetails updateStudentDetails(Long id, studentDetails updatedStudent) {
        return repo.findById(id)
                .map(student -> {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setMiddleName(updatedStudent.getMiddleName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setUserName(updatedStudent.getUserName());
                    student.setPassword(updatedStudent.getPassword());
                    student.setDob(updatedStudent.getDob());
                    student.setMobile(updatedStudent.getMobile());
                    student.setEmail(updatedStudent.getEmail());
                    return repo.save(student);
                })
                .orElse(null);
    }

    public boolean deleteStudent(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}

//package com.byterupt.subh.controller;
//
//import com.byterupt.subh.model.studentDetails;
//import com.byterupt.subh.service.studentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/studentdetails")
//public class studentController {
//
//    @Autowired
//    private studentService studentService;
//
//    @GetMapping
//    public ResponseEntity<List<studentDetails>> getAllStudentDetails() {
//        return ResponseEntity.ok(studentService.getAllStudentDetails());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<studentDetails> getStudentDetailsById(@PathVariable Long id) {
//        studentDetails student = studentService.getStudentDetailsById(id);
//        return (student != null) ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    public ResponseEntity<studentDetails> addStudent(@RequestBody studentDetails student) {
//        return ResponseEntity.ok(studentService.addStudentDetails(student));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<studentDetails> updateStudent(@PathVariable Long id, @RequestBody studentDetails student) {
//        studentDetails updatedStudent = studentService.updateStudentDetails(id, student);
//        return (updatedStudent != null) ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//        return studentService.deleteStudent(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
//    }
//}
//



// --------- Upadate with Api Response -----------

package com.byterupt.subh.controller;

import com.byterupt.subh.model.studentDetails;
import com.byterupt.subh.response.ApiResponse;
import com.byterupt.subh.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentdetails")
public class studentController {

    @Autowired
    private studentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<studentDetails>>> getAllStudentDetails() {
        List<studentDetails> students = studentService.getAllStudentDetails();
        return ApiResponse.success(students, "Student details retrieved successfully.");
    }

    @GetMapping("/{id}")
    public HttpEntity<? extends ApiResponse<? extends Object>> getStudentDetailsById(@PathVariable Long id) {
        studentDetails student = studentService.getStudentDetailsById(id);
        return (student != null) ? ApiResponse.success(student, "Student found.") : ApiResponse.notFound("Student not found.");
    }

    @PostMapping
    public ResponseEntity<ApiResponse<studentDetails>> addStudent(@RequestBody studentDetails student) {
        studentDetails savedStudent = studentService.addStudentDetails(student);
        return ApiResponse.created(savedStudent, "Student added successfully.");
    }

    @PutMapping("/{id}")
    public HttpEntity<? extends ApiResponse<? extends Object>> updateStudent(@PathVariable Long id, @RequestBody studentDetails student) {
        studentDetails updatedStudent = studentService.updateStudentDetails(id, student);
        return (updatedStudent != null) ? ApiResponse.success(updatedStudent, "Student updated successfully.") : ApiResponse.notFound("Student not found.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id) ? ApiResponse.success(null, "Student deleted successfully.") : ApiResponse.notFound("Student not found.");
    }
}


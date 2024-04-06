package uz.pdp.student.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.student.model.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@RestController
public class StudentController {
    List<Student> studentList=new ArrayList<>(Arrays.asList(
            new Student(1,"Alisher","+998991234567","Java"),
            new Student(2,"Halil",  "+998991234568","HTML"),
            new Student(3,"Ergash", "+998991234569","C++"),
            new Student(4,"Nodir",  "+998991234566","Math"),
            new Student(5,"Nurali", "+998991234565","Python")
    ));

        // All Students
        @RequestMapping(value = "/student",method = RequestMethod.GET)
        public List<Student>getStudentList(){
            return studentList;
        }

        // get byID
        @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
        public Student getStudentById(@PathVariable Integer id){
        for (Student student : studentList) {
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }

        // add new Student
        @RequestMapping(value = "/student",method = RequestMethod.POST)
        public String addStudent(@RequestBody Student student) {
        boolean similar =false;
        for (Student student1 : studentList) {
            if (Objects.equals(student1.getPhoneNumber(), student.getPhoneNumber())) {
                similar = true;
                break;
            }
        }
           if (similar){
               return "please enter another number";
           }else {
               student.setId((studentList.get(studentList.size()-1).getId())+1);
               studentList.add(student);
               return "Student added";
           } }

        //update Student
        @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
        public String editStudent(@PathVariable Integer id, @RequestBody Student student) {
            boolean edited = false;
            for (Student currentStudent : studentList) {
                if (currentStudent.getId() == id) {
                    currentStudent.setName(student.getName());
                    currentStudent.setPhoneNumber(student.getPhoneNumber());
                    currentStudent.setCourseName(student.getCourseName());
                    edited = true;
                    break;
                }
            }
            return edited ? "updated" : "such Student not exist";
        }

        //delete Student
        @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
        public String deleteStudent(@PathVariable Integer id){
            boolean deleted=false;
            for (Student student : studentList) {
                if (student.getId().equals(id)){
                    studentList.remove(student);
                    deleted=true;
                    break;
                }
           }
            return deleted? "Student deleted":"Student not found";
       }
}




package net.suhel.sms.mapper;

import net.suhel.sms.dto.StudentDto;
import net.suhel.sms.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        StudentDto sd= new StudentDto(student.getId(),student.getFirstName(),student.getLastName(), student.getEmail());
        return sd;
    }

    public static Student mapToStudent (StudentDto studentDto){
        Student st1= new Student(studentDto.getId(),studentDto.getFirstName(), studentDto.getLastName(), studentDto.getEmail());
    return st1;
    }
}

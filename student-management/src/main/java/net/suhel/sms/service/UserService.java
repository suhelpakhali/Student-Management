package net.suhel.sms.service;

import net.suhel.sms.dto.StudentDto;

import java.util.List;

public interface UserService {
    List<StudentDto> findAll();

    void saveStudent(StudentDto studentDto);

    StudentDto findById(Long studentId);

    void updateStudent(StudentDto studentDto);

    void deleteById(Long id);
}

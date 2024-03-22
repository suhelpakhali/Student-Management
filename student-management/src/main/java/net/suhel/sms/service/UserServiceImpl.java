package net.suhel.sms.service;

import lombok.AllArgsConstructor;
import net.suhel.sms.dto.StudentDto;
import net.suhel.sms.entity.Student;
import net.suhel.sms.mapper.StudentMapper;
import net.suhel.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    StudentRepository studentRepository;
    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos=students.stream().map((student) -> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void saveStudent(StudentDto studentDto) {
        Student student =StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);

    }

    @Override
    public StudentDto findById(Long studentId) {
        Student student=studentRepository.findById(studentId).get();
        StudentDto studentDto= StudentMapper.mapToStudentDto(student);

        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.mapToStudent(studentDto));


    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}

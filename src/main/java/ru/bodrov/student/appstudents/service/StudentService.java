package ru.bodrov.student.appstudents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bodrov.student.appstudents.entity.Student;
import ru.bodrov.student.appstudents.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findAll(Sort sort) {
        return studentRepository.findAll(sort);
    }

    public List<Student> findAllById(Iterable<String> iterable) {
        return studentRepository.findAllById(iterable);
    }

    public Student getOne(String s) {
        return studentRepository.getOne(s);
    }

   @Transactional
    public <S extends Student> S save(S s) {
        return studentRepository.save(s);
    }

    public boolean existsById(String s) {
        return studentRepository.existsById(s);
    }

    public long count() {
        return studentRepository.count();
    }

    @Transactional
    public void deleteById(String s) {
        studentRepository.deleteById(s);
    }

    @Transactional
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Transactional
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    public <S extends Student> long count(Example<S> example) {
        return studentRepository.count(example);
    }
}

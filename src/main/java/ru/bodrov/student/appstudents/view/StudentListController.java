package ru.bodrov.student.appstudents.view;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bodrov.student.appstudents.entity.Student;
import ru.bodrov.student.appstudents.repository.StudentRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class StudentListController {

    @Autowired
    private StudentRepository studentRepository;

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @PostConstruct
    public void init(){
        students = studentRepository.findAll();
    }

    public String deleteById(String id){
        studentRepository.deleteById(id);
        return "/student-list.xhtml?faces-redirect=true";
    }

    public String save(){
        final Student student = new Student("New Student");
        studentRepository.save(student);
        return "/student-list.xhtml?faces-redirect=true";
    }

    public String refresh(){
        return "/student-list.xhtml?faces-redirect=true" +System.currentTimeMillis();
    }
}

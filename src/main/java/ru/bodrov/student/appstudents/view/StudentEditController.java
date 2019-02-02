package ru.bodrov.student.appstudents.view;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bodrov.student.appstudents.entity.Student;
import ru.bodrov.student.appstudents.repository.StudentRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class StudentEditController {

    @Autowired
    private StudentRepository studentRepository;

    @Nullable
    private String id;

    @NotNull
    private Student student = new Student();

    private Integer selectMark;

    private List<Integer> listMarks;

    public Integer getSelectMark() {
        return selectMark;
    }

    public void setSelectMark(Integer selectMark) {
        this.selectMark = selectMark;
    }

    public List<Integer> getListMarks() {
        return listMarks;
    }

    public void setListMarks(List<Integer> listMarks) {
        this.listMarks = listMarks;
    }

    public void init() {
        @Nullable final Student student = studentRepository.getOne(id);
        if (student != null) this.student = student;
        listMarks = new LinkedList<>();
        for(int i = 0; i<5; i++) listMarks.add(i+1);
    }

    @NotNull
    public String save() {
        student.setMark(selectMark);
        studentRepository.save(student);
        return "/student-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public Student getStudent() {
        return student;
    }

    public void setStudent(@NotNull final Student student) {
        this.student = student;
    }
}

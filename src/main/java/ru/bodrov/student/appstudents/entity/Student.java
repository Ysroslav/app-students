package ru.bodrov.student.appstudents.entity;

import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = Student.TABLE_NAME)
@Entity(name = Student.ENTITY_NAME)
public class Student {

    @NotNull
    public static final String ENTITY_NAME = "student";

    @NotNull
    public static final String TABLE_NAME = "tbl_student";

    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private String id = UUID.randomUUID().toString();

    @Column(name = "name_student", nullable = false)
    private String name;

    @Column(name = "mark", nullable = true)
    private int mark;

    public Student(){}

    public Student(String name){ this.name = name; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Nullable
    public int getMark() {
        return mark;
    }

    public void setMark(@Nullable int mark) {
        this.mark = mark;
    }
}

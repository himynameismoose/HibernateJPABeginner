package com.perscholas.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tit;
    private String salary;
    private String teacherName;

    @ManyToOne
    @JoinColumn(name = "fk_dept")
    private Department department;

    public Teacher() {
    }

    public Teacher(int tit, String salary, String teacherName) {
        this.tit = tit;
        this.salary = salary;
        this.teacherName = teacherName;
    }

    public int getTit() {
        return tit;
    }

    public void setTit(int tit) {
        this.tit = tit;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

package com.perscholas.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tit;
    private String salary;
    private String teacherName;

//    @ManyToOne
//    @JoinColumn(name = "fk_dept")
//    private Department2 department;

    @ManyToMany(targetEntity = Cohort.class)
    private Set<Cohort> cohortSet;

    public Teacher() {
        super();
    }

//    public Teacher(int tit, String salary, String teacherName) {
//        this.tit = tit;
//        this.salary = salary;
//        this.teacherName = teacherName;
//    }

    public Teacher(String salary, String teacherName, Set<Cohort> cohortSet) {
        this.salary = salary;
        this.teacherName = teacherName;
        this.cohortSet = cohortSet;
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

    public Set<Cohort> getCohortSet() {
        return cohortSet;
    }

    public void setCohortSet(Set<Cohort> cohortSet) {
        this.cohortSet = cohortSet;
    }
}

package com.company.test1;

import java.util.Objects;

class Students{
    private String id;
    private String name;
    private double GPA;

    public Students(String id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }

    public Students() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}

public class StudentCollection {
    Students[] students;
    int size;
    int MAX_SIZE=100;

    StudentCollection(){
        students = new Students[MAX_SIZE];
        size = 0;
    }

    void addStudent(Students std){
        for (int i = 0; i < size; i++) {
            if(Objects.equals(students[i].getId(), std.getId())){
                return;
            }
        }

        students[size]=std;
        size++;
    }

    Students searchByName(String name){
        for (int i = 0; i < size; i++) {
            if(students[i].getName().contains(name)){
                return students[i];
            }
        }
        return null;
    }

    int rankStudent(String id){
        Students s = null;
        for (int i = 0; i < size; i++) {
           if(Objects.equals(students[i].getId(), id)){
               s = students[i];
           }
        }

        if(s == null) {
            return -1;
        }

        // find the students who is higher score than the sID student
        // then count the number of times, the rank would be the count plus 1
        int count = 0;
        double thisGPA = s.getGPA();
        double epsilon = 0.000001;
        for (int i = 0; i < size; i++) {
            if (students[i].getGPA() - thisGPA >= epsilon) {
                count++;
            }
        }
        return (count + 1);
    }

    void printAll(){
        for (int i = 0; i < size; i++) {
            System.out.printf("%s %s %.2f\n", students[i].getId(),
                    students[i].getName(), students[i].getGPA());
        }
        System.out.println("--------");
    }

    public static void main(String[] args) {
        StudentCollection col = new StudentCollection();
        col.printAll();

        // add one student
        col.addStudent(new Students("001", "Tom", 9.0));
        col.printAll();

        // add one student
        col.addStudent(new Students("002", "Jerry", 8.0));
        col.printAll();

        // add one duplicated student
        col.addStudent(new Students("002", "Name does not matter", 8.0));
        col.printAll();

        // add one student
        col.addStudent(new Students("003", "Donald", 8.5));

        // search by name, must return student whose name is Donald
        Students s = col.searchByName("a");
        System.out.printf("%s %s %.2f\n", s.getId(), s.getName(), s.getGPA());

        // search by name, must return null
        s = col.searchByName("ABC");
        if (s == null) {
            System.out.println("Null as expected");
        }

        // get rank of Donald, must be 2
        int rank = col.rankStudent("003");
        System.out.println("Rank = " + rank);

        // get rank of "111", must be -1 (No such student)
        rank = col.rankStudent("111");
        System.out.println("Rank = " + rank);

        // Add one student whose score is better than Donald
        col.addStudent(new Students("004", "Mickey", 9.0));

        // Rank of Donald should be 3 now
        rank = col.rankStudent("003");
        System.out.println("Rank = " + rank);
    }
}

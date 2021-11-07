package com.company.test1;

import java.util.Arrays;
import java.util.Objects;

class Person{
    private int age;
    private String id;

    public Person(String id,int age) {
        this.age = age;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

public class PeopleQueue{
    Person[] people;
    int size;
    int MAX_SIZE=100;

    public PeopleQueue() {
        people = new Person[MAX_SIZE];
        size = 0;
    }

    public void joinQueue(Person p){
        int index = size;
        if (p.getAge() < 65){
            people[size] = p;
        }
        else{
            while (index > 0){
                if (people[index -1].getAge() < 65){
                    people[index] = people[index-1];
                    index--;
                }
            }

            people[index] = p;
        }
        size++;
    }

    Person getVaccine(){
        if (size == 0){
            return null;
        }
        if (size - 1 >= 0) System.arraycopy(people, 1, people, 0, size - 1);
        size--;
        return people[0];
    }

    void giveUp(String id) {
        if (size == 0) {
            return;
        }
        int index = 0;
        while(index < size){
            if (Objects.equals(people[index].getId(), id)) {
                break;
            }
            index++;
        }
        if(index==size){
            return;
        }
        for (int i = index; i < size; i++) {
            people[index] = people[index+1];
        }
        size--;
    }

    public static void main(String[] args) {
        PeopleQueue queue = new PeopleQueue();
        // enqueue one person whose age = 20 and another whose age = 70
        // the person whose age = 70 should get vaccine first
        queue.joinQueue(new Person("001", 20));
        queue.joinQueue(new Person("002", 70));
        Person p = queue.getVaccine();
        System.out.printf("%s %d\n", p.getId(), p.getAge());

        // enqueue another person whose age = 50
        // the person whose age = 20 should get vaccine now
        queue.joinQueue(new Person("003", 50));
        p = queue.getVaccine();
        System.out.printf("%s %d\n", p.getId(), p.getAge());

        // enqueue one person whose age = 80 and another whose age = 72
        queue.joinQueue(new Person("004", 80));
        queue.joinQueue(new Person("005", 72));

        // the person whose age = 80 should get vaccine now
        p = queue.getVaccine();
        System.out.printf("%s %d\n", p.getId(), p.getAge());

        // the person whose age = 72 giveUp
        // so, the person whose age = 50 should get vaccine now
        queue.giveUp("005");
        p = queue.getVaccine();
        System.out.printf("%s %d\n", p.getId(), p.getAge());

    }

}

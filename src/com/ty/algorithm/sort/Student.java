package com.ty.algorithm.sort;

/**
 * @author tanyun
 * @description 学生类，具有年龄和姓名两个属性，通过Comparable接口提供比较规则
 * @date 2021/7/9 21:28
 *
 */
public class Student implements Comparable<Student> {

    private int age;
    private String username;

    public Student() {
    }

    public Student(int age, String username) {
        this.age = age;
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        return this.age - o.getAge();
    }
}

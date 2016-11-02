
package com.example.daniel.first_test.entities;


public class UsersPJ {

    private String name;
    private Integer age;
    private Double grade;
    private String password;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The age
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @param age
     * The age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     * @return
     * The grade
     */
    public Double getGrade() {
        return grade;
    }

    /**
     *
     * @param grade
     * The grade
     */
    public void setGrade(Double grade) {
        this.grade = grade;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UsersPJ{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", password='" + password + '\'' +
                '}';
    }
}
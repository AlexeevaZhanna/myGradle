package ru.my.shop.person;

import java.util.Objects;

public class Person {
    private String uname;
    private String lname;
    private String age;
    private String tel;
    private String address;
    private String login;
    private String password;

    public Person(String uname, String lname, String age, String tel, String address, String login, String password) {
        this.uname = uname;
        this.lname = lname;
        this.age = age;
        this.tel = tel;
        this.address = address;
        this.login = login;
        this.password = password;
    }

    public Person(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uname='" + uname + '\'' +
                ", lname='" + lname + '\'' +
                ", age='" + age + '\'' +
                ", tel='" + tel + '\'' +
                ", adress='" + address + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (login != null ? !login.equals(person.login) : person.login != null) return false;
        return Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUname(), getLname(), getAge(), getTel(), getAddress(), getLogin(), getPassword());
    }
}


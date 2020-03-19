package top.seefly.javase.old2017.employee;
/*
 * 该类是Employee用来方便其他类使用，直接继承该类就行了。
 * */

import java.util.Date;
import java.util.GregorianCalendar;

public class Employees {
    protected String name;
    protected double salary;
    protected Date hireDay;

    public Employees() {
        name = null;
        salary = 0;
        hireDay = new Date();
    }

    public Employees(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    public Employees(String name) {
        this.name = name;
        this.salary = 0;
        hireDay = new Date();
    }

    public Employees(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = new GregorianCalendar(year, month - 1, day).getTime();

    }


    public String getName() {
        return this.name;
    }

    public double getSalary() {//两个访问器
        return this.salary;
    }

    public void raisSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return String.format("name:%s,salary:%f", name, salary);
    }
}
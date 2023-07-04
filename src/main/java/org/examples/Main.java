package org.examples;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee1=new Employee(1234567891,"Ahmet","Tan",35);
        Employee employee2=new Employee(1234568891,"Mehmet","Tan",30);
        Employee employee3=new Employee(1234528891,"Mustafa","Ak",21);
        List<Employee> employees=new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        // now we will filter and print the employees who are older than 30 .
        //******************************

        //The first way is by filtering with a for loop and an if condition.
        //classic for structure
        for (int i=0;i<employees.size();i++){
            if (employees.get(i).getAge()>30){
                System.out.println(employees.get(i));
            }
        }
        System.out.println("**************************** \n");
        //with foreach structure
        for (Employee employee:employees){
            if (employee.getAge()>30){
                System.out.println(employee);
            }
        }
        System.out.println("******************** \n");
        //We will now print it to the screen with the stream structure
        employees.stream()
                .filter(employee -> employee.getAge()>30)
                .forEach(System.out::println);

        //With the stream structure, we performed operations on data structures in a simple and understandable way.
        // It is cleaner and easier to read and write than the for structures above.

        //********************************************************************

        //Now, let's find the sum of the ages of the employees whose names start with the letter "M" by using the map and sum functions provided by the stream library.
        //There are two employees whose names start with the letter "M" and their ages add up to 51.
        System.out.println( employees.stream()
                .filter(employee -> employee.getName().startsWith("M"))      //We filtered out employees whose names start with the letter "M"
                .map(employee -> employee.getAge())         //Since we are only interested in the ages of the filtered employees,
                // we have brought the ages in this step, now the stream structure will return only int values at this stage.


                .reduce(0,(sum, age) ->sum+age )); //At this stage, we gave our initial value 0 with the reduce method and we have two values,
                                                            // we added these values, but this process should not be perceived as working for only 2 values,
                                                            // if there were more than 2 values in this structure, it would add to the sum variable.
                                                             //  Here is the method reference state of this structure reduce(0, Integer::sum);
    }
}


class Employee{
    private int identityNumber;
    private String name;
    private String lastName;
    private int age;

    public Employee() {
    }

    public Employee(int identityNumber, String name, String lastName, int age) {
        this.identityNumber = identityNumber;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public int getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(int identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "identityNumber=" + identityNumber +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println();
        System.out.println("=== TEST 2: department findAll ===");
        departmentDao.findAll().forEach(System.out::println);

        System.out.println();
        System.out.println("=== TEST 3: department insert ===");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println();
        System.out.println("=== TEST 4: department update ===");
        department = departmentDao.findById(1);
        department.setName("Laptops");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println();
        System.out.println("=== TEST 5: department delete ===");
        System.out.print("Enter department id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}

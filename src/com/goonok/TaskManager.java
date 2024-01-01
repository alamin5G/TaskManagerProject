package com.goonok;

import com.goonok.service.TaskService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner input = new Scanner(System.in);
        List<String> lists = new ArrayList<String>();


        while(true){
            System.out.println("Task Manager Menu:");
            System.out.println("1. Create New Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Completed Task");
            System.out.println("4. Exit");
            System.out.print("Enter your Choice: ");

            int choice = input.nextInt();
            switch (choice){
                case 1:
                    taskService.addTask();
                    break;
                case 2:
                    taskService.viewTask();
                    break;
                case 3:
                    taskService.completedTask();
                    break;
                case 4:
                    System.out.println("Exiting Task Manager... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice. Please try again!");
            }

        }

    }
}
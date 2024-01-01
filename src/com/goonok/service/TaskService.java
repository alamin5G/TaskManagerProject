package com.goonok.service;

import com.goonok.model.Task;
import com.goonok.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskService {


    List<Task> taskList;
    int id = -1;
    List<Task> completedTask;
    Task task;
    Scanner input;

    private int count=0;

    //initializing with constructor
    public TaskService() {
        taskList    = new ArrayList<>();
        completedTask = new ArrayList<>();

        input       = new Scanner(System.in);
    }

    //adding the task
    public void addTask(){
        input.nextLine();
        System.out.print("Enter Task Title: ");
        String taskTitle = input.nextLine();

        System.out.print("Enter Task Description: ");
        String taskDescription = input.nextLine();
        System.out.print("Enter Due Date: (31-01-2024): ");
        String taskDueDate = input.nextLine();
        String date = String.valueOf(DateUtil.parseDate(taskDueDate));

        //input to the task Model
        task = new Task(taskTitle, taskDescription,date);
        taskList.add(task);
        task.setId(++id); //increase the id using Unary operator automatically for each task
        System.out.println("Task added successfully!");
    }

    //viewing the task
    public void viewTask(){
        if (!taskList.isEmpty()){ //checking there is task exist or not
            printTaskList(taskList); //private method, used same code in 2 places
        }else {
            System.out.print("No task found! Want to create new task? (y/n for yes/no):");
            char c = input.next().charAt(0);
            if (c == 'y'){
                input.nextLine();
                addTask();
            }else {
                System.out.println("Let's back to main page...\n");
            }
        }
        //after viewing the task each time, it will ask for complete a task..
        System.out.print("\nDo you want to mark as complete the task? (y/n): ");
        char c = input.next().charAt(0);

        if(c == 'y'){
            if (!taskList.isEmpty()){ //checking any task created before or not
                ++count; //using for adding and removing taskList item;
                System.out.println("Enter your task id (see left side of title): ");
                int id = input.nextInt();
                completedTask.add(taskList.get(id-count));
                taskList.remove(id-count);
                System.out.println("Task " + id + " marked as completed!");
            }else {
                System.out.println("There are no task available!");
            }
        }


    }
    //completed task
    public void completedTask(){
        if (!completedTask.isEmpty()){
            printTaskList(completedTask);
        }else {
            System.out.println("You did not completed any task yet!");
        }
    }

    private void printTaskList(List<Task> completedTask) {
        for (Task task : completedTask){
            System.out.println((task.getId()+1)+"-Title: " +task.getTitle());
            System.out.println("Description: " +task.getDescription());
            System.out.println("Due Date: " +task.getDueDate());
            System.out.println("\n");
        }
    }

}

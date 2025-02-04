# Task-tracker comand line interface
Task-tacker is a simple comand-line interface aplication written in java for managing tasks. It allows users to create, update, delate, view all tasks and tasks by status. This project leverages Java, Maven and JSON to store tasks in a JSON file.
##Features
-**Add tasks:** Create tasks witch description.
-**Update task:** Modity existing task description.
-**Delete task:** Remove task from the list.
-**Mark a task:** Set a tasks status.
-**List all tasks:** View all tasks from file.
-**List tasks by status:** View tasks with selected status.

## Run app with arguments
-**Add tasks:** Adding a new task
task-cli add "Buy groceries"
 Output: Task added successfully (ID: 1)

-**Update task:**
task-cli update 1 "Buy groceries and cook dinner"
-**Delete task:**
task-cli delete 1

-**Mark a task inprogres:** 
task-cli mark-in-progress 1
-**Mark a task done:** 
task-cli mark-done 1

-**List all tasks:** 
task-cli list

-**List tasks by status:**
task-cli list done
task-cli list todo
task-cli list in-progress

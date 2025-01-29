package org.example;

public class Main {
    public static void main(String[] args) {
        if(args.length<1){
            System.out.println(" ");
        }else{
            String command = args[0];
            switch(command){
                case "add":{
                    if(args.length>2){
                        System.out.println("To many arguments");
                    }else{
                        TaskService.addTask(args[1]);
                        break;
                    }

                }
                case "update":{
                    if(args.length>3){
                        System.out.println("To many arguments");
                    }else if(!Character.isDigit(Integer.parseInt(args[1]))){
                        System.out.println("Secend argument must represented id");
                    }else{
                        TaskService.updateTask(args[1],args[2]);
                        break;
                    }

                }
                case "delete":{
                    if(args.length>3){
                        System.out.println("To many arguments");
                    }else if(!Character.isDigit(Integer.parseInt(args[1]))){
                    TaskService.deleteTask(args[1]);
                    break;
                }
                case "mark-in-progress":{
                    TaskService.mark_in_progressTask(args[1]);
                    break;
                }
                case "mark-done":{
                    TaskService.mark_done(args[1]);
                    break;
                }
                case "list":{
                    TaskService.show_listTask();
                    break;
                }
                case "list":
                    switch (args[2]){
                        case "done":{
                            TaskService.show_DoneTask();
                            break;
                        }
                        case "todo":{
                            TaskService.show_TodoTask();
                            break;
                        }
                        case "in-progress":{
                            TaskService.show_InprogressTask();
                            break;
                        }
                    }
                    break;
            }
        }
    }

}
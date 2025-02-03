package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        if(args.length<1){
            System.out.println(" ");
        }else{
            String command = args[0];
            switch(command){
                case "add":{
                    if(args.length>2){
                        System.out.println("To many arguments");
                    }else{
                        fileManager.saveDataToJsonFile(args[1]);
                        break;
                    }
                }
                case "update":{
                    if(args.length>3){
                        System.out.println("To many arguments");
                    }{
                        fileManager.updateTask(Integer.parseInt(args[1]),args[2]);
                        break;
                    }
                }
                case "delete":{
                    if(args.length>3){
                        System.out.println("To many arguments");
                    }else if(!Character.isDigit(Integer.parseInt(args[1]))) {
                        fileManager.deleteTask(Integer.parseInt(args[1]));
                    }
                    break;
                }
                case "mark-in-progress":{
                    if(args.length>3){
                        System.out.println("To many arguments");
                    }else {
                        fileManager.setInProgressStatusTask(Integer.parseInt(args[1]));
                        break;
                    }
                    break;
                }
                case "mark-done":{
                    fileManager.setDoneStatusTask(Integer.parseInt(args[1]));
                    break;
                }
                case "list":{
                    if(!(args.length >=2)) {
                        System.out.println(fileManager.tasks.toString());
                        break;
                    }else{
                        switch (args[1]){
                            case "done":{
                                fileManager.showTasksWithStatusDone();
                                break;
                            }
                            case "todo":{
                                fileManager.showTasksWithStatusToDo();
                                break;
                            }
                            case "in-progress":{
                                fileManager.showTasksWithStatusInProgress();
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileManager  {

    private final String PATH = "jsonFile.json";
    File file = new File(PATH);
    List<Task> tasks =new ArrayList<>();
    public FileManager()throws IOException{
            tasks = loadDataFromJsonFileToTasksList();
    }
    void saveDataToJsonFile(String destination) throws IOException {
        Task task = new Task();
        task.setId(accessibleId(tasks));
        task.setDescription(destination);
        task.setStatus(Status.TODO);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        tasks.add(task);
        Save(tasks);
        System.out.println("Task added successfully (ID: " + task.getId()+")");
    }
    void Save(List<Task> tasks) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
        fileWriter.write(tasks.toString());
        fileWriter.close();
    }
    int accessibleId(List<Task> existingtasks){
        int expectedId = 0;
        Set existingIds = new LinkedHashSet();
        for(Task task: existingtasks){
            existingIds.add(task.getId());
        }
        while(existingIds.contains(expectedId)){
            expectedId++;
        }
        return expectedId;
    }

    List<Task> StringToTaskList(List<String> StringList){
        List<Task> tasksList = new ArrayList<>();
        for(String stringToTask : StringList){
            Map map = new HashMap();
            stringToTask = stringToTask.strip().replaceFirst("\"","").replace("\n","");
            String[] s = stringToTask.replace("[","").replace("]","").replace("{","").strip().split("\", \"");
            for(String p :s){
                String[] s3 = p.split("\":\"");
                map.put(s3[0],s3[1]);
            }
            tasksList.add(new Task(
                    Integer.parseInt(map.get("id").toString()),
                    map.get("description").toString(),
                    Status.valueOf(map.get("status").toString().toUpperCase()),
                    LocalDateTime.parse(map.get("createdAt").toString()),
                    LocalDateTime.parse((String) map.get("updatedAt"))
            ));
        }
        return tasksList;
    }

     List<Task> loadDataFromJsonFileToTasksList() throws FileNotFoundException {
        List tasks = new ArrayList<>();
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                if(line.startsWith("{")){
                    continue;
                }
                if(!line.startsWith("}")){
                    stringBuilder.append(line);
                }else{
                    tasks.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    continue;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        List<Task> tasksList = new ArrayList<Task>();
        tasksList = StringToTaskList(tasks);
        return tasksList;
    }
    void updateTask(int id, String description) throws IOException {
        for(Task task : tasks){
            if(task.getId()==id){
                task.setDescription(description);
            }
        }
        Save(tasks);
    }
    void deleteTask(int id) throws IOException{
        Task tasktoDelete= new Task();
        for (Task task : tasks){
            if(task.getId()==id){
                tasktoDelete = task;
                break;
            }
        }
        tasks.remove(tasktoDelete);
        Save(tasks);
    }
    
    void showTasksWithStatusInProgress()throws IOException{
        tasks.stream().filter(o -> o.getStatus().toString().equals(Status.IN_PROGRESS.toString())).forEach(System.out::println);
    }
    void showTasksWithStatusDone()throws IOException{
        tasks.stream().filter(o -> o.getStatus().toString().equals(Status.DONE.toString())).forEach(System.out::println);
    }
    void showTasksWithStatusToDo()throws IOException{
        tasks.stream().filter(o -> o.getStatus().getValue().equals(Status.TODO.getValue())).forEach(System.out::println);
    }
    void setInProgressStatusTask(int id) throws IOException {
        changeStatus(id,Status.IN_PROGRESS);
    }
    void setDoneStatusTask(int id) throws IOException {
        changeStatus(id,Status.DONE);
    }
    void changeStatus(int id,Status status)throws IOException{
        for(Task tasks : tasks){
            if(tasks.getId()==id){
                tasks.setStatus(status);
            }
        }
        Save(tasks);
    }
}


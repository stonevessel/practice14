import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println("json with gson example");
        serializeSimple();
        deserializeSimple();

    }
    static void deserializeSimple(){
        try (FileReader reader = new FileReader("data.json")){
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(reader);
            Gson gson = new Gson();
            ArrayList<Todos> yeah= gson.fromJson(jsonElement,ArrayList.class);
            System.out.println(yeah);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void serializeSimple(){
        Todos losdais = new Todos("walk the dog",false,0,3,"dog");
        Todos losmanas = new Todos("Pay the bills",false, 1, 1, "bills");
        ArrayList<Todos> todosList = new ArrayList<>();
        todosList.add(losdais);
        todosList.add(losmanas);


        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("data.json")){
            gson.toJson(todosList,writer);
        } catch (IOException e) {e.printStackTrace();}


    }




}

class Todos{
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public Todos(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "body='" + body + '\'' +
                ", done=" + done +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}
class Simple {
    private String name;
    private String Email;
    private int age;
    private boolean isDeveloper;

    public Simple(String name, String email, int age, boolean isDeveloper) {
        this.name = name;
        Email = email;
        this.age = age;
        this.isDeveloper = isDeveloper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDeveloper() {
        return isDeveloper;
    }

    public void setDeveloper(boolean developer) {
        isDeveloper = developer;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "name='" + name + '\'' +
                ", Email='" + Email + '\'' +
                ", age=" + age +
                ", isDeveloper=" + isDeveloper +
                '}';
    }

}
import java.io.*;

public class Gorilla implements Serializable {
    private static final long seriaLVersionUID = 1L;
    private String name;
    private int age;
    private Boolean friendly;
    private transient String favoriteFood;

    public Gorilla(String name, int age, Boolean friendly) {
        this.name = name;
        this.age = age;
        this.friendly = friendly;
    }

    // Constructors/Getters/Setters/toString() omitted


    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friendly=" + friendly +
                ']';
    }
}

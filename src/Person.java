@ClassAnnotation(comment = "For example")
public class Person {
    String name = "No name";
    int id = -1;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
    @MyAnnotation(comment = "comment", innerId = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

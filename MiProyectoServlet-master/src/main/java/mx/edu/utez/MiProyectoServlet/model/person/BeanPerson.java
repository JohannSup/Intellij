package mx.edu.utez.MiProyectoServlet.model.person;

public class BeanPerson {
    private long id;
    private String name;
    private String lastname;
    private String email;
    private int age;
    private String phone;


    public BeanPerson() {
    }

    public BeanPerson(long id, String name, String lastname, String email, int age, String phone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

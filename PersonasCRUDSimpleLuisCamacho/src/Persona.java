public class Persona {

    private int id;
    private String name;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Persona() {
    }

    public Persona(String name, int id) {
        this.name = name;
        this.id = id;
        this.isActive = true;
    }
}

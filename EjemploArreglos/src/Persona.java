public class Persona {

    private int id;
    private String name;
    private boolean isActive;

    public Persona() {
    }

    public Persona(int id, String name) {
        this.id = id;
        this.name = name;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public boolean getisActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", isActive=").append(isActive);
        sb.append('}');
        return sb.toString();
    }
}

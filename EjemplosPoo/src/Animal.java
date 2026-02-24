public class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void comer(){
        System.out.println(nombre + "está comiendo.");
    }

    public void hacerSonido(){
        System.out.println(nombre + "está haciendo sonido.");
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

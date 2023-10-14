package ListadoPersonas;

public class Persona {
    String Nombre;
    String Apellido;
    String Telefono;
    String Direccion;

    public Persona(String nombre, String apellido, String telefono, String direccion) {
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Direccion='" + Direccion + '\'' +
                '}';
    }
}

package ListadoPersonas;

import java.util.Vector;

public class ListaPersonas {
    Vector listaPersonas;   //Atributo

    public ListaPersonas(){
        listaPersonas=new Vector();     //Constructor

    }
    public void añadirPersonas(Persona p){
        listaPersonas.add(p);

    }
    public void eliminarPersona(int i){
        listaPersonas.removeElementAt(i);

    }
    public void borrarLista(){
        listaPersonas.removeAllElements();

    }
    public int buscarNombre(String Nombre){
        int ResultdadoNom;
        ResultdadoNom=listaPersonas.indexOf(Nombre);
        return ResultdadoNom;
    }
    public int buscarApellido(String Apellido){
        int ResultaApellid;
        ResultaApellid=listaPersonas.indexOf(Apellido);
        return ResultaApellid;
    }


}

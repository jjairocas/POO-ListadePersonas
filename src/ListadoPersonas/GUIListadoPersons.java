package ListadoPersonas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIListadoPersons extends JFrame{
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JButton btnañadir;
    private JList listaNombres;
    private DefaultListModel listadespliegaUI = new DefaultListModel<>();
    private JButton btneliminar;
    private JButton btnborrarLista;
    private JPanel MainPanel;
    private JButton salirButton;

    public GUIListadoPersons() {
        setContentPane(MainPanel);
        setTitle("Lista de Personas");     //Titulo Ventana
        setSize(350, 350);      //Tamaño ventana
        setLocationRelativeTo(null);        //La ventana se posiciona en el centro
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    //El boton cerrar cierra la ventana
        //setResizable(false);                //La ventana no se puede cambiar de tamaño
        //setVisible(true); Se visualiza la ventana en la parte superior izquierda

        ListaPersonas lista=new ListaPersonas();


        btnañadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Persona p=new Persona(txtNombre.getText(),txtApellido.getText(),txtTelefono.getText(),txtDireccion.getText());
                String NombreVerifica=txtNombre.getText();
                String ApellidoVerifica=txtApellido.getText();
                int indiceBusquedaNombre=lista.buscarNombre(NombreVerifica);
                int indiceBusquedaApellido=lista.buscarApellido(ApellidoVerifica);

                if((indiceBusquedaNombre <= -1 ) && (indiceBusquedaApellido <= -1)) {
                    lista.añadirPersonas(p);

                    /**
                     *Método para agregar elementos a la interfaz grafica Jlist utilizando un vector donde se almacenan los datos
                     *llamado listadespliegaUI*
                     */
                    String leyenda = txtNombre.getText() + " " + txtApellido.getText() + " " + txtTelefono.getText() + " " + txtDireccion.getText();
                    listadespliegaUI.addElement(leyenda);
                    listaNombres.setModel(listadespliegaUI);

                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtDireccion.setText("");
                    txtTelefono.setText("");

                }
                else{
                    JOptionPane.showMessageDialog(null, "Esa persona ya fué ingresada", "Error de ingreso",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btneliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice=listaNombres.getSelectedIndex();
                if (indice >=0){
                listadespliegaUI.removeElementAt(indice);
                lista.eliminarPersona(indice);
                }
                else {
                JOptionPane.showMessageDialog(null, "Seleccionar un elemento de la lista de nombres", "Error de selección",
                    JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnborrarLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.borrarLista();
                listadespliegaUI.clear();

            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


}
package view;

import controller.ClientController;
import model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class ClientView {
    private JFrame frame;
    private JTextField idField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField direccionField;
    private JTextField dniField;
    private JTextField fechaField;
    private ClientController clientController;

    public ClientView(ClientController clientController) {
        this.clientController = clientController;

        frame = new JFrame("Gestión de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(7, 2)); 

        
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(10); 
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(10);
        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoField = new JTextField(10);
        JLabel direccionLabel = new JLabel("Dirección:");
        direccionField = new JTextField(10);
        JLabel dniLabel = new JLabel("DNI:");
        dniField = new JTextField(10);
        JLabel fechaLabel = new JLabel("Fecha (yyyy-mm-dd):");
        fechaField = new JTextField(10);

        
        frame.add(idLabel);
        frame.add(idField);
        frame.add(nombreLabel);
        frame.add(nombreField);
        frame.add(apellidoLabel);
        frame.add(apellidoField);
        frame.add(direccionLabel);
        frame.add(direccionField);
        frame.add(dniLabel);
        frame.add(dniField);
        frame.add(fechaLabel);
        frame.add(fechaField);

        JButton addButton = new JButton("Agregar Cliente");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String nombre = nombreField.getText();
                    String apellido = apellidoField.getText();
                    String direccion = direccionField.getText();
                    int dni = Integer.parseInt(dniField.getText());
                    Date fecha = Date.valueOf(fechaField.getText());
                    Client client = new Client(id, nombre, apellido, direccion, dni, fecha);
                    clientController.addClient(client);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    
                } catch (IllegalArgumentException ex) {
                    ex.printStackTrace();
                    
                }
            }
        });

        frame.add(addButton); 
    }

    public void show() {
        frame.pack();
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static java.lang.Class.forName;
public class productos_crud extends JFrame {
    private JTextField textnombre;
    private JTextField textdescripcion;
    private JTextField textprecio;
    private JTextField textStock;
    private JButton actualizar;
    private JButton eliminar;
    private JButton buscarB;
    private JButton limpiar;
    private JTextField textid;
    private JButton agregar;
    private JPanel mainPanel;
    String id,nombre,descripcion, precio, stock;
    public static void main(String[] args) {
        JFrame frame = new JFrame("productos_crud");
        frame.setContentPane(new productos_crud().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public productos_crud() {
        conectar();
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregar();
            }
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }


    Connection con;
    PreparedStatement pst;
    public void conectar(){
        //BASE DE DATOS CON CUENTA DE USUARIO CREADA
        final String DB_URL="jdbc:mysql://localhost/productos?serverTimezone=UTC";
        final String USERNAME="pame";
        final String PASSWORD="1234";

        try{

            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            System.out.println("conexion exitosa");


        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");
        }

    }
    public void agregar() {

        id = textid.getText();
        nombre = textnombre.getText();
        descripcion = textdescripcion.getText();
        precio = textprecio.getText();
        stock = textStock.getText();

        final String DB_URL = "jdbc:mysql://localhost/productos?serverTimezone=UTC";
        final String USERNAME = "pame";
        final String PASSWORD = "1234";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "insert into registro_prod(nombre,descripcion,precio,stock) values (?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, descripcion);
            pst.setString(3, precio);
            pst.setString(4, stock);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Exitoso");

            stmt.close();
            conn.close();
        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo registrar");

        }
    }

        public void actualizar(){

            id = textid.getText();
            nombre = textnombre.getText();
            descripcion = textdescripcion.getText();
            precio = textprecio.getText();
            stock = textStock.getText();

            final String DB_URL="jdbc:mysql://localhost/productos?serverTimezone=UTC";
            final String USERNAME="pame";
            final String PASSWORD="1234";

            try{
                Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                Statement stmt = conn.createStatement();
                String sql = "update registro_prod set nombre=?,descripcion=?,precio=?,stock=? where id=?";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1,nombre);
                pst.setString(2,descripcion);
                pst.setString(3,precio);
                pst.setString(4,stock);
                pst.setString(5,id);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Registro Exitoso");
                stmt.close();
                conn.close();
            }
            catch (SQLException ex){

                ex.printStackTrace();
                System.out.println("SQL incorrecto");

            }
        }
        public void limpiar(){

            textnombre.setText("");
            textdescripcion.setText("");
            textprecio.setText("");
            textStock.setText("");
            textid.setText("");
        }

    }





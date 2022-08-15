import javax.swing.*;
import java.awt.*;
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

    }
    public productos_crud() {

        setTitle("Bienvenidos");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(1280, 720));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
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
                eliminar();
            }
        });
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });


        buscarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();
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

    public void buscar(){
        String id = "0";
        id = textid.getText();

        final String DB_URL="jdbc:mysql://localhost/productos?serverTimezone=UTC";
        final String USERNAME="pame";
        final String PASSWORD="1234";

        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "select * from registro_prod where id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,id);

            ResultSet rs = pst.executeQuery();

            if(rs.next()==true){
                String nombre,descripcion, precio, stock;
                nombre = rs.getString(2);
                descripcion=rs.getString(3);
                precio = rs.getString(4);
                stock = rs.getString(5);

                textnombre.setText(nombre);
                textdescripcion.setText(descripcion);
                textprecio.setText(precio);
                textStock.setText(stock);
            }
            else{
                //mensaje.setText("No se encontro el producto");
                JOptionPane.showMessageDialog(null,"No se encontro el producto");
            }

            stmt.close();
            conn.close();
        }
        catch (SQLException ex){

            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }

    public void eliminar(){

        final String DB_URL="jdbc:mysql://localhost/productos?serverTimezone=UTC";
        final String USERNAME="pame";
        final String PASSWORD="1234";

        String borrarid = textid.getText();
        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "delete from registro_prod where id=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1,borrarid);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Borrado");
            stmt.close();
            conn.close();
        }
        catch (SQLException ex){

            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }
}






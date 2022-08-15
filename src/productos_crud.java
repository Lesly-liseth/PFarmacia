import javax.swing.*;

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


    public static void main(String[] args) {
        JFrame frame = new JFrame("productos_crud");
        frame.setContentPane(new productos_crud().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


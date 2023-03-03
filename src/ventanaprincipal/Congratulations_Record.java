package ventanaprincipal;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.Dimension;



public class Congratulations_Record extends JFrame {
    private JTextField caja_texto;
    private JButton aceptar;
    private JPanel panel;
    private JLabel felicitacion;
    private JLabel fondo;
    private int alto;
    private int ancho;
 
  
    public Congratulations_Record(){
     
        this.setTitle("Felicidades");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
      
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
      
        alto = (int)d.getHeight();
        ancho = (int)d.getWidth();
      
        colocarPanel();
        colocarDemas();
  }
   
    private void colocarPanel(){
        
        panel = new JPanel();//crea panel
        panel.setBackground(Color.WHITE);//establecer color
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
  
    private void colocarDemas(){
           
        felicitacion=new JLabel();
        felicitacion.setBounds(ancho/4, alto/16, 900, 100);
        felicitacion.setForeground(Color.WHITE);
        felicitacion.setFont(new java.awt.Font("Cambria", 1, 60));
        felicitacion.setText("Felicidades Nuevo Record!!!");
      
        caja_texto = new JTextField();
        caja_texto.setBounds((ancho/16)*6, (alto/16)*6, 300, 90);
        caja_texto.setBackground(Color.WHITE);
        caja_texto.setText("Ingresa tu nombre!");
        caja_texto.setFont(new java.awt.Font("Dialog", 1, 30)); 
        caja_texto.setForeground(Color.LIGHT_GRAY); 
        
        aceptar = new JButton();
        aceptar.setBounds((ancho/16)*6,(alto/16)*8,150,50);
        aceptar.setText("LISTO!");
        aceptar.setFont(new java.awt.Font("DialogInput", 1, 30)); 
        aceptar.setBackground(Color.DARK_GRAY);
        aceptar.setForeground(Color.WHITE);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });    
      
        fondo = new JLabel();
        Image imgF=new ImageIcon("src/imagenes/Fondos/Felicidades.jpg").getImage();
        ImageIcon imagen =new ImageIcon(imgF.getScaledInstance(ancho, alto,Image.SCALE_SMOOTH));
        fondo.setIcon(imagen);
        fondo.setBounds(0, 0, ancho, alto);
        fondo.setVisible(true);
     
        panel.add(felicitacion);
        panel.add(caja_texto);
        panel.add(aceptar);
        panel.add(fondo);
    }   
   
    private void botonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String nombre = caja_texto.getText();
        ComprobadorRecords.PosicionarJugador(nombre ,Puzzle.getDificultad(),Puzzle.getMovimientos());
        new Inicio();
        this.dispose();
    } 
     
    public String getNombre(){
        return caja_texto.getText();
    } 
 }

package ventanaprincipal;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

public class ImagenNivel extends JFrame{//Ventana para seleccionar la imagen que quieres jugar
        private JButton img1;
        private JButton img2;
        private JButton img3;
        private JButton atras;
        private JLabel titulo;
        private JLabel fondo;
        private JPanel panel;
        private String ruta1;
        private String ruta2;
        private String ruta3;
        private int dificultad;
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        private int alto;
        private int ancho;
       
    public ImagenNivel(String ruta1, String ruta2, String ruta3, int dificultad){
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Seleccion de Imagen");
        this.setVisible(true);
        this.ruta1 = ruta1;
        this.ruta2 = ruta2;
        this.ruta3 = ruta3;
        this.dificultad = dificultad;
        
        alto = (int)d.getHeight();
        ancho = (int)d.getWidth();
       
        panel = new JPanel();
        panel.setLayout(null);
     
       
        titulo= new JLabel(); 
        titulo.setText("Seleciona una Imagen para Comenzar");
        titulo.setBounds(ancho/4,alto/8 ,900,50);
        titulo.setFont(new java.awt.Font("Cambria",Font.BOLD,40));
        titulo.setBackground(Color.BLUE);
        titulo.setForeground(Color.WHITE);
     
     
        img1 = new JButton();
        Image img=new ImageIcon(ruta1).getImage();
        ImageIcon imagen1 =new ImageIcon(img.getScaledInstance(200, 200,Image.SCALE_SMOOTH));
        img1.setIcon(imagen1);
        img1.setBounds((ancho/16)*3,(alto/8)*3, 200 , 200);
        img1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                img1ActionPerformed(evt);
            }
        });
    
             
        img2 = new JButton();
        Image imgn=new ImageIcon(ruta2).getImage();
        ImageIcon imagen2 =new ImageIcon(imgn.getScaledInstance(200, 200,Image.SCALE_SMOOTH));
        img2.setIcon(imagen2);
        img2.setBounds((ancho/16)*7,(alto/8)*3, 200 , 200);
        img2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                img2ActionPerformed(evt);
            }
        });
    
     
         img3 = new JButton();
        Image imag=new ImageIcon(ruta3).getImage();
        ImageIcon imagen3 =new ImageIcon(imag.getScaledInstance(200, 200,Image.SCALE_SMOOTH));
        img3.setIcon(imagen3);
        img3.setBounds((ancho/16)*11,(alto/8)*3, 200 , 200);
        img3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                img3ActionPerformed(evt);
            }
        });
     
     
        atras = new JButton();
        atras.setFont(new java.awt.Font("DialogInput", 1, 20));
        atras.setForeground(Color.DARK_GRAY);
        atras.setBounds(ancho/24, alto/24, 100, 50);
        atras.setText("ATRAS");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });
     
        fondo = new JLabel();
        Image imgF=new ImageIcon("src/imagenes/Fondos/seleccionImagen.jpg").getImage();
        ImageIcon imagen4 =new ImageIcon(imgF.getScaledInstance(ancho, alto,Image.SCALE_SMOOTH));
        fondo.setIcon(imagen4);
        fondo.setBounds(0, 0, ancho, alto);
        fondo.setVisible(true);
     
        
        this.add(panel);
     
        panel.add(titulo);
        panel.add(img1);
        panel.add(img2);
        panel.add(img3);
        panel.add(atras);
        panel.add(fondo);
   }
   
    private void img1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource()==img1){
            new Puzzle(dificultad,ruta1);
            this.dispose();
        }
    } 
    
    private void img2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource()==img2){
            new Puzzle(dificultad,ruta2);
            this.dispose();
        }
    } 
          
    private void img3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource()==img3){
            new Puzzle(dificultad,ruta3);
            this.dispose();
        }
    } 
          
    private void AtrasActionPerformed(java.awt.event.ActionEvent evt){
        if(evt.getSource() == atras){
            new VentanaNiveles();
            this.dispose();
        }
    }
}

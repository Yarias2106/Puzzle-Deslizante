package ventanaprincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaNiveles extends JFrame{
    
    private javax.swing.JButton aceptar;
    private javax.swing.JButton atras;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel titulo;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private JPanel panel;
    private String ruta1;
    private String ruta2;
    private String ruta3;
    private String ruta4;
    private String ruta5;
    private String ruta6;
    private String ruta7;
    private String ruta8;
    private String ruta9;
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    private int ancho;
    private int alto;
    
    public VentanaNiveles() {
        
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        
        alto = (int)d.getHeight();
        ancho = (int)d.getWidth();
        
        ruta1 = "src/imagenes/NivelFacil/BillGates.jpg";
        ruta2 = "src/imagenes/NivelFacil/Mark Zuckerberg.jpg";
        ruta3 = "src/imagenes/NivelFacil/SteveJobs.jpg";
        ruta4 = "src/imagenes/NivelMedio/programacion.jpg";
        ruta5 = "src/imagenes/NivelMedio/python.jpg";
        ruta6 = "src/imagenes/NivelMedio/programacionWeb.jpg";
        ruta7 = "src/imagenes/NivelDificil/Facebook.jpg";
        ruta8 = "src/imagenes/NivelDificil/Google.jpg";
        ruta9 = "src/imagenes/NivelDificil/You Tube.jpg";
        
        colocarPanel();
        initComponents(); 
    }
    
    private void colocarPanel(){
        
        panel = new JPanel();//crea panel
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();//Para escoger solo una opcion
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        aceptar = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRadioButton1.setContentAreaFilled(false);
        jRadioButton1.setFont(new java.awt.Font("Dungeon", 2, 30));
        jRadioButton1.setForeground(Color.DARK_GRAY);
        jRadioButton1.setBounds((ancho/16)*7,alto/4,300,70);
        jRadioButton1.setText("Facil (3x3)");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
       

        jRadioButton2.setContentAreaFilled(false);
        jRadioButton2.setFont(new java.awt.Font("Dungeon", 2, 30)); 
        jRadioButton2.setForeground(Color.DARK_GRAY);
        jRadioButton2.setBounds((ancho/16)*7,(alto/4)+100,300,70);
        jRadioButton2.setText("Intermedio(4x4)");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
      
        jRadioButton3.setContentAreaFilled(false);
        jRadioButton3.setFont(new java.awt.Font("Dungeon", 2, 30));
        jRadioButton3.setForeground(Color.DARK_GRAY);
        jRadioButton3.setBounds((ancho/16)*7, (alto/4)+200,300,70);
        jRadioButton3.setText("Dificil(5x5)");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        aceptar.setText("ACEPTAR");
        aceptar.setFont(new java.awt.Font("DialogInput", 1, 20));
        aceptar.setForeground(Color.DARK_GRAY);
        aceptar.setBounds((ancho/2)+3, (alto/3)*2, 200, 60);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1ActionPerformed(evt);
            }
        });

        atras.setText("ATRAS");
        atras.setFont(new java.awt.Font("DialogInput", 1, 20)); 
        atras.setForeground(Color.DARK_GRAY);
        atras.setBounds((ancho/32)*11,(alto/3)*2,200,60);
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        
        Image img=new ImageIcon("src/imagenes/Fondos/seleccionNiveles.jpg").getImage();
        ImageIcon imagen1 =new ImageIcon(img.getScaledInstance(ancho, alto,Image.SCALE_SMOOTH));
        fondo.setIcon(imagen1);
        fondo.setBounds(0, 0, ancho, alto);
        fondo.setVisible(true);
        
        
        titulo.setText("Selecciona el Nivel");
        titulo.setFont(new java.awt.Font("Cambria" ,Font.BOLD, 34));
        titulo.setBounds(ancho/4, alto/16, 400, 100);
        titulo.setVisible(true);
        
        panel.add(jRadioButton1);
        panel.add(jRadioButton2);
        panel.add(jRadioButton3);
        panel.add(aceptar);
        panel.add(atras);
        panel.add(titulo);
        panel.add(fondo);
            
          
    }
 
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here
    }                                             

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void Boton1ActionPerformed(java.awt.event.ActionEvent evt) { 
        
        if(jRadioButton1.isSelected()){
            new ImagenNivel(ruta1, ruta2, ruta3, 3);
            this.dispose();
        }else if(jRadioButton2.isSelected()){
                new ImagenNivel(ruta4, ruta5, ruta6, 4);
                this.dispose();
        }else if(jRadioButton3.isSelected()){
                new ImagenNivel(ruta7, ruta8, ruta9, 5);
                this.dispose();
        }
    }                                      

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {                                      
        if(evt.getSource() == atras){
            new Inicio();
        }
    }              
}
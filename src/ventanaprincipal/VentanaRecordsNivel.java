package ventanaprincipal;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;

public class VentanaRecordsNivel extends JFrame {
    
    private JPanel panel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel titulo;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JButton Boton1;
    private javax.swing.JButton atras;
     
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    private int alto;
    private int ancho;
    
    
    public VentanaRecordsNivel(){
        this.setTitle("Niveles");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
      
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
      
        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        Boton1 = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
          
         
        jRadioButton1.setContentAreaFilled(false);
        jRadioButton1.setFont(new java.awt.Font("Dungeon", 2, 30)); // NOI18N
        jRadioButton1.setBounds((ancho/16)*7,alto/4,300,70);
        jRadioButton1.setForeground(Color.DARK_GRAY);
        jRadioButton1.setText("Facil (3x3)");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        
        jRadioButton2.setContentAreaFilled(false);
        jRadioButton2.setFont(new java.awt.Font("Dungeon", 2, 30)); // NOI18N
        jRadioButton2.setBounds((ancho/16)*7,(alto/4)+100,300,70);
        jRadioButton2.setForeground(Color.DARK_GRAY);
        jRadioButton2.setText("Intermedio(4x4)");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        
        jRadioButton3.setContentAreaFilled(false);
        jRadioButton3.setFont(new java.awt.Font("Dungeon", 2, 30)); // NOI18N
        jRadioButton3.setForeground(Color.DARK_GRAY);
        jRadioButton3.setBounds((ancho/16)*7, (alto/4)+200,300,70);
        jRadioButton3.setText("Dificil(5x5)");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
       
        
        Boton1.setText("ACEPTAR");
        Boton1.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        Boton1.setForeground(Color.DARK_GRAY);
        Boton1.setBounds((ancho/2)+3,(alto/3)*2,200,60);
        Boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1ActionPerformed(evt);
            }
        });
        
        atras.setText("ATRAS");
        atras.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        atras.setForeground(Color.DARK_GRAY);
        atras.setBounds((ancho/32)*11,(alto/3)*2,200,60);
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });
        
        Image img=new ImageIcon("src/imagenes/Fondos/recordsNivel.jpg").getImage();
        ImageIcon imagen1 =new ImageIcon(img.getScaledInstance(ancho, alto,Image.SCALE_SMOOTH));
        fondo.setIcon(imagen1);
        fondo.setBounds(0, 0, ancho, alto);
        fondo.setVisible(true);
        
        
        titulo.setText("Selecciona el Nivel de los Mejores Jugadores");
        titulo.setFont(new java.awt.Font("Cambria" ,Font.BOLD, 34));
        titulo.setBounds((ancho/32)*9, alto/16, 800, 100);
        titulo.setVisible(true);
        
        
        panel.add(jRadioButton1); 
        panel.add(jRadioButton2); 
        panel.add(jRadioButton3); 
        panel.add(Boton1); 
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
            new VentanaRecord(3);
            this.dispose();
        }else if(jRadioButton2.isSelected()){
                new VentanaRecord(4);
                this.dispose();
        }else if(jRadioButton3.isSelected()){
                new VentanaRecord(5);
                this.dispose();
        }   
    }
       
    private void AtrasActionPerformed(java.awt.event.ActionEvent evt){
        if(evt.getSource() == atras){
            new Inicio();
            this.dispose();
        }
    }
}

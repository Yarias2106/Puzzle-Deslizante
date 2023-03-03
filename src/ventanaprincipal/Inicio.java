    package ventanaprincipal ;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Inicio extends JFrame{//Inicio del juego

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel titulo;
    private JPanel panel;
     
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    private int ancho;
    private int alto;
    
    public Inicio (){
        alto = (int)d.getHeight();
        ancho = (int)d.getWidth();
        
        this.setVisible(true);
        this.setTitle("Inicio");
        this.setExtendedState(MAXIMIZED_BOTH);
        
        colocarPanel();
        initComponents();  
    } 
    
    
    private void colocarPanel(){
        
        panel = new JPanel();//crea panel
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
        
          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(Color.ORANGE);
        jButton1.setFont(new java.awt.Font("DialogInput", 1, 20));
        jButton1.setForeground(Color.DARK_GRAY);
        jButton1.setText("JUGAR"); 
        jButton1.setBounds((ancho/16)*7,(alto/8)*3,200,60);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(Color.GREEN);
        jButton2.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        jButton2.setForeground(Color.DARK_GRAY);
        jButton2.setText("MEJORES JUGADORES");
        jButton2.setBounds((ancho/64)*27,alto/2,260,60);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
       
        
        Image img=new ImageIcon("src/imagenes/Fondos/principal.jpg").getImage();
        ImageIcon imagen1 =new ImageIcon(img.getScaledInstance(ancho, alto,Image.SCALE_SMOOTH));
        fondo.setIcon(imagen1);
        fondo.setBounds(0, 0, ancho, alto);
        fondo.setVisible(true);
        
        
        Image img2=new ImageIcon("src/imagenes/Otros/Titulo.png").getImage();
        ImageIcon imagen2 =new ImageIcon(img2.getScaledInstance(650,150,Image.SCALE_SMOOTH));
        titulo.setIcon(imagen2);
        titulo.setBounds((ancho/32)*9, alto/8, 650, 150);
        titulo.setVisible(true);
        
        panel.add(jButton1);
        panel.add(jButton2);
        panel.add(titulo);
        panel.add(fondo);
        
        
    }                     

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
        
        if(evt.getSource()==jButton1){
            new VentanaNiveles();
            this.dispose();
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {  
        if(evt.getSource()==jButton2){
            new VentanaRecordsNivel();
            this.dispose();
        }
    }     
     
    
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio();
            }
        });     
    }
}
    


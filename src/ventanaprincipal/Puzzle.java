package ventanaprincipal;


import java.awt.Color;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Puzzle extends JFrame {
    
    public static Container contenedor;
    public static Tablero tablero;
    public static Complemento movimientos;
    private static int mover;
    private BufferedImage img;
    protected static JLabel move;
    private static int dificultad;
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    private int ancho, alto;
    
    private JButton atras, reiniciar;
    private String RutaImagen;
     
    
    public Puzzle(int dificultad,String RutaImagen){//Constructor
        
        mover = 0;
        this.setTitle("Puzzle");
        this.dificultad= dificultad;
        this.RutaImagen= RutaImagen;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
       
        contenedor = this.getContentPane();
      
        try {
            img = ImageIO.read(new File(RutaImagen));
        }catch (IOException e) {
            System.out.print("error");
        }
       
        ancho = (int)d.getWidth();
        alto = (int)d.getHeight();
       
        iniciarComponentes(dificultad);
        iniciarMovimientos(0);
     
        this.setVisible(true);
    }
    
    private void iniciarComponentes(int dificultad){//Iniciacion de todo lo que es el juego
         
        tablero = new Tablero(dificultad,img); 
        tablero.setBounds(0,0,740,490);

        movimientos = new Complemento(RutaImagen);//panel que contiene los movimientos 
        movimientos.setBounds(0,ancho/2,ancho/2,alto);
     
       
        atras = new JButton();
        atras.setFont(new java.awt.Font("DialogInput", 1, 20));
        atras.setText("ATRAS");
        atras.setBounds(ancho/4,(alto/4)*3 , 200, 100);
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        
        reiniciar = new JButton();
        reiniciar.setContentAreaFilled(false);
        Image img=new ImageIcon("src/imagenes/Otros/refresh.png").getImage();
        ImageIcon imagen =new ImageIcon(img.getScaledInstance(150, 150,Image.SCALE_SMOOTH));
        reiniciar.setIcon(imagen);
        reiniciar.setBounds(ancho/2, (alto/32)*22, 150, 150);
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        contenedor.add(tablero);
        contenedor.add(movimientos);
        
        movimientos.add(atras);
        movimientos.add(reiniciar);
    }
     
    private void ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource() == atras){
            new VentanaNiveles();
            this.dispose();
        }
        if(evt.getSource() == reiniciar){
            new Puzzle(dificultad,RutaImagen);
            this.dispose();
        }
    }
    
    public static void actualizarMovimientos(){
        mover++;
        move.setText("");
        iniciarMovimientos(mover);
        
    }
    
   public static void iniciarMovimientos(int movimiento){
       
        move=new JLabel();
        move.setBounds(925,310,350,200);
        move.setFont(new java.awt.Font("Dialog", 70, 40)); // NOI18N
        move.setForeground(Color.DARK_GRAY);
        move.setText("Movimientos: " + movimiento );
        
        movimientos.add(move);
   
   }
   
    public static int getDificultad(){
        return dificultad;
    }
   
    public static int getMovimientos(){
        return mover;
    }
    
}

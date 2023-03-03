package ventanaprincipal;


import java.awt.Color;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Complemento extends JPanel{

    private int alto, ancho;
    private  JLabel  imagen;
    private String Ruta;
    
    
    public Complemento(String Ruta){ //Contructor de Complemento
        this.Ruta= Ruta;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
      
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        alto = (int)d.getHeight();
        ancho = (int)d.getWidth();
     
        iniciarComponentes();
    }
     
    private void iniciarComponentes(){ 
        imagen = new JLabel();   //Imagen de ayuda      
        imagen.setBounds((ancho/64)*40, alto/16, 400, 263);
        
        Image img=new ImageIcon(Ruta).getImage();
        ImageIcon img2 =new ImageIcon(img.getScaledInstance(400, 263,Image.SCALE_SMOOTH));
        imagen.setIcon(img2);
        add(imagen);
      
    }
}

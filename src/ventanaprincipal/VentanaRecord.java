
package ventanaprincipal;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class VentanaRecord extends JFrame {
    
    private JLabel LabelNombre;
    private JLabel LabelMovimientos;
    private JLabel Name1;
    private JLabel Move1;
    private JLabel Name2;
    private JLabel Moves2;
    private JLabel Name3;
    private JLabel Moves3;
    private JLabel Name4;
    private JLabel Moves4;
    private JLabel Name5;
    private JLabel Moves5;
    private JPanel panel;
    private int dificultad;
    private JLabel fondo;
    private JLabel titulo;
    private JLabel nombreTop;
    private JLabel movimientosTop;
    
    private JLabel posicion1;
    private JLabel posicion2;
    private JLabel posicion3;
    private JLabel posicion4;
    private JLabel posicion5;
    
    private JButton atras;
    
    
    String[] nombres; 
    String[] moves; 
         
    File ficheroN1 = new File("Datos/NombresFacil.txt");
    File ficheroN2 = new File("Datos/NombresMedio.txt");
    File ficheroN3 = new File("Datos/NombresDificil.txt");
    File ficheroM1 = new File("Datos/MovimientosFacil.txt");
    File ficheroM2 = new File("Datos/MovimientosMedio.txt");
    File ficheroM3 = new File("Datos/MovimientosDificil.txt");
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    private int ancho;
    private int alto;
     
    
    public VentanaRecord(int dificultad){
        
        this.dificultad= dificultad;
        this.setTitle("Top 5");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
              
        alto = (int)d.getHeight();
        ancho = (int)d.getWidth();
      
        colocarPanel();
        colocarDemas();
        colocarTitulos(); 
    }
    
    
    private void colocarPanel(){
        panel = new JPanel();//crea panel
        panel.setBackground(Color.WHITE);//establecer color
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
       
       
    private void colocarDemas(){
  
        Name1= new JLabel();
        Move1= new JLabel();
        Name2= new JLabel();
        Moves2= new JLabel();
        Name3= new JLabel();
        Moves3= new JLabel();
        Name4= new JLabel();
        Moves4= new JLabel();
        Name5= new JLabel();
        Moves5= new JLabel();
        atras = new JButton();
        fondo =  new JLabel();
        titulo = new JLabel();
        nombreTop  = new JLabel();
        movimientosTop = new JLabel();
        posicion1 = new JLabel();
        posicion2 = new JLabel();
        posicion3 = new JLabel();
        posicion4 = new JLabel();
        posicion5 = new JLabel();
        
        if(dificultad==3){//Obtener los jugadores y movimientos segun el nivel
            String linea = null;//Para guardar los datos de forma temporal
            String linea2 = null;//
            if (ficheroN1.exists()) {//Si se ha creado el fichero
                try {
                    Scanner lector = new Scanner(ficheroN1);
                    while(lector.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea=lector.next();
                    }
                    nombres = linea.split(",");
                    
                    Name1.setText(nombres[0]);
                    Name2.setText(nombres[1]);
                    Name3.setText(nombres[2]);
                    Name4.setText(nombres[3]);
                    Name5.setText(nombres[4]);
                
                    Scanner lector2 = new Scanner(ficheroM1);
                    while(lector2.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea2=lector2.next();
                    }
                
                    moves = linea2.split(",");
                    Move1.setText(moves[0]);
                    Moves2.setText(moves[1]);
                    Moves3.setText(moves[2]);
                    Moves4.setText(moves[3]);
                    Moves5.setText(moves[4]);
                
                } catch (FileNotFoundException ex) {
                    System.out.print("No se pudo abrir el archivo!"+ex.getMessage());
                }
            }else{
                System.out.print("No Existe Fichero");
            }
        }
        else if(dificultad==4){
                String linea = null;//Para guardar los datos de forma temporal
                String linea2 = null;//
                if (ficheroN2.exists()) {//Si se ha creado el fichero
                    try {
                        Scanner lector = new Scanner(ficheroN2);
                        while(lector.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                            linea=lector.next();
                        }
                    nombres = linea.split(",");
                    
                    Name1.setText(nombres[0]);
                    Name2.setText(nombres[1]);
                    Name3.setText(nombres[2]);
                    Name4.setText(nombres[3]);
                    Name5.setText(nombres[4]);
                
                    Scanner lector2 = new Scanner(ficheroM2);
                    while(lector2.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea2=lector2.next();
                    }
                
                    moves = linea2.split(",");
                    Move1.setText(moves[0]);
                    Moves2.setText(moves[1]);
                    Moves3.setText(moves[2]);
                    Moves4.setText(moves[3]);
                    Moves5.setText(moves[4]);
           
                } catch (FileNotFoundException ex) {
                    System.out.print("No se pudo abrir el archivo!"+ex.getMessage());
                }
            }else{
                System.out.print("No Existe Fichero");
            }
        }else{
            String linea = null;//Para guardar los datos de forma temporal
            String linea2 = null;//
            if (ficheroN3.exists()) {//Si se ha creado el fichero
                try {
                    Scanner lector = new Scanner(ficheroN3);
                    while(lector.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea=lector.next();
                    }
                    nombres = linea.split(",");
                    Name1.setText(nombres[0]);
                    Name2.setText(nombres[1]);
                    Name3.setText(nombres[2]);
                    Name4.setText(nombres[3]);
                    Name5.setText(nombres[4]);
                
                    Scanner lector2 = new Scanner(ficheroM3);
                    while(lector2.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea2=lector2.next();
                    }
                
                    moves = linea2.split(",");
                    Move1.setText(moves[0]);
                    Moves2.setText(moves[1]);
                    Moves3.setText(moves[2]);
                    Moves4.setText(moves[3]);
                    Moves5.setText(moves[4]);
             
                }catch (FileNotFoundException ex) {
                    System.out.print("No se pudo abrir el archivo!"+ex.getMessage());
                }
            }else{
                System.out.print("No Existe Fichero");
            }
        }
         
        if(dificultad == 3){
            titulo.setText("Top de jugadores Nivel Facil");
        }else{
            if(dificultad == 4){
                titulo.setText("Top de jugadores Nivel Medio");
            }else{
                titulo.setText("Top de jugadores Nivel Dificil");
            }
        }
        
        titulo.setBounds((ancho/64)*19,alto/16 ,900,50);
        titulo.setFont(new java.awt.Font("Cambria",Font.BOLD,40));
        titulo.setForeground(Color.BLACK);

        Name1.setBounds((ancho/128)*47, alto/4, 200, 100);
        Name1.setFont(new java.awt.Font("Calibri", 1, 25));
        Move1.setBounds((ancho/64)*35, alto/4, 100, 100);
        Move1.setFont(new java.awt.Font("Calibri", 1, 25));
        Name2.setBounds((ancho/128)*47, (alto/8)*3, 200, 100);
        Name2.setFont(new java.awt.Font("Calibri", 1, 25));
        Moves2.setBounds((ancho/64)*35, (alto/8)*3, 100, 100);
        Moves2.setFont(new java.awt.Font("Calibri", 1, 25));
        Name3.setBounds((ancho/128)*47, alto/2, 200, 100);
        Name3.setFont(new java.awt.Font("Calibri", 1, 25));
        Moves3.setBounds((ancho/64)*35, alto/2, 100, 100);
        Moves3.setFont(new java.awt.Font("Calibri", 1, 25));
        Name4.setBounds((ancho/128)*47, (alto/8)*5, 200, 100);
        Name4.setFont(new java.awt.Font("Calibri", 1, 25));
        Moves4.setBounds((ancho/64)*35, (alto/8)*5, 100, 100);
        Moves4.setFont(new java.awt.Font("Calibri", 1, 25));
        Name5.setBounds((ancho/128)*47, (alto/4)*3, 200, 100);
        Name5.setFont(new java.awt.Font("Calibri", 1, 25));
        Moves5.setBounds((ancho/64)*35, (alto/4)*3, 100, 100);
        Moves5.setFont(new java.awt.Font("Calibri", 1, 25));


    
        atras.setFont(new java.awt.Font("DialogInput", 1, 20));
        atras.setBackground(Color.BLUE);
        atras.setForeground(Color.WHITE);
        atras.setBounds(0, 0, 100, 50);
        atras.setText("ATRAS");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });        

        Image imgF=new ImageIcon("src/imagenes/Fondos/records.jpg").getImage();
        ImageIcon imagen =new ImageIcon(imgF.getScaledInstance(ancho, alto,Image.SCALE_SMOOTH));
        fondo.setIcon(imagen);
        fondo.setBounds(0, 0, ancho, alto);
        fondo.setVisible(true);
        
        Image img1=new ImageIcon("src/imagenes/Otros/1.png").getImage();
        ImageIcon imagen1 =new ImageIcon(img1.getScaledInstance(50, 50,Image.SCALE_SMOOTH));
        posicion1.setIcon(imagen1);
        posicion1.setBounds(ancho/4, (alto/32)*9, 50, 50);
        posicion1.setVisible(true);
     
        Image img2=new ImageIcon("src/imagenes/Otros/2.png").getImage();
        ImageIcon imagen2 =new ImageIcon(img2.getScaledInstance(50, 50,Image.SCALE_SMOOTH));
        posicion2.setIcon(imagen2);
        posicion2.setBounds(ancho/4, (alto/32)*13, 50, 50);
        posicion2.setVisible(true);
        
        Image img3=new ImageIcon("src/imagenes/Otros/3.png").getImage();
        ImageIcon imagen3 =new ImageIcon(img3.getScaledInstance(50, 50,Image.SCALE_SMOOTH));
        posicion3.setIcon(imagen3);
        posicion3.setBounds(ancho/4, (alto/32)*17, 50, 50);
        posicion3.setVisible(true);
        
        Image img4=new ImageIcon("src/imagenes/Otros/4.png").getImage();
        ImageIcon imagen4 =new ImageIcon(img4.getScaledInstance(50, 50,Image.SCALE_SMOOTH));
        posicion4.setIcon(imagen4);
        posicion4.setBounds(ancho/4, (alto/32)*21, 50, 50);
        posicion4.setVisible(true);
        
        Image img5=new ImageIcon("src/imagenes/Otros/5.png").getImage();
        ImageIcon imagen5 =new ImageIcon(img5.getScaledInstance(50, 50,Image.SCALE_SMOOTH));
        posicion5.setIcon(imagen5);
        posicion5.setBounds(ancho/4, (alto/32)*25, 50, 50);
        posicion5.setVisible(true);
        
        nombreTop.setText("Nombre");
        nombreTop.setBounds((ancho/32)*11,(alto/16)*3 ,200,30);
        nombreTop.setFont(new java.awt.Font("DialogInput",1 ,30));
        
        movimientosTop.setText("Movimientos");
        movimientosTop.setBounds(ancho/2,(alto/16)*3 ,200,30);
        movimientosTop.setFont(new java.awt.Font("DialogInput",1,30));
        
        
        panel.add(atras);
        panel.add(Name1);
        panel.add(Move1);
        panel.add(Name2);
        panel.add(Moves2);
        panel.add(Name3);
        panel.add(Moves3);
        panel.add(Name4);
        panel.add(Moves4);
        panel.add(Name5);
        panel.add(Moves5);
        panel.add(titulo);
        panel.add(nombreTop);
        panel.add(movimientosTop);
        panel.add(posicion1);
        panel.add(posicion2);
        panel.add(posicion3);
        panel.add(posicion4);
        panel.add(posicion5);
        panel.add(fondo);
    }
       
       
    private void colocarTitulos(){
            
        LabelNombre= new JLabel();
        LabelMovimientos= new JLabel();
        
         
        LabelNombre.setText("Jugadores");
        LabelNombre.setBounds(ancho/4, alto/8, 300, 100);
        LabelNombre.setFont(new java.awt.Font("DialogInput", 1, 40));
         
        LabelMovimientos.setText("Movimientos");
        LabelMovimientos.setBounds(ancho/2, alto/8, 300, 100);
        LabelMovimientos.setFont(new java.awt.Font("DialogInput", 1, 45));
        
        panel.add(LabelNombre);
        panel.add(LabelMovimientos);
    }
    
    
    public void ActionPerformed(java.awt.event.ActionEvent evt){
        if(evt.getSource() == atras){
            new VentanaRecordsNivel();
            this.dispose();
        }
    }
}
      
    
    


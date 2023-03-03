package ventanaprincipal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Imagen extends JButton implements ActionListener{
    private final int xSolPos, ySolPos;
    private int xActual,yActual;
    private int dimension;

    public Imagen(int xSolPos, int ySolPos, ImageIcon subImage, int dimension){
        
        this.xSolPos= xSolPos;
        this.ySolPos= ySolPos;
        this.dimension= dimension;
       
        xActual = xSolPos;
        yActual = ySolPos;
       
        this.setIcon(subImage);
        this.setPreferredSize(new Dimension(subImage.getIconWidth(),subImage.getIconHeight()));
        this.addActionListener(this);
    }

  

    public int getxActual() {
        return xActual;
    }
    public void setxActual(int xActual) {
        this.xActual = xActual;
    }
    public int getyActual() {
        return yActual;
    }
    public void setyActual(int yActual) {
        this.yActual = yActual;
    }
    public int getxSolPos(){
        return xSolPos;
    }
    public int getySolPos(){
        return ySolPos; 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Move();
    }
    
    private void Move(){//Ejecuta los movimientos del Puzzle
        Casilla[][] tablero = Tablero.tablero;
      
        try{
            if(tablero[xActual][yActual-1].getImagen()==null){
                Tablero.tablero[xActual][yActual-1].setImagen(this);
                Tablero.tablero[xActual][yActual].setImagen(null);
                yActual--;
                Puzzle.tablero.Remover();
                Puzzle.actualizarMovimientos();
                ComprobarRespuesta();
                return;
            }   
        }catch(ArrayIndexOutOfBoundsException e){
        
        }         
      
        try{
            if(tablero[xActual][yActual+1].getImagen()==null){
                Tablero.tablero[xActual][yActual+1].setImagen(this);
                Tablero.tablero[xActual][yActual].setImagen(null);
                yActual++;
                Puzzle.tablero.Remover();
                Puzzle.actualizarMovimientos();
                ComprobarRespuesta();
                return;
            }   
        }catch(ArrayIndexOutOfBoundsException e){
        
        }
        
        try{
            if(tablero[xActual-1][yActual].getImagen()==null){
                Tablero.tablero[xActual-1][yActual].setImagen(this);
                Tablero.tablero[xActual][yActual].setImagen(null);
                xActual--;
                Puzzle.tablero.Remover();
                Puzzle.actualizarMovimientos();
                ComprobarRespuesta();
                return;
            }   
        }catch(ArrayIndexOutOfBoundsException e){
        
        }
        
        try{
            if(tablero[xActual+1][yActual].getImagen()==null){
                Tablero.tablero[xActual+1][yActual].setImagen(this);
                Tablero.tablero[xActual][yActual].setImagen(null);
                xActual++;
                Puzzle.tablero.Remover();
                Puzzle.actualizarMovimientos();
                ComprobarRespuesta();
                return;
            }   
        }catch(ArrayIndexOutOfBoundsException e){
        
        }     
    }
  
    public void ComprobarRespuesta(){
        Imagen imagen = null;
      
         for(int i = 0; i< dimension; i++){
            for(int j=0; j<dimension;j++){
                imagen = Tablero.tablero[i][j].getImagen();
                if(imagen==null){
                    continue;
                }
                if(imagen.getxActual()!= imagen.getxSolPos() ||
                    imagen.getyActual()!= imagen.getySolPos()){
                    return;
                }
            }   
        }
        boolean record = ComprobadorRecords.Record(Puzzle.getDificultad(),Puzzle.getMovimientos());   
        if(record==true){//Crea la clase solo si hay record
            new Congratulations_Record();
            
            
        }else{
            String[] options = {"Aceptar"};
            int seleccion = JOptionPane.showOptionDialog(null, "¡Lo Completaste sin Record!", "Felicidades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if(seleccion == 0){
                System.exit(0);
            }
        }
    }
}

    
   
   


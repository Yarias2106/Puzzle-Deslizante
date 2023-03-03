package ventanaprincipal;

public class Casilla {
    
    private final int x,y;
    private Imagen imagen;
   
    public Casilla(int x,int y, Imagen imagen){
        this.x=x;
        this.y =y;
        this.imagen = imagen;
    }
 
    public Casilla(int x,int y){// esto es para la casilla vacia
        this.x=x;
        this.y =y;
        imagen = null;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
     
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}

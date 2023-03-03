package ventanaprincipal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ComprobadorRecords {
    
    private int dificultad;
    private int movimientos;
    
    static String []nombres; 
    static String [] stringmoves;
    
    
    static int moves []= new int[6];
    static ArrayList<Integer> moves2;
    static ArrayList<String> nombresAL;
    
    static File ficheroN1 = new File("Datos/NombresFacil.txt");
    static File ficheroN2 = new File("Datos/NombresMedio.txt");
    static File ficheroN3 = new File("Datos/NombresDificil.txt");
    static File ficheroM1 = new File("Datos/MovimientosFacil.txt");
    static File ficheroM2 = new File("Datos/MovimientosMedio.txt");
    static File ficheroM3 = new File("Datos/MovimientosDificil.txt");
    
    
    public ComprobadorRecords(int dificultad,int movimientos){
        
        moves2= new ArrayList<>(); 
        nombresAL= new ArrayList<>();
        this.dificultad=dificultad;
        this.movimientos= movimientos;
    }
   
    public static boolean Record(int dificultad,int movimientos){  //Metodo solo para Comprobar si hay o no un Record
        
        boolean res = false;
     
        if(dificultad==3){
            String linea = null;//Para guardar los datos de forma temporal
            if (ficheroM1.exists()) {//Si se ha creado el fichero
                try {
                    Scanner lector = new Scanner(ficheroM1);
                    while(lector.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea=lector.next();
                    }
                
                    stringmoves = linea.split(",");
            
                    for(int i = 0; i < 5; i++){
                        int a = Integer.parseInt(stringmoves[i]);
                        if(movimientos < a){
                            return true;
                        }
                    }
                } catch (FileNotFoundException ex) {
                    System.out.print("No se pudo abrir el archivo!"+ex.getMessage());
                }
                
            }else{
                System.out.print("Fichero no existe");
            }    
            
            
        }else if(dificultad==4){
                String linea = null;//Para guardar los datos de forma temporal
                if (ficheroM2.exists()) {//Si se ha creado el fichero
                    try {
                        Scanner lector = new Scanner(ficheroM2);
                        while(lector.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                            linea=lector.next();
                    }
                
                        stringmoves = linea.split(",");
            
                        for( int i =0; i < 5;i++){
                            int a = Integer.parseInt(stringmoves[i]);
                            if(movimientos < a){
                                return true;
                            }
                        }
                    } catch (FileNotFoundException ex) {
                        System.out.print("No se pudo abrir el archivo!"+ex.getMessage());
                    }
                }else{
                    System.out.print("te jodiste");
                } 
            
        
        }else{
            String linea = null;//Para guardar los datos de forma temporal
            if (ficheroM3.exists()) {//Si se ha creado el fichero
                try {
                    Scanner lector = new Scanner(ficheroM3);
                    while(lector.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea=lector.next();
                    }
                
                    stringmoves = linea.split(",");
            
                    for( int i =0; i < 5;i++){
                        int a = Integer.parseInt(stringmoves[i]);
                        if(movimientos < a){
                            return true;
                        }
                    }
                }catch (FileNotFoundException ex) {
                    System.out.print("No se pudo abrir el archivo!"+ex.getMessage());
                }
            }else{
                System.out.print("Fichero no existe");
            } 
        }
       
        return res;
    }
   
   
    public static void PosicionarJugador(String nombre,int dificultad, int movimientos){ //Para añadir nuevos Datos a la "base de datos"
        String linea = null;
        String linea2 = null;    //Para guardar los datos de forma temporal
        
        if(dificultad==3){
        
            if (ficheroM1.exists()) {//Si se ha creado el fichero
                try {
                    Scanner lector = new Scanner(ficheroM1);
                    while(lector.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea=lector.next();
                    }
                    
                    stringmoves = linea.split(",");
                    
                    for(int i =0; i <stringmoves.length; i++){
                        moves[i]= Integer.parseInt(stringmoves[i]);
                    }  
                    
                    moves[5] = movimientos;
                    moves2 = OrdenaryEliminarArreglo(moves);//Ordena el arreglo de menor a mayor(solo Movimientos)        
                    
                    int posicion = encontrarPosicion(moves2,movimientos);//Hallar la posicion del "movimiento" en el arreglo para saber en que posicion ira el Nombre del Jugador
               
                    Scanner lector2 = new Scanner(ficheroN1);
                    while(lector2.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea2=lector2.next();
                    }
                    
                    nombres = linea2.split(","); 
                  
                    nombres[4]= nombre;
                    nombresAL= OrdenarNombresRecord(nombres,posicion);//posicionar el nombre del jugador en el lugar Correspondiente
       
                       
                    SobreescribirFicheros(moves2,nombresAL,ficheroN1,ficheroM1);//con los arreglos ya ordenados, los escribimos en los .txt   
                  
                } catch (FileNotFoundException ex) {
                    System.out.print("No se pudo abrir el archivo!"+ex.getMessage());
                }
                
            }else{
                System.out.print("Fichero no existe");
            } 
            
            
        }else if(dificultad==4){
        
            if (ficheroM2.exists()) {//Si se ha creado el fichero
                try {
                    Scanner lector = new Scanner(ficheroM2);
                    while(lector.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea=lector.next();
                    }
                
                    stringmoves = linea.split(",");
                    
                    for(int i =0; i <stringmoves.length; i++){
                        moves[i]= Integer.parseInt(stringmoves[i]);
                    }  
                    
                    moves[5] = movimientos;
                    moves2 = OrdenaryEliminarArreglo(moves);        
                    int posicion = encontrarPosicion(moves2,movimientos);
                  
                  
                    Scanner lector2 = new Scanner(ficheroN2);
                    while(lector2.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea2=lector2.next();
                    }
                    
                    nombres = linea2.split(","); 
                    
                    nombres[4]= nombre;
                    nombresAL= OrdenarNombresRecord(nombres,posicion);
       
                    SobreescribirFicheros(moves2,nombresAL,ficheroN2,ficheroM2);
                
                
                }catch (FileNotFoundException ex) {
                    System.out.print("No se pudo abrir el archivo!"+ex.getMessage());
                }
            }else{
                System.out.print("Fichero no existe");
            } 
            
        
        }else{
            if (ficheroM3.exists()) {//Si se ha creado el fichero
                try {
                    Scanner lector = new Scanner(ficheroM3);
                    while(lector.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea=lector.next();
                    }
                
                    stringmoves = linea.split(",");
                    
                    for(int i =0; i <stringmoves.length; i++){
                        moves[i]= Integer.parseInt(stringmoves[i]);
                    }  
                    
                    moves[5] = movimientos;
                    moves2 = OrdenaryEliminarArreglo(moves);        
                    int posicion = encontrarPosicion(moves2,movimientos);
               
                    Scanner lector2 = new Scanner(ficheroN3);
                    while(lector2.hasNextLine()){// hasNextLine comprueba si hay otra linea Pattern en el bufer
                        linea2=lector2.next();
                    }
                    
                    nombres = linea2.split(","); 
                   
                    nombres[4]= nombre;
                    nombresAL= OrdenarNombresRecord(nombres,posicion);
         
                    SobreescribirFicheros(moves2,nombresAL,ficheroN3,ficheroM3);
                  
                } catch (FileNotFoundException ex) {
                    System.out.print("No se pudo abrir el archivo!"+ex.getMessage());
                }   
              
            }else{
                System.out.print("Fichero no existe");
            } 
        }
    }
    
    private static ArrayList OrdenaryEliminarArreglo(int moves[]){ //Ordena la cantidad de movimientos de menor a mayor
        ArrayList<Integer> lista = new ArrayList<Integer>();
      
        for(int i = 0; i <moves.length-1; i++){
            for(int j = 0; j < moves.length-1; j++){
                if(moves[j] > moves[j+1]){
                    int a = moves[j+1];
                    moves[j+1]= moves[j];
                    moves[j]=a;
                }  
            }
        }
      
        for(int i = 0; i < moves.length; i++){
            int a = moves[i];
            lista.add(a);
        }
        
        lista.remove(moves.length-1);
      
        return lista;
    }
  
    private static int encontrarPosicion(ArrayList moves,int movimientos){//Halla la posicion para situar la posicion del nombre correctamente
        int res = 0;
        for(int i = 0; i < moves.size();i++){
            int a = (int)moves.get(i);
            if(movimientos == a){
                return  i;
            }
        }
        return res;
    }
  
    private static ArrayList  OrdenarNombresRecord (String [] names,int posicion){//Inserta el nombre en la posicion correcta 
        ArrayList <String> res = new ArrayList<>();
      
        if(posicion == 4){
            for(int i = 0; i < names.length; i++){
                String a = names[i];
                res.add(a);
            }
        }else{
            for(int i = 0; i < names.length-1; i++){
                if(i == posicion){
                    String a = names[i];
                    String nom = names[4];
                    res.add(nom);
                    res.add(a);
                }else{
                    String b = names[i];
                    res.add(b);
                } 
            } 
        }
        return res;
    }
 
    private static void SobreescribirFicheros(ArrayList movimientoss,ArrayList nammes, File N, File M){

        try {
            BufferedWriter bw;//Instancia de BW
            bw = new BufferedWriter(new FileWriter(N));//Inicialización de "BW" con "FW" como parámetro con "fichero" como parámetro
            bw.write(nammes.get(0) + "," + nammes.get(1) + "," + nammes.get(2) + "," + nammes.get(3) + ","+ nammes.get(4));//Escribimos lo que haya en los TextFields
            //y entre ello agregamos una coma (",").
            bw.close();
             
            BufferedWriter bww;//Instancia de BW
            bww = new BufferedWriter(new FileWriter(M));//Inicialización de "BW" con "FW" como parámetro con "fichero" como parámetro
            bww.write(movimientoss.get(0) + "," + movimientoss.get(1) + "," + movimientoss.get(2) + "," + movimientoss.get(3) + ","+ movimientoss.get(4));//Escribimos lo que haya en los TextFields
            //y entre ello agregamos una coma (",").
            bww.close();//Cerramos para guardar los datos en el fichero
            
        }catch (IOException ex) {
            System.out.println("No se pudieron guardar los datos!n" + ex.getMessage());
        }
    }
}

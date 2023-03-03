/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanaprincipal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego
 */
public class ComprobadorRecordsTest {
    
    public ComprobadorRecordsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Record method, of class ComprobadorRecords.
     */
    @Test
    public void testRecord() {
        System.out.println("Record");
        int dificultad = 3;
        int movimientos = 200;
        boolean expResult = false;
        boolean result = ComprobadorRecords.Record(dificultad, movimientos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of PosicionarJugador method, of class ComprobadorRecords.
     */
    @Test
    public void testPosicionarJugador() {
        System.out.println("PosicionarJugador");
        String nombre = "Juan";
        int dificultad = 3;
        int movimientos = 55;
        ComprobadorRecords.PosicionarJugador(nombre, dificultad, movimientos);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

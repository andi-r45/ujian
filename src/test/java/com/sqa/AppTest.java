package com.sqa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AppTest 
{
    keliling_kolam keliling  ;
    volume_kolam volume ;
    suhu faren ;

    @Before
    public void setUp() throws Exception {
        keliling = new keliling_kolam();
        volume = new volume_kolam();
        faren = new suhu();

    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void teskeliling()
    {
        assertEquals(56, keliling.keliling(8,5,1), 0.0);
    }
    /*@Test
    public void teskeliling_bukanangka()
    {
        assertEquals(56, keliling.keliling("a",5,1), 0.0);
    }*/
    @Test
    public void teskeliling_angkanegatif()
    {
        assertEquals(-56, keliling.keliling(-8,-5,-1), 0.0);
    }
    @Test
    public void teskeliling_nullangka()
    {
        assertEquals(0, keliling.keliling(0,0,0), 0.0);
    }
    //========================================================
    @Test
    public void tesvolume()
    {
        assertEquals(40, volume.volume(8,5,1), 0.0);
    }
   /* @Test
    public void tesvolume_bukanangka()
    {
        assertEquals(40, volume.volume("a",5,1), 0.0);
    }*/
    @Test
    public void tesvolume_angkanegatif()
    {
        assertEquals(-40, volume.volume(-8,-5,-1), 0.0);
    }
    @Test
    public void tesvolume_nullangka()
    {
        assertEquals(0, volume.volume(0,0,0), 0.0);
    }




    //========================================================
    @Test
    public void tessuhu()
    {
        assertEquals(-5, faren.faren(23), 0.0);
    }
}

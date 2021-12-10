package com.sqa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppTest 
{
    keliling_kolam keliling  ;
    volume_kolam volume ;
    suhu faren ;
    Scanner baca;
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
    public void teskeliling_pakefile() {
        for (String isi : readfile("DBkeliling.csv")) {
            String [] data = isi.split(";");
            String panjang = data[0];
            String lebar = data[1];
            String tinggi = data[2];
            String hasil = data[3];
            assertEquals(Integer.parseInt(hasil), keliling.keliling(Integer.parseInt(panjang) , Integer.parseInt(lebar), Integer.parseInt(tinggi)),0.0);
        }
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
    public void tesvolume_pakefile() {
        for (String isi : readfile("DBvolume.csv")) {
            String [] data = isi.split(";");
            String panjang = data[0];
            String lebar = data[1];
            String tinggi = data[2];
            String hasil = data[3];
            assertEquals(Integer.parseInt(hasil), keliling.keliling(Integer.parseInt(panjang) , Integer.parseInt(lebar), Integer.parseInt(tinggi)),0.0);
        }
    }
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
    public void tessuhu_pakefile() {
        for (String isi : readfile("DBfaren.csv")) {
            String [] data = isi.split(";");
            String f = data[0];
            String c = data[1];
            assertEquals(Integer.parseInt(c),Integer.parseInt(f),0.0);
        }
    }
    @Test
    public void tessuhu()
    {
        assertEquals(-5, faren.faren(23), 0.0);
    }
    /*@Test
    public void tessuhu_bukananga()
    {
        assertEquals(-5, faren.faren("a"), 0.0);
    }*/
    @Test
    public void tessuhu_angkanegatif()
    {
        assertEquals(-5, faren.faren(23), 0.0);
    }
    @Test
    public void tessuhu_nullangka()
    {
        assertEquals(0, faren.faren(0), 0.0);
    }

//========================================================

    public List <String> readfile(String namefile) {
        List <String> temp = new  ArrayList<String>();

        try {
            InputStream myfile = getClass().getClassLoader().getResourceAsStream(namefile);
            baca = new Scanner(myfile);
            while (baca.hasNextLine()) {
                temp.add(baca.nextLine());
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

        return temp; 
    }
}

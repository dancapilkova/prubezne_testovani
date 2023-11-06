import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MyHistoryTest {
    @TempDir
    Path pomocnyAdresar;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void read() {
        MyHistory h = new MyHistory(pomocnyAdresar + "\\abc.dat");
        try {
            h.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void save() {
    }

    @Test
    void addLine() {
        MyHistory h = new MyHistory("abc");
        h.addLine("radek 1");
        assertEquals("radek 1\n", h.toString());
       /* if(h.toString().equals("radek 1")){
            System.out.println("test prosel");
        }else{
            System.out.println("test neprosel, toString vratil " + h.toString() + " ja jsem chtel radek 1");
        }
        */

    }
    @Test
    void addMoreLine() {
        MyHistory h = new MyHistory("abc");
        h.addLine("radek 1");
        h.addLine("radek 2");
        h.addLine("radek 3");
        assertEquals("radek 1\nradek 2\nradek 3\n", h.toString());
       /* if(h.toString().equals("radek 1")){
            System.out.println("test prosel");
        }else{
            System.out.println("test neprosel, toString vratil " + h.toString() + " ja jsem chtel radek 1");
        }
        */

    }
    @Test
    void addDuplicateLine() {
        MyHistory h = new MyHistory("abc");
        h.addLine("radek 1");
        h.addLine("radek 2");
        h.addLine("radek 3");
        h.addLine("radek 3");
        assertEquals("radek 1\nradek 2\nradek 3\n", h.toString());
       /* if(h.toString().equals("radek 1")){
            System.out.println("test prosel");
        }else{
            System.out.println("test neprosel, toString vratil " + h.toString() + " ja jsem chtel radek 1");
        }
        */

    }

    @Test
    void testToString() {
    }
}
package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
        @Test
        void isThisSphere() {
            Box box = new Box(0, 10);
            String name = box.whatsThis();
            assertThat(name).isEqualTo("Sphere");
        }
    @Test
    public void testWhatsThis() {
        Box box = new Box(4, 3);
        assertEquals("Tetrahedron", box.whatsThis());

        Box box2 = new Box(10, 3);
        assertEquals("Unknown object", box2.whatsThis());
    }

    @Test
    public void testGetNumberOfVertices() {
        Box box = new Box(4, 3);
        assertEquals(4, box.getNumberOfVertices());

        Box box2 = new Box(10, 3);
        assertEquals(-1, box2.getNumberOfVertices());
    }

    @Test
    public void testIsExist() {
        Box box = new Box(4, 3);
        assertTrue(box.isExist());

        Box box2 = new Box(-1, 3);
        assertFalse(box2.isExist());
    }

    @Test
    public void testGetArea() {
        Box box = new Box(4, 3);
        assertEquals(15.588457268119894, box.getArea());

        Box box2 = new Box(8, 0);
        assertEquals(0, box2.getArea());
    }
}
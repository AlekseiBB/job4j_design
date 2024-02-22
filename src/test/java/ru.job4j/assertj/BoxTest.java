package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BoxTest {
        @Test
        void isThisSphere() {
            Box box = new Box(0, 10);
            assertThat(box.whatsThis()).isEqualTo("Sphere");
        }
    @Test
    public void testWhatsThis() {
        Box box = new Box(4, 3);
        assertThat(box.whatsThis()).isEqualTo("Tetrahedron");

        Box box2 = new Box(10, 3);
        assertThat(box2.whatsThis()).isEqualTo("Unknown object");
    }

    @Test
    public void testGetNumberOfVertices() {
        Box box = new Box(4, 3);
        assertThat(box.getNumberOfVertices()).isEqualTo(4);

        Box box2 = new Box(10, 3);
        assertThat(box2.getNumberOfVertices()).isEqualTo(-1);
    }

    @Test
    public void testIsExist() {
        Box box = new Box(4, 3);
        assertThat(box.isExist()).isTrue();

        Box box2 = new Box(-1, 3);
        assertThat(box2.isExist()).isFalse();
    }

    @Test
    public void testGetArea() {
        Box box = new Box(4, 3);
        assertThat(box.getArea()).isCloseTo(15.588, withPrecision(0.001d));

        Box box2 = new Box(8, 0);
        assertThat(box2.getArea()).isEqualTo(0);
    }
}
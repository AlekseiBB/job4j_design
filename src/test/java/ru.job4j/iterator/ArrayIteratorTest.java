package ru.job4j.iterator;

// автоимпорт если создавать тестовый класс alt+enter
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

// копировал из класса урока
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

class ArrayIteratorTest {
    @Test
    public void whenMultiCallhasNextThenTrue() {
        ArrayIterator iterator = new ArrayIterator(
                new int[] {1, 2, 3}
        );
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        ArrayIterator iterator = new ArrayIterator(
                new int[] {1, 2, 3}
        );
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
    }
}
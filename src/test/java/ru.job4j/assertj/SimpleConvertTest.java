package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).isNotEmpty();
        assertThat(list).first().isEqualTo("first");
        assertThat(list).last().isNotNull().isEqualTo("five");
    }

    @Test
    void toSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).isNotEmpty()
                .hasSize(5)
                .containsAnyOf("first", "second", "three")
                .doesNotContain("zero")
                .containsOnly("first", "second", "three", "four", "five")
                .containsAnyOf("zero", "second", "six");
    }

    @Test
    void assertMap() {
        Map<Integer, String> map = Map.of(
                1, "first", 2, "second", 3, "three", 4, "four", 5, "five");
        assertThat(map).isNotEmpty()
                .hasSize(5)
                .containsKeys(1, 2, 3, 4, 5)
                .containsValues("first", "second", "three")
                .doesNotContainKey(0)
                .doesNotContainValue("zero")
                .containsEntry(2, "second");
    }
}
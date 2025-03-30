package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    private Container container;
    @BeforeEach
    void setUp() {
        container = new Container();
    }

    @Test
    void testAddAndGetElement() {
        container.add(10);
        container.add(20);
        container.add(30);

        assertEquals(10, container.get_element(0));
        assertEquals(20, container.get_element(1));
        assertEquals(30, container.get_element(2));
    }

    @Test
    void testGetSize() {
        assertEquals(0, container.get_size());
        container.add(10);
        assertEquals(1, container.get_size());
        container.add(20);
        assertEquals(2, container.get_size());
    }

    @Test
    void testGetCapacity() {
        assertEquals(50, container.get_capacity());
        for (int i = 0; i < 50; i++) {
            container.add(i);
        }
        assertTrue(container.get_capacity() > 50); // Проверяем, что вместимость увеличилась
    }

    @Test
    void testDelete() {
        container.add(10);
        container.add(20);
        container.add(30);
        container.delete(1); // Удаляем элемент с индексом 1 (20)

        assertEquals(10, container.get_element(0));
        assertEquals(30, container.get_element(1));
        assertEquals(2, container.get_size());
    }

    @Test
    void testDeleteOutOfBounds() {
        container.add(10);
        container.add(20);
        assertThrows(IndexOutOfBoundsException.class, () -> container.delete(2));
        assertThrows(IndexOutOfBoundsException.class, () -> container.delete(-1));
    }

    @Test
    void testGetElementOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.get_element(0));
        container.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> container.get_element(1));
    }

    @Test
    void testToString() {
        assertEquals("empty\nsize: 0\ncapacity: 50", container.toString());
        container.add(10);
        container.add(20);
        assertEquals("10 20 \nsize: 2\ncapacity: 50", container.toString());
    }
}
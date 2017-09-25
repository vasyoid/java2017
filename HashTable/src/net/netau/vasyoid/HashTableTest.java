package net.netau.vasyoid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    void testSize() {
        HashTable table = new HashTable();
        assertEquals(0, table.size());
        table.put("key", "value");
        assertEquals(1, table.size());
        table.put("key2", "value");
        assertEquals(2, table.size());
        table.remove("key2");
        assertEquals(1, table.size());
        table.remove("key");
        assertEquals(0, table.size());
    }

    @Test
    void testContains() {
        HashTable table = new HashTable();
        assertFalse(table.contains("key"));
        table.put("key", "value");
        assertTrue(table.contains("key"));
    }

    @Test
    void testGet() {
        HashTable table = new HashTable();
        assertNull(table.get("key"));
        table.put("key", "value");
        assertEquals("value", table.get("key"));
    }

    @Test
    void testPut() {
        HashTable table = new HashTable();
        assertNull(table.put("key", "value"));
        assertTrue(table.contains("key"));
        assertEquals("value", table.get("key"));
        assertEquals("value", table.put("key", "value2"));
        assertEquals("value2", table.get("key"));
    }

    @Test
    void testRemove() {
        HashTable table = new HashTable();
        table.put("key", "value");
        assertNull(table.remove("key2"));
        assertEquals("value", table.remove("key"));
        assertFalse(table.contains("key"));
        assertNull(table.remove("key"));
    }

    @Test
    void testClear() {
        HashTable table = new HashTable();
        table.put("key", "value");
        table.put("key2", "value2");
        table.clear();
        assertEquals(0, table.size());
        table.clear();
        assertEquals(0, table.size());
    }

    @Test
    void testCollision() {
        HashTable table = new HashTable();
        table.put("FB", "value1");
        table.put("Ea", "value2");
        assertEquals(2, table.size());
        assertEquals("value1", table.get("FB"));
        assertEquals("value2", table.get("Ea"));
    }

    @Test
    void testRebuild() {
        HashTable table = new HashTable();
        for (int i = 1; i <= 20; i++) {
            table.put("key" + i, "value");
            assertEquals(i, table.size());
        }
    }
}
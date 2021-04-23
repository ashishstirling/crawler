/*
Class URLStoreTest: This class tests URLStore functionality
Author: Ashish Kulkarni
Date: 23-Apr-2021
 */

package com.company.models;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestURLStore {

    // URLStore constructor initialises visited and yetToVisit hashsets
    // This test ensures that when a new URLStore is created, these hashsets are empty. This is vital.
    @Test
    public void testConstructor() {
        URLStore urlStore = new URLStore();

        assertTrue(urlStore.getVisited().isEmpty());
        assertTrue(urlStore.getYetToVisit().isEmpty());
    }

}

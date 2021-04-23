/*
Class URLStore: This class stores 2 HashSets - one to hold a set of visited URLs and another to hold a set of yet to visit URLs
Author: Ashish Kulkarni
Date: 23-Apr-2021
 */

package com.company.models;

import java.util.HashSet;

public class URLStore {
    // HashSet to store visited URLs
    private HashSet<String> visited;
    // HashSet to store yet to visit URLs
    private HashSet<String> yetToVisit;

    public URLStore() {
        visited = new HashSet<>();
        yetToVisit = new HashSet<>();
    }

    public HashSet<String> getVisited() {
        return visited;
    }

    public void setVisited(HashSet<String> visited) {
        this.visited = visited;
    }

    public HashSet<String> getYetToVisit() {
        return yetToVisit;
    }

    public void setYetToVisit(HashSet<String> yetToVisit) {
        this.yetToVisit = yetToVisit;
    }
}

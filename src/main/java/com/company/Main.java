/*
Class Main: Main class for crawler
Author: Ashish Kulkarni
Date: 23-Apr-2021
 */

package com.company;

import com.company.models.URLStore;
import com.company.services.Crawler;

public class Main {

    // Main function. This is where the magic begins.
    public static void main(String[] args) {
        // Create an object of URLStore class
        URLStore urlStore = new URLStore();
        // Create an object of Crawler class
        Crawler crawler = new Crawler();

        // Initiate crawling
        crawler.crawl("https://wiprodigital.com", "https://wiprodigital.com/", 0, urlStore);
    }

}

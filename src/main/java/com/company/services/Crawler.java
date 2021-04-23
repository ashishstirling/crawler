/*
Class Crawler: Service class to carry out the website crawling
Author: Ashish Kulkarni
Date: 23-Apr-2021
 */

package com.company.services;

import com.company.models.URLStore;

public class Crawler {

    /**
     * crawl - Function to crawl a given url
     * @param domain - Domain we are crawling
     * @param url - URL within the Domain to crawl
     * @param level - Current URL level - 0 will be starting page, 1 for links from that page and so on
     * @param urlStore - URL Storage of visited and yet to visit URLs
     */
    public void crawl(String domain, String url, int level, URLStore urlStore) {

        // Check if we have already visited the URL provided
        // If we don't do this check, we could end up in an infinite loop
        if (!urlStore.getVisited().contains(url)) {

            // Add this URL to list of visited URLs
            urlStore.getVisited().add(url);

            // Output this URL
            System.out.println("-".repeat(level) + url);

        }

    }

}

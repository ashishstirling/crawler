/*
Class Crawler: Service class to carry out the website crawling
Author: Ashish Kulkarni
Date: 23-Apr-2021
 */

package com.company.services;

import com.company.models.URLStore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

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

            // Add this URL to set of visited URLs
            urlStore.getVisited().add(url);
            // Remove this URL from set of yet to visit URLs
            urlStore.getYetToVisit().remove(url);

            // Output this URL
            System.out.println("-".repeat(level) + url);

            try {

                // Fetch URL content
                Document document = Jsoup.connect(url).get();

                // Get list of image elements on the page
                Elements imagesOnPage = document.select("img[src]");

                // Print this list of images
                imagesOnPage.forEach(image -> System.out.println("-".repeat(level + 1)
                        + " [IMAGE] "
                        + image.attr("abs:src")));

                // Get list of script elements on the page
                Elements scriptsOnPage = document.select("script[src]");

                // Print this list of scripts
                scriptsOnPage.forEach(script -> System.out.println("-".repeat(level + 1)
                        + " [SCRIPT] "
                        + script.attr("abs:src")));

                // Get list of anchor tags (links) on the page
                Elements anchorsOnPage = document.select("a[href]");

                // Create a HashSet to store Child URLs of this page
                HashSet<String> childURLs = new HashSet<>();

                // Traverse all the anchors on the page
                anchorsOnPage.forEach(anchor -> {
                    String link = anchor.attr("abs:href");
                    if (!urlStore.getVisited().contains(link)
                            && !urlStore.getYetToVisit().contains(link)
                            && !childURLs.contains(link)) {
                        urlStore.getYetToVisit().add(link);
                        childURLs.add(link);
                    }
                });

                // For each child URL, check if it is from the domain we are crawling
                // If it is from same domain, crawl that child URL
                // Else, display it as EXTERNAL URL

                childURLs.forEach(childURL -> {
                    if (childURL.startsWith(domain)) {
                        crawl(domain, childURL, level + 1, urlStore);
                    } else {
                        System.out.println("-".repeat(level + 1) + " [EXTERNAL URL] " + childURL);
                        urlStore.getYetToVisit().remove(childURL);
                    }
                });

            } catch (IOException e) {
                System.err.println("-".repeat(level) + url + e.getMessage());
            }

        }

    }

}

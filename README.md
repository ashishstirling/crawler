
# crawler
Website Crawler written in Java 11

**Requirements:**

 - Crawler will crawl one single domain.
 - Given a starting URL, it will visit all pages within the domain but, won't follow links to external websites. It will list them out though.
 - The output will be a simple structured site map showing
	 - Links to other pages within same domain
	 - Links to external URLs
	 - Links to static content such as images, script files, etc.

 **To Run This Code:**

 - Pull https://github.com/ashishstirling/crawler.git. Best option is to pull this into intelliJ IDEA as a new project from version control.
 - Ensure Java 11 and Maven are in the path and available to intelliJ IDEA.
 - Run - mvn clean compile test exec:java -Dexec.mainClass="com.company.Main"

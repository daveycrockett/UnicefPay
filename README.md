UnicefPay
=========

A web scraper to collate the minimum pay at UNICEF (level 1 step I) by country office in a common currency (USD)

Installation
---------------

This project requires that all the jar files in the attached lib/ folder are included in your classpath.  If you're using eclipse, you can easily use the project by selecting file..import..existing projects into workspace, as the .project and .classpath files are configured.  Then right click on WebScraper.java, select run as...java application.

This program will crawl the United nations root page, looking for spreadsheets that match a (almost easy-to-parse) standard template for publishing pay grades.  It will then search for the lowest pay grade and the currency that the pay grades are supplied in, fetch today's forex rates, and output a list of countries, currency codes, exchange rates, and annual salaries.  With a little formatting, you can produce a report similar to the one in this project.

Known Issues
-------------
Currently, there's a connection issue with Kosovo, and the Eastern Carribean doesn't have a known currency.  Also, the South Sudanese and Eritrean currencies are not available via yahoo! finance, these values had to be determined through a more manual search.


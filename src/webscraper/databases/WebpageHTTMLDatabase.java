/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.databases;

import java.util.HashMap;

/**
 *
 * @author Peter
 */
public class WebpageHTTMLDatabase {

    HashMap<String, String> WebPages;

    public WebpageHTTMLDatabase() {
        WebPages = new HashMap<String, String>();
    }

    public void addSiteNameWithThisHTMLAdress(String siteName, String HTMLAdress) {
        WebPages.put(siteName, HTMLAdress);
    }

    public void setSiteNameToThisAdress(String siteName, String HTMLAdress) {
        if (!WebPages.get(siteName).equals(HTMLAdress)) { //TODO and can connect
            WebPages.replace(siteName, HTMLAdress);
        }
        else{
            System.out.println("Nu such site found.\n");
             //       + "want to add Site and adress to directory? (Y/N)"); //TODO fix functionality        
        }

    }

    public String getHTMLAdressForThisSiteName(String siteNameToFind) {
        String htmlAdress = "";
        try {
            htmlAdress = WebPages.get(siteNameToFind);
        } catch (Exception e) {
            System.out.println("No such site name found"); //TODO if no such site name found ask if they want to add site name
        }
         return htmlAdress;
    }

}



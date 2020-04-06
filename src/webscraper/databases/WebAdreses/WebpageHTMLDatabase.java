/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.databases.WebAdreses;

import java.util.HashMap;

/**
 *
 * @author Peter
 */
public class WebpageHTMLDatabase {

    HashMap<String, String> WebPages;

    public WebpageHTMLDatabase() {
        WebPages = new HashMap<String, String>();
    }
    
    public void test(){
        String siteName = "Test1";
        String htmlAdress = "www.test.com";
        this.addSiteNameWithThisHTMLAdress(siteName, htmlAdress);
        System.out.println(this.getHTMLAdressForThisSiteName(siteName));
        System.out.println(this.getSiteNameForThisHTMLAdres(htmlAdress));
        System.out.println(WebPages.get("aaa"));
        System.out.println(this.containsSiteName(siteName));
        System.out.println(this.containsHTMLAdres(htmlAdress));
        System.out.println(this.containsSiteName("Test2"));
        System.out.println(this.containsHTMLAdres("www.test2.com"));
    }

    public void addSiteNameWithThisHTMLAdress(String siteName, String HTMLAdress) {
        WebPages.put(siteName, HTMLAdress);
    }

    public void setSiteNameToThisAdress(String siteName, String HTMLAdress) {
        if (!WebPages.get(siteName).equals(HTMLAdress)) { //TODO and can connect
            WebPages.replace(siteName, HTMLAdress);
        }
       

    }

    public String getHTMLAdressForThisSiteName(String siteNameToFind) {
        String returnString = "";
     
            returnString = WebPages.get(siteNameToFind);
      
         return returnString;
    }
    
    public String getSiteNameForThisHTMLAdres(String htmlAdress){
        String returnString = "";
        for(String checker : this.getDatabase().keySet()){
            if(this.getDatabase().get(checker).equals(htmlAdress)){
                returnString = this.getDatabase().get(checker);
            }
        }
        return returnString;
    }
    
    public boolean containsSiteName(String siteName){
        if(this.getDatabase().containsKey(siteName)){
            return true;
        }
        return false;
    }
    
    public boolean containsHTMLAdres(String htmlAdress){
        if(this.getDatabase().containsValue(htmlAdress)){
            return true;
        }
        return false;
    }
    
    public HashMap<String,String> getDatabase(){
        return this.WebPages;
    }

}



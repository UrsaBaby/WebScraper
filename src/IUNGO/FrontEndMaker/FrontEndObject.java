/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import IUNGO.FrontEndMaker.FrontEndMakerEnums.AlignJustify;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectTypes;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectDisplayTypes;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndLengthUnits;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Peter
 */
public class FrontEndObject {
    
    ArrayList<FrontEndObject> listOfFrontEndObjects;
    FrontEndObjectTypes frontEndObjectType;
    String id;
    boolean isHtmlPrinted;
    boolean isOpeningHtmlPrinted;
    boolean isCssPrinted;
    



 
    

    
    String linksTo;
    
    String outputTo;

    FrontEndObjectStyle style;
    
    public FrontEndObject() {
  
        isHtmlPrinted = false;
        isOpeningHtmlPrinted = false;
        this.style = style;
    }
    
    public void setFrontEndObjectStyle(FrontEndObjectStyle style) {
        this.style = style;
    }
    
    public void setObjectStyle(FrontEndObjectStyle style) {
        this.style = style;
    }
    



    
    public void setId(String id) {
        this.id = id;
    }
    
    

    
    public void setIsHtmlPrinted(boolean toThis) {
        this.isHtmlPrinted = toThis;
    }
    
    public void setIsOpeningHtmlPrinted(boolean toThis) {
        this.isOpeningHtmlPrinted = toThis;
    }
    
    
    public void setIsCssPrinted(boolean toThis) {
        this.isCssPrinted = toThis;
    }
    
    public void setLinksTo(String linkToThis) {
        this.linksTo = linkToThis;
    }
    
    public void setOutputTo(String directoryAndFilename) {
        this.outputTo = directoryAndFilename;
    }
    
    public void setObjectType(FrontEndObjectTypes thisType) {
        this.frontEndObjectType = thisType;
    }
    
    public void setImageCropType() {
        
    }

    //
    public FrontEndObjectStyle getFrontEndObjectStyle() {
        return style;
    }
    
    public String getId() {
        return this.id;
    }
    

    private ArrayList<FrontEndObject> getListOfFrontEndObjects() {
        return this.listOfFrontEndObjects;
    }
    
    public FrontEndObjectTypes getFrontEndObjectType() {
        return this.frontEndObjectType;
    }
    
  
  
  
    
    public ArrayList<FrontEndObject> getListOfFeos() {
        return this.listOfFrontEndObjects;
    }
    
  
   

    
    public String getLinksTo() {
        return this.linksTo;
    }
    
    public String getOutputTo() {
        return this.outputTo;
    }
    
    public String getLinkAdress() {
        return this.getLinkAdress() + ".html#" + this.getId();
    }
   
    
 

    //
    public void addFrontEndObject(FrontEndObject addThis) {
        if (!this.isListOfFEOsInitiated()) {
            this.initiateListOfFrontEndObjects();
        }
        this.getListOfFrontEndObjects().add(addThis);
    }

    //
  
    
  
    
   
    
  
    
    public boolean isListOfFEOsInitiated() {
        if (this.listOfFrontEndObjects == null) {
            return false;
        }
        return true;
    }
    
    public boolean isCssPrinted() {
        return this.isCssPrinted;
    }

    //
    private void initiateListOfFrontEndObjects() {
        this.listOfFrontEndObjects = new ArrayList<>();
    }
    
}

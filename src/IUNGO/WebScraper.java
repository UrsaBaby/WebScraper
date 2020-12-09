/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO;

import IUNGO.FrontEndMaker.FrontEndLengthUnits;
import IUNGO.FrontEndMaker.FrontEndObject;
import IUNGO.FrontEndMaker.FrontEndObjectInterface;
import IUNGO.FrontEndMaker.StringFormatter;
import java.awt.AWTException;
import java.io.IOException;

/**
 *
 * @author Peter
 */
public class WebScraper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        helperConsole helperConsole = new helperConsole();
        
        FrontEndObjectInterface FEOInterface = new FrontEndObjectInterface();
        int[] minMaxSize = new int[2];
        minMaxSize[0] = 100;
        minMaxSize[1] = 1000;
        FrontEndObject mainScene = FEOInterface.createContainer("scene", minMaxSize, 0, minMaxSize, 0, FrontEndLengthUnits.PX);
        mainScene.
        mainScene.setBackgroundColor("blue");

        FrontEndObject insideBox = FEOInterface.createContainer("box", minMaxSize, 0, minMaxSize, 0, FrontEndLengthUnits.PX);

        mainScene.addFrontEndObject(insideBox);

        StringFormatter stringFormat = new StringFormatter();
    
        String printString =  stringFormat.getCSS(mainScene) + "\n" +stringFormat.getHTML(mainScene);
        //System.out.println(stringFormat.getHTML2(mainScene));
        helperConsole.writeThisTextToAFile(printString, "tes2t", ".html");
       

    }

   

}

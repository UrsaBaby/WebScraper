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
import IUNGO.MainEnd.Functions.functions.coreFunctions.WebFunction;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstructionListRunner;
import IUNGO.MainEnd.Functions.functions.functionInstruction.ListOfFunctionInstructions;
import IUNGO.MainEnd.ports.Webport.WebPort;
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
        minMaxSize[0] = 10;
        minMaxSize[1] = 10;
        FrontEndObject mainScene = FEOInterface.createContainer("scene", minMaxSize, 0, minMaxSize, 0, FrontEndLengthUnits.PX);
        mainScene.setWidthHeight(500, FrontEndLengthUnits.PX, 500, FrontEndLengthUnits.PX);
        mainScene.setBackgroundColor("blue");

        FrontEndObject insideBox = FEOInterface.createContainer("box", minMaxSize, 0, minMaxSize, 0, FrontEndLengthUnits.PX);
        insideBox.setBackgroundColor("white");
        insideBox.setWidthHeight(50, FrontEndLengthUnits.PX, 50, FrontEndLengthUnits.PX);
        

        mainScene.addFrontEndObject(insideBox);

        StringFormatter stringFormat = new StringFormatter();
    
        String printString =  stringFormat.getCSS(mainScene) + "\n" +stringFormat.getHTML(mainScene);
        //System.out.println(stringFormat.getHTML2(mainScene));
        ListOfFunctionInstructions tryList = helperConsole.writeThisTextToAFile(printString, "tes2t", ".html");

        FunctionsInstructionListRunner listRunner = new FunctionsInstructionListRunner(tryList);
        listRunner.run();
        
        ListOfFunctionInstructions tryList2 = new ListOfFunctionInstructions();
        tryList2.addFunctionsInstruction(helperConsole.getWFI().createFunctionStartWebGetter());
        tryList2.addFunctionsInstruction(helperConsole.WFI.createFunctionInstructionConnectToThisSite("C:\\Users\\Peter\\Documents\\NetBeansProjects\\WebScraper\\tes2t.html"));
        FunctionsInstructionListRunner listRunner2 = new FunctionsInstructionListRunner(tryList2);
        listRunner2.run();
        

        
       

    }

   

}

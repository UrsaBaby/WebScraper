/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO;

import IUNGO.FrontEndMaker.FrontEndLengthUnits;
import IUNGO.FrontEndMaker.FrontEndObject;
import IUNGO.FrontEndMaker.FrontEndObjectDisplayTypes;
import IUNGO.FrontEndMaker.FrontEndObjectInterface;
import IUNGO.FrontEndMaker.FrontEndObjectTypes;
import IUNGO.FrontEndMaker.StringFormatter;
import IUNGO.MainEnd.Functions.functions.coreFunctions.WebFunction;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstructionListRunner;
import IUNGO.MainEnd.Functions.functions.functionInstruction.ListOfFunctionInstructions;
import IUNGO.MainEnd.ports.Webport.WebPort;
import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        WebFunction wf = new WebFunction();
        
        FrontEndObjectInterface FEOInterface = new FrontEndObjectInterface();
        int[] minMaxSize = new int[2];
        minMaxSize[0] = 10;
        minMaxSize[1] = 10;
        FrontEndObject mainScene = FEOInterface.createContainer("scene");
        mainScene.setWidthHeight(500, FrontEndLengthUnits.PX, 500, FrontEndLengthUnits.PX);
        mainScene.setBackgroundColor("grey");
       mainScene.setDisplayType(FrontEndObjectDisplayTypes.GRID);
       
       ArrayList<ArrayList<String>> templateArea = new ArrayList<>();
       ArrayList<String> column1 = new ArrayList<>();
       column1.add("one");
       column1.add("two");
       column1.add("two");
        ArrayList<String> column2 = new ArrayList<>();
       column2.add("one");
       column2.add("two");
       column2.add("two");
        ArrayList<String> column3 = new ArrayList<>();
       column3.add("one");
       column3.add("three");
       column3.add("three");
       templateArea.add(column1);
       templateArea.add(column2);
       templateArea.add(column3);
 
       mainScene.setGridTemplateArea(templateArea);
       mainScene.setOutputTo("C:\\\\Users\\\\Peter\\\\Documents\\\\NetBeansProjects\\\\WebScraper\\\\tes2t");
       
       

        FrontEndObject insideBox = FEOInterface.createContainer("box");
        insideBox.setBackgroundColor("pink");
        insideBox.setGridArea("one");
        insideBox.setLinksTo("https://www.google.com/");
        insideBox.setObjectType(FrontEndObjectTypes.BUTTON);
    
        
        FrontEndObject twiceInsideBox = FEOInterface.createContainer("box2");
        twiceInsideBox.setBackgroundColor("orange");  
        twiceInsideBox.setGridArea("two");
        
         FrontEndObject twiceInsideBox2 = FEOInterface.createContainer("box3");
        twiceInsideBox2.setBackgroundColor("grey");
        twiceInsideBox2.setGridArea("three");
        
       /*  FrontEndObject twiceInsideBox3 = FEOInterface.createContainer("box4", minMaxSize, 0, minMaxSize, 0, FrontEndLengthUnits.PX);
        twiceInsideBox3.setBackgroundColor("orange");
        twiceInsideBox3.setWidthHeight(50, FrontEndLengthUnits.PX, 500, FrontEndLengthUnits.PX);*/
        
       
        mainScene.addFrontEndObject(twiceInsideBox2);
        mainScene.addFrontEndObject(twiceInsideBox);
        mainScene.addFrontEndObject(insideBox);

        StringFormatter stringFormat = new StringFormatter();
    
        String printString =  stringFormat.getCSS(mainScene) + "\n" +stringFormat.getHTML(mainScene);
        //System.out.println(stringFormat.getHTML2(mainScene));
        ListOfFunctionInstructions tryList = helperConsole.writeThisTextToAFile(printString, mainScene.getOutputTo(), ".html");

        FunctionsInstructionListRunner listRunner = new FunctionsInstructionListRunner(tryList);
        listRunner.run();
        
       /* ListOfFunctionInstructions tryList2 = new ListOfFunctionInstructions();
        tryList2.addFunctionsInstruction(helperConsole.getWFI().createFunctionStartWebGetter());
        tryList2.addFunctionsInstruction(helperConsole.WFI.createFunctionInstructionConnectToThisSite("C:\\Users\\Peter\\Documents\\NetBeansProjects\\WebScraper\\tes2t.html"));
        FunctionsInstructionListRunner listRunner2 = new FunctionsInstructionListRunner(tryList2);
        listRunner2.run();*/
       
       wf.startWebPort();
       wf.connectWebGetterToThisSite("C:\\\\Users\\\\Peter\\\\Documents\\\\NetBeansProjects\\\\WebScraper\\\\tes2t.html");
       
       Thread.sleep(5000);
       /*   System.out.println("to quit press q and enter");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String checkForQuit = scanner.next();
            if(checkForQuit.equals("q")){
                break;
            }
            
        }*/
       
       wf.closeWebPort();
        
        
        

        
       

    }

   

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO;

import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndLengthUnits;
import IUNGO.FrontEndMaker.FrontEndObject;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectDisplayTypes;
import IUNGO.FrontEndMaker.FrontEndObjectInterface;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectTypes;

import IUNGO.FrontEndMaker.FrontEndObjectStyleInterface;
import IUNGO.FrontEndMaker.StringFormatter;
import IUNGO.MainEnd.Functions.functions.coreFunctions.WebFunction;
import IUNGO.MainEnd.Functions.functions.functionInstruction.FunctionsInstructionListRunner;
import IUNGO.MainEnd.Functions.functions.functionInstruction.ListOfFunctionInstructions;
import IUNGO.MainEnd.ports.Webport.WebPort;
import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import IUNGO.FrontEndMaker.FrontEndObjectStyle;

/**
 *
 * @author Peter
 */
public class WebScraper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        //create the interfaces for style for quick generic styles such as image, button and so on.
        FrontEndObjectStyleInterface styleInterface = new FrontEndObjectStyleInterface();
        FrontEndObjectInterface FEOInterface = new FrontEndObjectInterface();
        ////// create the mainscene

        //Sets resolution
        int[] resolution = new int[2];
        resolution[0] = 1920;
        resolution[1] = 1080;

        //Creating the templategridarea
        ArrayList<ArrayList<String>> templateArea = new ArrayList<>();
        ArrayList<String> column1 = new ArrayList<>();
        column1.add("one");
        column1.add("one");
        column1.add("one");
        ArrayList<String> column2 = new ArrayList<>();
        column2.add("two");
        column2.add("two");
        column2.add("three");
        ArrayList<String> column3 = new ArrayList<>();
        column3.add("two");
        column3.add("two");
        column3.add("three");
        templateArea.add(column1);
        templateArea.add(column2);
        templateArea.add(column3);

        // Creating FEOStyle object, from interface get a template scene, give it id, resolution with type of unitx (pixels), and the template area.
        FrontEndObjectStyle mainSceneStyle = styleInterface.getScene(resolution, FrontEndLengthUnits.PX, FrontEndLengthUnits.PX, templateArea);

        //sets color to 
        mainSceneStyle.setColor("blue");

        //Create a FEO, and put the style in it.
        FrontEndObject mainScene = FEOInterface.createScene("MAINSCENE", mainSceneStyle);

        //Sets the output of the frontendobject mainScene
        mainScene.setOutputTo("C:\\\\Users\\\\Peter\\\\Documents\\\\NetBeansProjects\\\\WebScraper\\\\tes2t");

        // create the button
        FrontEndObject button = FEOInterface.createButton("button 1", "https://www.google.com/", styleInterface.getButton(), "three");

        //button settings
        button.getFrontEndObjectStyle().setColor("red");
        button.getFrontEndObjectStyle().setText("button");
        button.getFrontEndObjectStyle().setTextColor("white");
        button.getFrontEndObjectStyle().setTextSize(100, FrontEndLengthUnits.PX);
        button.getFrontEndObjectStyle().setTextFont("arial");

        //image coordinates for where in the box the picture should, be for 50% height, 50% width, ie centered.
        int[] imageCoordinates = new int[2];
        imageCoordinates[0] = 50;
        imageCoordinates[1] = 50;
        FrontEndObject image = FEOInterface.createBoxedImage("image", 50, FrontEndLengthUnits.PER, imageCoordinates, FrontEndLengthUnits.PER, "imagePath", styleInterface.getBoxedImage(), "two");

        //adds the button and image to mainscene
        mainScene.addFrontEndObject(button);
        mainScene.addFrontEndObject(image);

        //Create stringformatter to convert the frontendobject mainscene to css and html
        StringFormatter stringFormatter = new StringFormatter();

        //puts the output of the stringformatter formatting mainscene to css and html in to a string.
        String outputString = stringFormatter.getCSS(mainScene) + "\n" + stringFormatter.getHTML(mainScene);

        //functioninstructionListinterface has template lists that you can put data into to convert it to for example a textfile. This gets a string, and output adress and a fileformat and writes to disk. 
        functionInstructionListInterface functionInstructionListInterface = new functionInstructionListInterface(); 
        ListOfFunctionInstructions ListOfFunctionInstruction = functionInstructionListInterface.writeThisTextToAFile(outputString, mainScene.getOutputTo(), ".html");
        
        //Create a listrunner that creates a new thread, put the list in to it and then run the thread to perform the tasks.
        FunctionsInstructionListRunner listRunner = new FunctionsInstructionListRunner(ListOfFunctionInstruction);
        listRunner.run();
         
        }
        
        
        
        
        
        
        /*
        
        FrontEndObject twiceInsideBox = FEOInterface.createScene("box2", styleInterface.getBoxedImage());
        twiceInsideBox.setBackgroundColor("orange");
        twiceInsideBox.setGridArea("two");
        twiceInsideBox.setObjectType(FrontEndObjectTypes.BOXEDIMAGE);
        twiceInsideBox.setLinksTo("https://nypost.com/wp-content/uploads/sites/2/2017/03/shutterstock.jpg?quality=80&strip=all");
        twiceInsideBox.setBoxedImageSize(70, FrontEndLengthUnits.PER);
        int[] boxedImageCoordinates = new int[2];
        boxedImageCoordinates[0] = 0;
        boxedImageCoordinates[1] = 100;
        twiceInsideBox.setBoxedImageCoordinates(boxedImageCoordinates, FrontEndLengthUnits.PER);

        FrontEndObject twiceInsideBox2 = FEOInterface.createEmptyObject("box3");
        twiceInsideBox2.setBackgroundColor("grey");
        twiceInsideBox2.setGridArea("three");

        /*  FrontEndObject twiceInsideBox3 = FEOInterface.createContainer("box4", minMaxSize, 0, minMaxSize, 0, FrontEndLengthUnits.PX);
        twiceInsideBox3.setBackgroundColor("orange");
        twiceInsideBox3.setWidthHeight(50, FrontEndLengthUnits.PX, 500, FrontEndLengthUnits.PX);
        mainScene.addFrontEndObject(twiceInsideBox2);
        mainScene.addFrontEndObject(twiceInsideBox);
        mainScene.addFrontEndObject(insideBox);

        //Puts the frontendobject in to a string
        StringFormatter stringFormat = new StringFormatter(); // Responsible for formatting the string
        String printString = stringFormat.getCSS(mainScene) + "\n" + stringFormat.getHTML(mainScene);
        //System.out.println(stringFormat.getHTML2(mainScene));

        //Add printing that string as an instruction to a list to the desired output and file format
        //Create a new listrunner and put the list in it, then runs in new th
       

        /* ListOfFunctionInstructions tryList2 = new ListOfFunctionInstructions();
        tryList2.addFunctionsInstruction(helperConsole.getWFI().createFunctionStartWebGetter());
        tryList2.addFunctionsInstruction(helperConsole.WFI.createFunctionInstructionConnectToThisSite("C:\\Users\\Peter\\Documents\\NetBeansProjects\\WebScraper\\tes2t.html"));
        FunctionsInstructionListRunner listRunner2 = new FunctionsInstructionListRunner(tryList2);
        listRunner2.run();
        //Gets a WebPort and opens the html file outputted
        WebFunction wf = new WebFunction();
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
            
        }

        wf.closeWebPort();

    }*/

}


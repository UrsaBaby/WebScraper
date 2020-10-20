/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

/**
 *
 * @author Peter
 */
public class FrontEndObjectInterface {
    
    public FrontEndObject createContainer(String id, int[] columnMinMaxSize, int numberOfColumns, int[] rowMinMaxSize, int numberOfRows){
        FrontEndObject returnObject = new FrontEndObject(FrontEndTags.CONTAINER, id);
        returnObject.setDisplayType(FrontEndObjectDisplayTypes.GRID);
        returnObject.setAlign(AlignJustify.START);
        returnObject.setJustify(AlignJustify.START);
     
        returnObject.setColumns(FrontEndLengthUnits.PX, columnMinMaxSize, numberOfColumns);
        returnObject.setRows(FrontEndLengthUnits.PX, rowMinMaxSize, numberOfRows);
      //  returnObject.se
        return returnObject;      
    }
    
}

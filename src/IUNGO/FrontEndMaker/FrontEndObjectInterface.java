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
    
    public FrontEndObject createContainer(String id){
        FrontEndObject returnObject = new FrontEndObject(FrontEndTags.CONTAINER, id);
        returnObject.setDisplayType(FrontEndObjectDisplayTypes.GRID);
        returnObject.setAlign(AlignJustify.CENTER);
        returnObject.setJustify(AlignJustify.START);
      //  returnObject.se
        return returnObject;      
    }
    
}

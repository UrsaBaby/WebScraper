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
        FrontEndObject returnObject = new FrontEndObject(FrontEndObjectTypes.CONTAINER, id);
       
        returnObject.setAlign(AlignJustify.START);
        returnObject.setJustify(AlignJustify.START);
     

      //  returnObject.se
        return returnObject;      
    }
    
}

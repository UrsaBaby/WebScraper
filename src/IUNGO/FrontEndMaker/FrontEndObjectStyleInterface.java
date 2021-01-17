/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndLengthUnits;

/**
 *
 * @author Peter
 */
public class FrontEndObjectStyleInterface {

    public FrontEndObjectStyleInterface() {

    }

    public FrontEndObjectStyle getGenericButton() {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();

        return returnStyle;
    }

    public FrontEndObjectStyle getGenericBoxedImage() {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();

        return returnStyle;
    }

    public FrontEndObjectStyle getGenericEmptyObject() {
        FrontEndObjectStyle returnStyle = new FrontEndObjectStyle();

        return returnStyle;
    }
    
    public void setBoxedImageToThisSize(int size, FrontEndLengthUnits thisUnit, FrontEndObjectStyle thisStyleFile){
        
    }
}

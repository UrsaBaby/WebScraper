/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import IUNGO.FrontEndMaker.FrontEndMakerEnums.AlignJustify;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndLengthUnits;
import IUNGO.FrontEndMaker.FrontEndMakerEnums.FrontEndObjectTypes;

/**
 *
 * @author Peter
 */
public class FrontEndObjectInterface {

    public FrontEndObject createEmptyObject(String id) {
        FrontEndObject returnObject = new FrontEndObject(FrontEndObjectTypes.CONTAINER, id);

        returnObject.setAlign(AlignJustify.START);
        returnObject.setJustify(AlignJustify.START);

        //  returnObject.se
        return returnObject;
    }

    public FrontEndObject createBoxedImage(String id, int imageSize, FrontEndLengthUnits imageSizeUnit, int[] imageCoordinates, FrontEndLengthUnits imageCoordinateUnit, String imagePath) {
        FrontEndObject returnObject = new FrontEndObject(FrontEndObjectTypes.BOXEDIMAGE, id);
        returnObject.setBoxedImageSize(imageSize, imageSizeUnit);
        returnObject.setBoxedImageCoordinates(imageCoordinates, imageCoordinateUnit);
        returnObject.setLinksTo(imagePath);
        return returnObject;
    }
    
    public FrontEndObject createButton(String id, String linksTo){
        FrontEndObject returnObject = new FrontEndObject(FrontEndObjectTypes.BUTTON, id);
        return returnObject;
    }

}

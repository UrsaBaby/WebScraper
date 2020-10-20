/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Peter
 */
public class FrontEndScene {
    HashMap<String,ArrayList<FrontEndObject>> sceneMap;
    
    
    public FrontEndScene(){
  
    }
    
    public void addFrontEndObjectWithThisParent(String parentId, ArrayList<FrontEndObject> feosToAdd){
        if(!isSceneMapInitiated()){
            this.initiateSceneMap();
        }
        this.sceneMap.put(parentId, feosToAdd );
    }
    
    //
    public HashMap<String, ArrayList<FrontEndObject>> getSceneMap(){
        return this.sceneMap;
    }
    
    //
    private boolean isSceneMapInitiated(){
        if(sceneMap == null){
            return false;
        }
        return true;
    }
    
    private void initiateSceneMap(){
        this.sceneMap = new HashMap<>();
    }
    
    
    
    
    
}

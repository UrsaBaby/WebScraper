/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker.FrontEndMakerEnums;

/**
 *
 * @author Peter
 */
public enum BackgroundImageRepeatEnum {
    REPEAT,
    REPEATX{
          public String toString(){
              return "REPEAT-X";
          }
    },
    REPEATY{
          public String toString(){
              return "REPEAT-Y";
          }
    },
    NOREPEAT{
          public String toString(){
              return "NO-REPEAT";
          }
    },
    SPACE,
    ROUND,
    INITIAL,
    INHERIT
    
}

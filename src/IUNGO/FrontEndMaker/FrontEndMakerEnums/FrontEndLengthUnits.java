/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUNGO.FrontEndMaker.FrontEndMakerEnums;

import com.google.common.net.PercentEscaper;

/**
 *
 * @author Peter
 */
public enum FrontEndLengthUnits {
    FR,
    CM,
    PX,
    EM,
    PER{
          public String toString(){
              return "%";
          }
    },
    
    
    
}

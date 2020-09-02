/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.MainEnd.ports.FilePort.Interface;

import java.io.IOException;

import webscraper.MainEnd.ports.FilePort.Interface.FilePort.FilePort;
import webscraper.MainEnd.ports.FilePort.Interface.FilePort.FilePort;

/**
 *
 * @author Peter
 */
public class FilePortInterface {

    FilePort filePort;

    public FilePortInterface() throws IOException {
        filePort = new FilePort();
    }

    public FilePort getFilePort() {
        return this.filePort;
    }
}

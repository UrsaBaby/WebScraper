/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper.interfaces;

import java.io.IOException;

import webscraper.structures.Handlers.FilePorting.FilePort;

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

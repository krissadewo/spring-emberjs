/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.demo.crude;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppCore {

    public static Logger getLogger(Object o) {
        return LoggerFactory.getLogger(o.getClass());
    }
}

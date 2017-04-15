/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.demo.crude.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    /**
     * Converting entity object to json value with specific format
     *
     * @param data
     * @param status
     * @return
     */
    protected Map<String, Object> convertModel(Object data, Object status) {
        Map<String, Object> model = new HashMap<>();
        model.put("data", data);
        model.put("status", status);
        return model;
    }

    protected Map<String, Object> convertModel(Object data, Object rows, Object status) {
        Map<String, Object> model = new HashMap<>();
        model.put("data", data);
        model.put("rows", rows);
        model.put("status", status);
        return model;
    }

    /**
     * @param data
     * @return
     */
    protected Map<String, Object> convertModel(Object data) {
        Map<String, Object> model = new HashMap<>();
        model.put("data", data);
        return model;
    }

    /**
     * Converting entity object to json value with specific format
     *
     * @param status
     * @return
     */
    protected Map<String, Object> convertModel(String status) {
        Map<String, Object> model = new HashMap();
        model.put("data", status);
        return model;
    }

}

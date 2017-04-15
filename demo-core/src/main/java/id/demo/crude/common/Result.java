/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.demo.crude.common;


import id.demo.crude.entity.Kabupaten;

import java.io.Serializable;

public class Result implements Serializable {

    public static final String SAVE_SUCCESS = "0010";
    public static final String SAVE_DATA_EXIST = "0011";
    public static final String DELETE_SUCCESS = "0014";
    public static final String UPLOAD_FAILED = "0016";
    public static final String SYSTEM_EXCEPTION = "0019";
    public static final String DB_EXCEPTION = "0020";

    private static final long serialVersionUID = -6811456395579116710L;
    private int id;
    private String message;
    private Kabupaten kabupaten;

    public Result() {
    }

    public Result(String message) {
        this.message = message;
    }

    public Result(String message, Integer id) {
        this.message = message;
        this.id = id;
    }

    public Result(String message, Kabupaten kabupaten) {
        this.message = message;
        this.kabupaten = kabupaten;
    }

    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}

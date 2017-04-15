package id.demo.crude.controller;

import id.demo.crude.entity.Provinsi;
import id.demo.crude.service.ProvinsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProvinsiController extends BaseController {

    @Autowired
    private ProvinsiService service;

    @RequestMapping(method = RequestMethod.GET, value = "provinsis")
    public Map<String, Object> find(@RequestParam(required = false) Integer offset,
                                    @RequestParam(required = false) Integer limit) {
        if (offset == null) {
            offset = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

        return convertModel(service.find(new Provinsi(), offset, limit), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "provinsis/count")
    public Map<String, Object> count() {
        return convertModel(service.count(new Provinsi()), HttpStatus.OK);
    }
}

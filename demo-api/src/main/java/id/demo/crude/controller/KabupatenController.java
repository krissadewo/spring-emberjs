package id.demo.crude.controller;

import id.demo.crude.entity.Kabupaten;
import id.demo.crude.service.KabupatenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class KabupatenController extends BaseController {

    @Autowired
    private KabupatenService service;

    @RequestMapping(method = RequestMethod.GET, value = "kabupatens")
    public Map<String, Object> find(@RequestParam(required = false) Integer offset,
                                    @RequestParam(required = false) Integer limit) {
        if (offset == null) {
            offset = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

        return convertModel(service.find(new Kabupaten(), offset, limit), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "kabupatens/count")
    public Map<String, Object> count() {
        return convertModel(service.count(new Kabupaten()), HttpStatus.OK);
    }

    @RequestMapping(value = "kabupatens", method = RequestMethod.POST)
    public Map<String, Object> save(@RequestBody Kabupaten kabupaten) {
        return convertModel(null, service.save(kabupaten).getMessage());
    }

    @RequestMapping(value = "kabupatens/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable Integer id) {
        return convertModel(null, service.delete(new Kabupaten(id)).getMessage());
    }

}

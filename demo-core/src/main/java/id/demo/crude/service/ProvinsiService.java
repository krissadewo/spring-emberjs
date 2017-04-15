package id.demo.crude.service;

import id.demo.crude.common.Result;
import id.demo.crude.entity.Provinsi;
import id.demo.crude.dao.ProvinsiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinsiService implements BaseService<Provinsi> {

    @Autowired
    private ProvinsiDAO provinsiDAO;

    @Override
    public Result save(Provinsi entity) {
        return null;
    }

    @Override
    public Result delete(Provinsi entity) {
        return null;
    }

    @Override
    public Provinsi findById(int id) {
        return null;
    }

    @Override
    public List<Provinsi> find(Provinsi param, int offset, int limit) {
        return provinsiDAO.find(param, offset, limit);
    }

    @Override
    public int count(Provinsi param) {
        return provinsiDAO.count(param);
    }
}

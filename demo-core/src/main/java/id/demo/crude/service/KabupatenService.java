package id.demo.crude.service;

import id.demo.crude.entity.Kabupaten;
import id.demo.crude.common.Result;
import id.demo.crude.dao.KabupatenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KabupatenService implements BaseService<Kabupaten> {

    @Autowired
    private KabupatenDAO kabupatenDAO;

    @Override
    @Transactional
    public Result save(Kabupaten entity) {
        if (entity.getId() == 0) {
            kabupatenDAO.save(entity);
        } else {
            kabupatenDAO.update(entity);
        }

        return null;
    }

    @Override
    @Transactional
    public Result delete(Kabupaten entity) {
        kabupatenDAO.delete(entity);
        return null;
    }

    @Override
    public Kabupaten findById(int id) {
        return null;
    }

    @Override
    public List<Kabupaten> find(Kabupaten param, int offset, int limit) {
        return kabupatenDAO.find(param, offset, limit);
    }

    @Override
    public int count(Kabupaten param) {
        return kabupatenDAO.count(param);
    }
}

package id.demo.crude.dao.impl;

import id.demo.crude.dao.ProvinsiDAO;
import id.demo.crude.entity.Provinsi;
import id.demo.crude.util.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProvinsiDAOImpl implements ProvinsiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Provinsi save(Provinsi entity) {
        return null;
    }

    @Override
    public Provinsi update(Provinsi entity) {
        return null;
    }

    @Override
    public Provinsi delete(Provinsi entity) {
        return null;
    }

    @Override
    public Provinsi findById(int id) {
        return null;
    }

    @Override
    public List<Provinsi> find(Provinsi param, int offset, int limit) {
        String sql = "SELECT * FROM " + Table.MASTER_PROVINSI;
        return jdbcTemplate.query(sql, new ProvinsiRowMapper());
    }

    @Override
    public int count(Provinsi param) {
        String sql = "SELECT COUNT(id) FROM " + Table.MASTER_PROVINSI;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    private class ProvinsiRowMapper implements RowMapper<Provinsi> {

        @Override
        public Provinsi mapRow(ResultSet rs, int i) throws SQLException {
            Provinsi provinsi = new Provinsi();
            provinsi.setId(rs.getInt("id"));
            provinsi.setKode(rs.getString("kode"));
            provinsi.setNama(rs.getString("nama"));
            return provinsi;
        }
    }
}

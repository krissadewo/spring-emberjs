package id.demo.crude.dao.impl;

import id.demo.crude.dao.KabupatenDAO;
import id.demo.crude.entity.Kabupaten;
import id.demo.crude.entity.Provinsi;
import id.demo.crude.util.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class KabupatenDAOImpl implements KabupatenDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Kabupaten save(Kabupaten entity) {
        String sql = "INSERT INTO " + Table.MASTER_KABUPATEN + " (" +
                "id_provinsi," +
                "kode," +
                "nama) " +
                "VALUES(?,?,?) ";

        jdbcTemplate.update(sql,
                entity.getProvinsi().getId(),
                entity.getKode(),
                entity.getNama());
        return entity;
    }

    @Override
    public Kabupaten update(Kabupaten entity) {
        String sql = "UPDATE " + Table.MASTER_KABUPATEN + " SET " +
                "id_provinsi = ?," +
                "kode = ?," +
                "nama = ? " +
                "WHERE id = ? ";

        jdbcTemplate.update(sql,
                entity.getProvinsi().getId(),
                entity.getKode(),
                entity.getNama(),
                entity.getId());

        return entity;
    }

    @Override
    public Kabupaten delete(Kabupaten entity) {
        String sql = "DELETE FROM " + Table.MASTER_KABUPATEN + " WHERE id = ? ";
        jdbcTemplate.update(sql, entity.getId());
        return entity;
    }

    @Override
    public Kabupaten findById(int id) {
        return null;
    }

    @Override
    public List<Kabupaten> find(Kabupaten param, int offset, int limit) {
        String sql = "SELECT " +
                "kabupaten.*," +
                "provinsi.nama AS nama_provinsi " +
                "FROM " + Table.MASTER_KABUPATEN + " kabupaten " +
                "INNER JOIN " + Table.MASTER_PROVINSI + " provinsi ON provinsi.id = kabupaten.id_provinsi ";

        List<Object> params = new ArrayList<>();
        params.add(offset);
        params.add(limit);
        sql += "LIMIT ?,? ";
        return jdbcTemplate.query(sql, params.toArray(), new KabupatenRowMapper());
    }

    @Override
    public int count(Kabupaten param) {
        String sql = "SELECT COUNT(kabupaten.id) FROM " + Table.MASTER_KABUPATEN + " kabupaten " +
                "INNER JOIN " + Table.MASTER_PROVINSI + " provinsi ON provinsi.id = kabupaten.id_provinsi ";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    private class KabupatenRowMapper implements RowMapper<Kabupaten> {

        @Override
        public Kabupaten mapRow(ResultSet rs, int i) throws SQLException {
            Provinsi provinsi = new Provinsi();
            provinsi.setId(rs.getInt("id_provinsi"));
            provinsi.setNama(rs.getString("nama_provinsi"));

            Kabupaten kabupaten = new Kabupaten();
            kabupaten.setId(rs.getInt("id"));
            kabupaten.setKode(rs.getString("kode"));
            kabupaten.setNama(rs.getString("nama"));
            kabupaten.setProvinsi(provinsi);
            return kabupaten;
        }
    }
}

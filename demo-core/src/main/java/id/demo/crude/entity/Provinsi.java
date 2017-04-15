package id.demo.crude.entity;

public class Provinsi extends Negara {

    public Provinsi() {
        super();
    }

    public Provinsi(int id) {
        super(id);
    }

    public Provinsi(String kode) {
        super(kode);
    }

    public Provinsi(String kode, String nama) {
        super(kode, nama);
    }

    @Override
    public String toString() {
        return "Provinsi{" +
                '}';
    }
}

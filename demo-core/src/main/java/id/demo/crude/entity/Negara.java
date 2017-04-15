package id.demo.crude.entity;

public class Negara {

    private int id;
    private String kode;
    private String nama;

    public Negara() {
    }

    public Negara(int id) {
        this.id = id;
    }

    public Negara(String kode) {
        this.kode = kode;
    }

    public Negara(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Negara{" +
                "kode='" + kode + '\'' +
                ", nama='" + nama + '\'' +
                '}';
    }
}

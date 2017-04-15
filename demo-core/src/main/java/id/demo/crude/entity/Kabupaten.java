package id.demo.crude.entity;

public class Kabupaten extends Provinsi {

    private Provinsi provinsi;

    public Kabupaten() {
        super();
    }

    public Kabupaten(int id) {
        super(id);
    }

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    @Override
    public String toString() {
        return "Kabupaten{" +
                "provinsi=" + provinsi +
                '}';
    }
}

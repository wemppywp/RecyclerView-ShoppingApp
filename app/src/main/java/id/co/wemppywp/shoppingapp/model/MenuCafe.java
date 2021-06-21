package id.co.wemppywp.shoppingapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cafe_table")
public class MenuCafe {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nama;
    private String harga;
    private String foto;

    public MenuCafe(String nama, String harga, String foto) {
        this.nama = nama;
        this.harga = harga;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}


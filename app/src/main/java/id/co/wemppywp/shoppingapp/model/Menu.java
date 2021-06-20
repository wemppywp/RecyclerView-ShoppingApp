package id.co.wemppywp.shoppingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {

    private String nama;
    private int harga;
    private String foto;

    protected Menu(Parcel parcel) {
        nama = parcel.readString();
        harga = parcel.readInt();
        foto = parcel.readString();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeInt(harga);
        parcel.writeString(foto);
    }
}


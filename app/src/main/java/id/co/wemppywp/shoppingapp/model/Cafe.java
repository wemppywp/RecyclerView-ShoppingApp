package id.co.wemppywp.shoppingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Cafe implements Parcelable {

    private String nama;
    private String alamat;
    private String image;
    private List<Menu> menus;


    protected Cafe(Parcel in) {
        nama = in.readString();
        alamat = in.readString();
        image = in.readString();
        menus = in.createTypedArrayList(Menu.CREATOR);
    }

    public static final Creator<Cafe> CREATOR = new Creator<Cafe>() {
        @Override
        public Cafe createFromParcel(Parcel in) {
            return new Cafe(in);
        }

        @Override
        public Cafe[] newArray(int size) {
            return new Cafe[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(alamat);
        parcel.writeString(image);
        parcel.writeTypedList(menus);
    }
}


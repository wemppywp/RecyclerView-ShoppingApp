package id.co.wemppywp.shoppingapp.utilities;

public class Singleton {

    private static Singleton mInstance = null;
    private String mString;
    private Singleton(){
        //contoh username setelah login menggunakan singleton untuk dipakai dalam beberapa activity
        mString = "Wemppywp";
    }
    public static Singleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new Singleton();
        }
        return mInstance;
    }
    public String getUser(){
        return this.mString;
    }

}

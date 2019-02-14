package be.ehb.mopapp.model;

import android.widget.TextView;

public class Mop {

    private String mop, clou;

    public Mop() {
    }

    public Mop(String mop, String clou) {
        this.mop = mop;
        this.clou = clou;
    }

    public String getMop() {
        return mop;
    }

    public void setMop(String mop) {
        this.mop = mop;
    }

    public String getClou() {
        return clou;
    }

    public void setClou(String clou) {
        this.clou = clou;
    }
}

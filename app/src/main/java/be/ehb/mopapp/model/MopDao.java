package be.ehb.mopapp.model;

import java.util.ArrayList;

public class MopDao {
    private static final MopDao ourInstance = new MopDao();
    private ArrayList<Mop> mopLijst = new ArrayList<>();

    public static MopDao getInstance() {

        return ourInstance;
    }

    private MopDao() {
        mopLijst.add(new Mop("Het is oud en het vliegt", "Een bejaardelaar"));
        mopLijst.add(new Mop("Het is rood en vliegt door de klas","Een ongestelde vraag"));
        mopLijst.add(new Mop("Het is geel en weegt niet veel","Lichtgeel"));
        mopLijst.add(new Mop("Het is orangje en als regent is het weg","De mannen van de gemeente"));
        mopLijst.add(new Mop("Het is zwart en als het uit de boom valt is uw stoof kapot","Uw stoof"));
    }

    public ArrayList<Mop> getMopLijst() {
        return mopLijst;
    }

    //add methode tovoegen
    public void addMop(Mop nieuweMop){
        mopLijst.add(nieuweMop);
    }}

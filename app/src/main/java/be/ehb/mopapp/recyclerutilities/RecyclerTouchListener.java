package be.ehb.mopapp.recyclerutilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
    //nodig om in de activity te laten invullen
    public interface ClickListener {
        void  OnClick(View view, int position);
    }

    //listener is een verwijzing naar listener in de activity
    private ClickListener clickListener;
    private GestureDetector gestureDetector;
//constuctor
    public RecyclerTouchListener(Context context, ClickListener clickListener) {
        this.clickListener = clickListener;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener());
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
       //wat staat er op coordinaat x,y in de recycler
        //coordinaat van waar een vinger het scherm raakt
        View rij = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

      //action, welk soort aanraking -> enkel down opvangen, vinger neer op het scherm
        if (rij!= null && motionEvent.getAction() == MotionEvent.ACTION_UP){
            //method uitvoeren, dit stuurt dan daar naar activity
            clickListener.OnClick(rij, recyclerView.getChildAdapterPosition(rij));
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}

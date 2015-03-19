package com.sqlweb.kittericpc3.actionbartTransparentScroll;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ScrollView;
public class MainActivity extends Activity {
    private Drawable ActionBarBackgroundDrawable;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBarBackgroundDrawable = getResources().getDrawable(R.drawable.abc_ab_bottom_solid_light_holo);
        ActionBarBackgroundDrawable.setAlpha(0);
        getActionBar().setBackgroundDrawable(ActionBarBackgroundDrawable);
        ((NotifyingScrollView) findViewById(R.id.scroll_view)).setOnScrollChangedListener(ScrollChangedListener);
    }

    private NotifyingScrollView.OnScrollChangedListener ScrollChangedListener = new NotifyingScrollView.OnScrollChangedListener() {
        public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
            final int imageheaderHeight = findViewById(R.id.image_header).getHeight() - getActionBar().getHeight();
            final float ratio = (float) Math.min(Math.max(t, 0), imageheaderHeight) / imageheaderHeight;
            final int newAlpha = (int) (ratio * 255);
            ActionBarBackgroundDrawable.setAlpha(newAlpha);
        }
    };
    private Drawable.Callback DrawableCallback = new Drawable.Callback() {
        @Override
        public void invalidateDrawable(Drawable who) {
            getActionBar().setBackgroundDrawable(who);
        }
        @Override
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
        }
        @Override
        public void unscheduleDrawable(Drawable who, Runnable what) {
        }
    };

}
package com.sqlweb.kittericpc3.actionbartTransparentScroll;

/**
 * Created by Cristiana214 on 8/20/14.
 */

import android.content.Context;
        import android.util.AttributeSet;
        import android.widget.ScrollView;

public class NotifyingScrollView extends ScrollView {

    /**
     * @author Cyril Mottier
     */
    public interface OnScrollChangedListener {
        void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt);
    }

    private OnScrollChangedListener ScrollChangedListener;

    public NotifyingScrollView(Context context) {
        super(context);
    }

    public NotifyingScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NotifyingScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (ScrollChangedListener!= null) {
            ScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }
    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
       ScrollChangedListener = listener;
    }

}
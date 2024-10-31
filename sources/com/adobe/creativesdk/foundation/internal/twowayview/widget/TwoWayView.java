package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import c.a.a.a.b.j;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public class TwoWayView extends RecyclerView {
    private static final Class<?>[] Ia = {Context.class, AttributeSet.class};
    final Object[] Ja;

    public TwoWayView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet, String str) {
        try {
            int indexOf = str.indexOf(46);
            if (indexOf == -1) {
                str = "com.adobe.creativesdk.foundation.internal.twowayview.widget." + str;
            } else if (indexOf == 0) {
                str = context.getPackageName() + "." + str;
            }
            Constructor constructor = context.getClassLoader().loadClass(str).asSubclass(TwoWayLayoutManager.class).getConstructor(Ia);
            this.Ja[0] = context;
            this.Ja[1] = attributeSet;
            setLayoutManager((RecyclerView.LayoutManager) constructor.newInstance(this.Ja));
        } catch (Exception e2) {
            throw new IllegalStateException("Could not load TwoWayLayoutManager from class: " + str, e2);
        }
    }

    public int getFirstVisiblePosition() {
        return ((TwoWayLayoutManager) getLayoutManager()).e();
    }

    public int getLastVisiblePosition() {
        return ((TwoWayLayoutManager) getLayoutManager()).f();
    }

    public TwoWayLayoutManager.Orientation getOrientation() {
        return ((TwoWayLayoutManager) getLayoutManager()).getOrientation();
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof TwoWayLayoutManager) {
            super.setLayoutManager(layoutManager);
            return;
        }
        throw new IllegalArgumentException("TwoWayView can only use TwoWayLayoutManager subclasses as its layout manager");
    }

    public void setOrientation(TwoWayLayoutManager.Orientation orientation) {
        ((TwoWayLayoutManager) getLayoutManager()).a(orientation);
    }

    public TwoWayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoWayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ja = new Object[2];
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.adobe_csdk_twowayview_TwoWayView, i, 0);
        String string = obtainStyledAttributes.getString(j.adobe_csdk_twowayview_TwoWayView_adobe_csdk_twowayview_layoutManager);
        if (!TextUtils.isEmpty(string)) {
            a(context, attributeSet, string);
        }
        obtainStyledAttributes.recycle();
    }
}

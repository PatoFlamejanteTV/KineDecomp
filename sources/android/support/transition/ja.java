package android.support.transition;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.Property;
import android.view.View;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
class ja extends Property<View, Rect> {
    public ja(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Rect get(View view) {
        return ViewCompat.getClipBounds(view);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(View view, Rect rect) {
        ViewCompat.setClipBounds(view, rect);
    }
}

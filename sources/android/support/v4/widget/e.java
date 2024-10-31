package android.support.v4.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/* compiled from: PopupWindowCompat.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    static final c f114a;

    /* compiled from: PopupWindowCompat.java */
    /* loaded from: classes.dex */
    interface c {
        void a(PopupWindow popupWindow, View view, int i, int i2, int i3);
    }

    /* compiled from: PopupWindowCompat.java */
    /* loaded from: classes.dex */
    static class a implements c {
        a() {
        }

        @Override // android.support.v4.widget.e.c
        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2);
        }
    }

    /* compiled from: PopupWindowCompat.java */
    /* loaded from: classes.dex */
    static class b extends a {
        b() {
        }

        @Override // android.support.v4.widget.e.a, android.support.v4.widget.e.c
        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            f.a(popupWindow, view, i, i2, i3);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f114a = new b();
        } else {
            f114a = new a();
        }
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f114a.a(popupWindow, view, i, i2, i3);
    }
}

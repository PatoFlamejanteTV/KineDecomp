package android.support.v4.g;

import android.os.Build;
import android.view.MotionEvent;

/* compiled from: MotionEventCompat.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    static final e f96a;

    /* compiled from: MotionEventCompat.java */
    /* loaded from: classes.dex */
    interface e {
    }

    /* compiled from: MotionEventCompat.java */
    /* loaded from: classes.dex */
    static class a implements e {
        a() {
        }
    }

    /* compiled from: MotionEventCompat.java */
    /* loaded from: classes.dex */
    static class b extends a {
        b() {
        }
    }

    /* compiled from: MotionEventCompat.java */
    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }
    }

    /* compiled from: MotionEventCompat.java */
    /* loaded from: classes.dex */
    static class d extends c {
        d() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            f96a = new d();
            return;
        }
        if (Build.VERSION.SDK_INT >= 9) {
            f96a = new c();
        } else if (Build.VERSION.SDK_INT >= 5) {
            f96a = new b();
        } else {
            f96a = new a();
        }
    }

    public static int a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }
}

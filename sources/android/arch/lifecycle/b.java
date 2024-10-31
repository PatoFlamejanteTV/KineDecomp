package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

/* compiled from: FullLifecycleObserverAdapter.java */
/* loaded from: classes.dex */
/* synthetic */ class b {

    /* renamed from: a */
    static final /* synthetic */ int[] f38a = new int[Lifecycle.Event.values().length];

    static {
        try {
            f38a[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f38a[Lifecycle.Event.ON_START.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f38a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f38a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f38a[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f38a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f38a[Lifecycle.Event.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}

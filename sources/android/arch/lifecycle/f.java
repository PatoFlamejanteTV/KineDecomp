package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;

/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
/* synthetic */ class f {

    /* renamed from: a */
    static final /* synthetic */ int[] f39a;

    /* renamed from: b */
    static final /* synthetic */ int[] f40b = new int[Lifecycle.State.values().length];

    static {
        try {
            f40b[Lifecycle.State.INITIALIZED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f40b[Lifecycle.State.CREATED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f40b[Lifecycle.State.STARTED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f40b[Lifecycle.State.RESUMED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f40b[Lifecycle.State.DESTROYED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f39a = new int[Lifecycle.Event.values().length];
        try {
            f39a[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f39a[Lifecycle.Event.ON_STOP.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f39a[Lifecycle.Event.ON_START.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f39a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f39a[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f39a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f39a[Lifecycle.Event.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused12) {
        }
    }
}

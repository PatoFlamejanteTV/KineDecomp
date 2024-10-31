package de.greenrobot.event;

/* compiled from: EventBus.java */
/* loaded from: classes3.dex */
/* synthetic */ class d {

    /* renamed from: a */
    static final /* synthetic */ int[] f26674a = new int[ThreadMode.values().length];

    static {
        try {
            f26674a[ThreadMode.PostThread.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f26674a[ThreadMode.MainThread.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f26674a[ThreadMode.BackgroundThread.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f26674a[ThreadMode.Async.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

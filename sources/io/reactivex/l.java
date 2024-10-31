package io.reactivex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Observable.java */
/* loaded from: classes3.dex */
public /* synthetic */ class l {

    /* renamed from: a */
    static final /* synthetic */ int[] f28487a = new int[BackpressureStrategy.values().length];

    static {
        try {
            f28487a[BackpressureStrategy.DROP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f28487a[BackpressureStrategy.LATEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f28487a[BackpressureStrategy.MISSING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f28487a[BackpressureStrategy.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

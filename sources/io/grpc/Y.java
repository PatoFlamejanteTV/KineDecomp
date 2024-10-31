package io.grpc;

/* compiled from: PickFirstBalancerFactory.java */
/* loaded from: classes3.dex */
/* synthetic */ class Y {

    /* renamed from: a */
    static final /* synthetic */ int[] f27143a = new int[ConnectivityState.values().length];

    static {
        try {
            f27143a[ConnectivityState.CONNECTING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f27143a[ConnectivityState.READY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f27143a[ConnectivityState.IDLE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f27143a[ConnectivityState.TRANSIENT_FAILURE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

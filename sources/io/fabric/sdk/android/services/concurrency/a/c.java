package io.fabric.sdk.android.services.concurrency.a;

/* compiled from: ExponentialBackoff.java */
/* loaded from: classes3.dex */
public class c implements a {

    /* renamed from: a */
    private final long f26945a;

    /* renamed from: b */
    private final int f26946b;

    public c(long j, int i) {
        this.f26945a = j;
        this.f26946b = i;
    }

    @Override // io.fabric.sdk.android.services.concurrency.a.a
    public long getDelayMillis(int i) {
        double d2 = this.f26945a;
        double pow = Math.pow(this.f26946b, i);
        Double.isNaN(d2);
        return (long) (d2 * pow);
    }
}

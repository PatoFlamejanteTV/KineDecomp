package io.fabric.sdk.android.services.concurrency.a;

/* compiled from: RetryState.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a */
    private final int f26947a;

    /* renamed from: b */
    private final a f26948b;

    /* renamed from: c */
    private final d f26949c;

    public e(a aVar, d dVar) {
        this(0, aVar, dVar);
    }

    public long a() {
        return this.f26948b.getDelayMillis(this.f26947a);
    }

    public e b() {
        return new e(this.f26948b, this.f26949c);
    }

    public e c() {
        return new e(this.f26947a + 1, this.f26948b, this.f26949c);
    }

    public e(int i, a aVar, d dVar) {
        this.f26947a = i;
        this.f26948b = aVar;
        this.f26949c = dVar;
    }
}

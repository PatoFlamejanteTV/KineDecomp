package com.google.firebase.database.core.utilities;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class OffsetClock implements Clock {

    /* renamed from: a */
    private final Clock f17057a;

    /* renamed from: b */
    private long f17058b;

    public OffsetClock(Clock clock, long j) {
        this.f17058b = 0L;
        this.f17057a = clock;
        this.f17058b = j;
    }

    public void a(long j) {
        this.f17058b = j;
    }

    @Override // com.google.firebase.database.core.utilities.Clock
    public long a() {
        return this.f17057a.a() + this.f17058b;
    }
}

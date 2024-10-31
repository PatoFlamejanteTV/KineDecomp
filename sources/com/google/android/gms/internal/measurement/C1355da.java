package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.da */
/* loaded from: classes2.dex */
public final class C1355da extends AbstractC1361fa {

    /* renamed from: a */
    private int f13435a = 0;

    /* renamed from: b */
    private final int f13436b;

    /* renamed from: c */
    private final /* synthetic */ zzte f13437c;

    public C1355da(zzte zzteVar) {
        this.f13437c = zzteVar;
        this.f13436b = this.f13437c.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13435a < this.f13436b;
    }

    @Override // com.google.android.gms.internal.measurement.zztl
    public final byte nextByte() {
        int i = this.f13435a;
        if (i < this.f13436b) {
            this.f13435a = i + 1;
            return this.f13437c.zzan(i);
        }
        throw new NoSuchElementException();
    }
}

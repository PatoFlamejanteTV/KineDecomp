package com.google.android.gms.internal.gtm;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.gtm.ba */
/* loaded from: classes2.dex */
public final class C1293ba extends AbstractC1299da {

    /* renamed from: a */
    private int f13206a = 0;

    /* renamed from: b */
    private final int f13207b;

    /* renamed from: c */
    private final /* synthetic */ zzps f13208c;

    public C1293ba(zzps zzpsVar) {
        this.f13208c = zzpsVar;
        this.f13207b = this.f13208c.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13206a < this.f13207b;
    }

    @Override // com.google.android.gms.internal.gtm.zzpz
    public final byte nextByte() {
        int i = this.f13206a;
        if (i < this.f13207b) {
            this.f13206a = i + 1;
            return this.f13208c.zzal(i);
        }
        throw new NoSuchElementException();
    }
}

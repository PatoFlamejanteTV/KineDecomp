package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.clearcut.q */
/* loaded from: classes2.dex */
public final class C1219q implements Iterator {

    /* renamed from: a */
    private int f12879a = 0;

    /* renamed from: b */
    private final int f12880b;

    /* renamed from: c */
    private final /* synthetic */ zzbb f12881c;

    public C1219q(zzbb zzbbVar) {
        this.f12881c = zzbbVar;
        this.f12880b = this.f12881c.size();
    }

    private final byte nextByte() {
        try {
            zzbb zzbbVar = this.f12881c;
            int i = this.f12879a;
            this.f12879a = i + 1;
            return zzbbVar.zzj(i);
        } catch (IndexOutOfBoundsException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12879a < this.f12880b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.ads.wh */
/* loaded from: classes2.dex */
public final class C1139wh implements zzbqa {

    /* renamed from: a */
    private int f12627a = 0;

    /* renamed from: b */
    private final int f12628b;

    /* renamed from: c */
    private final /* synthetic */ zzbpu f12629c;

    public C1139wh(zzbpu zzbpuVar) {
        this.f12629c = zzbpuVar;
        this.f12628b = this.f12629c.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12627a < this.f12628b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Byte next() {
        return Byte.valueOf(nextByte());
    }

    @Override // com.google.android.gms.internal.ads.zzbqa
    public final byte nextByte() {
        try {
            zzbpu zzbpuVar = this.f12629c;
            int i = this.f12627a;
            this.f12627a = i + 1;
            return zzbpuVar.zzem(i);
        } catch (IndexOutOfBoundsException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

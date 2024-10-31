package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzho extends zzhj {
    public long zzago;
    public ByteBuffer zzdd;
    public final zzhk zzagn = new zzhk();
    private final int zzagp = 0;

    public zzho(int i) {
    }

    private final ByteBuffer zzt(int i) {
        ByteBuffer byteBuffer = this.zzdd;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzdd;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean zzdt() {
        return zzr(1073741824);
    }

    public final void zzs(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzdd;
        if (byteBuffer != null) {
            int capacity = byteBuffer.capacity();
            int position = this.zzdd.position() + i;
            if (capacity >= position) {
                return;
            }
            zzt(position);
            throw null;
        }
        zzt(i);
        throw null;
    }
}

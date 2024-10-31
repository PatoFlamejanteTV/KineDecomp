package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

@zzark
/* renamed from: com.google.android.gms.internal.ads.mf */
/* loaded from: classes2.dex */
final class C0998mf implements zzbwa {

    /* renamed from: a */
    private final ByteBuffer f12327a;

    public C0998mf(ByteBuffer byteBuffer) {
        this.f12327a = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zzbwa, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final long position() throws IOException {
        return this.f12327a.position();
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f12327a.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.f12327a.remaining());
        byte[] bArr = new byte[min];
        this.f12327a.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final long size() throws IOException {
        return this.f12327a.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final void zzaw(long j) throws IOException {
        this.f12327a.position((int) j);
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final ByteBuffer zzk(long j, long j2) throws IOException {
        int position = this.f12327a.position();
        this.f12327a.position((int) j);
        ByteBuffer slice = this.f12327a.slice();
        slice.limit((int) j2);
        this.f12327a.position(position);
        return slice;
    }
}

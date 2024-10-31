package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzbg extends zzbvv {
    private ByteBuffer zzdd;

    public zzbg(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzg(ByteBuffer byteBuffer) {
        this.zzdd = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}

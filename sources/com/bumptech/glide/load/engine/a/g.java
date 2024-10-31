package com.bumptech.glide.load.engine.a;

/* compiled from: ByteArrayAdapter.java */
/* loaded from: classes.dex */
public final class g implements a<byte[]> {
    @Override // com.bumptech.glide.load.engine.a.a
    public int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public String getTag() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public byte[] newArray(int i) {
        return new byte[i];
    }
}

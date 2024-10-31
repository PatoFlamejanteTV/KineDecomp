package com.android.volley.a;

import java.util.Comparator;

/* compiled from: ByteArrayPool.java */
/* loaded from: classes.dex */
class c implements Comparator<byte[]> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }
}

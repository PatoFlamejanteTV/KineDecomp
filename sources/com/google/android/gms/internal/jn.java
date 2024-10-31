package com.google.android.gms.internal;

import java.util.Comparator;

/* loaded from: classes.dex */
final class jn implements Comparator<byte[]> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }
}

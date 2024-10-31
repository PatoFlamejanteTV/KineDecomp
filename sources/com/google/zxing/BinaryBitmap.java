package com.google.zxing;

import com.google.zxing.common.BitMatrix;

/* loaded from: classes2.dex */
public final class BinaryBitmap {

    /* renamed from: a */
    private final Binarizer f18941a;

    /* renamed from: b */
    private BitMatrix f18942b;

    public BitMatrix a() throws NotFoundException {
        if (this.f18942b == null) {
            this.f18942b = this.f18941a.a();
        }
        return this.f18942b;
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}

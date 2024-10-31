package com.google.zxing;

import com.google.zxing.common.BitMatrix;

/* loaded from: classes2.dex */
public abstract class Binarizer {

    /* renamed from: a */
    private final LuminanceSource f18940a;

    public abstract BitMatrix a() throws NotFoundException;

    public final LuminanceSource b() {
        return this.f18940a;
    }
}

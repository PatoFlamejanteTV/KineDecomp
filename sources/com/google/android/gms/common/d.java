package com.google.android.gms.common;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends c {

    /* renamed from: b */
    private final byte[] f10988b;

    public d(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f10988b = bArr;
    }

    @Override // com.google.android.gms.common.c
    public final byte[] v() {
        return this.f10988b;
    }
}

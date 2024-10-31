package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private zzrx f1493a;
    private byte[] b;
    private final int c;

    public d(int i) {
        this.c = i;
        a();
    }

    @Override // com.google.android.gms.internal.c
    public void a() {
        this.b = new byte[this.c];
        this.f1493a = zzrx.zzC(this.b);
    }

    @Override // com.google.android.gms.internal.c
    public void a(int i, long j) throws IOException {
        this.f1493a.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.c
    public void a(int i, String str) throws IOException {
        this.f1493a.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.c
    public byte[] b() throws IOException {
        int zzFD = this.f1493a.zzFD();
        if (zzFD < 0) {
            throw new IOException();
        }
        if (zzFD == 0) {
            return this.b;
        }
        byte[] bArr = new byte[this.b.length - zzFD];
        System.arraycopy(this.b, 0, bArr, 0, bArr.length);
        return bArr;
    }
}

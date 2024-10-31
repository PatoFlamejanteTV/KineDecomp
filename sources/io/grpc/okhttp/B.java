package io.grpc.okhttp;

import io.grpc.internal.Tc;

/* compiled from: OkHttpWritableBuffer.java */
/* loaded from: classes3.dex */
class B implements Tc {

    /* renamed from: a */
    private final okio.g f27823a;

    /* renamed from: b */
    private int f27824b;

    /* renamed from: c */
    private int f27825c;

    public B(okio.g gVar, int i) {
        this.f27823a = gVar;
        this.f27824b = i;
    }

    @Override // io.grpc.internal.Tc
    public int B() {
        return this.f27825c;
    }

    @Override // io.grpc.internal.Tc
    public void a(byte b2) {
        this.f27823a.writeByte((int) b2);
        this.f27824b--;
        this.f27825c++;
    }

    public okio.g b() {
        return this.f27823a;
    }

    @Override // io.grpc.internal.Tc
    public void release() {
    }

    @Override // io.grpc.internal.Tc
    public void write(byte[] bArr, int i, int i2) {
        this.f27823a.write(bArr, i, i2);
        this.f27824b -= i2;
        this.f27825c += i2;
    }

    @Override // io.grpc.internal.Tc
    public int a() {
        return this.f27824b;
    }
}

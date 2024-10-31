package com.umeng.commonsdk.proguard;

/* compiled from: TMemoryInputTransport.java */
/* loaded from: classes3.dex */
public final class av extends aw {

    /* renamed from: a */
    private byte[] f26209a;

    /* renamed from: b */
    private int f26210b;

    /* renamed from: c */
    private int f26211c;

    public av() {
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public boolean a() {
        return true;
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public void b() throws ax {
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public void b(byte[] bArr, int i, int i2) throws ax {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public void c() {
    }

    public void c(byte[] bArr, int i, int i2) {
        this.f26209a = bArr;
        this.f26210b = i;
        this.f26211c = i + i2;
    }

    public void e() {
        this.f26209a = null;
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public byte[] f() {
        return this.f26209a;
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public int g() {
        return this.f26210b;
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public int h() {
        return this.f26211c - this.f26210b;
    }

    public av(byte[] bArr) {
        a(bArr);
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public int a(byte[] bArr, int i, int i2) throws ax {
        int h2 = h();
        if (i2 > h2) {
            i2 = h2;
        }
        if (i2 > 0) {
            System.arraycopy(this.f26209a, this.f26210b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    public av(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    @Override // com.umeng.commonsdk.proguard.aw
    public void a(int i) {
        this.f26210b += i;
    }
}

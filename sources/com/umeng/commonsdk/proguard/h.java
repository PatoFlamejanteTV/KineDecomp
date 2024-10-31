package com.umeng.commonsdk.proguard;

/* compiled from: ShortStack.java */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a */
    private short[] f26258a;

    /* renamed from: b */
    private int f26259b = -1;

    public h(int i) {
        this.f26258a = new short[i];
    }

    private void d() {
        short[] sArr = this.f26258a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f26258a = sArr2;
    }

    public short a() {
        short[] sArr = this.f26258a;
        int i = this.f26259b;
        this.f26259b = i - 1;
        return sArr[i];
    }

    public short b() {
        return this.f26258a[this.f26259b];
    }

    public void c() {
        this.f26259b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i = 0; i < this.f26258a.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i == this.f26259b) {
                sb.append(">>");
            }
            sb.append((int) this.f26258a[i]);
            if (i == this.f26259b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public void a(short s) {
        if (this.f26258a.length == this.f26259b + 1) {
            d();
        }
        short[] sArr = this.f26258a;
        int i = this.f26259b + 1;
        this.f26259b = i;
        sArr[i] = s;
    }
}

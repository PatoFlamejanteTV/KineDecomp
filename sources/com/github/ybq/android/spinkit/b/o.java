package com.github.ybq.android.spinkit.b;

/* compiled from: Sprite.java */
/* loaded from: classes.dex */
class o extends com.github.ybq.android.spinkit.a.b<q> {
    public o(String str) {
        super(str);
    }

    @Override // com.github.ybq.android.spinkit.a.b
    public void a(q qVar, float f2) {
        qVar.d(f2);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(q qVar) {
        return Float.valueOf(qVar.i());
    }
}

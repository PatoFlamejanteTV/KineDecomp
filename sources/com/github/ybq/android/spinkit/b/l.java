package com.github.ybq.android.spinkit.b;

/* compiled from: Sprite.java */
/* loaded from: classes.dex */
class l extends com.github.ybq.android.spinkit.a.c<q> {
    public l(String str) {
        super(str);
    }

    @Override // com.github.ybq.android.spinkit.a.c
    public void a(q qVar, int i) {
        qVar.g(i);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Integer get(q qVar) {
        return Integer.valueOf(qVar.m());
    }
}

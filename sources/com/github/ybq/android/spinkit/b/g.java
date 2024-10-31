package com.github.ybq.android.spinkit.b;

/* compiled from: Sprite.java */
/* loaded from: classes.dex */
class g extends com.github.ybq.android.spinkit.a.c<q> {
    public g(String str) {
        super(str);
    }

    @Override // com.github.ybq.android.spinkit.a.c
    public void a(q qVar, int i) {
        qVar.setAlpha(i);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Integer get(q qVar) {
        return Integer.valueOf(qVar.getAlpha());
    }
}

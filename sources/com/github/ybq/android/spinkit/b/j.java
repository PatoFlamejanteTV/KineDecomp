package com.github.ybq.android.spinkit.b;

/* compiled from: Sprite.java */
/* loaded from: classes.dex */
class j extends com.github.ybq.android.spinkit.a.c<q> {
    public j(String str) {
        super(str);
    }

    @Override // com.github.ybq.android.spinkit.a.c
    public void a(q qVar, int i) {
        qVar.e(i);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Integer get(q qVar) {
        return Integer.valueOf(qVar.g());
    }
}

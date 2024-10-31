package com.github.ybq.android.spinkit.b;

/* compiled from: Sprite.java */
/* loaded from: classes.dex */
class i extends com.github.ybq.android.spinkit.a.c<q> {
    public i(String str) {
        super(str);
    }

    @Override // com.github.ybq.android.spinkit.a.c
    public void a(q qVar, int i) {
        qVar.c(i);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Integer get(q qVar) {
        return Integer.valueOf(qVar.e());
    }
}

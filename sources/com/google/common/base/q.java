package com.google.common.base;

import com.google.common.base.Splitter;

/* compiled from: Splitter.java */
/* loaded from: classes2.dex */
public class q implements Splitter.b {

    /* renamed from: a */
    final /* synthetic */ String f15146a;

    public q(String str) {
        this.f15146a = str;
    }

    @Override // com.google.common.base.Splitter.b
    public Splitter.a a(Splitter splitter, CharSequence charSequence) {
        return new p(this, splitter, charSequence);
    }
}

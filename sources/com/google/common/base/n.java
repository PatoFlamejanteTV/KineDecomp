package com.google.common.base;

import com.google.common.base.Splitter;

/* compiled from: Splitter.java */
/* loaded from: classes2.dex */
public class n extends Splitter.a {

    /* renamed from: h */
    final /* synthetic */ o f15143h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, Splitter splitter, CharSequence charSequence) {
        super(splitter, charSequence);
        this.f15143h = oVar;
    }

    @Override // com.google.common.base.Splitter.a
    int a(int i) {
        return i + 1;
    }

    @Override // com.google.common.base.Splitter.a
    int b(int i) {
        return this.f15143h.f15144a.a(this.f15113c, i);
    }
}

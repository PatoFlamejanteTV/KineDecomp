package com.google.common.base;

import com.google.common.base.Splitter;

/* compiled from: Splitter.java */
/* loaded from: classes2.dex */
public class o implements Splitter.b {

    /* renamed from: a */
    final /* synthetic */ CharMatcher f15144a;

    public o(CharMatcher charMatcher) {
        this.f15144a = charMatcher;
    }

    @Override // com.google.common.base.Splitter.b
    public Splitter.a a(Splitter splitter, CharSequence charSequence) {
        return new n(this, splitter, charSequence);
    }
}

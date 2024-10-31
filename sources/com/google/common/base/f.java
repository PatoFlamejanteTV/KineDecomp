package com.google.common.base;

import com.google.common.base.CharMatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
public class f extends CharMatcher {
    final /* synthetic */ CharMatcher.b p;
    final /* synthetic */ CharMatcher q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(CharMatcher charMatcher, String str, CharMatcher.b bVar) {
        super(str);
        this.q = charMatcher;
        this.p = bVar;
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return this.p.b(c);
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b() {
        return this;
    }
}

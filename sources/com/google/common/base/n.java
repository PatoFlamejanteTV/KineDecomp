package com.google.common.base;

import com.google.common.base.CharMatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
public final class n extends CharMatcher {
    final /* synthetic */ char p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, char c) {
        super(str);
        this.p = c;
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return c == this.p;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher a(CharMatcher charMatcher) {
        return charMatcher.c(this.p) ? this : m;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b(CharMatcher charMatcher) {
        return charMatcher.c(this.p) ? charMatcher : super.b(charMatcher);
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher a() {
        return b(this.p);
    }

    @Override // com.google.common.base.CharMatcher
    void a(CharMatcher.b bVar) {
        bVar.a(this.p);
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b() {
        return this;
    }
}

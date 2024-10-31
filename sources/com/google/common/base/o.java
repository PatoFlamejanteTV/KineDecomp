package com.google.common.base;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
public final class o extends CharMatcher {
    final /* synthetic */ char p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(String str, char c) {
        super(str);
        this.p = c;
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return c != this.p;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher a(CharMatcher charMatcher) {
        return charMatcher.c(this.p) ? super.a(charMatcher) : charMatcher;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b(CharMatcher charMatcher) {
        return charMatcher.c(this.p) ? l : this;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher a() {
        return a(this.p);
    }
}

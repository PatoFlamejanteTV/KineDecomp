package com.google.common.base;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
public class e extends CharMatcher {
    final /* synthetic */ CharMatcher p;
    final /* synthetic */ CharMatcher q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(CharMatcher charMatcher, String str, CharMatcher charMatcher2) {
        super(str);
        this.q = charMatcher;
        this.p = charMatcher2;
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return !this.p.c(c);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(CharSequence charSequence) {
        return this.p.d(charSequence);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean d(CharSequence charSequence) {
        return this.p.c(charSequence);
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher a() {
        return this.p;
    }
}

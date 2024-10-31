package com.google.common.base;

import com.google.common.base.CharMatcher;

/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
final class m extends CharMatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(String str) {
        super(str);
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    public int e(CharSequence charSequence) {
        Preconditions.a(charSequence);
        return -1;
    }

    @Override // com.google.common.base.CharMatcher
    public int a(CharSequence charSequence, int i) {
        Preconditions.b(i, charSequence.length());
        return -1;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean d(CharSequence charSequence) {
        Preconditions.a(charSequence);
        return true;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher a(CharMatcher charMatcher) {
        Preconditions.a(charMatcher);
        return this;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b(CharMatcher charMatcher) {
        return (CharMatcher) Preconditions.a(charMatcher);
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher a() {
        return l;
    }

    @Override // com.google.common.base.CharMatcher
    void a(CharMatcher.b bVar) {
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b() {
        return this;
    }
}

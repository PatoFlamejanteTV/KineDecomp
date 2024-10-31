package com.google.common.base;

/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
final class l extends CharMatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str) {
        super(str);
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return true;
    }

    @Override // com.google.common.base.CharMatcher
    public int e(CharSequence charSequence) {
        return charSequence.length() == 0 ? -1 : 0;
    }

    @Override // com.google.common.base.CharMatcher
    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        Preconditions.b(i, length);
        if (i == length) {
            return -1;
        }
        return i;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(CharSequence charSequence) {
        Preconditions.a(charSequence);
        return true;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean d(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher a(CharMatcher charMatcher) {
        return (CharMatcher) Preconditions.a(charMatcher);
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b(CharMatcher charMatcher) {
        Preconditions.a(charMatcher);
        return this;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher a() {
        return m;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b() {
        return this;
    }
}

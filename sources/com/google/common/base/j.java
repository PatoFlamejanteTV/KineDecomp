package com.google.common.base;

/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
final class j extends CharMatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str) {
        super(str);
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return Character.isUpperCase(c);
    }
}
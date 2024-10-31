package com.google.common.base;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
public final class a extends CharMatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        super(str);
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return Character.isDigit(c);
    }
}

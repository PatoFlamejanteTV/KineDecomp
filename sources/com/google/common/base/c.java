package com.google.common.base;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
public final class c extends CharMatcher {
    final /* synthetic */ char[] p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, char[] cArr) {
        super(str);
        this.p = cArr;
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return Arrays.binarySearch(this.p, c) >= 0;
    }
}

package com.google.common.base;

import com.google.common.base.CharMatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
public final class d extends CharMatcher {
    final /* synthetic */ char p;
    final /* synthetic */ char q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, char c, char c2) {
        super(str);
        this.p = c;
        this.q = c2;
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return this.p <= c && c <= this.q;
    }

    @Override // com.google.common.base.CharMatcher
    void a(CharMatcher.b bVar) {
        char c = this.p;
        while (true) {
            bVar.a(c);
            char c2 = (char) (c + 1);
            if (c == this.q) {
                return;
            } else {
                c = c2;
            }
        }
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b() {
        return this;
    }
}
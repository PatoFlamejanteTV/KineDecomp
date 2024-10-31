package com.google.common.base;

/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
final class g extends CharMatcher {
    private final char[] p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str) {
        super(str);
        this.p = new char[]{1, 0, 160, 0, 0, 0, 0, 0, 0, '\t', '\n', 11, '\f', '\r', 0, 0, 8232, 8233, 0, 0, 0, 0, 0, 8239, 0, 0, 0, 0, 0, 0, 0, 0, ' ', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12288, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 133, 8192, 8193, 8194, 8195, 8196, 8197, 8198, 8199, 8200, 8201, 8202, 0, 0, 0, 0, 0, 8287, 5760, 0, 0, 6158, 0, 0, 0};
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean c(char c) {
        return this.p[c % 'O'] == c;
    }

    @Override // com.google.common.base.CharMatcher
    public CharMatcher b() {
        return this;
    }
}

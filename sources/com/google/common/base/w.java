package com.google.common.base;

import com.google.common.base.Splitter;

/* compiled from: Splitter.java */
/* loaded from: classes2.dex */
final class w implements Splitter.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CharMatcher f2594a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(CharMatcher charMatcher) {
        this.f2594a = charMatcher;
    }

    @Override // com.google.common.base.Splitter.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Splitter.a b(Splitter splitter, CharSequence charSequence) {
        return new x(this, splitter, charSequence);
    }
}

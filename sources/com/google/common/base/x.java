package com.google.common.base;

import com.google.common.base.Splitter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Splitter.java */
/* loaded from: classes2.dex */
public class x extends Splitter.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f2595a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(w wVar, Splitter splitter, CharSequence charSequence) {
        super(splitter, charSequence);
        this.f2595a = wVar;
    }

    @Override // com.google.common.base.Splitter.a
    int a(int i) {
        return this.f2595a.f2594a.a(this.b, i);
    }

    @Override // com.google.common.base.Splitter.a
    int b(int i) {
        return i + 1;
    }
}

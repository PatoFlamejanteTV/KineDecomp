package com.google.common.base;

import javax.annotation.Nullable;

/* compiled from: Joiner.java */
/* loaded from: classes2.dex */
public class f extends Joiner {

    /* renamed from: b */
    final /* synthetic */ String f15131b;

    /* renamed from: c */
    final /* synthetic */ Joiner f15132c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Joiner joiner, Joiner joiner2, String str) {
        super(joiner2, null);
        this.f15132c = joiner;
        this.f15131b = str;
    }

    @Override // com.google.common.base.Joiner
    public CharSequence a(@Nullable Object obj) {
        return obj == null ? this.f15131b : this.f15132c.a(obj);
    }

    @Override // com.google.common.base.Joiner
    public Joiner b(String str) {
        throw new UnsupportedOperationException("already specified useForNull");
    }
}

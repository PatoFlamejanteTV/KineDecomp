package com.google.common.base;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Joiner.java */
/* loaded from: classes2.dex */
public class p extends Joiner {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2590a;
    final /* synthetic */ Joiner b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Joiner joiner, Joiner joiner2, String str) {
        super(joiner2, null);
        this.b = joiner;
        this.f2590a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.base.Joiner
    public CharSequence a(Object obj) {
        return obj == null ? this.f2590a : this.b.a(obj);
    }

    @Override // com.google.common.base.Joiner
    public Joiner b(String str) {
        Preconditions.a(str);
        throw new UnsupportedOperationException("already specified useForNull");
    }
}

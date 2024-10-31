package com.google.common.escape;

import com.google.common.base.Function;

/* compiled from: Escaper.java */
/* loaded from: classes2.dex */
public class a implements Function<String, String> {

    /* renamed from: a */
    final /* synthetic */ Escaper f15893a;

    public a(Escaper escaper) {
        this.f15893a = escaper;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a */
    public String apply(String str) {
        return this.f15893a.a(str);
    }
}

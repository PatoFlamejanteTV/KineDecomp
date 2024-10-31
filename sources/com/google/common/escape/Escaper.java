package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class Escaper {

    /* renamed from: a */
    private final Function<String, String> f15887a = new a(this);

    public abstract String a(String str);
}

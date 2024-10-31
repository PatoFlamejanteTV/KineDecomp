package com.google.common.reflect;

import com.google.common.base.Function;
import java.lang.reflect.Type;

/* compiled from: Types.java */
/* loaded from: classes2.dex */
final class i implements Function<Type, String> {
    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String apply(Type type) {
        return Types.d(type);
    }
}

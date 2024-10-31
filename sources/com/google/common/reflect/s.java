package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.Types;
import java.lang.reflect.Type;

/* compiled from: Types.java */
/* loaded from: classes2.dex */
public class s implements Function<Type, String> {
    @Override // com.google.common.base.Function
    /* renamed from: a */
    public String apply(Type type) {
        return Types.JavaVersion.CURRENT.typeName(type);
    }
}

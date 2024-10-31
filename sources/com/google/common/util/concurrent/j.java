package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import java.util.Arrays;

/* compiled from: Futures.java */
/* loaded from: classes2.dex */
final class j implements Function<Constructor<?>, Boolean> {
    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean apply(Constructor<?> constructor) {
        return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
    }
}

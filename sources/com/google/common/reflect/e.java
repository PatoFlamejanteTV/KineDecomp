package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.MutableTypeToInstanceMap;
import java.util.Map;

/* compiled from: MutableTypeToInstanceMap.java */
/* loaded from: classes2.dex */
public class e<K, V> implements Function<Map.Entry<K, V>, Map.Entry<K, V>> {
    @Override // com.google.common.base.Function
    /* renamed from: a */
    public Map.Entry<K, V> apply(Map.Entry<K, V> entry) {
        return new MutableTypeToInstanceMap.a(entry);
    }
}

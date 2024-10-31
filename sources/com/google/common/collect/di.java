package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collections;
import java.util.Map;

/* compiled from: Tables.java */
/* loaded from: classes2.dex */
final class di implements Function<Map<Object, Object>, Map<Object, Object>> {
    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<Object, Object> apply(Map<Object, Object> map) {
        return Collections.unmodifiableMap(map);
    }
}

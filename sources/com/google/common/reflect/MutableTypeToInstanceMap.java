package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps;
import java.util.Map;

@Beta
/* loaded from: classes2.dex */
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<TypeToken<? extends B>, B> f2934a = Maps.a();

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public B put(TypeToken<? extends B> typeToken, B b) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.f2934a;
    }
}

package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;

@Beta
/* loaded from: classes2.dex */
public final class ImmutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableMap<TypeToken<? extends B>, B> f16052a;

    @Beta
    /* loaded from: classes2.dex */
    public static final class Builder<B> {

        /* renamed from: a, reason: collision with root package name */
        private final ImmutableMap.Builder<TypeToken<? extends B>, B> f16053a = ImmutableMap.builder();

        private Builder() {
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public B put(TypeToken<? extends B> typeToken, B b2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.f16052a;
    }
}

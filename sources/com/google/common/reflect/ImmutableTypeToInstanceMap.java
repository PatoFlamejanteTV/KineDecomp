package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

@Beta
/* loaded from: classes2.dex */
public final class ImmutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableMap<TypeToken<? extends B>, B> f2932a;

    @Beta
    /* loaded from: classes2.dex */
    public static final class Builder<B> {

        /* renamed from: a, reason: collision with root package name */
        private final ImmutableMap.Builder<TypeToken<? extends B>, B> f2933a = ImmutableMap.builder();

        private Builder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.f2932a;
    }
}

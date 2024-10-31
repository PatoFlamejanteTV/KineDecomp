package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B> {

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableMap<Class<? extends B>, B> f2685a;

    /* loaded from: classes2.dex */
    public static final class Builder<B> {

        /* renamed from: a, reason: collision with root package name */
        private final ImmutableMap.Builder<Class<? extends B>, B> f2686a = ImmutableMap.builder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Class<? extends B>, B> delegate() {
        return this.f2685a;
    }
}

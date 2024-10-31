package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
final class EmptyImmutableBiMap extends ImmutableBiMap<Object, Object> {
    static final EmptyImmutableBiMap INSTANCE = new EmptyImmutableBiMap();

    private EmptyImmutableBiMap() {
    }

    @Override // com.google.common.collect.ImmutableBiMap
    ImmutableMap<Object, Object> delegate() {
        return ImmutableMap.of();
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap<Object, Object> inverse() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    Object readResolve() {
        return INSTANCE;
    }
}

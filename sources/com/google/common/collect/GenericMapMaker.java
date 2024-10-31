package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class GenericMapMaker<K0, V0> {

    /* renamed from: a, reason: collision with root package name */
    @GwtIncompatible
    MapMaker.a<K0, V0> f2684a;

    public abstract <K extends K0, V extends V0> ConcurrentMap<K, V> b();

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    /* loaded from: classes2.dex */
    public enum NullListener implements MapMaker.a<Object, Object> {
        INSTANCE;

        @Override // com.google.common.collect.MapMaker.a
        public void onRemoval(MapMaker.RemovalNotification<Object, Object> removalNotification) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public <K extends K0, V extends V0> MapMaker.a<K, V> a() {
        return (MapMaker.a) Objects.b(this.f2684a, NullListener.INSTANCE);
    }
}

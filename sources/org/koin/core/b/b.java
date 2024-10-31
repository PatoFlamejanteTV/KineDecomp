package org.koin.core.b;

import kotlin.jvm.internal.h;

/* compiled from: FactoryDefinitionInstance.kt */
/* loaded from: classes3.dex */
public final class b<T> extends a<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(org.koin.core.definition.b<T> bVar) {
        super(bVar);
        h.b(bVar, "beanDefinition");
    }

    @Override // org.koin.core.b.a
    public <T> T b(c cVar) {
        h.b(cVar, com.umeng.analytics.pro.b.Q);
        return a(cVar);
    }
}

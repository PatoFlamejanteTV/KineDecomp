package org.koin.core.b;

import kotlin.jvm.internal.h;

/* compiled from: SingleDefinitionInstance.kt */
/* loaded from: classes3.dex */
public final class e<T> extends a<T> {

    /* renamed from: c, reason: collision with root package name */
    private T f29354c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(org.koin.core.definition.b<T> bVar) {
        super(bVar);
        h.b(bVar, "beanDefinition");
    }

    @Override // org.koin.core.b.a
    public <T> T b(c cVar) {
        h.b(cVar, com.umeng.analytics.pro.b.Q);
        if (this.f29354c == null) {
            this.f29354c = a(cVar);
        }
        T t = this.f29354c;
        if (!(t instanceof Object)) {
            t = null;
        }
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Single instance created couldn't return value");
    }
}

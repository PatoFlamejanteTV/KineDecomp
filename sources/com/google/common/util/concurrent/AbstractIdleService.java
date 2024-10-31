package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class AbstractIdleService implements Service {

    /* renamed from: a */
    private final Supplier<String> f16139a = new b(this, null);

    /* renamed from: b */
    private final Service f16140b = new a(this, null);

    /* loaded from: classes2.dex */
    private final class a extends AbstractService {
        private a() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractIdleService.this.toString();
        }

        /* synthetic */ a(AbstractIdleService abstractIdleService, d dVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private final class b implements Supplier<String> {
        private b() {
        }

        /* synthetic */ b(AbstractIdleService abstractIdleService, d dVar) {
            this();
        }

        @Override // com.google.common.base.Supplier
        public String get() {
            return AbstractIdleService.this.b() + " " + AbstractIdleService.this.a();
        }
    }

    protected AbstractIdleService() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.f16140b.a();
    }

    protected String b() {
        return AbstractIdleService.class.getSimpleName();
    }

    public String toString() {
        return b() + " [" + a() + "]";
    }
}

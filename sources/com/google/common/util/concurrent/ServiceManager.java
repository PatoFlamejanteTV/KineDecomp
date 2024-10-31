package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.s;
import java.util.Collection;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class ServiceManager {

    /* renamed from: a */
    private static final Logger f16188a = Logger.getLogger(ServiceManager.class.getName());

    /* renamed from: b */
    private static final s.a<Listener> f16189b = new v("healthy()");

    /* renamed from: c */
    private static final s.a<Listener> f16190c = new w("stopped()");

    /* renamed from: d */
    private final ImmutableList<Service> f16191d;

    @Beta
    /* loaded from: classes2.dex */
    public static abstract class Listener {
        public void a() {
        }

        public void b() {
        }
    }

    /* loaded from: classes2.dex */
    private static final class a extends AbstractService {
        private a() {
        }
    }

    public String toString() {
        return MoreObjects.a((Class<?>) ServiceManager.class).a("services", Collections2.a((Collection) this.f16191d, Predicates.a((Predicate) Predicates.a((Class<?>) a.class)))).toString();
    }
}

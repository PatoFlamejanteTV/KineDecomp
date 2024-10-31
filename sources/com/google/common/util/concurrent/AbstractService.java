package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class AbstractService implements Service {

    /* renamed from: a */
    private static final s.a<Service.Listener> f16145a = new f("starting()");

    /* renamed from: b */
    private static final s.a<Service.Listener> f16146b = new g("running()");

    /* renamed from: c */
    private static final s.a<Service.Listener> f16147c = a(Service.State.STARTING);

    /* renamed from: d */
    private static final s.a<Service.Listener> f16148d = a(Service.State.RUNNING);

    /* renamed from: e */
    private static final s.a<Service.Listener> f16149e = b(Service.State.NEW);

    /* renamed from: f */
    private static final s.a<Service.Listener> f16150f = b(Service.State.RUNNING);

    /* renamed from: g */
    private static final s.a<Service.Listener> f16151g = b(Service.State.STOPPING);

    /* renamed from: h */
    private final Monitor f16152h = new Monitor();
    private final Monitor.Guard i = new b();
    private final Monitor.Guard j = new c();
    private final Monitor.Guard k = new a();
    private final Monitor.Guard l = new d();
    private final List<s<Service.Listener>> m = Collections.synchronizedList(new ArrayList());
    private volatile e n = new e(Service.State.NEW);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a extends Monitor.Guard {
        a() {
            super(AbstractService.this.f16152h);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return AbstractService.this.a().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class b extends Monitor.Guard {
        b() {
            super(AbstractService.this.f16152h);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return AbstractService.this.a() == Service.State.NEW;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class c extends Monitor.Guard {
        c() {
            super(AbstractService.this.f16152h);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return AbstractService.this.a().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class d extends Monitor.Guard {
        d() {
            super(AbstractService.this.f16152h);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean a() {
            return AbstractService.this.a().isTerminal();
        }
    }

    @Immutable
    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a */
        final Service.State f16157a;

        /* renamed from: b */
        final boolean f16158b;

        /* renamed from: c */
        @Nullable
        final Throwable f16159c;

        e(Service.State state) {
            this(state, false, null);
        }

        Service.State a() {
            if (this.f16158b && this.f16157a == Service.State.STARTING) {
                return Service.State.STOPPING;
            }
            return this.f16157a;
        }

        e(Service.State state, boolean z, @Nullable Throwable th) {
            Preconditions.a(!z || state == Service.State.STARTING, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            Preconditions.a((th != null) ^ (state == Service.State.FAILED) ? false : true, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.f16157a = state;
            this.f16158b = z;
            this.f16159c = th;
        }
    }

    private static s.a<Service.Listener> b(Service.State state) {
        return new h("terminated({from = " + state + "})", state);
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + a() + "]";
    }

    private static s.a<Service.Listener> a(Service.State state) {
        return new i("stopping({from = " + state + "})", state);
    }

    private void b() {
        if (this.f16152h.b()) {
            return;
        }
        for (int i = 0; i < this.m.size(); i++) {
            this.m.get(i).b();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0014. Please report as an issue. */
    public final void a(Throwable th) {
        Preconditions.a(th);
        this.f16152h.a();
        try {
            Service.State a2 = a();
            switch (k.f16204a[a2.ordinal()]) {
                case 1:
                case 5:
                    throw new IllegalStateException("Failed while in state:" + a2, th);
                case 2:
                case 3:
                case 4:
                    this.n = new e(Service.State.FAILED, false, th);
                    a(a2, th);
                case 6:
                    return;
                default:
                    throw new AssertionError("Unexpected state: " + a2);
            }
        } finally {
            this.f16152h.c();
            b();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.n.a();
    }

    private void a(Service.State state, Throwable th) {
        new j(this, "failed({from = " + state + ", cause = " + th + "})", state, th).a((Iterable) this.m);
    }
}

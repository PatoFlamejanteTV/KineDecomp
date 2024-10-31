package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class AbstractScheduledService implements Service {

    /* renamed from: a */
    private static final Logger f16142a = Logger.getLogger(AbstractScheduledService.class.getName());

    /* renamed from: b */
    private final AbstractService f16143b = new a(this, null);

    @Beta
    /* loaded from: classes2.dex */
    public static abstract class CustomScheduler extends Scheduler {

        @Beta
        /* loaded from: classes2.dex */
        protected static final class Schedule {
        }

        public CustomScheduler() {
            super(null);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Scheduler {
        /* synthetic */ Scheduler(e eVar) {
            this();
        }

        private Scheduler() {
        }
    }

    protected AbstractScheduledService() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.f16143b.a();
    }

    protected abstract void c() throws Exception;

    protected String d() {
        return AbstractScheduledService.class.getSimpleName();
    }

    protected void e() throws Exception {
    }

    public String toString() {
        return d() + " [" + a() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a extends AbstractService {
        private volatile Future<?> o;
        private final ReentrantLock p;
        private final Runnable q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$a$a */
        /* loaded from: classes2.dex */
        public class RunnableC0092a implements Runnable {
            RunnableC0092a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.p.lock();
                try {
                    try {
                    } catch (Throwable th) {
                        try {
                            AbstractScheduledService.this.e();
                        } catch (Exception e2) {
                            AbstractScheduledService.f16142a.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e2);
                        }
                        a.this.a(th);
                        a.this.o.cancel(false);
                    }
                    if (a.this.o.isCancelled()) {
                        return;
                    }
                    AbstractScheduledService.this.c();
                } finally {
                    a.this.p.unlock();
                }
            }
        }

        private a() {
            this.p = new ReentrantLock();
            this.q = new RunnableC0092a();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractScheduledService.this.toString();
        }

        /* synthetic */ a(AbstractScheduledService abstractScheduledService, e eVar) {
            this();
        }
    }
}

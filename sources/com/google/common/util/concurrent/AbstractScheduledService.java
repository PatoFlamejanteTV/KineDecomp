package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.Service;
import java.util.logging.Logger;

@Beta
/* loaded from: classes2.dex */
public abstract class AbstractScheduledService implements Service {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2952a = Logger.getLogger(AbstractScheduledService.class.getName());
    private final AbstractService b = new d(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b() throws Exception;

    /* loaded from: classes2.dex */
    public static abstract class Scheduler {
        /* synthetic */ Scheduler(d dVar) {
            this();
        }

        private Scheduler() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() throws Exception {
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + a() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.b.a();
    }

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
}

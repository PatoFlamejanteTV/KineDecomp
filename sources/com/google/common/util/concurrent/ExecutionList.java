package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class ExecutionList {

    /* renamed from: a */
    private static final Logger f16168a = Logger.getLogger(ExecutionList.class.getName());

    /* renamed from: b */
    private a f16169b;

    /* renamed from: c */
    private boolean f16170c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        final Runnable f16171a;

        /* renamed from: b */
        final Executor f16172b;

        /* renamed from: c */
        @Nullable
        a f16173c;

        a(Runnable runnable, Executor executor, a aVar) {
            this.f16171a = runnable;
            this.f16172b = executor;
            this.f16173c = aVar;
        }
    }

    private static void b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f16168a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        Preconditions.a(runnable, "Runnable was null.");
        Preconditions.a(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f16170c) {
                this.f16169b = new a(runnable, executor, this.f16169b);
            } else {
                b(runnable, executor);
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.f16170c) {
                return;
            }
            this.f16170c = true;
            a aVar = this.f16169b;
            this.f16169b = null;
            a aVar2 = aVar;
            a aVar3 = null;
            while (aVar2 != null) {
                a aVar4 = aVar2.f16173c;
                aVar2.f16173c = aVar3;
                aVar3 = aVar2;
                aVar2 = aVar4;
            }
            while (aVar3 != null) {
                b(aVar3.f16171a, aVar3.f16172b);
                aVar3 = aVar3.f16173c;
            }
        }
    }
}

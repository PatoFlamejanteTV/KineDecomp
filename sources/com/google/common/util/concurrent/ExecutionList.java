package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class ExecutionList {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2961a = Logger.getLogger(ExecutionList.class.getName());
    private final Queue<a> b = Lists.b();
    private boolean c = false;

    public void a(Runnable runnable, Executor executor) {
        Preconditions.a(runnable, "Runnable was null.");
        Preconditions.a(executor, "Executor was null.");
        boolean z = false;
        synchronized (this.b) {
            if (!this.c) {
                this.b.add(new a(runnable, executor));
            } else {
                z = true;
            }
        }
        if (z) {
            new a(runnable, executor).a();
        }
    }

    public void a() {
        synchronized (this.b) {
            if (!this.c) {
                this.c = true;
                while (!this.b.isEmpty()) {
                    this.b.poll().a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f2962a;
        final Executor b;

        a(Runnable runnable, Executor executor) {
            this.f2962a = runnable;
            this.b = executor;
        }

        void a() {
            try {
                this.b.execute(this.f2962a);
            } catch (RuntimeException e) {
                ExecutionList.f2961a.log(Level.SEVERE, "RuntimeException while executing runnable " + this.f2962a + " with executor " + this.b, (Throwable) e);
            }
        }
    }
}

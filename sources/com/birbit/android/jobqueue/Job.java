package com.birbit.android.jobqueue;

import android.content.Context;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class Job implements Serializable {
    public static final int DEFAULT_RETRY_LIMIT = 20;
    static final String SINGLE_ID_TAG_PREFIX = "job-single-id:";
    private static final long serialVersionUID = 3;

    /* renamed from: a */
    private transient String f8099a = UUID.randomUUID().toString();

    /* renamed from: b */
    private transient String f8100b;

    /* renamed from: c */
    private transient boolean f8101c;
    volatile transient boolean cancelled;

    /* renamed from: d */
    private transient Set<String> f8102d;

    /* renamed from: e */
    private transient int f8103e;

    /* renamed from: f */
    private transient long f8104f;

    /* renamed from: g */
    private transient long f8105g;

    /* renamed from: h */
    private transient boolean f8106h;
    private transient Context i;
    private volatile transient boolean j;
    private volatile transient boolean k;
    transient int priority;
    transient int requiredNetworkType;

    public Job(w wVar) {
        this.requiredNetworkType = wVar.f8319a;
        this.f8101c = wVar.g();
        this.f8100b = wVar.c();
        this.priority = wVar.d();
        this.f8104f = Math.max(0L, wVar.b());
        this.f8105g = Math.max(0L, wVar.a());
        this.f8106h = wVar.i();
        String e2 = wVar.e();
        if (wVar.f() != null || e2 != null) {
            HashSet<String> f2 = wVar.f() != null ? wVar.f() : new HashSet<>();
            if (e2 != null) {
                String a2 = a(e2);
                f2.add(a2);
                if (this.f8100b == null) {
                    this.f8100b = a2;
                }
            }
            this.f8102d = Collections.unmodifiableSet(f2);
        }
        long j = this.f8105g;
        if (j <= 0 || j >= this.f8104f) {
            return;
        }
        throw new IllegalArgumentException("deadline cannot be less than the delay. It does not make sense. deadline:" + this.f8105g + ",delay:" + this.f8104f);
    }

    private String a(String str) {
        return SINGLE_ID_TAG_PREFIX + str;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (!this.j) {
            throw new IllegalStateException("A job cannot be serialized w/o first being added into a job manager.");
        }
    }

    public void assertNotCancelled() {
        if (this.cancelled) {
            throw new RuntimeException("job is cancelled");
        }
    }

    public Context getApplicationContext() {
        return this.i;
    }

    public final int getCurrentRunCount() {
        return this.f8103e;
    }

    public long getDeadlineInMs() {
        return this.f8105g;
    }

    public final long getDelayInMs() {
        return this.f8104f;
    }

    public final String getId() {
        return this.f8099a;
    }

    public final int getPriority() {
        return this.priority;
    }

    protected int getRetryLimit() {
        return 20;
    }

    public final String getRunGroupId() {
        return this.f8100b;
    }

    public final String getSingleInstanceId() {
        Set<String> set = this.f8102d;
        if (set == null) {
            return null;
        }
        for (String str : set) {
            if (str.startsWith(SINGLE_ID_TAG_PREFIX)) {
                return str;
            }
        }
        return null;
    }

    public final Set<String> getTags() {
        return this.f8102d;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isDeadlineReached() {
        return this.k;
    }

    public final boolean isPersistent() {
        return this.f8101c;
    }

    public abstract void onAdded();

    public abstract void onCancel(int i, Throwable th);

    public abstract void onRun() throws Throwable;

    public final boolean requiresNetwork() {
        return this.requiredNetworkType >= 1;
    }

    public final boolean requiresUnmeteredNetwork() {
        return this.requiredNetworkType >= 2;
    }

    public final int safeRun(p pVar, int i, com.birbit.android.jobqueue.i.b bVar) {
        boolean z;
        Throwable th;
        boolean z2;
        boolean z3;
        this.f8103e = i;
        if (com.birbit.android.jobqueue.f.c.b()) {
            com.birbit.android.jobqueue.f.c.a("running job %s", getClass().getSimpleName());
        }
        try {
            onRun();
            if (com.birbit.android.jobqueue.f.c.b()) {
                com.birbit.android.jobqueue.f.c.a("finished job %s", this);
            }
            th = null;
            z3 = false;
            z2 = false;
            z = false;
        } catch (Throwable th2) {
            com.birbit.android.jobqueue.f.c.a(th2, "error while executing job %s", this);
            boolean z4 = pVar.v() && pVar.b() <= bVar.b();
            z = i < getRetryLimit() && !z4;
            if (z && !this.cancelled) {
                try {
                    y shouldReRunOnThrowable = shouldReRunOnThrowable(th2, i, getRetryLimit());
                    if (shouldReRunOnThrowable == null) {
                        shouldReRunOnThrowable = y.f8327a;
                    }
                    pVar.q = shouldReRunOnThrowable;
                    z = shouldReRunOnThrowable.c();
                } catch (Throwable th3) {
                    com.birbit.android.jobqueue.f.c.a(th3, "shouldReRunOnThrowable did throw an exception", new Object[0]);
                }
            }
            th = th2;
            z2 = z4;
            z3 = true;
        }
        com.birbit.android.jobqueue.f.c.a("safeRunResult for %s : %s. re run:%s. cancelled: %s", this, Boolean.valueOf(!z3), Boolean.valueOf(z), Boolean.valueOf(this.cancelled));
        if (!z3) {
            return 1;
        }
        if (pVar.s()) {
            return 6;
        }
        if (pVar.r()) {
            return 3;
        }
        if (z) {
            return 4;
        }
        if (z2) {
            return 7;
        }
        if (i < getRetryLimit()) {
            pVar.a(th);
            return 5;
        }
        pVar.a(th);
        return 2;
    }

    public void setApplicationContext(Context context) {
        this.i = context;
    }

    public void setDeadlineReached(boolean z) {
        this.k = z;
    }

    public boolean shouldCancelOnDeadline() {
        return this.f8106h;
    }

    protected abstract y shouldReRunOnThrowable(Throwable th, int i, int i2);

    public final void updateFromJobHolder(p pVar) {
        if (!this.j) {
            this.f8099a = pVar.f8242b;
            this.f8100b = pVar.f8245e;
            this.priority = pVar.h();
            this.f8101c = pVar.f8243c;
            this.f8102d = pVar.n;
            this.requiredNetworkType = pVar.j;
            this.j = true;
            return;
        }
        throw new IllegalStateException("Cannot set a Job from JobHolder after it is sealed.");
    }
}

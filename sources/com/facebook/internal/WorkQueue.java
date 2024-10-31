package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class WorkQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    private a pendingJobs;
    private int runningCount;
    private a runningJobs;
    private final Object workLock;

    /* loaded from: classes.dex */
    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    /* loaded from: classes.dex */
    public class a implements WorkItem {

        /* renamed from: a */
        private final Runnable f9309a;

        /* renamed from: b */
        private a f9310b;

        /* renamed from: c */
        private a f9311c;

        /* renamed from: d */
        private boolean f9312d;

        a(Runnable runnable) {
            this.f9309a = runnable;
        }

        public Runnable a() {
            return this.f9309a;
        }

        a b() {
            return this.f9310b;
        }

        void b(boolean z) {
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            synchronized (WorkQueue.this.workLock) {
                if (isRunning()) {
                    return false;
                }
                WorkQueue.this.pendingJobs = a(WorkQueue.this.pendingJobs);
                return true;
            }
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean isRunning() {
            return this.f9312d;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public void moveToFront() {
            synchronized (WorkQueue.this.workLock) {
                if (!isRunning()) {
                    WorkQueue.this.pendingJobs = a(WorkQueue.this.pendingJobs);
                    WorkQueue.this.pendingJobs = a(WorkQueue.this.pendingJobs, true);
                }
            }
        }

        void a(boolean z) {
            this.f9312d = z;
        }

        a a(a aVar, boolean z) {
            if (aVar == null) {
                this.f9311c = this;
                this.f9310b = this;
                aVar = this;
            } else {
                this.f9310b = aVar;
                this.f9311c = aVar.f9311c;
                a aVar2 = this.f9310b;
                this.f9311c.f9310b = this;
                aVar2.f9311c = this;
            }
            return z ? this : aVar;
        }

        a a(a aVar) {
            if (aVar == this && (aVar = this.f9310b) == this) {
                aVar = null;
            }
            a aVar2 = this.f9310b;
            aVar2.f9311c = this.f9311c;
            this.f9311c.f9310b = aVar2;
            this.f9311c = null;
            this.f9310b = null;
            return aVar;
        }
    }

    public WorkQueue() {
        this(8);
    }

    private void execute(a aVar) {
        this.executor.execute(new K(this, aVar));
    }

    public void finishItemAndStartNew(a aVar) {
        a aVar2;
        synchronized (this.workLock) {
            if (aVar != null) {
                this.runningJobs = aVar.a(this.runningJobs);
                this.runningCount--;
            }
            if (this.runningCount < this.maxConcurrent) {
                aVar2 = this.pendingJobs;
                if (aVar2 != null) {
                    this.pendingJobs = aVar2.a(this.pendingJobs);
                    this.runningJobs = aVar2.a(this.runningJobs, false);
                    this.runningCount++;
                    aVar2.a(true);
                }
            } else {
                aVar2 = null;
            }
        }
        if (aVar2 != null) {
            execute(aVar2);
        }
    }

    private void startItem() {
        finishItemAndStartNew(null);
    }

    public WorkItem addActiveWorkItem(Runnable runnable) {
        return addActiveWorkItem(runnable, true);
    }

    public void validate() {
        synchronized (this.workLock) {
            if (this.runningJobs != null) {
                a aVar = this.runningJobs;
                do {
                    aVar.b(true);
                    aVar = aVar.b();
                } while (aVar != this.runningJobs);
            }
        }
    }

    public WorkQueue(int i) {
        this(i, FacebookSdk.getExecutor());
    }

    public WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        a aVar = new a(runnable);
        synchronized (this.workLock) {
            this.pendingJobs = aVar.a(this.pendingJobs, z);
        }
        startItem();
        return aVar;
    }

    public WorkQueue(int i, Executor executor) {
        this.workLock = new Object();
        this.runningJobs = null;
        this.runningCount = 0;
        this.maxConcurrent = i;
        this.executor = executor;
    }
}

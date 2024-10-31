package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class WorkQueue {
    static final /* synthetic */ boolean $assertionsDisabled;
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

    static {
        $assertionsDisabled = !WorkQueue.class.desiredAssertionStatus();
    }

    public WorkQueue() {
        this(8);
    }

    public WorkQueue(int i) {
        this(i, FacebookSdk.getExecutor());
    }

    public WorkQueue(int i, Executor executor) {
        this.workLock = new Object();
        this.runningJobs = null;
        this.runningCount = 0;
        this.maxConcurrent = i;
        this.executor = executor;
    }

    public WorkItem addActiveWorkItem(Runnable runnable) {
        return addActiveWorkItem(runnable, true);
    }

    public WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        a aVar = new a(runnable);
        synchronized (this.workLock) {
            this.pendingJobs = aVar.a(this.pendingJobs, z);
        }
        startItem();
        return aVar;
    }

    public void validate() {
        synchronized (this.workLock) {
            int i = 0;
            if (this.runningJobs != null) {
                a aVar = this.runningJobs;
                do {
                    aVar.b(true);
                    i++;
                    aVar = aVar.b();
                } while (aVar != this.runningJobs);
            }
            if (!$assertionsDisabled && this.runningCount != i) {
                throw new AssertionError();
            }
        }
    }

    private void startItem() {
        finishItemAndStartNew(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishItemAndStartNew(a aVar) {
        a aVar2 = null;
        synchronized (this.workLock) {
            if (aVar != null) {
                this.runningJobs = aVar.a(this.runningJobs);
                this.runningCount--;
            }
            if (this.runningCount < this.maxConcurrent && (aVar2 = this.pendingJobs) != null) {
                this.pendingJobs = aVar2.a(this.pendingJobs);
                this.runningJobs = aVar2.a(this.runningJobs, false);
                this.runningCount++;
                aVar2.a(true);
            }
        }
        if (aVar2 != null) {
            execute(aVar2);
        }
    }

    private void execute(a aVar) {
        this.executor.execute(new aj(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements WorkItem {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f279a;
        private final Runnable c;
        private a d;
        private a e;
        private boolean f;

        static {
            f279a = !WorkQueue.class.desiredAssertionStatus();
        }

        a(Runnable runnable) {
            this.c = runnable;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            synchronized (WorkQueue.this.workLock) {
                if (!isRunning()) {
                    WorkQueue.this.pendingJobs = a(WorkQueue.this.pendingJobs);
                    return true;
                }
                return false;
            }
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

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean isRunning() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Runnable a() {
            return this.c;
        }

        a b() {
            return this.d;
        }

        void a(boolean z) {
            this.f = z;
        }

        a a(a aVar, boolean z) {
            a aVar2;
            if (!f279a && this.d != null) {
                throw new AssertionError();
            }
            if (!f279a && this.e != null) {
                throw new AssertionError();
            }
            if (aVar == null) {
                this.e = this;
                this.d = this;
                aVar2 = this;
            } else {
                this.d = aVar;
                this.e = aVar.e;
                a aVar3 = this.d;
                this.e.d = this;
                aVar3.e = this;
                aVar2 = aVar;
            }
            return z ? this : aVar2;
        }

        a a(a aVar) {
            if (!f279a && this.d == null) {
                throw new AssertionError();
            }
            if (!f279a && this.e == null) {
                throw new AssertionError();
            }
            if (aVar == this) {
                aVar = this.d == this ? null : this.d;
            }
            this.d.e = this.e;
            this.e.d = this.d;
            this.e = null;
            this.d = null;
            return aVar;
        }

        void b(boolean z) {
            if (!f279a && this.e.d != this) {
                throw new AssertionError();
            }
            if (!f279a && this.d.e != this) {
                throw new AssertionError();
            }
            if (!f279a && isRunning() != z) {
                throw new AssertionError();
            }
        }
    }
}

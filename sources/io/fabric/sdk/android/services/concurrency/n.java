package io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PriorityTask.java */
/* loaded from: classes3.dex */
public class n implements g<p>, m, p {
    private final List<p> dependencies = new ArrayList();
    private final AtomicBoolean hasRun = new AtomicBoolean(false);
    private final AtomicReference<Throwable> throwable = new AtomicReference<>(null);

    public static boolean isProperDelegate(Object obj) {
        try {
            return (((g) obj) == null || ((p) obj) == null || ((m) obj) == null) ? false : true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // io.fabric.sdk.android.services.concurrency.g
    public boolean areDependenciesMet() {
        Iterator<p> it = getDependencies().iterator();
        while (it.hasNext()) {
            if (!it.next().isFinished()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Priority.compareTo(this, obj);
    }

    @Override // io.fabric.sdk.android.services.concurrency.g
    public synchronized Collection<p> getDependencies() {
        return Collections.unmodifiableCollection(this.dependencies);
    }

    public Throwable getError() {
        return this.throwable.get();
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    @Override // io.fabric.sdk.android.services.concurrency.p
    public boolean isFinished() {
        return this.hasRun.get();
    }

    @Override // io.fabric.sdk.android.services.concurrency.p
    public void setError(Throwable th) {
        this.throwable.set(th);
    }

    @Override // io.fabric.sdk.android.services.concurrency.p
    public synchronized void setFinished(boolean z) {
        this.hasRun.set(z);
    }

    @Override // io.fabric.sdk.android.services.concurrency.g
    public synchronized void addDependency(p pVar) {
        this.dependencies.add(pVar);
    }
}

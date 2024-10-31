package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.File;
import java.util.Collection;

/* compiled from: Kit.java */
/* loaded from: classes.dex */
public abstract class l<Result> implements Comparable<l> {
    Context context;
    f fabric;
    IdManager idManager;
    j<Result> initializationCallback;
    k<Result> initializationTask = new k<>(this);
    final io.fabric.sdk.android.services.concurrency.h dependsOnAnnotation = (io.fabric.sdk.android.services.concurrency.h) getClass().getAnnotation(io.fabric.sdk.android.services.concurrency.h.class);

    boolean containsAnnotatedDependency(l lVar) {
        if (hasAnnotatedDependency()) {
            for (Class<?> cls : this.dependsOnAnnotation.value()) {
                if (cls.isAssignableFrom(lVar.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract Result doInBackground();

    public Context getContext() {
        return this.context;
    }

    public Collection<io.fabric.sdk.android.services.concurrency.p> getDependencies() {
        return this.initializationTask.getDependencies();
    }

    public f getFabric() {
        return this.fabric;
    }

    public IdManager getIdManager() {
        return this.idManager;
    }

    public abstract String getIdentifier();

    public String getPath() {
        return ".Fabric" + File.separator + getIdentifier();
    }

    public abstract String getVersion();

    boolean hasAnnotatedDependency() {
        return this.dependsOnAnnotation != null;
    }

    public final void initialize() {
        this.initializationTask.a(this.fabric.c(), (Object[]) new Void[]{null});
    }

    public void injectParameters(Context context, f fVar, j<Result> jVar, IdManager idManager) {
        this.fabric = fVar;
        this.context = new g(context, getIdentifier(), getPath());
        this.initializationCallback = jVar;
        this.idManager = idManager;
    }

    public void onCancelled(Result result) {
    }

    public void onPostExecute(Result result) {
    }

    public boolean onPreExecute() {
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(l lVar) {
        if (containsAnnotatedDependency(lVar)) {
            return 1;
        }
        if (lVar.containsAnnotatedDependency(this)) {
            return -1;
        }
        if (!hasAnnotatedDependency() || lVar.hasAnnotatedDependency()) {
            return (hasAnnotatedDependency() || !lVar.hasAnnotatedDependency()) ? 0 : -1;
        }
        return 1;
    }
}

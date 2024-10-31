package io.fabric.sdk.android;

import io.fabric.sdk.android.services.common.z;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitializationTask.java */
/* loaded from: classes3.dex */
public class k<Result> extends io.fabric.sdk.android.services.concurrency.j<Void, Void, Result> {
    final l<Result> p;

    public k(l<Result> lVar) {
        this.p = lVar;
    }

    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    protected void b(Result result) {
        this.p.onPostExecute(result);
        this.p.initializationCallback.a((j<Result>) result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    public void c() {
        super.c();
        z a2 = a("onPreExecute");
        try {
            try {
                boolean onPreExecute = this.p.onPreExecute();
                a2.b();
                if (onPreExecute) {
                    return;
                }
            } catch (UnmetDependencyException e2) {
                throw e2;
            } catch (Exception e3) {
                f.f().c("Fabric", "Failure onPreExecute()", e3);
                a2.b();
            }
            a(true);
        } catch (Throwable th) {
            a2.b();
            a(true);
            throw th;
        }
    }

    @Override // io.fabric.sdk.android.services.concurrency.m
    public Priority getPriority() {
        return Priority.HIGH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    public Result a(Void... voidArr) {
        z a2 = a("doInBackground");
        Result doInBackground = !b() ? this.p.doInBackground() : null;
        a2.b();
        return doInBackground;
    }

    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    protected void a(Result result) {
        this.p.onCancelled(result);
        this.p.initializationCallback.a(new InitializationException(this.p.getIdentifier() + " Initialization was cancelled"));
    }

    private z a(String str) {
        z zVar = new z(this.p.getIdentifier() + "." + str, "KitInitialization");
        zVar.a();
        return zVar;
    }
}

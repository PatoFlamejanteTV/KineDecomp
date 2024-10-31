package io.fabric.sdk.android.services.concurrency;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* compiled from: AsyncTask.java */
/* loaded from: classes3.dex */
public class c<Result> extends FutureTask<Result> {

    /* renamed from: a */
    final /* synthetic */ AsyncTask f26951a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AsyncTask asyncTask, Callable callable) {
        super(callable);
        this.f26951a = asyncTask;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        try {
            this.f26951a.e(get());
        } catch (InterruptedException e2) {
            Log.w("AsyncTask", e2);
        } catch (CancellationException unused) {
            this.f26951a.e(null);
        } catch (ExecutionException e3) {
            throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
        }
    }
}

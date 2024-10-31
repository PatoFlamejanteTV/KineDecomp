package io.fabric.sdk.android.services.concurrency;

import android.os.Process;
import io.fabric.sdk.android.services.concurrency.AsyncTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AsyncTask.java */
/* loaded from: classes3.dex */
public class b<Params, Result> extends AsyncTask.d<Params, Result> {

    /* renamed from: b */
    final /* synthetic */ AsyncTask f26950b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AsyncTask asyncTask) {
        super(null);
        this.f26950b = asyncTask;
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.f26950b.n;
        atomicBoolean.set(true);
        Process.setThreadPriority(10);
        AsyncTask asyncTask = this.f26950b;
        Result result = (Result) asyncTask.a((Object[]) this.f26942a);
        AsyncTask.a(asyncTask, result);
        return result;
    }
}

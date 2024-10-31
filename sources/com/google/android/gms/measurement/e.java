package com.google.android.gms.measurement;

import android.util.Log;
import com.google.android.gms.measurement.zzg;
import java.lang.Thread;
import java.util.concurrent.FutureTask;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
class e<T> extends FutureTask<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzg.a f2017a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(zzg.a aVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f2017a = aVar;
    }

    @Override // java.util.concurrent.FutureTask
    protected void setException(Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        uncaughtExceptionHandler = zzg.this.g;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            Log.e("GAv4", "MeasurementExecutor: job failed with " + th);
        }
        super.setException(th);
    }
}

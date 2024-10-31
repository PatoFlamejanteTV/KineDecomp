package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.utilities.DefaultRunLoop;
import java.lang.Thread;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ DefaultRunLoop.a f17076a;

    public b(DefaultRunLoop.a aVar) {
        this.f17076a = aVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        DefaultRunLoop.this.a(th);
    }
}

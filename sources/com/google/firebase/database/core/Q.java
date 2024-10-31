package com.google.firebase.database.core;

import java.lang.Thread;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class Q implements ThreadInitializer {
    @Override // com.google.firebase.database.core.ThreadInitializer
    public void a(Thread thread, String str) {
        thread.setName(str);
    }

    @Override // com.google.firebase.database.core.ThreadInitializer
    public void a(Thread thread, boolean z) {
        thread.setDaemon(z);
    }

    @Override // com.google.firebase.database.core.ThreadInitializer
    public void a(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
    }
}

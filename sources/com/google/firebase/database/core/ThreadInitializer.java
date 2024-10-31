package com.google.firebase.database.core;

import java.lang.Thread;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public interface ThreadInitializer {

    /* renamed from: a */
    public static final ThreadInitializer f16946a = new Q();

    void a(Thread thread, String str);

    void a(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);

    void a(Thread thread, boolean z);
}

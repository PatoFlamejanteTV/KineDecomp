package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckReturnValue;

@CanIgnoreReturnValue
@GwtIncompatible
/* loaded from: classes2.dex */
public final class ThreadFactoryBuilder {

    /* renamed from: a */
    private String f16194a = null;

    /* renamed from: b */
    private Boolean f16195b = null;

    /* renamed from: c */
    private Integer f16196c = null;

    /* renamed from: d */
    private Thread.UncaughtExceptionHandler f16197d = null;

    /* renamed from: e */
    private ThreadFactory f16198e = null;

    public static String b(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactoryBuilder a(String str) {
        b(str, 0);
        this.f16194a = str;
        return this;
    }

    public ThreadFactoryBuilder a(boolean z) {
        this.f16195b = Boolean.valueOf(z);
        return this;
    }

    @CheckReturnValue
    public ThreadFactory a() {
        return a(this);
    }

    private static ThreadFactory a(ThreadFactoryBuilder threadFactoryBuilder) {
        String str = threadFactoryBuilder.f16194a;
        Boolean bool = threadFactoryBuilder.f16195b;
        Integer num = threadFactoryBuilder.f16196c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadFactoryBuilder.f16197d;
        ThreadFactory threadFactory = threadFactoryBuilder.f16198e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        return new y(threadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }
}

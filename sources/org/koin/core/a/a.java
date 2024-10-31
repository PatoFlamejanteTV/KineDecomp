package org.koin.core.a;

import kotlin.jvm.internal.h;
import org.koin.core.error.KoinAppAlreadyStartedException;

/* compiled from: GlobalContext.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static org.koin.core.b f29342a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f29343b = new a();

    private a() {
    }

    public static final org.koin.core.b a() {
        org.koin.core.b bVar = f29342a;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public static final void a(org.koin.core.b bVar) {
        h.b(bVar, "koinApplication");
        if (f29342a == null) {
            f29342a = bVar;
            return;
        }
        throw new KoinAppAlreadyStartedException("A Koin Application has already been started");
    }
}

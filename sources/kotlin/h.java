package kotlin;

import kotlin.Result;

/* compiled from: Result.kt */
/* loaded from: classes3.dex */
public final class h {
    public static final Object a(Throwable th) {
        kotlin.jvm.internal.h.b(th, "exception");
        return new Result.Failure(th);
    }

    public static final void a(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}

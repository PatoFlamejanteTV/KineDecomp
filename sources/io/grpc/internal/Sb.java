package io.grpc.internal;

import com.google.common.base.Preconditions;

/* compiled from: MoreThrowables.java */
/* loaded from: classes3.dex */
public final class Sb {
    public static void a(Throwable th) {
        Preconditions.a(th);
        if (!(th instanceof RuntimeException)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            return;
        }
        throw ((RuntimeException) th);
    }
}

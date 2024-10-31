package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.Status;
import java.util.concurrent.TimeoutException;

/* compiled from: Contexts.java */
/* renamed from: io.grpc.t */
/* loaded from: classes3.dex */
public final class C2524t {
    public static Status a(Context context) {
        Preconditions.a(context, "context must not be null");
        if (!context.v()) {
            return null;
        }
        Throwable r = context.r();
        if (r == null) {
            return Status.f27130c.b("io.grpc.Context was cancelled without error");
        }
        if (r instanceof TimeoutException) {
            return Status.f27133f.b(r.getMessage()).b(r);
        }
        Status a2 = Status.a(r);
        if (Status.Code.UNKNOWN.equals(a2.e()) && a2.d() == r) {
            return Status.f27130c.b("Context cancelled").b(r);
        }
        return a2.b(r);
    }
}

package io.grpc;

import io.grpc.Context;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadLocalContextStorage.java */
/* loaded from: classes3.dex */
public final class fa extends Context.f {

    /* renamed from: a */
    private static final Logger f27193a = Logger.getLogger(fa.class.getName());

    /* renamed from: b */
    private static final ThreadLocal<Context> f27194b = new ThreadLocal<>();

    @Override // io.grpc.Context.f
    public void a(Context context, Context context2) {
        if (a() != context) {
            f27193a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        b(context2);
    }

    @Override // io.grpc.Context.f
    public Context b(Context context) {
        Context a2 = a();
        f27194b.set(context);
        return a2;
    }

    @Override // io.grpc.Context.f
    public Context a() {
        return f27194b.get();
    }
}

package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.api.internal.zzaj;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class zzah<T extends zzaj> {

    /* renamed from: a, reason: collision with root package name */
    private static Logger f16466a = new Logger("BiChannelGoogleApi", "FirebaseAuth: ");

    /* renamed from: b, reason: collision with root package name */
    private C1561a<T> f16467b;

    private final C1561a<T> c() {
        C1561a<T> c1561a;
        synchronized (this) {
            if (this.f16467b == null) {
                try {
                    this.f16467b = a().get();
                } catch (Exception e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    throw new RuntimeException(valueOf.length() != 0 ? "There was an error while initializing the connection to Google Play Services: ".concat(valueOf) : new String("There was an error while initializing the connection to Google Play Services: "));
                }
            }
            c1561a = this.f16467b;
        }
        return c1561a;
    }

    public final <ResultT, A extends Api.AnyClient> Task<ResultT> a(zzam<A, ResultT> zzamVar) {
        GoogleApi<T> a2 = a(zzamVar.a());
        if (a2 == null) {
            return b();
        }
        return (Task<ResultT>) a2.doRead(zzamVar.b());
    }

    abstract Future<C1561a<T>> a();

    public final <ResultT, A extends Api.AnyClient> Task<ResultT> b(zzam<A, ResultT> zzamVar) {
        GoogleApi<T> a2 = a(zzamVar.a());
        if (a2 == null) {
            return b();
        }
        return (Task<ResultT>) a2.doWrite(zzamVar.b());
    }

    private final GoogleApi<T> a(String str) {
        C1561a<T> c2 = c();
        if (c2.f16449c.zzbr(str)) {
            Logger logger = f16466a;
            String valueOf = String.valueOf(c2.f16448b);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 43);
            sb.append("getGoogleApiForMethod() returned Fallback: ");
            sb.append(valueOf);
            logger.e(sb.toString(), new Object[0]);
            return c2.f16448b;
        }
        Logger logger2 = f16466a;
        String valueOf2 = String.valueOf(c2.f16447a);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 38);
        sb2.append("getGoogleApiForMethod() returned Gms: ");
        sb2.append(valueOf2);
        logger2.e(sb2.toString(), new Object[0]);
        return c2.f16447a;
    }

    private static <ResultT> Task<ResultT> b() {
        return Tasks.a((Exception) zzds.a(new Status(17499, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable")));
    }
}

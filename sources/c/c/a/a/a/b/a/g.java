package c.c.a.a.a.b.a;

import android.util.Log;
import com.kinemaster.module.network.kinemaster.error.ServiceError;
import com.kinemaster.module.network.kinemaster.error.ServiceException;
import com.kinemaster.module.network.kinemaster.service.auth.error.AuthServiceException;
import io.reactivex.m;
import io.reactivex.p;
import java.net.UnknownHostException;
import retrofit2.HttpException;

/* compiled from: AuthServiceImpl.java */
/* loaded from: classes2.dex */
public class g implements e {

    /* renamed from: a, reason: collision with root package name */
    private c.c.a.a.a.b.a.a.c.b f3517a;

    /* renamed from: b, reason: collision with root package name */
    private c.c.a.a.a.b.a.a.a.a f3518b;

    public g(c.c.a.a.a.b.a.a.c.b bVar, c.c.a.a.a.b.a.a.a.a aVar) {
        this.f3517a = bVar;
        this.f3518b = aVar;
    }

    private <T> io.reactivex.c.f<Throwable, m<T>> b(final m<T> mVar) {
        return new io.reactivex.c.f() { // from class: c.c.a.a.a.b.a.c
            @Override // io.reactivex.c.f
            public final Object apply(Object obj) {
                return g.this.a(mVar, (Throwable) obj);
            }
        };
    }

    private <T> m<T> c(final m<T> mVar) {
        return (m<T>) this.f3517a.a().d(new io.reactivex.c.f() { // from class: c.c.a.a.a.b.a.b
            @Override // io.reactivex.c.f
            public final Object apply(Object obj) {
                p a2;
                a2 = m.a((Throwable) new AuthServiceException(ServiceError.NETWORK_NO_CONNECTION_ERROR, (Throwable) obj));
                return a2;
            }
        }).a(new io.reactivex.c.f() { // from class: c.c.a.a.a.b.a.a
            @Override // io.reactivex.c.f
            public final Object apply(Object obj) {
                return g.this.a(mVar, (c.c.a.a.a.b.a.a.b.a) obj);
            }
        });
    }

    @Override // c.c.a.a.a.b.a.e
    public String a() {
        return this.f3518b.a("PREF_KEY_ACCESS_TOKEN", null);
    }

    @Override // c.c.a.a.a.b.a.e
    public final <T> m<T> a(m<T> mVar) {
        return mVar.d(b(mVar));
    }

    public /* synthetic */ m a(m mVar, Throwable th) throws Exception {
        if (th instanceof AuthServiceException) {
            ServiceError serviceError = ((AuthServiceException) th).getServiceError();
            int i = f.f3516a[serviceError.ordinal()];
            if (i != 1 && i != 2) {
                Log.d("jason", "1.parseErrorAndRefreshToken: " + th + " error: " + serviceError);
                return m.a((Throwable) new AuthServiceException(ServiceError.NETWORK_UNKNOWN_ERROR, th));
            }
            return c(mVar);
        }
        if (th instanceof HttpException) {
            return m.a((Throwable) new AuthServiceException(ServiceError.NETWORK_HTTP_ERROR, th));
        }
        if (th instanceof UnknownHostException) {
            return m.a((Throwable) new AuthServiceException(ServiceError.NETWORK_NO_CONNECTION_ERROR, th));
        }
        if (th instanceof ServiceException) {
            return m.a(th);
        }
        return m.a((Throwable) new AuthServiceException(ServiceError.NETWORK_UNKNOWN_ERROR, th));
    }

    public /* synthetic */ p a(m mVar, c.c.a.a.a.b.a.a.b.a aVar) throws Exception {
        a(aVar.f3503a);
        return mVar;
    }

    private void a(String str) {
        this.f3518b.b("PREF_KEY_ACCESS_TOKEN", str);
    }
}

package c.c.a.a.a.b.b.a.b;

import com.kinemaster.module.network.kinemaster.error.ServiceError;
import com.kinemaster.module.network.kinemaster.service.auth.error.AuthServiceException;
import com.kinemaster.module.network.kinemaster.service.dci.error.DciServiceException;
import io.reactivex.c.f;
import io.reactivex.m;
import retrofit2.D;

/* compiled from: DciClientImpl.java */
/* loaded from: classes2.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private b f3529a;

    public d(b bVar) {
        this.f3529a = bVar;
    }

    @Override // c.c.a.a.a.b.b.a.b.c
    public m<c.c.a.a.a.b.b.a.a.a> a(String str, int i, String str2, String str3) {
        return a(this.f3529a.a(str, i, str2, str3, true));
    }

    private <T> m<T> a(m<D<T>> mVar) {
        return (m<T>) mVar.c(a());
    }

    private <T> f<D<T>, T> a() {
        return new f() { // from class: c.c.a.a.a.b.b.a.b.a
            @Override // io.reactivex.c.f
            public final Object apply(Object obj) {
                return d.a((D) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object a(D d2) throws Exception {
        if (d2.c()) {
            return d2.a();
        }
        int b2 = d2.b();
        if (b2 != ServiceError.KINEMASTER_SERVER_UNAUTHORIZED.getErrorCode()) {
            if (b2 == ServiceError.KINEMASTER_SERVER_NOT_FOUND.getErrorCode()) {
                throw new DciServiceException(ServiceError.KINEMASTER_SERVER_NOT_FOUND, null);
            }
            throw new DciServiceException(ServiceError.UNKNOWN_ERROR, null);
        }
        throw new AuthServiceException(ServiceError.KINEMASTER_SERVER_UNAUTHORIZED, null);
    }
}

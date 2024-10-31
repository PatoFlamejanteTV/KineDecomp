package c.c.a.a.a.b.b;

import android.annotation.SuppressLint;
import c.c.a.a.a.b.a.e;
import c.c.a.a.a.b.b.c;
import com.kinemaster.module.network.kinemaster.error.ServiceError;
import com.kinemaster.module.network.kinemaster.error.ServiceException;
import com.kinemaster.module.network.kinemaster.service.dci.error.DciServiceException;
import io.reactivex.m;

/* compiled from: DciServiceImpl.java */
@SuppressLint({"CheckResult"})
/* loaded from: classes2.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private c.c.a.a.a.b.b.a.b.c f3531a;

    /* renamed from: b, reason: collision with root package name */
    private e f3532b;

    public d(c.c.a.a.a.b.b.a.b.c cVar, e eVar) {
        this.f3531a = cVar;
        this.f3532b = eVar;
    }

    @Override // c.c.a.a.a.b.b.c
    public void a(String str, int i, String str2, String str3, final c.b<c.c.a.a.a.b.b.a.a.a> bVar, final c.a aVar) {
        m a2 = this.f3532b.a(this.f3531a.a(str, i, str2, str3)).b(io.reactivex.g.b.b()).a(io.reactivex.a.b.b.a());
        bVar.getClass();
        a2.a(new io.reactivex.c.e() { // from class: c.c.a.a.a.b.b.b
            @Override // io.reactivex.c.e
            public final void accept(Object obj) {
                c.b.this.onSuccess((c.c.a.a.a.b.b.a.a.a) obj);
            }
        }, new io.reactivex.c.e() { // from class: c.c.a.a.a.b.b.a
            @Override // io.reactivex.c.e
            public final void accept(Object obj) {
                d.this.a(aVar, (Throwable) obj);
            }
        });
    }

    public /* synthetic */ void a(c.a aVar, Throwable th) throws Exception {
        aVar.a(a(th));
    }

    private DciServiceException a(Throwable th) {
        if (th instanceof ServiceException) {
            return new DciServiceException(((ServiceException) th).getServiceError(), th);
        }
        return new DciServiceException(ServiceError.UNKNOWN_ERROR, th);
    }
}

package c.c.a.a.a.b.b;

import com.kinemaster.module.network.kinemaster.service.dci.error.DciServiceException;

/* compiled from: DciService.java */
/* loaded from: classes2.dex */
public interface c {

    /* compiled from: DciService.java */
    @FunctionalInterface
    /* loaded from: classes2.dex */
    public interface a {
        void a(DciServiceException dciServiceException);
    }

    /* compiled from: DciService.java */
    @FunctionalInterface
    /* loaded from: classes2.dex */
    public interface b<T> {
        void onSuccess(T t);
    }

    void a(String str, int i, String str2, String str3, b<c.c.a.a.a.b.b.a.a.a> bVar, a aVar);
}

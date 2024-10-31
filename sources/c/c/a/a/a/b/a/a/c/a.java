package c.c.a.a.a.b.a.a.c;

import io.reactivex.m;
import retrofit2.b.d;
import retrofit2.b.l;

/* compiled from: AuthApi.java */
/* loaded from: classes2.dex */
public interface a {
    @d
    @l("oauth/v3/auth/authorize")
    m<c.c.a.a.a.b.a.a.b.a> a(@retrofit2.b.b("app_uuid") String str, @retrofit2.b.b("app_name") String str2, @retrofit2.b.b("app_version") String str3, @retrofit2.b.b("app_ucode") String str4, @retrofit2.b.b("client_id") String str5, @retrofit2.b.b("application") String str6, @retrofit2.b.b("edition") String str7, @retrofit2.b.b("scope") int i, @retrofit2.b.b("lifetime") int i2);
}

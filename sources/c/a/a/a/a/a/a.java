package c.a.a.a.a.a;

import c.a.a.a.c;
import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.auth.AdobeAuthUserProfile;
import com.adobe.creativesdk.foundation.auth.j;
import com.adobe.creativesdk.foundation.internal.auth.E;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeUXAuthManagerRestricted.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static a f3423a = null;

    /* renamed from: b */
    private static String f3424b = null;

    /* renamed from: c */
    private static boolean f3425c = false;

    /* renamed from: d */
    private E f3426d;

    private a() {
        this.f3426d = null;
        this.f3426d = E.m();
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f3423a == null) {
                f3423a = new a();
            }
            aVar = f3423a;
        }
        return aVar;
    }

    public void a(j jVar) {
        this.f3426d.a(jVar);
    }

    public AdobeAuthUserProfile c() {
        return this.f3426d.f();
    }

    public boolean d() {
        return this.f3426d.g();
    }

    public boolean e() {
        return this.f3426d.a(0L);
    }

    public boolean f() {
        return this.f3426d.i();
    }

    public void g() {
        this.f3426d.k();
    }

    public boolean h() {
        return this.f3426d.l();
    }

    public static String a() {
        return f3424b;
    }

    public boolean a(c<AdobeAuthException> cVar, String str) {
        if (f3425c) {
            return false;
        }
        boolean e2 = e();
        if (!e2) {
            if (cVar != null) {
                cVar.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CREDENTIALS_REQUIRED));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, a.class.getSimpleName(), str);
            }
        }
        return !e2;
    }

    public void b(j jVar) {
        this.f3426d.b(jVar);
    }

    public boolean b(c<AdobeAuthException> cVar, String str) {
        if (f3425c) {
            return false;
        }
        boolean f2 = f();
        if (!f2) {
            if (cVar != null) {
                cVar.a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CREDENTIALS_REQUIRED));
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, a.class.getSimpleName(), str);
            }
        }
        return !f2;
    }
}

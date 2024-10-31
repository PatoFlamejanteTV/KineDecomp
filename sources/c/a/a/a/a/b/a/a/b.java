package c.a.a.a.a.b.a.a;

import c.a.a.a.a.b.a.c.g;
import com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.ACLibraryManager;
import com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.e;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;

/* compiled from: ACLibraryManagerAppBridge.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private static b f3430a;

    /* renamed from: b */
    private final c.a.a.a.a.b.a.a f3431b;

    /* renamed from: c */
    private final e f3432c;

    /* renamed from: d */
    private c f3433d;

    /* renamed from: e */
    private com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.b f3434e;

    /* renamed from: f */
    private boolean f3435f;

    protected b(e eVar, c.a.a.a.a.b.a.a aVar) {
        this.f3432c = eVar;
        this.f3431b = aVar;
        this.f3431b.b(this);
        this.f3435f = false;
    }

    public static void a(e eVar, c.a.a.a.a.b.a.a aVar) {
        if (!f()) {
            if (g.a()) {
                f3430a = new b(eVar, aVar);
                f3430a.h();
                return;
            }
            throw new IllegalArgumentException("ACLibraryManagerAppSupportMgr : FAIL : no valid authenticated user present");
        }
        throw new IllegalArgumentException("ACLibraryManagerAppSupportMgr : instance already present");
    }

    public static b c() {
        return f3430a;
    }

    public static boolean f() {
        return f3430a != null;
    }

    private void g() {
        c cVar = this.f3433d;
        if (cVar != null) {
            cVar.b();
        }
    }

    private void h() {
        ACLibraryManager a2 = ACLibraryManager.a(this.f3432c, this.f3431b);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLogoutNotification, new a(this));
        if (a2.g()) {
            this.f3434e = new com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.b(a2);
            return;
        }
        throw new IllegalArgumentException("ACLibraryManagerAppSupportMgr : ACLibraryManager not initialized correctly");
    }

    private void i() {
        this.f3431b.c(this);
        this.f3434e.f();
        this.f3434e = null;
        this.f3433d = null;
    }

    public void b() {
        this.f3434e.a();
    }

    public com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.b d() {
        return this.f3434e;
    }

    public ACLibraryManager e() {
        return this.f3434e.d();
    }

    public void a(c cVar) {
        this.f3433d = cVar;
        if (this.f3434e.e()) {
            c cVar2 = this.f3433d;
            if (cVar2 != null) {
                cVar2.a();
            }
            this.f3434e.a();
            this.f3435f = true;
            return;
        }
        g();
    }

    public static void a() {
        b bVar = f3430a;
        if (bVar == null) {
            return;
        }
        bVar.i();
        f3430a = null;
    }
}

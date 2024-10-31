package com.adobe.creativesdk.foundation.internal.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.auth.AdobeAuthUserProfile;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.internal.ServerProtocol;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.NoSuchPaddingException;

/* compiled from: AdobeAuthManager.java */
/* loaded from: classes.dex */
public class E {

    /* renamed from: a, reason: collision with root package name */
    private static E f4799a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f4800b = "E";

    /* renamed from: g, reason: collision with root package name */
    private Map<X, b> f4805g;

    /* renamed from: h, reason: collision with root package name */
    private Map<Y, c> f4806h;
    private Map<aa, a> i;
    private boolean l;

    /* renamed from: c, reason: collision with root package name */
    private AdobeAuthOptions[] f4801c = null;

    /* renamed from: d, reason: collision with root package name */
    private AdobeAuthUserProfileImpl f4802d = null;

    /* renamed from: e, reason: collision with root package name */
    private V f4803e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4804f = false;
    private com.adobe.creativesdk.foundation.auth.j j = null;
    private Activity k = null;
    private boolean m = false;

    /* compiled from: AdobeAuthManager.java */
    /* loaded from: classes.dex */
    class a implements Observer {

        /* renamed from: a, reason: collision with root package name */
        aa f4807a;

        a(aa aaVar) {
            this.f4807a = null;
            this.f4807a = aaVar;
        }

        public void a() {
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthContiuableEventNotification, this);
        }

        public void b() {
            com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeAuthContiuableEventNotification, this);
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
            if (cVar.b() == null || cVar.b().get("Error") == null) {
                return;
            }
            this.f4807a.a((AdobeAuthException) cVar.b().get("Error"));
        }
    }

    /* compiled from: AdobeAuthManager.java */
    /* loaded from: classes.dex */
    class b implements Observer {

        /* renamed from: a, reason: collision with root package name */
        X f4809a;

        b(X x) {
            this.f4809a = null;
            this.f4809a = x;
        }

        public void a() {
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLoginExternalNotification, this);
        }

        public void b() {
            com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeAuthLoginExternalNotification, this);
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
            if (cVar.b() != null && cVar.b().get("Error") != null) {
                this.f4809a.a((AdobeAuthException) cVar.b().get("Error"));
            } else {
                this.f4809a.a(E.this.f());
            }
        }
    }

    /* compiled from: AdobeAuthManager.java */
    /* loaded from: classes.dex */
    static class c implements Observer {

        /* renamed from: a, reason: collision with root package name */
        Y f4811a;

        c(Y y) {
            this.f4811a = null;
            this.f4811a = y;
        }

        public void a() {
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLogoutNotification, this);
        }

        public void b() {
            com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeAuthLogoutNotification, this);
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
            if (cVar.b() != null && cVar.b().get("Error") != null) {
                this.f4811a.a((AdobeAuthException) cVar.b().get("Error"));
            } else {
                this.f4811a.onSuccess();
            }
        }
    }

    private E() {
        this.f4805g = null;
        this.f4806h = null;
        this.i = null;
        this.f4805g = new HashMap();
        this.f4806h = new HashMap();
        this.i = new HashMap();
    }

    private void c(com.adobe.creativesdk.foundation.auth.j jVar) {
        this.j = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j() {
        return f4799a != null;
    }

    public static E m() {
        if (f4799a == null) {
            f4799a = new E();
        }
        return f4799a;
    }

    private Context n() {
        return c.a.a.a.c.a.a.b().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdobeAuthIdentityManagementService o() {
        return AdobeAuthIdentityManagementService.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p() {
        new Handler(n().getMainLooper()).post(new D(this));
    }

    private boolean q() {
        return n() != null;
    }

    public com.adobe.creativesdk.foundation.auth.j d() {
        return this.j;
    }

    public V e() {
        return this.f4803e;
    }

    public AdobeAuthUserProfile f() {
        if (!q() || !i()) {
            return null;
        }
        this.f4802d = new AdobeAuthUserProfileImpl();
        AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
        String e2 = o().e();
        if (e2 != null) {
            this.f4802d.setAdobeID(e2);
            this.f4802d.setDisplayName(K.t());
            this.f4802d.setCountrycode(K.n());
            this.f4802d.setFirstName(K.y());
            this.f4802d.setLastName(K.C());
            this.f4802d.setEmail(K.u());
            this.f4802d.setEmailVerified(K.v() != null && K.v().equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            this.f4802d.setEnterprise(K.B() != null && K.B().equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            return this.f4802d;
        }
        throw new RuntimeException("User profile not available. But user Authenticated");
    }

    public boolean g() {
        return this.l;
    }

    public boolean h() {
        Date d2;
        String c2 = o().c();
        if (c2 != null && c2.length() > 0 && (d2 = o().d()) != null) {
            if (d2.getTime() - new Date().getTime() > 0) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4800b, "Inside hasValidAccessToken(inside if) and expireTime=" + d2.toString() + " and current time" + new Date().toString());
                return true;
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4800b, "Inside hasValidAccessToken(inside else) and expireTime=" + d2.toString() + " and current time" + new Date().toString());
        }
        return false;
    }

    public boolean i() {
        if (q()) {
            return (h() || a()) && AdobeAuthIdentityManagementService.K().e() != null;
        }
        return false;
    }

    public void k() {
        String str;
        AdobeAuthUserProfile f2 = f();
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Authentication", "logout() called");
        com.adobe.creativesdk.foundation.internal.analytics.f fVar = new com.adobe.creativesdk.foundation.internal.analytics.f(AdobeAnalyticsEventParams.Type.AdobeEventTypeAppLogout.getValue());
        fVar.a(o().A(), o().F(), o().G());
        if (this.f4804f) {
            fVar.a(AdobeAnalyticsEventParams.Core.AdobeEventPropertySubType.getValue(), "token_deleted");
            this.f4804f = false;
        }
        if (f2 != null) {
            com.adobe.creativesdk.foundation.internal.analytics.q.a("Logout Attempt", f2.getAdobeID());
            str = f2.getAdobeID();
        } else {
            str = null;
        }
        if (n() == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Error", new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_AUTH_MODULE_NOT_INITIALIZED));
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeAuthLogoutNotification, hashMap));
            return;
        }
        B b2 = new B(this, str, fVar);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Authentication", "Calling getImSService-Signout");
        o().a(b2);
    }

    public boolean l() {
        if (!q()) {
            return false;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Authentication", "reAuthenticate() called");
            ReentrantLock reentrantLock = new ReentrantLock();
            Condition newCondition = reentrantLock.newCondition();
            A a2 = new A(this);
            Date d2 = o().d();
            if (d2 != null && d2.getTime() - new Date().getTime() > 0) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Authentication", "Access token required reauthentication sooner than expected.");
            }
            C0321z c0321z = new C0321z(this, reentrantLock, a2, newCondition);
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLoginNotification, c0321z);
            a(AdobeAuthInteraction.AdobeAuthInteractionHeadless, false);
            reentrantLock.lock();
            while (!a2.f4744a) {
                try {
                    newCondition.await();
                } catch (InterruptedException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "Authentication", "Reauthenticate: Can not acquire permit.", e2);
                }
            }
            reentrantLock.unlock();
            return c0321z.f4932a;
        }
        throw new RuntimeException("ReAuthenticate called on Main Thread!");
    }

    public String c() {
        return AdobeAuthIdentityManagementService.K().m();
    }

    public AdobeAuthException b() {
        return AdobeAuthIdentityManagementService.K().k();
    }

    public void b(com.adobe.creativesdk.foundation.auth.j jVar) {
        c(jVar);
        Context c2 = this.j.c();
        AdobeAuthErrorCode a2 = this.j.a();
        if (a2 != null) {
            if (a2 == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_AGE_VERIFICATION || a2 == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_UPDATED_TOU || a2 == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_EMAIL_VERIFICATION) {
                AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
                if (a2.toString().equals(K.l())) {
                    String m = K.m();
                    if (c2 == null) {
                        c2 = this.j.d();
                    }
                    Intent intent = new Intent(c2, (Class<?>) AdobeAuthContinuableEventActivity.class);
                    if (m != null) {
                        intent.putExtra(C0297a.f4872e, m);
                    }
                    c2.startActivity(intent);
                    K.a();
                }
            }
        }
    }

    public void a(Activity activity) {
        this.k = activity;
    }

    public void a(String str, String str2, String str3, String[] strArr, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (q()) {
            AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
            this.f4801c = new AdobeAuthOptions[]{AdobeAuthOptions.AdobeAuthOptionsHideSignUpOnSignIn};
            K.a(bArr);
            K.u(str3);
            K.a(str, str2, (String) null, (String) null, (String) null);
            K.a(AdobeAuthIMSGrantType.AdobeAuthIMSGrantTypeAuthorization);
            a(strArr);
            this.l = false;
        }
    }

    private void a(String[] strArr) {
        if (!q() || strArr == null || strArr.length <= 0) {
            return;
        }
        AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str);
        }
        arrayList.add("openid");
        K.a((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public void b(X x) {
        if (this.f4805g.containsKey(x)) {
            this.f4805g.get(x).b();
            this.f4805g.remove(x);
        }
    }

    public void b(Y y) {
        if (this.f4806h.containsKey(y)) {
            this.f4806h.get(y).b();
            this.f4806h.remove(y);
        }
    }

    public void b(aa aaVar) {
        if (this.i.containsKey(aaVar)) {
            this.i.get(aaVar).b();
            this.i.remove(aaVar);
        }
    }

    public void a(com.adobe.creativesdk.foundation.auth.j jVar) {
        if (jVar != null) {
            a(jVar.g());
            if (jVar.e() != null) {
                a(jVar.e());
            }
        }
        c(jVar);
        com.adobe.creativesdk.foundation.internal.analytics.q.a("Login Start", null);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Authentication", "login() called");
        if (h()) {
            a(true);
            return;
        }
        String adobeID = f() != null ? f().getAdobeID() : null;
        if (AdobeAuthIdentityManagementService.K().c() != null) {
            com.adobe.creativesdk.foundation.internal.analytics.q.a("Expired Authentication Token", adobeID);
        } else {
            com.adobe.creativesdk.foundation.internal.analytics.q.a("Missing Authentication Token", null);
        }
        a(AdobeAuthInteraction.AdobeAuthInteractionInteractive, true);
    }

    public void a(X x) {
        this.f4805g.put(x, new b(x));
        this.f4805g.get(x).a();
    }

    public void a(Y y) {
        this.f4806h.put(y, new c(y));
        this.f4806h.get(y).a();
    }

    public void a(aa aaVar) {
        this.i.put(aaVar, new a(aaVar));
        this.i.get(aaVar).a();
    }

    void a(V v) {
        this.f4803e = v;
    }

    private void a(AdobeAuthInteraction adobeAuthInteraction, boolean z) {
        com.adobe.creativesdk.foundation.internal.analytics.q.a("Login Attempt", f() != null ? f().getAdobeID() : null);
        com.adobe.creativesdk.foundation.internal.analytics.f fVar = new com.adobe.creativesdk.foundation.internal.analytics.f(AdobeAnalyticsEventParams.Type.AdobeEventTypeAppLogin.getValue());
        fVar.a(o().A(), o().D(), o().E());
        C c2 = new C(this, fVar, z, adobeAuthInteraction);
        a(c2);
        o().a(c2);
    }

    public boolean a() {
        boolean z;
        Date s;
        Date J;
        AdobeAuthIdentityManagementService o = o();
        String r = o.r();
        String I = o.I();
        if (I == null || I.length() <= 0 || (J = o().J()) == null) {
            z = false;
        } else {
            z = J.getTime() - new Date().getTime() > 0;
            if (z) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4800b, "Getting access token through refresh token");
            }
        }
        if (!z && r != null && r.length() > 0 && (s = o().s()) != null) {
            z = s.getTime() - new Date().getTime() > 0;
            if (z) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4800b, "Getting access token through device token");
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AdobeAuthException adobeAuthException) {
        String adobeID = f() != null ? f().getAdobeID() : null;
        if (adobeAuthException.getErrorCode() == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CANCELLED) {
            com.adobe.creativesdk.foundation.internal.analytics.q.a("Login Cancel", adobeID);
        } else {
            com.adobe.creativesdk.foundation.internal.analytics.q.a("Login Failure", adobeID);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Error", adobeAuthException);
        AdobeInternalNotificationID adobeInternalNotificationID = AdobeInternalNotificationID.AdobeAuthLoginNotification;
        if (z) {
            adobeInternalNotificationID = AdobeInternalNotificationID.AdobeAuthLoginExternalNotification;
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(adobeInternalNotificationID, hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        AdobeInternalNotificationID adobeInternalNotificationID = AdobeInternalNotificationID.AdobeAuthLoginNotification;
        com.adobe.creativesdk.foundation.internal.analytics.q.a("Login Success", f() != null ? f().getAdobeID() : null);
        if (z) {
            adobeInternalNotificationID = AdobeInternalNotificationID.AdobeAuthLoginExternalNotification;
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(adobeInternalNotificationID, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdobeAuthException adobeAuthException) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error", adobeAuthException);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeAuthContiuableEventNotification, hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        int i2;
        boolean z;
        Context c2 = this.j.c();
        int b2 = this.j.b();
        boolean z2 = false;
        if (c2 == null) {
            c2 = this.j.d();
            i2 = b2 | 268435456;
            z = false;
        } else {
            i2 = b2;
            z = true;
        }
        Intent intent = new Intent(c2, (Class<?>) AdobeAuthSignInActivity.class);
        boolean z3 = AdobeAuthIdentityManagementService.K().p() != null;
        if (!z3) {
            z2 = z3;
        } else if (c.a.a.a.a.a.a.a() != null) {
            z2 = c.a.a.a.a.a.a.a().equalsIgnoreCase("com.adobe.creativesdk.foundation.auth.adobeID");
        }
        if (z2) {
            intent.putExtra("uxauth_trysharedtoken", true);
        }
        intent.putExtra(C0297a.f4871d, i);
        intent.addFlags(i2);
        if (z) {
            ((Activity) c2).startActivityForResult(intent, this.j.f());
        } else {
            c2.startActivity(intent);
        }
    }

    public boolean a(long j) {
        Date d2;
        String c2 = o().c();
        return c2 != null && c2.length() > 0 && (d2 = o().d()) != null && d2.getTime() > new Date().getTime() + (j * 1000);
    }

    public void a(String str) {
        o().u(str);
    }
}

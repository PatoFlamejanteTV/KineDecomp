package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import com.adobe.creativesdk.foundation.auth.k;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.auth.E;
import com.adobe.creativesdk.foundation.internal.net.A;
import com.adobe.creativesdk.foundation.internal.net.G;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;

/* compiled from: AdobeCloudServiceSession.java */
/* loaded from: classes.dex */
public abstract class g implements G, Observer {

    /* renamed from: a */
    private HashMap<String, A> f3954a;

    /* renamed from: b */
    private Timer f3955b;

    /* renamed from: c */
    private Timer f3956c;

    /* renamed from: d */
    private boolean f3957d;

    /* renamed from: e */
    private boolean f3958e;

    /* renamed from: f */
    private boolean f3959f;

    /* renamed from: g */
    private com.adobe.creativesdk.foundation.internal.notification.d f3960g;

    /* renamed from: h */
    private AdobeCloudEndpoint f3961h;
    private boolean i;

    public g() {
        this.f3954a = new HashMap<>();
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLoginNotification, this);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLoginExternalNotification, this);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLogoutNotification, this);
    }

    public void k() {
        if (!k.a().c()) {
            m();
            return;
        }
        if (this.f3957d) {
            return;
        }
        Iterator<Map.Entry<String, A>> it = this.f3954a.entrySet().iterator();
        while (it.hasNext()) {
            A value = it.next().getValue();
            if (value == null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, g.class.getSimpleName(), "Network service not set up for " + getClass().getSimpleName() + " timer");
            } else if (this.f3960g == null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, g.class.getSimpleName(), "Disconnect notifier not set up for " + getClass().getSimpleName() + " timer");
            } else if (value.f()) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, g.class.getSimpleName(), getClass().getSimpleName() + " isConnected is true.  Cancel timer.");
                this.f3955b.cancel();
                this.f3955b = null;
            } else if (!this.f3958e) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, g.class.getSimpleName(), "Attempting to reconnect " + getClass().getSimpleName());
                value.g();
                this.f3958e = true;
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, g.class.getSimpleName(), "Failed to reconnect " + getClass().getSimpleName() + ". Sending " + this.f3960g);
                com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(this.f3960g, null));
                value.g();
                Timer timer = this.f3955b;
                if (timer != null) {
                    timer.cancel();
                    this.f3955b = null;
                }
                this.f3958e = false;
            }
        }
    }

    public void l() {
        if (this.f3959f && !k.a().c()) {
            h();
            return;
        }
        if (this.f3957d) {
            for (Map.Entry<String, A> entry : this.f3954a.entrySet()) {
                A value = entry.getValue();
                entry.getKey();
                if (value == null) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, g.class.getSimpleName(), "Network service not set up for " + getClass().getSimpleName() + " timer");
                } else if (this.f3960g == null) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, g.class.getSimpleName(), "Disconnect notification not set up for " + getClass().getSimpleName() + " timer");
                } else if (!value.f()) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, g.class.getSimpleName(), "Ongoing timer.  Attempting to reconnect " + getClass().getSimpleName());
                    value.g();
                }
            }
        }
    }

    private void m() {
        if (this.f3955b != null) {
            synchronized (this) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, g.class.getSimpleName(), "Stopping connection timer");
                this.f3955b.cancel();
                this.f3955b = null;
                this.f3958e = false;
            }
        }
    }

    public A c(String str) {
        if (str == null) {
            Iterator<Map.Entry<String, A>> it = this.f3954a.entrySet().iterator();
            if (it.hasNext()) {
                str = it.next().getKey();
            }
        }
        if (str != null) {
            return this.f3954a.get(str);
        }
        return null;
    }

    public HashMap<String, A> d() {
        return this.f3954a;
    }

    public A e() {
        return c((String) null);
    }

    public boolean f() {
        return this.i;
    }

    protected void finalize() {
        j();
    }

    public void g() {
    }

    protected synchronized void h() {
        if (this.f3956c != null) {
            this.f3957d = false;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, g.class.getSimpleName(), "Stopping ongoing connection timer");
            this.f3956c.cancel();
            this.f3956c = null;
        }
    }

    public void i() {
        Iterator<A> it = d().values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    protected void j() {
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeAuthLoginNotification, this);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeAuthLoginExternalNotification, this);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeAuthLogoutNotification, this);
        i();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
        if (cVar.a() == AdobeInternalNotificationID.AdobeAuthLogoutNotification && cVar.b() == null) {
            i();
            m();
            h();
            Iterator<Map.Entry<String, A>> it = this.f3954a.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().b();
            }
            this.f3954a.clear();
            return;
        }
        if (cVar.a() == AdobeInternalNotificationID.AdobeAuthLoginNotification || cVar.a() == AdobeInternalNotificationID.AdobeAuthLoginExternalNotification) {
            AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
            Iterator<Map.Entry<String, A>> it2 = this.f3954a.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, A> next = it2.next();
                A value = next.getValue();
                String key = next.getKey();
                value.a(K.c());
                value.a(false);
                AdobeCloudEndpoint adobeCloudEndpoint = this.f3961h;
                if (adobeCloudEndpoint != null) {
                    URL url = adobeCloudEndpoint.getServiceURLs() != null ? this.f3961h.getServiceURLs().get(key) : null;
                    if (url != null) {
                        value.a(url);
                    } else if (this.f3961h.getServiceURLs() != null && this.f3961h.getServiceURLs().size() > 0) {
                        if (key.equals("default")) {
                            Iterator<Map.Entry<String, URL>> it3 = this.f3961h.getServiceURLs().entrySet().iterator();
                            if (it2.hasNext()) {
                                it3.next();
                                next.getKey();
                            }
                            value.a(this.f3961h.getServiceURLs().get(key));
                        } else {
                            value.a((URL) null);
                        }
                    }
                }
            }
            g();
        }
    }

    private boolean d(A a2) {
        boolean l = E.m().l();
        if (l) {
            a2.a(AdobeAuthIdentityManagementService.K().c());
            a2.a(false);
        }
        return l;
    }

    public void a(boolean z) {
        this.i = z;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.G
    public boolean b(A a2) {
        return d(a2);
    }

    public void a(String str, A a2) {
        this.f3954a.put(str, a2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.G
    public void a(A a2) {
        m();
    }

    private void a(long j, A a2) {
        if (this.f3957d) {
            return;
        }
        A a3 = null;
        Iterator<Map.Entry<String, A>> it = this.f3954a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, A> next = it.next();
            if (a2.equals(next.getValue())) {
                a3 = next.getValue();
                break;
            }
        }
        if (a3 == null) {
            this.f3954a.put("default", a2);
        }
        if (this.f3955b == null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, g.class.getSimpleName(), "Check connection for in " + j + " secs.");
            this.f3955b = new Timer();
            this.f3955b.scheduleAtFixedRate(new e(this), 0L, 1000 * j);
        }
    }

    public g(A a2, String str) {
        this();
        this.f3954a.put(str == null ? "default" : str, a2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.G
    public void c(A a2) {
        a(15L, a2);
    }

    public g(AdobeCloudEndpoint adobeCloudEndpoint) {
        this();
        a(adobeCloudEndpoint);
    }

    public AdobeCloudEndpoint c() {
        return this.f3961h;
    }

    public void a(com.adobe.creativesdk.foundation.internal.notification.d dVar) {
        this.f3960g = dVar;
    }

    public void a(AdobeCloudEndpoint adobeCloudEndpoint) {
        if (adobeCloudEndpoint == null) {
            return;
        }
        AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
        String c2 = K.c();
        HashMap hashMap = new HashMap();
        String format = String.format("%s%s", "CreativeSDK", c.a.a.a.a.d());
        hashMap.put("x-api-key", K.h());
        hashMap.put("x-creativesdk-versions", format);
        for (Map.Entry<String, URL> entry : adobeCloudEndpoint.getServiceURLs().entrySet()) {
            A a2 = new A(entry.getValue().toString(), K.h(), hashMap);
            a2.a(c2);
            a2.a(this);
            this.f3954a.put(entry.getKey(), a2);
        }
        this.f3961h = adobeCloudEndpoint;
    }

    public void a(long j, boolean z) {
        this.f3957d = true;
        this.f3959f = z;
        if (this.f3956c == null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, g.class.getSimpleName(), "Set up " + getClass().getSimpleName() + " ongoing connection timer at " + j + " secs.");
            this.f3956c = new Timer();
            this.f3956c.scheduleAtFixedRate(new f(this), 0L, 1000 * j);
        }
    }
}

package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class A {

    /* renamed from: a */
    private static int f5064a = 10;

    /* renamed from: b */
    private static int f5065b = 10;

    /* renamed from: c */
    private static List<Date> f5066c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d */
    private static Map<String, Boolean> f5067d = new LinkedHashMap();

    /* renamed from: e */
    private static Object f5068e = new Object();

    /* renamed from: f */
    private URL f5069f;

    /* renamed from: g */
    private String f5070g;

    /* renamed from: h */
    private Map<String, String> f5071h;
    private int i;
    private String j = null;
    private G k = null;
    private k l;
    private AtomicInteger m;

    /* compiled from: AdobeNetworkHttpService.java */
    /* loaded from: classes.dex */
    public interface a extends Runnable {
        void a();
    }

    public A(String str, String str2, Map<String, String> map) {
        this.f5069f = null;
        this.f5070g = null;
        this.f5071h = null;
        this.i = 5;
        this.l = null;
        this.m = null;
        try {
            this.f5069f = new URL(str);
        } catch (MalformedURLException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, A.class.getName(), "Malformed url", e2);
        }
        this.f5070g = str2;
        this.f5071h = map;
        this.i = 5;
        f5065b = 5;
        this.m = new AtomicInteger(0);
        int i = this.i;
        this.l = new k(i, i, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public void b() {
        this.l.shutdownNow();
        int i = this.i;
        this.l = new k(i, i, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public synchronized String c() {
        return this.j;
    }

    public URL d() {
        return this.f5069f;
    }

    public synchronized boolean e() {
        boolean z;
        z = false;
        if (f5066c.size() >= f5064a) {
            Date date = new Date();
            synchronized (f5066c) {
                int i = 0;
                while (true) {
                    if (i >= f5066c.size()) {
                        break;
                    }
                    if (date.getTime() - f5066c.get(i).getTime() > 300000) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
        }
        return z;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof A)) {
            return false;
        }
        A a2 = (A) obj;
        return a(this.j, a2.j) & a(this.f5069f, a2.f5069f) & a(this.f5070g, a2.f5070g);
    }

    public synchronized boolean f() {
        return this.m.get() < f5065b;
    }

    public synchronized void g() {
        this.m.set(0);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public E b(j jVar, String str, AdobeNetworkRequestPriority adobeNetworkRequestPriority, F f2, Handler handler) {
        a(jVar);
        E e2 = new E();
        e2.a(handler);
        v vVar = new v(this, e2, f2, handler);
        w wVar = new w(this, jVar, str, vVar, e2, f2, handler);
        vVar.f5126a = wVar;
        wVar.a();
        return e2;
    }

    public void a(G g2) {
        this.k = g2;
    }

    public void a(URL url) {
        this.f5069f = url;
    }

    public void a(boolean z) {
        if (z) {
            this.l.a();
        } else {
            this.l.b();
        }
    }

    public URL a() {
        return this.f5069f;
    }

    public void a(String str) {
        synchronized (f5066c) {
            this.j = str;
            if (str != null) {
                if (f5066c.size() >= f5064a) {
                    f5066c.remove(f5066c.size() - 1);
                }
                f5066c.add(new Date());
            } else {
                f5066c = Collections.synchronizedList(new ArrayList());
            }
        }
    }

    public E a(j jVar, AdobeNetworkRequestPriority adobeNetworkRequestPriority, F f2, Handler handler) {
        a(jVar);
        E e2 = new E();
        r rVar = new r(this, e2, f2, handler);
        s sVar = new s(this, jVar, rVar, e2, f2, handler);
        rVar.f5126a = sVar;
        sVar.a();
        return e2;
    }

    public l a(j jVar, AdobeNetworkRequestPriority adobeNetworkRequestPriority) {
        a(jVar);
        if (f()) {
            C0325d c0325d = new C0325d();
            E e2 = new E();
            String c2 = c();
            c0325d.a(jVar, c2, null, e2);
            try {
                Future<l> submit = this.l.submit(c0325d);
                e2.a(submit);
                e2.a(c2);
                return submit.get();
            } catch (Exception e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "NetworkService", "Network Disconnected!", e3);
            }
        }
        return null;
    }

    public E a(j jVar, String str, AdobeNetworkRequestPriority adobeNetworkRequestPriority, F f2, Handler handler) {
        a(jVar);
        E e2 = new E();
        e2.a(handler);
        t tVar = new t(this, e2, f2, handler);
        u uVar = new u(this, jVar, str, tVar, e2, f2, handler);
        tVar.f5126a = uVar;
        uVar.a();
        return e2;
    }

    public E a(j jVar, InputStream inputStream, AdobeNetworkRequestPriority adobeNetworkRequestPriority, F f2, Handler handler) {
        a(jVar);
        E e2 = new E();
        e2.a(handler);
        x xVar = new x(this, e2, f2, handler);
        y yVar = new y(this, jVar, inputStream, xVar, e2, f2, handler);
        xVar.f5126a = yVar;
        yVar.a();
        return e2;
    }

    public E a(j jVar, String str, ArrayList<C0322a> arrayList, F f2, Handler handler) {
        a(jVar);
        E e2 = new E();
        e2.a(handler);
        z zVar = new z(this, e2, f2, handler);
        n nVar = new n(this, jVar, zVar, e2, str, arrayList, f2, handler);
        zVar.f5126a = nVar;
        nVar.a();
        return e2;
    }

    private void a(l lVar) {
        Map<String, List<String>> e2;
        if (lVar == null || (e2 = lVar.e()) == null || e2.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : e2.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (key != null) {
                hashMap.put(key.toLowerCase(), value);
            }
        }
        lVar.a(hashMap);
    }

    public void a(l lVar, E e2, Runnable runnable, F f2, Handler handler) {
        G g2;
        a(lVar);
        if (lVar != null) {
            boolean z = false;
            if (lVar.g() == 401) {
                synchronized (f5068e) {
                    String b2 = e2.b();
                    if (b2 == null) {
                        b2 = "no-token" + com.adobe.creativesdk.foundation.internal.utils.n.a();
                    }
                    boolean containsKey = f5067d.containsKey(b2);
                    if (containsKey ? f5067d.get(b2).booleanValue() : false) {
                        a(AdobeAuthIdentityManagementService.K().c());
                        z = true;
                    } else if (!containsKey) {
                        if (this.k != null) {
                            this.l.a();
                            z = this.k.b(this);
                        }
                        f5067d.put(b2, Boolean.valueOf(z));
                    }
                }
            }
            if (lVar.g() == 401 && !a(e2)) {
                this.m.incrementAndGet();
                if (this.k != null && !f()) {
                    this.k.c(this);
                }
            }
            if (lVar.g() < 400 && !lVar.i() && (g2 = this.k) != null) {
                g2.a(this);
            }
            if (z) {
                runnable.run();
                return;
            } else {
                a(new o(this, f2, lVar, e2), handler);
                return;
            }
        }
        a(new p(this, f2, e2), handler);
    }

    private void a(Runnable runnable, Handler handler) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            new Thread(runnable).start();
        }
    }

    public void a(F f2, Handler handler) {
        q qVar = new q(this, f2);
        if (handler != null) {
            handler.post(qVar);
        } else {
            new Thread(qVar).start();
        }
    }

    private boolean a(E e2) {
        return e2.c();
    }

    private void a(j jVar) {
        Map<String, String> map = this.f5071h;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jVar.f().put(entry.getKey(), entry.getValue());
        }
    }

    private boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    private boolean a(URL url, URL url2) {
        if (url == null && url2 == null) {
            return true;
        }
        if (url == null || url2 == null) {
            return false;
        }
        return url.getPath().equals(url2.getPath());
    }
}

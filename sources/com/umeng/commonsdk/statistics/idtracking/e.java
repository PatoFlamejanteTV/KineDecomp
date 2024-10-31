package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: IdTracker.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final long f26406a = 86400000;

    /* renamed from: b, reason: collision with root package name */
    public static e f26407b;
    private static Object j = new Object();

    /* renamed from: d, reason: collision with root package name */
    private File f26409d;

    /* renamed from: f, reason: collision with root package name */
    private long f26411f;
    private a i;

    /* renamed from: c, reason: collision with root package name */
    private final String f26408c = "umeng_it.cache";

    /* renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f26410e = null;

    /* renamed from: h, reason: collision with root package name */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f26413h = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private long f26412g = 86400000;

    /* compiled from: IdTracker.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Context f26414a;

        /* renamed from: b, reason: collision with root package name */
        private Set<String> f26415b = new HashSet();

        public a(Context context) {
            this.f26414a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f26415b.contains(str);
        }

        public synchronized void b(String str) {
            this.f26415b.add(str);
        }

        public void c(String str) {
            this.f26415b.remove(str);
        }

        public synchronized void a() {
            if (!this.f26415b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.f26415b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f26414a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f26414a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f26415b.add(str);
                    }
                }
            }
        }
    }

    e(Context context) {
        this.i = null;
        this.f26409d = new File(context.getFilesDir(), "umeng_it.cache");
        this.i = new a(context);
        this.i.b();
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f26407b == null) {
                f26407b = new e(context);
                f26407b.a(new f(context));
                f26407b.a(new b(context));
                f26407b.a(new r(context));
                f26407b.a(new d(context));
                f26407b.a(new c(context));
                f26407b.a(new g(context));
                f26407b.a(new j());
                f26407b.a(new s(context));
                q qVar = new q(context);
                if (!TextUtils.isEmpty(qVar.f())) {
                    f26407b.a(qVar);
                }
                i iVar = new i(context);
                if (iVar.g()) {
                    f26407b.a(iVar);
                    f26407b.a(new h(context));
                    iVar.i();
                }
                if (SdkVersion.SDK_TYPE != 1) {
                    f26407b.a(new p(context));
                    f26407b.a(new m(context));
                    f26407b.a(new o(context));
                    f26407b.a(new n(context));
                    f26407b.a(new l(context));
                    f26407b.a(new k(context));
                }
                f26407b.e();
            }
            eVar = f26407b;
        }
        return eVar;
    }

    private synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f26413h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    hashMap.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(hashMap);
        synchronized (this) {
            this.f26410e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c h() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (j) {
            if (!this.f26409d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f26409d);
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
            try {
                try {
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                    com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                    new com.umeng.commonsdk.proguard.m().a(cVar, readStreamToByteArray);
                    HelperUtils.safeClose(fileInputStream);
                    return cVar;
                } catch (Throwable th3) {
                    th = th3;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                HelperUtils.safeClose(fileInputStream);
                return null;
            }
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c b() {
        return this.f26410e;
    }

    public String c() {
        return null;
    }

    public synchronized void d() {
        boolean z = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f26413h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z = true;
            }
        }
        if (z) {
            this.f26410e.b(false);
            f();
        }
    }

    public synchronized void e() {
        com.umeng.commonsdk.statistics.proto.c h2 = h();
        if (h2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f26413h.size());
        synchronized (this) {
            this.f26410e = h2;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f26413h) {
                aVar.a(this.f26410e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f26413h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
            }
            g();
        }
    }

    public synchronized void f() {
        if (this.f26410e != null) {
            a(this.f26410e);
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.i.a(aVar.b())) {
            return this.f26413h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j2) {
        this.f26412g = j2;
    }

    public synchronized void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f26411f >= this.f26412g) {
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f26413h) {
                if (aVar.c() && aVar.a()) {
                    z = true;
                    if (!aVar.c()) {
                        this.i.b(aVar.b());
                    }
                }
            }
            if (z) {
                g();
                this.i.a();
                f();
            }
            this.f26411f = currentTimeMillis;
        }
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a2;
        synchronized (j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a2 = new com.umeng.commonsdk.proguard.s().a(cVar);
                    }
                    if (a2 != null) {
                        HelperUtils.writeFile(this.f26409d, a2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}

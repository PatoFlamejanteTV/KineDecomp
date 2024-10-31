package com.adobe.creativesdk.foundation.internal.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: AdobeCommonCache.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private static volatile d f4943a;

    /* renamed from: b */
    private static Context f4944b;

    /* renamed from: c */
    private static final Integer f4945c = 8;

    /* renamed from: d */
    private int f4946d;

    /* renamed from: e */
    private SharedPreferences f4947e;

    /* renamed from: f */
    private int f4948f;

    /* renamed from: g */
    private final String f4949g;

    /* renamed from: h */
    private int f4950h;
    private boolean j;
    private ExecutorService k;
    private ScheduledExecutorService l;
    private ScheduledFuture<?> n;
    private Pattern m = Pattern.compile("^[a-zA-Z0-9]{33}$");
    HashMap<String, o> i = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdobeCommonCache.java */
    /* loaded from: classes.dex */
    public class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        byte[] f4951a;

        /* renamed from: b */
        String f4952b;

        /* renamed from: c */
        String f4953c;

        /* renamed from: d */
        EnumSet<AdobeCommonCacheOptions> f4954d;

        /* renamed from: e */
        String f4955e;

        /* renamed from: f */
        c.a.a.a.b<Boolean> f4956f;

        /* renamed from: g */
        boolean f4957g = false;

        a(byte[] bArr, String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, String str3, c.a.a.a.b<Boolean> bVar) {
            this.f4951a = bArr;
            this.f4952b = str;
            this.f4953c = str2;
            this.f4954d = enumSet;
            this.f4955e = str3;
            this.f4956f = bVar;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            this.f4957g = d.this.a(this.f4951a, this.f4952b, this.f4953c, this.f4954d, this.f4955e);
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r2) {
            this.f4956f.b(Boolean.valueOf(this.f4957g));
        }
    }

    private d() {
        f4944b = c.a.a.a.c.a.a.b().a();
        this.f4949g = f4944b.getCacheDir().getAbsolutePath();
        this.f4947e = f4944b.getSharedPreferences("Foundation", 0);
        this.f4946d = this.f4947e.getInt("CCCache.version", -1);
        if (this.f4946d != f4945c.intValue()) {
            c();
            SharedPreferences.Editor edit = this.f4947e.edit();
            edit.putInt("CCCache.version", f4945c.intValue());
            edit.commit();
        }
        this.f4948f = 86400000;
        this.f4950h = 1800000;
        a(this.f4948f);
        d();
        this.k = Executors.newCachedThreadPool();
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAuthLogoutNotification, new c(this));
    }

    private void d() {
        e();
        if (this.l == null) {
            this.l = Executors.newSingleThreadScheduledExecutor();
        }
        this.n = this.l.scheduleAtFixedRate(new com.adobe.creativesdk.foundation.internal.cache.a(this), 0L, this.f4950h, TimeUnit.MILLISECONDS);
    }

    private void e() {
        b(false);
    }

    public boolean c(String str) {
        o oVar = this.i.get(str);
        if (oVar == null) {
            return false;
        }
        oVar.a();
        this.i.remove(str);
        return true;
    }

    public static d b() throws AdobeInvalidCacheSettingsException {
        if (f4943a == null) {
            synchronized (d.class) {
                if (f4943a == null) {
                    f4943a = new d();
                }
            }
        }
        return f4943a;
    }

    public void a(int i) {
        File file = new File(this.f4949g);
        if (file.exists()) {
            File[] listFiles = file.listFiles(new b(this));
            if (listFiles == null) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, d.class.getName(), "Failed to access disk cache root directory at " + this.f4949g);
                return;
            }
            if (listFiles.length == 0 && this.j) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, d.class.getName(), "Cache is Empty. Nothing to scrub");
            }
            a(true);
            for (File file2 : listFiles) {
                String lowerCase = file2.getName().toLowerCase();
                if (this.m.matcher(lowerCase).matches() && lowerCase.charAt(32) == '7' && new Date().getTime() - file2.lastModified() > i) {
                    try {
                        org.apache.commons.io.b.b(file2);
                        if (this.j) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, d.class.getName(), "Deleting disk cache at " + file2.getAbsolutePath());
                        }
                    } catch (IOException e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, d.class.getName(), "Error delecting disk cache during scrubbing : " + file2.getAbsolutePath(), e2);
                    }
                }
            }
            a(false);
        }
    }

    public boolean c(String str, String str2, String str3) {
        o oVar = this.i.get(str3);
        if (oVar == null) {
            return false;
        }
        oVar.c(str, str2);
        return true;
    }

    private <T> boolean d(String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, String str3, e<T> eVar, Handler handler) {
        o oVar = this.i.get(str3);
        if (oVar == null) {
            return false;
        }
        oVar.a(str, str2, enumSet, eVar, handler);
        return true;
    }

    public boolean c(String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, String str3, e<Object> eVar, Handler handler) {
        return d(str, str2, enumSet, str3, eVar, handler);
    }

    public void c() {
        File file = new File(this.f4949g);
        if (file.exists()) {
            try {
                org.apache.commons.io.b.b(file);
            } catch (IOException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, d.class.getName(), "Error removing cache", e2);
            }
            Iterator<String> it = this.i.keySet().iterator();
            while (it.hasNext()) {
                this.i.get(it.next()).a();
            }
            this.i.clear();
        }
    }

    private void b(boolean z) {
        ScheduledFuture<?> scheduledFuture = this.n;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(z);
        }
    }

    private AdobeCommonCachePolicies b(EnumSet<AdobeCommonCachePolicies> enumSet) {
        if (enumSet.contains(AdobeCommonCachePolicies.AdobeCommonCacheEvictionLSF)) {
            return AdobeCommonCachePolicies.AdobeCommonCacheEvictionLSF;
        }
        if (enumSet.contains(AdobeCommonCachePolicies.AdobeCommonCacheEvictionLRU)) {
            return AdobeCommonCachePolicies.AdobeCommonCacheEvictionLRU;
        }
        if (enumSet.contains(AdobeCommonCachePolicies.AdobeCommonCacheEvictionFIFO)) {
            return AdobeCommonCachePolicies.AdobeCommonCacheEvictionFIFO;
        }
        return AdobeCommonCachePolicies.AdobeCommonCachePolicyUnset;
    }

    public boolean b(String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, String str3, e<Map<String, Object>> eVar, Handler handler) {
        return d(str, str2, enumSet, str3, eVar, handler);
    }

    public void b(String str) {
        o oVar = this.i.get(str);
        if (oVar != null) {
            oVar.c();
        }
    }

    public void a(String str, int i, double d2, EnumSet<AdobeCommonCachePolicies> enumSet) throws AdobeInvalidCacheSettingsException {
        String str2;
        int i2;
        double d3;
        if (str != null && !str.isEmpty()) {
            if (enumSet.contains(AdobeCommonCachePolicies.AdobeCommonCachePolicyUnset) && enumSet.size() == 1) {
                throw new AdobeInvalidCacheSettingsException("Invalid cache policy.");
            }
            AdobeCommonCachePolicies b2 = b(enumSet);
            boolean a2 = a(enumSet);
            if (a2) {
                str2 = "000000000000000000000000@AdobeID";
            } else {
                str2 = AdobeAuthIdentityManagementService.K().e();
                if (str2 == null || str2.isEmpty()) {
                    throw new AdobeInvalidCacheSettingsException("Cannot configure cache before logging in");
                }
            }
            String str3 = str2;
            if (i < 0) {
                throw new AdobeInvalidCacheSettingsException("Illegal memCacheSize value " + i);
            }
            if (i > 200) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, d.class.getName(), "memCacheSize: %" + (i / 1048576) + " MB exceeds maximum value.  Setting to 0 MB.");
                i2 = 200;
            } else {
                i2 = i;
            }
            if (d2 >= 0.0d) {
                if (d2 > 2.68435456E8d) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, d.class.getName(), "diskCacheSize: " + (d2 / 1048576.0d) + "MB exceeds maximum value.  Setting to 256.0MB.");
                    d3 = 2.68435456E8d;
                } else {
                    d3 = d2;
                }
                o oVar = this.i.get(str);
                if (oVar == null) {
                    oVar = new o(this.k);
                    this.i.put(str, oVar);
                } else if (!str3.equals(oVar.b())) {
                    throw new AdobeInvalidCacheSettingsException("Attempt to reconfigure cache " + str + " with different AdobeID: " + str3 + " vs " + oVar.b());
                }
                oVar.a(str, str3, this.f4949g, i2, d3, b2, a2);
                return;
            }
            throw new AdobeInvalidCacheSettingsException("Illegal diskCacheSize value: " + ((long) d2));
        }
        throw new AdobeInvalidCacheSettingsException("Invalid cache name.");
    }

    public Date b(String str, String str2, String str3) {
        HashMap<String, o> hashMap = this.i;
        if (hashMap != null) {
            synchronized (hashMap) {
                o oVar = this.i.get(str3);
                r1 = oVar != null ? oVar.b(str, str2) : null;
            }
        }
        return r1;
    }

    private boolean a(EnumSet<AdobeCommonCachePolicies> enumSet) {
        return enumSet.contains(AdobeCommonCachePolicies.AdobeCommonCacheAllowOfflineUse);
    }

    public boolean a(String str) {
        return this.i.containsKey(str);
    }

    public void a() {
        Iterator<Map.Entry<String, o>> it = this.i.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
    }

    public void a(boolean z) {
        Iterator<Map.Entry<String, o>> it = this.i.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(z);
        }
    }

    public boolean a(Map map, String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, String str3) {
        return a((Object) map, str, str2, enumSet, str3);
    }

    public void a(byte[] bArr, String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, String str3, c.a.a.a.b<Boolean> bVar) {
        new a(bArr, str, str2, enumSet, str3, bVar).execute(new Void[0]);
    }

    public boolean a(Object obj, String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, String str3) {
        if (!(obj instanceof Serializable)) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, d.class.getName(), "Object is not serializable. Not adding " + str2 + " to cache.");
            return false;
        }
        o oVar = this.i.get(str3);
        if (oVar == null) {
            return false;
        }
        oVar.a(obj, str, str2, enumSet);
        return true;
    }

    public boolean a(String str, String str2, String str3) {
        o oVar = this.i.get(str3);
        if (oVar != null) {
            return oVar.a(str, str2);
        }
        return false;
    }

    public boolean a(String str, String str2) {
        o oVar = this.i.get(str2);
        if (oVar == null) {
            return false;
        }
        oVar.a(str);
        return true;
    }

    public <T> T a(String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, String str3) {
        o oVar = this.i.get(str3);
        if (oVar != null) {
            return (T) oVar.a(str, str2, enumSet);
        }
        return null;
    }

    public boolean a(String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, String str3, e<byte[]> eVar, Handler handler) {
        return d(str, str2, enumSet, str3, eVar, handler);
    }
}

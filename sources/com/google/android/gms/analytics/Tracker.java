package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public class Tracker extends zzd {

    /* renamed from: a, reason: collision with root package name */
    private boolean f687a;
    private final Map<String, String> b;
    private final Map<String, String> c;
    private final zzad d;
    private final a e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends zzd {
        private long b;
        private boolean c;

        protected a(zzf zzfVar) {
            super(zzfVar);
            this.b = -1L;
        }

        @Override // com.google.android.gms.analytics.internal.zzd
        protected void a() {
        }

        public synchronized boolean b() {
            boolean z;
            z = this.c;
            this.c = false;
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tracker(zzf zzfVar, String str, zzad zzadVar) {
        super(zzfVar);
        this.b = new HashMap();
        this.c = new HashMap();
        if (str != null) {
            this.b.put("&tid", str);
        }
        this.b.put("useSecure", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        this.b.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        if (zzadVar == null) {
            this.d = new zzad("tracking");
        } else {
            this.d = zzadVar;
        }
        this.e = new a(zzfVar);
    }

    private static void a(Map<String, String> map, Map<String, String> map2) {
        zzx.a(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String b = b(entry);
            if (b != null) {
                map2.put(b, entry.getValue());
            }
        }
    }

    private static boolean a(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        entry.getValue();
        return key.startsWith("&") && key.length() >= 2;
    }

    private static String b(Map.Entry<String, String> entry) {
        if (a(entry)) {
            return entry.getKey().substring(1);
        }
        return null;
    }

    private static void b(Map<String, String> map, Map<String, String> map2) {
        zzx.a(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String b = b(entry);
            if (b != null && !map2.containsKey(b)) {
                map2.put(b, entry.getValue());
            }
        }
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
        this.e.E();
        String c = v().c();
        if (c != null) {
            a("&an", c);
        }
        String b = v().b();
        if (b != null) {
            a("&av", b);
        }
    }

    public void a(String str, String str2) {
        zzx.a(str, (Object) "Key should be non-null");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, str2);
    }

    public void a(Map<String, String> map) {
        long currentTimeMillis = n().currentTimeMillis();
        if (s().f()) {
            c("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean e = s().e();
        HashMap hashMap = new HashMap();
        a(this.b, hashMap);
        a(map, hashMap);
        boolean a2 = zzam.a(this.b.get("useSecure"), true);
        b(this.c, hashMap);
        this.c.clear();
        String str = hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            p().a(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            p().a(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean b = b();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt(this.b.get("&a")) + 1;
                if (parseInt >= Integer.MAX_VALUE) {
                    parseInt = 1;
                }
                this.b.put("&a", Integer.toString(parseInt));
            }
        }
        r().a(new f(this, hashMap, b, str, currentTimeMillis, e, a2, str2));
    }

    public void a(boolean z) {
        this.f687a = z;
    }

    boolean b() {
        return this.f687a;
    }
}

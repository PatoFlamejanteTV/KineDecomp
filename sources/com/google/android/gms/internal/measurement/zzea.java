package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class zzea {
    private static volatile zzea zzadk;
    private final String zzadh;
    private final ExecutorService zzadl;
    private final AppMeasurementSdk zzadm;
    private Map<zzcy, d> zzadn;
    private int zzado;
    private boolean zzadp;
    private String zzadq;
    private zzdn zzadr;
    protected final Clock zzrz;

    /* loaded from: classes2.dex */
    public class a extends zzdr {

        /* renamed from: a */
        private final AtomicReference<Bundle> f13571a = new AtomicReference<>();

        /* renamed from: b */
        private boolean f13572b;

        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:            r9 = r9.get("r");     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final <T> T a(android.os.Bundle r9, java.lang.Class<T> r10) {
            /*
                r8 = this;
                r0 = 0
                if (r9 == 0) goto L46
                java.lang.String r1 = "r"
                java.lang.Object r9 = r9.get(r1)
                if (r9 == 0) goto L46
                java.lang.Object r9 = r10.cast(r9)     // Catch: java.lang.ClassCastException -> L10
                return r9
            L10:
                r6 = move-exception
                java.lang.String r7 = "Unexpected object type. Expected, Received"
                java.lang.String r10 = r10.getCanonicalName()
                java.lang.Class r9 = r9.getClass()
                java.lang.String r9 = r9.getCanonicalName()
                com.google.android.gms.internal.measurement.zzea r0 = com.google.android.gms.internal.measurement.zzea.this
                r1 = 5
                r2 = r7
                r3 = r10
                r4 = r9
                r5 = r6
                r0.zzc(r1, r2, r3, r4, r5)
                com.google.android.gms.internal.measurement.zzea r0 = com.google.android.gms.internal.measurement.zzea.this
                java.lang.String r0 = com.google.android.gms.internal.measurement.zzea.zzc(r0)
                java.lang.String r1 = ": %s, %s"
                java.lang.String r1 = r7.concat(r1)
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                r2[r3] = r10
                r10 = 1
                r2[r10] = r9
                java.lang.String r9 = java.lang.String.format(r1, r2)
                android.util.Log.w(r0, r9, r6)
                throw r6
            L46:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzea.a.a(android.os.Bundle, java.lang.Class):java.lang.Object");
        }

        final String b(long j) {
            return (String) a(c(j), String.class);
        }

        final Bundle c(long j) {
            Bundle bundle;
            synchronized (this.f13571a) {
                if (!this.f13572b) {
                    try {
                        this.f13571a.wait(j);
                    } catch (InterruptedException unused) {
                        return null;
                    }
                }
                bundle = this.f13571a.get();
            }
            return bundle;
        }

        @Override // com.google.android.gms.internal.measurement.zzdq
        public final void zzb(Bundle bundle) {
            synchronized (this.f13571a) {
                try {
                    this.f13571a.set(bundle);
                    this.f13572b = true;
                } finally {
                    this.f13571a.notify();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public abstract class b implements Runnable {

        /* renamed from: a */
        final long f13574a;

        /* renamed from: b */
        final long f13575b;

        /* renamed from: c */
        private final boolean f13576c;

        public b(zzea zzeaVar) {
            this(true);
        }

        abstract void b() throws RemoteException;

        protected void c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzea.this.zzadp) {
                c();
                return;
            }
            try {
                b();
            } catch (Exception e2) {
                zzea.this.zza(e2, false, this.f13576c);
                c();
            }
        }

        public b(boolean z) {
            this.f13574a = zzea.this.zzrz.a();
            this.f13575b = zzea.this.zzrz.c();
            this.f13576c = z;
        }
    }

    /* loaded from: classes2.dex */
    static class c extends zzdu {

        /* renamed from: a */
        private final zzcx f13578a;

        public c(zzcx zzcxVar) {
            this.f13578a = zzcxVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzdt
        public final int id() {
            return this.f13578a.hashCode();
        }

        @Override // com.google.android.gms.internal.measurement.zzdt
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.f13578a.a(str, str2, bundle, j);
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends zzdu {

        /* renamed from: a */
        private final zzcy f13579a;

        public d(zzcy zzcyVar) {
            this.f13579a = zzcyVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzdt
        public final int id() {
            return this.f13579a.hashCode();
        }

        @Override // com.google.android.gms.internal.measurement.zzdt
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.f13579a.onEvent(str, str2, bundle, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Application.ActivityLifecycleCallbacks {
        e() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzea.this.zza(new C1398x(this, activity, bundle));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzea.this.zza(new D(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzea.this.zza(new A(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzea.this.zza(new C1402z(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            a aVar = new a();
            zzea.this.zza(new C(this, activity, aVar));
            Bundle c2 = aVar.c(50L);
            if (c2 != null) {
                bundle.putAll(c2);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzea.this.zza(new C1400y(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzea.this.zza(new B(this, activity));
        }
    }

    private zzea(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str != null && zze(str2, str3)) {
            this.zzadh = str;
        } else {
            this.zzadh = "FA";
        }
        this.zzrz = DefaultClock.d();
        this.zzadl = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzadh, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new e());
        }
        this.zzadm = new AppMeasurementSdk(this);
        if (!(!zzf(context) || zzgb())) {
            this.zzadq = null;
            this.zzadp = true;
            Log.w(this.zzadh, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zze(str2, str3)) {
            this.zzadq = "fa";
            if (str2 != null && str3 != null) {
                Log.v(this.zzadh, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.zzadp = true;
                return;
            } else {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.zzadh, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            }
        } else {
            this.zzadq = str2;
        }
        zza(new C1348b(this, context, str2, str3, bundle));
    }

    public static zzea zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.a(context);
        if (zzadk == null) {
            synchronized (zzea.class) {
                if (zzadk == null) {
                    zzadk = new zzea(context, str, str2, str3, bundle);
                }
            }
        }
        return zzadk;
    }

    public static boolean zze(String str, String str2) {
        return (str2 == null || str == null || zzgb()) ? false : true;
    }

    private static boolean zzf(Context context) {
        try {
            GoogleServices.a(context);
        } catch (IllegalStateException unused) {
        }
        return GoogleServices.a() != null;
    }

    private static boolean zzgb() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static int zzh(Context context) {
        return DynamiteModule.b(context, "com.google.android.gms.measurement.dynamite");
    }

    public static int zzi(Context context) {
        return DynamiteModule.a(context, "com.google.android.gms.measurement.dynamite");
    }

    public final void beginAdUnitExposure(String str) {
        zza(new C1363g(this, str));
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza(new C1351c(this, str, str2, bundle));
    }

    public final void endAdUnitExposure(String str) {
        zza(new C1366h(this, str));
    }

    public final long generateEventId() {
        a aVar = new a();
        zza(new C1375l(this, aVar));
        Long l = (Long) aVar.a(aVar.c(500L), Long.class);
        if (l == null) {
            long nextLong = new Random(System.nanoTime() ^ this.zzrz.a()).nextLong();
            int i = this.zzado + 1;
            this.zzado = i;
            return nextLong + i;
        }
        return l.longValue();
    }

    public final String getAppIdOrigin() {
        return this.zzadq;
    }

    public final List<Bundle> getConditionalUserProperties(String str, String str2) {
        a aVar = new a();
        zza(new C1354d(this, str, str2, aVar));
        List<Bundle> list = (List) aVar.a(aVar.c(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final String getCurrentScreenClass() {
        a aVar = new a();
        zza(new C1379n(this, aVar));
        return aVar.b(500L);
    }

    public final String getCurrentScreenName() {
        a aVar = new a();
        zza(new C1377m(this, aVar));
        return aVar.b(500L);
    }

    public final String getGmpAppId() {
        a aVar = new a();
        zza(new C1371j(this, aVar));
        return aVar.b(500L);
    }

    public final int getMaxUserProperties(String str) {
        a aVar = new a();
        zza(new r(this, str, aVar));
        Integer num = (Integer) aVar.a(aVar.c(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        a aVar = new a();
        zza(new C1381o(this, str, str2, z, aVar));
        Bundle c2 = aVar.c(5000L);
        if (c2 != null && c2.size() != 0) {
            HashMap hashMap = new HashMap(c2.size());
            for (String str3 : c2.keySet()) {
                Object obj = c2.get(str3);
                if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                    hashMap.put(str3, obj);
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    public final void logEventInternal(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        zza(new C1396w(this, bundle));
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        zza(new C1357e(this, activity, str, str2));
    }

    public final void setMeasurementEnabled(boolean z) {
        zza(new C1360f(this, z));
    }

    public final void zzb(zzcy zzcyVar) {
        zza(new C1390t(this, zzcyVar));
    }

    public final void zzc(int i, String str, Object obj, Object obj2, Object obj3) {
        zza(new C1383p(this, false, 5, str, obj, obj2, obj3));
    }

    public final zzdn zzg(Context context) {
        try {
            return zzdo.asInterface(DynamiteModule.a(context, DynamiteModule.l, "com.google.android.gms.measurement.dynamite").a("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e2) {
            zza((Exception) e2, true, false);
            return null;
        }
    }

    public final AppMeasurementSdk zzga() {
        return this.zzadm;
    }

    public final String zzgc() {
        a aVar = new a();
        zza(new C1373k(this, aVar));
        return aVar.b(50L);
    }

    public final void zza(b bVar) {
        this.zzadl.execute(bVar);
    }

    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzadp |= z;
        if (z) {
            Log.w(this.zzadh, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzc(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(this.zzadh, "Error with data collection. Data lost.", exc);
    }

    public final void zza(zzcx zzcxVar) {
        zza(new C1369i(this, zzcxVar));
    }

    public final void zza(zzcy zzcyVar) {
        zza(new C1388s(this, zzcyVar));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza(new C1392u(this, l, str, str2, bundle, true, z2));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(new C1394v(this, str, str2, obj, true));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        a aVar = new a();
        zza(new C1385q(this, bundle, aVar));
        if (z) {
            return aVar.c(5000L);
        }
        return null;
    }
}

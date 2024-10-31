package com.nexstreaming.kinemaster.ad;

import android.content.Context;
import android.util.Log;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.gson.GsonBuilder;
import com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider;
import com.nextreaming.nexeditorui.NexTimeline;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class AdManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f19931a = "AdManager";

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f19932b = {"pub-6554794109779706"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f19933c = {"com.nexstreaming.kinemaster.ad.providers.AdmobNativeUnifiedAdProvider", AdmobAdProvider.TIMELINE_AD_UNIT_ID, "com.nexstreaming.kinemaster.ad.providers.AdmobInterstitialAdProvider", AdmobAdProvider.EAS_AD_INTERSTITIAL_ID};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f19934d = {"com.nexstreaming.kinemaster.ad.providers.AdmobNativeAdvancedCustomAdProvider", AdmobAdProvider.PL_AD_UNIT_ID, "com.nexstreaming.kinemaster.ad.providers.AdmobNativeAdvancedCustomAdProvider", AdmobAdProvider.STORE_AD_UNIT_ID, "com.nexstreaming.kinemaster.ad.providers.AdmobNativeAdvancedCustomAdProvider", AdmobAdProvider.EAS_AD_UNIT_ID};

    /* renamed from: e, reason: collision with root package name */
    private static AdManager f19935e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f19936f;
    private List<BannerInfo> i;
    private boolean j;
    private m l;
    private ExportInterstitialAdsType k = ExportInterstitialAdsType.NONE;
    private boolean m = false;
    private String n = null;
    private ConsentStatus o = ConsentStatus.UNKNOWN;

    /* renamed from: g, reason: collision with root package name */
    private final List<g> f19937g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<g> f19938h = new ArrayList();

    /* loaded from: classes.dex */
    public enum ExportInterstitialAdsType {
        NONE(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE),
        BEFORE("before"),
        AFTER("after"),
        EXPORTING("exporting");

        private final String type;

        ExportInterstitialAdsType(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }

    private AdManager(Context context) {
        this.f19936f = context.getApplicationContext();
        h();
        i();
        f();
        g();
        a(context, c.d.b.c.a.c(context));
    }

    private void h() {
        int i = 0;
        while (true) {
            String[] strArr = f19934d;
            if (i >= strArr.length) {
                return;
            }
            g a2 = a(strArr[i], strArr[i + 1]);
            if (a2 != null) {
                a(a2);
            }
            i += 2;
        }
    }

    private void i() {
        int i = 0;
        while (true) {
            String[] strArr = f19933c;
            if (i >= strArr.length) {
                return;
            }
            g a2 = a(strArr[i], strArr[i + 1]);
            if (a2 != null) {
                b(a2);
            }
            i += 2;
        }
    }

    public void d(String str) {
        if (!this.j) {
            this.m = true;
            this.n = str;
            return;
        }
        for (g gVar : this.f19938h) {
            if (gVar.getUnitId().equals(str)) {
                gVar.requestCustomInstallAd();
                return;
            }
        }
    }

    public void e(String str) {
        if (this.k == ExportInterstitialAdsType.NONE) {
            return;
        }
        for (g gVar : this.f19937g) {
            if (gVar.getUnitId().equals(str)) {
                gVar.requestTriggerAd();
                return;
            }
        }
    }

    public AdManager f() {
        if (!c.d.b.m.e.f3850a.a() && c.d.b.c.a.d(this.f19936f)) {
            c.d.b.b.i.d().a(0L, new e(this));
            this.j = c.d.b.b.i.d().i();
        } else {
            this.j = true;
            this.i = (List) new GsonBuilder().create().fromJson(g("ads/ads_info.json"), new c(this).getType());
        }
        return this;
    }

    public void g() {
        if (c.d.b.m.e.f3850a.a() || !c.d.b.c.a.d(this.f19936f)) {
            return;
        }
        this.k = c.d.b.b.i.d().d();
    }

    public <T extends g> T c(String str) {
        Iterator<g> it = this.f19937g.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getId().equals(str)) {
                return t;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003f, code lost:            return r0.toString();     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:            r1.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0038, code lost:            if (r1 == null) goto L17;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:            if (r1 != null) goto L30;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String g(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r4.f19936f     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            java.io.InputStream r1 = r2.open(r5)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
        L1c:
            java.lang.String r2 = r5.readLine()     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            if (r2 == 0) goto L26
            r0.append(r2)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e
            goto L1c
        L26:
            if (r1 == 0) goto L3b
        L28:
            r1.close()     // Catch: java.io.IOException -> L3b
            goto L3b
        L2c:
            r5 = move-exception
            goto L40
        L2e:
            r5 = move-exception
            java.lang.String r2 = com.nexstreaming.kinemaster.ad.AdManager.f19931a     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = r5.getMessage()     // Catch: java.lang.Throwable -> L2c
            android.util.Log.e(r2, r3, r5)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L3b
            goto L28
        L3b:
            java.lang.String r5 = r0.toString()
            return r5
        L40:
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.io.IOException -> L45
        L45:
            goto L47
        L46:
            throw r5
        L47:
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ad.AdManager.g(java.lang.String):java.lang.String");
    }

    public g b(String str) {
        for (g gVar : this.f19937g) {
            if (gVar.getId().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    public int c() {
        List<BannerInfo> list;
        if (!this.j || (list = this.i) == null) {
            return 0;
        }
        return list.size();
    }

    public <T extends g> T a(String str) {
        Iterator<g> it = this.f19938h.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getUnitId().endsWith(str)) {
                return t;
            }
        }
        return null;
    }

    public void b(g gVar) {
        if (gVar != null) {
            this.f19937g.add(gVar);
        }
    }

    public boolean e() {
        Iterator<g> it = this.f19937g.iterator();
        while (it.hasNext()) {
            if (it.next().isOpened()) {
                return true;
            }
        }
        return false;
    }

    public ExportInterstitialAdsType b() {
        return this.k;
    }

    public g a(String str, String str2) {
        try {
            return a(Class.forName(str), str2);
        } catch (ClassNotFoundException e2) {
            Log.w(f19931a, e2.getMessage(), e2);
            return null;
        }
    }

    public boolean d() {
        return this.j;
    }

    public void f(String str) {
        if (this.j) {
            for (g gVar : this.f19937g) {
                if (gVar.getUnitId().equals(str)) {
                    gVar.requestTriggerAd();
                    return;
                }
            }
        }
    }

    public g a(Class<?> cls, String str) {
        try {
            return (g) cls.getConstructor(Context.class, String.class).newInstance(this.f19936f, str);
        } catch (IllegalAccessException e2) {
            Log.w(f19931a, e2.getMessage(), e2);
            return null;
        } catch (InstantiationException e3) {
            Log.w(f19931a, e3.getMessage(), e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.w(f19931a, e4.getMessage(), e4);
            return null;
        } catch (InvocationTargetException e5) {
            Log.w(f19931a, e5.getMessage(), e5);
            return null;
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            this.f19938h.add(gVar);
        }
    }

    public void a(m mVar) {
        this.l = mVar;
    }

    public m a() {
        return this.l;
    }

    public BannerInfo a(int i) {
        List<BannerInfo> list;
        if (!this.j || (list = this.i) == null || i >= list.size()) {
            return null;
        }
        return this.i.get(i);
    }

    public static AdManager a(Context context) {
        if (f19935e == null) {
            f19935e = new AdManager(context);
        }
        return f19935e;
    }

    public void a(UnifiedNativeAd unifiedNativeAd, String str) {
        m mVar = this.l;
        if (mVar != null) {
            mVar.a(unifiedNativeAd, str);
        }
    }

    public void a(InterstitialAd interstitialAd, String str) {
        m mVar = this.l;
        if (mVar != null) {
            mVar.a(interstitialAd, str);
        }
    }

    public static void a(Context context, boolean z) {
        ConsentInformation.a(context).a(z ? ConsentStatus.PERSONALIZED : ConsentStatus.NON_PERSONALIZED);
    }
}

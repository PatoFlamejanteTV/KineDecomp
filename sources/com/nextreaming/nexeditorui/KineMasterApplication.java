package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatDelegate;
import c.d.b.m.m;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.FirebaseApp;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import com.nexstreaming.app.general.nexasset.assetpackage.security.provider.BasicEncryptionProvider;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.scanner.MediaDb;
import com.nexstreaming.kinemaster.network.InterfaceC1820i;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nexstreaming.kinemaster.usage.analytics.d;
import com.nexstreaming.kinemaster.usage.c;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.PropertyReference1Impl;

/* compiled from: KineMasterApplication.kt */
/* loaded from: classes.dex */
public final class KineMasterApplication extends b.b.g.b implements com.adobe.creativesdk.foundation.auth.l {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.g[] f24053a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f24054b;

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f24055c;

    /* renamed from: d, reason: collision with root package name */
    public static KineMasterApplication f24056d;

    /* renamed from: e, reason: collision with root package name */
    private static com.nexstreaming.app.general.nexasset.assetpackage.a.b[] f24057e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f24058f;

    /* renamed from: g, reason: collision with root package name */
    private MediaStore f24059g;

    /* renamed from: h, reason: collision with root package name */
    private com.nexstreaming.kinemaster.mediastore.e f24060h;
    private InterfaceC1820i i;
    private boolean j;
    private String k;
    private String l;
    private com.nexstreaming.kinemaster.mediastore.scanner.e m;
    private NexEditor n;
    private NexEditor.EditorInitException o;
    private UnsatisfiedLinkError p;
    private boolean q;
    private final WeakHashMap<Activity, Dummy> r = new WeakHashMap<>();
    private final kotlin.d s = kotlin.e.a(new kotlin.jvm.a.a<SharedPreferences>() { // from class: com.nextreaming.nexeditorui.KineMasterApplication$sp$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.a.a
        public final SharedPreferences invoke() {
            return PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.this);
        }
    });
    private final c.a t = new F(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KineMasterApplication.kt */
    /* loaded from: classes.dex */
    public enum Dummy {
        DUMMY
    }

    /* compiled from: KineMasterApplication.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public final KineMasterApplication a() {
            return c();
        }

        public final String b() {
            StringBuilder sb = new StringBuilder();
            c.d.b.a.a aVar = c.d.b.a.a.f3576b;
            kotlin.jvm.internal.h.a((Object) aVar, "ChipsetInfo.INSTANCE");
            sb.append(aVar.c());
            sb.append("//");
            c.d.b.a.a aVar2 = c.d.b.a.a.f3576b;
            kotlin.jvm.internal.h.a((Object) aVar2, "ChipsetInfo.INSTANCE");
            sb.append(aVar2.i());
            return sb.toString();
        }

        public final KineMasterApplication c() {
            KineMasterApplication kineMasterApplication = KineMasterApplication.f24056d;
            if (kineMasterApplication != null) {
                return kineMasterApplication;
            }
            kotlin.jvm.internal.h.b("instance");
            throw null;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(kotlin.jvm.internal.j.a(KineMasterApplication.class), "sp", "getSp()Landroid/content/SharedPreferences;");
        kotlin.jvm.internal.j.a(propertyReference1Impl);
        f24053a = new kotlin.reflect.g[]{propertyReference1Impl};
        f24058f = new a(null);
        f24054b = f24058f.getClass().getSimpleName();
        f24055c = new String[]{NotificationCompat.CATEGORY_EMAIL, "profile", "address"};
        HttpsURLConnection.setDefaultSSLSocketFactory(new c.d.a.a.c.b());
    }

    public KineMasterApplication() {
        f24056d = this;
    }

    public static final KineMasterApplication i() {
        return f24058f.a();
    }

    public static final String j() {
        return f24058f.b();
    }

    public static final KineMasterApplication m() {
        a aVar = f24058f;
        KineMasterApplication kineMasterApplication = f24056d;
        if (kineMasterApplication != null) {
            return kineMasterApplication;
        }
        kotlin.jvm.internal.h.b("instance");
        throw null;
    }

    private final void w() {
        int i = 1;
        if (!kotlin.jvm.internal.h.a(Looper.myLooper(), Looper.getMainLooper())) {
            if (EditorGlobal.p) {
                Crashlytics.log("Attempt to create editor instance on non-UI thread");
                return;
            }
            return;
        }
        if (this.n != null) {
            return;
        }
        try {
            G g2 = new G();
            NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
            int[] iArr = new int[5];
            iArr[0] = 2;
            kotlin.jvm.internal.h.a((Object) deviceProfile, "dprof");
            iArr[1] = deviceProfile.getGLDepthBufferBits();
            iArr[2] = 1;
            if (!deviceProfile.getGLMultisample()) {
                i = 0;
            }
            iArr[3] = i;
            iArr[4] = 0;
            this.n = new NexEditor(this, null, EditorGlobal.d(), EditorGlobal.q(), g2, iArr);
            NexEditor nexEditor = this.n;
            if (nexEditor != null) {
                nexEditor.createProject();
            }
            String e2 = EditorGlobal.e();
            KMEvents.VERSION_CHECK.logEvent("4.11.15.14242.GP " + e2);
        } catch (NexEditor.EditorInitException e3) {
            this.o = e3;
        } catch (UnsatisfiedLinkError e4) {
            this.p = e4;
        }
        if (this.n == null || this.m != null) {
            return;
        }
        List<m.a> a2 = c.d.b.m.m.a();
        File[] fileArr = new File[a2.size()];
        int length = fileArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            fileArr[i2] = new File(a2.get(i2).f3857a);
        }
        this.m = new com.nexstreaming.kinemaster.mediastore.scanner.e(getApplicationContext(), this.n, false, (File[]) Arrays.copyOf(fileArr, fileArr.length));
        if (EditorGlobal.p) {
            Crashlytics.log("AllMediaScanner#startScanning() Called by: First activity");
        }
        com.nexstreaming.kinemaster.mediastore.scanner.e eVar = this.m;
        if (eVar != null) {
            eVar.e();
        }
    }

    private final boolean x() {
        String b2 = EditorGlobal.b(this);
        return kotlin.jvm.internal.h.a((Object) b2, (Object) "") || kotlin.jvm.internal.h.a((Object) b2, (Object) getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (defaultSharedPreferences.getBoolean("km.ostype", false)) {
            return;
        }
        defaultSharedPreferences.edit().putBoolean("km.ostype", true).apply();
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.h.a((Object) applicationContext, "applicationContext");
        boolean hasSystemFeature = applicationContext.getPackageManager().hasSystemFeature("org.chromium.arc.device_management");
        d.a aVar = com.nexstreaming.kinemaster.usage.analytics.d.f23910b;
        Context applicationContext2 = getApplicationContext();
        kotlin.jvm.internal.h.a((Object) applicationContext2, "applicationContext");
        aVar.a(applicationContext2, "OS Type", hasSystemFeature ? "chrome" : "android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        d.a aVar = com.nexstreaming.kinemaster.usage.analytics.d.f23910b;
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.h.a((Object) applicationContext, "applicationContext");
        aVar.a(applicationContext, "UnlimitedLayer", EditorGlobal.w() ? "on" : "off");
    }

    @Override // com.adobe.creativesdk.foundation.auth.l
    public String a() {
        return "5f07c1ec-593f-4223-b290-87ee1272f151";
    }

    @Override // com.adobe.creativesdk.foundation.auth.l
    public String b() {
        return "48f26baeaf97499f84bba3a781066b87";
    }

    @Override // com.adobe.creativesdk.foundation.auth.l
    public String c() {
        return "ams+0683ee739db562ac8ccc69deda9608512d28d026://adobeid/48f26baeaf97499f84bba3a781066b87";
    }

    @Override // com.adobe.creativesdk.foundation.auth.l
    public String[] d() {
        return f24055c;
    }

    public final void f() {
        this.k = null;
    }

    public final void g() {
        this.j = false;
    }

    public final com.nexstreaming.kinemaster.mediastore.scanner.e h() {
        return this.m;
    }

    public final com.nexstreaming.kinemaster.mediastore.e k() {
        return this.f24060h;
    }

    public final NexEditor.EditorInitException l() {
        return this.o;
    }

    public final UnsatisfiedLinkError n() {
        return this.p;
    }

    public final MediaDb o() {
        com.nexstreaming.kinemaster.mediastore.scanner.e eVar = this.m;
        if (eVar == null) {
            return null;
        }
        if (eVar != null) {
            return eVar.b();
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        if (x()) {
            org.koin.core.a.b.a(new kotlin.jvm.a.b<org.koin.core.b, kotlin.k>() { // from class: com.nextreaming.nexeditorui.KineMasterApplication$onCreate$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.a.b
                public /* bridge */ /* synthetic */ kotlin.k invoke(org.koin.core.b bVar) {
                    invoke2(bVar);
                    return kotlin.k.f28545a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(org.koin.core.b bVar) {
                    kotlin.jvm.internal.h.b(bVar, "$receiver");
                    org.koin.android.ext.koin.a.a(bVar, null, 1, null);
                    org.koin.android.ext.koin.a.a(bVar, KineMasterApplication.this);
                    bVar.a(com.nextreaming.nexeditorui.di.a.a());
                }
            });
            c.c.a.a.a.a.f3459a = "https://api.kinemaster.com/";
            c.c.a.a.a.a.f3460b = "Android";
            Resources resources = getResources();
            kotlin.jvm.internal.h.a((Object) resources, "resources");
            String locale = resources.getConfiguration().locale.toString();
            kotlin.jvm.internal.h.a((Object) locale, "resources.configuration.locale.toString()");
            c.c.a.a.a.a.f3461c = kotlin.text.n.a(locale, io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR, "-", false, 4, (Object) null);
            c.c.a.a.a.a.f3462d = 3;
            c.c.a.a.a.a.f3463e = com.nexstreaming.app.general.util.N.c(this);
            c.c.a.a.a.a.f3464f = com.nexstreaming.app.general.util.N.a(this);
            c.c.a.a.a.a.f3465g = com.nexstreaming.app.general.util.N.d(this);
            c.c.a.a.a.a.f3466h = "ZmNjMTM4ZGIyODEwOWEzOTg5NzNlZmMyMzA0YjdhNjJmMWQ5MDVlYzo";
            c.c.a.a.a.a.i = c.c.a.a.a.a.f3463e;
            c.c.a.a.a.a.j = com.nexstreaming.app.general.util.N.b();
            c.c.a.a.a.a.k = 5;
            c.c.a.a.a.a.l = 172800;
            FirebaseApp.a(this);
            c.d.b.b.i.a(this);
            c.d.b.b.i.d().b();
            c.d.b.c.a.d(this, c.d.b.c.a.d(getApplicationContext()));
            com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a().a(this, c.d.b.c.a.d(getApplicationContext()));
            this.i = (InterfaceC1820i) g.a.a.a.a.a.a(this).b().a(kotlin.jvm.internal.j.a(InterfaceC1820i.class), (org.koin.core.e.a) null, (kotlin.jvm.a.a<org.koin.core.d.a>) null);
            InterfaceC1820i interfaceC1820i = this.i;
            if (interfaceC1820i != null) {
                interfaceC1820i.f();
            }
            String packageName = getPackageName();
            this.l = com.nexstreaming.app.general.util.J.a(String.valueOf(packageName.length()) + "y{}x!hbtY3kg![gJ:Vh4uzZ" + packageName);
            int i = -1;
            com.nexstreaming.app.general.nexasset.assetpackage.security.provider.c cVar = new com.nexstreaming.app.general.nexasset.assetpackage.security.provider.c();
            f24057e = new com.nexstreaming.app.general.nexasset.assetpackage.a.b[cVar.a().size()];
            Map<int[], String[]> a2 = cVar.a();
            kotlin.jvm.internal.h.a((Object) a2, "s.getpKeyMap()");
            for (Map.Entry<int[], String[]> entry : a2.entrySet()) {
                com.nexstreaming.app.general.nexasset.assetpackage.a.b[] bVarArr = f24057e;
                if (bVarArr != null) {
                    i++;
                    bVarArr[i] = new BasicEncryptionProvider(entry.getKey(), entry.getValue());
                    com.nexstreaming.app.general.nexasset.assetpackage.a.b[] bVarArr2 = f24057e;
                    if (bVarArr2 == null) {
                        kotlin.jvm.internal.h.b("securityProvider");
                        throw null;
                    }
                    if (bVarArr2[i] != null) {
                        if (bVarArr2 == null) {
                            kotlin.jvm.internal.h.b("securityProvider");
                            throw null;
                        }
                        AssetPackageReader.a(bVarArr2[i]);
                    }
                } else {
                    kotlin.jvm.internal.h.b("securityProvider");
                    throw null;
                }
            }
            SupportLogger.f19845a.a(getApplicationContext());
            com.nexstreaming.kinemaster.usage.c.a(this).a(this.t);
            registerActivityLifecycleCallbacks(new H(this));
            c.d.b.k.i.a(getApplicationContext());
            HashMap hashMap = new HashMap();
            String h2 = EditorGlobal.h();
            kotlin.jvm.internal.h.a((Object) h2, "EditorGlobal.getMarketId()");
            hashMap.put("marketid", h2);
            MediaInfo.a(getApplicationContext());
            NexEditorDeviceProfile.setAppContext(getApplicationContext());
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.h.a((Object) applicationContext, "applicationContext");
            Resources resources2 = applicationContext.getResources();
            kotlin.jvm.internal.h.a((Object) resources2, "applicationContext.resources");
            resources2.getDisplayMetrics();
            HashMap hashMap2 = new HashMap();
            String str = Build.MODEL;
            kotlin.jvm.internal.h.a((Object) str, "Build.MODEL");
            hashMap2.put("model", str);
            String str2 = Build.PRODUCT;
            kotlin.jvm.internal.h.a((Object) str2, "Build.PRODUCT");
            hashMap2.put("product", str2);
            String str3 = Build.DEVICE;
            kotlin.jvm.internal.h.a((Object) str3, "Build.DEVICE");
            hashMap2.put("device", str3);
            String str4 = Build.MANUFACTURER;
            kotlin.jvm.internal.h.a((Object) str4, "Build.MANUFACTURER");
            hashMap2.put("manufacturer", str4);
            String str5 = Build.HARDWARE;
            kotlin.jvm.internal.h.a((Object) str5, "Build.HARDWARE");
            hashMap2.put("hardware", str5);
            String str6 = Build.BOARD;
            kotlin.jvm.internal.h.a((Object) str6, "Build.BOARD");
            hashMap2.put("board", str6);
            hashMap2.put("sdk_level", String.valueOf(Build.VERSION.SDK_INT));
            KMEvents.DEVICE_INFO.logEvent(hashMap2);
            com.nexstreaming.app.kinemasterfree.wxapi.e.c(this);
            d.a aVar = com.nexstreaming.kinemaster.usage.analytics.d.f23910b;
            Context applicationContext2 = getApplicationContext();
            kotlin.jvm.internal.h.a((Object) applicationContext2, "applicationContext");
            c.d.b.a.a aVar2 = c.d.b.a.a.f3576b;
            kotlin.jvm.internal.h.a((Object) aVar2, "ChipsetInfo.INSTANCE");
            aVar.a(applicationContext2, "Chipset", aVar2.c());
            c.a.a.a.a.a(getApplicationContext());
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
            this.q = true;
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (this.q) {
            com.bumptech.glide.c.a(this).a();
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (this.q) {
            com.bumptech.glide.c.a(this).a(i);
        }
    }

    public final MediaStore p() {
        return this.f24059g;
    }

    public final InterfaceC1820i q() {
        return this.i;
    }

    public final NexEditor r() {
        if (this.n == null) {
            w();
        }
        return this.n;
    }

    public final NexEditor s() {
        return this.n;
    }

    public final String t() {
        return this.l;
    }

    public final String u() {
        return this.k;
    }

    public final boolean v() {
        return this.j;
    }

    public final void a(MediaStore mediaStore) {
        this.f24059g = mediaStore;
    }

    public final void a(com.nexstreaming.kinemaster.mediastore.e eVar) {
        this.f24060h = eVar;
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final void a(String str) {
        this.k = str;
    }
}

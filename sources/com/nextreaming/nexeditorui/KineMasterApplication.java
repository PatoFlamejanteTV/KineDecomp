package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.h.d;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.v2.scanner.MediaDb;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nexstreaming.kinemaster.usage.a;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.xiaomi.gamecenter.sdk.MiCommplatform;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes.dex */
public class KineMasterApplication extends android.support.a.b {

    /* renamed from: a, reason: collision with root package name */
    private static KineMasterApplication f4476a;
    private static boolean e = false;
    private MiAppInfo b = null;
    private WeakHashMap<Activity, Dummy> c = new WeakHashMap<>();
    private long d = 0;
    private a.InterfaceC0079a f = new ax(this);
    private com.nexstreaming.kinemaster.mediastore.v2.scanner.a g;
    private NexEditor h;
    private NexEditor.EditorInitException i;
    private UnsatisfiedLinkError j;
    private EffectLibrary k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Dummy {
        DUMMY
    }

    public static KineMasterApplication a() {
        if (f4476a == null) {
            Log.e("KineMasterApplication", "getApplicationInstance : Returning NULL!");
        }
        return f4476a;
    }

    public KineMasterApplication() {
        f4476a = this;
    }

    public boolean a(Class<? extends Activity> cls) {
        Iterator<Activity> it = this.c.keySet().iterator();
        while (it.hasNext()) {
            if (cls.isInstance(it.next())) {
                return true;
            }
        }
        return false;
    }

    static {
        HttpsURLConnection.setDefaultSSLSocketFactory(new com.nexstreaming.app.general.b.a());
    }

    @Override // android.app.Application
    public void onCreate() {
        SupportLogger.f3223a.a(getApplicationContext());
        com.nexstreaming.kinemaster.usage.a.a(this).a(this.f);
        registerActivityLifecycleCallbacks(new ay(this));
        com.nexstreaming.kinemaster.g.b.a(getApplicationContext());
        HashMap hashMap = new HashMap();
        hashMap.put("marketid", EditorGlobal.b());
        EffectLibrary.a(hashMap);
        EffectLibrary.a(EditorGlobal.i());
        EffectLibrary.a("km");
        EffectLibrary.a("com.nexstreaming.kinemaster.builtin.watermark.");
        EffectLibrary.a(getApplicationContext());
        MediaInfo.a(getApplicationContext());
        NexEditorDeviceProfile.setAppContext(getApplicationContext());
        KMAppUsage.a(getApplicationContext()).a(KMAppUsage.KMMetric.KineMasterStarted);
        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        KMUsage.onStart(getApplicationContext());
        KMUsage.DeviceInfo.logEvent("model", Build.MODEL, "product", Build.PRODUCT, "device", Build.DEVICE, "manufacturer", Build.MANUFACTURER, "hardware", Build.HARDWARE, "board", Build.BOARD, "board_platform", b(), "sdk_level", "" + Build.VERSION.SDK_INT, "screen", "" + displayMetrics.widthPixels + "x" + displayMetrics.heightPixels, "density_dpi", "" + displayMetrics.densityDpi);
        KMUsage.onStop(getApplicationContext());
        super.onCreate();
        this.b = new MiAppInfo();
        this.b.setAppId(getString(R.string.mi_app_id));
        this.b.setAppKey(getString(R.string.mi_app_key));
        MiCommplatform.Init(this, this.b);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String string = defaultSharedPreferences.getString("lastest_version", null);
        try {
            String str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            Log.i("KineMasterApplication", "Kinemaster current version : " + str);
            Log.i("KineMasterApplication", "Kinemaster lastest version : " + string);
            if (string == null || (string != null && !string.equalsIgnoreCase(str))) {
                Log.i("KineMasterApplication", "Kinemaster lastest version mismatch!! clear APC Cache");
                defaultSharedPreferences.edit().putString("lastest_version", str).commit();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        com.nexstreaming.app.kinemasterfree.wxapi.b.a(this);
        com.nexstreaming.kinemaster.tracelog.e.a(this);
    }

    public static String b() {
        String a2;
        String str = "";
        String a3 = NexEditor.a("ro.board.platform");
        if (a3 != null && a3.trim().equalsIgnoreCase("msm8916")) {
            a3 = NexEditor.a("ro.product.board");
            if (!a3.trim().equalsIgnoreCase("msm8939")) {
                a3 = NexEditor.a("ro.board.platform");
            }
        }
        if (a3 != null && a3.trim().equalsIgnoreCase("msm8960") && (a2 = NexEditor.a("ro.product.board")) != null && a2.trim().equalsIgnoreCase("8x30")) {
            str = "special//";
            a3 = "MSM8x30n";
        }
        if (a3 == null || a3.trim().length() < 1) {
            a3 = NexEditor.a("ro.mediatek.platform");
            str = "ro.mediatek.platform//";
        }
        if (a3 == null || a3.trim().length() < 1) {
            a3 = NexEditor.a("ro.hardware");
            str = "ro.hardware//";
        }
        if (a3 == null || a3.trim().length() < 1) {
            a3 = "unknown";
            str = "unknown//";
        }
        return str + a3;
    }

    public com.nexstreaming.kinemaster.mediastore.v2.scanner.a c() {
        return this.g;
    }

    public MediaDb d() {
        if (this.g == null) {
            j();
        }
        return this.g.d();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        EffectLibrary.b(true);
        super.onLowMemory();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i >= 80) {
            EffectLibrary.b(true);
        } else if (i >= 60) {
            EffectLibrary.b(false);
        }
        super.onTrimMemory(i);
    }

    private void j() {
        if (this.h == null) {
            try {
                az azVar = new az(this);
                NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
                int[] iArr = new int[5];
                iArr[0] = 2;
                iArr[1] = deviceProfile.getGLDepthBufferBits();
                iArr[2] = 1;
                iArr[3] = deviceProfile.getGLMultisample() ? 1 : 0;
                iArr[4] = 0;
                this.h = new NexEditor(this, null, EditorGlobal.d(), EditorGlobal.c(), azVar, iArr);
                this.h.c("com.nexstreaming.kinemaster.basic", false);
                this.h.createProject();
            } catch (NexEditor.EditorInitException e2) {
                this.i = e2;
            } catch (UnsatisfiedLinkError e3) {
                this.j = e3;
            }
            if (this.h != null && this.g == null) {
                List<d.a> a2 = com.nexstreaming.kinemaster.h.d.a();
                File[] fileArr = new File[a2.size()];
                for (int i = 0; i < fileArr.length; i++) {
                    fileArr[i] = new File(a2.get(i).f3394a);
                }
                this.g = new com.nexstreaming.kinemaster.mediastore.v2.scanner.a(getApplicationContext(), this.h, false, fileArr);
                this.g.b();
            }
        }
    }

    public EffectLibrary e() {
        if (this.k == null) {
            this.k = EffectLibrary.a(getApplicationContext());
        }
        return this.k;
    }

    public UnsatisfiedLinkError f() {
        return this.j;
    }

    public NexEditor.EditorInitException g() {
        return this.i;
    }

    public NexEditor h() {
        if (this.h == null) {
            j();
        }
        return this.h;
    }
}

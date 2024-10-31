package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzayh {
    public static final Handler zzelc = new zzaya(Looper.getMainLooper());
    private String zzeiz;
    private Pattern zzelg;
    private Pattern zzelh;
    private final Object mLock = new Object();
    private boolean zzeld = true;
    private boolean zzele = false;
    private boolean zzelf = false;

    public static boolean zzah(Context context) {
        ActivityInfo activityInfo;
        boolean z;
        Context zzu = zzaum.zzu(context);
        Intent intent = new Intent();
        intent.setClassName(zzu, "com.google.android.gms.ads.AdActivity");
        try {
            ResolveInfo resolveActivity = zzu.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null && (activityInfo = resolveActivity.activityInfo) != null) {
                if ((activityInfo.configChanges & 16) == 0) {
                    zzbbd.zzeo(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboard"));
                    z = false;
                } else {
                    z = true;
                }
                if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
                    zzbbd.zzeo(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboardHidden"));
                    z = false;
                }
                if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
                    zzbbd.zzeo(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "orientation"));
                    z = false;
                }
                if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
                    zzbbd.zzeo(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenLayout"));
                    z = false;
                }
                if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
                    zzbbd.zzeo(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "uiMode"));
                    z = false;
                }
                if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
                    zzbbd.zzeo(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenSize"));
                    z = false;
                }
                if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
                    return z;
                }
                zzbbd.zzeo(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "smallestScreenSize"));
                return false;
            }
            zzbbd.zzeo("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        } catch (Exception e2) {
            zzbbd.zzc("Could not verify that com.google.android.gms.ads.AdActivity is declared in AndroidManifest.xml", e2);
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AdUtil.hasAdActivity");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public static String zzak(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return zzzr();
        }
    }

    public static AlertDialog.Builder zzal(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static zzzy zzam(Context context) {
        return new zzzy(context);
    }

    private static String zzan(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                return runningTaskInfo.topActivity.getClassName();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:            if (r3.importance != 100) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:            if (r2.inKeyguardRestrictedInputMode() != false) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:            if (zzaq(r6) == false) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:            return true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zzao(android.content.Context r6) {
        /*
            r0 = 0
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r6.getSystemService(r1)     // Catch: java.lang.Throwable -> L49
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = "keyguard"
            java.lang.Object r2 = r6.getSystemService(r2)     // Catch: java.lang.Throwable -> L49
            android.app.KeyguardManager r2 = (android.app.KeyguardManager) r2     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L49
            if (r2 != 0) goto L16
            goto L49
        L16:
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L49
            if (r1 != 0) goto L1d
            return r0
        L1d:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L49
        L21:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L49
            if (r3 == 0) goto L49
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L49
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch: java.lang.Throwable -> L49
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L49
            int r5 = r3.pid     // Catch: java.lang.Throwable -> L49
            if (r4 != r5) goto L21
            int r1 = r3.importance     // Catch: java.lang.Throwable -> L49
            r3 = 100
            if (r1 != r3) goto L49
            boolean r1 = r2.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L49
            if (r1 != 0) goto L49
            boolean r6 = zzaq(r6)     // Catch: java.lang.Throwable -> L49
            if (r6 == 0) goto L49
            r6 = 1
            return r6
        L49:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayh.zzao(android.content.Context):boolean");
    }

    public static boolean zzap(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return true;
                    }
                    return !zzaq(context);
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean zzaq(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }

    public static Bitmap zzar(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        try {
            Window window = ((Activity) context).getWindow();
            if (window != null) {
                return zzw(window.getDecorView().getRootView());
            }
            return null;
        } catch (RuntimeException e2) {
            zzbbd.zzb("Fail to capture screen shot", e2);
            return null;
        }
    }

    public static int zzas(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    private static KeyguardManager zzat(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    @TargetApi(16)
    public static boolean zzau(Context context) {
        KeyguardManager zzat;
        return context != null && PlatformVersion.c() && (zzat = zzat(context)) != null && zzat.isKeyguardLocked();
    }

    public static boolean zzav(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzbbd.zzb("Error loading class.", th);
            com.google.android.gms.ads.internal.zzbv.i().zza(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static boolean zzay(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public static void zzc(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, arrayList);
    }

    public static void zzd(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzayf.zzc(runnable);
        }
    }

    public static String zzdx(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public static int zzdy(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzbbd.zzeo(sb.toString());
            return 0;
        }
    }

    public static boolean zzdz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    private final JSONObject zze(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static boolean zzec(String str) {
        if (!zzbax.isEnabled()) {
            return false;
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcws)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzwu.zzpz().zzd(zzaan.zzcwu);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) zzwu.zzpz().zzd(zzaan.zzcwt);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> zzg(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : com.google.android.gms.ads.internal.zzbv.g().zzh(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public static boolean zzn(Context context, String str) {
        Context zzu = zzaum.zzu(context);
        return Wrappers.a(zzu).a(str, zzu.getPackageName()) == 0;
    }

    public static String zzp(Context context, String str) {
        try {
            return new String(IOUtils.a(context.openFileInput(str), true), "UTF-8");
        } catch (IOException unused) {
            zzbbd.zzdn("Error reading from internal storage.");
            return "";
        }
    }

    public static Bitmap zzt(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap zzu(View view) {
        if (view == null) {
            return null;
        }
        Bitmap zzw = zzw(view);
        return zzw == null ? zzv(view) : zzw;
    }

    private static Bitmap zzv(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                view.layout(0, 0, width, height);
                view.draw(canvas);
                return createBitmap;
            }
            zzbbd.zzeo("Width or height of view is zero");
            return null;
        } catch (RuntimeException e2) {
            zzbbd.zzb("Fail to capture the webview", e2);
            return null;
        }
    }

    private static Bitmap zzw(View view) {
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            r0 = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (RuntimeException e2) {
            zzbbd.zzb("Fail to capture the web view", e2);
        }
        return r0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zzx(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 == 0) goto L12
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L12
            android.app.Activity r2 = (android.app.Activity) r2
            goto L13
        L12:
            r2 = r0
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayh.zzx(android.view.View):boolean");
    }

    public static int zzy(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    private static String zzzr() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            sb.append("; ");
            sb.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                sb.append(" Build/");
                sb.append(Build.DISPLAY);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static String zzzs() {
        return UUID.randomUUID().toString();
    }

    public static String zzzt() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    private static int[] zzzu() {
        return new int[]{0, 0};
    }

    public static Bundle zzzv() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcpi)).booleanValue()) {
                Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            Runtime runtime = Runtime.getRuntime();
            bundle.putLong("runtime_free_memory", runtime.freeMemory());
            bundle.putLong("runtime_max_memory", runtime.maxMemory());
            bundle.putLong("runtime_total_memory", runtime.totalMemory());
            bundle.putInt("web_view_count", com.google.android.gms.ads.internal.zzbv.i().zzyp());
        } catch (Exception e2) {
            zzbbd.zzc("Unable to gather memory stats", e2);
        }
        return bundle;
    }

    public final void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, zzo(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final boolean zzai(Context context) {
        if (this.zzele) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new Ed(this, null), intentFilter);
        this.zzele = true;
        return true;
    }

    public final boolean zzaj(Context context) {
        if (this.zzelf) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new Dd(this, null), intentFilter);
        this.zzelf = true;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final String zzaw(final Context context) {
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcym)).booleanValue()) {
            return "";
        }
        try {
            return (String) zzayf.zza(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.yd

                /* renamed from: a, reason: collision with root package name */
                private final zzayh f12681a;

                /* renamed from: b, reason: collision with root package name */
                private final Context f12682b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12681a = this;
                    this.f12682b = context;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return !((Boolean) zzwu.zzpz().zzd(zzaan.zzcym)).booleanValue() ? "" : this.f12682b.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
                }
            }).get();
        } catch (InterruptedException unused) {
            Thread.interrupted();
            return "";
        } catch (ExecutionException unused2) {
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final Bundle zzax(final Context context) {
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcyn)).booleanValue()) {
            return null;
        }
        try {
            return (Bundle) zzayf.zza(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.zd

                /* renamed from: a, reason: collision with root package name */
                private final zzayh f12699a;

                /* renamed from: b, reason: collision with root package name */
                private final Context f12700b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12699a = this;
                    this.f12700b = context;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.f12700b;
                    if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcyn)).booleanValue()) {
                        return null;
                    }
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
                    Bundle bundle = new Bundle();
                    if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                        bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
                    }
                    String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
                    for (int i = 0; i < 4; i++) {
                        String str = strArr[i];
                        if (defaultSharedPreferences.contains(str)) {
                            bundle.putString(str, defaultSharedPreferences.getString(str, null));
                        }
                    }
                    return bundle;
                }
            }).get();
        } catch (InterruptedException unused) {
            Thread.interrupted();
            return null;
        } catch (ExecutionException unused2) {
            return null;
        }
    }

    public final void zzb(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcsw)).booleanValue()) {
            zza(context, str, str2, bundle, z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:            if (((java.lang.String) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcqq)).equals(r3.zzelg.pattern()) == false) goto L10;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzea(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            monitor-enter(r3)     // Catch: java.util.regex.PatternSyntaxException -> L46
            java.util.regex.Pattern r0 = r3.zzelg     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L25
            com.google.android.gms.internal.ads.zzaac<java.lang.String> r0 = com.google.android.gms.internal.ads.zzaan.zzcqq     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.ads.zzaak r2 = com.google.android.gms.internal.ads.zzwu.zzpz()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r2 = r3.zzelg     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r2.pattern()     // Catch: java.lang.Throwable -> L43
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L43
            if (r0 != 0) goto L37
        L25:
            com.google.android.gms.internal.ads.zzaac<java.lang.String> r0 = com.google.android.gms.internal.ads.zzaan.zzcqq     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.ads.zzaak r2 = com.google.android.gms.internal.ads.zzwu.zzpz()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch: java.lang.Throwable -> L43
            r3.zzelg = r0     // Catch: java.lang.Throwable -> L43
        L37:
            java.util.regex.Pattern r0 = r3.zzelg     // Catch: java.lang.Throwable -> L43
            java.util.regex.Matcher r4 = r0.matcher(r4)     // Catch: java.lang.Throwable -> L43
            boolean r4 = r4.matches()     // Catch: java.lang.Throwable -> L43
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            return r4
        L43:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            throw r4     // Catch: java.util.regex.PatternSyntaxException -> L46
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayh.zzea(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:            if (((java.lang.String) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcqr)).equals(r3.zzelh.pattern()) == false) goto L10;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzeb(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            monitor-enter(r3)     // Catch: java.util.regex.PatternSyntaxException -> L46
            java.util.regex.Pattern r0 = r3.zzelh     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L25
            com.google.android.gms.internal.ads.zzaac<java.lang.String> r0 = com.google.android.gms.internal.ads.zzaan.zzcqr     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.ads.zzaak r2 = com.google.android.gms.internal.ads.zzwu.zzpz()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r2 = r3.zzelh     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = r2.pattern()     // Catch: java.lang.Throwable -> L43
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L43
            if (r0 != 0) goto L37
        L25:
            com.google.android.gms.internal.ads.zzaac<java.lang.String> r0 = com.google.android.gms.internal.ads.zzaan.zzcqr     // Catch: java.lang.Throwable -> L43
            com.google.android.gms.internal.ads.zzaak r2 = com.google.android.gms.internal.ads.zzwu.zzpz()     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch: java.lang.Throwable -> L43
            r3.zzelh = r0     // Catch: java.lang.Throwable -> L43
        L37:
            java.util.regex.Pattern r0 = r3.zzelh     // Catch: java.lang.Throwable -> L43
            java.util.regex.Matcher r4 = r0.matcher(r4)     // Catch: java.lang.Throwable -> L43
            boolean r4 = r4.matches()     // Catch: java.lang.Throwable -> L43
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            return r4
        L43:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            throw r4     // Catch: java.util.regex.PatternSyntaxException -> L46
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayh.zzeb(java.lang.String):boolean");
    }

    public final int[] zzh(Activity activity) {
        int[] zzg = zzg(activity);
        zzwu.zzpv();
        zzwu.zzpv();
        return new int[]{zzbat.zzb(activity, zzg[0]), zzbat.zzb(activity, zzg[1])};
    }

    public final int[] zzi(Activity activity) {
        int[] zzzu;
        View findViewById;
        Window window = activity.getWindow();
        if (window != null && (findViewById = window.findViewById(R.id.content)) != null) {
            zzzu = new int[]{findViewById.getTop(), findViewById.getBottom()};
        } else {
            zzzu = zzzu();
        }
        zzwu.zzpv();
        zzwu.zzpv();
        return new int[]{zzbat.zzb(activity, zzzu[0]), zzbat.zzb(activity, zzzu[1])};
    }

    public final String zzo(Context context, String str) {
        synchronized (this.mLock) {
            if (this.zzeiz != null) {
                return this.zzeiz;
            }
            if (str == null) {
                return zzzr();
            }
            try {
                this.zzeiz = com.google.android.gms.ads.internal.zzbv.g().getDefaultUserAgent(context);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(this.zzeiz)) {
                zzwu.zzpv();
                if (!zzbat.zzaar()) {
                    this.zzeiz = null;
                    zzelc.post(new Bd(this, context));
                    while (this.zzeiz == null) {
                        try {
                            this.mLock.wait();
                        } catch (InterruptedException unused2) {
                            this.zzeiz = zzzr();
                            String valueOf = String.valueOf(this.zzeiz);
                            zzbbd.zzeo(valueOf.length() != 0 ? "Interrupted, use default user agent: ".concat(valueOf) : new String("Interrupted, use default user agent: "));
                        }
                    }
                } else {
                    this.zzeiz = zzak(context);
                }
            }
            String valueOf2 = String.valueOf(this.zzeiz);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 10 + String.valueOf(str).length());
            sb.append(valueOf2);
            sb.append(" (Mobile; ");
            sb.append(str);
            this.zzeiz = sb.toString();
            try {
                if (Wrappers.a(context).a()) {
                    this.zzeiz = String.valueOf(this.zzeiz).concat(";aia");
                }
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AdUtil.getUserAgent");
            }
            this.zzeiz = String.valueOf(this.zzeiz).concat(")");
            return this.zzeiz;
        }
    }

    public static void zzd(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Exception e2) {
            zzbbd.zzb("Error writing to file in internal storage.", e2);
        }
    }

    @VisibleForTesting
    private static boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    public final JSONObject zzn(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zza(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    @TargetApi(18)
    public static void zzb(Context context, Intent intent) {
        if (intent != null && PlatformVersion.e()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static WebResourceResponse zze(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, com.google.android.gms.ads.internal.zzbv.e().zzo(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = new zzazs(context).zzc(str2, hashMap).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
            return null;
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e2) {
            zzbbd.zzc("Could not fetch MRAID JS.", e2);
            return null;
        }
    }

    public static int[] zzg(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window != null && (findViewById = window.findViewById(R.id.content)) != null) {
            return new int[]{findViewById.getWidth(), findViewById.getHeight()};
        }
        return zzzu();
    }

    public static void zza(Context context, String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            new zzbah(context, str, it.next()).zzwa();
        }
    }

    public static WebResourceResponse zzd(HttpURLConnection httpURLConnection) throws IOException {
        com.google.android.gms.ads.internal.zzbv.e();
        String contentType = httpURLConnection.getContentType();
        String str = "";
        String trim = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
        com.google.android.gms.ads.internal.zzbv.e();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(";");
            if (split.length != 1) {
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    if (split[i].trim().startsWith("charset")) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            str = split2[1].trim();
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        String str2 = str;
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && entry.getValue().size() > 0) {
                hashMap.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return com.google.android.gms.ads.internal.zzbv.g().zza(trim, str2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    public final void zza(Context context, List<String> list) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (TextUtils.isEmpty(zzbwi.zzbp(activity))) {
                return;
            }
            if (list == null) {
                zzaxz.v("Cannot ping urls: empty list.");
            } else {
                if (!zzabk.zzj(context)) {
                    zzaxz.v("Cannot ping url because custom tabs is not supported");
                    return;
                }
                zzabk zzabkVar = new zzabk();
                zzabkVar.zza(new Ad(this, list, zzabkVar, context));
                zzabkVar.zzd(activity);
            }
        }
    }

    public static String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                sb.append(cArr, 0, read);
            } else {
                return sb.toString();
            }
        }
    }

    public final void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zzo(context, str));
    }

    public final JSONObject zza(Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                return zze(bundle);
            } catch (JSONException e2) {
                zzbbd.zzb("Error converting Bundle to JSON", e2);
            }
        }
        return null;
    }

    private final JSONArray zza(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            zza(jSONArray, it.next());
        }
        return jSONArray;
    }

    private final void zza(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zze((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(zzn((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(zza((Collection<?>) obj));
            return;
        }
        if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                zza(jSONArray2, obj2);
            }
            jSONArray.put(jSONArray2);
            return;
        }
        jSONArray.put(obj);
    }

    private final void zza(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zze((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, zzn((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zza((Collection<?>) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zza(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public static DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    public static String zza(Context context, View view, zzwf zzwfVar) {
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcqo)).booleanValue()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", zzwfVar.width);
            jSONObject2.put("height", zzwfVar.height);
            jSONObject.put("size", jSONObject2);
            jSONObject.put("activity", zzan(context));
            if (!zzwfVar.zzckl) {
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    Object parent = view.getParent();
                    if (parent != null) {
                        int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", parent.getClass().getName());
                        jSONObject3.put("index_of_child", indexOfChild);
                        jSONArray.put(jSONObject3);
                    }
                    view = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("parents", jSONArray);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            zzbbd.zzc("Fail to get view hierarchy json", e2);
            return null;
        }
    }

    public final void zza(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            com.google.android.gms.ads.internal.zzbv.e();
            bundle.putString("device", zzzt());
            bundle.putString("eids", TextUtils.join(",", zzaan.zzqw()));
        }
        zzwu.zzpv();
        zzbat.zza(context, str, str2, bundle, z, new Cd(this, context, str));
    }

    public static void zza(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public final boolean zza(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zza(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, zzat(context));
    }

    public final boolean zza(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        if (!com.google.android.gms.ads.internal.zzbv.e().zzeld) {
            if ((keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) && !zzx(view)) {
                z = false;
                if (view.getVisibility() == 0 && view.isShown()) {
                    if ((powerManager != null || powerManager.isScreenOn()) && z) {
                        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcst)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        z = true;
        if (view.getVisibility() == 0) {
            if (powerManager != null || powerManager.isScreenOn()) {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcst)).booleanValue()) {
                }
                return true;
            }
        }
        return false;
    }

    @TargetApi(18)
    public static void zza(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzb(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzbbd.zzdn(sb.toString());
        } catch (ActivityNotFoundException e2) {
            zzbbd.zzb("No browser is found.", e2);
        }
    }

    @TargetApi(24)
    public static boolean zza(Activity activity, Configuration configuration) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwn)).booleanValue()) {
            return !activity.isInMultiWindowMode();
        }
        zzwu.zzpv();
        int zza = zzbat.zza(activity, configuration.screenHeightDp);
        int zza2 = zzbat.zza(activity, configuration.screenWidthDp);
        DisplayMetrics zza3 = zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza3.heightPixels;
        int i2 = zza3.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d2 = activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d2);
        int round = ((int) Math.round(d2 + 0.5d)) * ((Integer) zzwu.zzpz().zzd(zzaan.zzcwk)).intValue();
        return zze(i, zza + dimensionPixelSize, round) && zze(i2, zza2, round);
    }

    @VisibleForTesting
    public static Bundle zza(zzsx zzsxVar) {
        String zzzd;
        String zzzf;
        String str;
        if (zzsxVar == null) {
            return null;
        }
        if (com.google.android.gms.ads.internal.zzbv.i().zzyq().zzzc() && com.google.android.gms.ads.internal.zzbv.i().zzyq().zzze()) {
            return null;
        }
        if (zzsxVar.zznw()) {
            zzsxVar.wakeup();
        }
        zzsr zznu = zzsxVar.zznu();
        if (zznu != null) {
            zzzd = zznu.zznj();
            str = zznu.zznk();
            zzzf = zznu.zznl();
            if (zzzd != null) {
                com.google.android.gms.ads.internal.zzbv.i().zzyq().zzdq(zzzd);
            }
            if (zzzf != null) {
                com.google.android.gms.ads.internal.zzbv.i().zzyq().zzdr(zzzf);
            }
        } else {
            zzzd = com.google.android.gms.ads.internal.zzbv.i().zzyq().zzzd();
            zzzf = com.google.android.gms.ads.internal.zzbv.i().zzyq().zzzf();
            str = null;
        }
        Bundle bundle = new Bundle(1);
        if (zzzf != null && !com.google.android.gms.ads.internal.zzbv.i().zzyq().zzze()) {
            bundle.putString("v_fp_vertical", zzzf);
        }
        if (zzzd != null && !com.google.android.gms.ads.internal.zzbv.i().zzyq().zzzc()) {
            bundle.putString("fingerprint", zzzd);
            if (!zzzd.equals(str)) {
                bundle.putString("v_fp", str);
            }
        }
        if (bundle.isEmpty()) {
            return null;
        }
        return bundle;
    }

    public static void zza(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        boolean z = false;
        try {
            z = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcof)).booleanValue();
        } catch (IllegalStateException unused) {
        }
        if (z) {
            CrashUtils.a(context, th);
        }
    }
}

package com.google.android.gms.internal;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.search.SearchAdView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzid {
    private String zzIa;
    private static final String zzIy = AdView.class.getName();
    private static final String zzIz = InterstitialAd.class.getName();
    private static final String zzIA = PublisherAdView.class.getName();
    private static final String zzIB = PublisherInterstitialAd.class.getName();
    private static final String zzIC = SearchAdView.class.getName();
    private static final String zzID = AdLoader.class.getName();
    public static final Handler zzIE = new zzia(Looper.getMainLooper());
    private final Object zzpd = new Object();
    private boolean zzIF = true;
    private boolean zzIG = false;

    /* loaded from: classes.dex */
    private final class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(zzid zzidVar, du duVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzid.this.zzIF = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzid.this.zzIF = false;
            }
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            zzIE.post(runnable);
        }
    }

    private JSONArray zza(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            zza(jSONArray, it.next());
        }
        return jSONArray;
    }

    private void zza(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zze((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(zzz((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(zza((Collection<?>) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(zza((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void zza(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zze((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, zzz((Map) obj));
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

    public static void zzb(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzic.zza(runnable);
        }
    }

    private JSONObject zze(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private boolean zzr(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }

    public boolean zzH(Context context) {
        boolean z;
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            com.google.android.gms.ads.internal.util.client.zzb.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboard"));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            com.google.android.gms.ads.internal.util.client.zzb.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboardHidden"));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            com.google.android.gms.ads.internal.util.client.zzb.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "orientation"));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            com.google.android.gms.ads.internal.util.client.zzb.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenLayout"));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            com.google.android.gms.ads.internal.util.client.zzb.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "uiMode"));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            com.google.android.gms.ads.internal.util.client.zzb.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenSize"));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        com.google.android.gms.ads.internal.util.client.zzb.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "smallestScreenSize"));
        return false;
    }

    public boolean zzI(Context context) {
        if (this.zzIG) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new a(this, null), intentFilter);
        this.zzIG = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String zzJ(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public AlertDialog.Builder zzK(Context context) {
        return new AlertDialog.Builder(context);
    }

    public zzbq zzL(Context context) {
        return new zzbq(context);
    }

    public String zzM(Context context) {
        ActivityManager activityManager;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            activityManager = (ActivityManager) context.getSystemService("activity");
        } catch (Exception e) {
        }
        if (activityManager == null) {
            return null;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
        if (runningTasks != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
            return runningTaskInfo.topActivity.getClassName();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:            if (r0.importance != 100) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:            if (r1.inKeyguardRestrictedInputMode() != false) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:            if (zzr(r7) == false) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:            return true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean zzN(android.content.Context r7) {
        /*
            r6 = this;
            r2 = 0
            java.lang.String r0 = "activity"
            java.lang.Object r0 = r7.getSystemService(r0)     // Catch: java.lang.Throwable -> L4d
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = "keyguard"
            java.lang.Object r1 = r7.getSystemService(r1)     // Catch: java.lang.Throwable -> L4d
            android.app.KeyguardManager r1 = (android.app.KeyguardManager) r1     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L15
            if (r1 != 0) goto L17
        L15:
            r0 = r2
        L16:
            return r0
        L17:
            java.util.List r0 = r0.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L4d
            if (r0 != 0) goto L1f
            r0 = r2
            goto L16
        L1f:
            java.util.Iterator r3 = r0.iterator()     // Catch: java.lang.Throwable -> L4d
        L23:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L4b
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L4d
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0     // Catch: java.lang.Throwable -> L4d
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L4d
            int r5 = r0.pid     // Catch: java.lang.Throwable -> L4d
            if (r4 != r5) goto L23
            int r0 = r0.importance     // Catch: java.lang.Throwable -> L4d
            r3 = 100
            if (r0 != r3) goto L4b
            boolean r0 = r1.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L4d
            if (r0 != 0) goto L4b
            boolean r0 = r6.zzr(r7)     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L4b
            r0 = 1
            goto L16
        L4b:
            r0 = r2
            goto L16
        L4d:
            r0 = move-exception
            r0 = r2
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzid.zzN(android.content.Context):boolean");
    }

    public Bitmap zzO(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        try {
            View decorView = ((Activity) context).getWindow().getDecorView();
            Bitmap createBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            decorView.layout(0, 0, decorView.getWidth(), decorView.getHeight());
            decorView.draw(canvas);
            return createBitmap;
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Fail to capture screen shot", e);
            return null;
        }
    }

    public DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public String zza(Context context, View view, AdSizeParcel adSizeParcel) {
        if (!zzby.zzvg.get().booleanValue()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", adSizeParcel.f);
            jSONObject2.put("height", adSizeParcel.c);
            jSONObject.put("size", jSONObject2);
            jSONObject.put("activity", zzM(context));
            if (!adSizeParcel.e) {
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
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Fail to get view hierarchy json", e);
            return null;
        }
    }

    public String zza(Context context, zzan zzanVar, String str) {
        if (zzanVar == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzanVar.zzc(parse)) {
                parse = zzanVar.zza(parse, context);
            }
            return parse.toString();
        } catch (Exception e) {
            return str;
        }
    }

    public String zza(zziz zzizVar, String str) {
        return zza(zzizVar.getContext(), zzizVar.zzhg(), str);
    }

    public String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    public String zza(StackTraceElement[] stackTraceElementArr, String str) {
        String str2;
        if (zzby.zzvr.get().booleanValue()) {
            for (int i = 0; i + 1 < stackTraceElementArr.length; i++) {
                StackTraceElement stackTraceElement = stackTraceElementArr[i];
                String className = stackTraceElement.getClassName();
                if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (zzIy.equalsIgnoreCase(className) || zzIz.equalsIgnoreCase(className) || zzIA.equalsIgnoreCase(className) || zzIB.equalsIgnoreCase(className) || zzIC.equalsIgnoreCase(className) || zzID.equalsIgnoreCase(className))) {
                    str2 = stackTraceElementArr[i + 1].getClassName();
                    break;
                }
            }
            str2 = null;
            if (str2 != null && !str2.contains(str)) {
                return str2;
            }
        }
        return null;
    }

    JSONArray zza(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            zza(jSONArray, obj);
        }
        return jSONArray;
    }

    public void zza(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void zza(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
    }

    public void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zzf(context, str));
    }

    public void zza(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", Build.VERSION.RELEASE);
            bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
            bundle.putString("device", com.google.android.gms.ads.internal.zzp.e().zzgE());
            bundle.putString("js", str);
            bundle.putString("appid", applicationContext.getPackageName());
            bundle.putString("eids", TextUtils.join(",", zzby.zzdf()));
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter(ShareConstants.WEB_DIALOG_PARAM_ID, str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        com.google.android.gms.ads.internal.zzp.e().zzc(context, str, appendQueryParameter.toString());
    }

    public void zza(Context context, String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            new zzij(context, str, it.next()).zzfu();
        }
    }

    public void zza(Context context, String str, List<String> list, String str2) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            new zzij(context, str, it.next(), str2).zzfu();
        }
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        zza(context, str, z, httpURLConnection, false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", str2);
        httpURLConnection.setUseCaches(false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", zzf(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public boolean zza(Context context, Bitmap bitmap, String str) {
        com.google.android.gms.common.internal.zzx.c("saveImageToFile must not be called on the main UI thread.");
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, openFileOutput);
            openFileOutput.close();
            bitmap.recycle();
            return true;
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Fail to save file", e);
            return false;
        }
    }

    public boolean zza(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public boolean zza(ClassLoader classLoader, Class<?> cls, String str) {
        try {
            return cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
            return false;
        }
    }

    public int zzaA(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not parse value:" + e);
            return 0;
        }
    }

    public boolean zzaB(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public String zzaz(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public void zzb(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
    }

    public void zzb(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void zzb(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (zzby.zzvo.get().booleanValue()) {
            zza(context, str, str2, bundle, z);
        }
    }

    public void zzc(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, arrayList);
    }

    public Map<String, String> zze(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : com.google.android.gms.ads.internal.zzp.g().zzf(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public String zzf(Context context, String str) {
        String str2;
        synchronized (this.zzpd) {
            if (this.zzIa != null) {
                str2 = this.zzIa;
            } else {
                try {
                    this.zzIa = com.google.android.gms.ads.internal.zzp.g().getDefaultUserAgent(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.zzIa)) {
                    if (com.google.android.gms.ads.internal.client.zzl.a().b()) {
                        try {
                            this.zzIa = zzJ(context);
                        } catch (Exception e2) {
                            this.zzIa = zzgC();
                        }
                    } else {
                        this.zzIa = null;
                        zzIE.post(new du(this, context));
                        while (this.zzIa == null) {
                            try {
                                this.zzpd.wait();
                            } catch (InterruptedException e3) {
                                this.zzIa = zzgC();
                                com.google.android.gms.ads.internal.util.client.zzb.e("Interrupted, use default user agent: " + this.zzIa);
                            }
                        }
                    }
                }
                this.zzIa += " (Mobile; " + str + ")";
                str2 = this.zzIa;
            }
        }
        return str2;
    }

    public Bitmap zzg(Context context, String str) {
        com.google.android.gms.common.internal.zzx.c("getBackgroundImage must not be called on the main UI thread.");
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            return decodeStream;
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Fail to get background image");
            return null;
        }
    }

    public int[] zzg(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        return (window == null || (findViewById = window.findViewById(R.id.content)) == null) ? zzgF() : new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public boolean zzgB() {
        return this.zzIF;
    }

    String zzgC() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(Build.VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public String zzgD() {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public String zzgE() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    protected int[] zzgF() {
        return new int[]{0, 0};
    }

    public void zzh(Context context, String str) {
        com.google.android.gms.common.internal.zzx.c("deleteFile must not be called on the main UI thread.");
        context.deleteFile(str);
    }

    public int[] zzh(Activity activity) {
        int[] zzg = zzg(activity);
        return new int[]{com.google.android.gms.ads.internal.client.zzl.a().b(activity, zzg[0]), com.google.android.gms.ads.internal.client.zzl.a().b(activity, zzg[1])};
    }

    public int[] zzi(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        return (window == null || (findViewById = window.findViewById(R.id.content)) == null) ? zzgF() : new int[]{findViewById.getTop(), findViewById.getBottom()};
    }

    public int[] zzj(Activity activity) {
        int[] zzi = zzi(activity);
        return new int[]{com.google.android.gms.ads.internal.client.zzl.a().b(activity, zzi[0]), com.google.android.gms.ads.internal.client.zzl.a().b(activity, zzi[1])};
    }

    public Bitmap zzk(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public JSONObject zzz(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zza(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }
}

package c.d.b.m;

import android.content.Context;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.nextreaming.nexeditorui.E;
import com.nextreaming.nexeditorui.KineMasterApplication;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppMarketUtil.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f3847a = {"com.qihoo", "com.tencent", "com.wandoujia", "com.taobao", "com.baidu", "com.xiaomi", "com.huawei", "com.yulong", "zte.", "com.zte", "com.suning", "com.gionee", "cn.", "com.sogou", "com.bbk.appstore"};

    public static String a() {
        Context applicationContext = KineMasterApplication.f24056d.getApplicationContext();
        String b2 = E.c().b();
        if (b2 == null) {
            b2 = applicationContext.getPackageManager().getInstallerPackageName(applicationContext.getPackageName());
            if (b2 == null) {
                b2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            try {
                new JSONObject().put("Download Store", b2);
                if (c.d.b.c.a.d(applicationContext)) {
                    com.nexstreaming.kinemaster.usage.analytics.d.f23910b.a(applicationContext, "Installer", b2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            Log.i("AppMarketUtil", "Store Installer info : " + b2);
        } else {
            Log.i("AppMarketUtil", "Use DevConfig Installer : " + b2);
        }
        return b2;
    }

    public static boolean b() {
        String a2 = a();
        if (a2 != null && a2.length() > 0) {
            for (String str : f3847a) {
                if (a2.startsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}

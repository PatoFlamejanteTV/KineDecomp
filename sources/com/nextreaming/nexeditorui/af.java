package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.gson.Gson;
import com.mixpanel.android.mpmetrics.n;
import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.service.NexNotificationService;
import com.nexstreaming.app.general.service.alarm.AlarmData;
import com.nexstreaming.app.general.service.notification.NotificationData;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.ResponseCode;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.tracelog.a;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.tencent.mm.sdk.openapi.IWXAPI;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class af {

    /* renamed from: a */
    private IABHelper f4513a;
    private IABHelper.e b;
    private IABHelper.d c;
    private IABHelper.c d;
    private IABHelper.b e;
    private IABHelper.a f;
    private Activity w;
    private Gson x;
    private SKUDetails g = null;
    private SKUDetails h = null;
    private SKUDetails i = null;
    private SKUDetails j = null;
    private SKUDetails k = null;
    private SKUDetails l = null;
    private boolean m = false;
    private PurchaseType n = null;
    private Purchase o = null;
    private Purchase p = null;
    private int q = 0;
    private int r = 7;
    private int s = 1;
    private int t = 0;
    private int u = 0;
    private Map<String, Purchase> v = new HashMap();
    private com.nexstreaming.kinemaster.ui.a.a y = null;
    private ProgressDialog z = null;
    private boolean A = false;
    private IABHelper.e B = new ah(this);
    private IABHelper.d C = new aj(this);
    private IABHelper.c D = new ak(this);
    private IABHelper.b E = new al(this);
    private IABHelper.a F = new am(this);

    /* JADX WARN: Multi-variable type inference failed */
    public af(Activity activity) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.w = null;
        this.x = null;
        this.w = activity;
        this.f4513a = d(activity);
        this.x = new Gson();
        if (activity instanceof IABHelper.e) {
            this.b = (IABHelper.e) activity;
        }
        if (activity instanceof IABHelper.d) {
            this.c = (IABHelper.d) activity;
        }
        if (activity instanceof IABHelper.c) {
            this.d = (IABHelper.c) activity;
        }
        if (activity instanceof IABHelper.b) {
            this.e = (IABHelper.b) activity;
        }
        if (activity instanceof IABHelper.a) {
            this.f = (IABHelper.a) activity;
        }
        K();
    }

    public void a() {
        C();
        if (this.f4513a != null) {
            O();
            Purchase e = d().e("one");
            if (e != null) {
                a(e);
            } else {
                this.p = null;
                this.q = 0;
            }
            Purchase e2 = d().e("subs");
            if (e2 != null) {
                b(e2);
            } else {
                this.o = null;
            }
            this.f4513a.a(this.B);
            return;
        }
        this.B.a(false, 0);
    }

    public void b() {
        if (this.f4513a != null) {
            O();
            this.f4513a.c(this.B);
        }
    }

    private void K() {
        this.h = null;
        this.i = null;
        this.g = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.y = null;
    }

    public void c() {
        if (this.f4513a != null) {
            this.f4513a.i();
        }
    }

    private IABHelper d(Context context) {
        IWXAPI wXAPIInstance = KMUsage.getWXAPIInstance(context);
        String a2 = a(context);
        if ("com.android.vending".equalsIgnoreCase(a2)) {
            return new com.nexstreaming.app.general.iab.a.a(context, a2);
        }
        if ("com.xiaomi.market".equalsIgnoreCase(a2)) {
            return new com.nexstreaming.app.general.iab.c.a(context, a2);
        }
        if ("com.baidu.appsearch".equalsIgnoreCase(a2)) {
            return new com.nexstreaming.app.general.iab.b.a(context, a2);
        }
        if ("com.qihoo.appstore".equalsIgnoreCase(a2)) {
            return new com.nexstreaming.app.general.iab.b.a(context, a2);
        }
        if (com.nexstreaming.kinemaster.h.a.f(context)) {
            if (c(context)) {
                return new com.nexstreaming.app.general.iab.c.a(context, a2);
            }
            if (!wXAPIInstance.isWXAppInstalled() || !wXAPIInstance.isWXAppSupportAPI()) {
                return null;
            }
            return new com.nexstreaming.app.general.iab.b.a(context, a2);
        }
        if (b(context)) {
            return new com.nexstreaming.app.general.iab.a.a(context, a2);
        }
        if (c(context)) {
            return new com.nexstreaming.app.general.iab.a.a(context, a2);
        }
        if (!wXAPIInstance.isWXAppInstalled() || !wXAPIInstance.isWXAppSupportAPI()) {
            return null;
        }
        return new com.nexstreaming.app.general.iab.b.a(context, a2);
    }

    private boolean L() {
        return this.m && !TextUtils.isEmpty(PreferenceManager.getDefaultSharedPreferences(this.w).getString("com.kinemaster.apc.sel_account_name", null));
    }

    public String a(Context context) {
        String e = av.a().e();
        if (e == null) {
            e = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            if (e == null) {
                e = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("Download Store", e);
                KMUsage.Download_Store.logEvent(jSONObject);
                KMUsage.getMixpanelInstanceFromContext(context).a(jSONObject);
                KMUsage.getMixpanelPeople(context).a(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            Log.i("IABWrapper", "Store Installer info : " + e);
        } else {
            Log.i("IABWrapper", "Use DevConfig Installer : " + e);
        }
        return e;
    }

    public static boolean b(Context context) {
        int a2 = GooglePlayServicesUtil.a(context);
        Log.i("IABWrapper", "hasGoogleService() : result = [" + a2 + "]");
        return a2 == 0;
    }

    public static boolean c(Context context) {
        return a(context, "com.xiaomi.gamecenter.sdk.service");
    }

    public static boolean a(Context context, String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
        }
        boolean z = packageInfo != null;
        if (z) {
            Log.i("IABWrapper", String.format("found %s", str));
        } else {
            Log.i("IABWrapper", String.format("can not found %s", str));
        }
        return z;
    }

    public IABHelper d() {
        if (this.f4513a == null) {
            this.f4513a = d(this.w);
        }
        return this.f4513a;
    }

    public boolean e() {
        if (m() == null) {
            return false;
        }
        switch (m()) {
            case SubAnnual:
            case SubMonthly:
            case SubUnknown:
            case OneTimeValid:
            case Promocode:
                return true;
            default:
                return false;
        }
    }

    public boolean f() {
        boolean z = false;
        if (d() != null) {
            Log.d("IABWrapper", "hasPurchaseCache() called with: " + (d() != null));
            if (d().e("one") != null || d().e("subs") != null || d().u()) {
                z = true;
            }
        }
        Log.d("IABWrapper", "hasPurchaseCache() returned: " + z);
        return z;
    }

    public SKUDetails g() {
        return this.g;
    }

    public SKUDetails h() {
        return this.h;
    }

    public SKUDetails i() {
        return this.i;
    }

    public SKUDetails j() {
        return this.j;
    }

    public SKUDetails k() {
        return this.k;
    }

    public SKUDetails l() {
        return this.l;
    }

    public PurchaseType m() {
        if (d() != null) {
            if (L()) {
                this.n = PurchaseType.Promocode;
            } else if (this.o != null && this.o.k() == Purchase.PurchaseState.Purchased) {
                this.n = d().c(this.o.a());
            } else if (this.p != null && this.p.k() == Purchase.PurchaseState.Purchased) {
                if (this.q > 0) {
                    this.n = PurchaseType.OneTimeValid;
                } else {
                    this.n = PurchaseType.OneTimeExpired;
                }
            } else {
                this.n = PurchaseType.None;
            }
            KMUsage.FailToGetPurchaseType.logEvent("case", "GPT");
        } else {
            this.n = PurchaseType.None;
        }
        return this.n;
    }

    public int n() {
        return this.q;
    }

    public int o() {
        return this.t;
    }

    public int p() {
        return this.u;
    }

    public boolean q() {
        return this.p != null && this.q >= 1 && this.q <= this.r;
    }

    public int r() {
        PurchaseType m = m();
        if (m == null) {
            return 0;
        }
        switch (m) {
            case SubAnnual:
                return 40;
            case SubMonthly:
                return 5;
            case SubUnknown:
            case Promocode:
            case OneTimeExpired:
            default:
                return 0;
            case OneTimeValid:
                return (p() * 8) / 30;
        }
    }

    public String s() {
        PurchaseType m = m();
        if (m == null) {
            return "Free";
        }
        switch (m) {
            case SubAnnual:
                return "Sub-Annual";
            case SubMonthly:
                return "Sub-Monthly";
            case SubUnknown:
            default:
                return "Free";
            case OneTimeValid:
                if (this.A) {
                    return "Pass-" + p() + "days-ext";
                }
                return "Pass-" + p() + "days";
            case Promocode:
                return "Free-prom";
            case OneTimeExpired:
                return "Free";
        }
    }

    private IABHelper.DeveloperPayLoad a(SKUDetails sKUDetails, Context context) {
        SecureRandom secureRandom = new SecureRandom();
        String substring = (Integer.toHexString(secureRandom.nextInt()) + "XXXXXXXX").substring(0, 8);
        (Integer.toHexString(secureRandom.nextInt()) + "XXXXXXXX").substring(0, 8);
        IABHelper.DeveloperPayLoad developerPayLoad = new IABHelper.DeveloperPayLoad();
        if (sKUDetails != null && this.q >= 0) {
            String str = "KM313X." + substring + "." + com.nexstreaming.app.general.util.z.a(context);
            developerPayLoad.preSku = this.p != null ? this.p.g() : null;
            developerPayLoad.remainingDays = this.q >= 0 ? this.q : 0;
            developerPayLoad.payload = str;
        }
        return developerPayLoad;
    }

    public void a(SKUDetails sKUDetails, int i) {
        if (this.f4513a != null) {
            if (this.w != null && sKUDetails != null) {
                Log.i("IABWrapper", "do buy product : " + sKUDetails.a());
                d().a(sKUDetails, a(sKUDetails, this.w), i, this.F);
            } else {
                this.F.a(false, null, "Context or Sku is null");
            }
        }
    }

    public void t() {
        if (this.f4513a == null || this.w == null) {
            this.D.b(IABError.NoContext, "missing helper or context");
        } else {
            O();
            this.f4513a.a(this.D);
        }
    }

    private void M() {
        this.q = 0;
        this.p = null;
        this.v.clear();
    }

    public void a(SKUDetails sKUDetails) {
        if (this.f4513a != null) {
            Purchase purchase = this.v.get(sKUDetails.a());
            if (purchase != null) {
                Log.i("IABWrapper", "do consume : " + sKUDetails.a());
                this.f4513a.a(sKUDetails, purchase, this.E);
            } else {
                Log.i("IABWrapper", "not exist expired : " + sKUDetails.a());
                this.E.a(sKUDetails, purchase);
            }
        }
    }

    public boolean a(Purchase purchase) {
        int i;
        boolean b = d().b(purchase.a());
        boolean b2 = d().b(purchase);
        int a2 = d().a(purchase);
        if (b && a2 > 0) {
            this.t = a2;
            this.u = this.t;
            this.A = b2;
            if (this.t > 0) {
                if (this.t >= 365) {
                    this.r = 30;
                    this.s = 1;
                } else if (this.t >= 30) {
                    this.r = 7;
                    this.s = 1;
                } else if (this.t >= 7) {
                    this.r = 3;
                    this.s = 1;
                }
            }
            int min = this.t - ((int) Math.min(2147483647L, (purchase.i() - purchase.c().getTime()) / 86400000));
            IABHelper.DeveloperPayLoad developerPayLoad = null;
            try {
                developerPayLoad = (IABHelper.DeveloperPayLoad) this.x.fromJson(purchase.e(), IABHelper.DeveloperPayLoad.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (developerPayLoad != null) {
                i = developerPayLoad.remainingDays + min;
                this.t += developerPayLoad.remainingDays;
            } else {
                i = min;
            }
            if (i > 0) {
                DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_PREFIX_OK_INAPP);
                this.p = purchase;
                this.q = i;
                d().a("one", purchase, d().p() + (i * 86400000));
                if (d() instanceof com.nexstreaming.app.general.iab.a.a) {
                    a(this.p.f(), this.p.d(), this.p.a(), this.f4513a.s());
                }
                if (this.q > 0 && this.p != null) {
                    a(this.q);
                }
                return true;
            }
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_EXPIRED);
            if (i > this.q || this.p == null) {
                this.p = purchase;
                this.q = i;
                this.v.put(purchase.a(), purchase);
            }
        } else {
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_PREFIX_NOT_FOUND_INAPP);
        }
        return false;
    }

    private void a(int i) {
        long j = 86400000 * i;
        Log.i("IABWrapper", "setNotificationAlarm() called with: daysRemaining = [" + i + "]");
        String string = this.w.getString(R.string.special_price_title);
        String string2 = this.w.getString(R.string.special_price_message);
        if (i > this.r) {
            long currentTimeMillis = (System.currentTimeMillis() + j) - (86400000 * this.r);
            Log.i("IABWrapper", "setFirstNotify trigger time = [" + currentTimeMillis + "]");
            NexNotificationService.a(this.w, new AlarmData(36, "a_week", currentTimeMillis, new NotificationData(35, String.format(string, Integer.valueOf(this.r)), string2, ProjectGalleryActivity.class, com.nexstreaming.app.general.util.d.a("setting", "pref_information_about_account", "sepcial"))));
        }
        if (i > this.s) {
            long currentTimeMillis2 = (System.currentTimeMillis() + j) - (86400000 * this.s);
            Log.i("IABWrapper", "setSecondNotify trigger time = [" + currentTimeMillis2 + "]");
            NexNotificationService.a(this.w, new AlarmData(35, "d-day", currentTimeMillis2, new NotificationData(35, String.format(string, Integer.valueOf(this.s)), string2, ProjectGalleryActivity.class, com.nexstreaming.app.general.util.d.a("setting", "pref_information_about_account", "sepcial"))));
        }
    }

    public boolean b(Purchase purchase) {
        int i = 0;
        boolean a2 = d().a(purchase.a());
        Log.d("IABWrapper", "## found ### : " + a2);
        if (a2) {
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_PREFIX_OK);
            this.o = purchase;
            if (purchase.h() != null && (d().d(purchase) || d().e(purchase))) {
                if (d().d(purchase)) {
                    i = 30;
                } else if (d().e(purchase)) {
                    i = 365;
                }
                d().a("subs", purchase, (i * 86400000) + purchase.c().getTime());
            }
            if (d() instanceof com.nexstreaming.app.general.iab.a.a) {
                a(this.o.f(), this.o.d(), this.o.a(), this.f4513a.s());
            }
            return true;
        }
        DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_PREFIX_NOT_FOUND);
        return false;
    }

    public void u() {
        if (this.w == null || this.f4513a == null) {
            Log.e("IABWrapper", "loadSkus() called with: " + IABError.NoContext + " context is null");
            this.C.b(null);
        } else {
            O();
            d().a(this.C);
        }
    }

    private boolean c(Purchase purchase) {
        if (this.f4513a == null) {
            return false;
        }
        if ((this.f4513a instanceof com.nexstreaming.app.general.iab.c.a) || (this.f4513a instanceof com.nexstreaming.app.general.iab.b.a)) {
            return true;
        }
        int random = (int) (Math.random() * 65535.0d);
        return ((this.f4513a.a(random) - (random ^ 4660)) ^ ((purchase.j() ^ 79225) & 65535)) == 51916;
    }

    public void v() {
        if (d() != null) {
            d().a();
        }
    }

    public Purchase w() {
        return this.p;
    }

    private void a(String str, String str2, String str3, String str4) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.w);
        HashSet hashSet = new HashSet();
        Set<String> stringSet = defaultSharedPreferences.getStringSet("registered_iap_orders", null);
        if (stringSet != null) {
            if (!stringSet.contains(str)) {
                hashSet.addAll(stringSet);
            } else {
                return;
            }
        }
        com.nexstreaming.kinemaster.tracelog.d.a(this.w, str, str2, str3, str4).onResultAvailable(new ag(this, str, hashSet, defaultSharedPreferences, str3));
    }

    public void a(int i, int i2, Intent intent) {
        if (this.f4513a != null && this.w != null) {
            Task.TaskError[] taskErrorArr = new Task.TaskError[1];
            Purchase a2 = d().a(i, i2, intent, taskErrorArr);
            if (a2 != null) {
                if (!c(a2)) {
                    KMAppUsage.a(this.w).a(KMAppUsage.KMMetric.SubAction, "no_vfy");
                    this.F.a(false, a2, IABError.InternalErrorA0.name());
                    return;
                } else if (a2.k() != Purchase.PurchaseState.Purchased) {
                    KMAppUsage.a(this.w).a(KMAppUsage.KMMetric.SubAction, "no_pur");
                    this.F.a(false, a2, IABError.InternalErrorA1.name());
                    return;
                } else {
                    this.F.a(true, a2, null);
                    return;
                }
            }
            if (taskErrorArr[0] == BillingResponse.USER_CANCELED_ACTIVITY) {
                KMAppUsage.a(this.w).a(KMAppUsage.KMMetric.SubAction, "cancel");
                this.F.a(false, a2, null);
            } else {
                KMAppUsage.a(this.w).a(KMAppUsage.KMMetric.SubAction, taskErrorArr[0].getMessage());
                this.F.a(false, a2, taskErrorArr[0].getMessage());
            }
        }
    }

    public void a(Map<IABHelper.SKUType, List<Purchase>> map) {
        if (this.f4513a instanceof com.nexstreaming.app.general.iab.a.a) {
            if (map.get(IABHelper.SKUType.inapp) != null && map.get(IABHelper.SKUType.inapp).size() > 0) {
                a(map.get(IABHelper.SKUType.inapp));
            }
            if (map.get(IABHelper.SKUType.subs) != null && map.get(IABHelper.SKUType.subs).size() > 0) {
                b(map.get(IABHelper.SKUType.subs));
                return;
            }
            return;
        }
        if (this.f4513a instanceof com.nexstreaming.app.general.iab.c.a) {
            if (map.get(IABHelper.SKUType.xiaomi) != null && map.get(IABHelper.SKUType.xiaomi).size() > 0) {
                a(map.get(IABHelper.SKUType.xiaomi));
                return;
            }
            return;
        }
        if ((this.f4513a instanceof com.nexstreaming.app.general.iab.b.a) && map.get(IABHelper.SKUType.wechat) != null && map.get(IABHelper.SKUType.wechat).size() > 0) {
            a(map.get(IABHelper.SKUType.wechat));
        }
    }

    private void a(List<Purchase> list) {
        if (list != null) {
            DiagnosticLogger.a().a(DiagnosticLogger.ParamTag.IW_GETP_RESULT_INAPP, list.size());
            M();
            for (Purchase purchase : list) {
                if (!c(purchase)) {
                    DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_NOTVALID_INAPP);
                    KMAppUsage.a(this.w).a(KMAppUsage.KMMetric.SubInfo, "no_vfy_ia");
                } else if (purchase.k() != Purchase.PurchaseState.Purchased) {
                    switch (purchase.k()) {
                        case Canceled:
                            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_CANCELED);
                            break;
                        case Refunded:
                            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_REFUNDED);
                            break;
                        default:
                            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_OTHER);
                            break;
                    }
                    KMAppUsage.a(this.w).a(KMAppUsage.KMMetric.SubInfo, "no_pur_iap");
                } else if (a(purchase)) {
                    SupportLogger.Event.IW_Once_Success.log(new int[0]);
                }
            }
            SupportLogger.Event.IW_Once_Success.log(new int[0]);
        }
    }

    /* compiled from: IABWrapper.java */
    /* renamed from: com.nextreaming.nexeditorui.af$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] b;

        static {
            try {
                c[Purchase.PurchaseState.Canceled.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                c[Purchase.PurchaseState.Refunded.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            b = new int[ResponseCode.values().length];
            try {
                b[ResponseCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[ResponseCode.ALREADY_IAP_REGISTERED.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[ResponseCode.APPAUTH_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                b[ResponseCode.INVALID_APIVERSION.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                b[ResponseCode.ERR_NORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            f4514a = new int[PurchaseType.values().length];
            try {
                f4514a[PurchaseType.SubAnnual.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f4514a[PurchaseType.SubMonthly.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f4514a[PurchaseType.SubUnknown.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f4514a[PurchaseType.OneTimeValid.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f4514a[PurchaseType.Promocode.ordinal()] = 5;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f4514a[PurchaseType.OneTimeExpired.ordinal()] = 6;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f4514a[PurchaseType.None.ordinal()] = 7;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    private void b(List<Purchase> list) {
        if (list != null) {
            DiagnosticLogger.a().a(DiagnosticLogger.ParamTag.IW_GETP_RESULT_INAPP, list.size());
            for (Purchase purchase : list) {
                if (!c(purchase)) {
                    DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_NOTVALID_INAPP);
                    KMAppUsage.a(this.w).a(KMAppUsage.KMMetric.SubInfo, "no_vfy_ia");
                } else if (purchase.k() != Purchase.PurchaseState.Purchased) {
                    switch (purchase.k()) {
                        case Canceled:
                            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_CANCELED);
                            break;
                        case Refunded:
                            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_REFUNDED);
                            break;
                        default:
                            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_OTHER);
                            break;
                    }
                    KMAppUsage.a(this.w).a(KMAppUsage.KMMetric.SubInfo, "no_pur_iap");
                } else if (b(purchase)) {
                    SupportLogger.Event.IW_Once_Success.log(new int[0]);
                }
            }
            SupportLogger.Event.IW_Once_Success.log(new int[0]);
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        DiagnosticLogger.a().b();
        DiagnosticLogger.a().toString();
        if (this.f4513a != null && (this.f4513a instanceof com.nexstreaming.app.general.iab.a.a)) {
            new a.C0074a(this.w).f(R.string.iab_no_connection).d(18).a(A()).c(12).c(R.string.continue_with_watermark, new ap(this, onClickListener)).b(R.string.check_account, new ao(this)).a(R.string.retry, new an(this)).a().show();
        } else {
            b(new aq(this, onClickListener));
        }
    }

    public void b(DialogInterface.OnClickListener onClickListener) {
        if (this.y == null) {
            String str = "";
            if (this.f4513a != null) {
                if (this.f4513a instanceof com.nexstreaming.app.general.iab.c.a) {
                    str = this.w.getString(R.string.xiaomi);
                } else if (this.f4513a instanceof com.nexstreaming.app.general.iab.a.a) {
                    str = this.w.getString(R.string.google);
                }
            }
            this.y = new com.nexstreaming.kinemaster.ui.a.a(this.w);
            this.y.setTitle(String.format(this.w.getString(R.string.account_of), str));
            this.y.a(String.format(this.w.getString(R.string.account_login_popup_message), str));
            this.y.d(12);
            this.y.e(18);
            this.y.b(this.w.getString(R.string.continue_with_watermark), new ar(this, onClickListener));
            this.y.a(this.w.getString(R.string.service_login_required), new as(this));
        }
        if (this.y != null && !this.y.isShowing()) {
            this.y.show();
        }
    }

    public void x() {
        if (this.y != null) {
            this.y.dismiss();
        }
    }

    public void y() {
        if (this.f4513a != null) {
            O();
            this.f4513a.b(this.B);
        }
    }

    public void z() {
        if (this.f4513a != null) {
            O();
            this.f4513a.d(this.B);
        }
    }

    public String A() {
        if (this.f4513a != null) {
            if (this.f4513a instanceof com.nexstreaming.app.general.iab.a.a) {
                return this.w.getString(R.string.iab_connection_fail_message);
            }
            return this.f4513a instanceof com.nexstreaming.app.general.iab.c.a ? String.format(this.w.getString(R.string.account_login_message), this.w.getString(R.string.xiaomi)) : this.f4513a instanceof com.nexstreaming.app.general.iab.b.a ? String.format(this.w.getString(R.string.account_login_message), this.w.getString(R.string.sns_wechat)) : this.w.getString(R.string.iab_connection_fail_message);
        }
        return this.w.getString(R.string.iab_connection_fail_message);
    }

    public boolean B() {
        return this.f4513a != null && (this.f4513a instanceof com.nexstreaming.app.general.iab.a.a);
    }

    public ResultTask<a.C0073a> a(String str, String str2) {
        ResultTask<a.C0073a> resultTask = new ResultTask<>();
        if (com.nexstreaming.kinemaster.tracelog.a.a(str)) {
            com.nexstreaming.kinemaster.tracelog.a.a(this.w, str, str2, this.f4513a == null || (this.f4513a instanceof com.nexstreaming.app.general.iab.a.a)).onResultAvailable(new au(this, resultTask)).onFailure((Task.OnFailListener) new at(this, resultTask));
            return resultTask;
        }
        resultTask.sendFailure(new a.C0073a(false, "verifyFail", R.string.apc_err_verify_fail, null));
        return resultTask;
    }

    public boolean C() {
        this.m = com.nexstreaming.kinemaster.tracelog.a.a(this.w);
        return this.m;
    }

    public boolean D() {
        return this.f4513a != null && this.f4513a.b();
    }

    public boolean E() {
        return this.f4513a != null;
    }

    public String F() {
        if (this.f4513a == null) {
            return null;
        }
        return this.f4513a.s();
    }

    public String G() {
        if (this.f4513a == null) {
            return null;
        }
        return this.f4513a.r();
    }

    public void a(IABHelper iABHelper, Map<String, SKUDetails> map) {
        if (iABHelper != null && map != null) {
            if (map.get(iABHelper.c()) != null) {
                this.g = map.get(iABHelper.c());
            }
            if (map.get(iABHelper.d()) != null) {
                this.h = map.get(iABHelper.d());
            }
            if (map.get(iABHelper.e()) != null) {
                this.i = map.get(iABHelper.e());
            }
            if (map.get(iABHelper.f()) != null) {
                this.j = map.get(iABHelper.f());
            }
            if (map.get(iABHelper.g()) != null) {
                this.k = map.get(iABHelper.g());
            }
            if (map.get(iABHelper.h()) != null) {
                this.l = map.get(iABHelper.h());
            }
        }
    }

    public void N() {
        String str;
        if (this.f4513a == null) {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        } else {
            str = this.f4513a.q();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Type", s());
            jSONObject.put("Store", str);
            jSONObject.put("Revenue Est", r());
            KMUsage.getMixpanelInstanceFromContext(this.w).a("Purchase Plan", jSONObject);
            KMUsage.Purchase_Plan.logEvent(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("Purchase Store", str);
            jSONObject2.put("Last Purchase Date", KMUsage.getISODateTimeUTC());
            KMUsage.getMixpanelInstanceFromContext(this.w).a(jSONObject2);
            KMUsage.Purchase_Store.logEvent(jSONObject2);
        } catch (JSONException e) {
            Log.e("IABWrapper", "MixPanel Error", e);
        }
        n.c mixpanelPeople = KMUsage.getMixpanelPeople(this.w);
        mixpanelPeople.a("Lifetime Revenue Est", r());
        mixpanelPeople.a(r(), (JSONObject) null);
        mixpanelPeople.a("Purchase Count", 1.0d);
        mixpanelPeople.a("Purchase Store", str);
        mixpanelPeople.a("Last Purchase Date", KMUsage.getISODateTimeUTC());
        KMUsage.getMixpanelInstanceFromContext(this.w).a();
    }

    public void O() {
        if (!(this.w instanceof ProjectGalleryActivity)) {
            if (this.z == null) {
                this.z = ProgressDialog.show(this.w, null, null);
                this.z.setContentView(R.layout.layout_transparent_progress_dialog);
                this.z.getWindow().setDimAmount(0.0f);
                this.z.getWindow().setBackgroundDrawable(this.w.getResources().getDrawable(android.R.color.transparent));
                this.z.setCancelable(true);
                this.z.setCanceledOnTouchOutside(false);
            }
            if (!this.z.isShowing()) {
                this.z.show();
            }
        }
    }

    public void P() {
        if (this.z != null && this.z.isShowing()) {
            this.z.dismiss();
        }
    }

    public SKUDetails H() {
        SKUDetails[] sKUDetailsArr = {this.g, this.h, this.i};
        if (this.f4513a != null) {
            for (SKUDetails sKUDetails : sKUDetailsArr) {
                if (this.f4513a.f(sKUDetails)) {
                    return sKUDetails;
                }
            }
        }
        return null;
    }

    public SKUDetails I() {
        SKUDetails[] sKUDetailsArr = {this.g, this.h, this.i};
        if (this.f4513a != null) {
            for (SKUDetails sKUDetails : sKUDetailsArr) {
                if (this.f4513a.e(sKUDetails)) {
                    return sKUDetails;
                }
            }
        }
        return null;
    }

    public int J() {
        SKUDetails H = H();
        SKUDetails I = I();
        if (H == null || I == null) {
            return 0;
        }
        return (int) Math.floor((1.0d - (H.e() / (I.e() * 12))) * 100.0d);
    }
}

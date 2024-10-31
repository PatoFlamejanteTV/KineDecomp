package com.qq.e.ads.interstitial2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class UnifiedInterstitialAD {

    /* renamed from: a, reason: collision with root package name */
    private UIADI f24860a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f24861b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f24862c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f24863d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicInteger f24864e;

    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, str2, unifiedInterstitialADListener, null);
    }

    public UnifiedInterstitialAD(final Activity activity, final String str, final String str2, final UnifiedInterstitialADListener unifiedInterstitialADListener, final Map map) {
        this.f24861b = false;
        this.f24862c = false;
        this.f24863d = false;
        this.f24864e = new AtomicInteger(0);
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedInterstitialADListener == null) {
            GDTLogger.e(String.format("UnifiedInterstitialAD Constructor paras error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedInterstitialADListener));
            return;
        }
        this.f24861b = true;
        if (!a.a(activity)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
        } else {
            this.f24862c = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.interstitial2.UnifiedInterstitialAD.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!GDTADManager.getInstance().initWith(activity, str)) {
                        GDTLogger.e("Fail to init ADManager");
                        return;
                    }
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.interstitial2.UnifiedInterstitialAD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        if (pOFactory != null) {
                                            UnifiedInterstitialAD.this.f24860a = pOFactory.getUnifiedInterstitialADDelegate(activity, str, str2, unifiedInterstitialADListener);
                                            UnifiedInterstitialAD.a(UnifiedInterstitialAD.this, true);
                                            UnifiedInterstitialAD.a(UnifiedInterstitialAD.this, map, str2);
                                            while (UnifiedInterstitialAD.this.f24864e.getAndDecrement() > 0) {
                                                UnifiedInterstitialAD.this.loadAD();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("Exception while init UnifiedInterstitialAD Core", th);
                                    }
                                } finally {
                                    UnifiedInterstitialAD.a(UnifiedInterstitialAD.this, true);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init UnifiedInterstitialAD plugin", th);
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(UnifiedInterstitialAD unifiedInterstitialAD, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e2) {
            GDTLogger.e("UnifiedInterstitialAD#setTag Exception");
            e2.printStackTrace();
        }
    }

    static /* synthetic */ boolean a(UnifiedInterstitialAD unifiedInterstitialAD, boolean z) {
        unifiedInterstitialAD.f24863d = true;
        return true;
    }

    public void close() {
        UIADI uiadi = this.f24860a;
        if (uiadi != null) {
            uiadi.close();
        }
    }

    public void destroy() {
        UIADI uiadi = this.f24860a;
        if (uiadi != null) {
            uiadi.destory();
        }
    }

    public Map getExt() {
        try {
            if (this.f24860a != null) {
                return UIADI.ext;
            }
            return null;
        } catch (Exception unused) {
            GDTLogger.e("interstitial2 can not get ext");
            return null;
        }
    }

    public void loadAD() {
        if (!this.f24861b || !this.f24862c) {
            GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
            return;
        }
        if (!this.f24863d) {
            this.f24864e.incrementAndGet();
            return;
        }
        UIADI uiadi = this.f24860a;
        if (uiadi != null) {
            uiadi.loadAd();
        } else {
            GDTLogger.e("InterstitialAD Init error,See More Logs");
        }
    }

    public void show() {
        UIADI uiadi = this.f24860a;
        if (uiadi != null) {
            uiadi.show();
        }
    }

    public void show(Activity activity) {
        UIADI uiadi = this.f24860a;
        if (uiadi != null) {
            uiadi.show(activity);
        }
    }

    public void showAsPopupWindow() {
        UIADI uiadi = this.f24860a;
        if (uiadi != null) {
            uiadi.showAsPopupWindow();
        }
    }

    public void showAsPopupWindow(Activity activity) {
        UIADI uiadi = this.f24860a;
        if (uiadi != null) {
            uiadi.showAsPopupWindow(activity);
        }
    }
}

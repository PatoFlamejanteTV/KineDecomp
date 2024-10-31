package com.qq.e.ads.splash;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class SplashAD {

    /* renamed from: a, reason: collision with root package name */
    private NSPVI f24940a;

    /* renamed from: b, reason: collision with root package name */
    private SplashADListener f24941b;

    /* loaded from: classes3.dex */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(SplashAD splashAD, byte b2) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (SplashAD.this.f24941b == null) {
                GDTLogger.e("SplashADListener == null");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    SplashAD.this.f24941b.onADDismissed();
                    return;
                case 2:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        SplashAD.this.f24941b.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    } else {
                        GDTLogger.e("Splash onNoAD event get params error.");
                        return;
                    }
                case 3:
                    SplashAD.this.f24941b.onADPresent();
                    return;
                case 4:
                    SplashAD.this.f24941b.onADClicked();
                    return;
                case 5:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Long)) {
                        SplashAD.this.f24941b.onADTick(((Long) aDEvent.getParas()[0]).longValue());
                        return;
                    } else {
                        GDTLogger.e("Splash onADTick event get param error.");
                        return;
                    }
                case 6:
                    SplashAD.this.f24941b.onADExposure();
                    return;
                default:
                    return;
            }
        }
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, View view, String str, String str2, SplashADListener splashADListener, int i) {
        this(activity, viewGroup, view, str, str2, splashADListener, i, null);
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, View view, String str, String str2, SplashADListener splashADListener, int i, Map map) {
        int i2;
        this.f24941b = splashADListener;
        byte b2 = 0;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || viewGroup == null || activity == null) {
            GDTLogger.e(String.format("SplashAD Constructor params error, appid=%s,posId=%s,context=%s", str, str2, activity));
            i2 = 2001;
        } else if (a.a(activity)) {
            try {
                try {
                    if (!GDTADManager.getInstance().initWith(activity, str)) {
                        GDTLogger.e("Fail to Init GDT AD SDK, report logcat info filter by gdt_ad_mob");
                        a(splashADListener, 200101);
                        return;
                    }
                    this.f24940a = GDTADManager.getInstance().getPM().getPOFactory().getNativeSplashAdView(activity, str, str2);
                    if (this.f24940a == null) {
                        GDTLogger.e("SplashAdView created by factory return null");
                        a(splashADListener, 200103);
                        return;
                    }
                    if (map != null && map.size() > 0) {
                        try {
                            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str2);
                        } catch (Exception e2) {
                            GDTLogger.e("SplashAD#setTag Exception");
                            e2.printStackTrace();
                        }
                    }
                    this.f24940a.setFetchDelay(i);
                    this.f24940a.setAdListener(new ADListenerAdapter(this, b2));
                    this.f24940a.setSkipView(view);
                    this.f24940a.fetchAndShowIn(viewGroup);
                    return;
                } catch (c e3) {
                    GDTLogger.e("Fail to init splash plugin", e3);
                    i2 = 200102;
                }
            } catch (Throwable th) {
                GDTLogger.e("Unknown Exception", th);
                a(splashADListener, ErrorCode.OtherError.UNKNOWN_ERROR);
                return;
            }
        } else {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            i2 = LicenseErrCode.ERROR_NETWORK_ERROR;
        }
        a(splashADListener, i2);
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, String str, String str2, SplashADListener splashADListener) {
        this(activity, viewGroup, str, str2, splashADListener, 0);
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, String str, String str2, SplashADListener splashADListener, int i) {
        this(activity, viewGroup, null, str, str2, splashADListener, i);
    }

    private static void a(SplashADListener splashADListener, int i) {
        if (splashADListener != null) {
            splashADListener.onNoAD(a.a(i));
        }
    }

    public final Map getExt() {
        try {
            return NSPVI.ext;
        } catch (Exception e2) {
            GDTLogger.e("splash ad can not get extra");
            e2.printStackTrace();
            return null;
        }
    }
}

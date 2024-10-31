package com.qq.e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class UnifiedBannerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private UBVI f24786a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f24787b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f24788c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f24789d;

    /* renamed from: e, reason: collision with root package name */
    private DownAPPConfirmPolicy f24790e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f24791f;

    /* renamed from: g, reason: collision with root package name */
    private int f24792g;

    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, str2, unifiedBannerADListener, null);
    }

    public UnifiedBannerView(final Activity activity, final String str, final String str2, final UnifiedBannerADListener unifiedBannerADListener, final Map map) {
        super(activity);
        this.f24787b = false;
        this.f24788c = false;
        this.f24789d = false;
        this.f24791f = 0;
        this.f24792g = 30;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedBannerADListener == null) {
            GDTLogger.e(String.format("UnifiedBannerView Constructor params error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedBannerADListener));
            return;
        }
        this.f24787b = true;
        if (!a.a(activity)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.f24788c = true;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.banner2.UnifiedBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!GDTADManager.getInstance().initWith(activity, str)) {
                    GDTLogger.e("Fail to init ADManager");
                    return;
                }
                try {
                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.banner2.UnifiedBannerView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                try {
                                    if (pOFactory != null) {
                                        UnifiedBannerView.this.f24786a = pOFactory.getUnifiedBannerViewDelegate(UnifiedBannerView.this, activity, str, str2, unifiedBannerADListener);
                                        UnifiedBannerView.a(UnifiedBannerView.this, true);
                                        UnifiedBannerView.a(UnifiedBannerView.this, map, str2);
                                        if (UnifiedBannerView.this.f24790e != null) {
                                            UnifiedBannerView.this.setDownConfirmPolicy(UnifiedBannerView.this.f24790e);
                                        }
                                        UnifiedBannerView.this.setRefresh(UnifiedBannerView.this.f24792g);
                                        while (UnifiedBannerView.c(UnifiedBannerView.this) > 0) {
                                            UnifiedBannerView.this.loadAD();
                                        }
                                    }
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init UnifiedBannerView Core", th);
                                }
                            } finally {
                                UnifiedBannerView.a(UnifiedBannerView.this, true);
                            }
                        }
                    });
                } catch (Throwable th) {
                    GDTLogger.e("Exception while init UnifiedBannerView plugin", th);
                }
            }
        });
    }

    static /* synthetic */ void a(UnifiedBannerView unifiedBannerView, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e2) {
            GDTLogger.e("UnifiedBanner#setTag Exception");
            e2.printStackTrace();
        }
    }

    static /* synthetic */ boolean a(UnifiedBannerView unifiedBannerView, boolean z) {
        unifiedBannerView.f24789d = true;
        return true;
    }

    static /* synthetic */ int c(UnifiedBannerView unifiedBannerView) {
        int i = unifiedBannerView.f24791f;
        unifiedBannerView.f24791f = i - 1;
        return i;
    }

    public void destroy() {
        UBVI ubvi = this.f24786a;
        if (ubvi != null) {
            ubvi.destroy();
        }
    }

    public Map getExt() {
        try {
            if (this.f24786a != null) {
                return UBVI.ext;
            }
            return null;
        } catch (Exception unused) {
            GDTLogger.e("banner2 can not get ext");
            return null;
        }
    }

    public void loadAD() {
        if (!this.f24787b || !this.f24788c) {
            GDTLogger.e("UnifiedBannerView init Paras OR Context error,See More logs while new BannerView");
            return;
        }
        if (!this.f24789d) {
            this.f24791f++;
            return;
        }
        UBVI ubvi = this.f24786a;
        if (ubvi != null) {
            ubvi.fetchAd();
        } else {
            GDTLogger.e("UnifiedBannerView Init error,See More Logs");
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        UBVI ubvi = this.f24786a;
        if (ubvi != null) {
            ubvi.onWindowFocusChanged(z);
        }
    }

    public void setDownConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        UBVI ubvi;
        this.f24790e = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || (ubvi = this.f24786a) == null) {
            return;
        }
        ubvi.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    public void setRefresh(int i) {
        this.f24792g = i;
        UBVI ubvi = this.f24786a;
        if (ubvi != null) {
            ubvi.setRefresh(i);
        }
    }
}

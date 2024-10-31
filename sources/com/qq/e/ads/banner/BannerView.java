package com.qq.e.ads.banner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.BannerRollAnimation;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.BVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class BannerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private BVI f24770a;

    /* renamed from: b, reason: collision with root package name */
    private BannerADListener f24771b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f24772c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f24773d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f24774e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f24775f;

    /* renamed from: g, reason: collision with root package name */
    private BannerRollAnimation f24776g;

    /* renamed from: h, reason: collision with root package name */
    private DownAPPConfirmPolicy f24777h;
    private Boolean i;
    private volatile int j;

    /* loaded from: classes3.dex */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(BannerView bannerView, byte b2) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (BannerView.this.f24771b == null) {
                GDTLogger.i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        BannerView.this.f24771b.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    GDTLogger.e("AdEvent.Paras error for Banner(" + aDEvent + ")");
                    return;
                case 2:
                    BannerView.this.f24771b.onADReceiv();
                    return;
                case 3:
                    BannerView.this.f24771b.onADExposure();
                    return;
                case 4:
                    BannerView.this.f24771b.onADClosed();
                    return;
                case 5:
                    BannerView.this.f24771b.onADClicked();
                    return;
                case 6:
                    BannerView.this.f24771b.onADLeftApplication();
                    return;
                case 7:
                    BannerView.this.f24771b.onADOpenOverlay();
                    return;
                case 8:
                    BannerView.this.f24771b.onADCloseOverlay();
                    return;
                default:
                    return;
            }
        }
    }

    public BannerView(final Activity activity, final ADSize aDSize, final String str, final String str2) {
        super(activity);
        this.f24772c = false;
        this.f24773d = false;
        this.f24774e = false;
        this.j = 0;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.e(String.format("Banner ADView Constructor params error, appid=%s,posId=%s,context=%s", str, str2, activity));
            return;
        }
        this.f24772c = true;
        if (!a.a(activity)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.f24773d = true;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.banner.BannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!GDTADManager.getInstance().initWith(activity, str)) {
                    GDTLogger.e("Fail to init ADManager");
                    return;
                }
                try {
                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.banner.BannerView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                try {
                                    if (pOFactory != null) {
                                        BannerView.this.f24770a = pOFactory.getBannerView(activity, aDSize, str, str2);
                                        BannerView.this.f24770a.setAdListener(new ADListenerAdapter(BannerView.this, (byte) 0));
                                        BannerView.this.addView(BannerView.this.f24770a.getView());
                                        BannerView.a(BannerView.this, true);
                                        if (BannerView.this.f24777h != null) {
                                            BannerView.this.setDownConfirmPilicy(BannerView.this.f24777h);
                                        }
                                        if (BannerView.this.f24775f != null) {
                                            BannerView.this.setRefresh(BannerView.this.f24775f.intValue());
                                        }
                                        if (BannerView.this.f24776g != null) {
                                            BannerView.this.setRollAnimation(BannerView.this.f24776g);
                                        }
                                        if (BannerView.this.i != null) {
                                            BannerView.this.setShowClose(BannerView.this.i.booleanValue());
                                        }
                                        while (BannerView.f(BannerView.this) > 0) {
                                            BannerView.this.loadAD();
                                        }
                                    }
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init Banner Core", th);
                                }
                            } finally {
                                BannerView.a(BannerView.this, true);
                            }
                        }
                    });
                } catch (Throwable th) {
                    GDTLogger.e("Exception while init Banner plugin", th);
                }
            }
        });
    }

    static /* synthetic */ boolean a(BannerView bannerView, boolean z) {
        bannerView.f24774e = true;
        return true;
    }

    static /* synthetic */ int f(BannerView bannerView) {
        int i = bannerView.j;
        bannerView.j = i - 1;
        return i;
    }

    public void destroy() {
        BVI bvi = this.f24770a;
        if (bvi != null) {
            bvi.destroy();
        }
    }

    public void loadAD() {
        if (!this.f24772c || !this.f24773d) {
            GDTLogger.e("Banner init Paras OR Context error,See More logs while new BannerView");
            return;
        }
        if (!this.f24774e) {
            this.j++;
            return;
        }
        BVI bvi = this.f24770a;
        if (bvi != null) {
            bvi.fetchAd();
        } else {
            GDTLogger.e("Banner Init error,See More Logs");
        }
    }

    public void setADListener(BannerADListener bannerADListener) {
        this.f24771b = bannerADListener;
    }

    public void setDownConfirmPilicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        BVI bvi;
        this.f24777h = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || (bvi = this.f24770a) == null) {
            return;
        }
        bvi.setDownAPPConfirmPolicy(downAPPConfirmPolicy.value());
    }

    public void setRefresh(int i) {
        this.f24775f = Integer.valueOf(i);
        if (i < 30 && i != 0) {
            i = 30;
        } else if (i > 120) {
            i = 120;
        }
        BVI bvi = this.f24770a;
        if (bvi != null) {
            bvi.setRefresh(i);
        }
    }

    public void setRollAnimation(BannerRollAnimation bannerRollAnimation) {
        BVI bvi;
        this.f24776g = bannerRollAnimation;
        if (bannerRollAnimation == null || (bvi = this.f24770a) == null) {
            return;
        }
        bvi.setRollAnimation(bannerRollAnimation.value());
    }

    public void setShowClose(boolean z) {
        this.i = Boolean.valueOf(z);
        BVI bvi = this.f24770a;
        if (bvi != null) {
            bvi.setShowCloseButton(z);
        }
    }
}

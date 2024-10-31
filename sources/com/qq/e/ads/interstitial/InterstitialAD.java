package com.qq.e.ads.interstitial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.IADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class InterstitialAD {

    /* renamed from: a, reason: collision with root package name */
    private IADI f24847a;

    /* renamed from: b, reason: collision with root package name */
    private InterstitialADListener f24848b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f24849c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f24850d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f24851e = false;

    /* renamed from: f, reason: collision with root package name */
    private AtomicInteger f24852f = new AtomicInteger(0);

    /* loaded from: classes3.dex */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(InterstitialAD interstitialAD, byte b2) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (InterstitialAD.this.f24848b == null) {
                GDTLogger.i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        InterstitialAD.this.f24848b.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    GDTLogger.e("AdEvent.Paras error for InterstitialAD(" + aDEvent + ")");
                    return;
                case 2:
                    InterstitialAD.this.f24848b.onADReceive();
                    return;
                case 3:
                    InterstitialAD.this.f24848b.onADExposure();
                    return;
                case 4:
                    InterstitialAD.this.f24848b.onADOpened();
                    return;
                case 5:
                    InterstitialAD.this.f24848b.onADClicked();
                    return;
                case 6:
                    InterstitialAD.this.f24848b.onADLeftApplication();
                    return;
                case 7:
                    InterstitialAD.this.f24848b.onADClosed();
                    return;
                default:
                    return;
            }
        }
    }

    public InterstitialAD(final Activity activity, final String str, final String str2) {
        this.f24849c = false;
        this.f24850d = false;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.e(String.format("Interstitial Constructor paras error, appid=%s,posId=%s,context=%s", str, str2, activity));
            return;
        }
        this.f24849c = true;
        if (!a.a(activity)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
        } else {
            this.f24850d = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.interstitial.InterstitialAD.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!GDTADManager.getInstance().initWith(activity, str)) {
                        GDTLogger.e("Fail to init ADManager");
                        return;
                    }
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.interstitial.InterstitialAD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        if (pOFactory != null) {
                                            InterstitialAD.this.f24847a = pOFactory.getIADView(activity, str, str2);
                                            InterstitialAD.this.f24847a.setAdListener(new ADListenerAdapter(InterstitialAD.this, (byte) 0));
                                            InterstitialAD.a(InterstitialAD.this, true);
                                            while (InterstitialAD.this.f24852f.getAndDecrement() > 0) {
                                                InterstitialAD.this.loadAD();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("Exception while init IAD Core", th);
                                    }
                                } finally {
                                    InterstitialAD.a(InterstitialAD.this, true);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init IAD plugin", th);
                    }
                }
            });
        }
    }

    static /* synthetic */ boolean a(InterstitialAD interstitialAD, boolean z) {
        interstitialAD.f24851e = true;
        return true;
    }

    public void closePopupWindow() {
        IADI iadi = this.f24847a;
        if (iadi != null) {
            iadi.closePopupWindow();
        }
    }

    public void destroy() {
        IADI iadi = this.f24847a;
        if (iadi != null) {
            iadi.destory();
        }
    }

    public void loadAD() {
        if (!this.f24849c || !this.f24850d) {
            GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
            return;
        }
        if (!this.f24851e) {
            this.f24852f.incrementAndGet();
            return;
        }
        IADI iadi = this.f24847a;
        if (iadi != null) {
            iadi.loadAd();
        } else {
            GDTLogger.e("InterstitialAD Init error,See More Logs");
        }
    }

    public void setADListener(InterstitialADListener interstitialADListener) {
        this.f24848b = interstitialADListener;
    }

    public synchronized void show() {
        if (this.f24847a != null) {
            this.f24847a.show();
        }
    }

    public synchronized void show(Activity activity) {
        if (this.f24847a != null) {
            this.f24847a.show(activity);
        }
    }

    public synchronized void showAsPopupWindow() {
        if (this.f24847a != null) {
            this.f24847a.showAsPopupWindown();
        }
    }

    public synchronized void showAsPopupWindow(Activity activity) {
        if (this.f24847a != null) {
            this.f24847a.showAsPopupWindown(activity);
        }
    }
}

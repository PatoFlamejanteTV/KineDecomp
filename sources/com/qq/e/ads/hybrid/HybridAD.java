package com.qq.e.ads.hybrid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class HybridAD implements HADI {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f24822a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f24823b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f24824c;

    /* renamed from: d, reason: collision with root package name */
    private HADI f24825d;

    /* renamed from: e, reason: collision with root package name */
    private HybridADListener f24826e;

    /* renamed from: f, reason: collision with root package name */
    private CountDownLatch f24827f = new CountDownLatch(1);

    public HybridAD(final Context context, final String str, final HybridADSetting hybridADSetting, final HybridADListener hybridADListener) {
        if (context == null || TextUtils.isEmpty(str) || hybridADListener == null) {
            GDTLogger.e(String.format("HybridAD Constructor params error, context=%s, appID=%s,HybridADListener=%s", context, str, hybridADListener));
            return;
        }
        this.f24826e = hybridADListener;
        this.f24823b = true;
        if (!a.a(context)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
        } else {
            this.f24824c = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GDTADManager.getInstance().initWith(context, str)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    POFactory pOFactory2 = pOFactory;
                                    if (pOFactory2 != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        HybridAD.this.f24825d = pOFactory2.getHybridAD(hybridADSetting, hybridADListener);
                                        HybridAD.a(HybridAD.this, true);
                                    } else {
                                        GDTLogger.e("poFactory is null");
                                        HybridAD.a(HybridAD.this, 2001);
                                    }
                                    HybridAD.this.f24827f.countDown();
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            GDTLogger.e("Exception while init HybridAD plugin", th);
                        }
                    } else {
                        GDTLogger.e("Fail to init ADManager");
                    }
                    HybridAD.a(HybridAD.this, 2001);
                    HybridAD.this.f24827f.countDown();
                }
            });
        }
    }

    static /* synthetic */ void a(HybridAD hybridAD, int i) {
        final int i2 = 2001;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.3
            @Override // java.lang.Runnable
            public void run() {
                if (HybridAD.this.f24826e != null) {
                    HybridAD.this.f24826e.onError(a.a(i2));
                }
            }
        });
    }

    static /* synthetic */ boolean a(HybridAD hybridAD, boolean z) {
        hybridAD.f24822a = true;
        return true;
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        boolean z;
        if (this.f24823b && this.f24824c) {
            z = true;
        } else {
            GDTLogger.e("AD init Params OR Context error, details in logs produced while init HybridAD");
            z = false;
        }
        if (!z) {
            GDTLogger.e("HybridAD loadUrl error");
        } else if (this.f24822a) {
            this.f24825d.loadUrl(str);
        } else {
            new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HybridAD.this.f24827f.await(30L, TimeUnit.SECONDS);
                        if (HybridAD.this.f24822a) {
                            HybridAD.this.f24825d.loadUrl(str);
                        } else {
                            GDTLogger.e("delegate init failed ");
                            HybridAD.a(HybridAD.this, 2001);
                        }
                    } catch (InterruptedException unused) {
                        GDTLogger.e("buffered loadUrl action timeout");
                        HybridAD.a(HybridAD.this, 2001);
                    }
                }
            }).start();
        }
    }
}

package com.qq.e.ads.rewardvideo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.GDTLogger;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes3.dex */
public class RewardVideoAD {

    /* renamed from: a, reason: collision with root package name */
    private RewardVideoADListener f24925a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f24926b;

    /* renamed from: c, reason: collision with root package name */
    private RVADI f24927c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f24928d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f24929e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f24930f;

    /* loaded from: classes3.dex */
    public static class ADListenerAdapter implements ADListener {
        public static final int EVENT_TYPE_ON_AD_CLICK = 6;
        public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
        public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
        public static final int EVENT_TYPE_ON_AD_LOADED = 1;
        public static final int EVENT_TYPE_ON_AD_SHOW = 3;
        public static final int EVENT_TYPE_ON_ERROR = 9;
        public static final int EVENT_TYPE_ON_REWARD = 5;
        public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
        public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                    this.adListener.onADLoad();
                    return;
                case 2:
                    this.adListener.onVideoCached();
                    return;
                case 3:
                    this.adListener.onADShow();
                    return;
                case 4:
                    this.adListener.onADExpose();
                    return;
                case 5:
                    this.adListener.onReward();
                    return;
                case 6:
                    this.adListener.onADClick();
                    return;
                case 7:
                    this.adListener.onVideoComplete();
                    return;
                case 8:
                    this.adListener.onADClose();
                    return;
                case 9:
                    if (aDEvent.getParas().length == 1) {
                        Object obj = aDEvent.getParas()[0];
                        if (obj instanceof Integer) {
                            this.adListener.onError(a.a(((Integer) obj).intValue()));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public RewardVideoAD(final Context context, final String str, final String str2, final RewardVideoADListener rewardVideoADListener) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || rewardVideoADListener == null) {
            GDTLogger.e(String.format("RewardVideoAD Constructor params error, context=%s, appID=%s, posID=%s, rewardVideoADListener=%s", context, str, str2, rewardVideoADListener));
            return;
        }
        this.f24925a = rewardVideoADListener;
        this.f24928d = true;
        if (a.a(context)) {
            this.f24929e = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GDTADManager.getInstance().initWith(context, str)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (pOFactory == null) {
                                            RewardVideoAD.this.a(2001);
                                            return;
                                        }
                                        RewardVideoAD.this.f24927c = pOFactory.getRewardVideoADDelegate(context, str, str2, new ADListenerAdapter(rewardVideoADListener));
                                        RewardVideoAD.a(RewardVideoAD.this, true);
                                        if (RewardVideoAD.this.f24930f) {
                                            RewardVideoAD.this.loadAD();
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("Exception while init Core", th);
                                        RewardVideoAD.this.a(2001);
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            GDTLogger.e("Exception while init Reward Video AD Core", th);
                        }
                    }
                    RewardVideoAD.this.a(2001);
                }
            });
        } else {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            a(LicenseErrCode.ERROR_NETWORK_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.2
            @Override // java.lang.Runnable
            public void run() {
                if (RewardVideoAD.this.f24925a != null) {
                    RewardVideoAD.this.f24925a.onError(a.a(i));
                }
            }
        });
    }

    static /* synthetic */ boolean a(RewardVideoAD rewardVideoAD, boolean z) {
        rewardVideoAD.f24926b = true;
        return true;
    }

    public long getExpireTimestamp() {
        RVADI rvadi = this.f24927c;
        if (rvadi != null) {
            return rvadi.getExpireTimestamp();
        }
        GDTLogger.e("please invoke getExpireTimestamp method after callback \"onADLoad\" ");
        return 0L;
    }

    public boolean hasShown() {
        RVADI rvadi = this.f24927c;
        if (rvadi != null) {
            return rvadi.hasShown();
        }
        GDTLogger.e("please invoke hasShown method after callback \"onADLoad\" ");
        return false;
    }

    public void loadAD() {
        if (!this.f24928d || !this.f24929e) {
            GDTLogger.e("AD init Params OR Context error, details in logs produced while init RewardVideoAD");
            return;
        }
        if (!this.f24926b) {
            this.f24930f = true;
            return;
        }
        RVADI rvadi = this.f24927c;
        if (rvadi != null) {
            rvadi.loadAD();
        } else {
            GDTLogger.e("RewardVideo AD Init error, see more logs");
        }
    }

    public void showAD() {
        RVADI rvadi = this.f24927c;
        if (rvadi != null) {
            rvadi.showAD();
        } else {
            GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
        }
    }
}

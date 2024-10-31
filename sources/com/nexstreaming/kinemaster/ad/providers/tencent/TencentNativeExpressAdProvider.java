package com.nexstreaming.kinemaster.ad.providers.tencent;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.nexstreaming.kinemaster.ad.g;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import com.umeng.analytics.pro.b;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.TypeCastException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* compiled from: TencentNativeExpressAdProvider.kt */
/* loaded from: classes.dex */
public final class TencentNativeExpressAdProvider extends TencentAdProvider implements NativeExpressAD.NativeExpressADListener {
    private final long VALID_TIME;
    private g.a iadListener;
    private boolean isLoaded;
    private long loadedTime;
    private int mAdHeight;
    private int mAdWidth;
    private ViewGroup mContainerView;
    private TencentAdListener.NativeExpressAdListener mNativeAdListener;
    private NativeExpressAD mNativeExpressAD;
    private NativeExpressADView mNativeExpressAdView;
    private String mUnitId;
    private final TencentNativeExpressAdProvider$mediaListener$1 mediaListener;
    public static final Companion Companion = new Companion(null);
    private static final String TAG_TNEAP = TAG_TNEAP;
    private static final String TAG_TNEAP = TAG_TNEAP;

    /* compiled from: TencentNativeExpressAdProvider.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final String getTAG_TNEAP() {
            return TencentNativeExpressAdProvider.TAG_TNEAP;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.nexstreaming.kinemaster.ad.providers.tencent.TencentNativeExpressAdProvider$mediaListener$1] */
    public TencentNativeExpressAdProvider(Context context) {
        super(context);
        h.b(context, b.Q);
        this.VALID_TIME = 3600000;
        this.mAdWidth = -1;
        this.mAdHeight = -2;
        this.mUnitId = TencentAdProvider.Companion.getPG_UNIT_ID();
        this.mediaListener = new NativeExpressMediaListener() { // from class: com.nexstreaming.kinemaster.ad.providers.tencent.TencentNativeExpressAdProvider$mediaListener$1
            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoComplete(NativeExpressADView nativeExpressADView) {
                h.b(nativeExpressADView, "nativeExpressADView");
                Log.i(TencentNativeExpressAdProvider.Companion.getTAG_TNEAP(), "onVideoComplete");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
                h.b(nativeExpressADView, "nativeExpressADView");
                h.b(adError, "adError");
                Log.i(TencentNativeExpressAdProvider.Companion.getTAG_TNEAP(), "onVideoError");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoInit(NativeExpressADView nativeExpressADView) {
                h.b(nativeExpressADView, "nativeExpressADView");
                Log.i(TencentNativeExpressAdProvider.Companion.getTAG_TNEAP(), "onVideoInit");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoLoading(NativeExpressADView nativeExpressADView) {
                h.b(nativeExpressADView, "nativeExpressADView");
                Log.i(TencentNativeExpressAdProvider.Companion.getTAG_TNEAP(), "onVideoLoading");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
                h.b(nativeExpressADView, "nativeExpressADView");
                Log.i(TencentNativeExpressAdProvider.Companion.getTAG_TNEAP(), "onVideoPageClose");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
                h.b(nativeExpressADView, "nativeExpressADView");
                Log.i(TencentNativeExpressAdProvider.Companion.getTAG_TNEAP(), "onVideoPageOpen");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPause(NativeExpressADView nativeExpressADView) {
                h.b(nativeExpressADView, "nativeExpressADView");
                Log.i(TencentNativeExpressAdProvider.Companion.getTAG_TNEAP(), "onVideoPause");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoReady(NativeExpressADView nativeExpressADView, long j) {
                h.b(nativeExpressADView, "nativeExpressADView");
                Log.i(TencentNativeExpressAdProvider.Companion.getTAG_TNEAP(), "onVideoReady");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoStart(NativeExpressADView nativeExpressADView) {
                h.b(nativeExpressADView, "nativeExpressADView");
                Log.i(TencentNativeExpressAdProvider.Companion.getTAG_TNEAP(), "onVideoStart");
            }
        };
    }

    private final String getAdInfo(NativeExpressADView nativeExpressADView) {
        AdData boundData = nativeExpressADView.getBoundData();
        if (boundData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("title:");
        sb.append(boundData.getTitle());
        sb.append(",");
        sb.append("desc:");
        sb.append(boundData.getDesc());
        sb.append(",");
        sb.append("patternType:");
        sb.append(boundData.getAdPatternType());
        if (boundData.getAdPatternType() == 2) {
            sb.append(", video info: ");
            sb.append(getVideoInfo((AdData.VideoPlayer) boundData.getProperty(AdData.VideoPlayer.class)));
        }
        return sb.toString();
    }

    private final String getVideoInfo(AdData.VideoPlayer videoPlayer) {
        if (videoPlayer == null) {
            return null;
        }
        return "{state:" + videoPlayer.getVideoState() + ",duration:" + videoPlayer.getDuration() + ",position:" + videoPlayer.getCurrentPosition() + "}";
    }

    private final synchronized void notifyLoaded() {
        if (this.iadListener != null) {
            try {
                g.a aVar = this.iadListener;
                if (aVar != null) {
                    aVar.a(this);
                }
            } catch (Exception e2) {
                Log.e(TAG_TNEAP, e2.getMessage(), e2);
            }
        }
    }

    private final void renderAd(NativeExpressADView nativeExpressADView) {
        NativeExpressADView nativeExpressADView2 = this.mNativeExpressAdView;
        if (nativeExpressADView2 != null) {
            if (nativeExpressADView2 == null) {
                h.a();
                throw null;
            }
            nativeExpressADView2.destroy();
        }
        ViewGroup viewGroup = this.mContainerView;
        if (viewGroup != null) {
            if (viewGroup.getVisibility() != 0) {
                viewGroup.setVisibility(0);
            }
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeAllViews();
            }
        }
        this.mNativeExpressAdView = nativeExpressADView;
        NativeExpressADView nativeExpressADView3 = this.mNativeExpressAdView;
        if (nativeExpressADView3 != null) {
            nativeExpressADView3.setMediaListener(this.mediaListener);
            try {
                nativeExpressADView3.setAdSize(new ADSize(this.mAdWidth, this.mAdHeight));
            } catch (NumberFormatException unused) {
                Log.e(TAG_TNEAP, "ad size invalid");
            }
            ViewGroup viewGroup2 = this.mContainerView;
            if (viewGroup2 != null) {
                viewGroup2.addView(nativeExpressADView3);
            }
            nativeExpressADView3.render();
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider, com.nexstreaming.kinemaster.ad.g
    public synchronized void addListener(g.a aVar) {
        h.b(aVar, "listener");
        super.addListener(aVar);
        this.iadListener = aVar;
    }

    public final int getMAdHeight() {
        return this.mAdHeight;
    }

    public final int getMAdWidth() {
        return this.mAdWidth;
    }

    public final ViewGroup getMContainerView() {
        return this.mContainerView;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider, com.nexstreaming.kinemaster.ad.g
    public boolean isReady() {
        return this.isLoaded && this.loadedTime + this.VALID_TIME > System.currentTimeMillis();
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClicked(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClosed(NativeExpressADView nativeExpressADView) {
        ViewGroup viewGroup = this.mContainerView;
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
            viewGroup.setVisibility(8);
            this.isLoaded = false;
        }
        TencentAdListener.NativeExpressAdListener nativeExpressAdListener = this.mNativeAdListener;
        if (nativeExpressAdListener != null) {
            nativeExpressAdListener.onNativeClosed(this.mContainerView);
        }
        this.loadedTime = 0L;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADExposure(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLoaded(List<NativeExpressADView> list) {
        if (list != null) {
            this.isLoaded = true;
            this.loadedTime = System.currentTimeMillis();
            notifyLoaded();
            renderAd(list.get(0));
            TencentAdListener.NativeExpressAdListener nativeExpressAdListener = this.mNativeAdListener;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onNativeLoaded(this.mContainerView);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider
    public void onLoadAd() {
        super.onLoadAd();
        this.mNativeExpressAD = new NativeExpressAD(getContext(), new ADSize(this.mAdWidth, this.mAdHeight), TencentAdProvider.Companion.getAPPID(), this.mUnitId, this);
        NativeExpressAD nativeExpressAD = this.mNativeExpressAD;
        if (nativeExpressAD != null) {
            nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(0).setAutoPlayMuted(true).build());
        }
        NativeExpressAD nativeExpressAD2 = this.mNativeExpressAD;
        if (nativeExpressAD2 != null) {
            nativeExpressAD2.loadAD(1);
        }
    }

    @Override // com.qq.e.ads.AbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        this.isLoaded = false;
        this.loadedTime = 0L;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderFail(NativeExpressADView nativeExpressADView) {
        this.isLoaded = false;
        this.loadedTime = 0L;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
    }

    public final void setContainer() {
        setContainer(new TencentAdContainer(getContext(), null, 2, null));
    }

    public final void setMAdHeight(int i) {
        this.mAdHeight = i;
    }

    public final void setMAdWidth(int i) {
        this.mAdWidth = i;
    }

    public final void setMContainerView(ViewGroup viewGroup) {
        this.mContainerView = viewGroup;
    }

    @Override // com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider, com.nexstreaming.kinemaster.ad.g
    public void showDialogAd(AppCompatActivity appCompatActivity, int i, int i2) {
        h.b(appCompatActivity, "callerActivity");
        new com.nexstreaming.kinemaster.ad.b(this).show(appCompatActivity.getSupportFragmentManager(), i, i2);
    }

    public final void setContainer(int i) {
        View inflate = View.inflate(getContext(), i, null);
        if (inflate == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        setContainer((ViewGroup) inflate);
    }

    public final void setContainer(ViewGroup viewGroup) {
        h.b(viewGroup, "containerView");
        viewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.mContainerView = viewGroup;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TencentNativeExpressAdProvider(Context context, TencentAdListener.NativeExpressAdListener nativeExpressAdListener) {
        this(context);
        h.b(context, b.Q);
        h.b(nativeExpressAdListener, "adListener");
        this.mNativeAdListener = nativeExpressAdListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TencentNativeExpressAdProvider(Context context, TencentAdListener.NativeExpressAdListener nativeExpressAdListener, String str) {
        this(context, nativeExpressAdListener);
        h.b(context, b.Q);
        h.b(nativeExpressAdListener, "adListener");
        h.b(str, "unitID");
        this.mUnitId = str;
    }

    public /* synthetic */ TencentNativeExpressAdProvider(Context context, TencentAdListener.NativeExpressAdListener nativeExpressAdListener, String str, int i, f fVar) {
        this(context, nativeExpressAdListener, (i & 4) != 0 ? TencentAdProvider.Companion.getPG_UNIT_ID() : str);
    }
}

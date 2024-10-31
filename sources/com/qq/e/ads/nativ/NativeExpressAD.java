package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class NativeExpressAD extends AbstractAD<NEADI> {
    public static final int EVENT_TYPE_ON_AD_CLICKED = 6;
    public static final int EVENT_TYPE_ON_AD_CLOSED = 7;
    public static final int EVENT_TYPE_ON_AD_CLOSE_OVERLAY = 10;
    public static final int EVENT_TYPE_ON_AD_EXPOSURE = 5;
    public static final int EVENT_TYPE_ON_AD_LEFT_APPLICATION = 8;
    public static final int EVENT_TYPE_ON_AD_LOADED = 2;
    public static final int EVENT_TYPE_ON_AD_OPEN_OVERLAY = 9;
    public static final int EVENT_TYPE_ON_NO_AD = 1;
    public static final int EVENT_TYPE_ON_RENDER_FAILED = 3;
    public static final int EVENT_TYPE_ON_RENDER_SUCCESS = 4;
    public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 16;
    public static final int EVENT_TYPE_ON_VIDEO_ERROR = 17;
    public static final int EVENT_TYPE_ON_VIDEO_INIT = 11;
    public static final int EVENT_TYPE_ON_VIDEO_LOADING = 12;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_CLOSE = 19;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_OPEN = 18;
    public static final int EVENT_TYPE_ON_VIDEO_PAUSE = 15;
    public static final int EVENT_TYPE_ON_VIDEO_READY = 13;
    public static final int EVENT_TYPE_ON_VIDEO_START = 14;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f24882a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f24883b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private VideoOption f24884c;

    /* renamed from: d, reason: collision with root package name */
    private ADSize f24885d;

    /* renamed from: e, reason: collision with root package name */
    private NativeExpressADListener f24886e;

    /* loaded from: classes3.dex */
    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NativeExpressADListener f24887a;

        /* renamed from: b, reason: collision with root package name */
        private NativeExpressMediaListener f24888b;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.f24887a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f24888b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    NativeExpressAD.a(this.f24887a, aDEvent);
                    return;
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    NativeExpressAD.a(this.f24888b, aDEvent);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface NativeExpressADListener extends AbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADCloseOverlay(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onADOpenOverlay(NativeExpressADView nativeExpressADView);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, String str2, NativeExpressADListener nativeExpressADListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || aDSize == null || context == null) {
            GDTLogger.e(String.format("NativeExpressAD Constructor params error, adSize=%s, appid=%s, posId=%s, context=%s", aDSize, str, str2, context));
            a(nativeExpressADListener, 2001);
        } else {
            this.f24885d = aDSize;
            this.f24886e = nativeExpressADListener;
            a(context, str, str2, nativeExpressADListener);
        }
    }

    static /* synthetic */ void a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener == null) {
            GDTLogger.i("No DevADListener Bound");
            return;
        }
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    nativeExpressADListener.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                }
                GDTLogger.e("AdEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 2:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    nativeExpressADListener.onADLoaded((List) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 3:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onRenderFail((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 4:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onRenderSuccess((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 5:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADExposure((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 6:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADClicked((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 7:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADClosed((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 8:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADLeftApplication((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 9:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADOpenOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 10:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressADListener.onADCloseOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        if (nativeExpressMediaListener == null) {
            GDTLogger.i("No media listener");
            return;
        }
        switch (aDEvent.getType()) {
            case 11:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoInit((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 12:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoLoading((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 13:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView) && (aDEvent.getParas()[1] instanceof Integer)) {
                    nativeExpressMediaListener.onVideoReady((NativeExpressADView) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            case 14:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoStart((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 15:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPause((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 16:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoComplete((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 17:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeExpressADView) && (aDEvent.getParas()[1] instanceof Integer)) {
                    nativeExpressMediaListener.onVideoError((NativeExpressADView) aDEvent.getParas()[0], a.a(((Integer) aDEvent.getParas()[1]).intValue()));
                    return;
                } else {
                    GDTLogger.e("Native express media event paras error!");
                    return;
                }
            case 18:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPageOpen((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            case 19:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    nativeExpressMediaListener.onVideoPageClose((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Params error for NativeExpressAD(" + aDEvent + ")");
                return;
            default:
                return;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ NEADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeExpressADDelegate(context, this.f24885d, str, str2, new ADListenerAdapter(this.f24886e));
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ void a(NEADI neadi) {
        neadi.setMaxVideoDuration(this.f24882a);
        VideoOption videoOption = this.f24884c;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        Iterator<Integer> it = this.f24883b.iterator();
        while (it.hasNext()) {
            loadAD(it.next().intValue());
        }
    }

    public void loadAD(int i) {
        if (!c()) {
            GDTLogger.e("AD init Paras OR Context error,details in logs produced while init NativeAD");
            return;
        }
        if (!b()) {
            this.f24883b.add(Integer.valueOf(i));
            return;
        }
        NEADI a2 = a();
        if (a2 != null) {
            a2.loadAd(i);
        } else {
            GDTLogger.e("Native Express AD Init error, see more logs");
        }
    }

    public void setMaxVideoDuration(int i) {
        this.f24882a = i;
        NEADI a2 = a();
        if (a2 != null) {
            a2.setMaxVideoDuration(this.f24882a);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f24884c = videoOption;
        NEADI a2 = a();
        if (a2 == null || videoOption == null) {
            return;
        }
        a2.setVideoOption(videoOption);
    }
}

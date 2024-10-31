package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.NVADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class NativeMediaAD extends AbstractAD<NVADI> {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f24904a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f24905b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private NativeMediaADListener f24906c;

    /* loaded from: classes3.dex */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(NativeMediaAD nativeMediaAD, byte b2) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeMediaAD.this.f24906c == null) {
                GDTLogger.i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        NativeMediaAD.this.f24906c.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    GDTLogger.e("AdEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                    return;
                case 2:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                        NativeMediaAD.this.f24906c.onADLoaded((List) aDEvent.getParas()[0]);
                        return;
                    }
                    GDTLogger.e("ADEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                    return;
                case 3:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        NativeMediaAD.this.f24906c.onADStatusChanged((NativeMediaADData) aDEvent.getParas()[0]);
                        return;
                    }
                    GDTLogger.e("ADEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                    return;
                case 4:
                    if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeADDataRef) && (aDEvent.getParas()[1] instanceof Integer)) {
                        NativeMediaAD.this.f24906c.onADError((NativeMediaADData) aDEvent.getParas()[0], a.a(((Integer) aDEvent.getParas()[1]).intValue()));
                        return;
                    }
                    GDTLogger.e("ADEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                    return;
                case 5:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        NativeMediaAD.this.f24906c.onADVideoLoaded((NativeMediaADData) aDEvent.getParas()[0]);
                        return;
                    }
                    GDTLogger.e("ADEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                    return;
                case 6:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        NativeMediaAD.this.f24906c.onADExposure((NativeMediaADData) aDEvent.getParas()[0]);
                        return;
                    }
                    GDTLogger.e("ADEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                    return;
                case 7:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        NativeMediaAD.this.f24906c.onADClicked((NativeMediaADData) aDEvent.getParas()[0]);
                        return;
                    }
                    GDTLogger.e("ADEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface NativeMediaADListener extends AbstractAD.BasicADListener {
        void onADClicked(NativeMediaADData nativeMediaADData);

        void onADError(NativeMediaADData nativeMediaADData, AdError adError);

        void onADExposure(NativeMediaADData nativeMediaADData);

        void onADLoaded(List<NativeMediaADData> list);

        void onADStatusChanged(NativeMediaADData nativeMediaADData);

        void onADVideoLoaded(NativeMediaADData nativeMediaADData);
    }

    public NativeMediaAD(Context context, String str, String str2, NativeMediaADListener nativeMediaADListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.e(String.format("NativeMediaAD Contructor paras error, appid=%s, posId=%s, context=%s", str, str2, context));
            a(nativeMediaADListener, 2001);
        } else {
            this.f24906c = nativeMediaADListener;
            a(context, str, str2, nativeMediaADListener);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ NVADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeVideoADDelegate(context, str, str2, new ADListenerAdapter(this, (byte) 0));
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ void a(NVADI nvadi) {
        nvadi.setMaxVideoDuration(this.f24904a);
        Iterator<Integer> it = this.f24905b.iterator();
        while (it.hasNext()) {
            loadAD(it.next().intValue());
        }
    }

    public void loadAD(int i) {
        if (!c()) {
            GDTLogger.e("AD init Paras OR Context error, details in logs produced while init NativeMediaAD");
            return;
        }
        if (!b()) {
            this.f24905b.add(Integer.valueOf(i));
            return;
        }
        NVADI a2 = a();
        if (a2 != null) {
            a2.loadAd(i);
        } else {
            GDTLogger.e("NativeMediaAD Init error, See More Logs");
        }
    }

    public void setMaxVideoDuration(int i) {
        this.f24904a = i;
        if (b()) {
            NVADI a2 = a();
            if (a2 != null) {
                a2.setMaxVideoDuration(i);
            } else {
                GDTLogger.e("NativeMediaAD setMaxVideoDuration error, See More Logs");
            }
        }
    }
}

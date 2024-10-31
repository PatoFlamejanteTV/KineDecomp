package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.NADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class NativeAD extends AbstractAD<NADI> {

    /* renamed from: a, reason: collision with root package name */
    private NativeAdListener f24878a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f24879b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<String> f24880c;

    /* loaded from: classes3.dex */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(NativeAD nativeAD, byte b2) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeAD.this.f24878a == null) {
                GDTLogger.i("No DevADListener Binded");
                return;
            }
            int type = aDEvent.getType();
            if (type == 1) {
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    NativeAD.this.f24878a.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                }
                GDTLogger.e("AdEvent.Paras error for NativeAD(" + aDEvent + ")");
                return;
            }
            if (type == 2) {
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    NativeAD.this.f24878a.onADLoaded((List) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Paras error for NativeAD(" + aDEvent + ")");
                return;
            }
            if (type == 3) {
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeADDataRef)) {
                    NativeAD.this.f24878a.onADStatusChanged((NativeADDataRef) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Paras error for NativeAD(" + aDEvent + ")");
                return;
            }
            if (type != 4) {
                return;
            }
            if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeADDataRef) && (aDEvent.getParas()[1] instanceof Integer)) {
                NativeAD.this.f24878a.onADError((NativeADDataRef) aDEvent.getParas()[0], a.a(((Integer) aDEvent.getParas()[1]).intValue()));
                return;
            }
            GDTLogger.e("ADEvent.Paras error for NativeAD(" + aDEvent + ")");
        }
    }

    /* loaded from: classes3.dex */
    public interface NativeAdListener extends AbstractAD.BasicADListener {
        void onADError(NativeADDataRef nativeADDataRef, AdError adError);

        void onADLoaded(List<NativeADDataRef> list);

        void onADStatusChanged(NativeADDataRef nativeADDataRef);
    }

    public NativeAD(Context context, String str, String str2, NativeAdListener nativeAdListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.e(String.format("GDTNativeAd Contructor paras error,appid=%s,posId=%s,context=%s", str, str2, context));
            a(nativeAdListener, 2001);
        } else {
            this.f24878a = nativeAdListener;
            a(context, str, str2, nativeAdListener);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ NADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeADDelegate(context, str, str2, new ADListenerAdapter(this, (byte) 0));
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ void a(NADI nadi) {
        List<String> list = this.f24880c;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.f24879b.iterator();
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
            this.f24879b.add(Integer.valueOf(i));
            return;
        }
        NADI a2 = a();
        if (a2 != null) {
            a2.loadAd(i);
        } else {
            GDTLogger.e("NativeAD Init error,See More Logs");
        }
    }

    public void setCategories(List<String> list) {
        this.f24880c = list;
        NADI a2 = a();
        if (a2 == null || list == null) {
            return;
        }
        a2.setCategories(list);
    }
}

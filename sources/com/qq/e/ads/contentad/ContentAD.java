package com.qq.e.ads.contentad;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.nativ.NativeMediaADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.CAI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ContentAD extends AbstractAD<CAI> {

    /* renamed from: a, reason: collision with root package name */
    private ContentADListener f24817a;

    /* renamed from: b, reason: collision with root package name */
    private List<Map<String, Object>> f24818b = new ArrayList();

    /* loaded from: classes3.dex */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(ContentAD contentAD, byte b2) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (ContentAD.this.f24817a == null) {
                GDTLogger.i("No DevADListener Binded");
                return;
            }
            int type = aDEvent.getType();
            if (type == 1) {
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    ContentAD.this.f24817a.onNoContentAD(((Integer) aDEvent.getParas()[0]).intValue());
                    return;
                }
                GDTLogger.e("AdEvent.Paras error for ContentAD(" + aDEvent + ")");
                return;
            }
            if (type == 2) {
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    ContentAD.this.f24817a.onContentADLoaded((List) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Paras error for ContentAD(" + aDEvent + ")");
                return;
            }
            if (type == 3) {
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                    ContentAD.this.f24817a.onContentADStatusChanged((NativeMediaADData) aDEvent.getParas()[0]);
                    return;
                }
                GDTLogger.e("ADEvent.Paras error for ContentAD(" + aDEvent + ")");
                return;
            }
            if (type == 4) {
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof ContentAdData) && (aDEvent.getParas()[1] instanceof Integer)) {
                    ContentAD.this.f24817a.onContentADError((ContentAdData) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                    return;
                }
                GDTLogger.e("ADEvent.Paras error for ContentAD(" + aDEvent + ")");
                return;
            }
            if (type != 5) {
                return;
            }
            if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                ContentAD.this.f24817a.onADVideoLoaded((NativeMediaADData) aDEvent.getParas()[0]);
                return;
            }
            GDTLogger.e("ADEvent.Paras error for ContentAD(" + aDEvent + ")");
        }
    }

    /* loaded from: classes3.dex */
    private static final class BasicADListenerAdapter implements AbstractAD.BasicADListener {

        /* renamed from: a, reason: collision with root package name */
        private ContentADListener f24820a;

        public BasicADListenerAdapter(ContentADListener contentADListener) {
            this.f24820a = contentADListener;
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public final void onNoAD(AdError adError) {
            this.f24820a.onNoContentAD(adError.getErrorCode());
        }
    }

    /* loaded from: classes3.dex */
    public interface ContentADListener {
        void onADVideoLoaded(ContentAdData contentAdData);

        void onContentADError(ContentAdData contentAdData, int i);

        void onContentADLoaded(List<ContentAdData> list);

        void onContentADStatusChanged(ContentAdData contentAdData);

        void onNoContentAD(int i);
    }

    public ContentAD(Context context, String str, String str2, ContentADListener contentADListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.e(String.format("GDTContentAd Contructor paras error,appid=%s,posId=%s,context=%s", str, str2, context));
            a(new BasicADListenerAdapter(contentADListener), 2001);
        } else {
            this.f24817a = contentADListener;
            a(context, str, str2, new BasicADListenerAdapter(contentADListener));
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ CAI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getContentAdDelegate(context, str, str2, new ADListenerAdapter(this, (byte) 0));
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ void a(CAI cai) {
        for (Map<String, Object> map : this.f24818b) {
            loadAD(((Integer) map.get("page_number")).intValue(), ((Integer) map.get("channel")).intValue(), ((Boolean) map.get("is_manual_operation")).booleanValue());
        }
    }

    public void loadAD(int i, int i2, boolean z) {
        if (!c()) {
            GDTLogger.e("AD init Paras OR Context error,details in logs produced while init ContentAD");
            return;
        }
        if (b()) {
            CAI a2 = a();
            if (a2 != null) {
                a2.loadAd(i, i2, z);
                return;
            } else {
                GDTLogger.e("ContentAD Init error,See More Logs");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("page_number", Integer.valueOf(i));
        hashMap.put("channel", Integer.valueOf(i2));
        hashMap.put("is_manual_operation", Boolean.valueOf(z));
        this.f24818b.add(hashMap);
    }
}

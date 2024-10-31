package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NativeUnifiedAD extends AbstractAD<NUADI> {

    /* renamed from: a, reason: collision with root package name */
    private AdListenerAdapter f24908a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f24909b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<String> f24910c;

    /* renamed from: d, reason: collision with root package name */
    private String f24911d;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f24912e;

    /* loaded from: classes3.dex */
    private static class AdListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NativeADUnifiedListener f24916a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f24916a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.f24916a == null) {
                GDTLogger.i("not bind NativeADUnifiedListener");
                return;
            }
            Object[] paras = aDEvent.getParas();
            int type = aDEvent.getType();
            if (type != 1) {
                if (type == 2 && paras.length == 1 && (paras[0] instanceof Integer)) {
                    this.f24916a.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                }
                return;
            }
            if (paras.length == 1 && (paras[0] instanceof List)) {
                List list = (List) paras[0];
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) it.next()));
                    }
                }
                this.f24916a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        if (context == null || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            GDTLogger.e(String.format("NativeUnifiedAD constructor parameters error, appId=%s, posId=%s, context=%s", str, str2, context));
            a(nativeADUnifiedListener, LicenseErrCode.ERROR_NETWORK_ERROR);
        } else {
            this.f24908a = new AdListenerAdapter(nativeADUnifiedListener);
            this.f24911d = str2;
            a(context, str, str2, nativeADUnifiedListener);
        }
    }

    private void a(int i, boolean z) {
        if (!c()) {
            GDTLogger.e("Parameters or context error, details in init NativeUnifiedAD log");
            return;
        }
        if (!b()) {
            if (z) {
                this.f24909b.add(Integer.valueOf(i));
            }
        } else {
            NUADI a2 = a();
            if (a2 != null) {
                a2.loadData(i);
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ NUADI a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, this.f24908a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public final void a(final AbstractAD.BasicADListener basicADListener, final int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.nativ.NativeUnifiedAD.1
            @Override // java.lang.Runnable
            public void run() {
                NativeUnifiedAD.super.a(basicADListener, i);
            }
        });
    }

    @Override // com.qq.e.ads.AbstractAD
    protected final /* synthetic */ void a(NUADI nuadi) {
        nuadi.setMaxVideoDuration(this.f24912e);
        List<String> list = this.f24910c;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.f24909b.iterator();
        while (it.hasNext()) {
            a(it.next().intValue(), false);
        }
    }

    public void loadData(int i) {
        a(i, true);
    }

    public void setCategories(List<String> list) {
        this.f24910c = list;
        NUADI a2 = a();
        if (a2 == null || list == null) {
            return;
        }
        a2.setCategories(list);
    }

    public void setMaxVideoDuration(int i) {
        this.f24912e = i;
        NUADI a2 = a();
        if (a2 != null) {
            a2.setMaxVideoDuration(this.f24912e);
        }
    }

    public void setTag(Map map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), this.f24911d);
        } catch (Exception e2) {
            GDTLogger.e("NativeUnifiedAD#setTag Exception");
            e2.printStackTrace();
        }
    }
}

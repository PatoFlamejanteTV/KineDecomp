package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

/* loaded from: classes3.dex */
public class GDTAD {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f24807a = false;

    /* renamed from: b, reason: collision with root package name */
    private static InitListener f24808b;

    /* renamed from: c, reason: collision with root package name */
    private static PM.a.InterfaceC0127a f24809c = new PM.a.InterfaceC0127a() { // from class: com.qq.e.ads.cfg.GDTAD.1
        @Override // com.qq.e.comm.managers.plugin.PM.a.InterfaceC0127a
        public final void onLoadFail() {
            GDTLogger.w("Init fail", null);
        }

        @Override // com.qq.e.comm.managers.plugin.PM.a.InterfaceC0127a
        public final void onLoadSuccess() {
            GDTAD.a(true);
            if (GDTAD.f24808b != null) {
                GDTAD.f24808b.onSuccess();
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface InitListener {
        void onSuccess();
    }

    static /* synthetic */ boolean a(boolean z) {
        f24807a = true;
        return true;
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (f24807a) {
            GDTLogger.w("SDK已经被初始化过", null);
            return;
        }
        if (context == null) {
            GDTLogger.e("Context参数不能为null");
            return;
        }
        if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId参数不能为空");
            return;
        }
        f24808b = initListener;
        GDTADManager gDTADManager = GDTADManager.getInstance();
        gDTADManager.setPluginLoadListener(f24809c);
        gDTADManager.initWith(context.getApplicationContext(), str);
    }
}

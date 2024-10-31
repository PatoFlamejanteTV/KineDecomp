package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NativeExpressADView extends FrameLayout {

    /* renamed from: a */
    private NEADVI f24889a;

    /* renamed from: b */
    private boolean f24890b;

    /* renamed from: c */
    private volatile boolean f24891c;

    /* renamed from: d */
    private NativeExpressMediaListener f24892d;

    /* renamed from: e */
    private AdData f24893e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.ads.nativ.NativeExpressADView$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f24894a;

        /* renamed from: b */
        final /* synthetic */ String f24895b;

        /* renamed from: c */
        final /* synthetic */ NEADI f24896c;

        /* renamed from: d */
        final /* synthetic */ ADSize f24897d;

        /* renamed from: e */
        final /* synthetic */ String f24898e;

        /* renamed from: f */
        final /* synthetic */ JSONObject f24899f;

        /* renamed from: g */
        final /* synthetic */ HashMap f24900g;

        /* renamed from: com.qq.e.ads.nativ.NativeExpressADView$1$1 */
        /* loaded from: classes3.dex */
        class RunnableC01251 implements Runnable {

            /* renamed from: a */
            private /* synthetic */ POFactory f24902a;

            RunnableC01251(POFactory pOFactory) {
                pOFactory = pOFactory;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        if (pOFactory != null) {
                            NativeExpressADView.this.f24889a = pOFactory.getNativeExpressADView(neadi, context, NativeExpressADView.this, aDSize, str, str2, jSONObject, hashMap);
                            NativeExpressADView.a(NativeExpressADView.this, true);
                            if (NativeExpressADView.this.f24892d != null) {
                                NativeExpressADView.this.setMediaListener(NativeExpressADView.this.f24892d);
                            }
                            if (NativeExpressADView.this.f24891c) {
                                NativeExpressADView.this.render();
                            }
                        }
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init Native Express AD View Core", th);
                    }
                } finally {
                    NativeExpressADView.a(NativeExpressADView.this, true);
                }
            }
        }

        AnonymousClass1(Context context, String str, NEADI neadi, ADSize aDSize, String str2, JSONObject jSONObject, HashMap hashMap) {
            context = context;
            str = str;
            neadi = neadi;
            aDSize = aDSize;
            str2 = str2;
            jSONObject = jSONObject;
            hashMap = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!GDTADManager.getInstance().initWith(context, str)) {
                GDTLogger.e("Fail to init ADManager");
                return;
            }
            try {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.nativ.NativeExpressADView.1.1

                    /* renamed from: a */
                    private /* synthetic */ POFactory f24902a;

                    RunnableC01251(POFactory pOFactory) {
                        pOFactory = pOFactory;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            try {
                                if (pOFactory != null) {
                                    NativeExpressADView.this.f24889a = pOFactory.getNativeExpressADView(neadi, context, NativeExpressADView.this, aDSize, str, str2, jSONObject, hashMap);
                                    NativeExpressADView.a(NativeExpressADView.this, true);
                                    if (NativeExpressADView.this.f24892d != null) {
                                        NativeExpressADView.this.setMediaListener(NativeExpressADView.this.f24892d);
                                    }
                                    if (NativeExpressADView.this.f24891c) {
                                        NativeExpressADView.this.render();
                                    }
                                }
                            } catch (Throwable th) {
                                GDTLogger.e("Exception while init Native Express AD View Core", th);
                            }
                        } finally {
                            NativeExpressADView.a(NativeExpressADView.this, true);
                        }
                    }
                });
            } catch (Throwable th) {
                GDTLogger.e("Exception while init Native Express AD View plugin", th);
            }
        }
    }

    public NativeExpressADView(NEADI neadi, Context context, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, JSONObject> hashMap) {
        super(context);
        this.f24890b = false;
        this.f24891c = false;
        this.f24893e = a(hashMap);
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.nativ.NativeExpressADView.1

            /* renamed from: a */
            final /* synthetic */ Context f24894a;

            /* renamed from: b */
            final /* synthetic */ String f24895b;

            /* renamed from: c */
            final /* synthetic */ NEADI f24896c;

            /* renamed from: d */
            final /* synthetic */ ADSize f24897d;

            /* renamed from: e */
            final /* synthetic */ String f24898e;

            /* renamed from: f */
            final /* synthetic */ JSONObject f24899f;

            /* renamed from: g */
            final /* synthetic */ HashMap f24900g;

            /* renamed from: com.qq.e.ads.nativ.NativeExpressADView$1$1 */
            /* loaded from: classes3.dex */
            class RunnableC01251 implements Runnable {

                /* renamed from: a */
                private /* synthetic */ POFactory f24902a;

                RunnableC01251(POFactory pOFactory) {
                    pOFactory = pOFactory;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (pOFactory != null) {
                                NativeExpressADView.this.f24889a = pOFactory.getNativeExpressADView(neadi, context, NativeExpressADView.this, aDSize, str, str2, jSONObject, hashMap);
                                NativeExpressADView.a(NativeExpressADView.this, true);
                                if (NativeExpressADView.this.f24892d != null) {
                                    NativeExpressADView.this.setMediaListener(NativeExpressADView.this.f24892d);
                                }
                                if (NativeExpressADView.this.f24891c) {
                                    NativeExpressADView.this.render();
                                }
                            }
                        } catch (Throwable th) {
                            GDTLogger.e("Exception while init Native Express AD View Core", th);
                        }
                    } finally {
                        NativeExpressADView.a(NativeExpressADView.this, true);
                    }
                }
            }

            AnonymousClass1(Context context2, String str3, NEADI neadi2, ADSize aDSize2, String str22, JSONObject jSONObject2, HashMap hashMap2) {
                context = context2;
                str = str3;
                neadi = neadi2;
                aDSize = aDSize2;
                str2 = str22;
                jSONObject = jSONObject2;
                hashMap = hashMap2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!GDTADManager.getInstance().initWith(context, str)) {
                    GDTLogger.e("Fail to init ADManager");
                    return;
                }
                try {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.nativ.NativeExpressADView.1.1

                        /* renamed from: a */
                        private /* synthetic */ POFactory f24902a;

                        RunnableC01251(POFactory pOFactory) {
                            pOFactory = pOFactory;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                try {
                                    if (pOFactory != null) {
                                        NativeExpressADView.this.f24889a = pOFactory.getNativeExpressADView(neadi, context, NativeExpressADView.this, aDSize, str, str2, jSONObject, hashMap);
                                        NativeExpressADView.a(NativeExpressADView.this, true);
                                        if (NativeExpressADView.this.f24892d != null) {
                                            NativeExpressADView.this.setMediaListener(NativeExpressADView.this.f24892d);
                                        }
                                        if (NativeExpressADView.this.f24891c) {
                                            NativeExpressADView.this.render();
                                        }
                                    }
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init Native Express AD View Core", th);
                                }
                            } finally {
                                NativeExpressADView.a(NativeExpressADView.this, true);
                            }
                        }
                    });
                } catch (Throwable th) {
                    GDTLogger.e("Exception while init Native Express AD View plugin", th);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.qq.e.comm.pi.AdData a(java.util.HashMap<java.lang.String, org.json.JSONObject> r2) {
        /*
            java.lang.String r0 = "adinfo"
            r1 = 0
            if (r2 == 0) goto Lc
            java.lang.Object r2 = r2.get(r0)     // Catch: org.json.JSONException -> L14
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch: org.json.JSONException -> L14
            goto Ld
        Lc:
            r2 = r1
        Ld:
            if (r2 == 0) goto L14
            java.lang.Object r2 = r2.get(r0)     // Catch: org.json.JSONException -> L14
            goto L15
        L14:
            r2 = r1
        L15:
            boolean r0 = r2 instanceof com.qq.e.comm.pi.AdData
            if (r0 == 0) goto L1c
            com.qq.e.comm.pi.AdData r2 = (com.qq.e.comm.pi.AdData) r2
            return r2
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.ads.nativ.NativeExpressADView.a(java.util.HashMap):com.qq.e.comm.pi.AdData");
    }

    static /* synthetic */ boolean a(NativeExpressADView nativeExpressADView, boolean z) {
        nativeExpressADView.f24890b = true;
        return true;
    }

    public void destroy() {
        NEADVI neadvi = this.f24889a;
        if (neadvi != null) {
            neadvi.destroy();
        }
    }

    public AdData getBoundData() {
        return this.f24893e;
    }

    public void render() {
        if (!this.f24890b) {
            this.f24891c = true;
            return;
        }
        NEADVI neadvi = this.f24889a;
        if (neadvi != null) {
            neadvi.render();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void setAdSize(ADSize aDSize) {
        NEADVI neadvi = this.f24889a;
        if (neadvi != null) {
            neadvi.setAdSize(aDSize);
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        this.f24892d = nativeExpressMediaListener;
        NEADVI neadvi = this.f24889a;
        if (neadvi == null || nativeExpressMediaListener == null) {
            return;
        }
        neadvi.setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
    }
}

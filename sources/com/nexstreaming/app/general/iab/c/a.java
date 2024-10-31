package com.nexstreaming.app.general.iab.c;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.nexstreaming.app.general.iab.BuyResult;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.InAppPurchaseData;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpOrderListResponse;
import com.nexstreaming.app.general.tracelog.ResponseCode;
import com.xiaomi.gamecenter.sdk.MiCommplatform;
import com.xiaomi.gamecenter.sdk.MiErrorCode;
import com.xiaomi.gamecenter.sdk.OnLoginProcessListener;
import com.xiaomi.gamecenter.sdk.entry.MiAccountInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
public class a extends IABHelper {
    private static MiAccountInfo m = null;
    private static boolean n = false;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private MiAccountInfo o;
    private Comparator<Purchase> p;
    private boolean q;
    private C0064a r;

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String q() {
        return "XiaoMi Store";
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String r() {
        return "Xiaomi";
    }

    public a(Context context, String str) {
        super(context, str);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = null;
        this.p = null;
        this.q = false;
        this.r = new C0064a(this, null);
        this.p = new b(this);
        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("MiIABHelper must has context of Activity");
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(IABHelper.e eVar) {
        this.r.b = eVar;
        if (this.o == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(k());
            long j = defaultSharedPreferences.getLong("xiaid", 0L);
            String g = g(defaultSharedPreferences.getString("xiasession", null));
            String g2 = g(defaultSharedPreferences.getString("xianickname", null));
            if (j > 0 && !TextUtils.isEmpty(g) && !TextUtils.isEmpty(g2)) {
                this.o = new MiAccountInfo(j, g, g2);
            }
        }
        if (this.o == null) {
            if (m()) {
                if (!n) {
                    MiCommplatform.getInstance().miLogin((Activity) k(), this.r);
                    n = true;
                    return;
                } else {
                    this.r.finishLoginProcess(-12, this.o);
                    return;
                }
            }
            this.r.finishLoginProcess(MiErrorCode.MI_XIAOMI_ERROR_NETWORK_ERROR, this.o);
            return;
        }
        this.r.finishLoginProcess(0, this.o);
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a() {
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public boolean b() {
        return this.o != null;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(IABHelper.d dVar) {
        com.nexstreaming.kinemaster.tracelog.d.a(k(), r(), this.o.getUid()).onResultAvailable(new d(this, dVar)).onFailure((Task.OnFailListener) new c(this, dVar));
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(IABHelper.c cVar) {
        if (o().get(IABHelper.SKUType.xiaomi) == null) {
            Log.i("MiIABHelper", "loadPurchaseInventory() called with: inventory is empty. try to create");
            o().put(IABHelper.SKUType.xiaomi, new ArrayList());
        }
        if (this.o != null) {
            com.nexstreaming.kinemaster.tracelog.d.a(k(), r(), this.o.getUid(), this.q).onResultAvailable(new f(this, cVar)).onFailure((Task.OnFailListener) new e(this, cVar));
        } else {
            cVar.b(IABError.StartupError, "Login error");
            Log.i("MiIABHelper", "loadPurchaseInventory -> did not login");
        }
    }

    /* compiled from: MiIABHelper.java */
    /* renamed from: com.nexstreaming.app.general.iab.c.a$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3167a = new int[ResponseCode.values().length];

        static {
            try {
                f3167a[ResponseCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3167a[ResponseCode.NOT_FOUND_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(SKUDetails sKUDetails, IABHelper.DeveloperPayLoad developerPayLoad, int i, IABHelper.a aVar) {
        if (m == null) {
            this.o = null;
            PreferenceManager.getDefaultSharedPreferences(k()).edit().putLong("xiaid", 0L).commit();
            a(new g(this, sKUDetails, developerPayLoad, i, aVar));
            return;
        }
        a(m, sKUDetails, developerPayLoad, i, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void j() {
        m = null;
        this.o = null;
        PreferenceManager.getDefaultSharedPreferences(k()).edit().putLong("xiaid", 0L).commit();
        n = false;
        this.q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MiAccountInfo miAccountInfo, SKUDetails sKUDetails, IABHelper.DeveloperPayLoad developerPayLoad, int i, IABHelper.a aVar) {
        if (miAccountInfo != null) {
            if (sKUDetails != null && sKUDetails.g() > 0) {
                BuyResult buyResult = new BuyResult();
                buyResult.a(1);
                aVar.a(buyResult);
                com.nexstreaming.kinemaster.tracelog.d.a(k(), r(), s(), miAccountInfo.getUid(), sKUDetails.g()).onResultAvailable(new i(this, sKUDetails, developerPayLoad, aVar)).onFailure((Task.OnFailListener) new h(this, aVar));
                return;
            }
            aVar.a(false, null, IABError.BuyError + "invalid sku infomation");
            return;
        }
        aVar.a(false, null, IABError.StartupError + "service disconnected");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005e, code lost:            r1.add(r3);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.nexstreaming.app.general.iab.SKUDetails> a(java.util.List<com.nexstreaming.app.general.iab.Product> r7) {
        /*
            r6 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r7.iterator()
        L9:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L7a
            java.lang.Object r0 = r2.next()
            com.nexstreaming.app.general.iab.Product r0 = (com.nexstreaming.app.general.iab.Product) r0
            java.lang.String r3 = r0.product_code
            boolean r3 = r6.a(r3)
            if (r3 != 0) goto L25
            java.lang.String r3 = r0.product_code
            boolean r3 = r6.b(r3)
            if (r3 == 0) goto L9
        L25:
            com.nexstreaming.app.general.iab.SKUDetails r3 = new com.nexstreaming.app.general.iab.SKUDetails
            r3.<init>()
            java.lang.String r4 = r0.product_code
            r3.a(r4)
            int r4 = r0.display
            r3.d(r4)
            int r4 = r0.idx
            r3.a(r4)
            java.lang.String r4 = r0.product_name
            r3.d(r4)
            java.lang.String r0 = r0.payfee
            r3.c(r0)
            com.nexstreaming.app.general.iab.IABHelper$SKUType r0 = com.nexstreaming.app.general.iab.IABHelper.SKUType.xiaomi
            java.lang.String r0 = r0.name()
            r3.b(r0)
            r6.a(r3)
            boolean r0 = r6.c(r3)
            java.lang.String r4 = r3.a()
            int r5 = r3.j()
            switch(r5) {
                case 1: goto L62;
                case 2: goto L6a;
                case 3: goto L72;
                default: goto L5e;
            }
        L5e:
            r1.add(r3)
            goto L9
        L62:
            if (r0 == 0) goto L67
            r6.j = r4
            goto L5e
        L67:
            r6.g = r4
            goto L5e
        L6a:
            if (r0 == 0) goto L6f
            r6.k = r4
            goto L5e
        L6f:
            r6.h = r4
            goto L5e
        L72:
            if (r0 == 0) goto L77
            r6.l = r4
            goto L5e
        L77:
            r6.i = r4
            goto L5e
        L7a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.iab.c.a.a(java.util.List):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Purchase> a(List<CpOrderListResponse.OrderList> list, long j) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CpOrderListResponse.OrderList orderList : list) {
            Purchase purchase = new Purchase();
            InAppPurchaseData inAppPurchaseData = new InAppPurchaseData();
            inAppPurchaseData.b(k().getPackageName());
            inAppPurchaseData.a(orderList.orderid);
            inAppPurchaseData.c(orderList.productcode);
            try {
                inAppPurchaseData.f(orderList.cp_user_info);
            } catch (Exception e) {
                e.printStackTrace();
            }
            inAppPurchaseData.e(String.valueOf(Purchase.PurchaseState.Purchased.ordinal()));
            inAppPurchaseData.d(String.valueOf(String.valueOf(orderList.paytime).length() <= 10 ? orderList.paytime * 1000 : orderList.paytime));
            purchase.a(new Date(String.valueOf(orderList.paytime).length() <= 10 ? orderList.paytime * 1000 : orderList.paytime));
            purchase.a(p());
            purchase.a(inAppPurchaseData);
            purchase.a(orderList.productcode);
            arrayList.add(purchase);
        }
        Collections.sort(arrayList, this.p);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MiIABHelper.java */
    /* renamed from: com.nexstreaming.app.general.iab.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0064a implements OnLoginProcessListener {
        private IABHelper.e b;

        private C0064a() {
            this.b = null;
        }

        /* synthetic */ C0064a(a aVar, b bVar) {
            this();
        }

        @Override // com.xiaomi.gamecenter.sdk.OnLoginProcessListener
        public void finishLoginProcess(int i, MiAccountInfo miAccountInfo) {
            switch (i) {
                case -18006:
                    Log.e("MiIABHelper", IABError.StartupError + " fail login to Xiaomi game center service");
                    this.b.a(false, i);
                    return;
                case 0:
                    if (a.this.o == null) {
                        a.this.o = miAccountInfo;
                        MiAccountInfo unused = a.m = miAccountInfo;
                        boolean unused2 = a.n = false;
                        com.nexstreaming.kinemaster.tracelog.d.a(a.this.k(), a.this.r(), a.this.o.getUid(), a.this.o.getSessionId()).onResultAvailable(new l(this, miAccountInfo, i));
                        return;
                    }
                    this.b.a(true, 0);
                    return;
                default:
                    this.b.a(false, i);
                    Log.e("MiIABHelper", IABError.StartupError + " Xiaomi game center service failure");
                    return;
            }
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String c() {
        return this.g;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String d() {
        return this.h;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String e() {
        return this.i;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String f() {
        return this.j;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String g() {
        return this.k;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String h() {
        return this.l;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String t() {
        return this.o == null ? super.t() : String.valueOf(this.o.getUid());
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public boolean u() {
        String valueOf = this.o != null ? String.valueOf(this.o.getUid()) : "";
        boolean z = com.nexstreaming.app.general.tracelog.f.a(k(), r(), valueOf).f() != null;
        Log.d("MiIABHelper", "hasCachedPurchaseInfo() returned: " + valueOf + " = " + z);
        return z;
    }
}

package com.nexstreaming.app.general.iab.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import com.nexstreaming.app.general.iab.BuyResult;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.InAppPurchaseData;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpLoginInfoResponse;
import com.nexstreaming.app.general.tracelog.CpOrderListResponse;
import com.nexstreaming.app.general.tracelog.ResponseCode;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.xiaomi.gamecenter.sdk.MiErrorCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* compiled from: WxIABHelper.java */
/* loaded from: classes.dex */
public class a extends IABHelper {
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private WXAccessToken m;
    private Comparator<Purchase> n;
    private IWXAPI o;
    private IABHelper.e p;
    private IABHelper.a q;
    private boolean r;
    private IntentFilter s;
    private BroadcastReceiver t;

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String q() {
        return "WeChat Pay";
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String r() {
        return "Wechat";
    }

    public a(Context context, String str) {
        super(context, str);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = false;
        this.s = null;
        this.t = new j(this);
        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("MiIABHelper must has context of Activity");
        }
        this.n = new b(this);
        this.s = new IntentFilter("com.nexstreaming.app.kinemasterfree.wxpay.result");
        this.s.addAction("com.nexstreaming.app.kinemasterfree.wechat.login.completed");
        this.s.addAction("com.nexstreaming.app.kinemasterfree.wechat.login.canceld");
        this.o = KMUsage.getWXAPIInstance(k());
        k().registerReceiver(this.t, this.s);
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(IABHelper.e eVar) {
        this.m = com.nexstreaming.app.kinemasterfree.wxapi.b.a().e();
        this.p = eVar;
        if (this.m != null) {
            C0063a c0063a = new C0063a(eVar);
            if (!this.m.f()) {
                Log.i("WxIABHelper", "startUp() called with: l = [ token is not expired]");
                this.p.a(true, -104);
                return;
            } else {
                Log.i("WxIABHelper", "startUp() called with: l = [ token is expired]");
                com.nexstreaming.app.kinemasterfree.wxapi.b.a().a(this.m, new c(this, c0063a));
                return;
            }
        }
        if (m()) {
            if (com.nexstreaming.app.kinemasterfree.wxapi.b.a().b()) {
                this.p.a(false, -12);
                return;
            }
            return;
        }
        this.p.a(false, MiErrorCode.MI_XIAOMI_ERROR_NETWORK_ERROR);
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void d(IABHelper.e eVar) {
        com.nexstreaming.app.kinemasterfree.wxapi.b.a().f();
        super.d(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void j() {
        super.j();
        com.nexstreaming.app.kinemasterfree.wxapi.b.a().c();
        this.m = null;
        this.r = true;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a() {
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void i() {
        super.i();
        if (k() != null && this.t != null) {
            k().unregisterReceiver(this.t);
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public boolean b() {
        return this.m != null;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(IABHelper.d dVar) {
        com.nexstreaming.kinemaster.tracelog.d.b(k(), r(), this.m.d()).onResultAvailable(new e(this, dVar)).onFailure((Task.OnFailListener) new d(this, dVar));
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(IABHelper.c cVar) {
        if (o().get(IABHelper.SKUType.wechat) == null) {
            Log.i("WxIABHelper", "loadPurchaseInventory() called with: inventory is empty. try to create");
            o().put(IABHelper.SKUType.wechat, new ArrayList());
        }
        if (this.m != null) {
            com.nexstreaming.kinemaster.tracelog.d.a(k(), r(), this.m.d(), this.r).onResultAvailable(new g(this, cVar)).onFailure((Task.OnFailListener) new f(this, cVar));
        } else {
            cVar.b(IABError.RemoteServiceError, "Wechat account connection error");
        }
    }

    /* compiled from: WxIABHelper.java */
    /* renamed from: com.nexstreaming.app.general.iab.b.a$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3156a = new int[ResponseCode.values().length];

        static {
            try {
                f3156a[ResponseCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3156a[ResponseCode.NOT_FOUND_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(SKUDetails sKUDetails, IABHelper.DeveloperPayLoad developerPayLoad, int i, IABHelper.a aVar) {
        this.q = aVar;
        if (this.m != null) {
            if (sKUDetails != null && sKUDetails.g() > 0) {
                BuyResult buyResult = new BuyResult();
                buyResult.a(3);
                aVar.a(buyResult);
                com.nexstreaming.kinemaster.tracelog.d.a(k(), r(), s(), this.m.d(), sKUDetails.g(), l().toJson(developerPayLoad)).onResultAvailable(new i(this, sKUDetails, developerPayLoad, aVar)).onFailure((Task.OnFailListener) new h(this, aVar));
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
            com.nexstreaming.app.general.iab.IABHelper$SKUType r0 = com.nexstreaming.app.general.iab.IABHelper.SKUType.wechat
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
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.iab.b.a.a(java.util.List):java.util.List");
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
            inAppPurchaseData.e(String.valueOf(Purchase.PurchaseState.Purchased.ordinal()));
            try {
                inAppPurchaseData.f(orderList.cp_user_info);
            } catch (Exception e) {
                e.printStackTrace();
            }
            inAppPurchaseData.d(String.valueOf(String.valueOf(orderList.paytime).length() <= 10 ? orderList.paytime * 1000 : orderList.paytime));
            purchase.a(new Date(String.valueOf(orderList.paytime).length() <= 10 ? orderList.paytime * 1000 : orderList.paytime));
            purchase.a(p());
            purchase.a(inAppPurchaseData);
            purchase.a(orderList.productcode);
            arrayList.add(purchase);
        }
        Collections.sort(arrayList, this.n);
        return arrayList;
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
        return this.m == null ? super.t() : this.m.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WxIABHelper.java */
    /* renamed from: com.nexstreaming.app.general.iab.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0063a implements ResultTask.OnResultAvailableListener<CpLoginInfoResponse>, Task.OnFailListener {

        /* renamed from: a, reason: collision with root package name */
        IABHelper.e f3157a;
        int b = 0;

        public C0063a(IABHelper.e eVar) {
            this.f3157a = null;
            this.f3157a = eVar;
        }

        @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultAvailable(ResultTask<CpLoginInfoResponse> resultTask, Task.Event event, CpLoginInfoResponse cpLoginInfoResponse) {
            Log.i("WxIABHelper", "onResultAvailable() called with: Nex Login Completed");
            if (this.f3157a != null) {
                this.f3157a.a(true, -104);
            }
        }

        @Override // com.nexstreaming.app.general.task.Task.OnFailListener
        public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
            Log.i("WxIABHelper", "onResultAvailable() called with: Nex Login Failed");
            if (3 > this.b && a.this.m != null) {
                this.b++;
                com.nexstreaming.kinemaster.tracelog.d.a(a.this.k(), a.this.r().toLowerCase(), a.this.m.d(), "").onResultAvailable(this).onFailure((Task.OnFailListener) this);
            } else if (this.f3157a != null) {
                this.f3157a.a(false, MiErrorCode.MI_XIAOMI_ERROR_NETWORK_ERROR);
            }
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public boolean u() {
        String d = this.m != null ? this.m.d() : "";
        boolean z = com.nexstreaming.app.general.tracelog.f.a(k(), s(), d).f() != null;
        Log.d("WxIABHelper", "hasCachedPurchaseInfo() returned: " + d + " = " + z);
        return z;
    }
}

package com.nexstreaming.app.general.iab.Presenter;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.nexstreaming.app.general.iab.DeveloperPayLoad;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.InAppPurchaseData;
import com.nexstreaming.app.general.iab.Product;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpLoginInfoResponse;
import com.nexstreaming.app.general.tracelog.CpOrderListResponse;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;
import com.qq.e.comm.constants.Constants;
import com.tencent.mm.sdk.openapi.IWXAPI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.TypeCastException;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class B extends IABBasePresent {
    private com.nexstreaming.app.general.iab.a j;
    private final int k;
    private Comparator<Purchase> l;
    private IWXAPI m;
    private boolean n;
    private IntentFilter o;
    private ResultTask<Boolean> p;
    private WXAccessToken q;
    private boolean r;
    private String s;
    private String t;
    private String u;
    private boolean v;
    private final BroadcastReceiver w;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IABWxPresent.kt */
    /* loaded from: classes2.dex */
    public final class a implements ResultTask.OnResultAvailableListener<CpLoginInfoResponse>, Task.OnFailListener {

        /* renamed from: a, reason: collision with root package name */
        private IABManager f19325a;

        /* renamed from: b, reason: collision with root package name */
        private int f19326b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ B f19327c;

        public a(B b2, IABManager iABManager) {
            kotlin.jvm.internal.h.b(iABManager, Constants.LANDSCAPE);
            this.f19327c = b2;
            this.f19325a = iABManager;
        }

        @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultAvailable(ResultTask<CpLoginInfoResponse> resultTask, Task.Event event, CpLoginInfoResponse cpLoginInfoResponse) {
            kotlin.jvm.internal.h.b(resultTask, "task");
            kotlin.jvm.internal.h.b(event, NotificationCompat.CATEGORY_EVENT);
            kotlin.jvm.internal.h.b(cpLoginInfoResponse, "result");
            IABManager iABManager = this.f19325a;
            if (iABManager != null) {
                iABManager.a(true, IABError.NoError.ordinal());
            }
        }

        @Override // com.nexstreaming.app.general.task.Task.OnFailListener
        public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
            kotlin.jvm.internal.h.b(task, com.umeng.commonsdk.proguard.e.ar);
            kotlin.jvm.internal.h.b(event, "e");
            kotlin.jvm.internal.h.b(taskError, "failureReason");
            if (this.f19327c.k > this.f19326b && this.f19327c.q != null) {
                this.f19326b++;
                Context f2 = this.f19327c.f();
                String c2 = this.f19327c.c();
                Locale locale = Locale.ENGLISH;
                kotlin.jvm.internal.h.a((Object) locale, "Locale.ENGLISH");
                if (c2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = c2.toLowerCase(locale);
                kotlin.jvm.internal.h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                WXAccessToken wXAccessToken = this.f19327c.q;
                if (wXAccessToken != null) {
                    com.nexstreaming.kinemaster.tracelog.f.a(f2, lowerCase, wXAccessToken.c(), "").onResultAvailable(this).onFailure((Task.OnFailListener) this);
                    return;
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            IABManager iABManager = this.f19325a;
            if (iABManager != null) {
                iABManager.a(false, IABError.NetworkError.ordinal());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(Context context, String str, IABManager iABManager) {
        super(context, str, iABManager);
        kotlin.jvm.internal.h.b(context, "ctx");
        kotlin.jvm.internal.h.b(str, "marketId");
        kotlin.jvm.internal.h.b(iABManager, "iabManager");
        this.j = com.nexstreaming.app.general.iab.a.f19428c;
        this.k = 3;
        this.r = true;
        this.w = new E(this, iABManager);
        this.l = C1696z.f19415a;
        IntentFilter intentFilter = new IntentFilter("com.nexstreaming.app.kinemasterfree.wxpay.result");
        intentFilter.addAction("com.nexstreaming.app.kinemasterfree.wechat.login.completed");
        intentFilter.addAction("com.nexstreaming.app.kinemasterfree.wechat.login.canceld");
        this.o = intentFilter;
        this.m = com.nexstreaming.app.kinemasterfree.wxapi.e.b(context);
        com.nexstreaming.app.kinemasterfree.wxapi.e c2 = com.nexstreaming.app.kinemasterfree.wxapi.e.c();
        kotlin.jvm.internal.h.a((Object) c2, "WXApiManager.getInstance()");
        this.q = c2.d();
        context.registerReceiver(this.w, this.o);
        this.v = true;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public void A() {
        x();
        i().b(true);
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.a> B() {
        io.reactivex.m<com.nexstreaming.app.general.iab.b.a> a2 = io.reactivex.m.a((io.reactivex.o) new ga(this));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …}\n            }\n        }");
        return a2;
    }

    public final void C() {
        IntentFilter intentFilter;
        try {
            f().unregisterReceiver(this.w);
            intentFilter = new IntentFilter("com.nexstreaming.app.kinemasterfree.wxpay.result");
        } catch (IllegalArgumentException unused) {
            intentFilter = new IntentFilter("com.nexstreaming.app.kinemasterfree.wxpay.result");
        } catch (Exception unused2) {
            intentFilter = new IntentFilter("com.nexstreaming.app.kinemasterfree.wxpay.result");
        } catch (Throwable th) {
            IntentFilter intentFilter2 = new IntentFilter("com.nexstreaming.app.kinemasterfree.wxpay.result");
            intentFilter2.addAction("com.nexstreaming.app.kinemasterfree.wechat.login.completed");
            intentFilter2.addAction("com.nexstreaming.app.kinemasterfree.wechat.login.canceld");
            this.o = intentFilter2;
            f().registerReceiver(this.w, this.o);
            throw th;
        }
        intentFilter.addAction("com.nexstreaming.app.kinemasterfree.wechat.login.completed");
        intentFilter.addAction("com.nexstreaming.app.kinemasterfree.wechat.login.canceld");
        this.o = intentFilter;
        f().registerReceiver(this.w, this.o);
    }

    public final boolean D() {
        IWXAPI iwxapi = this.m;
        if (iwxapi != null) {
            if (iwxapi == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (iwxapi.isWXAppInstalled()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean E() {
        return c.d.b.m.i.f(f());
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public int a(int i) {
        return 0;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public void a() {
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public String c() {
        return "Wechat";
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public String g() {
        return this.s;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public LinkedHashMap<IABConstant.SKUType, List<Purchase>> l() {
        return this.j.a();
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public String m() {
        return this.t;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n() {
        return this.j.b();
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public String p() {
        return this.u;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public boolean r() {
        WXAccessToken wXAccessToken = this.q;
        com.nexstreaming.app.general.tracelog.j a2 = com.nexstreaming.app.general.tracelog.j.a(f(), k(), wXAccessToken != null ? wXAccessToken != null ? wXAccessToken.c() : null : "");
        kotlin.jvm.internal.h.a((Object) a2, "CpOrderList.getInstance(context, marketId, id)");
        return a2.c() != null;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public boolean s() {
        return this.q != null;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.c> t() {
        io.reactivex.m<com.nexstreaming.app.general.iab.b.c> a2 = io.reactivex.m.a((io.reactivex.o) new U(this));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …)\n            }\n        }");
        return a2;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.d> u() {
        io.reactivex.m<com.nexstreaming.app.general.iab.b.d> a2 = io.reactivex.m.a((io.reactivex.o) new Y(this));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …)\n            }\n        }");
        return a2;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public void v() {
        if (f() != null && this.w != null && this.v) {
            f().unregisterReceiver(this.w);
            this.v = false;
        }
        e().a();
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public void w() {
        com.nexstreaming.app.kinemasterfree.wxapi.e.c().b();
        x();
        i().b(true);
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public void x() {
        a("subs", (Purchase) null, 0L);
        a("one", (Purchase) null, 0L);
        com.nexstreaming.app.kinemasterfree.wxapi.e.c().a();
        this.q = null;
        this.r = true;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public ResultTask<Boolean> y() {
        this.p = b(true);
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(SKUDetails sKUDetails) {
        boolean a2;
        boolean a3;
        boolean a4;
        boolean a5;
        boolean a6;
        boolean a7;
        boolean a8;
        String g2 = sKUDetails.g();
        if (g2 != null) {
            a2 = kotlin.text.w.a((CharSequence) g2, (CharSequence) IABConstant.o.g()[0], false, 2, (Object) null);
            if (!a2) {
                a6 = kotlin.text.w.a((CharSequence) g2, (CharSequence) IABConstant.o.g()[1], false, 2, (Object) null);
                if (!a6) {
                    a7 = kotlin.text.w.a((CharSequence) g2, (CharSequence) IABConstant.o.g()[2], false, 2, (Object) null);
                    if (!a7) {
                        a8 = kotlin.text.w.a((CharSequence) g2, (CharSequence) IABConstant.o.g()[3], false, 2, (Object) null);
                        if (!a8) {
                            return;
                        }
                    }
                }
            }
            if (sKUDetails.h() == 1) {
                a3 = kotlin.text.w.a((CharSequence) g2, (CharSequence) "7.days", false, 2, (Object) null);
                if (a3) {
                    this.s = g2;
                    return;
                }
                a4 = kotlin.text.w.a((CharSequence) g2, (CharSequence) "30.days", false, 2, (Object) null);
                if (a4) {
                    this.t = g2;
                    return;
                }
                a5 = kotlin.text.w.a((CharSequence) g2, (CharSequence) "365.days", false, 2, (Object) null);
                if (a5) {
                    this.u = g2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(WXAccessToken wXAccessToken) {
        com.nexstreaming.app.kinemasterfree.wxapi.e.c().b(wXAccessToken, new Z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Runnable runnable) {
        if (this.n) {
            runnable.run();
        } else {
            e().b(B().b(io.reactivex.g.b.b()).a(io.reactivex.a.b.b.a()).a(new G(runnable), new H(this)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResultTask<Boolean> b(boolean z) {
        C();
        if (E() && com.nexstreaming.app.kinemasterfree.wxapi.e.c().a(z)) {
            return new ResultTask<>();
        }
        return null;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public String b() {
        WXAccessToken wXAccessToken = this.q;
        if (wXAccessToken != null) {
            return wXAccessToken.c();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(ArrayList<String> arrayList, IABConstant.SKUType sKUType) {
        if (n().get(sKUType) == null) {
            return true;
        }
        LinkedHashMap<String, SKUDetails> linkedHashMap = n().get(sKUType);
        if (linkedHashMap == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (linkedHashMap.size() == 0) {
            return true;
        }
        LinkedHashMap<String, SKUDetails> linkedHashMap2 = n().get(sKUType);
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (linkedHashMap2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (linkedHashMap2.containsKey(next)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SKUDetails> a(List<? extends Product> list) {
        ArrayList arrayList = new ArrayList();
        for (Product product : list) {
            if (d().d(product.product_code) || d().c(product.product_code) || d().b(product.product_code)) {
                SKUDetails sKUDetails = new SKUDetails();
                sKUDetails.j(product.product_code);
                sKUDetails.a(product.display);
                sKUDetails.c(product.idx);
                sKUDetails.l(product.product_name);
                sKUDetails.h(product.payfee);
                sKUDetails.a(product.fee);
                sKUDetails.m(IABConstant.SKUType.wechat.name());
                a(sKUDetails);
                b(sKUDetails);
                arrayList.add(sKUDetails);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Purchase> a(List<? extends CpOrderListResponse.OrderList> list, long j) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CpOrderListResponse.OrderList orderList : list) {
            Purchase purchase = new Purchase();
            InAppPurchaseData inAppPurchaseData = new InAppPurchaseData();
            inAppPurchaseData.c(f().getPackageName());
            inAppPurchaseData.b(orderList.orderid);
            inAppPurchaseData.d(orderList.productcode);
            inAppPurchaseData.e(String.valueOf(Purchase.PurchaseState.Purchased.ordinal()));
            try {
                inAppPurchaseData.a(orderList.cp_user_info);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            inAppPurchaseData.f(String.valueOf(String.valueOf(orderList.paytime).length() <= 10 ? orderList.paytime * 1000 : orderList.paytime));
            purchase.a(new Date(String.valueOf(orderList.paytime).length() <= 10 ? orderList.paytime * 1000 : orderList.paytime));
            purchase.a(d().a(f()));
            purchase.a(inAppPurchaseData);
            purchase.b(orderList.productcode);
            arrayList.add(purchase);
        }
        Collections.sort(arrayList, this.l);
        return arrayList;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.f> a(SKUDetails sKUDetails, DeveloperPayLoad developerPayLoad, Activity activity) {
        kotlin.jvm.internal.h.b(sKUDetails, "sku");
        kotlin.jvm.internal.h.b(developerPayLoad, "payLoad");
        kotlin.jvm.internal.h.b(activity, "activity");
        io.reactivex.m<com.nexstreaming.app.general.iab.b.f> a2 = io.reactivex.m.a((io.reactivex.o) new L(this, sKUDetails, developerPayLoad));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …)\n            }\n        }");
        return a2;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.d> a(ArrayList<String> arrayList, IABConstant.SKUType sKUType) {
        kotlin.jvm.internal.h.b(arrayList, "skus");
        kotlin.jvm.internal.h.b(sKUType, "type");
        io.reactivex.m<com.nexstreaming.app.general.iab.b.d> a2 = io.reactivex.m.a((io.reactivex.o) new P(this, arrayList));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …}\n            }\n        }");
        return a2;
    }

    public final void a(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.mm")));
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.tencent.mm")));
        }
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.b> a(Purchase purchase) {
        kotlin.jvm.internal.h.b(purchase, "purchase");
        io.reactivex.m<com.nexstreaming.app.general.iab.b.b> a2 = io.reactivex.m.a((io.reactivex.o) F.f19332a);
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …rrorCode, null)\n        }");
        return a2;
    }

    public final void a(boolean z) {
        ResultTask<Boolean> resultTask = this.p;
        if (resultTask != null) {
            if (resultTask != null) {
                resultTask.sendResult(Boolean.valueOf(z));
                this.p = null;
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public LinkedHashMap<String, SKUDetails> a(IABConstant.SKUType sKUType) {
        kotlin.jvm.internal.h.b(sKUType, "type");
        return this.j.a(sKUType);
    }
}

package com.nexstreaming.app.general.iab.Presenter;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;
import com.android.billingclient.api.AbstractC0693g;
import com.android.billingclient.api.S;
import com.nexstreaming.app.general.iab.DeveloperPayLoad;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.iab.b.d;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.kinemaster.network.SubscriptionInfo;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.C2534c;
import kotlinx.coroutines.C2551u;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1695y extends IABBasePresent implements com.android.billingclient.api.O {
    private com.nexstreaming.app.general.iab.a j;
    private final PublishSubject<Object> k;
    private AbstractC0693g l;
    private boolean m;
    private String n;
    private String o;
    private String p;
    private final ExecutorService q;
    private final ExecutorService r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1695y(Context context, String str, IABManager iABManager) {
        super(context, str, iABManager);
        kotlin.jvm.internal.h.b(context, "ctx");
        kotlin.jvm.internal.h.b(str, "marketId");
        kotlin.jvm.internal.h.b(iABManager, "iabManager");
        this.j = com.nexstreaming.app.general.iab.a.f19428c;
        PublishSubject<Object> f2 = PublishSubject.f();
        kotlin.jvm.internal.h.a((Object) f2, "PublishSubject.create<PurchasesUpdatedResponse>()");
        this.k = f2;
        AbstractC0693g.a a2 = AbstractC0693g.a(f());
        a2.b();
        a2.a(this);
        this.l = a2.a();
        this.q = Executors.newSingleThreadExecutor();
        this.r = Executors.newSingleThreadExecutor();
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(SKUDetails sKUDetails) {
        String g2 = sKUDetails.g();
        if (g2 != null) {
            if (sKUDetails.h() == 2 && sKUDetails.a() == 1) {
                this.n = g2;
                return;
            }
            if (sKUDetails.h() == 2 && sKUDetails.a() == 2) {
                this.o = g2;
            } else if (sKUDetails.h() == 2 && sKUDetails.a() == 3) {
                this.p = g2;
            }
        }
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public void A() {
        try {
            Intent intent = new Intent("android.settings.SYNC_SETTINGS");
            intent.addFlags(268435456);
            f().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Log.e(o(), "startLogin: ActivityNotFoundException");
        }
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.a> B() {
        io.reactivex.m<com.nexstreaming.app.general.iab.b.a> a2 = io.reactivex.m.a((io.reactivex.o) new C1694x(this));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …\n            })\n        }");
        return a2;
    }

    public final void C() {
        int currentTimeMillis = (int) ((System.currentTimeMillis() * 31) & 65535);
        IABConstant.a aVar = IABConstant.o;
        aVar.d(37429791 ^ ((aVar.a() >> 1) * currentTimeMillis));
        IABConstant.a aVar2 = IABConstant.o;
        aVar2.b((aVar2.h() ^ 69471369) & ((int) 3326319207L));
        IABConstant.a aVar3 = IABConstant.o;
        aVar3.c((aVar3.h() ^ 191889905) & 968648088);
        IABConstant.a aVar4 = IABConstant.o;
        aVar4.a(aVar4.h() ^ 268349438);
        IABConstant.a aVar5 = IABConstant.o;
        aVar5.e(aVar5.h() * 31);
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public String b() {
        return null;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public String c() {
        return "Google";
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public String g() {
        return this.n;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public LinkedHashMap<IABConstant.SKUType, List<Purchase>> l() {
        return this.j.a();
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public String m() {
        return this.o;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n() {
        return this.j.b();
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public String p() {
        return this.p;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public boolean r() {
        return PreferenceManager.getDefaultSharedPreferences(f()).getBoolean("giab_check_p", false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:            if (r0.size() <= 0) goto L21;     */
    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean s() {
        /*
            r3 = this;
            android.content.Context r0 = r3.f()
            boolean r0 = c.d.b.m.i.f(r0)
            if (r0 == 0) goto L74
            java.util.LinkedHashMap r0 = r3.n()
            if (r0 == 0) goto L74
            java.util.LinkedHashMap r0 = r3.n()
            r1 = 0
            if (r0 == 0) goto L70
            com.nexstreaming.app.general.iab.Utils.IABConstant$SKUType r2 = com.nexstreaming.app.general.iab.Utils.IABConstant.SKUType.inapp
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L3e
            java.util.LinkedHashMap r0 = r3.n()
            if (r0 == 0) goto L3a
            com.nexstreaming.app.general.iab.Utils.IABConstant$SKUType r2 = com.nexstreaming.app.general.iab.Utils.IABConstant.SKUType.inapp
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L36
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0
            int r0 = r0.size()
            if (r0 > 0) goto L62
            goto L3e
        L36:
            kotlin.jvm.internal.h.a()
            throw r1
        L3a:
            kotlin.jvm.internal.h.a()
            throw r1
        L3e:
            java.util.LinkedHashMap r0 = r3.n()
            if (r0 == 0) goto L6c
            com.nexstreaming.app.general.iab.Utils.IABConstant$SKUType r2 = com.nexstreaming.app.general.iab.Utils.IABConstant.SKUType.subs
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L74
            java.util.LinkedHashMap r0 = r3.n()
            if (r0 == 0) goto L68
            com.nexstreaming.app.general.iab.Utils.IABConstant$SKUType r2 = com.nexstreaming.app.general.iab.Utils.IABConstant.SKUType.subs
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L64
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0
            int r0 = r0.size()
            if (r0 <= 0) goto L74
        L62:
            r0 = 1
            goto L75
        L64:
            kotlin.jvm.internal.h.a()
            throw r1
        L68:
            kotlin.jvm.internal.h.a()
            throw r1
        L6c:
            kotlin.jvm.internal.h.a()
            throw r1
        L70:
            kotlin.jvm.internal.h.a()
            throw r1
        L74:
            r0 = 0
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.iab.Presenter.C1695y.s():boolean");
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.c> t() {
        io.reactivex.m<com.nexstreaming.app.general.iab.b.c> a2 = io.reactivex.m.a((io.reactivex.o) new r(this));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …chaseToExecute)\n        }");
        return a2;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.d> u() {
        io.reactivex.m<com.nexstreaming.app.general.iab.b.d> a2 = io.reactivex.m.a((io.reactivex.o) new C1692v(this));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …)\n            }\n        }");
        return a2;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public void v() {
        e().a();
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public void w() {
        x();
        i().b(true);
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public void x() {
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public ResultTask<Boolean> y() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(ArrayList<String> arrayList, IABConstant.SKUType sKUType) {
        LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n = n();
        if (n == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (n.get(sKUType) == null) {
            return false;
        }
        LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n2 = n();
        if (n2 == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        LinkedHashMap<String, SKUDetails> linkedHashMap = n2.get(sKUType);
        if (linkedHashMap == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (linkedHashMap.size() == 0) {
            return false;
        }
        if (sKUType == IABConstant.SKUType.subs) {
            LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n3 = n();
            if (n3 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            LinkedHashMap<String, SKUDetails> linkedHashMap2 = n3.get(IABConstant.SKUType.subs);
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (linkedHashMap2 != null && linkedHashMap2.containsKey(next)) {
                        return true;
                    }
                }
            }
            return false;
        }
        LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> n4 = n();
        if (n4 == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        LinkedHashMap<String, SKUDetails> linkedHashMap3 = n4.get(IABConstant.SKUType.inapp);
        if (arrayList != null) {
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (linkedHashMap3 != null && linkedHashMap3.containsKey(next2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.android.billingclient.api.O
    public void a(com.android.billingclient.api.H h2, List<com.android.billingclient.api.M> list) {
        if (h2 != null) {
            if (h2.a() == 0 && list != null) {
                a(list);
                i().a(h2.a(), list);
            } else {
                i().a(h2.a(), (List<com.android.billingclient.api.M>) null);
            }
        }
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public void a() {
        this.m = false;
        this.l.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Runnable runnable) {
        if (this.m) {
            runnable.run();
        } else {
            e().b(B().b(io.reactivex.g.b.b()).a(io.reactivex.a.b.b.a()).a(new C1680i(runnable), new C1681j(this)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.android.billingclient.api.P b(SKUDetails sKUDetails) {
        return new com.android.billingclient.api.P(sKUDetails.b());
    }

    public final void a(SubscriptionInfo subscriptionInfo, io.reactivex.n<com.nexstreaming.app.general.iab.b.d> nVar) {
        if (b((ArrayList<String>) null, IABConstant.SKUType.subs)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (subscriptionInfo != null) {
            Iterator<SubscriptionInfo.SubscriptionProductInfo> it = subscriptionInfo.getList().iterator();
            while (it.hasNext()) {
                for (SubscriptionInfo.SubscriptionItemInfo subscriptionItemInfo : it.next().getItems()) {
                    if (d().d(subscriptionItemInfo.getProductId()) || d().c(subscriptionItemInfo.getProductId())) {
                        arrayList.add(subscriptionItemInfo.getProductId());
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            S.a c2 = com.android.billingclient.api.S.c();
            c2.a(arrayList);
            c2.a(IABConstant.SKUType.subs.name());
            this.l.a(c2.a(), new C1676e(this, subscriptionInfo, nVar));
            return;
        }
        DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_GETSKU_INVALID);
        if (nVar != null) {
            nVar.onNext(new d.a(4));
        }
    }

    public final SKUDetails a(com.android.billingclient.api.P p) {
        kotlin.jvm.internal.h.b(p, "details");
        SKUDetails sKUDetails = new SKUDetails();
        sKUDetails.a(p.a());
        sKUDetails.b(p.b());
        sKUDetails.j(p.k());
        sKUDetails.m(p.o());
        sKUDetails.h(p.h());
        sKUDetails.l(p.n());
        sKUDetails.a(p.i());
        sKUDetails.i(p.j());
        sKUDetails.g(p.g());
        sKUDetails.b(p.b());
        sKUDetails.c(p.c());
        sKUDetails.d(String.valueOf(p.d()));
        sKUDetails.e(p.e());
        sKUDetails.f(p.f());
        sKUDetails.k(p.m());
        sKUDetails.a(p.p());
        return sKUDetails;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.f> a(SKUDetails sKUDetails, DeveloperPayLoad developerPayLoad, Activity activity) {
        kotlin.jvm.internal.h.b(sKUDetails, "sku");
        kotlin.jvm.internal.h.b(developerPayLoad, "payLoad");
        kotlin.jvm.internal.h.b(activity, "activity");
        io.reactivex.m<com.nexstreaming.app.general.iab.b.f> a2 = io.reactivex.m.a((io.reactivex.o) new C1683l(this, sKUDetails, activity));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …aseFlowRequest)\n        }");
        return a2;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.d> a(ArrayList<String> arrayList, IABConstant.SKUType sKUType) {
        kotlin.jvm.internal.h.b(arrayList, "skus");
        kotlin.jvm.internal.h.b(sKUType, "type");
        io.reactivex.m<com.nexstreaming.app.general.iab.b.d> a2 = io.reactivex.m.a((io.reactivex.o) new C1686o(this, arrayList, sKUType));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …)\n            }\n        }");
        return a2;
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public LinkedHashMap<String, SKUDetails> a(IABConstant.SKUType sKUType) {
        kotlin.jvm.internal.h.b(sKUType, "type");
        return this.j.a(sKUType);
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public int a(int i) {
        return (IABConstant.o.h() & SupportMenu.USER_MASK) + (i ^ 4660);
    }

    @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent
    public io.reactivex.m<com.nexstreaming.app.general.iab.b.b> a(Purchase purchase) {
        kotlin.jvm.internal.h.b(purchase, "purchase");
        io.reactivex.m<com.nexstreaming.app.general.iab.b.b> a2 = io.reactivex.m.a((io.reactivex.o) new C1679h(this, purchase));
        kotlin.jvm.internal.h.a((Object) a2, "Observable.create {\n    …consumeRequest)\n        }");
        return a2;
    }

    public final void a(List<com.android.billingclient.api.M> list) {
        kotlin.jvm.internal.h.b(list, "purchases");
        for (com.android.billingclient.api.M m : list) {
            if (m.b() == 1) {
                C2534c.a(C2551u.a(kotlinx.coroutines.D.b()), null, null, new IABGooglePresent$handlePurchase$1(this, m, null), 3, null);
            }
        }
    }
}

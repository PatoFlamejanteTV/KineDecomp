package com.nexstreaming.app.general.iab.c;

import android.content.Context;
import com.google.gson.Gson;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.InAppPurchaseData;
import com.nexstreaming.app.general.iab.Purchase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3178a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, int i) {
        this.b = jVar;
        this.f3178a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context k;
        Map o;
        Context k2;
        Map o2;
        Gson l;
        Map o3;
        Map o4;
        if (this.b.b.d.o != null) {
            k = this.b.b.d.k();
            if (k != null) {
                switch (this.f3178a) {
                    case -18006:
                        this.b.b.c.a(false, null, "PAY_ACTION_EXCUTED  code : " + this.f3178a);
                        return;
                    case -18005:
                        this.b.b.c.a(false, null, "PAY_REPEAT  code : " + this.f3178a);
                        return;
                    case -18004:
                    case -12:
                        this.b.b.c.a(false, null, "PAY_CANCLE  code : " + this.f3178a);
                        return;
                    case -18003:
                        this.b.b.c.a(false, null, "PAY_FAILED  code : " + this.f3178a);
                        return;
                    case -102:
                        this.b.b.c.a(false, null, "LOGIN_FAIL  code : " + this.f3178a);
                        return;
                    case 0:
                        this.b.b.d.q = true;
                        o = this.b.b.d.o();
                        if (o != null) {
                            o3 = this.b.b.d.o();
                            if (o3.get(IABHelper.SKUType.xiaomi) == null) {
                                o4 = this.b.b.d.o();
                                o4.put(IABHelper.SKUType.xiaomi, new ArrayList());
                            }
                        }
                        Purchase purchase = new Purchase();
                        InAppPurchaseData inAppPurchaseData = new InAppPurchaseData();
                        k2 = this.b.b.d.k();
                        inAppPurchaseData.b(k2.getPackageName());
                        inAppPurchaseData.a(this.b.f3177a.getCpOrderId());
                        inAppPurchaseData.c(this.b.b.f3176a.a());
                        try {
                            l = this.b.b.d.l();
                            inAppPurchaseData.f(l.toJson(this.b.b.b));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        inAppPurchaseData.e(String.valueOf(Purchase.PurchaseState.Purchased.ordinal()));
                        inAppPurchaseData.d(String.valueOf(this.b.b.d.p()));
                        purchase.a(new Date(this.b.b.d.p()));
                        purchase.a(this.b.b.d.p());
                        purchase.a(inAppPurchaseData);
                        purchase.a(this.b.b.f3176a.a());
                        o2 = this.b.b.d.o();
                        ((List) o2.get(IABHelper.SKUType.xiaomi)).add(0, purchase);
                        this.b.b.c.a(true, purchase, this.b.b.f3176a.toString());
                        return;
                    default:
                        this.b.b.c.a(false, null, "Unknown Error code : " + this.f3178a);
                        return;
                }
            }
        }
    }
}

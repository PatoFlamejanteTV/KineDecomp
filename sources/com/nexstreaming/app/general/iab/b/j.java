package com.nexstreaming.app.general.iab.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.InAppPurchaseData;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.b.a;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;
import com.nexstreaming.app.kinemasterfree.wxapi.WxPayInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WxIABHelper.java */
/* loaded from: classes.dex */
public class j extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f3166a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IABHelper.e eVar;
        IABHelper.e eVar2;
        IABHelper.e eVar3;
        Context k;
        IABHelper.a aVar;
        IABHelper.a aVar2;
        IABHelper.a aVar3;
        Map o;
        Context k2;
        Map o2;
        IABHelper.a aVar4;
        Map o3;
        Map o4;
        if (intent != null && intent.getAction() != null) {
            Log.i("WxIABHelper", "received action : " + intent.getAction());
            if (intent.getAction().equals("com.nexstreaming.app.kinemasterfree.wxpay.result")) {
                int intExtra = intent.getIntExtra("code", -1);
                WxPayInfo wxPayInfo = (WxPayInfo) intent.getParcelableExtra(WxPayInfo.class.getName());
                aVar = this.f3166a.q;
                if (aVar != null) {
                    Log.i("WxIABHelper", "Error code = [" + intExtra + "]  payInfo = [" + wxPayInfo + "]");
                    switch (intExtra) {
                        case -2:
                            aVar2 = this.f3166a.q;
                            aVar2.a(false, null, "User Cancel : " + intExtra);
                            break;
                        case -1:
                            aVar3 = this.f3166a.q;
                            aVar3.a(false, null, "Purchase Fail Error : " + intExtra);
                            break;
                        case 0:
                            this.f3166a.r = true;
                            if (wxPayInfo != null) {
                                o = this.f3166a.o();
                                if (o != null) {
                                    o3 = this.f3166a.o();
                                    if (o3.get(IABHelper.SKUType.wechat) == null) {
                                        o4 = this.f3166a.o();
                                        o4.put(IABHelper.SKUType.wechat, new ArrayList());
                                    }
                                }
                                Purchase purchase = new Purchase();
                                InAppPurchaseData inAppPurchaseData = new InAppPurchaseData();
                                k2 = this.f3166a.k();
                                inAppPurchaseData.b(k2.getPackageName());
                                inAppPurchaseData.a(wxPayInfo.b());
                                inAppPurchaseData.c(wxPayInfo.c());
                                inAppPurchaseData.f(wxPayInfo.a());
                                inAppPurchaseData.e(String.valueOf(Purchase.PurchaseState.Purchased.ordinal()));
                                inAppPurchaseData.d(String.valueOf(this.f3166a.p()));
                                purchase.a(new Date(this.f3166a.p()));
                                purchase.a(this.f3166a.p());
                                purchase.a(inAppPurchaseData);
                                purchase.a(wxPayInfo.c());
                                o2 = this.f3166a.o();
                                ((List) o2.get(IABHelper.SKUType.wechat)).add(0, purchase);
                                aVar4 = this.f3166a.q;
                                aVar4.a(true, purchase, wxPayInfo.toString());
                                break;
                            }
                            break;
                    }
                }
                this.f3166a.q = null;
                return;
            }
            if (intent.getAction().equals("com.nexstreaming.app.kinemasterfree.wechat.login.completed")) {
                Log.i("WxIABHelper", "from auth WX. Try to first login to nex server");
                WXAccessToken wXAccessToken = (WXAccessToken) intent.getParcelableExtra(WXAccessToken.class.getName());
                if (wXAccessToken != null) {
                    this.f3166a.m = wXAccessToken;
                    a aVar5 = this.f3166a;
                    eVar3 = this.f3166a.p;
                    a.C0063a c0063a = new a.C0063a(eVar3);
                    k = this.f3166a.k();
                    com.nexstreaming.kinemaster.tracelog.d.a(k, this.f3166a.r().toLowerCase(), this.f3166a.m.d(), "").onResultAvailable(c0063a).onFailure((Task.OnFailListener) c0063a);
                    return;
                }
                return;
            }
            if (intent.getAction().equals("com.nexstreaming.app.kinemasterfree.wechat.login.canceld")) {
                eVar = this.f3166a.p;
                if (eVar != null) {
                    eVar2 = this.f3166a.p;
                    eVar2.a(false, -12);
                }
            }
        }
    }
}

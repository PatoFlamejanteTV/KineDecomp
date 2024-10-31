package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import com.nexstreaming.app.general.iab.BuyResult;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class am implements IABHelper.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f4521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(af afVar) {
        this.f4521a = afVar;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.a
    public void a(BuyResult buyResult) {
        IABHelper.a aVar;
        IABHelper.a aVar2;
        Activity activity;
        IABHelper.a aVar3;
        IABHelper.a aVar4;
        Log.i("IABWrapper", "onBuy() called with: " + this.f4521a.G() + " result = [" + buyResult + "]");
        if (buyResult != null) {
            switch (buyResult.b()) {
                case 2:
                    if (buyResult.a() != null) {
                        try {
                            activity = this.f4521a.w;
                            activity.startIntentSenderForResult(buyResult.a().getIntentSender(), buyResult.c(), null, 0, 0, 0);
                            break;
                        } catch (IntentSender.SendIntentException e) {
                            e.printStackTrace();
                            a(false, null, e.toString());
                            break;
                        }
                    }
                    break;
                default:
                    this.f4521a.O();
                    aVar3 = this.f4521a.f;
                    if (aVar3 != null) {
                        aVar4 = this.f4521a.f;
                        aVar4.a(buyResult);
                        break;
                    }
                    break;
            }
        }
        aVar = this.f4521a.f;
        if (aVar != null) {
            aVar2 = this.f4521a.f;
            aVar2.a(buyResult);
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.a
    public void a(boolean z, Purchase purchase, String str) {
        IABHelper.a aVar;
        IABHelper.a aVar2;
        boolean b;
        boolean a2;
        Activity activity;
        Activity activity2;
        Activity activity3;
        this.f4521a.P();
        Log.i("IABWrapper", "onBuyResult() called with: " + this.f4521a.G() + "isSuccess = [" + z + "], purchase = [" + purchase + "], message = [" + str + "]");
        if (z) {
            if (purchase != null) {
                b = this.f4521a.b(purchase);
                if (b) {
                    activity3 = this.f4521a.w;
                    KMAppUsage.a(activity3).a(KMAppUsage.KMMetric.SubAction, "purchase");
                } else {
                    a2 = this.f4521a.a(purchase);
                    if (a2) {
                        activity2 = this.f4521a.w;
                        KMAppUsage.a(activity2).a(KMAppUsage.KMMetric.SubAction, "purchase_managed");
                    } else {
                        activity = this.f4521a.w;
                        KMAppUsage.a(activity).a(KMAppUsage.KMMetric.SubAction, "bad_sku");
                    }
                }
            }
            this.f4521a.N();
        } else {
            Log.e("IABWrapper", "onBuyResult() called with: isSuccess = [" + z + "], message = [" + str + "]");
        }
        aVar = this.f4521a.f;
        if (aVar != null) {
            aVar2 = this.f4521a.f;
            aVar2.a(z, purchase, str);
        }
        this.f4521a.t();
    }
}

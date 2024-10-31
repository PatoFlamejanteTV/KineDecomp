package com.nexstreaming.app.general.iab.Presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.InAppPurchaseData;
import com.nexstreaming.app.general.iab.Presenter.B;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;
import com.nexstreaming.app.kinemasterfree.wxapi.WxPayInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.TypeCastException;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class E extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f19330a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ IABManager f19331b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(B b2, IABManager iABManager) {
        this.f19330a = b2;
        this.f19331b = iABManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (intent == null || intent.getAction() == null || (action = intent.getAction()) == null) {
            return;
        }
        int hashCode = action.hashCode();
        if (hashCode == -1939399780) {
            if (action.equals("com.nexstreaming.app.kinemasterfree.wechat.login.completed")) {
                WXAccessToken wXAccessToken = (WXAccessToken) intent.getParcelableExtra(WXAccessToken.class.getName());
                boolean booleanExtra = intent.getBooleanExtra("isBeijing", false);
                if (wXAccessToken != null) {
                    if (!booleanExtra) {
                        this.f19330a.q = wXAccessToken;
                        B.a aVar = new B.a(this.f19330a, this.f19331b);
                        String c2 = this.f19330a.c();
                        Locale locale = Locale.ENGLISH;
                        kotlin.jvm.internal.h.a((Object) locale, "Locale.ENGLISH");
                        if (c2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase = c2.toLowerCase(locale);
                        kotlin.jvm.internal.h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        WXAccessToken wXAccessToken2 = this.f19330a.q;
                        if (wXAccessToken2 != null) {
                            com.nexstreaming.kinemaster.tracelog.f.a(context, lowerCase, wXAccessToken2.c(), "").onResultAvailable(aVar).onFailure((Task.OnFailListener) aVar);
                            return;
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    }
                    String c3 = this.f19330a.c();
                    Locale locale2 = Locale.ENGLISH;
                    kotlin.jvm.internal.h.a((Object) locale2, "Locale.ENGLISH");
                    if (c3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase2 = c3.toLowerCase(locale2);
                    kotlin.jvm.internal.h.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                    WXAccessToken wXAccessToken3 = this.f19330a.q;
                    if (wXAccessToken3 != null) {
                        com.nexstreaming.kinemaster.tracelog.f.a(context, lowerCase2, wXAccessToken3.c(), wXAccessToken.c(), "").onResultAvailable(new C(this)).onFailure((Task.OnFailListener) new D(this));
                        return;
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
                return;
            }
            return;
        }
        if (hashCode == -871569733) {
            if (action.equals("com.nexstreaming.app.kinemasterfree.wechat.login.canceld")) {
                if (intent.getBooleanExtra("isBeijing", false)) {
                    this.f19330a.a(false);
                }
                if (this.f19331b != null) {
                    if (context != null) {
                        Toast.makeText(context, context.getResources().getString(R.string.cloud_connect_fail), 0).show();
                        this.f19331b.a(false, IABError.ErrorCancel.ordinal());
                        return;
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
                return;
            }
            return;
        }
        if (hashCode == -270398558 && action.equals("com.nexstreaming.app.kinemasterfree.wxpay.result")) {
            int intExtra = intent.getIntExtra("code", -1);
            WxPayInfo wxPayInfo = (WxPayInfo) intent.getParcelableExtra(WxPayInfo.class.getName());
            if (intExtra == -2) {
                this.f19331b.b(false, null, BillingResponse.USER_CANCELED.getMessage());
                return;
            }
            if (intExtra == -1) {
                this.f19331b.b(false, null, "Purchase Fail Error : " + intExtra);
                return;
            }
            if (intExtra != 0) {
                return;
            }
            this.f19330a.r = true;
            if (wxPayInfo != null) {
                if (this.f19330a.l().get(IABConstant.SKUType.wechat) == null) {
                    this.f19330a.l().put(IABConstant.SKUType.wechat, new ArrayList());
                }
                Purchase purchase = new Purchase();
                InAppPurchaseData inAppPurchaseData = new InAppPurchaseData();
                if (context != null) {
                    inAppPurchaseData.c(context.getPackageName());
                    inAppPurchaseData.b(wxPayInfo.a());
                    inAppPurchaseData.d(wxPayInfo.c());
                    inAppPurchaseData.a(wxPayInfo.b());
                    inAppPurchaseData.e(String.valueOf(Purchase.PurchaseState.Purchased.ordinal()));
                    inAppPurchaseData.f(String.valueOf(this.f19330a.d().a(context)));
                    purchase.a(new Date(this.f19330a.d().a(context)));
                    purchase.a(this.f19330a.d().a(context));
                    purchase.a(inAppPurchaseData);
                    purchase.b(wxPayInfo.c());
                    List<Purchase> list = this.f19330a.l().get(IABConstant.SKUType.wechat);
                    if (list != null) {
                        list.add(0, purchase);
                        this.f19331b.b(true, purchase, wxPayInfo.toString());
                        return;
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }
}

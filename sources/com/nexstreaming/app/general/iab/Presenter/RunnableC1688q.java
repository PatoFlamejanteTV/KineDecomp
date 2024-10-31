package com.nexstreaming.app.general.iab.Presenter;

import android.preference.PreferenceManager;
import android.support.v4.internal.view.SupportMenu;
import com.android.billingclient.api.AbstractC0693g;
import com.android.billingclient.api.M;
import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.InAppPurchaseData;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.iab.b.c;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.SupportLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1688q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f19404a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19405b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1688q(r rVar, io.reactivex.n nVar) {
        this.f19404a = rVar;
        this.f19405b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0693g abstractC0693g;
        IABConstant.SKUType[] sKUTypeArr;
        int i;
        IABConstant.SKUType[] sKUTypeArr2;
        int i2;
        int i3 = 1;
        IABConstant.SKUType[] sKUTypeArr3 = {IABConstant.SKUType.inapp, IABConstant.SKUType.subs};
        int length = sKUTypeArr3.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            IABConstant.SKUType sKUType = sKUTypeArr3[i4];
            abstractC0693g = this.f19404a.f19406a.l;
            M.a a2 = abstractC0693g.a(sKUType.name());
            ArrayList arrayList = new ArrayList();
            if (a2 != null && a2.c() == 0) {
                IABConstant.a aVar = IABConstant.o;
                aVar.e(aVar.j() * 6163);
                int j = IABConstant.o.j() & 7;
                for (com.android.billingclient.api.M m : a2.b()) {
                    kotlin.jvm.internal.h.a((Object) m, "purchaseresult");
                    if (m.b() == i3) {
                        Purchase purchase = new Purchase();
                        C1695y c1695y = this.f19404a.f19406a;
                        String a3 = m.a();
                        kotlin.jvm.internal.h.a((Object) a3, "purchaseresult.originalJson");
                        String d2 = m.d();
                        kotlin.jvm.internal.h.a((Object) d2, "purchaseresult.signature");
                        int a4 = c1695y.a(a3, d2);
                        if (((IABConstant.o.h() ^ a4) & SupportMenu.CATEGORY_MASK) != -491454464) {
                            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IH_VFY_SKIP);
                        } else {
                            purchase.b(m.e());
                            purchase.a(m.d());
                            sKUTypeArr2 = sKUTypeArr3;
                            i2 = length;
                            purchase.a(this.f19404a.f19406a.d().a(this.f19404a.f19406a.f()));
                            purchase.a(a4);
                            purchase.a((InAppPurchaseData) this.f19404a.f19406a.h().fromJson(m.a(), InAppPurchaseData.class));
                            DiagnosticLogger.b().a(DiagnosticLogger.ParamTag.IH_VFY_CONT, j);
                            arrayList.add(purchase);
                            sKUTypeArr3 = sKUTypeArr2;
                            length = i2;
                            i3 = 1;
                        }
                    }
                    sKUTypeArr2 = sKUTypeArr3;
                    i2 = length;
                    sKUTypeArr3 = sKUTypeArr2;
                    length = i2;
                    i3 = 1;
                }
                sKUTypeArr = sKUTypeArr3;
                i = length;
                if (arrayList.size() > 0) {
                    if (this.f19404a.f19406a.l().get(sKUType) != null) {
                        List<Purchase> list = this.f19404a.f19406a.l().get(sKUType);
                        if (list == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        Boolean.valueOf(list.addAll(arrayList));
                    }
                    this.f19404a.f19406a.l().put(sKUType, arrayList);
                } else {
                    this.f19404a.f19406a.l().put(sKUType, new ArrayList());
                }
                if (i5 >= 1) {
                    DiagnosticLogger b2 = DiagnosticLogger.b();
                    DiagnosticLogger.ParamTag paramTag = DiagnosticLogger.ParamTag.IH_GETP_SIZE;
                    LinkedHashMap<IABConstant.SKUType, List<Purchase>> l = this.f19404a.f19406a.l();
                    if (l != null) {
                        b2.a(paramTag, l.size());
                        this.f19405b.onNext(new c.b(BillingResponse.OK.getIntErrorCode(), this.f19404a.f19406a.l()));
                        PreferenceManager.getDefaultSharedPreferences(this.f19404a.f19406a.f()).edit().putBoolean("giab_check_p", true).apply();
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
            } else {
                sKUTypeArr = sKUTypeArr3;
                i = length;
                SupportLogger.Event.IH_RemoteException.log(1);
                LinkedHashMap<IABConstant.SKUType, List<Purchase>> l2 = this.f19404a.f19406a.l();
                if (l2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                l2.put(sKUType, new ArrayList());
                if (i5 >= 1) {
                    DiagnosticLogger b3 = DiagnosticLogger.b();
                    DiagnosticLogger.ParamTag paramTag2 = DiagnosticLogger.ParamTag.IH_GETP_SIZE;
                    LinkedHashMap<IABConstant.SKUType, List<Purchase>> l3 = this.f19404a.f19406a.l();
                    if (l3 != null) {
                        b3.a(paramTag2, l3.size());
                        this.f19405b.onNext(new c.a(BillingResponse.GENERAL_FAILURE.getIntErrorCode()));
                        PreferenceManager.getDefaultSharedPreferences(this.f19404a.f19406a.f()).edit().putBoolean("giab_check_p", true).apply();
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                } else {
                    continue;
                }
            }
            i5++;
            i4++;
            sKUTypeArr3 = sKUTypeArr;
            length = i;
            i3 = 1;
        }
    }
}

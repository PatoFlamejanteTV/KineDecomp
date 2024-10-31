package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.iab.b.c;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpOrderListResponse;
import com.nexstreaming.app.general.tracelog.ResponseCode;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.SupportLogger;
import java.util.Date;
import java.util.List;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class Q<T> implements ResultTask.OnResultAvailableListener<CpOrderListResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ T f19356a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(T t) {
        this.f19356a = t;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<CpOrderListResponse> resultTask, Task.Event event, CpOrderListResponse cpOrderListResponse) {
        List<Purchase> a2;
        boolean z;
        if (cpOrderListResponse != null) {
            ResponseCode fromValue = ResponseCode.fromValue(cpOrderListResponse.getResult());
            if (fromValue != null) {
                int i = A.f19324a[fromValue.ordinal()];
                if (i == 1) {
                    a2 = this.f19356a.f19358a.f19360a.a((List<? extends CpOrderListResponse.OrderList>) cpOrderListResponse.getList(), cpOrderListResponse.getLogDate());
                    if (a2 != null && a2.size() > 0) {
                        Purchase purchase = a2.get(0);
                        z = this.f19356a.f19358a.f19360a.r;
                        if (z) {
                            List<Purchase> list = this.f19356a.f19358a.f19360a.l().get(IABConstant.SKUType.wechat);
                            if (list == null) {
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                            if (list.size() > 0) {
                                List<Purchase> list2 = this.f19356a.f19358a.f19360a.l().get(IABConstant.SKUType.wechat);
                                if (list2 != null) {
                                    Purchase purchase2 = list2.get(0);
                                    if (purchase.g() != null && purchase2.g() != null) {
                                        long time = purchase.g().getTime();
                                        Date g2 = purchase2.g();
                                        kotlin.jvm.internal.h.a((Object) g2, "recentlyPurchase.purchaseTime");
                                        if (time >= g2.getTime()) {
                                            this.f19356a.f19358a.f19360a.l().put(IABConstant.SKUType.wechat, a2);
                                            this.f19356a.f19358a.f19360a.r = false;
                                        }
                                    }
                                } else {
                                    kotlin.jvm.internal.h.a();
                                    throw null;
                                }
                            }
                        }
                        this.f19356a.f19358a.f19360a.l().put(IABConstant.SKUType.wechat, a2);
                        this.f19356a.f19358a.f19360a.r = false;
                    }
                    DiagnosticLogger.b().a(DiagnosticLogger.ParamTag.IH_GETP_SIZE, this.f19356a.f19358a.f19360a.l().size());
                    this.f19356a.f19359b.onNext(new c.b(BillingResponse.OK.getIntErrorCode(), this.f19356a.f19358a.f19360a.l()));
                    return;
                }
                if (i == 2) {
                    this.f19356a.f19359b.onNext(new c.a(BillingResponse.ITEM_UNAVAILABLE.getIntErrorCode()));
                    return;
                }
            }
            SupportLogger.Event.IH_ResponseCode.log(BillingResponse.BILLING_UNAVAILABLE.getIntErrorCode());
            this.f19356a.f19359b.onNext(new c.a(BillingResponse.BILLING_UNAVAILABLE.getIntErrorCode()));
        }
    }
}

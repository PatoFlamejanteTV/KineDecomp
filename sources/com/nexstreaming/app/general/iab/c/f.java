package com.nexstreaming.app.general.iab.c;

import android.util.Log;
import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpOrderListResponse;
import com.nexstreaming.app.general.tracelog.ResponseCode;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.SupportLogger;
import java.util.List;
import java.util.Map;

/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
class f implements ResultTask.OnResultAvailableListener<CpOrderListResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABHelper.c f3173a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, IABHelper.c cVar) {
        this.b = aVar;
        this.f3173a = cVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<CpOrderListResponse> resultTask, Task.Event event, CpOrderListResponse cpOrderListResponse) {
        List a2;
        Map o;
        Map<IABHelper.SKUType, List<Purchase>> o2;
        boolean z;
        Map o3;
        Map o4;
        Map o5;
        Map o6;
        if (cpOrderListResponse != null) {
            switch (ResponseCode.fromValue(cpOrderListResponse.getResult())) {
                case SUCCESS:
                    a2 = this.b.a((List<CpOrderListResponse.OrderList>) cpOrderListResponse.getList(), cpOrderListResponse.getLogDate());
                    if (a2 != null && a2.size() > 0) {
                        Purchase purchase = (Purchase) a2.get(0);
                        z = this.b.q;
                        if (z) {
                            o4 = this.b.o();
                            if (((List) o4.get(IABHelper.SKUType.xiaomi)).size() > 0) {
                                o5 = this.b.o();
                                Purchase purchase2 = (Purchase) ((List) o5.get(IABHelper.SKUType.xiaomi)).get(0);
                                if (purchase.c() != null && purchase2.c() != null && purchase.c().getTime() >= purchase2.c().getTime()) {
                                    o6 = this.b.o();
                                    o6.put(IABHelper.SKUType.xiaomi, a2);
                                    this.b.q = false;
                                }
                            }
                        }
                        o3 = this.b.o();
                        o3.put(IABHelper.SKUType.xiaomi, a2);
                        this.b.q = false;
                    }
                    DiagnosticLogger a3 = DiagnosticLogger.a();
                    DiagnosticLogger.ParamTag paramTag = DiagnosticLogger.ParamTag.IH_GETP_SIZE;
                    o = this.b.o();
                    a3.a(paramTag, o.size());
                    IABHelper.c cVar = this.f3173a;
                    o2 = this.b.o();
                    cVar.a(o2);
                    return;
                case NOT_FOUND_LIST:
                    this.f3173a.b(IABError.PurchasedNotFound, "error loading purchase list code " + cpOrderListResponse.getResult());
                    return;
                default:
                    Log.e("MiIABHelper", "getPurchases -> doInBackground : (bail) responseCode=" + BillingResponse.BILLING_UNAVAILABLE);
                    SupportLogger.Event.IH_ResponseCode.log(BillingResponse.BILLING_UNAVAILABLE.getIntErrorCode());
                    this.f3173a.b(IABError.NetworkError, "error loading purchase list code " + cpOrderListResponse.getResult());
                    return;
            }
        }
    }
}

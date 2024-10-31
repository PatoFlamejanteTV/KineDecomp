package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.Product;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.iab.b.d;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpProductListResponse;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class V<T> implements ResultTask.OnResultAvailableListener<CpProductListResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ X f19361a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(X x) {
        this.f19361a = x;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<CpProductListResponse> resultTask, Task.Event event, CpProductListResponse cpProductListResponse) {
        List<SKUDetails> a2;
        if (cpProductListResponse != null) {
            LinkedHashMap<String, SKUDetails> linkedHashMap = new LinkedHashMap<>();
            B b2 = this.f19361a.f19363a.f19365a;
            List<Product> list = cpProductListResponse.getList();
            kotlin.jvm.internal.h.a((Object) list, "result.list");
            a2 = b2.a((List<? extends Product>) list);
            if (a2.size() > 0) {
                for (SKUDetails sKUDetails : a2) {
                    String g2 = sKUDetails.g();
                    kotlin.jvm.internal.h.a((Object) g2, "details.getProductId()");
                    linkedHashMap.put(g2, sKUDetails);
                }
            } else {
                DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_GETSKU_INVALID);
            }
            for (SKUDetails sKUDetails2 : linkedHashMap.values()) {
                if (this.f19361a.f19363a.f19365a.n().get(IABConstant.SKUType.wechat) == null) {
                    this.f19361a.f19363a.f19365a.n().put(IABConstant.SKUType.wechat, linkedHashMap);
                } else {
                    LinkedHashMap<String, SKUDetails> linkedHashMap2 = this.f19361a.f19363a.f19365a.n().get(IABConstant.SKUType.wechat);
                    if (linkedHashMap2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a((Object) sKUDetails2, "skuDetails");
                    linkedHashMap2.put(sKUDetails2.g(), sKUDetails2);
                }
            }
            this.f19361a.f19364b.onNext(new d.b(BillingResponse.OK.getIntErrorCode(), this.f19361a.f19363a.f19365a.n()));
            return;
        }
        this.f19361a.f19364b.onNext(new d.a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
    }
}

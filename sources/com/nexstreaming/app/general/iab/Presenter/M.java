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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class M<T> implements ResultTask.OnResultAvailableListener<CpProductListResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f19350a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(O o) {
        this.f19350a = o;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<CpProductListResponse> resultTask, Task.Event event, CpProductListResponse cpProductListResponse) {
        List<SKUDetails> a2;
        if (cpProductListResponse != null) {
            LinkedHashMap<String, SKUDetails> linkedHashMap = new LinkedHashMap<>();
            B b2 = this.f19350a.f19352a.f19354a;
            List<Product> list = cpProductListResponse.getList();
            kotlin.jvm.internal.h.a((Object) list, "result.list");
            a2 = b2.a((List<? extends Product>) list);
            if (a2.size() > 0) {
                for (SKUDetails sKUDetails : a2) {
                    Iterator it = this.f19350a.f19352a.f19355b.iterator();
                    while (it.hasNext()) {
                        if (kotlin.jvm.internal.h.a(it.next(), (Object) sKUDetails.g())) {
                            linkedHashMap.put(sKUDetails.g(), sKUDetails);
                        }
                    }
                }
            } else {
                DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_GETSKU_INVALID);
            }
            for (SKUDetails sKUDetails2 : linkedHashMap.values()) {
                if (this.f19350a.f19352a.f19354a.n().get(IABConstant.SKUType.wechat) == null) {
                    this.f19350a.f19352a.f19354a.n().put(IABConstant.SKUType.wechat, linkedHashMap);
                } else {
                    LinkedHashMap<String, SKUDetails> linkedHashMap2 = this.f19350a.f19352a.f19354a.n().get(IABConstant.SKUType.wechat);
                    if (linkedHashMap2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a((Object) sKUDetails2, "skuDetails");
                    linkedHashMap2.put(sKUDetails2.g(), sKUDetails2);
                }
            }
            this.f19350a.f19353b.onNext(new d.b(BillingResponse.OK.getIntErrorCode(), this.f19350a.f19352a.f19354a.n()));
            return;
        }
        this.f19350a.f19353b.onNext(new d.a(BillingResponse.SERVICE_DISCONNECTED.getIntErrorCode()));
    }
}

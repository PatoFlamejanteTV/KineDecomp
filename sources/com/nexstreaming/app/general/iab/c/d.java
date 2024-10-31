package com.nexstreaming.app.general.iab.c;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Product;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpProductListResponse;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
class d implements ResultTask.OnResultAvailableListener<CpProductListResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABHelper.d f3171a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, IABHelper.d dVar) {
        this.b = aVar;
        this.f3171a = dVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<CpProductListResponse> resultTask, Task.Event event, CpProductListResponse cpProductListResponse) {
        Map<IABHelper.SKUType, Map<String, SKUDetails>> n;
        List<SKUDetails> a2;
        Map n2;
        Map<IABHelper.SKUType, Map<String, SKUDetails>> n3;
        if (cpProductListResponse != null) {
            HashMap hashMap = new HashMap();
            a2 = this.b.a((List<Product>) cpProductListResponse.getList());
            Log.i("MiIABHelper", "loadSkuInventory() called with: result = [" + cpProductListResponse.getResult() + " / " + a2.size() + "]");
            if (a2.size() > 0) {
                for (SKUDetails sKUDetails : a2) {
                    hashMap.put(sKUDetails.a(), sKUDetails);
                }
            } else {
                Log.e("MiIABHelper", IABError.InvalidSKUId + " invalid Sku id");
                DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_GETSKU_INVALID);
            }
            n2 = this.b.n();
            n2.put(IABHelper.SKUType.xiaomi, hashMap);
            IABHelper.d dVar = this.f3171a;
            n3 = this.b.n();
            dVar.b(n3);
            return;
        }
        Log.e("MiIABHelper", IABError.NetworkError + " network result error");
        IABHelper.d dVar2 = this.f3171a;
        n = this.b.n();
        dVar2.b(n);
    }
}
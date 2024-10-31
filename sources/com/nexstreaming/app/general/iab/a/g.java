package com.nexstreaming.app.general.iab.a;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.util.Log;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.gson.Gson;
import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Product;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.GoogleProductListResponse;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GoogleIABHelper.java */
/* loaded from: classes.dex */
class g implements ResultTask.OnResultAvailableListener<GoogleProductListResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABHelper.d f3149a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, IABHelper.d dVar) {
        this.b = aVar;
        this.f3149a = dVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<GoogleProductListResponse> resultTask, Task.Event event, GoogleProductListResponse googleProductListResponse) {
        Map<IABHelper.SKUType, Map<String, SKUDetails>> n;
        Object obj;
        com.a.a.a.a aVar;
        Context k;
        Map<IABHelper.SKUType, Map<String, SKUDetails>> n2;
        Map n3;
        Map<IABHelper.SKUType, Map<String, SKUDetails>> n4;
        Map n5;
        Gson l;
        Map<IABHelper.SKUType, Map<String, SKUDetails>> n6;
        Map<IABHelper.SKUType, Map<String, SKUDetails>> n7;
        ArrayList<String> arrayList = new ArrayList<>();
        for (Product product : googleProductListResponse.getList()) {
            if (this.b.a(product.product_code) || this.b.b(product.product_code)) {
                arrayList.add(product.product_code);
            }
        }
        if (arrayList.size() > 0) {
            obj = this.b.i;
            synchronized (obj) {
                aVar = this.b.g;
                k = this.b.k();
            }
            if (aVar == null) {
                SupportLogger.Event.IH_Service_Disconnected.log(4);
                DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_GETSKU_SCONN_DIS);
                Log.e("GoogleIABHelper", IABError.StartupError + " service disconnected");
                IABHelper.d dVar = this.f3149a;
                n7 = this.b.n();
                dVar.b(n7);
                return;
            }
            if (k == null) {
                DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_GETSKU_SCONN_NOCTX);
                Log.e("GoogleIABHelper", IABError.ActivityDisconnected + "activity disconnected");
                IABHelper.d dVar2 = this.f3149a;
                n6 = this.b.n();
                dVar2.b(n6);
                return;
            }
            for (IABHelper.SKUType sKUType : new IABHelper.SKUType[]{IABHelper.SKUType.inapp, IABHelper.SKUType.subs}) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
                try {
                    Bundle a2 = aVar.a(3, k.getPackageName(), sKUType.name(), bundle);
                    int i = a2.getInt("RESPONSE_CODE");
                    BillingResponse fromCode = BillingResponse.fromCode(i);
                    if (fromCode != BillingResponse.OK) {
                        SupportLogger.Event.IH_GetSkuFail.log(i);
                        DiagnosticLogger.a().a(DiagnosticLogger.ParamTag.IH_GETSKU_FAIL, i);
                        Log.e("GoogleIABHelper", IABError.SKUNotFound + " error response code = " + fromCode + fromCode.name());
                        n3 = this.b.n();
                        n3.clear();
                        IABHelper.d dVar3 = this.f3149a;
                        n4 = this.b.n();
                        dVar3.b(n4);
                        return;
                    }
                    ArrayList<String> stringArrayList = a2.getStringArrayList("DETAILS_LIST");
                    HashMap hashMap = new HashMap();
                    for (String str : stringArrayList) {
                        l = this.b.l();
                        SKUDetails sKUDetails = (SKUDetails) l.fromJson(str, SKUDetails.class);
                        try {
                            IABHelper.SKUType.valueOf(sKUDetails.b());
                        } catch (IllegalArgumentException e) {
                            KMUsage.InApp_Bad_SKU_Type.logEvent(JsonFactory.FORMAT_NAME_JSON, str);
                            sKUDetails.b(sKUType.name());
                        }
                        for (Product product2 : googleProductListResponse.getList()) {
                            if (product2.product_code.equals(sKUDetails.a())) {
                                sKUDetails.d(product2.display);
                                sKUDetails.a(product2.idx);
                            }
                        }
                        switch (sKUType) {
                            case subs:
                                this.b.g(sKUDetails);
                                break;
                            case inapp:
                                this.b.h(sKUDetails);
                                break;
                        }
                        this.b.a(sKUDetails);
                        hashMap.put(sKUDetails.a(), sKUDetails);
                    }
                    n5 = this.b.n();
                    n5.put(sKUType, hashMap);
                    DiagnosticLogger.a().a(DiagnosticLogger.ParamTag.IH_GETSKU_OK, stringArrayList.size());
                } catch (RemoteException e2) {
                    int i2 = 0;
                    if (e2 instanceof DeadObjectException) {
                        i2 = 5;
                    } else if (e2 instanceof TransactionTooLargeException) {
                        i2 = 6;
                    }
                    SupportLogger.Event.IH_RemoteException.log(4, i2);
                    DiagnosticLogger.a().a(DiagnosticLogger.ParamTag.IH_GETSKU_SCONN_EX, i2);
                    Log.e("GoogleIABHelper", IABError.RemoteServiceError + " " + e2.toString());
                    IABHelper.d dVar4 = this.f3149a;
                    n2 = this.b.n();
                    dVar4.b(n2);
                    return;
                }
            }
        } else {
            Log.e("GoogleIABHelper", "invalid Sku id");
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IW_GETSKU_INVALID);
        }
        IABHelper.d dVar5 = this.f3149a;
        n = this.b.n();
        dVar5.b(n);
    }
}

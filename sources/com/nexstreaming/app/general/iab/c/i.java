package com.nexstreaming.app.general.iab.c;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpOrderIdResponse;
import com.xiaomi.gamecenter.sdk.MiCommplatform;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MiIABHelper.java */
/* loaded from: classes.dex */
public class i implements ResultTask.OnResultAvailableListener<CpOrderIdResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SKUDetails f3176a;
    final /* synthetic */ IABHelper.DeveloperPayLoad b;
    final /* synthetic */ IABHelper.a c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, SKUDetails sKUDetails, IABHelper.DeveloperPayLoad developerPayLoad, IABHelper.a aVar2) {
        this.d = aVar;
        this.f3176a = sKUDetails;
        this.b = developerPayLoad;
        this.c = aVar2;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<CpOrderIdResponse> resultTask, Task.Event event, CpOrderIdResponse cpOrderIdResponse) {
        Gson l;
        Context k;
        if (cpOrderIdResponse != null && cpOrderIdResponse.cporderid != null) {
            MiBuyInfo miBuyInfo = new MiBuyInfo();
            miBuyInfo.setProductCode(this.f3176a.a());
            miBuyInfo.setCount(1);
            miBuyInfo.setCpOrderId(cpOrderIdResponse.cporderid);
            l = this.d.l();
            miBuyInfo.setCpUserInfo(l.toJson(this.b));
            Log.i("MiIABHelper", "start buy info sku = " + this.f3176a.a());
            Log.i("MiIABHelper", "start buy info count = 1");
            Log.i("MiIABHelper", "start buy info payload = " + this.b.toString());
            MiCommplatform miCommplatform = MiCommplatform.getInstance();
            k = this.d.k();
            miCommplatform.miUniPay((Activity) k, miBuyInfo, new j(this, miBuyInfo));
            return;
        }
        this.c.a(false, null, "Nexserver data error : " + cpOrderIdResponse.toString());
    }
}

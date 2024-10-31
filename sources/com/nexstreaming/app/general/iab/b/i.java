package com.nexstreaming.app.general.iab.b;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpOrderIdResponse;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.app.kinemasterfree.wxapi.WxPayInfo;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;

/* compiled from: WxIABHelper.java */
/* loaded from: classes.dex */
class i implements ResultTask.OnResultAvailableListener<CpOrderIdResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SKUDetails f3165a;
    final /* synthetic */ IABHelper.DeveloperPayLoad b;
    final /* synthetic */ IABHelper.a c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, SKUDetails sKUDetails, IABHelper.DeveloperPayLoad developerPayLoad, IABHelper.a aVar2) {
        this.d = aVar;
        this.f3165a = sKUDetails;
        this.b = developerPayLoad;
        this.c = aVar2;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<CpOrderIdResponse> resultTask, Task.Event event, CpOrderIdResponse cpOrderIdResponse) {
        Context k;
        Context k2;
        Gson l;
        Gson l2;
        IWXAPI iwxapi;
        if (cpOrderIdResponse != null && cpOrderIdResponse.prepay_id != null) {
            PayReq payReq = new PayReq();
            k = this.d.k();
            payReq.appId = k.getString(R.string.wx_app_id);
            k2 = this.d.k();
            payReq.partnerId = k2.getString(R.string.wx_partnerid);
            payReq.prepayId = cpOrderIdResponse.prepay_id;
            payReq.packageValue = cpOrderIdResponse.packageValue;
            payReq.timeStamp = cpOrderIdResponse.timestamp;
            String str = "appid=" + payReq.appId;
            String str2 = "partnerid=" + payReq.partnerId;
            String str3 = "prepayid=" + payReq.prepayId;
            String str4 = "package=" + payReq.packageValue;
            String str5 = "timestamp=" + payReq.timeStamp;
            payReq.nonceStr = IABHelper.d(str + "&" + str4 + "&" + str2 + "&" + str3 + "&" + str5);
            payReq.sign = IABHelper.d(str + "&" + ("noncestr=" + payReq.nonceStr) + "&" + str4 + "&" + str2 + "&" + str3 + "&" + str5 + "&" + ("key=" + cpOrderIdResponse.key)).toUpperCase();
            String str6 = cpOrderIdResponse.prepay_id;
            String str7 = cpOrderIdResponse.cporderid;
            String a2 = this.f3165a.a();
            l = this.d.l();
            WxPayInfo wxPayInfo = new WxPayInfo(str6, str7, a2, l.toJson(this.b));
            l2 = this.d.l();
            payReq.extData = l2.toJson(wxPayInfo);
            Log.i("WxIABHelper", "start buy info = " + wxPayInfo.toString());
            if (payReq.checkArgs()) {
                iwxapi = this.d.o;
                iwxapi.sendReq(payReq);
                return;
            } else {
                this.c.a(false, null, "argument error");
                return;
            }
        }
        this.c.a(false, null, "Nexserver data error : " + cpOrderIdResponse.toString());
    }
}

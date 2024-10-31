package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.b.f;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.CpOrderIdResponse;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.app.kinemasterfree.wxapi.WxPayInfo;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import kotlin.TypeCastException;

/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
final class I<T> implements ResultTask.OnResultAvailableListener<CpOrderIdResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ K f19335a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(K k) {
        this.f19335a = k;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onResultAvailable(ResultTask<CpOrderIdResponse> resultTask, Task.Event event, CpOrderIdResponse cpOrderIdResponse) {
        IWXAPI iwxapi;
        if (cpOrderIdResponse != null && cpOrderIdResponse.prepay_id != null) {
            PayReq payReq = new PayReq();
            this.f19335a.f19345a.f19347a.C();
            payReq.appId = this.f19335a.f19345a.f19347a.f().getString(R.string.wx_app_id);
            payReq.partnerId = this.f19335a.f19345a.f19347a.f().getString(R.string.wx_partnerid);
            payReq.prepayId = cpOrderIdResponse.prepay_id;
            payReq.packageValue = cpOrderIdResponse.packageValue;
            payReq.timeStamp = cpOrderIdResponse.timestamp;
            String str = "appid=" + payReq.appId;
            String str2 = "partnerid=" + payReq.partnerId;
            String str3 = "prepayid=" + payReq.prepayId;
            String str4 = "package=" + payReq.packageValue;
            String str5 = "timestamp=" + payReq.timeStamp;
            payReq.nonceStr = IABBasePresent.f19336a.a(str + '&' + str4 + '&' + str2 + '&' + str3 + '&' + str5);
            StringBuilder sb = new StringBuilder();
            sb.append("noncestr=");
            sb.append(payReq.nonceStr);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("key=");
            sb3.append(cpOrderIdResponse.key);
            String sb4 = sb3.toString();
            String a2 = IABBasePresent.f19336a.a(str + '&' + sb2 + '&' + str4 + '&' + str2 + '&' + str3 + '&' + str5 + '&' + sb4);
            if (a2 != null) {
                String upperCase = a2.toUpperCase();
                kotlin.jvm.internal.h.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                payReq.sign = upperCase;
                payReq.extData = this.f19335a.f19345a.f19347a.h().toJson(new WxPayInfo(cpOrderIdResponse.prepay_id, cpOrderIdResponse.cporderid, this.f19335a.f19345a.f19348b.g(), this.f19335a.f19345a.f19347a.h().toJson(this.f19335a.f19345a.f19349c)));
                if (payReq.checkArgs()) {
                    iwxapi = this.f19335a.f19345a.f19347a.m;
                    if (iwxapi != null) {
                        iwxapi.sendReq(payReq);
                    }
                    this.f19335a.f19346b.onNext(new f.b(BillingResponse.PENDING_PURCHASE.getIntErrorCode()));
                    return;
                }
                this.f19335a.f19346b.onNext(new f.a(BillingResponse.GENERAL_FAILURE.getIntErrorCode()));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        this.f19335a.f19346b.onNext(new f.a(BillingResponse.ITEM_NOT_OWNED.getIntErrorCode()));
    }
}

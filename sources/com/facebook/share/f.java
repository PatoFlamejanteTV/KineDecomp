package com.facebook.share;

import com.facebook.FacebookCallback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Mutable;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class f implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f341a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ Mutable c;
    final /* synthetic */ FacebookCallback d;
    final /* synthetic */ ShareApi e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ShareApi shareApi, ArrayList arrayList, ArrayList arrayList2, Mutable mutable, FacebookCallback facebookCallback) {
        this.e = shareApi;
        this.f341a = arrayList;
        this.b = arrayList2;
        this.c = mutable;
        this.d = facebookCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.Integer] */
    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject != null) {
            this.f341a.add(jSONObject);
        }
        if (graphResponse.getError() != null) {
            this.b.add(graphResponse);
        }
        this.c.value = Integer.valueOf(((Integer) this.c.value).intValue() - 1);
        if (((Integer) this.c.value).intValue() == 0) {
            if (!this.b.isEmpty()) {
                ShareInternalUtility.invokeCallbackWithResults(this.d, null, (GraphResponse) this.b.get(0));
            } else if (!this.f341a.isEmpty()) {
                ShareInternalUtility.invokeCallbackWithResults(this.d, ((JSONObject) this.f341a.get(0)).optString(ShareConstants.WEB_DIALOG_PARAM_ID), graphResponse);
            }
        }
    }
}

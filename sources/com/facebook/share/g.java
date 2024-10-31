package com.facebook.share;

import com.facebook.FacebookCallback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Mutable;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class g implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f9488a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f9489b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Mutable f9490c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f9491d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ShareApi f9492e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ShareApi shareApi, ArrayList arrayList, ArrayList arrayList2, Mutable mutable, FacebookCallback facebookCallback) {
        this.f9492e = shareApi;
        this.f9488a = arrayList;
        this.f9489b = arrayList2;
        this.f9490c = mutable;
        this.f9491d = facebookCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Integer] */
    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject != null) {
            this.f9488a.add(jSONObject);
        }
        if (graphResponse.getError() != null) {
            this.f9489b.add(graphResponse);
        }
        this.f9490c.value = Integer.valueOf(((Integer) r0.value).intValue() - 1);
        if (((Integer) this.f9490c.value).intValue() == 0) {
            if (!this.f9489b.isEmpty()) {
                ShareInternalUtility.invokeCallbackWithResults(this.f9491d, null, (GraphResponse) this.f9489b.get(0));
            } else {
                if (this.f9488a.isEmpty()) {
                    return;
                }
                ShareInternalUtility.invokeCallbackWithResults(this.f9491d, ((JSONObject) this.f9488a.get(0)).optString("id"), graphResponse);
            }
        }
    }
}

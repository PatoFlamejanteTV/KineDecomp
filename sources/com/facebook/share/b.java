package com.facebook.share;

import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.CollectionMapper;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class b implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CollectionMapper.OnMapValueCompleteListener f9471a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ShareApi f9472b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ShareApi shareApi, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        this.f9472b = shareApi;
        this.f9471a = onMapValueCompleteListener;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = "Error staging Open Graph object.";
            }
            this.f9471a.onError(new FacebookGraphResponseException(graphResponse, errorMessage));
            return;
        }
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject == null) {
            this.f9471a.onError(new FacebookGraphResponseException(graphResponse, "Error staging Open Graph object."));
            return;
        }
        String optString = jSONObject.optString("id");
        if (optString == null) {
            this.f9471a.onError(new FacebookGraphResponseException(graphResponse, "Error staging Open Graph object."));
        } else {
            this.f9471a.onComplete(optString);
        }
    }
}

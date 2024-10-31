package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.model.SharePhoto;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class d implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CollectionMapper.OnMapValueCompleteListener f339a;
    final /* synthetic */ SharePhoto b;
    final /* synthetic */ ShareApi c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ShareApi shareApi, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener, SharePhoto sharePhoto) {
        this.c = shareApi;
        this.f339a = onMapValueCompleteListener;
        this.b = sharePhoto;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = "Error staging photo.";
            }
            this.f339a.onError(new FacebookGraphResponseException(graphResponse, errorMessage));
            return;
        }
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject == null) {
            this.f339a.onError(new FacebookException("Error staging photo."));
            return;
        }
        String optString = jSONObject.optString("uri");
        if (optString == null) {
            this.f339a.onError(new FacebookException("Error staging photo."));
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", optString);
            jSONObject2.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, this.b.getUserGenerated());
            this.f339a.onComplete(jSONObject2);
        } catch (JSONException e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging photo.";
            }
            this.f339a.onError(new FacebookException(localizedMessage));
        }
    }
}

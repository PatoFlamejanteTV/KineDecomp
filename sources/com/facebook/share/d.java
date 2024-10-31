package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.SharePhoto;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class d implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CollectionMapper.OnMapValueCompleteListener f9478a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SharePhoto f9479b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ShareApi f9480c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ShareApi shareApi, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener, SharePhoto sharePhoto) {
        this.f9480c = shareApi;
        this.f9478a = onMapValueCompleteListener;
        this.f9479b = sharePhoto;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = "Error staging photo.";
            }
            this.f9478a.onError(new FacebookGraphResponseException(graphResponse, errorMessage));
            return;
        }
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject == null) {
            this.f9478a.onError(new FacebookException("Error staging photo."));
            return;
        }
        String optString = jSONObject.optString(ShareConstants.MEDIA_URI);
        if (optString == null) {
            this.f9478a.onError(new FacebookException("Error staging photo."));
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", optString);
            jSONObject2.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, this.f9479b.getUserGenerated());
            this.f9478a.onComplete(jSONObject2);
        } catch (JSONException e2) {
            String localizedMessage = e2.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging photo.";
            }
            this.f9478a.onError(new FacebookException(localizedMessage));
        }
    }
}

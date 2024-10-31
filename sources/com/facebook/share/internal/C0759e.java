package com.facebook.share.internal;

import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.share.internal.DeviceShareDialogFragment;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceShareDialogFragment.java */
/* renamed from: com.facebook.share.internal.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0759e implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceShareDialogFragment f9570a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0759e(DeviceShareDialogFragment deviceShareDialogFragment) {
        this.f9570a = deviceShareDialogFragment;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            this.f9570a.finishActivityWithError(error);
            return;
        }
        JSONObject jSONObject = graphResponse.getJSONObject();
        DeviceShareDialogFragment.a aVar = new DeviceShareDialogFragment.a();
        try {
            aVar.a(jSONObject.getString("user_code"));
            aVar.a(jSONObject.getLong(AccessToken.EXPIRES_IN_KEY));
            this.f9570a.setCurrentRequestState(aVar);
        } catch (JSONException unused) {
            this.f9570a.finishActivityWithError(new FacebookRequestError(0, "", "Malformed server response"));
        }
    }
}

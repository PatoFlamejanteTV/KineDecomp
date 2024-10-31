package com.facebook.login;

import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginClient;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceAuthDialog.java */
/* renamed from: com.facebook.login.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0746e implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceAuthDialog f9382a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0746e(DeviceAuthDialog deviceAuthDialog) {
        this.f9382a = deviceAuthDialog;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        AtomicBoolean atomicBoolean;
        LoginClient.Request request;
        atomicBoolean = this.f9382a.completed;
        if (atomicBoolean.get()) {
            return;
        }
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            int subErrorCode = error.getSubErrorCode();
            if (subErrorCode != 1349152) {
                switch (subErrorCode) {
                    case 1349172:
                    case 1349174:
                        this.f9382a.schedulePoll();
                        return;
                    case 1349173:
                        this.f9382a.onCancel();
                        return;
                    default:
                        this.f9382a.onError(graphResponse.getError().getException());
                        return;
                }
            }
            DeviceAuthDialog deviceAuthDialog = this.f9382a;
            request = deviceAuthDialog.mRequest;
            deviceAuthDialog.startLogin(request);
            return;
        }
        try {
            this.f9382a.onSuccess(graphResponse.getJSONObject().getString("access_token"));
        } catch (JSONException e2) {
            this.f9382a.onError(new FacebookException(e2));
        }
    }
}

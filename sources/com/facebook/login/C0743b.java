package com.facebook.login;

import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.DeviceAuthDialog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceAuthDialog.java */
/* renamed from: com.facebook.login.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0743b implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceAuthDialog f9379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0743b(DeviceAuthDialog deviceAuthDialog) {
        this.f9379a = deviceAuthDialog;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        boolean z;
        z = this.f9379a.isBeingDestroyed;
        if (z) {
            return;
        }
        if (graphResponse.getError() != null) {
            this.f9379a.onError(graphResponse.getError().getException());
            return;
        }
        JSONObject jSONObject = graphResponse.getJSONObject();
        DeviceAuthDialog.a aVar = new DeviceAuthDialog.a();
        try {
            aVar.b(jSONObject.getString("user_code"));
            aVar.a(jSONObject.getString("code"));
            aVar.a(jSONObject.getLong(com.umeng.commonsdk.proguard.e.aB));
            this.f9379a.setCurrentRequestState(aVar);
        } catch (JSONException e2) {
            this.f9379a.onError(new FacebookException(e2));
        }
    }
}

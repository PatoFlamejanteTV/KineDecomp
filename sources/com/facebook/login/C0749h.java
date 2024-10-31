package com.facebook.login;

import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.login.DeviceAuthDialog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceAuthDialog.java */
/* renamed from: com.facebook.login.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0749h implements GraphRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9388a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeviceAuthDialog f9389b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0749h(DeviceAuthDialog deviceAuthDialog, String str) {
        this.f9389b = deviceAuthDialog;
        this.f9388a = str;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        AtomicBoolean atomicBoolean;
        DeviceAuthDialog.a aVar;
        boolean z;
        atomicBoolean = this.f9389b.completed;
        if (atomicBoolean.get()) {
            return;
        }
        if (graphResponse.getError() != null) {
            this.f9389b.onError(graphResponse.getError().getException());
            return;
        }
        try {
            JSONObject jSONObject = graphResponse.getJSONObject();
            String string = jSONObject.getString("id");
            Utility.PermissionsPair handlePermissionResponse = Utility.handlePermissionResponse(jSONObject);
            String string2 = jSONObject.getString("name");
            aVar = this.f9389b.currentRequestState;
            DeviceRequestsHelper.cleanUpAdvertisementService(aVar.d());
            if (FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.RequireConfirm)) {
                z = this.f9389b.isRetry;
                if (!z) {
                    this.f9389b.isRetry = true;
                    this.f9389b.presentConfirmation(string, handlePermissionResponse, this.f9388a, string2);
                    return;
                }
            }
            this.f9389b.completeLogin(string, handlePermissionResponse, this.f9388a);
        } catch (JSONException e2) {
            this.f9389b.onError(new FacebookException(e2));
        }
    }
}

package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient;

/* compiled from: FacebookLiteLoginMethodHandler.java */
/* loaded from: classes.dex */
public class m extends F {
    public static final Parcelable.Creator<m> CREATOR = new l();

    public m(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.D
    public String getNameForLogging() {
        return "fb_lite_login";
    }

    @Override // com.facebook.login.D
    public boolean tryAuthorize(LoginClient.Request request) {
        String e2 = LoginClient.e();
        Intent createFacebookLiteIntent = NativeProtocol.createFacebookLiteIntent(this.loginClient.c(), request.getApplicationId(), request.getPermissions(), e2, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience(), getClientState(request.getAuthId()), request.getAuthType());
        addLoggingExtra("e2e", e2);
        return a(createFacebookLiteIntent, LoginClient.h());
    }

    @Override // com.facebook.login.D, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public m(Parcel parcel) {
        super(parcel);
    }
}

package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient;

/* compiled from: KatanaProxyLoginMethodHandler.java */
/* loaded from: classes.dex */
public class t extends F {
    public static final Parcelable.Creator<t> CREATOR = new s();

    public t(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.D
    public String getNameForLogging() {
        return "katana_proxy_auth";
    }

    @Override // com.facebook.login.D
    public boolean tryAuthorize(LoginClient.Request request) {
        String e2 = LoginClient.e();
        Intent createProxyAuthIntent = NativeProtocol.createProxyAuthIntent(this.loginClient.c(), request.getApplicationId(), request.getPermissions(), e2, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience(), getClientState(request.getAuthId()), request.getAuthType());
        addLoggingExtra("e2e", e2);
        return a(createProxyAuthIntent, LoginClient.h());
    }

    @Override // com.facebook.login.D, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public t(Parcel parcel) {
        super(parcel);
    }
}

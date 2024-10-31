package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class KatanaProxyLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public String a() {
        return "katana_proxy_auth";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean a(LoginClient.Request request) {
        String l = LoginClient.l();
        Intent createProxyAuthIntent = NativeProtocol.createProxyAuthIntent(this.b.b(), request.getApplicationId(), request.getPermissions(), l, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience());
        a("e2e", l);
        return a(createProxyAuthIntent, LoginClient.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean a(int i, int i2, Intent intent) {
        LoginClient.Result a2;
        LoginClient.Request c = this.b.c();
        if (intent == null) {
            a2 = LoginClient.Result.createCancelResult(c, "Operation canceled");
        } else if (i2 == 0) {
            a2 = b(c, intent);
        } else if (i2 != -1) {
            a2 = LoginClient.Result.createErrorResult(c, "Unexpected resultCode from authorization.", null);
        } else {
            a2 = a(c, intent);
        }
        if (a2 != null) {
            this.b.a(a2);
            return true;
        }
        this.b.h();
        return true;
    }

    private LoginClient.Result a(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String a2 = a(extras);
        String string = extras.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
        String b = b(extras);
        String string2 = extras.getString("e2e");
        if (!Utility.isNullOrEmpty(string2)) {
            a(string2);
        }
        if (a2 == null && string == null && b == null) {
            try {
                return LoginClient.Result.createTokenResult(request, a(request.getPermissions(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.getApplicationId()));
            } catch (FacebookException e) {
                return LoginClient.Result.createErrorResult(request, null, e.getMessage());
            }
        }
        if (ServerProtocol.errorsProxyAuthDisabled.contains(a2)) {
            return null;
        }
        if (ServerProtocol.errorsUserCanceled.contains(a2)) {
            return LoginClient.Result.createCancelResult(request, null);
        }
        return LoginClient.Result.createErrorResult(request, a2, b, string);
    }

    private LoginClient.Result b(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String a2 = a(extras);
        String string = extras.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
        return ServerProtocol.errorConnectionFailure.equals(string) ? LoginClient.Result.createErrorResult(request, a2, b(extras), string) : LoginClient.Result.createCancelResult(request, a2);
    }

    private String a(Bundle bundle) {
        String string = bundle.getString("error");
        if (string == null) {
            return bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
        }
        return string;
    }

    private String b(Bundle bundle) {
        String string = bundle.getString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE);
        if (string == null) {
            return bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
        }
        return string;
    }

    protected boolean a(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.b.a().startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}

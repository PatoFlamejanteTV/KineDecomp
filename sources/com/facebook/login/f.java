package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;

/* compiled from: NativeAppLoginMethodHandler.java */
/* loaded from: classes.dex */
abstract class F extends D {
    /* JADX INFO: Access modifiers changed from: package-private */
    public F(LoginClient loginClient) {
        super(loginClient);
    }

    private LoginClient.Result a(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String a2 = a(extras);
        String obj = extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE) != null ? extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE).toString() : null;
        if (ServerProtocol.errorConnectionFailure.equals(obj)) {
            return LoginClient.Result.createErrorResult(request, a2, b(extras), obj);
        }
        return LoginClient.Result.createCancelResult(request, a2);
    }

    private LoginClient.Result b(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String a2 = a(extras);
        String obj = extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE) != null ? extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE).toString() : null;
        String b2 = b(extras);
        String string = extras.getString("e2e");
        if (!Utility.isNullOrEmpty(string)) {
            logWebLoginCompleted(string);
        }
        if (a2 == null && obj == null && b2 == null) {
            try {
                return LoginClient.Result.createTokenResult(request, D.createAccessTokenFromWebBundle(request.getPermissions(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.getApplicationId()));
            } catch (FacebookException e2) {
                return LoginClient.Result.createErrorResult(request, null, e2.getMessage());
            }
        }
        if (ServerProtocol.errorsProxyAuthDisabled.contains(a2)) {
            return null;
        }
        if (ServerProtocol.errorsUserCanceled.contains(a2)) {
            return LoginClient.Result.createCancelResult(request, null);
        }
        return LoginClient.Result.createErrorResult(request, a2, b2, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.D
    public boolean onActivityResult(int i, int i2, Intent intent) {
        LoginClient.Result b2;
        LoginClient.Request i3 = this.loginClient.i();
        if (intent == null) {
            b2 = LoginClient.Result.createCancelResult(i3, "Operation canceled");
        } else if (i2 == 0) {
            b2 = a(i3, intent);
        } else if (i2 != -1) {
            b2 = LoginClient.Result.createErrorResult(i3, "Unexpected resultCode from authorization.", null);
        } else {
            b2 = b(i3, intent);
        }
        if (b2 != null) {
            this.loginClient.b(b2);
            return true;
        }
        this.loginClient.m();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(Parcel parcel) {
        super(parcel);
    }

    private String a(Bundle bundle) {
        String string = bundle.getString("error");
        return string == null ? bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE) : string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.loginClient.f().startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private String b(Bundle bundle) {
        String string = bundle.getString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE);
        return string == null ? bundle.getString("error_description") : string;
    }
}

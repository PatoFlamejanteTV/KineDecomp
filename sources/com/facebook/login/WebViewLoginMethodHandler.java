package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class WebViewLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new p();
    private WebDialog c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public String a() {
        return "web_view";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public void b() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean a(LoginClient.Request request) {
        Bundle bundle = new Bundle();
        if (!Utility.isNullOrEmpty(request.getPermissions())) {
            String join = TextUtils.join(",", request.getPermissions());
            bundle.putString("scope", join);
            a("scope", join);
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, request.getDefaultAudience().getNativeProtocolAudience());
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        String token = currentAccessToken != null ? currentAccessToken.getToken() : null;
        if (token != null && token.equals(d())) {
            bundle.putString("access_token", token);
            a("access_token", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        } else {
            Utility.clearFacebookCookies(this.b.b());
            a("access_token", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        o oVar = new o(this, request);
        this.d = LoginClient.l();
        a("e2e", this.d);
        android.support.v4.app.l b = this.b.b();
        this.c = new a(b, request.getApplicationId(), bundle).a(this.d).a(request.isRerequest()).setOnCompleteListener(oVar).setTheme(FacebookSdk.getWebDialogTheme()).build();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.setDialog(this.c);
        facebookDialogFragment.show(b.getSupportFragmentManager(), FacebookDialogFragment.TAG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        String str;
        LoginClient.Result createErrorResult;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.d = bundle.getString("e2e");
            }
            try {
                AccessToken a2 = a(request.getPermissions(), bundle, AccessTokenSource.WEB_VIEW, request.getApplicationId());
                createErrorResult = LoginClient.Result.createTokenResult(this.b.c(), a2);
                CookieSyncManager.createInstance(this.b.b()).sync();
                b(a2.getToken());
            } catch (FacebookException e) {
                createErrorResult = LoginClient.Result.createErrorResult(this.b.c(), null, e.getMessage());
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            createErrorResult = LoginClient.Result.createCancelResult(this.b.c(), "User canceled log in.");
        } else {
            this.d = null;
            String message = facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                str = String.format(Locale.ROOT, "%d", Integer.valueOf(requestError.getErrorCode()));
                message = requestError.toString();
            } else {
                str = null;
            }
            createErrorResult = LoginClient.Result.createErrorResult(this.b.c(), null, message, str);
        }
        if (!Utility.isNullOrEmpty(this.d)) {
            a(this.d);
        }
        this.b.a(createErrorResult);
    }

    private void b(String str) {
        this.b.b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", str).apply();
    }

    private String d() {
        return this.b.b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    /* loaded from: classes.dex */
    static class a extends WebDialog.Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f310a;
        private boolean b;

        public a(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
        }

        public a a(String str) {
            this.f310a = str;
            return this;
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        @Override // com.facebook.internal.WebDialog.Builder
        public WebDialog build() {
            Bundle parameters = getParameters();
            parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, ServerProtocol.DIALOG_REDIRECT_URI);
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", this.f310a);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            if (this.b) {
                parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE);
            }
            return new WebDialog(getContext(), "oauth", parameters, getTheme(), getListener());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.d);
    }
}

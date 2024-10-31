package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;

/* compiled from: WebViewLoginMethodHandler.java */
/* loaded from: classes.dex */
public class K extends H {
    public static final Parcelable.Creator<K> CREATOR = new J();

    /* renamed from: a */
    private WebDialog f9364a;
    private String e2e;

    /* compiled from: WebViewLoginMethodHandler.java */
    /* loaded from: classes.dex */
    static class a extends WebDialog.Builder {

        /* renamed from: a */
        private String f9365a;

        /* renamed from: b */
        private String f9366b;

        /* renamed from: c */
        private String f9367c;

        public a(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
            this.f9367c = ServerProtocol.DIALOG_REDIRECT_URI;
        }

        public a a(boolean z) {
            this.f9367c = z ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : ServerProtocol.DIALOG_REDIRECT_URI;
            return this;
        }

        public a b(String str) {
            this.f9365a = str;
            return this;
        }

        @Override // com.facebook.internal.WebDialog.Builder
        public WebDialog build() {
            Bundle parameters = getParameters();
            parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.f9367c);
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", this.f9365a);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, this.f9366b);
            return WebDialog.newInstance(getContext(), "oauth", parameters, getTheme(), getListener());
        }

        public a a(String str) {
            this.f9366b = str;
            return this;
        }
    }

    public K(LoginClient loginClient) {
        super(loginClient);
    }

    public void a(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        super.onComplete(request, bundle, facebookException);
    }

    @Override // com.facebook.login.D
    public void cancel() {
        WebDialog webDialog = this.f9364a;
        if (webDialog != null) {
            webDialog.cancel();
            this.f9364a = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.D
    public String getNameForLogging() {
        return "web_view";
    }

    @Override // com.facebook.login.H
    AccessTokenSource getTokenSource() {
        return AccessTokenSource.WEB_VIEW;
    }

    @Override // com.facebook.login.D
    public boolean needsInternetPermission() {
        return true;
    }

    @Override // com.facebook.login.D
    public boolean tryAuthorize(LoginClient.Request request) {
        Bundle parameters = getParameters(request);
        I i = new I(this, request);
        this.e2e = LoginClient.e();
        addLoggingExtra("e2e", this.e2e);
        FragmentActivity c2 = this.loginClient.c();
        boolean isChromeOS = Utility.isChromeOS(c2);
        a aVar = new a(c2, request.getApplicationId(), parameters);
        aVar.b(this.e2e);
        aVar.a(isChromeOS);
        aVar.a(request.getAuthType());
        this.f9364a = aVar.setOnCompleteListener(i).build();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.setDialog(this.f9364a);
        facebookDialogFragment.show(c2.getSupportFragmentManager(), FacebookDialogFragment.TAG);
        return true;
    }

    @Override // com.facebook.login.D, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.e2e);
    }

    public K(Parcel parcel) {
        super(parcel);
        this.e2e = parcel.readString();
    }
}

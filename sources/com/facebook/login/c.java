package com.facebook.login;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginManager.java */
/* loaded from: classes.dex */
public class C implements PlatformServiceClient.CompletedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9349a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ z f9350b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ LoginStatusCallback f9351c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f9352d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ LoginManager f9353e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(LoginManager loginManager, String str, z zVar, LoginStatusCallback loginStatusCallback, String str2) {
        this.f9353e = loginManager;
        this.f9349a = str;
        this.f9350b = zVar;
        this.f9351c = loginStatusCallback;
        this.f9352d = str2;
    }

    @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
    public void completed(Bundle bundle) {
        Profile profileFromBundle;
        if (bundle != null) {
            String string = bundle.getString(NativeProtocol.STATUS_ERROR_TYPE);
            String string2 = bundle.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
            if (string != null) {
                LoginManager.handleLoginStatusError(string, string2, this.f9349a, this.f9350b, this.f9351c);
                return;
            }
            String string3 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            long j = bundle.getLong(NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH);
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string4 = bundle.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
            String userIDFromSignedRequest = Utility.isNullOrEmpty(string4) ? null : D.getUserIDFromSignedRequest(string4);
            if (!Utility.isNullOrEmpty(string3) && stringArrayList != null && !stringArrayList.isEmpty() && !Utility.isNullOrEmpty(userIDFromSignedRequest)) {
                AccessToken accessToken = new AccessToken(string3, this.f9352d, userIDFromSignedRequest, stringArrayList, null, null, new Date(j), null);
                AccessToken.setCurrentAccessToken(accessToken);
                profileFromBundle = LoginManager.getProfileFromBundle(bundle);
                if (profileFromBundle != null) {
                    Profile.setCurrentProfile(profileFromBundle);
                } else {
                    Profile.fetchProfileForCurrentAccessToken();
                }
                this.f9350b.c(this.f9349a);
                this.f9351c.onCompleted(accessToken);
                return;
            }
            this.f9350b.a(this.f9349a);
            this.f9351c.onFailure();
            return;
        }
        this.f9350b.a(this.f9349a);
        this.f9351c.onFailure();
    }
}

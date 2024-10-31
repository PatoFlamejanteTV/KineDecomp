package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: GetTokenLoginMethodHandler.java */
/* renamed from: com.facebook.login.r */
/* loaded from: classes.dex */
public class C0753r extends D {
    public static final Parcelable.Creator<C0753r> CREATOR = new q();

    /* renamed from: a */
    private n f9396a;

    public C0753r(LoginClient loginClient) {
        super(loginClient);
    }

    void a(LoginClient.Request request, Bundle bundle) {
        String string = bundle.getString(NativeProtocol.EXTRA_USER_ID);
        if (string != null && !string.isEmpty()) {
            c(request, bundle);
        } else {
            this.loginClient.j();
            Utility.getGraphMeRequestWithCacheAsync(bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN), new p(this, bundle, request));
        }
    }

    public void b(LoginClient.Request request, Bundle bundle) {
        n nVar = this.f9396a;
        if (nVar != null) {
            nVar.setCompletedListener(null);
        }
        this.f9396a = null;
        this.loginClient.k();
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            Set<String> permissions = request.getPermissions();
            if (stringArrayList != null && (permissions == null || stringArrayList.containsAll(permissions))) {
                a(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : permissions) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                addLoggingExtra("new_permissions", TextUtils.join(",", hashSet));
            }
            request.setPermissions(hashSet);
        }
        this.loginClient.m();
    }

    public void c(LoginClient.Request request, Bundle bundle) {
        this.loginClient.b(LoginClient.Result.createTokenResult(this.loginClient.i(), D.createAccessTokenFromNativeLogin(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId())));
    }

    @Override // com.facebook.login.D
    public void cancel() {
        n nVar = this.f9396a;
        if (nVar != null) {
            nVar.cancel();
            this.f9396a.setCompletedListener(null);
            this.f9396a = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.D
    public String getNameForLogging() {
        return "get_token";
    }

    @Override // com.facebook.login.D
    public boolean tryAuthorize(LoginClient.Request request) {
        this.f9396a = new n(this.loginClient.c(), request.getApplicationId());
        if (!this.f9396a.start()) {
            return false;
        }
        this.loginClient.j();
        this.f9396a.setCompletedListener(new o(this, request));
        return true;
    }

    @Override // com.facebook.login.D, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public C0753r(Parcel parcel) {
        super(parcel);
    }
}

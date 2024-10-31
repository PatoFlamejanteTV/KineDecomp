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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new d();
    private a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public String a() {
        return "get_token";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public void b() {
        if (this.c != null) {
            this.c.cancel();
            this.c.setCompletedListener(null);
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean a(LoginClient.Request request) {
        this.c = new a(this.b.b(), request.getApplicationId());
        if (!this.c.start()) {
            return false;
        }
        this.b.j();
        this.c.setCompletedListener(new b(this, request));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LoginClient.Request request, Bundle bundle) {
        if (this.c != null) {
            this.c.setCompletedListener(null);
        }
        this.c = null;
        this.b.k();
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            Set<String> permissions = request.getPermissions();
            if (stringArrayList != null && (permissions == null || stringArrayList.containsAll(permissions))) {
                c(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : permissions) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                a("new_permissions", TextUtils.join(",", hashSet));
            }
            request.setPermissions(hashSet);
        }
        this.b.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(LoginClient.Request request, Bundle bundle) {
        this.b.a(LoginClient.Result.createTokenResult(this.b.c(), a(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId())));
    }

    void c(LoginClient.Request request, Bundle bundle) {
        String string = bundle.getString(NativeProtocol.EXTRA_USER_ID);
        if (string == null || string.isEmpty()) {
            this.b.j();
            Utility.getGraphMeRequestWithCacheAsync(bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN), new c(this, bundle, request));
        } else {
            b(request, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetTokenLoginMethodHandler(Parcel parcel) {
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

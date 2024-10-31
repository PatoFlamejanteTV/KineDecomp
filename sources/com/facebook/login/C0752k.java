package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: DeviceAuthMethodHandler.java */
/* renamed from: com.facebook.login.k */
/* loaded from: classes.dex */
public class C0752k extends D {
    public static final Parcelable.Creator<C0752k> CREATOR = new C0751j();

    /* renamed from: a */
    private static ScheduledThreadPoolExecutor f9390a;

    public C0752k(LoginClient loginClient) {
        super(loginClient);
    }

    private void a(LoginClient.Request request) {
        DeviceAuthDialog a2 = a();
        a2.show(this.loginClient.c().getSupportFragmentManager(), "login_with_facebook");
        a2.startLogin(request);
    }

    public static synchronized ScheduledThreadPoolExecutor b() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (C0752k.class) {
            if (f9390a == null) {
                f9390a = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = f9390a;
        }
        return scheduledThreadPoolExecutor;
    }

    public void c() {
        this.loginClient.b(LoginClient.Result.createCancelResult(this.loginClient.i(), "User canceled log in."));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.D
    public String getNameForLogging() {
        return "device_auth";
    }

    @Override // com.facebook.login.D
    public boolean tryAuthorize(LoginClient.Request request) {
        a(request);
        return true;
    }

    @Override // com.facebook.login.D, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public C0752k(Parcel parcel) {
        super(parcel);
    }

    protected DeviceAuthDialog a() {
        return new DeviceAuthDialog();
    }

    public void a(Exception exc) {
        this.loginClient.b(LoginClient.Result.createErrorResult(this.loginClient.i(), null, exc.getMessage()));
    }

    public void a(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, AccessTokenSource accessTokenSource, Date date, Date date2) {
        this.loginClient.b(LoginClient.Result.createTokenResult(this.loginClient.i(), new AccessToken(str, str2, str3, collection, collection2, accessTokenSource, date, date2)));
    }
}

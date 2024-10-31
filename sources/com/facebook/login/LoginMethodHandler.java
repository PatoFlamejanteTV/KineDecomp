package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public abstract class LoginMethodHandler implements Parcelable {

    /* renamed from: a */
    Map<String, String> f309a;
    protected LoginClient b;

    public abstract String a();

    public abstract boolean a(LoginClient.Request request);

    public LoginMethodHandler(LoginClient loginClient) {
        this.b = loginClient;
    }

    public LoginMethodHandler(Parcel parcel) {
        this.f309a = Utility.readStringMapFromParcel(parcel);
    }

    public void a(LoginClient loginClient) {
        if (this.b != null) {
            throw new FacebookException("Can't set LoginClient if it is already set.");
        }
        this.b = loginClient;
    }

    public boolean a(int i, int i2, Intent intent) {
        return false;
    }

    public boolean c() {
        return false;
    }

    public void b() {
    }

    public void a(String str, Object obj) {
        if (this.f309a == null) {
            this.f309a = new HashMap();
        }
        this.f309a.put(str, obj == null ? null : obj.toString());
    }

    public void a(String str) {
        String applicationId = this.b.c().getApplicationId();
        AppEventsLogger newLogger = AppEventsLogger.newLogger(this.b.b(), applicationId);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str);
        bundle.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        bundle.putString("app_id", applicationId);
        newLogger.logSdkEvent(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, null, bundle);
    }

    public static AccessToken a(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0L));
        ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
        String string = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
        if (Utility.isNullOrEmpty(string)) {
            return null;
        }
        return new AccessToken(string, str, bundle.getString(NativeProtocol.EXTRA_USER_ID), stringArrayList, null, accessTokenSource, bundleLongAsDate, new Date());
    }

    public static AccessToken a(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) throws FacebookException {
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, AccessToken.EXPIRES_IN_KEY, new Date());
        String string = bundle.getString("access_token");
        String string2 = bundle.getString("granted_scopes");
        Collection<String> arrayList = !Utility.isNullOrEmpty(string2) ? new ArrayList<>(Arrays.asList(string2.split(","))) : collection;
        String string3 = bundle.getString("denied_scopes");
        ArrayList arrayList2 = !Utility.isNullOrEmpty(string3) ? new ArrayList(Arrays.asList(string3.split(","))) : null;
        if (Utility.isNullOrEmpty(string)) {
            return null;
        }
        return new AccessToken(string, str, b(bundle.getString("signed_request")), arrayList, arrayList2, accessTokenSource, bundleLongAsDate, new Date());
    }

    private static String b(String str) throws FacebookException {
        if (str == null || str.isEmpty()) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            String[] split = str.split("\\.");
            if (split.length == 2) {
                return new JSONObject(new String(Base64.decode(split[1], 0), Keyczar.DEFAULT_ENCODING)).getString(AccessToken.USER_ID_KEY);
            }
        } catch (UnsupportedEncodingException e) {
        } catch (JSONException e2) {
        }
        throw new FacebookException("Failed to retrieve user_id from signed_request");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Utility.writeStringMapToParcel(parcel, this.f309a);
    }
}

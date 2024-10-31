package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.login.LoginClient;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginLogger.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private final AppEventsLogger f9422a;

    /* renamed from: b, reason: collision with root package name */
    private String f9423b;

    /* renamed from: c, reason: collision with root package name */
    private String f9424c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Context context, String str) {
        PackageInfo packageInfo;
        this.f9423b = str;
        this.f9422a = AppEventsLogger.newLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) == null) {
                return;
            }
            this.f9424c = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static Bundle d(String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", str);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }

    public String a() {
        return this.f9423b;
    }

    public void b(String str, String str2) {
        Bundle d2 = d(str);
        d2.putString("3_method", str2);
        this.f9422a.logSdkEvent("fb_mobile_login_method_start", null, d2);
    }

    public void c(String str) {
        Bundle d2 = d(str);
        d2.putString("2_result", LoginClient.Result.Code.SUCCESS.getLoggingValue());
        this.f9422a.logSdkEvent("fb_mobile_login_status_complete", null, d2);
    }

    public void a(LoginClient.Request request) {
        Bundle d2 = d(request.getAuthId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("login_behavior", request.getLoginBehavior().toString());
            jSONObject.put("request_code", LoginClient.h());
            jSONObject.put(NativeProtocol.RESULT_ARGS_PERMISSIONS, TextUtils.join(",", request.getPermissions()));
            jSONObject.put(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, request.getDefaultAudience().toString());
            jSONObject.put("isReauthorize", request.isRerequest());
            if (this.f9424c != null) {
                jSONObject.put("facebookVersion", this.f9424c);
            }
            d2.putString("6_extras", jSONObject.toString());
        } catch (JSONException unused) {
        }
        this.f9422a.logSdkEvent("fb_mobile_login_start", null, d2);
    }

    public void b(String str) {
        this.f9422a.logSdkEvent("fb_mobile_login_status_start", null, d(str));
    }

    public void c(String str, String str2) {
        a(str, str2, "");
    }

    public void a(String str, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exc) {
        Bundle d2 = d(str);
        if (code != null) {
            d2.putString("2_result", code.getLoggingValue());
        }
        if (exc != null && exc.getMessage() != null) {
            d2.putString("5_error_message", exc.getMessage());
        }
        JSONObject jSONObject = !map.isEmpty() ? new JSONObject(map) : null;
        if (map2 != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
            }
        }
        if (jSONObject != null) {
            d2.putString("6_extras", jSONObject.toString());
        }
        this.f9422a.logSdkEvent("fb_mobile_login_complete", null, d2);
    }

    public void a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Bundle d2 = d(str);
        if (str3 != null) {
            d2.putString("2_result", str3);
        }
        if (str4 != null) {
            d2.putString("5_error_message", str4);
        }
        if (str5 != null) {
            d2.putString("4_error_code", str5);
        }
        if (map != null && !map.isEmpty()) {
            d2.putString("6_extras", new JSONObject(map).toString());
        }
        d2.putString("3_method", str2);
        this.f9422a.logSdkEvent("fb_mobile_login_method_complete", null, d2);
    }

    public void a(String str, String str2) {
        Bundle d2 = d(str);
        d2.putString("3_method", str2);
        this.f9422a.logSdkEvent("fb_mobile_login_method_not_tried", null, d2);
    }

    public void a(String str) {
        Bundle d2 = d(str);
        d2.putString("2_result", "failure");
        this.f9422a.logSdkEvent("fb_mobile_login_status_complete", null, d2);
    }

    public void a(String str, Exception exc) {
        Bundle d2 = d(str);
        d2.putString("2_result", LoginClient.Result.Code.ERROR.getLoggingValue());
        d2.putString("5_error_message", exc.toString());
        this.f9422a.logSdkEvent("fb_mobile_login_status_complete", null, d2);
    }

    public void a(String str, String str2, String str3) {
        Bundle d2 = d("");
        d2.putString("2_result", LoginClient.Result.Code.ERROR.getLoggingValue());
        d2.putString("5_error_message", str2);
        d2.putString("3_method", str3);
        this.f9422a.logSdkEvent(str, null, d2);
    }
}

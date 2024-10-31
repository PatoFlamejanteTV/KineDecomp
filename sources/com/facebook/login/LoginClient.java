package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LoginClient implements Parcelable {
    public static final Parcelable.Creator<LoginClient> CREATOR = new u();

    /* renamed from: a */
    D[] f9368a;

    /* renamed from: b */
    int f9369b;

    /* renamed from: c */
    Fragment f9370c;

    /* renamed from: d */
    OnCompletedListener f9371d;

    /* renamed from: e */
    a f9372e;

    /* renamed from: f */
    boolean f9373f;

    /* renamed from: g */
    Request f9374g;

    /* renamed from: h */
    Map<String, String> f9375h;
    private z i;

    /* loaded from: classes.dex */
    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    /* loaded from: classes.dex */
    public static class Request implements Parcelable {
        public static final Parcelable.Creator<Request> CREATOR = new v();
        private final String applicationId;
        private final String authId;
        private String authType;
        private final DefaultAudience defaultAudience;
        private String deviceRedirectUriString;
        private boolean isRerequest;
        private final LoginBehavior loginBehavior;
        private Set<String> permissions;

        public /* synthetic */ Request(Parcel parcel, u uVar) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getApplicationId() {
            return this.applicationId;
        }

        public String getAuthId() {
            return this.authId;
        }

        public String getAuthType() {
            return this.authType;
        }

        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public String getDeviceRedirectUriString() {
            return this.deviceRedirectUriString;
        }

        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public Set<String> getPermissions() {
            return this.permissions;
        }

        public boolean hasPublishPermission() {
            Iterator<String> it = this.permissions.iterator();
            while (it.hasNext()) {
                if (LoginManager.isPublishPermission(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public boolean isRerequest() {
            return this.isRerequest;
        }

        void setAuthType(String str) {
            this.authType = str;
        }

        public void setDeviceRedirectUriString(String str) {
            this.deviceRedirectUriString = str;
        }

        public void setPermissions(Set<String> set) {
            Validate.notNull(set, NativeProtocol.RESULT_ARGS_PERMISSIONS);
            this.permissions = set;
        }

        public void setRerequest(boolean z) {
            this.isRerequest = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            LoginBehavior loginBehavior = this.loginBehavior;
            parcel.writeString(loginBehavior != null ? loginBehavior.name() : null);
            parcel.writeStringList(new ArrayList(this.permissions));
            DefaultAudience defaultAudience = this.defaultAudience;
            parcel.writeString(defaultAudience != null ? defaultAudience.name() : null);
            parcel.writeString(this.applicationId);
            parcel.writeString(this.authId);
            parcel.writeByte(this.isRerequest ? (byte) 1 : (byte) 0);
            parcel.writeString(this.deviceRedirectUriString);
            parcel.writeString(this.authType);
        }

        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String str, String str2, String str3) {
            this.isRerequest = false;
            this.loginBehavior = loginBehavior;
            this.permissions = set == null ? new HashSet<>() : set;
            this.defaultAudience = defaultAudience;
            this.authType = str;
            this.applicationId = str2;
            this.authId = str3;
        }

        private Request(Parcel parcel) {
            this.isRerequest = false;
            String readString = parcel.readString();
            this.loginBehavior = readString != null ? LoginBehavior.valueOf(readString) : null;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            String readString2 = parcel.readString();
            this.defaultAudience = readString2 != null ? DefaultAudience.valueOf(readString2) : null;
            this.applicationId = parcel.readString();
            this.authId = parcel.readString();
            this.isRerequest = parcel.readByte() != 0;
            this.deviceRedirectUriString = parcel.readString();
            this.authType = parcel.readString();
        }
    }

    /* loaded from: classes.dex */
    public static class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new w();
        final Code code;
        final String errorCode;
        final String errorMessage;
        public Map<String, String> loggingExtras;
        final Request request;
        final AccessToken token;

        /* loaded from: classes.dex */
        public enum Code {
            SUCCESS(GraphResponse.SUCCESS_KEY),
            CANCEL("cancel"),
            ERROR("error");

            private final String loggingValue;

            Code(String str) {
                this.loggingValue = str;
            }

            public String getLoggingValue() {
                return this.loggingValue;
            }
        }

        public /* synthetic */ Result(Parcel parcel, u uVar) {
            this(parcel);
        }

        public static Result createCancelResult(Request request, String str) {
            return new Result(request, Code.CANCEL, null, str, null);
        }

        public static Result createErrorResult(Request request, String str, String str2) {
            return createErrorResult(request, str, str2, null);
        }

        public static Result createTokenResult(Request request, AccessToken accessToken) {
            return new Result(request, Code.SUCCESS, accessToken, null, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.code.name());
            parcel.writeParcelable(this.token, i);
            parcel.writeString(this.errorMessage);
            parcel.writeString(this.errorCode);
            parcel.writeParcelable(this.request, i);
            Utility.writeStringMapToParcel(parcel, this.loggingExtras);
        }

        Result(Request request, Code code, AccessToken accessToken, String str, String str2) {
            Validate.notNull(code, "code");
            this.request = request;
            this.token = accessToken;
            this.errorMessage = str;
            this.code = code;
            this.errorCode = str2;
        }

        public static Result createErrorResult(Request request, String str, String str2, String str3) {
            return new Result(request, Code.ERROR, null, TextUtils.join(": ", Utility.asListNoNulls(str, str2)), str3);
        }

        private Result(Parcel parcel) {
            this.code = Code.valueOf(parcel.readString());
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readStringMapFromParcel(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    public LoginClient(Fragment fragment) {
        this.f9369b = -1;
        this.f9370c = fragment;
    }

    public static String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static int h() {
        return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }

    private void n() {
        a(Result.createErrorResult(this.f9374g, "Login attempt failed.", null));
    }

    private z o() {
        z zVar = this.i;
        if (zVar == null || !zVar.a().equals(this.f9374g.getApplicationId())) {
            this.i = new z(c(), this.f9374g.getApplicationId());
        }
        return this.i;
    }

    public void a(Fragment fragment) {
        if (this.f9370c == null) {
            this.f9370c = fragment;
            return;
        }
        throw new FacebookException("Can't set fragment once it is already set.");
    }

    protected D[] b(Request request) {
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (loginBehavior.allowsGetTokenAuth()) {
            arrayList.add(new C0753r(this));
        }
        if (loginBehavior.allowsKatanaAuth()) {
            arrayList.add(new t(this));
        }
        if (loginBehavior.allowsFacebookLiteAuth()) {
            arrayList.add(new m(this));
        }
        if (loginBehavior.allowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (loginBehavior.allowsWebViewAuth()) {
            arrayList.add(new K(this));
        }
        if (loginBehavior.allowsDeviceAuth()) {
            arrayList.add(new C0752k(this));
        }
        D[] dArr = new D[arrayList.size()];
        arrayList.toArray(dArr);
        return dArr;
    }

    public FragmentActivity c() {
        return this.f9370c.getActivity();
    }

    public D d() {
        int i = this.f9369b;
        if (i >= 0) {
            return this.f9368a[i];
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Fragment f() {
        return this.f9370c;
    }

    boolean g() {
        return this.f9374g != null && this.f9369b >= 0;
    }

    public Request i() {
        return this.f9374g;
    }

    public void j() {
        a aVar = this.f9372e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void k() {
        a aVar = this.f9372e;
        if (aVar != null) {
            aVar.b();
        }
    }

    boolean l() {
        D d2 = d();
        if (d2.needsInternetPermission() && !b()) {
            a("no_internet_permission", "1", false);
            return false;
        }
        boolean tryAuthorize = d2.tryAuthorize(this.f9374g);
        if (tryAuthorize) {
            o().b(this.f9374g.getAuthId(), d2.getNameForLogging());
        } else {
            o().a(this.f9374g.getAuthId(), d2.getNameForLogging());
            a("not_tried", d2.getNameForLogging(), true);
        }
        return tryAuthorize;
    }

    public void m() {
        int i;
        if (this.f9369b >= 0) {
            a(d().getNameForLogging(), "skipped", null, null, d().methodLoggingExtras);
        }
        do {
            if (this.f9368a != null && (i = this.f9369b) < r0.length - 1) {
                this.f9369b = i + 1;
            } else {
                if (this.f9374g != null) {
                    n();
                    return;
                }
                return;
            }
        } while (!l());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.f9368a, i);
        parcel.writeInt(this.f9369b);
        parcel.writeParcelable(this.f9374g, i);
        Utility.writeStringMapToParcel(parcel, this.f9375h);
    }

    public void c(Request request) {
        if (g()) {
            return;
        }
        a(request);
    }

    private void d(Result result) {
        OnCompletedListener onCompletedListener = this.f9371d;
        if (onCompletedListener != null) {
            onCompletedListener.onCompleted(result);
        }
    }

    public LoginClient(Parcel parcel) {
        this.f9369b = -1;
        Parcelable[] readParcelableArray = parcel.readParcelableArray(D.class.getClassLoader());
        this.f9368a = new D[readParcelableArray.length];
        for (int i = 0; i < readParcelableArray.length; i++) {
            D[] dArr = this.f9368a;
            dArr[i] = (D) readParcelableArray[i];
            dArr[i].setLoginClient(this);
        }
        this.f9369b = parcel.readInt();
        this.f9374g = (Request) parcel.readParcelable(Request.class.getClassLoader());
        this.f9375h = Utility.readStringMapFromParcel(parcel);
    }

    void a(Request request) {
        if (request == null) {
            return;
        }
        if (this.f9374g == null) {
            if (!AccessToken.isCurrentAccessTokenActive() || b()) {
                this.f9374g = request;
                this.f9368a = b(request);
                m();
                return;
            }
            return;
        }
        throw new FacebookException("Attempted to authorize while a request is pending.");
    }

    void c(Result result) {
        Result createErrorResult;
        if (result.token != null) {
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            AccessToken accessToken = result.token;
            if (currentAccessToken != null && accessToken != null) {
                try {
                    if (currentAccessToken.getUserId().equals(accessToken.getUserId())) {
                        createErrorResult = Result.createTokenResult(this.f9374g, result.token);
                        a(createErrorResult);
                        return;
                    }
                } catch (Exception e2) {
                    a(Result.createErrorResult(this.f9374g, "Caught exception", e2.getMessage()));
                    return;
                }
            }
            createErrorResult = Result.createErrorResult(this.f9374g, "User logged in as different Facebook user.", null);
            a(createErrorResult);
            return;
        }
        throw new FacebookException("Can't validate without a token");
    }

    public void a() {
        if (this.f9369b >= 0) {
            d().cancel();
        }
    }

    public boolean a(int i, int i2, Intent intent) {
        if (this.f9374g != null) {
            return d().onActivityResult(i, i2, intent);
        }
        return false;
    }

    private void a(String str, String str2, boolean z) {
        if (this.f9375h == null) {
            this.f9375h = new HashMap();
        }
        if (this.f9375h.containsKey(str) && z) {
            str2 = this.f9375h.get(str) + "," + str2;
        }
        this.f9375h.put(str, str2);
    }

    boolean b() {
        if (this.f9373f) {
            return true;
        }
        if (a("android.permission.INTERNET") != 0) {
            FragmentActivity c2 = c();
            a(Result.createErrorResult(this.f9374g, c2.getString(com.facebook.common.R.string.com_facebook_internet_permission_error_title), c2.getString(com.facebook.common.R.string.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.f9373f = true;
        return true;
    }

    public void a(Result result) {
        D d2 = d();
        if (d2 != null) {
            a(d2.getNameForLogging(), result, d2.methodLoggingExtras);
        }
        Map<String, String> map = this.f9375h;
        if (map != null) {
            result.loggingExtras = map;
        }
        this.f9368a = null;
        this.f9369b = -1;
        this.f9374g = null;
        this.f9375h = null;
        d(result);
    }

    public void b(Result result) {
        if (result.token != null && AccessToken.isCurrentAccessTokenActive()) {
            c(result);
        } else {
            a(result);
        }
    }

    public void a(OnCompletedListener onCompletedListener) {
        this.f9371d = onCompletedListener;
    }

    public void a(a aVar) {
        this.f9372e = aVar;
    }

    int a(String str) {
        return c().checkCallingOrSelfPermission(str);
    }

    private void a(String str, Result result, Map<String, String> map) {
        a(str, result.code.getLoggingValue(), result.errorMessage, result.errorCode, map);
    }

    private void a(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.f9374g == null) {
            o().a("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
        } else {
            o().a(this.f9374g.getAuthId(), str, str2, str3, str4, map);
        }
    }
}

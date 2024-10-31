package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.R;
import com.facebook.appevents.AppEventsConstants;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoginClient implements Parcelable {
    public static final Parcelable.Creator<LoginClient> CREATOR = new f();

    /* renamed from: a, reason: collision with root package name */
    LoginMethodHandler[] f305a;
    int b;
    Fragment c;
    OnCompletedListener d;
    a e;
    boolean f;
    Request g;
    Map<String, String> h;
    private k i;

    /* loaded from: classes.dex */
    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    /* loaded from: classes.dex */
    interface a {
        void a();

        void b();
    }

    public LoginClient(Fragment fragment) {
        this.b = -1;
        this.c = fragment;
    }

    public Fragment a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.c != null) {
            throw new FacebookException("Can't set fragment once it is already set.");
        }
        this.c = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public android.support.v4.app.l b() {
        return this.c.getActivity();
    }

    public Request c() {
        return this.g;
    }

    public static int d() {
        return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Request request) {
        if (!e()) {
            b(request);
        }
    }

    void b(Request request) {
        if (request != null) {
            if (this.g != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            }
            if (AccessToken.getCurrentAccessToken() == null || g()) {
                this.g = request;
                this.f305a = c(request);
                h();
            }
        }
    }

    boolean e() {
        return this.g != null && this.b >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.b >= 0) {
            m().b();
        }
    }

    private LoginMethodHandler m() {
        if (this.b >= 0) {
            return this.f305a[this.b];
        }
        return null;
    }

    public boolean a(int i, int i2, Intent intent) {
        if (this.g != null) {
            return m().a(i, i2, intent);
        }
        return false;
    }

    private LoginMethodHandler[] c(Request request) {
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (loginBehavior.allowsKatanaAuth()) {
            arrayList.add(new GetTokenLoginMethodHandler(this));
            arrayList.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (loginBehavior.allowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(loginMethodHandlerArr);
        return loginMethodHandlerArr;
    }

    boolean g() {
        if (this.f) {
            return true;
        }
        if (a("android.permission.INTERNET") != 0) {
            android.support.v4.app.l b = b();
            b(Result.createErrorResult(this.g, b.getString(R.string.com_facebook_internet_permission_error_title), b.getString(R.string.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.f = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.b >= 0) {
            a(m().a(), "skipped", null, null, m().f309a);
        }
        while (this.f305a != null && this.b < this.f305a.length - 1) {
            this.b++;
            if (i()) {
                return;
            }
        }
        if (this.g != null) {
            n();
        }
    }

    private void n() {
        b(Result.createErrorResult(this.g, "Login attempt failed.", null));
    }

    private void a(String str, String str2, boolean z) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        if (this.h.containsKey(str) && z) {
            str2 = this.h.get(str) + "," + str2;
        }
        this.h.put(str, str2);
    }

    boolean i() {
        boolean z = false;
        LoginMethodHandler m = m();
        if (m.c() && !g()) {
            a("no_internet_permission", AppEventsConstants.EVENT_PARAM_VALUE_YES, false);
        } else {
            z = m.a(this.g);
            if (z) {
                o().a(this.g.getAuthId(), m.a());
            } else {
                a("not_tried", m.a(), true);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Result result) {
        if (result.token != null && AccessToken.getCurrentAccessToken() != null) {
            c(result);
        } else {
            b(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Result result) {
        LoginMethodHandler m = m();
        if (m != null) {
            a(m.a(), result, m.f309a);
        }
        if (this.h != null) {
            result.loggingExtras = this.h;
        }
        this.f305a = null;
        this.b = -1;
        this.g = null;
        this.h = null;
        d(result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OnCompletedListener onCompletedListener) {
        this.d = onCompletedListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.e = aVar;
    }

    int a(String str) {
        return b().checkCallingOrSelfPermission(str);
    }

    void c(Result result) {
        Result createErrorResult;
        if (result.token == null) {
            throw new FacebookException("Can't validate without a token");
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        AccessToken accessToken = result.token;
        if (currentAccessToken != null && accessToken != null) {
            try {
                if (currentAccessToken.getUserId().equals(accessToken.getUserId())) {
                    createErrorResult = Result.createTokenResult(this.g, result.token);
                    b(createErrorResult);
                }
            } catch (Exception e) {
                b(Result.createErrorResult(this.g, "Caught exception", e.getMessage()));
                return;
            }
        }
        createErrorResult = Result.createErrorResult(this.g, "User logged in as different Facebook user.", null);
        b(createErrorResult);
    }

    private k o() {
        if (this.i == null || !this.i.a().equals(this.g.getApplicationId())) {
            this.i = new k(b(), this.g.getApplicationId());
        }
        return this.i;
    }

    private void d(Result result) {
        if (this.d != null) {
            this.d.onCompleted(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (this.e != null) {
            this.e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (this.e != null) {
            this.e.b();
        }
    }

    private void a(String str, Result result, Map<String, String> map) {
        a(str, result.code.getLoggingValue(), result.errorMessage, result.errorCode, map);
    }

    private void a(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.g == null) {
            o().a("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
        } else {
            o().a(this.g.getAuthId(), str, str2, str3, str4, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    /* loaded from: classes.dex */
    public static class Request implements Parcelable {
        public static final Parcelable.Creator<Request> CREATOR = new g();
        private final String applicationId;
        private final String authId;
        private final DefaultAudience defaultAudience;
        private boolean isRerequest;
        private final LoginBehavior loginBehavior;
        private Set<String> permissions;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Request(Parcel parcel, f fVar) {
            this(parcel);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String str, String str2) {
            this.isRerequest = false;
            this.loginBehavior = loginBehavior;
            this.permissions = set == null ? new HashSet<>() : set;
            this.defaultAudience = defaultAudience;
            this.applicationId = str;
            this.authId = str2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set<String> getPermissions() {
            return this.permissions;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setPermissions(Set<String> set) {
            Validate.notNull(set, NativeProtocol.RESULT_ARGS_PERMISSIONS);
            this.permissions = set;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getAuthId() {
            return this.authId;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isRerequest() {
            return this.isRerequest;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setRerequest(boolean z) {
            this.isRerequest = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean hasPublishPermission() {
            Iterator<String> it = this.permissions.iterator();
            while (it.hasNext()) {
                if (LoginManager.isPublishPermission(it.next())) {
                    return true;
                }
            }
            return false;
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
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.loginBehavior != null ? this.loginBehavior.name() : null);
            parcel.writeStringList(new ArrayList(this.permissions));
            parcel.writeString(this.defaultAudience != null ? this.defaultAudience.name() : null);
            parcel.writeString(this.applicationId);
            parcel.writeString(this.authId);
            parcel.writeByte((byte) (this.isRerequest ? 1 : 0));
        }
    }

    /* loaded from: classes.dex */
    public static class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new h();
        final Code code;
        final String errorCode;
        final String errorMessage;
        public Map<String, String> loggingExtras;
        final Request request;
        final AccessToken token;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Result(Parcel parcel, f fVar) {
            this(parcel);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum Code {
            SUCCESS(GraphResponse.SUCCESS_KEY),
            CANCEL("cancel"),
            ERROR("error");

            private final String loggingValue;

            Code(String str) {
                this.loggingValue = str;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public String getLoggingValue() {
                return this.loggingValue;
            }
        }

        Result(Request request, Code code, AccessToken accessToken, String str, String str2) {
            Validate.notNull(code, "code");
            this.request = request;
            this.token = accessToken;
            this.errorMessage = str;
            this.code = code;
            this.errorCode = str2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Result createTokenResult(Request request, AccessToken accessToken) {
            return new Result(request, Code.SUCCESS, accessToken, null, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Result createCancelResult(Request request, String str) {
            return new Result(request, Code.CANCEL, null, str, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Result createErrorResult(Request request, String str, String str2) {
            return createErrorResult(request, str, str2, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
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
    }

    public LoginClient(Parcel parcel) {
        this.b = -1;
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.f305a = new LoginMethodHandler[readParcelableArray.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < readParcelableArray.length) {
                this.f305a[i2] = (LoginMethodHandler) readParcelableArray[i2];
                this.f305a[i2].a(this);
                i = i2 + 1;
            } else {
                this.b = parcel.readInt();
                this.g = (Request) parcel.readParcelable(Request.class.getClassLoader());
                this.h = Utility.readStringMapFromParcel(parcel);
                return;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.f305a, i);
        parcel.writeInt(this.b);
        parcel.writeParcelable(this.g, i);
        Utility.writeStringMapToParcel(parcel, this.h);
    }
}

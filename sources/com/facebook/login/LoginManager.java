package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.facebook.share.internal.ShareConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public class LoginManager {
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS = getOtherPublishPermissions();
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static volatile LoginManager instance;
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;

    LoginManager() {
        Validate.sdkInitialized();
    }

    public static LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    public void resolveError(Activity activity, GraphResponse graphResponse) {
        startLogin(new a(activity), createLoginRequestFromResponse(graphResponse));
    }

    public void resolveError(Fragment fragment, GraphResponse graphResponse) {
        startLogin(new b(fragment), createLoginRequestFromResponse(graphResponse));
    }

    private LoginClient.Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        Validate.notNull(graphResponse, "response");
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        return createLoginRequest(accessToken != null ? accessToken.getPermissions() : null);
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new l(this, facebookCallback));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onActivityResult(int i, Intent intent) {
        return onActivityResult(i, intent, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onActivityResult(int i, Intent intent, FacebookCallback<LoginResult> facebookCallback) {
        boolean z;
        AccessToken accessToken;
        LoginClient.Result.Code code;
        LoginClient.Request request;
        FacebookException facebookException;
        Map<String, String> map;
        LoginClient.Request request2;
        AccessToken accessToken2;
        Map<String, String> map2;
        FacebookAuthorizationException facebookAuthorizationException;
        LoginClient.Result.Code code2;
        FacebookAuthorizationException facebookAuthorizationException2 = null;
        AccessToken accessToken3 = null;
        LoginClient.Result.Code code3 = LoginClient.Result.Code.ERROR;
        boolean z2 = false;
        if (intent != null) {
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result == null) {
                request2 = null;
                accessToken2 = null;
                map2 = null;
                facebookAuthorizationException = null;
                code2 = code3;
            } else {
                LoginClient.Request request3 = result.request;
                LoginClient.Result.Code code4 = result.code;
                if (i == -1) {
                    if (result.code == LoginClient.Result.Code.SUCCESS) {
                        accessToken3 = result.token;
                    } else {
                        facebookAuthorizationException2 = new FacebookAuthorizationException(result.errorMessage);
                    }
                } else if (i == 0) {
                    z2 = true;
                }
                accessToken2 = accessToken3;
                map2 = result.loggingExtras;
                request2 = request3;
                facebookAuthorizationException = facebookAuthorizationException2;
                code2 = code4;
            }
            z = z2;
            request = request2;
            accessToken = accessToken2;
            facebookException = facebookAuthorizationException;
            Map<String, String> map3 = map2;
            code = code2;
            map = map3;
        } else if (i != 0) {
            z = false;
            accessToken = null;
            code = code3;
            request = null;
            facebookException = null;
            map = null;
        } else {
            z = true;
            accessToken = null;
            code = LoginClient.Result.Code.CANCEL;
            request = null;
            facebookException = null;
            map = null;
        }
        if (facebookException == null && accessToken == null && !z) {
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        logCompleteLogin(null, code, map, facebookException, true, request);
        finishLogin(accessToken, request, facebookException, z, facebookCallback);
        return true;
    }

    public LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public LoginManager setLoginBehavior(LoginBehavior loginBehavior) {
        this.loginBehavior = loginBehavior;
        return this;
    }

    public DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    public LoginManager setDefaultAudience(DefaultAudience defaultAudience) {
        this.defaultAudience = defaultAudience;
        return this;
    }

    public void logOut() {
        AccessToken.setCurrentAccessToken(null);
        Profile.setCurrentProfile(null);
    }

    public void logInWithReadPermissions(Fragment fragment, Collection<String> collection) {
        validateReadPermissions(collection);
        startLogin(new b(fragment), createLoginRequest(collection));
    }

    public void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        validateReadPermissions(collection);
        startLogin(new a(activity), createLoginRequest(collection));
    }

    public void logInWithPublishPermissions(Fragment fragment, Collection<String> collection) {
        validatePublishPermissions(collection);
        startLogin(new b(fragment), createLoginRequest(collection));
    }

    public void logInWithPublishPermissions(Activity activity, Collection<String> collection) {
        validatePublishPermissions(collection);
        startLogin(new a(activity), createLoginRequest(collection));
    }

    private void validateReadPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String str : collection) {
                if (isPublishPermission(str)) {
                    throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", str));
                }
            }
        }
    }

    private void validatePublishPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String str : collection) {
                if (!isPublishPermission(str)) {
                    throw new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isPublishPermission(String str) {
        return str != null && (str.startsWith(PUBLISH_PERMISSION_PREFIX) || str.startsWith(MANAGE_PERMISSION_PREFIX) || OTHER_PUBLISH_PERMISSIONS.contains(str));
    }

    private static Set<String> getOtherPublishPermissions() {
        return Collections.unmodifiableSet(new HashSet<String>() { // from class: com.facebook.login.LoginManager.2
            {
                add("ads_management");
                add("create_event");
                add("rsvp_event");
            }
        });
    }

    private LoginClient.Request createLoginRequest(Collection<String> collection) {
        LoginClient.Request request = new LoginClient.Request(this.loginBehavior, Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet()), this.defaultAudience, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
        request.setRerequest(AccessToken.getCurrentAccessToken() != null);
        return request;
    }

    private void startLogin(n nVar, LoginClient.Request request) throws FacebookException {
        logStartLogin(nVar.a(), request);
        CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new m(this));
        if (!tryFacebookActivity(nVar, request)) {
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            logCompleteLogin(nVar.a(), LoginClient.Result.Code.ERROR, null, facebookException, false, request);
            throw facebookException;
        }
    }

    private void logStartLogin(Context context, LoginClient.Request request) {
        k b2 = c.b(context);
        if (b2 != null && request != null) {
            b2.a(request);
        }
    }

    private void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        k b2 = c.b(context);
        if (b2 != null) {
            if (request == null) {
                b2.b("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("try_login_activity", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            b2.a(request.getAuthId(), hashMap, code, map, exc);
        }
    }

    private boolean tryFacebookActivity(n nVar, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            nVar.a(facebookActivityIntent, LoginClient.d());
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    private boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private Intent getFacebookActivityIntent(LoginClient.Request request) {
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, request);
        intent.putExtras(bundle);
        return intent;
    }

    static LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken) {
        Set<String> permissions = request.getPermissions();
        HashSet hashSet = new HashSet(accessToken.getPermissions());
        if (request.isRerequest()) {
            hashSet.retainAll(permissions);
        }
        HashSet hashSet2 = new HashSet(permissions);
        hashSet2.removeAll(hashSet);
        return new LoginResult(accessToken, hashSet, hashSet2);
    }

    private void finishLogin(AccessToken accessToken, LoginClient.Request request, FacebookException facebookException, boolean z, FacebookCallback<LoginResult> facebookCallback) {
        if (accessToken != null) {
            AccessToken.setCurrentAccessToken(accessToken);
            Profile.fetchProfileForCurrentAccessToken();
        }
        if (facebookCallback != null) {
            LoginResult computeLoginResult = accessToken != null ? computeLoginResult(request, accessToken) : null;
            if (z || (computeLoginResult != null && computeLoginResult.getRecentlyGrantedPermissions().size() == 0)) {
                facebookCallback.onCancel();
            } else if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else if (accessToken != null) {
                facebookCallback.onSuccess(computeLoginResult);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class a implements n {

        /* renamed from: a, reason: collision with root package name */
        private final Activity f306a;

        a(Activity activity) {
            Validate.notNull(activity, "activity");
            this.f306a = activity;
        }

        @Override // com.facebook.login.n
        public void a(Intent intent, int i) {
            this.f306a.startActivityForResult(intent, i);
        }

        @Override // com.facebook.login.n
        public Activity a() {
            return this.f306a;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements n {

        /* renamed from: a, reason: collision with root package name */
        private final Fragment f307a;

        b(Fragment fragment) {
            Validate.notNull(fragment, "fragment");
            this.f307a = fragment;
        }

        @Override // com.facebook.login.n
        public void a(Intent intent, int i) {
            this.f307a.startActivityForResult(intent, i);
        }

        @Override // com.facebook.login.n
        public Activity a() {
            return this.f307a.getActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static volatile k f308a;

        /* JADX INFO: Access modifiers changed from: private */
        public static synchronized k b(Context context) {
            k kVar;
            synchronized (c.class) {
                if (context == null) {
                    context = FacebookSdk.getApplicationContext();
                }
                if (context == null) {
                    kVar = null;
                } else {
                    if (f308a == null) {
                        f308a = new k(context, FacebookSdk.getApplicationId());
                    }
                    kVar = f308a;
                }
            }
            return kVar;
        }
    }
}

package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.login.DefaultAudience;
import com.facebook.messenger.MessengerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class NativeProtocol {
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    public static final String AUDIENCE_EVERYONE = "everyone";
    public static final String AUDIENCE_FRIENDS = "friends";
    public static final String AUDIENCE_ME = "only_me";
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    private static final String CONTENT_SCHEME = "content://";
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    public static final String IMAGE_URL_KEY = "url";
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    public static final String WEB_DIALOG_ACTION = "action";
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    public static final String WEB_DIALOG_PARAMS = "params";
    public static final String WEB_DIALOG_URL = "url";
    private static final c FACEBOOK_APP_INFO = new a(null);
    private static List<c> facebookAppInfoList = buildFacebookAppList();
    private static Map<String, List<c>> actionToAppInfoMap = buildActionToAppInfoMap();
    private static AtomicBoolean protocolVersionsAsyncUpdating = new AtomicBoolean(false);
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    private static final List<Integer> KNOWN_PROTOCOL_VERSIONS = Arrays.asList(Integer.valueOf(PROTOCOL_VERSION_20141218), Integer.valueOf(PROTOCOL_VERSION_20141107), Integer.valueOf(PROTOCOL_VERSION_20141028), Integer.valueOf(PROTOCOL_VERSION_20141001), Integer.valueOf(PROTOCOL_VERSION_20140701), Integer.valueOf(PROTOCOL_VERSION_20140324), Integer.valueOf(PROTOCOL_VERSION_20140204), Integer.valueOf(PROTOCOL_VERSION_20131107), Integer.valueOf(PROTOCOL_VERSION_20130618), Integer.valueOf(PROTOCOL_VERSION_20130502), Integer.valueOf(PROTOCOL_VERSION_20121101));

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        private static final HashSet<String> f277a = c();
        private TreeSet<Integer> b;

        protected abstract String a();

        private c() {
        }

        /* synthetic */ c(y yVar) {
            this();
        }

        private static HashSet<String> c() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
            hashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
            hashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
            return hashSet;
        }

        public boolean a(Context context, String str) {
            String str2 = Build.BRAND;
            int i = context.getApplicationInfo().flags;
            if (str2.startsWith("generic") && (i & 2) != 0) {
                return true;
            }
            try {
                for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                    if (f277a.contains(Utility.sha1hash(signature.toByteArray()))) {
                        return true;
                    }
                }
                return false;
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            }
        }

        public TreeSet<Integer> b() {
            if (this.b == null) {
                a(false);
            }
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0005, code lost:            if (r1.b == null) goto L6;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized void a(boolean r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                if (r2 != 0) goto L7
                java.util.TreeSet<java.lang.Integer> r0 = r1.b     // Catch: java.lang.Throwable -> Lf
                if (r0 != 0) goto Ld
            L7:
                java.util.TreeSet r0 = com.facebook.internal.NativeProtocol.access$000(r1)     // Catch: java.lang.Throwable -> Lf
                r1.b = r0     // Catch: java.lang.Throwable -> Lf
            Ld:
                monitor-exit(r1)
                return
            Lf:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.c.a(boolean):void");
        }
    }

    /* loaded from: classes.dex */
    private static class a extends c {
        private a() {
            super(null);
        }

        /* synthetic */ a(y yVar) {
            this();
        }

        @Override // com.facebook.internal.NativeProtocol.c
        protected String a() {
            return "com.facebook.katana";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends c {
        private b() {
            super(null);
        }

        /* synthetic */ b(y yVar) {
            this();
        }

        @Override // com.facebook.internal.NativeProtocol.c
        protected String a() {
            return MessengerUtils.PACKAGE_NAME;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {
        private d() {
            super(null);
        }

        /* synthetic */ d(y yVar) {
            this();
        }

        @Override // com.facebook.internal.NativeProtocol.c
        protected String a() {
            return "com.facebook.wakizashi";
        }
    }

    private static List<c> buildFacebookAppList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FACEBOOK_APP_INFO);
        arrayList.add(new d(null));
        return arrayList;
    }

    private static Map<String, List<c>> buildActionToAppInfoMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(null));
        hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_FEED_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_LIKE_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_APPINVITE_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_MESSAGE_DIALOG, arrayList);
        hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
        return hashMap;
    }

    static Intent validateActivityIntent(Context context, Intent intent, c cVar) {
        ResolveInfo resolveActivity;
        if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null || !cVar.a(context, resolveActivity.activityInfo.packageName)) {
            return null;
        }
        return intent;
    }

    static Intent validateServiceIntent(Context context, Intent intent, c cVar) {
        ResolveInfo resolveService;
        if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null || !cVar.a(context, resolveService.serviceInfo.packageName)) {
            return null;
        }
        return intent;
    }

    public static Intent createProxyAuthIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience) {
        for (c cVar : facebookAppInfoList) {
            Intent putExtra = new Intent().setClassName(cVar.a(), FACEBOOK_PROXY_AUTH_ACTIVITY).putExtra("client_id", str);
            if (!Utility.isNullOrEmpty(collection)) {
                putExtra.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!Utility.isNullOrEmpty(str2)) {
                putExtra.putExtra("e2e", str2);
            }
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            if (z2) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, defaultAudience.getNativeProtocolAudience());
            }
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, ServerProtocol.GRAPH_API_VERSION);
            if (z) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE);
            }
            Intent validateActivityIntent = validateActivityIntent(context, putExtra, cVar);
            if (validateActivityIntent != null) {
                return validateActivityIntent;
            }
        }
        return null;
    }

    public static Intent createTokenRefreshIntent(Context context) {
        for (c cVar : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent().setClassName(cVar.a(), FACEBOOK_TOKEN_REFRESH_ACTIVITY), cVar);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }

    public static final int getLatestKnownVersion() {
        return KNOWN_PROTOCOL_VERSIONS.get(0).intValue();
    }

    private static Intent findActivityIntent(Context context, String str, String str2) {
        List<c> list = actionToAppInfoMap.get(str2);
        if (list == null) {
            return null;
        }
        Intent intent = null;
        for (c cVar : list) {
            intent = validateActivityIntent(context, new Intent().setAction(str).setPackage(cVar.a()).addCategory("android.intent.category.DEFAULT"), cVar);
            if (intent != null) {
                return intent;
            }
        }
        return intent;
    }

    public static boolean isVersionCompatibleWithBucketedIntent(int i) {
        return KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(i)) && i >= 20140701;
    }

    public static Intent createPlatformActivityIntent(Context context, String str, String str2, int i, Bundle bundle) {
        Intent findActivityIntent = findActivityIntent(context, INTENT_ACTION_PLATFORM_ACTIVITY, str2);
        if (findActivityIntent == null) {
            return null;
        }
        setupProtocolRequestIntent(findActivityIntent, str, str2, i, bundle);
        return findActivityIntent;
    }

    public static void setupProtocolRequestIntent(Intent intent, String str, String str2, int i, Bundle bundle) {
        String applicationId = FacebookSdk.getApplicationId();
        String applicationName = FacebookSdk.getApplicationName();
        intent.putExtra(EXTRA_PROTOCOL_VERSION, i).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
        if (isVersionCompatibleWithBucketedIntent(i)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", str);
            Utility.putNonEmptyString(bundle2, BRIDGE_ARG_APP_NAME_STRING, applicationName);
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
            return;
        }
        intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
        if (!Utility.isNullOrEmpty(applicationName)) {
            intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
        }
        intent.putExtras(bundle);
    }

    public static Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookException) {
        UUID callIdFromIntent = getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", callIdFromIntent.toString());
        if (facebookException != null) {
            bundle2.putBundle("error", createBundleForException(facebookException));
        }
        intent2.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
        if (bundle != null) {
            intent2.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
            return intent2;
        }
        return intent2;
    }

    public static Intent createPlatformServiceIntent(Context context) {
        for (c cVar : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(cVar.a()).addCategory("android.intent.category.DEFAULT"), cVar);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }

    public static int getProtocolVersionFromIntent(Intent intent) {
        return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
    }

    public static UUID getCallIdFromIntent(Intent intent) {
        String stringExtra;
        if (intent == null) {
            return null;
        }
        if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
            stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
        } else {
            stringExtra = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
        }
        if (stringExtra == null) {
            return null;
        }
        try {
            return UUID.fromString(stringExtra);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static Bundle getBridgeArgumentsFromIntent(Intent intent) {
        if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            return intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
        }
        return null;
    }

    public static Bundle getMethodArgumentsFromIntent(Intent intent) {
        return !isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent)) ? intent.getExtras() : intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
    }

    public static Bundle getSuccessResultsFromIntent(Intent intent) {
        int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
        Bundle extras = intent.getExtras();
        return (!isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) || extras == null) ? extras : extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
    }

    public static boolean isErrorResult(Intent intent) {
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        return bridgeArgumentsFromIntent != null ? bridgeArgumentsFromIntent.containsKey("error") : intent.hasExtra(STATUS_ERROR_TYPE);
    }

    public static Bundle getErrorDataFromResultIntent(Intent intent) {
        if (!isErrorResult(intent)) {
            return null;
        }
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent != null) {
            return bridgeArgumentsFromIntent.getBundle("error");
        }
        return intent.getExtras();
    }

    public static FacebookException getExceptionFromErrorData(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(BRIDGE_ARG_ERROR_TYPE);
        if (string == null) {
            string = bundle.getString(STATUS_ERROR_TYPE);
        }
        String string2 = bundle.getString(BRIDGE_ARG_ERROR_DESCRIPTION);
        if (string2 == null) {
            string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
        }
        if (string != null && string.equalsIgnoreCase(ERROR_USER_CANCELED)) {
            return new FacebookOperationCanceledException(string2);
        }
        return new FacebookException(string2);
    }

    public static Bundle createBundleForException(FacebookException facebookException) {
        if (facebookException == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(BRIDGE_ARG_ERROR_DESCRIPTION, facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException) {
            bundle.putString(BRIDGE_ARG_ERROR_TYPE, ERROR_USER_CANCELED);
            return bundle;
        }
        return bundle;
    }

    public static int getLatestAvailableProtocolVersionForService(int i) {
        return getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i});
    }

    public static int getLatestAvailableProtocolVersionForAction(String str, int[] iArr) {
        return getLatestAvailableProtocolVersionForAppInfoList(actionToAppInfoMap.get(str), iArr);
    }

    private static int getLatestAvailableProtocolVersionForAppInfoList(List<c> list, int[] iArr) {
        updateAllAvailableProtocolVersionsAsync();
        if (list == null) {
            return -1;
        }
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(it.next().b(), getLatestKnownVersion(), iArr);
            if (computeLatestAvailableVersionFromVersionSpec != -1) {
                return computeLatestAvailableVersionFromVersionSpec;
            }
        }
        return -1;
    }

    public static void updateAllAvailableProtocolVersionsAsync() {
        if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
            FacebookSdk.getExecutor().execute(new y());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TreeSet<Integer> fetchAllAvailableProtocolVersionsForAppInfo(c cVar) {
        Cursor cursor;
        Cursor cursor2 = null;
        TreeSet<Integer> treeSet = new TreeSet<>();
        ContentResolver contentResolver = FacebookSdk.getApplicationContext().getContentResolver();
        String[] strArr = {"version"};
        Uri buildPlatformProviderVersionURI = buildPlatformProviderVersionURI(cVar);
        try {
            if (FacebookSdk.getApplicationContext().getPackageManager().resolveContentProvider(cVar.a() + PLATFORM_PROVIDER, 0) != null) {
                cursor = contentResolver.query(buildPlatformProviderVersionURI, strArr, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            treeSet.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("version"))));
                        } catch (Throwable th) {
                            cursor2 = cursor;
                            th = th;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    }
                }
            } else {
                cursor = null;
            }
            if (cursor != null) {
                cursor.close();
            }
            return treeSet;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> treeSet, int i, int[] iArr) {
        int length = iArr.length - 1;
        Iterator<Integer> descendingIterator = treeSet.descendingIterator();
        int i2 = -1;
        int i3 = length;
        while (descendingIterator.hasNext()) {
            int intValue = descendingIterator.next().intValue();
            int max = Math.max(i2, intValue);
            int i4 = i3;
            while (i4 >= 0 && iArr[i4] > intValue) {
                i4--;
            }
            if (i4 < 0) {
                return -1;
            }
            if (iArr[i4] == intValue) {
                if (i4 % 2 == 0) {
                    return Math.min(max, i);
                }
                return -1;
            }
            i3 = i4;
            i2 = max;
        }
        return -1;
    }

    private static Uri buildPlatformProviderVersionURI(c cVar) {
        return Uri.parse(CONTENT_SCHEME + cVar.a() + PLATFORM_PROVIDER_VERSIONS);
    }
}

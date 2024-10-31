package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.share.internal.ShareConstants;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
public final class Utility {
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
    private static final String DIALOG_CONFIG_NAME_KEY = "name";
    private static final String DIALOG_CONFIG_URL_KEY = "url";
    private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final int GINGERBREAD_MR1 = 10;
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    static final String LOG_TAG = "FacebookSDK";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
    private static final String[] APP_SETTING_FIELDS = {APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, APP_SETTING_NUX_CONTENT, APP_SETTING_NUX_ENABLED, APP_SETTING_DIALOG_CONFIGS, APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES};
    private static Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    private static AtomicBoolean loadingSettings = new AtomicBoolean(false);
    private static int numCPUCores = 0;
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;
    private static long availableExternalStorageGB = -1;
    private static String deviceTimezone = "";
    private static final String noCarrierConstant = "NoCarrier";
    private static String carrierName = noCarrierConstant;

    /* loaded from: classes.dex */
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    /* loaded from: classes.dex */
    public interface Mapper<T, K> {
        K apply(T t);
    }

    /* loaded from: classes.dex */
    public interface Predicate<T> {
        boolean apply(T t);
    }

    /* loaded from: classes.dex */
    public static class FetchedAppSettings {
        private Map<String, Map<String, DialogFeatureConfig>> dialogConfigMap;
        private FacebookRequestErrorClassification errorClassification;
        private String nuxContent;
        private boolean nuxEnabled;
        private boolean supportsImplicitLogging;

        /* synthetic */ FetchedAppSettings(boolean z, String str, boolean z2, Map map, FacebookRequestErrorClassification facebookRequestErrorClassification, ac acVar) {
            this(z, str, z2, map, facebookRequestErrorClassification);
        }

        private FetchedAppSettings(boolean z, String str, boolean z2, Map<String, Map<String, DialogFeatureConfig>> map, FacebookRequestErrorClassification facebookRequestErrorClassification) {
            this.supportsImplicitLogging = z;
            this.nuxContent = str;
            this.nuxEnabled = z2;
            this.dialogConfigMap = map;
            this.errorClassification = facebookRequestErrorClassification;
        }

        public boolean supportsImplicitLogging() {
            return this.supportsImplicitLogging;
        }

        public String getNuxContent() {
            return this.nuxContent;
        }

        public boolean getNuxEnabled() {
            return this.nuxEnabled;
        }

        public Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
            return this.dialogConfigMap;
        }

        public FacebookRequestErrorClassification getErrorClassification() {
            return this.errorClassification;
        }
    }

    /* loaded from: classes.dex */
    public static class DialogFeatureConfig {
        private String dialogName;
        private Uri fallbackUrl;
        private String featureName;
        private int[] featureVersionSpec;

        /* JADX INFO: Access modifiers changed from: private */
        public static DialogFeatureConfig parseDialogConfig(JSONObject jSONObject) {
            String optString = jSONObject.optString("name");
            if (Utility.isNullOrEmpty(optString)) {
                return null;
            }
            String[] split = optString.split(Utility.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR);
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            String str2 = split[1];
            if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                return null;
            }
            String optString2 = jSONObject.optString("url");
            return new DialogFeatureConfig(str, str2, Utility.isNullOrEmpty(optString2) ? null : Uri.parse(optString2), parseVersionSpec(jSONObject.optJSONArray(Utility.DIALOG_CONFIG_VERSIONS_KEY)));
        }

        private static int[] parseVersionSpec(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                int optInt = jSONArray.optInt(i, -1);
                if (optInt == -1) {
                    String optString = jSONArray.optString(i);
                    if (!Utility.isNullOrEmpty(optString)) {
                        try {
                            optInt = Integer.parseInt(optString);
                        } catch (NumberFormatException e) {
                            Utility.logd(Utility.LOG_TAG, e);
                            optInt = -1;
                        }
                    }
                }
                iArr[i] = optInt;
            }
            return iArr;
        }

        private DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.featureVersionSpec = iArr;
        }

        public String getDialogName() {
            return this.dialogName;
        }

        public String getFeatureName() {
            return this.featureName;
        }

        public Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        public int[] getVersionSpec() {
            return this.featureVersionSpec;
        }
    }

    public static int[] intersectRanges(int[] iArr, int[] iArr2) {
        int i = 0;
        if (iArr != null) {
            if (iArr2 == null) {
                return iArr;
            }
            int[] iArr3 = new int[iArr.length + iArr2.length];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= iArr.length || i >= iArr2.length) {
                    break;
                }
                int i4 = iArr[i2];
                int i5 = iArr2[i];
                int i6 = i2 < iArr.length + (-1) ? iArr[i2 + 1] : Integer.MAX_VALUE;
                int i7 = i < iArr2.length + (-1) ? iArr2[i + 1] : Integer.MAX_VALUE;
                if (i4 < i5) {
                    if (i6 > i5) {
                        if (i6 > i7) {
                            i += 2;
                        } else {
                            i2 += 2;
                            i7 = i6;
                        }
                    } else {
                        i2 += 2;
                        i7 = Integer.MAX_VALUE;
                        i5 = Integer.MIN_VALUE;
                    }
                } else if (i7 > i4) {
                    if (i7 > i6) {
                        i2 += 2;
                        i7 = i6;
                        i5 = i4;
                    } else {
                        i += 2;
                        i5 = i4;
                    }
                } else {
                    i += 2;
                    i7 = Integer.MAX_VALUE;
                    i5 = Integer.MIN_VALUE;
                }
                if (i5 != Integer.MIN_VALUE) {
                    int i8 = i3 + 1;
                    iArr3[i3] = i5;
                    if (i7 == Integer.MAX_VALUE) {
                        i3 = i8;
                        break;
                    }
                    i3 = i8 + 1;
                    iArr3[i8] = i7;
                }
            }
            return Arrays.copyOf(iArr3, i3);
        }
        return iArr2;
    }

    public static <T> boolean isSubset(Collection<T> collection, Collection<T> collection2) {
        if (collection2 == null || collection2.size() == 0) {
            return collection == null || collection.size() == 0;
        }
        HashSet hashSet = new HashSet(collection2);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean isNullOrEmpty(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    public static <T> Collection<T> unmodifiableCollection(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
    }

    public static <T> ArrayList<T> arrayList(T... tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    public static <T> HashSet<T> hashSet(T... tArr) {
        HashSet<T> hashSet = new HashSet<>(tArr.length);
        for (T t : tArr) {
            hashSet.add(t);
        }
        return hashSet;
    }

    public static String md5hash(String str) {
        return hashWithAlgorithm(HASH_ALGORITHM_MD5, str);
    }

    public static String sha1hash(String str) {
        return hashWithAlgorithm(HASH_ALGORITHM_SHA1, str);
    }

    public static String sha1hash(byte[] bArr) {
        return hashWithAlgorithm(HASH_ALGORITHM_SHA1, bArr);
    }

    private static String hashWithAlgorithm(String str, String str2) {
        return hashWithAlgorithm(str, str2.getBytes());
    }

    private static String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            return hashBytes(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString((b >> 0) & 15));
        }
        return sb.toString();
    }

    public static Uri buildUri(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(URL_SCHEME);
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        return builder.build();
    }

    public static Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    } else if (split.length == 1) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e) {
                    logd(LOG_TAG, e);
                }
            }
        }
        return bundle;
    }

    public static void putNonEmptyString(Bundle bundle, String str, String str2) {
        if (!isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    public static void putCommaSeparatedStringList(Bundle bundle, String str, List<String> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            String str2 = "";
            if (sb.length() > 0) {
                str2 = sb.substring(0, sb.length() - 1);
            }
            bundle.putString(str, str2);
        }
    }

    public static void putUri(Bundle bundle, String str, Uri uri) {
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    public static boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        if (obj == null) {
            bundle.remove(str);
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, ((JSONArray) obj).toString());
        } else if (obj instanceof JSONObject) {
            bundle.putString(str, ((JSONObject) obj).toString());
        } else {
            return false;
        }
        return true;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static String getMetadataApplicationId(Context context) {
        Validate.notNull(context, "context");
        FacebookSdk.sdkInitialize(context);
        return FacebookSdk.getApplicationId();
    }

    static Map<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < names.length()) {
                try {
                    String string = names.getString(i2);
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = convertJSONObjectToHashMap((JSONObject) obj);
                    }
                    hashMap.put(string, obj);
                } catch (JSONException e) {
                }
                i = i2 + 1;
            } else {
                return hashMap;
            }
        }
    }

    public static Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) throws JSONException {
        Object opt = jSONObject.opt(str);
        Object nextValue = (opt == null || !(opt instanceof String)) ? opt : new JSONTokener((String) opt).nextValue();
        if (nextValue == null || (nextValue instanceof JSONObject) || (nextValue instanceof JSONArray)) {
            return nextValue;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, nextValue);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    public static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
                bufferedInputStream2 = bufferedInputStream;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[2048];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read != -1) {
                    sb.append(cArr, 0, read);
                } else {
                    String sb2 = sb.toString();
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    return sb2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            closeQuietly(bufferedInputStream2);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    public static int copyAndCloseInputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        int i = 0;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[DEFAULT_STREAM_BUFFER_SIZE];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i += read;
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static boolean stringsEqualOrEmpty(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty && isEmpty2) {
            return true;
        }
        if (!isEmpty && !isEmpty2) {
            return str.equals(str2);
        }
        return false;
    }

    private static void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie != null) {
            String[] split = cookie.split(";");
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length > 0) {
                    cookieManager.setCookie(str, split2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                }
            }
            cookieManager.removeExpiredCookie();
        }
    }

    public static void clearFacebookCookies(Context context) {
        clearCookiesForDomain(context, "facebook.com");
        clearCookiesForDomain(context, ".facebook.com");
        clearCookiesForDomain(context, "https://facebook.com");
        clearCookiesForDomain(context, "https://.facebook.com");
    }

    public static void logd(String str, Exception exc) {
        if (FacebookSdk.isDebugEnabled() && str != null && exc != null) {
            Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
        }
    }

    public static void logd(String str, String str2) {
        if (FacebookSdk.isDebugEnabled() && str != null && str2 != null) {
            Log.d(str, str2);
        }
    }

    public static void logd(String str, String str2, Throwable th) {
        if (FacebookSdk.isDebugEnabled() && !isNullOrEmpty(str)) {
            Log.d(str, str2, th);
        }
    }

    public static <T> boolean areObjectsEqual(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return t.equals(t2);
    }

    public static boolean hasSameId(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || !jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_ID) || !jSONObject2.has(ShareConstants.WEB_DIALOG_PARAM_ID)) {
            return false;
        }
        if (jSONObject.equals(jSONObject2)) {
            return true;
        }
        String optString = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
        String optString2 = jSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
        if (optString == null || optString2 == null) {
            return false;
        }
        return optString.equals(optString2);
    }

    public static void loadAppSettingsAsync(Context context, String str) {
        boolean compareAndSet = loadingSettings.compareAndSet(false, true);
        if (!isNullOrEmpty(str) && !fetchedAppSettings.containsKey(str) && compareAndSet) {
            FacebookSdk.getExecutor().execute(new ac(context, String.format(APP_SETTINGS_PREFS_KEY_FORMAT, str), str));
        }
    }

    public static FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        if (str != null) {
            return fetchedAppSettings.get(str);
        }
        return null;
    }

    public static FetchedAppSettings queryAppSettings(String str, boolean z) {
        if (!z && fetchedAppSettings.containsKey(str)) {
            return fetchedAppSettings.get(str);
        }
        JSONObject appSettingsQueryResponse = getAppSettingsQueryResponse(str);
        if (appSettingsQueryResponse == null) {
            return null;
        }
        return parseAppSettingsFromJSON(str, appSettingsQueryResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FetchedAppSettings parseAppSettingsFromJSON(String str, JSONObject jSONObject) {
        FacebookRequestErrorClassification createFromJSON;
        JSONArray optJSONArray = jSONObject.optJSONArray(APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES);
        if (optJSONArray == null) {
            createFromJSON = FacebookRequestErrorClassification.getDefaultErrorClassification();
        } else {
            createFromJSON = FacebookRequestErrorClassification.createFromJSON(optJSONArray);
        }
        FetchedAppSettings fetchedAppSettings2 = new FetchedAppSettings(jSONObject.optBoolean(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, false), jSONObject.optString(APP_SETTING_NUX_CONTENT, ""), jSONObject.optBoolean(APP_SETTING_NUX_ENABLED, false), parseDialogConfigurations(jSONObject.optJSONObject(APP_SETTING_DIALOG_CONFIGS)), createFromJSON, null);
        fetchedAppSettings.put(str, fetchedAppSettings2);
        return fetchedAppSettings2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject getAppSettingsQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", APP_SETTING_FIELDS));
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, str, null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest.executeAndWait().getJSONObject();
    }

    public static DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
        Map<String, DialogFeatureConfig> map;
        if (isNullOrEmpty(str2) || isNullOrEmpty(str3)) {
            return null;
        }
        FetchedAppSettings fetchedAppSettings2 = fetchedAppSettings.get(str);
        if (fetchedAppSettings2 == null || (map = fetchedAppSettings2.getDialogConfigurations().get(str2)) == null) {
            return null;
        }
        return map.get(str3);
    }

    private static Map<String, Map<String, DialogFeatureConfig>> parseDialogConfigurations(JSONObject jSONObject) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA)) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                DialogFeatureConfig parseDialogConfig = DialogFeatureConfig.parseDialogConfig(optJSONArray.optJSONObject(i2));
                if (parseDialogConfig != null) {
                    String dialogName = parseDialogConfig.getDialogName();
                    Map map = (Map) hashMap.get(dialogName);
                    if (map == null) {
                        map = new HashMap();
                        hashMap.put(dialogName, map);
                    }
                    map.put(parseDialogConfig.getFeatureName(), parseDialogConfig);
                }
                i = i2 + 1;
            }
        }
        return hashMap;
    }

    public static String safeGetStringFromResponse(JSONObject jSONObject, String str) {
        return jSONObject != null ? jSONObject.optString(str, "") : "";
    }

    public static JSONObject tryGetJSONObjectFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    public static JSONArray tryGetJSONArrayFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    public static void clearCaches(Context context) {
        ImageDownloader.clearCache(context);
    }

    public static void deleteDirectory(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteDirectory(file2);
                }
            }
            file.delete();
        }
    }

    public static <T> List<T> asListNoNulls(T... tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static List<String> jsonArrayToStringList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static Set<String> jsonArrayToSet(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        return hashSet;
    }

    public static void setAppEventAttributionParameters(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z) throws JSONException {
        if (attributionIdentifiers != null && attributionIdentifiers.getAttributionId() != null) {
            jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
        }
        if (attributionIdentifiers != null && attributionIdentifiers.getAndroidAdvertiserId() != null) {
            jSONObject.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
            jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
        }
        if (attributionIdentifiers != null && attributionIdentifiers.getAndroidInstallerPackage() != null) {
            jSONObject.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
        }
        jSONObject.put("anon_id", str);
        jSONObject.put("application_tracking_enabled", z ? false : true);
    }

    public static void setAppEventExtendedDeviceInfoParameters(JSONObject jSONObject, Context context) throws JSONException {
        Locale locale;
        int i;
        int i2;
        int i3;
        int i4;
        double d;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i5 = -1;
        String str = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i5 = packageInfo.versionCode;
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        jSONArray.put(packageName);
        jSONArray.put(i5);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception e2) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + "_" + locale.getCountry());
        jSONArray.put(deviceTimezone);
        jSONArray.put(carrierName);
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                d = 0.0d;
                i3 = 0;
                i4 = 0;
            } else {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                int i6 = displayMetrics.widthPixels;
                try {
                    int i7 = displayMetrics.heightPixels;
                    try {
                        d = displayMetrics.density;
                        i3 = i7;
                        i4 = i6;
                    } catch (Exception e3) {
                        i = i7;
                        i2 = i6;
                        i3 = i;
                        i4 = i2;
                        d = 0.0d;
                        jSONArray.put(i4);
                        jSONArray.put(i3);
                        jSONArray.put(String.format("%.2f", Double.valueOf(d)));
                        jSONArray.put(refreshBestGuessNumberOfCPUCores());
                        jSONArray.put(totalExternalStorageGB);
                        jSONArray.put(availableExternalStorageGB);
                        jSONObject.put("extinfo", jSONArray.toString());
                    }
                } catch (Exception e4) {
                    i = 0;
                    i2 = i6;
                }
            }
        } catch (Exception e5) {
            i = 0;
            i2 = 0;
        }
        jSONArray.put(i4);
        jSONArray.put(i3);
        jSONArray.put(String.format("%.2f", Double.valueOf(d)));
        jSONArray.put(refreshBestGuessNumberOfCPUCores());
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    public static Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        try {
            return getMethodQuietly(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e2) {
            return null;
        }
    }

    public static String getActivityName(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        return context.getClass().getSimpleName();
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (predicate.apply(t)) {
                arrayList.add(t);
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        return null;
    }

    public static <T, K> List<K> map(List<T> list, Mapper<T, K> mapper) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            K apply = mapper.apply(it.next());
            if (apply != null) {
                arrayList.add(apply);
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        return null;
    }

    public static String getUriString(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public static boolean isWebUri(Uri uri) {
        return uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || URL_SCHEME.equalsIgnoreCase(uri.getScheme()));
    }

    public static boolean isContentUri(Uri uri) {
        return uri != null && "content".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean isFileUri(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    public static long getContentSize(Uri uri) {
        Cursor cursor;
        try {
            cursor = FacebookSdk.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            try {
                int columnIndex = cursor.getColumnIndex("_size");
                cursor.moveToFirst();
                long j = cursor.getLong(columnIndex);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public static Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        long parseLong;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            parseLong = ((Long) obj).longValue();
        } else {
            if (!(obj instanceof String)) {
                return null;
            }
            try {
                parseLong = Long.parseLong((String) obj);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (parseLong == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date((parseLong * 1000) + date.getTime());
    }

    public static void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    public static Map<String, String> readStringMapFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    public static boolean isCurrentAccessToken(AccessToken accessToken) {
        if (accessToken != null) {
            return accessToken.equals(AccessToken.getCurrentAccessToken());
        }
        return false;
    }

    public static void getGraphMeRequestWithCacheAsync(String str, GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        JSONObject a2 = aa.a(str);
        if (a2 != null) {
            graphMeRequestWithCacheCallback.onSuccess(a2);
            return;
        }
        ad adVar = new ad(graphMeRequestWithCacheCallback, str);
        GraphRequest graphMeRequestWithCache = getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(adVar);
        graphMeRequestWithCache.executeAsync();
    }

    public static JSONObject awaitGetGraphMeRequestWithCache(String str) {
        JSONObject a2 = aa.a(str);
        if (a2 == null) {
            GraphResponse executeAndWait = getGraphMeRequestWithCache(str).executeAndWait();
            if (executeAndWait.getError() != null) {
                return null;
            }
            return executeAndWait.getJSONObject();
        }
        return a2;
    }

    private static GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        return new GraphRequest(null, "me", bundle, HttpMethod.GET, null);
    }

    private static int refreshBestGuessNumberOfCPUCores() {
        if (numCPUCores > 0) {
            return numCPUCores;
        }
        try {
            numCPUCores = new File("/sys/devices/system/cpu/").listFiles(new ae()).length;
        } catch (Exception e) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    private static void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private static void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            deviceTimezone = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
        } catch (Exception e) {
        }
    }

    private static void refreshCarrierName(Context context) {
        if (carrierName.equals(noCarrierConstant)) {
            try {
                carrierName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception e) {
            }
        }
    }

    private static boolean externalStorageExists() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
            availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
        } catch (Exception e) {
        }
    }

    private static void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = statFs.getBlockSize() * statFs.getBlockCount();
            }
            totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
        } catch (Exception e) {
        }
    }

    private static long convertBytesToGB(double d) {
        return Math.round(d / 1.073741824E9d);
    }
}

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
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.marketing.internal.Constants;
import com.facebook.places.model.PlaceFields;
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
import java.math.BigInteger;
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
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final int GINGERBREAD_MR1 = 10;
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    static final String LOG_TAG = "FacebookSDK";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static long availableExternalStorageGB = -1;
    private static String carrierName = "NoCarrier";
    private static String deviceTimeZoneName = "";
    private static String deviceTimezoneAbbreviation = "";
    private static final String noCarrierConstant = "NoCarrier";
    private static int numCPUCores = 0;
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;

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
    public static class PermissionsPair {
        List<String> declinedPermissions;
        List<String> grantedPermissions;

        public PermissionsPair(List<String> list, List<String> list2) {
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
        }

        public List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        public List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }
    }

    /* loaded from: classes.dex */
    public interface Predicate<T> {
        boolean apply(T t);
    }

    public static <T> boolean areObjectsEqual(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return t.equals(t2);
    }

    public static <T> ArrayList<T> arrayList(T... tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
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

    public static JSONObject awaitGetGraphMeRequestWithCache(String str) {
        JSONObject a2 = B.a(str);
        if (a2 != null) {
            return a2;
        }
        GraphResponse executeAndWait = getGraphMeRequestWithCache(str).executeAndWait();
        if (executeAndWait.getError() != null) {
            return null;
        }
        return executeAndWait.getJSONObject();
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

    public static void clearCaches(Context context) {
        ImageDownloader.clearCache(context);
    }

    private static void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        for (String str2 : cookie.split(";")) {
            String[] split = str2.split("=");
            if (split.length > 0) {
                cookieManager.setCookie(str, split[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
        }
        cookieManager.removeExpiredCookie();
    }

    public static void clearFacebookCookies(Context context) {
        clearCookiesForDomain(context, "facebook.com");
        clearCookiesForDomain(context, ".facebook.com");
        clearCookiesForDomain(context, "https://facebook.com");
        clearCookiesForDomain(context, "https://.facebook.com");
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    private static long convertBytesToGB(double d2) {
        return Math.round(d2 / 1.073741824E9d);
    }

    static Map<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        for (int i = 0; i < names.length(); i++) {
            try {
                String string = names.getString(i);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    obj = convertJSONObjectToHashMap((JSONObject) obj);
                }
                hashMap.put(string, obj);
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    public static int copyAndCloseInputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            int i = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i += read;
            }
            bufferedInputStream.close();
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

    public static void deleteDirectory(File file) {
        File[] listFiles;
        if (file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    deleteDirectory(file2);
                }
            }
            file.delete();
        }
    }

    public static void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    private static boolean externalStorageExists() {
        return "mounted".equals(Environment.getExternalStorageState());
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
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public static String generateRandomString(int i) {
        return new BigInteger(i * 5, new Random()).toString(32);
    }

    public static String getActivityName(Context context) {
        return context == null ? "null" : context == context.getApplicationContext() ? "unknown" : context.getClass().getSimpleName();
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
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        if (parseLong == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + (parseLong * 1000));
    }

    public static long getContentSize(Uri uri) {
        Cursor cursor = null;
        try {
            cursor = FacebookSdk.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            return cursor.getLong(columnIndex);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static Locale getCurrentLocale() {
        try {
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return Locale.getDefault();
        }
    }

    private static GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        return new GraphRequest(null, "me", bundle, HttpMethod.GET, null);
    }

    public static void getGraphMeRequestWithCacheAsync(String str, GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        JSONObject a2 = B.a(str);
        if (a2 != null) {
            graphMeRequestWithCacheCallback.onSuccess(a2);
            return;
        }
        D d2 = new D(graphMeRequestWithCacheCallback, str);
        GraphRequest graphMeRequestWithCache = getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(d2);
        graphMeRequestWithCache.executeAsync();
    }

    public static String getMetadataApplicationId(Context context) {
        Validate.notNull(context, com.umeng.analytics.pro.b.Q);
        FacebookSdk.sdkInitialize(context);
        return FacebookSdk.getApplicationId();
    }

    public static Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) throws JSONException {
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    public static String getUriString(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public static PermissionsPair handlePermissionResponse(JSONObject jSONObject) throws JSONException {
        String optString;
        JSONArray jSONArray = jSONObject.getJSONObject(NativeProtocol.RESULT_ARGS_PERMISSIONS).getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString2 = optJSONObject.optString("permission");
            if (optString2 != null && !optString2.equals("installed") && (optString = optJSONObject.optString("status")) != null) {
                if (optString.equals("granted")) {
                    arrayList.add(optString2);
                } else if (optString.equals("declined")) {
                    arrayList2.add(optString2);
                }
            }
        }
        return new PermissionsPair(arrayList, arrayList2);
    }

    public static boolean hasSameId(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.has("id") && jSONObject2.has("id")) {
            if (jSONObject.equals(jSONObject2)) {
                return true;
            }
            String optString = jSONObject.optString("id");
            String optString2 = jSONObject2.optString("id");
            if (optString != null && optString2 != null) {
                return optString.equals(optString2);
            }
        }
        return false;
    }

    private static String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b2 : digest) {
            sb.append(Integer.toHexString((b2 >> 4) & 15));
            sb.append(Integer.toHexString((b2 >> 0) & 15));
        }
        return sb.toString();
    }

    public static <T> HashSet<T> hashSet(T... tArr) {
        HashSet<T> hashSet = new HashSet<>(tArr.length);
        for (T t : tArr) {
            hashSet.add(t);
        }
        return hashSet;
    }

    private static String hashWithAlgorithm(String str, String str2) {
        return hashWithAlgorithm(str, str2.getBytes());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x000e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] intersectRanges(int[] r10, int[] r11) {
        /*
            if (r10 != 0) goto L3
            return r11
        L3:
            if (r11 != 0) goto L6
            return r10
        L6:
            int r0 = r10.length
            int r1 = r11.length
            int r0 = r0 + r1
            int[] r0 = new int[r0]
            r1 = 0
            r2 = 0
            r3 = 0
        Le:
            int r4 = r10.length
            if (r1 >= r4) goto L68
            int r4 = r11.length
            if (r2 >= r4) goto L68
            r4 = r10[r1]
            r5 = r11[r2]
            int r6 = r10.length
            int r6 = r6 + (-1)
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r6) goto L25
            int r6 = r1 + 1
            r6 = r10[r6]
            goto L28
        L25:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L28:
            int r8 = r11.length
            int r8 = r8 + (-1)
            if (r2 >= r8) goto L32
            int r8 = r2 + 1
            r8 = r11[r8]
            goto L35
        L32:
            r8 = 2147483647(0x7fffffff, float:NaN)
        L35:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 >= r5) goto L48
            if (r6 <= r5) goto L45
            if (r6 <= r8) goto L41
            int r2 = r2 + 2
            r4 = r5
            goto L51
        L41:
            int r1 = r1 + 2
            r4 = r5
            goto L5a
        L45:
            int r1 = r1 + 2
            goto L55
        L48:
            if (r8 <= r4) goto L53
            if (r8 <= r6) goto L4f
            int r1 = r1 + 2
            goto L5a
        L4f:
            int r2 = r2 + 2
        L51:
            r6 = r8
            goto L5a
        L53:
            int r2 = r2 + 2
        L55:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 2147483647(0x7fffffff, float:NaN)
        L5a:
            if (r4 == r9) goto Le
            int r5 = r3 + 1
            r0[r3] = r4
            if (r6 == r7) goto L67
            int r3 = r5 + 1
            r0[r5] = r6
            goto Le
        L67:
            r3 = r5
        L68:
            int[] r10 = java.util.Arrays.copyOf(r0, r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.intersectRanges(int[], int[]):int[]");
    }

    public static Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean isAutofillAvailable(Context context) {
        AutofillManager autofillManager;
        return Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    public static boolean isChromeOS(Context context) {
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        return str != null && str.matches(ARC_DEVICE_PATTERN);
    }

    public static boolean isContentUri(Uri uri) {
        return uri != null && "content".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean isCurrentAccessToken(AccessToken accessToken) {
        return accessToken != null && accessToken.equals(AccessToken.getCurrentAccessToken());
    }

    public static boolean isFileUri(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    public static <T> boolean isNullOrEmpty(Collection<T> collection) {
        return collection == null || collection.size() == 0;
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

    public static boolean isWebUri(Uri uri) {
        return uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || URL_SCHEME.equalsIgnoreCase(uri.getScheme()) || "fbstaging".equalsIgnoreCase(uri.getScheme()));
    }

    public static Set<String> jsonArrayToSet(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        return hashSet;
    }

    public static List<String> jsonArrayToStringList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static void logd(String str, Exception exc) {
        if (!FacebookSdk.isDebugEnabled() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
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
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public static String md5hash(String str) {
        return hashWithAlgorithm(HASH_ALGORITHM_MD5, str);
    }

    public static boolean mustFixWindowParamsForAutofill(Context context) {
        return isAutofillAvailable(context);
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
                } catch (UnsupportedEncodingException e2) {
                    logd(LOG_TAG, e2);
                }
            }
        }
        return bundle;
    }

    public static void putCommaSeparatedStringList(Bundle bundle, String str, List<String> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            bundle.putString(str, sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "");
        }
    }

    public static boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        if (obj == null) {
            bundle.remove(str);
            return true;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        }
        if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return true;
        }
        if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return true;
        }
        if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return true;
        }
        if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        }
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        }
        if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
            return true;
        }
        if (!(obj instanceof JSONObject)) {
            return false;
        }
        bundle.putString(str, obj.toString());
        return true;
    }

    public static void putNonEmptyString(Bundle bundle, String str, String str2) {
        if (isNullOrEmpty(str2)) {
            return;
        }
        bundle.putString(str, str2);
    }

    public static void putUri(Bundle bundle, String str, Uri uri) {
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    public static String readStreamToString(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
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
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
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

    private static void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private static int refreshBestGuessNumberOfCPUCores() {
        int i = numCPUCores;
        if (i > 0) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new E());
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    private static void refreshCarrierName(Context context) {
        if (carrierName.equals(noCarrierConstant)) {
            try {
                carrierName = ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getNetworkOperatorName();
            } catch (Exception unused) {
            }
        }
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
            deviceTimezoneAbbreviation = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            deviceTimeZoneName = timeZone.getID();
        } catch (AssertionError | Exception unused) {
        }
    }

    private static void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = statFs.getBlockCount() * statFs.getBlockSize();
            }
            totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    public static String safeGetStringFromResponse(JSONObject jSONObject, String str) {
        return jSONObject != null ? jSONObject.optString(str, "") : "";
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
        jSONObject.put("application_tracking_enabled", !z);
    }

    public static void setAppEventExtendedDeviceInfoParameters(JSONObject jSONObject, Context context) throws JSONException {
        String str;
        Locale locale;
        int i;
        int i2;
        WindowManager windowManager;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i3 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i3 = packageInfo.versionCode;
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "";
        }
        jSONArray.put(packageName);
        jSONArray.put(i3);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception unused2) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + locale.getCountry());
        jSONArray.put(deviceTimezoneAbbreviation);
        jSONArray.put(carrierName);
        double d2 = 0.0d;
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception unused3) {
        }
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            try {
                i2 = displayMetrics.heightPixels;
                try {
                    d2 = displayMetrics.density;
                } catch (Exception unused4) {
                }
            } catch (Exception unused5) {
            }
            jSONArray.put(i);
            jSONArray.put(i2);
            jSONArray.put(String.format("%.2f", Double.valueOf(d2)));
            jSONArray.put(refreshBestGuessNumberOfCPUCores());
            jSONArray.put(totalExternalStorageGB);
            jSONArray.put(availableExternalStorageGB);
            jSONArray.put(deviceTimeZoneName);
            jSONObject.put(Constants.EXTINFO, jSONArray.toString());
        }
        i = 0;
        i2 = 0;
        jSONArray.put(i);
        jSONArray.put(i2);
        jSONArray.put(String.format("%.2f", Double.valueOf(d2)));
        jSONArray.put(refreshBestGuessNumberOfCPUCores());
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONArray.put(deviceTimeZoneName);
        jSONObject.put(Constants.EXTINFO, jSONArray.toString());
    }

    public static String sha1hash(String str) {
        return hashWithAlgorithm(HASH_ALGORITHM_SHA1, str);
    }

    public static boolean stringsEqualOrEmpty(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty && isEmpty2) {
            return true;
        }
        if (isEmpty || isEmpty2) {
            return false;
        }
        return str.equals(str2);
    }

    public static JSONArray tryGetJSONArrayFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    public static JSONObject tryGetJSONObjectFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    public static <T> Collection<T> unmodifiableCollection(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
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

    public static Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        try {
            return getMethodQuietly(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            return hashBytes(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String sha1hash(byte[] bArr) {
        return hashWithAlgorithm(HASH_ALGORITHM_SHA1, bArr);
    }

    public static void logd(String str, String str2) {
        if (!FacebookSdk.isDebugEnabled() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    public static void logd(String str, String str2, Throwable th) {
        if (!FacebookSdk.isDebugEnabled() || isNullOrEmpty(str)) {
            return;
        }
        Log.d(str, str2, th);
    }
}

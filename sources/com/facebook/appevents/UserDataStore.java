package com.facebook.appevents;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    public static final String LAST_NAME = "ln";
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    private static final String TAG = "UserDataStore";
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    private static String hashedUserData;
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static volatile boolean initialized = false;

    private static String encryptData(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(str.getBytes());
                return AppEventUtility.bytesToHex(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static String getHashedUserData() {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            initAndWait();
        }
        lock.readLock().lock();
        try {
            return hashedUserData;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static String hashUserData(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                String obj = bundle.get(str).toString();
                if (maybeSHA256Hashed(obj)) {
                    jSONObject.put(str, obj.toLowerCase());
                } else {
                    String encryptData = encryptData(normalizeData(str, bundle.get(str).toString()));
                    if (encryptData != null) {
                        jSONObject.put(str, encryptData);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return jSONObject.toString();
    }

    public static void initAndWait() {
        if (initialized) {
            return;
        }
        lock.writeLock().lock();
        try {
            if (initialized) {
                return;
            }
            hashedUserData = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(USER_DATA_KEY, null);
            initialized = true;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void initStore() {
        if (initialized) {
            return;
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new z());
    }

    private static boolean maybeSHA256Hashed(String str) {
        return str.matches("[A-Fa-f0-9]{64}");
    }

    private static String normalizeData(String str, String str2) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == 3185) {
            if (str.equals(CITY)) {
                c2 = 3;
            }
            c2 = 65535;
        } else if (hashCode == 3240) {
            if (str.equals(EMAIL)) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode == 3272) {
            if (str.equals(FIRST_NAME)) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode == 3294) {
            if (str.equals(GENDER)) {
                c2 = 7;
            }
            c2 = 65535;
        } else if (hashCode == 3458) {
            if (str.equals(LAST_NAME)) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode == 3576) {
            if (str.equals(PHONE)) {
                c2 = 6;
            }
            c2 = 65535;
        } else if (hashCode != 3681) {
            if (hashCode == 957831062 && str.equals("country")) {
                c2 = 5;
            }
            c2 = 65535;
        } else {
            if (str.equals("st")) {
                c2 = 4;
            }
            c2 = 65535;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return str2.trim().toLowerCase();
            case 6:
                return str2.trim().replaceAll("[^0-9]", "");
            case 7:
                String lowerCase = str2.trim().toLowerCase();
                return lowerCase.length() > 0 ? lowerCase.substring(0, 1) : "";
            default:
                return "";
        }
    }

    public static void setUserDataAndHash(Bundle bundle) {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserData");
            initAndWait();
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new A(bundle));
    }
}

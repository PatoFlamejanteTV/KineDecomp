package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class Validate {
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    private static final String TAG = Validate.class.getName();

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("Argument '" + str + "' cannot be null");
        }
    }

    public static <T> void notEmpty(Collection<T> collection, String str) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + str + "' cannot be empty");
        }
    }

    public static <T> void containsNoNulls(Collection<T> collection, String str) {
        notNull(collection, str);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    public static void containsNoNullOrEmpty(Collection<String> collection, String str) {
        notNull(collection, str);
        for (String str2 : collection) {
            if (str2 == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
            if (str2.length() == 0) {
                throw new IllegalArgumentException("Container '" + str + "' cannot contain empty values");
            }
        }
    }

    public static <T> void notEmptyAndContainsNoNulls(Collection<T> collection, String str) {
        containsNoNulls(collection, str);
        notEmpty(collection, str);
    }

    public static void runningOnUiThread() {
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new FacebookException("This method should be called from the UI thread");
        }
    }

    public static void notNullOrEmpty(String str, String str2) {
        if (Utility.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("Argument '" + str2 + "' cannot be null or empty");
        }
    }

    public static void oneOf(Object obj, String str, Object... objArr) {
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                if (obj2.equals(obj)) {
                    return;
                }
            } else if (obj == null) {
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + str + "' was not one of the allowed values");
    }

    public static void sdkInitialized() {
        if (!FacebookSdk.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    public static String hasAppID() {
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId == null) {
            throw new IllegalStateException("No App ID found, please set the App ID.");
        }
        return applicationId;
    }

    public static void hasInternetPermissions(Context context) {
        hasInternetPermissions(context, true);
    }

    public static void hasInternetPermissions(Context context, boolean z) {
        notNull(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            if (z) {
                throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON);
            }
            Log.w(TAG, NO_INTERNET_PERMISSION_REASON);
        }
    }

    public static void hasFacebookActivity(Context context) {
        hasFacebookActivity(context, true);
    }

    public static void hasFacebookActivity(Context context, boolean z) {
        notNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        ActivityInfo activityInfo = null;
        if (packageManager != null) {
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, (Class<?>) FacebookActivity.class), 1);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        if (activityInfo == null) {
            if (z) {
                throw new IllegalStateException(FACEBOOK_ACTIVITY_NOT_FOUND_REASON);
            }
            Log.w(TAG, FACEBOOK_ACTIVITY_NOT_FOUND_REASON);
        }
    }

    public static void hasContentProvider(Context context) {
        notNull(context, "context");
        String hasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String str = CONTENT_PROVIDER_BASE + hasAppID;
            if (packageManager.resolveContentProvider(str, 0) == null) {
                throw new IllegalStateException(String.format(CONTENT_PROVIDER_NOT_FOUND_REASON, str));
            }
        }
    }
}

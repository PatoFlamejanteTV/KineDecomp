package com.google.firebase.storage.internal;

import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.storage.network.NetworkRequest;
import com.umeng.commonsdk.proguard.c;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class Util {
    public static boolean a(Object obj, Object obj2) {
        return Objects.a(obj, obj2);
    }

    private static String a() throws RemoteException {
        return NetworkRequest.b();
    }

    public static Uri a(FirebaseApp firebaseApp, String str) throws UnsupportedEncodingException {
        String substring;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.toLowerCase().startsWith("gs://")) {
            return Uri.parse("gs://" + SlashUtil.b(SlashUtil.a(str.substring(5))));
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme != null && (a(scheme.toLowerCase(), "http") || a(scheme.toLowerCase(), "https"))) {
            try {
                int indexOf = parse.getAuthority().toLowerCase().indexOf(a());
                String c2 = SlashUtil.c(parse.getEncodedPath());
                if (indexOf == 0 && c2.startsWith("/")) {
                    int indexOf2 = c2.indexOf("/b/", 0);
                    int i = indexOf2 + 3;
                    int indexOf3 = c2.indexOf("/", i);
                    int indexOf4 = c2.indexOf("/o/", 0);
                    if (indexOf2 != -1 && indexOf3 != -1) {
                        substring = c2.substring(i, indexOf3);
                        c2 = indexOf4 != -1 ? c2.substring(indexOf4 + 3) : "";
                    } else {
                        Log.w("StorageUtil", "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                        throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                    }
                } else if (indexOf > 1) {
                    substring = parse.getAuthority().substring(0, indexOf - 1);
                } else {
                    Log.w("StorageUtil", "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                    throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                }
                Preconditions.a(substring, (Object) "No bucket specified");
                return new Uri.Builder().scheme("gs").authority(substring).encodedPath(c2).build();
            } catch (RemoteException unused) {
                throw new UnsupportedEncodingException("Could not parse Url because the Storage network layer did not load");
            }
        }
        Log.w("StorageUtil", "FirebaseStorage is unable to support the scheme:" + scheme);
        throw new IllegalArgumentException("Uri scheme");
    }

    public static String a(FirebaseApp firebaseApp) {
        try {
            String c2 = ((GetTokenResult) Tasks.a(firebaseApp.a(false), c.f26227d, TimeUnit.MILLISECONDS)).c();
            if (!TextUtils.isEmpty(c2)) {
                return c2;
            }
            Log.w("StorageUtil", "no auth token for request");
            return null;
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            Log.e("StorageUtil", "error getting token " + e2);
            return null;
        }
    }
}

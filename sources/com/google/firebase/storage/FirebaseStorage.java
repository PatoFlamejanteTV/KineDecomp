package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.internal.Util;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class FirebaseStorage {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Map<String, FirebaseStorage>> f18082a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final FirebaseApp f18083b;

    /* renamed from: c, reason: collision with root package name */
    private final String f18084c;

    /* renamed from: d, reason: collision with root package name */
    private long f18085d = 600000;

    /* renamed from: e, reason: collision with root package name */
    private long f18086e = 600000;

    /* renamed from: f, reason: collision with root package name */
    private long f18087f = 120000;

    private FirebaseStorage(String str, FirebaseApp firebaseApp) {
        this.f18084c = str;
        this.f18083b = firebaseApp;
    }

    private static FirebaseStorage a(FirebaseApp firebaseApp, Uri uri) {
        FirebaseStorage firebaseStorage;
        String host = uri != null ? uri.getHost() : null;
        if (uri != null && !TextUtils.isEmpty(uri.getPath())) {
            throw new IllegalArgumentException("The storage Uri cannot contain a path element.");
        }
        synchronized (f18082a) {
            Map<String, FirebaseStorage> map = f18082a.get(firebaseApp.d());
            if (map == null) {
                map = new HashMap<>();
                f18082a.put(firebaseApp.d(), map);
            }
            firebaseStorage = map.get(host);
            if (firebaseStorage == null) {
                firebaseStorage = new FirebaseStorage(host, firebaseApp);
                map.put(host, firebaseStorage);
            }
        }
        return firebaseStorage;
    }

    @PublicApi
    public static FirebaseStorage b() {
        FirebaseApp c2 = FirebaseApp.c();
        Preconditions.a(c2 != null, "You must call FirebaseApp.initialize() first.");
        return a(c2);
    }

    private String f() {
        return this.f18084c;
    }

    @PublicApi
    public long c() {
        return this.f18086e;
    }

    @PublicApi
    public long d() {
        return this.f18085d;
    }

    @PublicApi
    public StorageReference e() {
        if (!TextUtils.isEmpty(f())) {
            return a(new Uri.Builder().scheme("gs").authority(f()).path("/").build());
        }
        throw new IllegalStateException("FirebaseApp was not initialized with a bucket name.");
    }

    @PublicApi
    public StorageReference b(String str) {
        Preconditions.a(!TextUtils.isEmpty(str), "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("gs://") && !lowerCase.startsWith("https://") && !lowerCase.startsWith("http://")) {
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
        try {
            Uri a2 = Util.a(this.f18083b, str);
            if (a2 != null) {
                return a(a2);
            }
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        } catch (UnsupportedEncodingException e2) {
            Log.e("FirebaseStorage", "Unable to parse location:" + str, e2);
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    @PublicApi
    public static FirebaseStorage a(FirebaseApp firebaseApp) {
        Preconditions.a(firebaseApp != null, "Null is not a valid value for the FirebaseApp.");
        String e2 = firebaseApp.e().e();
        if (e2 == null) {
            return a(firebaseApp, null);
        }
        try {
            return a(firebaseApp, Util.a(firebaseApp, "gs://" + firebaseApp.e().e()));
        } catch (UnsupportedEncodingException e3) {
            Log.e("FirebaseStorage", "Unable to parse bucket:" + e2, e3);
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    @PublicApi
    public StorageReference a(String str) {
        Preconditions.a(!TextUtils.isEmpty(str), "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("gs://") && !lowerCase.startsWith("https://") && !lowerCase.startsWith("http://")) {
            return e().a(str);
        }
        throw new IllegalArgumentException("location should not be a full URL.");
    }

    private StorageReference a(Uri uri) {
        Preconditions.a(uri, "uri must not be null");
        String f2 = f();
        Preconditions.a(TextUtils.isEmpty(f2) || uri.getAuthority().equalsIgnoreCase(f2), "The supplied bucketname does not match the storage bucket of the current instance.");
        return new StorageReference(uri, this);
    }

    @PublicApi
    public FirebaseApp a() {
        return this.f18083b;
    }
}

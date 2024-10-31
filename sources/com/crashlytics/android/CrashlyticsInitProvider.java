package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.services.common.s;

/* loaded from: classes.dex */
public class CrashlyticsInitProvider extends ContentProvider {
    private static final String TAG = "CrashlyticsInitProvider";

    /* loaded from: classes.dex */
    public interface EnabledCheckStrategy {
        boolean isCrashlyticsEnabled(Context context);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        if (shouldInitializeFabric(context, new s(), new ManifestEnabledCheckStrategy())) {
            try {
                f.a(context, new Crashlytics());
                f.f().a(TAG, "CrashlyticsInitProvider initialization successful");
            } catch (IllegalStateException unused) {
                f.f().a(TAG, "CrashlyticsInitProvider initialization unsuccessful");
                return false;
            }
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    boolean shouldInitializeFabric(Context context, s sVar, EnabledCheckStrategy enabledCheckStrategy) {
        return sVar.b(context) && enabledCheckStrategy.isCrashlyticsEnabled(context);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

package com.facebook.share.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookSdk;
import com.facebook.internal.FileLruCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0769o extends AccessTokenTracker {
    @Override // com.facebook.AccessTokenTracker
    protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
        int i;
        int i2;
        FileLruCache fileLruCache;
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (accessToken2 == null) {
            i = LikeActionController.objectSuffix;
            int unused = LikeActionController.objectSuffix = (i + 1) % 1000;
            SharedPreferences.Editor edit = applicationContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit();
            i2 = LikeActionController.objectSuffix;
            edit.putInt("OBJECT_SUFFIX", i2).apply();
            LikeActionController.cache.clear();
            fileLruCache = LikeActionController.controllerDiskCache;
            fileLruCache.clearCache();
        }
        LikeActionController.broadcastAction(null, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
    }
}

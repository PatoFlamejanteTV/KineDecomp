package com.facebook.share.internal;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.internal.Utility;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoUploader.java */
/* loaded from: classes.dex */
public final class ae extends AccessTokenTracker {
    @Override // com.facebook.AccessTokenTracker
    protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
        if (accessToken != null) {
            if (accessToken2 == null || !Utility.areObjectsEqual(accessToken2.getUserId(), accessToken.getUserId())) {
                VideoUploader.cancelAllRequests();
            }
        }
    }
}

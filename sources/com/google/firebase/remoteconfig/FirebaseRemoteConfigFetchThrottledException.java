package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigFetchException {
    private final long zzs;

    public FirebaseRemoteConfigFetchThrottledException(long j) {
        this.zzs = j;
    }

    public long getThrottleEndTimeMillis() {
        return this.zzs;
    }
}

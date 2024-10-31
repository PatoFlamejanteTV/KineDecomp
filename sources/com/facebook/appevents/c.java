package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnalyticsUserIDStore.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9163a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.f9163a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReentrantReadWriteLock reentrantReadWriteLock;
        ReentrantReadWriteLock reentrantReadWriteLock2;
        String str;
        reentrantReadWriteLock = d.f9170b;
        reentrantReadWriteLock.writeLock().lock();
        try {
            String unused = d.f9171c = this.f9163a;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            str = d.f9171c;
            edit.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", str);
            edit.apply();
        } finally {
            reentrantReadWriteLock2 = d.f9170b;
            reentrantReadWriteLock2.writeLock().unlock();
        }
    }
}

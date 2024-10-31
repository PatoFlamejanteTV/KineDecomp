package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserDataStore.java */
/* loaded from: classes.dex */
public class A implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f9154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(Bundle bundle) {
        this.f9154a = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReentrantReadWriteLock reentrantReadWriteLock;
        ReentrantReadWriteLock reentrantReadWriteLock2;
        String hashUserData;
        String str;
        reentrantReadWriteLock = UserDataStore.lock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            hashUserData = UserDataStore.hashUserData(this.f9154a);
            String unused = UserDataStore.hashedUserData = hashUserData;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            str = UserDataStore.hashedUserData;
            edit.putString("com.facebook.appevents.UserDataStore.userData", str);
            edit.apply();
        } finally {
            reentrantReadWriteLock2 = UserDataStore.lock;
            reentrantReadWriteLock2.writeLock().unlock();
        }
    }
}

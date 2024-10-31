package com.facebook.appevents;

/* compiled from: UserDataStore.java */
/* loaded from: classes.dex */
public class z implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        UserDataStore.initAndWait();
    }
}

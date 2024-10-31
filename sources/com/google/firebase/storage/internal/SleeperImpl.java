package com.google.firebase.storage.internal;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class SleeperImpl implements Sleeper {
    @Override // com.google.firebase.storage.internal.Sleeper
    public void a(int i) throws InterruptedException {
        Thread.sleep(i);
    }
}

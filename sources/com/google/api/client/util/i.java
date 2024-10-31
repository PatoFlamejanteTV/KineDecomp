package com.google.api.client.util;

/* compiled from: Sleeper.java */
/* loaded from: classes2.dex */
class i implements Sleeper {
    @Override // com.google.api.client.util.Sleeper
    public void a(long j) throws InterruptedException {
        Thread.sleep(j);
    }
}

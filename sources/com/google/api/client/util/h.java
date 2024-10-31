package com.google.api.client.util;

/* compiled from: Sleeper.java */
/* loaded from: classes.dex */
final class h implements Sleeper {
    @Override // com.google.api.client.util.Sleeper
    public void a(long j) throws InterruptedException {
        Thread.sleep(j);
    }
}

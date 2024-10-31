package com.facebook.internal;

import com.facebook.internal.NativeProtocol;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NativeProtocol.java */
/* loaded from: classes.dex */
public final class y implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        List list;
        try {
            list = NativeProtocol.facebookAppInfoList;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((NativeProtocol.c) it.next()).a(true);
            }
        } finally {
            atomicBoolean = NativeProtocol.protocolVersionsAsyncUpdating;
            atomicBoolean.set(false);
        }
    }
}

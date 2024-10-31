package com.crashlytics.android.core;

import io.fabric.sdk.android.services.network.h;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CrashlyticsPinningInfoProvider implements h {
    private final PinningInfoProvider pinningInfo;

    public CrashlyticsPinningInfoProvider(PinningInfoProvider pinningInfoProvider) {
        this.pinningInfo = pinningInfoProvider;
    }

    @Override // io.fabric.sdk.android.services.network.h
    public String getKeyStorePassword() {
        return this.pinningInfo.getKeyStorePassword();
    }

    @Override // io.fabric.sdk.android.services.network.h
    public InputStream getKeyStoreStream() {
        return this.pinningInfo.getKeyStoreStream();
    }

    @Override // io.fabric.sdk.android.services.network.h
    public long getPinCreationTimeInMillis() {
        return -1L;
    }

    @Override // io.fabric.sdk.android.services.network.h
    public String[] getPins() {
        return this.pinningInfo.getPins();
    }
}

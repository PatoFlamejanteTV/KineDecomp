package com.google.android.gms.wearable;

import java.io.IOException;

/* loaded from: classes.dex */
public class ChannelIOException extends IOException {
    private final int zzbeU;
    private final int zzbeV;

    public ChannelIOException(String str, int i, int i2) {
        super(str);
        this.zzbeU = i;
        this.zzbeV = i2;
    }

    public int getAppSpecificErrorCode() {
        return this.zzbeV;
    }

    public int getCloseReason() {
        return this.zzbeU;
    }
}

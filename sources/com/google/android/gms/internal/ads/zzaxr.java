package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.math.BigInteger;

@zzark
/* loaded from: classes2.dex */
public final class zzaxr {
    private BigInteger zzejv = BigInteger.ONE;
    private String zzejw = AppEventsConstants.EVENT_PARAM_VALUE_NO;

    public final synchronized String zzyv() {
        String bigInteger;
        bigInteger = this.zzejv.toString();
        this.zzejv = this.zzejv.add(BigInteger.ONE);
        this.zzejw = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzyw() {
        return this.zzejw;
    }
}

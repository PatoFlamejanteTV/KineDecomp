package com.google.android.gms.internal.config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzap implements FirebaseRemoteConfigValue {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Pattern zzm = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
    public static final Pattern zzn = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    private final byte[] zzba;
    private final int zzbb;

    public zzap(byte[] bArr, int i) {
        this.zzba = bArr;
        this.zzbb = i;
    }

    public final boolean asBoolean() throws IllegalArgumentException {
        if (this.zzbb == 0) {
            return false;
        }
        String trim = asString().trim();
        if (zzm.matcher(trim).matches()) {
            return true;
        }
        if (zzn.matcher(trim).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", trim, "boolean"));
    }

    public final byte[] asByteArray() {
        if (this.zzbb == 0) {
            return FirebaseRemoteConfig.f18068a;
        }
        return this.zzba;
    }

    public final double asDouble() {
        if (this.zzbb == 0) {
            return 0.0d;
        }
        String trim = asString().trim();
        try {
            return Double.valueOf(trim).doubleValue();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", trim, "double"), e2);
        }
    }

    public final long asLong() {
        if (this.zzbb == 0) {
            return 0L;
        }
        String trim = asString().trim();
        try {
            return Long.valueOf(trim).longValue();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", trim, "long"), e2);
        }
    }

    public final String asString() {
        if (this.zzbb == 0) {
            return "";
        }
        byte[] bArr = this.zzba;
        if (bArr != null) {
            return new String(bArr, UTF_8);
        }
        throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
    }

    public final int getSource() {
        return this.zzbb;
    }
}

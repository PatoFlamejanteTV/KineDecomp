package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzuv extends IOException {
    private zzvv zzbzd;

    public zzuv(String str) {
        super(str);
        this.zzbzd = null;
    }

    public static zzuv zzwq() {
        return new zzuv("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzuv zzwr() {
        return new zzuv("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzuv zzws() {
        return new zzuv("CodedInputStream encountered a malformed varint.");
    }

    public static zzuv zzwt() {
        return new zzuv("Protocol message end-group tag did not match expected tag.");
    }

    public static zzuw zzwu() {
        return new zzuw("Protocol message tag had invalid wire type.");
    }

    public static zzuv zzwv() {
        return new zzuv("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static zzuv zzww() {
        return new zzuv("Failed to parse the message.");
    }

    public static zzuv zzwx() {
        return new zzuv("Protocol message had invalid UTF-8.");
    }

    public final zzuv zzg(zzvv zzvvVar) {
        this.zzbzd = zzvvVar;
        return this;
    }
}

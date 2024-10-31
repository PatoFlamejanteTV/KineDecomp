package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzrk extends IOException {
    private zzsk zzbbk;

    public zzrk(String str) {
        super(str);
        this.zzbbk = null;
    }

    public static zzrk zzpp() {
        return new zzrk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzrk zzpq() {
        return new zzrk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzrk zzpr() {
        return new zzrk("CodedInputStream encountered a malformed varint.");
    }

    public static zzrk zzps() {
        return new zzrk("Protocol message end-group tag did not match expected tag.");
    }

    public static zzrl zzpt() {
        return new zzrl("Protocol message tag had invalid wire type.");
    }

    public static zzrk zzpu() {
        return new zzrk("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static zzrk zzpv() {
        return new zzrk("Failed to parse the message.");
    }

    public static zzrk zzpw() {
        return new zzrk("Protocol message had invalid UTF-8.");
    }

    public final zzrk zzg(zzsk zzskVar) {
        this.zzbbk = zzskVar;
        return this;
    }
}
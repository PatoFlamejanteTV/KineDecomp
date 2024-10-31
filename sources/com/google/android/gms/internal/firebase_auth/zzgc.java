package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzgc extends IOException {
    private zzhc zzxx;

    public zzgc(String str) {
        super(str);
        this.zzxx = null;
    }

    public static zzgc zzhq() {
        return new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzgc zzhr() {
        return new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzgc zzhs() {
        return new zzgc("CodedInputStream encountered a malformed varint.");
    }

    public static zzgc zzht() {
        return new zzgc("Protocol message contained an invalid tag (zero).");
    }

    public static zzgc zzhu() {
        return new zzgc("Protocol message end-group tag did not match expected tag.");
    }

    public static zzgd zzhv() {
        return new zzgd("Protocol message tag had invalid wire type.");
    }

    public static zzgc zzhw() {
        return new zzgc("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static zzgc zzhx() {
        return new zzgc("Failed to parse the message.");
    }

    public static zzgc zzhy() {
        return new zzgc("Protocol message had invalid UTF-8.");
    }

    public final zzgc zzh(zzhc zzhcVar) {
        this.zzxx = zzhcVar;
        return this;
    }
}

package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzuv extends IOException {
    public zzuv(String str) {
        super(str);
    }

    public static zzuv zzsa() {
        return new zzuv("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzuv zzsb() {
        return new zzuv("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzuv zzsc() {
        return new zzuv("CodedInputStream encountered a malformed varint.");
    }

    public static zzuv zzsd() {
        return new zzuv("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public zzuv(String str, Exception exc) {
        super(str, exc);
    }
}

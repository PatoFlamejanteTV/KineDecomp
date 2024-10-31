package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbuy extends IOException {
    public zzbuy(String str) {
        super(str);
    }

    public static zzbuy zzapo() {
        return new zzbuy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzbuy zzapp() {
        return new zzbuy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzbuy zzapq() {
        return new zzbuy("CodedInputStream encountered a malformed varint.");
    }

    public zzbuy(String str, Exception exc) {
        super(str, exc);
    }
}

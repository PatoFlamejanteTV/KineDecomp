package com.google.android.gms.internal.firebase_abt;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzi extends IOException {
    public zzi(String str) {
        super(str);
    }

    public static zzi zzl() {
        return new zzi("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzi zzm() {
        return new zzi("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzi zzn() {
        return new zzi("CodedInputStream encountered a malformed varint.");
    }
}

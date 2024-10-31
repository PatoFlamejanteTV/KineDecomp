package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class zzbjw {
    private static final CopyOnWriteArrayList<zzbjv> zzfdb = new CopyOnWriteArrayList<>();

    public static zzbjv zzfh(String str) throws GeneralSecurityException {
        Iterator<zzbjv> it = zzfdb.iterator();
        while (it.hasNext()) {
            zzbjv next = it.next();
            if (next.zzff(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}

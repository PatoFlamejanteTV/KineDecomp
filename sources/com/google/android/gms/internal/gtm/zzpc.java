package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;

@VisibleForTesting
/* loaded from: classes2.dex */
public interface zzpc {
    void close();

    InputStream zzcj(String str) throws IOException;
}

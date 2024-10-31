package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public final class Jl implements zzpm<Long> {
    private Jl() {
    }

    @Override // com.google.android.gms.internal.ads.zzpm
    public final /* synthetic */ Long zzb(Uri uri, InputStream inputStream) throws IOException {
        return Long.valueOf(zzqe.zzal(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
    }

    public /* synthetic */ Jl(Cl cl) {
        this();
    }
}

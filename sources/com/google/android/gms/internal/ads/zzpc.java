package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzpc extends IOException {
    private final int type;
    private final zzoz zzazo;

    public zzpc(String str, zzoz zzozVar, int i) {
        super(str);
        this.zzazo = zzozVar;
        this.type = 1;
    }

    public zzpc(IOException iOException, zzoz zzozVar, int i) {
        super(iOException);
        this.zzazo = zzozVar;
        this.type = i;
    }

    public zzpc(String str, IOException iOException, zzoz zzozVar, int i) {
        super(str, iOException);
        this.zzazo = zzozVar;
        this.type = 1;
    }
}

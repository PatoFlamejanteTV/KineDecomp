package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzot {
    private final zzl zzakg;
    private final Map<String, zzl> zzats;

    /* JADX INFO: Access modifiers changed from: private */
    public zzot(Map<String, zzl> map, zzl zzlVar) {
        this.zzats = map;
        this.zzakg = zzlVar;
    }

    public static zzou zzml() {
        return new zzou();
    }

    public final String toString() {
        String valueOf = String.valueOf(Collections.unmodifiableMap(this.zzats));
        String valueOf2 = String.valueOf(this.zzakg);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32 + String.valueOf(valueOf2).length());
        sb.append("Properties: ");
        sb.append(valueOf);
        sb.append(" pushAfterEvaluate: ");
        sb.append(valueOf2);
        return sb.toString();
    }

    public final void zza(String str, zzl zzlVar) {
        this.zzats.put(str, zzlVar);
    }

    public final zzl zzji() {
        return this.zzakg;
    }

    public final Map<String, zzl> zzlu() {
        return Collections.unmodifiableMap(this.zzats);
    }

    public /* synthetic */ zzot(Map map, zzl zzlVar, Q q) {
        this(map, zzlVar);
    }
}

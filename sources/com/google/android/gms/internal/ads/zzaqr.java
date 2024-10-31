package com.google.android.gms.internal.ads;

@zzark
/* loaded from: classes2.dex */
public final class zzaqr implements zzaqe<zzabu> {
    private final boolean zzdmt;
    private final boolean zzdut;
    private final boolean zzduu;

    public zzaqr(boolean z, boolean z2, boolean z3) {
        this.zzdut = z;
        this.zzduu = z2;
        this.zzdmt = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
    @Override // com.google.android.gms.internal.ads.zzaqe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzabu zza(com.google.android.gms.internal.ads.zzapw r19, org.json.JSONObject r20) throws org.json.JSONException, java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        /*
            r18 = this;
            r0 = r18
            r7 = r19
            r8 = r20
            boolean r5 = r0.zzdut
            boolean r6 = r0.zzduu
            java.lang.String r3 = "images"
            r4 = 0
            r1 = r19
            r2 = r20
            java.util.List r1 = r1.zza(r2, r3, r4, r5, r6)
            boolean r2 = r0.zzdut
            java.lang.String r3 = "secondary_image"
            com.google.android.gms.internal.ads.zzbcb r2 = r7.zza(r8, r3, r4, r2)
            com.google.android.gms.internal.ads.zzbcb r3 = r19.zzg(r20)
            java.lang.String r4 = "video"
            com.google.android.gms.internal.ads.zzbcb r4 = r7.zzc(r8, r4)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r1 = r1.iterator()
        L30:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L46
            java.lang.Object r5 = r1.next()
            com.google.android.gms.internal.ads.zzbcb r5 = (com.google.android.gms.internal.ads.zzbcb) r5
            java.lang.Object r5 = r5.get()
            com.google.android.gms.internal.ads.zzabr r5 = (com.google.android.gms.internal.ads.zzabr) r5
            r7.add(r5)
            goto L30
        L46:
            com.google.android.gms.internal.ads.zzbgg r1 = com.google.android.gms.internal.ads.zzapw.zzc(r4)
            com.google.android.gms.internal.ads.zzabu r4 = new com.google.android.gms.internal.ads.zzabu
            java.lang.String r5 = "headline"
            java.lang.String r5 = r8.getString(r5)
            boolean r6 = r0.zzdmt
            if (r6 == 0) goto L92
            com.google.android.gms.internal.ads.zzaxk r6 = com.google.android.gms.ads.internal.zzbv.i()
            android.content.res.Resources r6 = r6.getResources()
            if (r6 == 0) goto L67
            int r9 = com.google.android.gms.ads.impl.R.string.s7
            java.lang.String r6 = r6.getString(r9)
            goto L69
        L67:
            java.lang.String r6 = "Test Ad"
        L69:
            if (r5 == 0) goto L93
            java.lang.String r9 = java.lang.String.valueOf(r6)
            int r9 = r9.length()
            int r9 = r9 + 3
            java.lang.String r10 = java.lang.String.valueOf(r5)
            int r10 = r10.length()
            int r9 = r9 + r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r9)
            r10.append(r6)
            java.lang.String r6 = " : "
            r10.append(r6)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
        L92:
            r6 = r5
        L93:
            java.lang.String r5 = "body"
            java.lang.String r9 = r8.getString(r5)
            java.lang.Object r2 = r2.get()
            com.google.android.gms.internal.ads.zzadb r2 = (com.google.android.gms.internal.ads.zzadb) r2
            java.lang.String r5 = "call_to_action"
            java.lang.String r10 = r8.getString(r5)
            java.lang.String r5 = "advertiser"
            java.lang.String r11 = r8.getString(r5)
            java.lang.Object r3 = r3.get()
            r12 = r3
            com.google.android.gms.internal.ads.zzabm r12 = (com.google.android.gms.internal.ads.zzabm) r12
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            r3 = 0
            if (r1 == 0) goto Lc0
            com.google.android.gms.internal.ads.zzbgw r5 = r1.zzabu()
            r14 = r5
            goto Lc1
        Lc0:
            r14 = r3
        Lc1:
            if (r1 == 0) goto Lc9
            android.view.View r1 = r1.getView()
            r15 = r1
            goto Lca
        Lc9:
            r15 = r3
        Lca:
            r16 = 0
            r17 = 0
            r5 = r4
            r8 = r9
            r9 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqr.zza(com.google.android.gms.internal.ads.zzapw, org.json.JSONObject):com.google.android.gms.internal.ads.zzacf");
    }
}

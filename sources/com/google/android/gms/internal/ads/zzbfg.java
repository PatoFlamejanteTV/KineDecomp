package com.google.android.gms.internal.ads;

@zzark
/* loaded from: classes2.dex */
public final class zzbfg implements com.google.android.gms.ads.internal.gmsg.zzu<zzbdz> {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0085 A[Catch: NumberFormatException -> 0x00ca, NullPointerException | NumberFormatException -> 0x00cc, TryCatch #2 {NullPointerException | NumberFormatException -> 0x00cc, blocks: (B:24:0x000c, B:3:0x0033, B:8:0x0069, B:11:0x007f, B:13:0x0085, B:14:0x00c3, B:21:0x007a), top: B:23:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a A[Catch: NumberFormatException -> 0x00ca, NullPointerException | NumberFormatException -> 0x00cc, TryCatch #2 {NullPointerException | NumberFormatException -> 0x00cc, blocks: (B:24:0x000c, B:3:0x0033, B:8:0x0069, B:11:0x007f, B:13:0x0085, B:14:0x00c3, B:21:0x007a), top: B:23:0x000c }] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzbdz r8, java.util.Map r9) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbdz r8 = (com.google.android.gms.internal.ads.zzbdz) r8
            com.google.android.gms.internal.ads.zzbgw r0 = r8.zzabu()
            java.lang.String r1 = "duration"
            java.lang.String r2 = "1"
            if (r0 != 0) goto L33
            java.lang.Object r0 = r9.get(r1)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r3 = "customControlsAllowed"
            java.lang.Object r3 = r9.get(r3)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            boolean r3 = r2.equals(r3)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r4 = "clickToExpandAllowed"
            java.lang.Object r4 = r9.get(r4)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            boolean r4 = r2.equals(r4)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            com.google.android.gms.internal.ads.zzbgw r5 = new com.google.android.gms.internal.ads.zzbgw     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r5.<init>(r8, r0, r3, r4)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r8.zza(r5)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r0 = r5
        L33:
            java.lang.Object r8 = r9.get(r1)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            float r8 = java.lang.Float.parseFloat(r8)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r1 = "muted"
            java.lang.Object r1 = r9.get(r1)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            boolean r4 = r2.equals(r1)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r1 = "currentTime"
            java.lang.Object r1 = r9.get(r1)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r2 = "playbackState"
            java.lang.Object r2 = r9.get(r2)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r3 = 3
            if (r2 < 0) goto L67
            if (r3 >= r2) goto L65
            goto L67
        L65:
            r5 = r2
            goto L69
        L67:
            r2 = 0
            r5 = 0
        L69:
            java.lang.String r2 = "aspectRatio"
            java.lang.Object r9 = r9.get(r2)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            if (r2 == 0) goto L7a
            r2 = 0
            r6 = 0
            goto L7f
        L7a:
            float r2 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r6 = r2
        L7f:
            boolean r2 = com.google.android.gms.internal.ads.zzbbd.isLoggable(r3)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            if (r2 == 0) goto Lc3
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            int r2 = r2.length()     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            int r2 = r2 + 140
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r3.<init>(r2)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r2 = "Video Meta GMSG: currentTime : "
            r3.append(r2)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r3.append(r1)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r2 = " , duration : "
            r3.append(r2)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r3.append(r8)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r2 = " , isMuted : "
            r3.append(r2)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r3.append(r4)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r2 = " , playbackState : "
            r3.append(r2)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r3.append(r5)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r2 = " , aspectRatio : "
            r3.append(r2)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            r3.append(r9)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            java.lang.String r9 = r3.toString()     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            com.google.android.gms.internal.ads.zzbbd.zzdn(r9)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
        Lc3:
            r2 = r8
            r3 = r5
            r5 = r6
            r0.zza(r1, r2, r3, r4, r5)     // Catch: java.lang.NumberFormatException -> Lca java.lang.NullPointerException -> Lcc
            return
        Lca:
            r8 = move-exception
            goto Lcd
        Lcc:
            r8 = move-exception
        Lcd:
            java.lang.String r9 = "Unable to parse videoMeta message."
            com.google.android.gms.internal.ads.zzbbd.zzb(r9, r8)
            com.google.android.gms.internal.ads.zzaxk r9 = com.google.android.gms.ads.internal.zzbv.i()
            java.lang.String r0 = "VideoMetaGmsgHandler.onGmsg"
            r9.zza(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfg.zza(java.lang.Object, java.util.Map):void");
    }
}

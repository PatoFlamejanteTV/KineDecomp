package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzdl implements zzff<zzj.zzl> {
    private String zzgc;
    private String zzgh;
    private String zzgi;
    private String zzgw;
    private String zzhw;
    private String zzhx;
    private String zzpu;
    private boolean zzpt = true;
    private zzdp zzps = new zzdp();
    private zzdp zzpr = new zzdp();

    public final String getDisplayName() {
        return this.zzhw;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    public final String zzal() {
        return this.zzhx;
    }

    public final boolean zzch(String str) {
        Preconditions.b(str);
        return this.zzps.zzeb().contains(str);
    }

    public final zzdl zzci(String str) {
        Preconditions.b(str);
        this.zzgc = str;
        return this;
    }

    public final zzdl zzcj(String str) {
        if (str == null) {
            this.zzps.zzeb().add("EMAIL");
        } else {
            this.zzgh = str;
        }
        return this;
    }

    public final zzdl zzck(String str) {
        if (str == null) {
            this.zzps.zzeb().add("PASSWORD");
        } else {
            this.zzgi = str;
        }
        return this;
    }

    public final zzdl zzcl(String str) {
        if (str == null) {
            this.zzps.zzeb().add("DISPLAY_NAME");
        } else {
            this.zzhw = str;
        }
        return this;
    }

    public final zzdl zzcm(String str) {
        if (str == null) {
            this.zzps.zzeb().add("PHOTO_URL");
        } else {
            this.zzhx = str;
        }
        return this;
    }

    public final zzdl zzcn(String str) {
        Preconditions.b(str);
        this.zzpr.zzeb().add(str);
        return this;
    }

    public final zzdl zzco(String str) {
        Preconditions.b(str);
        this.zzpu = str;
        return this;
    }

    public final zzdl zzcp(String str) {
        this.zzgw = str;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzhc zzds() {
        /*
            r11 = this;
            com.google.android.gms.internal.firebase_auth.zzj$zzl$zza r0 = com.google.android.gms.internal.firebase_auth.zzj.zzl.zzai()
            boolean r1 = r11.zzpt
            com.google.android.gms.internal.firebase_auth.zzj$zzl$zza r0 = r0.zzf(r1)
            com.google.android.gms.internal.firebase_auth.zzdp r1 = r11.zzpr
            java.util.List r1 = r1.zzeb()
            com.google.android.gms.internal.firebase_auth.zzj$zzl$zza r0 = r0.zzd(r1)
            com.google.android.gms.internal.firebase_auth.zzdp r1 = r11.zzps
            java.util.List r1 = r1.zzeb()
            int r2 = r1.size()
            com.google.android.gms.internal.firebase_auth.zzo[] r2 = new com.google.android.gms.internal.firebase_auth.zzo[r2]
            r3 = 0
            r4 = 0
        L22:
            int r5 = r1.size()
            if (r4 >= r5) goto L7c
            java.lang.Object r5 = r1.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            r6 = -1
            int r7 = r5.hashCode()
            r8 = 3
            r9 = 2
            r10 = 1
            switch(r7) {
                case -333046776: goto L58;
                case 66081660: goto L4e;
                case 1939891618: goto L44;
                case 1999612571: goto L3a;
                default: goto L39;
            }
        L39:
            goto L61
        L3a:
            java.lang.String r7 = "PASSWORD"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L61
            r6 = 2
            goto L61
        L44:
            java.lang.String r7 = "PHOTO_URL"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L61
            r6 = 3
            goto L61
        L4e:
            java.lang.String r7 = "EMAIL"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L61
            r6 = 0
            goto L61
        L58:
            java.lang.String r7 = "DISPLAY_NAME"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L61
            r6 = 1
        L61:
            if (r6 == 0) goto L75
            if (r6 == r10) goto L72
            if (r6 == r9) goto L6f
            if (r6 == r8) goto L6c
            com.google.android.gms.internal.firebase_auth.zzo r5 = com.google.android.gms.internal.firebase_auth.zzo.USER_ATTRIBUTE_NAME_UNSPECIFIED
            goto L77
        L6c:
            com.google.android.gms.internal.firebase_auth.zzo r5 = com.google.android.gms.internal.firebase_auth.zzo.PHOTO_URL
            goto L77
        L6f:
            com.google.android.gms.internal.firebase_auth.zzo r5 = com.google.android.gms.internal.firebase_auth.zzo.PASSWORD
            goto L77
        L72:
            com.google.android.gms.internal.firebase_auth.zzo r5 = com.google.android.gms.internal.firebase_auth.zzo.DISPLAY_NAME
            goto L77
        L75:
            com.google.android.gms.internal.firebase_auth.zzo r5 = com.google.android.gms.internal.firebase_auth.zzo.EMAIL
        L77:
            r2[r4] = r5
            int r4 = r4 + 1
            goto L22
        L7c:
            java.util.List r1 = java.util.Arrays.asList(r2)
            com.google.android.gms.internal.firebase_auth.zzj$zzl$zza r0 = r0.zzc(r1)
            java.lang.String r1 = r11.zzgc
            if (r1 == 0) goto L8b
            r0.zzan(r1)
        L8b:
            java.lang.String r1 = r11.zzgh
            if (r1 == 0) goto L92
            r0.zzap(r1)
        L92:
            java.lang.String r1 = r11.zzgi
            if (r1 == 0) goto L99
            r0.zzaq(r1)
        L99:
            java.lang.String r1 = r11.zzhw
            if (r1 == 0) goto La0
            r0.zzao(r1)
        La0:
            java.lang.String r1 = r11.zzhx
            if (r1 == 0) goto La7
            r0.zzas(r1)
        La7:
            java.lang.String r1 = r11.zzpu
            if (r1 == 0) goto Lae
            r0.zzar(r1)
        Lae:
            java.lang.String r1 = r11.zzgw
            if (r1 == 0) goto Lb5
            r0.zzat(r1)
        Lb5:
            com.google.android.gms.internal.firebase_auth.zzhc r0 = r0.zzhn()
            com.google.android.gms.internal.firebase_auth.zzj$zzl r0 = (com.google.android.gms.internal.firebase_auth.zzj.zzl) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzdl.zzds():com.google.android.gms.internal.firebase_auth.zzhc");
    }
}

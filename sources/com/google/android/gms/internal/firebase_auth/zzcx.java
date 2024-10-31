package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzcx implements zzff<zzj.zzh> {
    private String zzgc;
    private String zzgh;
    private String zzgw;
    private ActionCodeSettings zzig;
    private String zzpf;

    public zzcx(zzjo zzjoVar) {
        int i = C1240b.f13015a[zzjoVar.ordinal()];
        this.zzpf = i != 1 ? i != 2 ? i != 3 ? "REQUEST_TYPE_UNSET_ENUM_VALUE" : "EMAIL_SIGNIN" : "VERIFY_EMAIL" : "PASSWORD_RESET";
    }

    public final zzcx zza(ActionCodeSettings actionCodeSettings) {
        Preconditions.a(actionCodeSettings);
        this.zzig = actionCodeSettings;
        return this;
    }

    public final zzcx zzcb(String str) {
        Preconditions.b(str);
        this.zzgh = str;
        return this;
    }

    public final zzcx zzcc(String str) {
        Preconditions.b(str);
        this.zzgc = str;
        return this;
    }

    public final zzcx zzcd(String str) {
        this.zzgw = str;
        return this;
    }

    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }

    public final /* synthetic */ zzhc zzds() {
        char c2;
        zzjo zzjoVar;
        zzj.zzh.zza zzz = zzj.zzh.zzz();
        String str = this.zzpf;
        int hashCode = str.hashCode();
        if (hashCode == -1452371317) {
            if (str.equals("PASSWORD_RESET")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != -1341836234) {
            if (hashCode == 870738373 && str.equals("EMAIL_SIGNIN")) {
                c2 = 2;
            }
            c2 = 65535;
        } else {
            if (str.equals("VERIFY_EMAIL")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            zzjoVar = zzjo.PASSWORD_RESET;
        } else if (c2 == 1) {
            zzjoVar = zzjo.VERIFY_EMAIL;
        } else if (c2 != 2) {
            zzjoVar = zzjo.OOB_REQ_TYPE_UNSPECIFIED;
        } else {
            zzjoVar = zzjo.EMAIL_SIGNIN;
        }
        zzj.zzh.zza zzb = zzz.zzb(zzjoVar);
        String str2 = this.zzgh;
        if (str2 != null) {
            zzb.zzv(str2);
        }
        String str3 = this.zzgc;
        if (str3 != null) {
            zzb.zzw(str3);
        }
        ActionCodeSettings actionCodeSettings = this.zzig;
        if (actionCodeSettings != null) {
            zzb.zzc(actionCodeSettings.O()).zzd(this.zzig.a());
            if (this.zzig.U() != null) {
                zzb.zzx(this.zzig.U());
            }
            if (this.zzig.R() != null) {
                zzb.zzy(this.zzig.R());
            }
            if (this.zzig.zzbt() != null) {
                zzb.zzz(this.zzig.zzbt());
            }
            if (this.zzig.Q() != null) {
                zzb.zzaa(this.zzig.Q());
            }
            if (this.zzig.P() != null) {
                zzb.zzab(this.zzig.P());
            }
            if (this.zzig.W() != null) {
                zzb.zzad(this.zzig.W());
            }
        }
        String str4 = this.zzgw;
        if (str4 != null) {
            zzb.zzac(str4);
        }
        return (zzj.zzh) zzb.zzhn();
    }
}

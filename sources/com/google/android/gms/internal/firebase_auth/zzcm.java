package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.api.internal.zzff;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcm implements zzff<zzj.zzd> {
    private static final Logger zzgg = new Logger("EmailLinkSignInRequest", new String[0]);
    private final String zzgc;
    private final String zzgh;
    private final String zzgj;

    public zzcm(EmailAuthCredential emailAuthCredential, String str) {
        String email = emailAuthCredential.getEmail();
        Preconditions.b(email);
        this.zzgh = email;
        String O = emailAuthCredential.O();
        Preconditions.b(O);
        this.zzgj = O;
        this.zzgc = str;
    }

    private static String zzb(String str, String str2) {
        Uri parse = Uri.parse(str);
        try {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return parse.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(parse.getQueryParameter("link")).getQueryParameter(str2);
            }
            return null;
        } catch (UnsupportedOperationException e2) {
            Logger logger = zzgg;
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 19 + String.valueOf(message).length());
            sb.append("No ");
            sb.append(str2);
            sb.append(" in signInLink: ");
            sb.append(message);
            logger.d("EmailLinkSignInRequest", sb.toString());
            return null;
        }
    }

    public final /* synthetic */ zzhc zzds() {
        zzj.zzd.zza zzl = zzj.zzd.zzp().zzl(this.zzgh);
        String zzb = zzb(this.zzgj, "oobCode");
        String zzb2 = zzb(this.zzgj, "tenantId");
        if (zzb != null) {
            zzl.zzk(zzb);
        }
        if (zzb2 != null) {
            zzl.zzn(zzb2);
        }
        String str = this.zzgc;
        if (str != null) {
            zzl.zzm(str);
        }
        return (zzj.zzd) zzl.zzhn();
    }
}

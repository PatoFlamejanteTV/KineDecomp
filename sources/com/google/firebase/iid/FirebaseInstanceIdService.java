package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

@Deprecated
/* loaded from: classes2.dex */
public class FirebaseInstanceIdService extends zzb {
    @Override // com.google.firebase.iid.zzb
    protected final Intent a(Intent intent) {
        return zzav.a().f17416d.poll();
    }

    @Deprecated
    public void a() {
    }

    @Override // com.google.firebase.iid.zzb
    public final void c(Intent intent) {
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            a();
            return;
        }
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length());
                sb.append("Received command: ");
                sb.append(stringExtra);
                sb.append(" - ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            if (!"RST".equals(stringExtra) && !"RST_FULL".equals(stringExtra)) {
                if ("SYNC".equals(stringExtra)) {
                    FirebaseInstanceId.b().m();
                    return;
                }
                return;
            }
            FirebaseInstanceId.b().i();
        }
    }
}

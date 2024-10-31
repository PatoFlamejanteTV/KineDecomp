package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzco {
    private final String name;
    private final long zzabz;
    private final /* synthetic */ zzcm zzaca;

    private zzco(zzcm zzcmVar, String str, long j) {
        this.zzaca = zzcmVar;
        Preconditions.b(str);
        Preconditions.a(j > 0);
        this.name = str;
        this.zzabz = j;
    }

    private final void zzgb() {
        SharedPreferences sharedPreferences;
        long a2 = this.zzaca.zzcn().a();
        sharedPreferences = this.zzaca.zzabv;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(zzgf());
        edit.remove(zzgg());
        edit.putLong(zzge(), a2);
        edit.commit();
    }

    private final long zzgd() {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.zzaca.zzabv;
        return sharedPreferences.getLong(zzge(), 0L);
    }

    private final String zzge() {
        return String.valueOf(this.name).concat(":start");
    }

    private final String zzgf() {
        return String.valueOf(this.name).concat(":count");
    }

    @VisibleForTesting
    private final String zzgg() {
        return String.valueOf(this.name).concat(":value");
    }

    public final void zzae(String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        SharedPreferences sharedPreferences3;
        if (zzgd() == 0) {
            zzgb();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            sharedPreferences = this.zzaca.zzabv;
            long j = sharedPreferences.getLong(zzgf(), 0L);
            if (j <= 0) {
                sharedPreferences3 = this.zzaca.zzabv;
                SharedPreferences.Editor edit = sharedPreferences3.edit();
                edit.putString(zzgg(), str);
                edit.putLong(zzgf(), 1L);
                edit.apply();
                return;
            }
            long j2 = j + 1;
            boolean z = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / j2;
            sharedPreferences2 = this.zzaca.zzabv;
            SharedPreferences.Editor edit2 = sharedPreferences2.edit();
            if (z) {
                edit2.putString(zzgg(), str);
            }
            edit2.putLong(zzgf(), j2);
            edit2.apply();
        }
    }

    public final Pair<String, Long> zzgc() {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        long zzgd = zzgd();
        long abs = zzgd == 0 ? 0L : Math.abs(zzgd - this.zzaca.zzcn().a());
        long j = this.zzabz;
        if (abs < j) {
            return null;
        }
        if (abs <= (j << 1)) {
            sharedPreferences = this.zzaca.zzabv;
            String string = sharedPreferences.getString(zzgg(), null);
            sharedPreferences2 = this.zzaca.zzabv;
            long j2 = sharedPreferences2.getLong(zzgf(), 0L);
            zzgb();
            if (string == null || j2 <= 0) {
                return null;
            }
            return new Pair<>(string, Long.valueOf(j2));
        }
        zzgb();
        return null;
    }
}

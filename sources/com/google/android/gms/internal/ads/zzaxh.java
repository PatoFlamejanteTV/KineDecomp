package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzark
/* loaded from: classes2.dex */
public final class zzaxh {
    private final Clock zzehz;
    private final zzaxt zzeia;
    private final String zzeic;
    private final String zzeid;
    private final Object mLock = new Object();
    private long zzeie = -1;
    private long zzeif = -1;
    private boolean zzebk = false;
    private long zzeig = -1;
    private long zzeih = 0;
    private long zzeii = -1;
    private long zzeij = -1;
    private final LinkedList<C1010nd> zzeib = new LinkedList<>();

    public zzaxh(Clock clock, zzaxt zzaxtVar, String str, String str2) {
        this.zzehz = clock;
        this.zzeia = zzaxtVar;
        this.zzeic = str;
        this.zzeid = str2;
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzeic);
            bundle.putString("slotid", this.zzeid);
            bundle.putBoolean("ismediation", this.zzebk);
            bundle.putLong("treq", this.zzeii);
            bundle.putLong("tresponse", this.zzeij);
            bundle.putLong("timp", this.zzeif);
            bundle.putLong("tload", this.zzeig);
            bundle.putLong("pcc", this.zzeih);
            bundle.putLong("tfetch", this.zzeie);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<C1010nd> it = this.zzeib.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void zzaj(boolean z) {
        synchronized (this.mLock) {
            if (this.zzeij != -1) {
                this.zzeig = this.zzehz.c();
                if (!z) {
                    this.zzeif = this.zzeig;
                    this.zzeia.zzb(this);
                }
            }
        }
    }

    public final void zzak(boolean z) {
        synchronized (this.mLock) {
            if (this.zzeij != -1) {
                this.zzebk = z;
                this.zzeia.zzb(this);
            }
        }
    }

    public final void zzas(long j) {
        synchronized (this.mLock) {
            this.zzeij = j;
            if (this.zzeij != -1) {
                this.zzeia.zzb(this);
            }
        }
    }

    public final void zzat(long j) {
        synchronized (this.mLock) {
            if (this.zzeij != -1) {
                this.zzeie = j;
                this.zzeia.zzb(this);
            }
        }
    }

    public final void zzn(zzwb zzwbVar) {
        synchronized (this.mLock) {
            this.zzeii = this.zzehz.c();
            this.zzeia.zzb(zzwbVar, this.zzeii);
        }
    }

    public final void zzxv() {
        synchronized (this.mLock) {
            if (this.zzeij != -1 && this.zzeif == -1) {
                this.zzeif = this.zzehz.c();
                this.zzeia.zzb(this);
            }
            this.zzeia.zzxv();
        }
    }

    public final void zzxw() {
        synchronized (this.mLock) {
            if (this.zzeij != -1) {
                C1010nd c1010nd = new C1010nd(this);
                c1010nd.d();
                this.zzeib.add(c1010nd);
                this.zzeih++;
                this.zzeia.zzxw();
                this.zzeia.zzb(this);
            }
        }
    }

    public final void zzxx() {
        synchronized (this.mLock) {
            if (this.zzeij != -1 && !this.zzeib.isEmpty()) {
                C1010nd last = this.zzeib.getLast();
                if (last.b() == -1) {
                    last.c();
                    this.zzeia.zzb(this);
                }
            }
        }
    }

    public final String zzxy() {
        return this.zzeic;
    }
}

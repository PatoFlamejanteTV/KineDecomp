package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzgr
/* loaded from: classes.dex */
public class zzht {
    private boolean zzGb;
    private final LinkedList<a> zzHE;
    private final String zzHF;
    private final String zzHG;
    private long zzHH;
    private long zzHI;
    private long zzHJ;
    private long zzHK;
    private long zzHL;
    private long zzHM;
    private final zzhu zzpV;
    private final Object zzpd;

    /* JADX INFO: Access modifiers changed from: private */
    @zzgr
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f1723a = -1;
        private long b = -1;

        public long a() {
            return this.b;
        }

        public void b() {
            this.b = SystemClock.elapsedRealtime();
        }

        public void c() {
            this.f1723a = SystemClock.elapsedRealtime();
        }

        public Bundle d() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.f1723a);
            bundle.putLong("tclose", this.b);
            return bundle;
        }
    }

    public zzht(zzhu zzhuVar, String str, String str2) {
        this.zzpd = new Object();
        this.zzHH = -1L;
        this.zzHI = -1L;
        this.zzGb = false;
        this.zzHJ = -1L;
        this.zzHK = 0L;
        this.zzHL = -1L;
        this.zzHM = -1L;
        this.zzpV = zzhuVar;
        this.zzHF = str;
        this.zzHG = str2;
        this.zzHE = new LinkedList<>();
    }

    public zzht(String str, String str2) {
        this(com.google.android.gms.ads.internal.zzp.h(), str, str2);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zzpd) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzHF);
            bundle.putString("slotid", this.zzHG);
            bundle.putBoolean("ismediation", this.zzGb);
            bundle.putLong("treq", this.zzHL);
            bundle.putLong("tresponse", this.zzHM);
            bundle.putLong("timp", this.zzHI);
            bundle.putLong("tload", this.zzHJ);
            bundle.putLong("pcc", this.zzHK);
            bundle.putLong("tfetch", this.zzHH);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<a> it = this.zzHE.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public void zzgf() {
        synchronized (this.zzpd) {
            if (this.zzHM != -1 && this.zzHI == -1) {
                this.zzHI = SystemClock.elapsedRealtime();
                this.zzpV.zza(this);
            }
            this.zzpV.zzgn().zzgf();
        }
    }

    public void zzgg() {
        synchronized (this.zzpd) {
            if (this.zzHM != -1) {
                a aVar = new a();
                aVar.c();
                this.zzHE.add(aVar);
                this.zzHK++;
                this.zzpV.zzgn().zzgg();
                this.zzpV.zza(this);
            }
        }
    }

    public void zzgh() {
        synchronized (this.zzpd) {
            if (this.zzHM != -1 && !this.zzHE.isEmpty()) {
                a last = this.zzHE.getLast();
                if (last.a() == -1) {
                    last.b();
                    this.zzpV.zza(this);
                }
            }
        }
    }

    public void zzi(AdRequestParcel adRequestParcel) {
        synchronized (this.zzpd) {
            this.zzHL = SystemClock.elapsedRealtime();
            this.zzpV.zzgn().zzb(adRequestParcel, this.zzHL);
        }
    }

    public void zzl(long j) {
        synchronized (this.zzpd) {
            this.zzHM = j;
            if (this.zzHM != -1) {
                this.zzpV.zza(this);
            }
        }
    }

    public void zzm(long j) {
        synchronized (this.zzpd) {
            if (this.zzHM != -1) {
                this.zzHH = j;
                this.zzpV.zza(this);
            }
        }
    }

    public void zzy(boolean z) {
        synchronized (this.zzpd) {
            if (this.zzHM != -1) {
                this.zzHJ = SystemClock.elapsedRealtime();
                if (!z) {
                    this.zzHI = this.zzHJ;
                    this.zzpV.zza(this);
                }
            }
        }
    }

    public void zzz(boolean z) {
        synchronized (this.zzpd) {
            if (this.zzHM != -1) {
                this.zzGb = z;
                this.zzpV.zza(this);
            }
        }
    }
}

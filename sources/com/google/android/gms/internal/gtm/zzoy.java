package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzoy {
    private final List<zzot> zzatu;
    private final List<zzot> zzatv;
    private final List<zzot> zzatw;
    private final List<zzot> zzatx;
    private final List<zzot> zzava;
    private final List<zzot> zzavb;
    private final List<String> zzavc;
    private final List<String> zzavd;
    private final List<String> zzave;
    private final List<String> zzavf;

    /* JADX INFO: Access modifiers changed from: private */
    public zzoy() {
        this.zzatu = new ArrayList();
        this.zzatv = new ArrayList();
        this.zzatw = new ArrayList();
        this.zzatx = new ArrayList();
        this.zzava = new ArrayList();
        this.zzavb = new ArrayList();
        this.zzavc = new ArrayList();
        this.zzavd = new ArrayList();
        this.zzave = new ArrayList();
        this.zzavf = new ArrayList();
    }

    public final zzoy zzct(String str) {
        this.zzave.add(str);
        return this;
    }

    public final zzoy zzcu(String str) {
        this.zzavf.add(str);
        return this;
    }

    public final zzoy zzcv(String str) {
        this.zzavc.add(str);
        return this;
    }

    public final zzoy zzcw(String str) {
        this.zzavd.add(str);
        return this;
    }

    public final zzoy zzd(zzot zzotVar) {
        this.zzatu.add(zzotVar);
        return this;
    }

    public final zzoy zze(zzot zzotVar) {
        this.zzatv.add(zzotVar);
        return this;
    }

    public final zzoy zzf(zzot zzotVar) {
        this.zzatw.add(zzotVar);
        return this;
    }

    public final zzoy zzg(zzot zzotVar) {
        this.zzatx.add(zzotVar);
        return this;
    }

    public final zzoy zzh(zzot zzotVar) {
        this.zzava.add(zzotVar);
        return this;
    }

    public final zzoy zzi(zzot zzotVar) {
        this.zzavb.add(zzotVar);
        return this;
    }

    public final zzox zzms() {
        return new zzox(this.zzatu, this.zzatv, this.zzatw, this.zzatx, this.zzava, this.zzavb, this.zzavc, this.zzavd, this.zzave, this.zzavf);
    }

    public /* synthetic */ zzoy(Q q) {
        this();
    }
}

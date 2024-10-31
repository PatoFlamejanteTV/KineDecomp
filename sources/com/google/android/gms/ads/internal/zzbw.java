package com.google.android.gms.ads.internal;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzaeb;
import com.google.android.gms.internal.ads.zzaee;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaek;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzafz;
import com.google.android.gms.internal.ads.zzagf;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzauu;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzaxh;
import com.google.android.gms.internal.ads.zzaxs;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzcq;
import com.google.android.gms.internal.ads.zzcu;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzwx;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxq;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyv;
import com.google.android.gms.internal.ads.zzzw;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbw implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    zzyv A;
    zzaen B;
    List<Integer> C;
    zzabg D;
    zzavb E;
    zzauu F;
    public String G;
    public String H;
    List<String> I;
    public zzaxs J;
    View K;
    public int L;
    boolean M;
    private HashSet<zzaxh> N;
    private int O;
    private int P;
    private zzbai Q;
    private boolean R;
    private boolean S;
    private boolean T;

    /* renamed from: a, reason: collision with root package name */
    final String f10249a;

    /* renamed from: b, reason: collision with root package name */
    public String f10250b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f10251c;

    /* renamed from: d, reason: collision with root package name */
    final zzcu f10252d;

    /* renamed from: e, reason: collision with root package name */
    public final zzbbi f10253e;

    /* renamed from: f, reason: collision with root package name */
    zzbx f10254f;

    /* renamed from: g, reason: collision with root package name */
    public zzaxv f10255g;

    /* renamed from: h, reason: collision with root package name */
    public zzazb f10256h;
    public zzwf i;
    public zzaxf j;
    public zzaxg k;
    public zzaxh l;
    zzwx m;
    zzxa n;
    zzxt o;
    zzxq p;
    zzxz q;
    zzaeb r;
    zzaee s;
    zzaeq t;
    zzagf u;
    SimpleArrayMap<String, zzaeh> v;
    SimpleArrayMap<String, zzaek> w;
    zzacp x;
    zzzw y;
    zzafz z;

    public zzbw(Context context, zzwf zzwfVar, String str, zzbbi zzbbiVar) {
        this(context, zzwfVar, str, zzbbiVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(View view) {
        zzcq zzab;
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzctk)).booleanValue() && (zzab = this.f10252d.zzab()) != null) {
            zzab.zzb(view);
        }
    }

    public final void b() {
        zzbgg zzbggVar;
        zzaxf zzaxfVar = this.j;
        if (zzaxfVar == null || (zzbggVar = zzaxfVar.zzdrv) == null) {
            return;
        }
        zzbggVar.destroy();
    }

    public final void c() {
        zzalj zzaljVar;
        zzaxf zzaxfVar = this.j;
        if (zzaxfVar == null || (zzaljVar = zzaxfVar.zzdnc) == null) {
            return;
        }
        try {
            zzaljVar.destroy();
        } catch (RemoteException unused) {
            zzbbd.zzeo("Could not destroy mediation adapter.");
        }
    }

    public final boolean d() {
        return this.L == 0;
    }

    public final boolean e() {
        return this.L == 1;
    }

    public final String f() {
        return (this.R && this.S) ? "" : this.R ? this.T ? "top-scrollable" : "top-locked" : this.S ? this.T ? "bottom-scrollable" : "bottom-locked" : "";
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        b(false);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        b(true);
        this.T = true;
    }

    private zzbw(Context context, zzwf zzwfVar, String str, zzbbi zzbbiVar, zzcu zzcuVar) {
        this.J = null;
        this.K = null;
        this.L = 0;
        this.M = false;
        this.N = null;
        this.O = -1;
        this.P = -1;
        this.R = true;
        this.S = true;
        this.T = false;
        zzaan.initialize(context);
        if (zzbv.i().zzyh() != null) {
            List<String> zzqx = zzaan.zzqx();
            int i = zzbbiVar.zzeou;
            if (i != 0) {
                zzqx.add(Integer.toString(i));
            }
            zzbv.i().zzyh().zzg(zzqx);
        }
        this.f10249a = UUID.randomUUID().toString();
        if (!zzwfVar.zzckl && !zzwfVar.zzckn) {
            this.f10254f = new zzbx(context, str, zzbbiVar.zzdp, this, this);
            this.f10254f.setMinimumWidth(zzwfVar.widthPixels);
            this.f10254f.setMinimumHeight(zzwfVar.heightPixels);
            this.f10254f.setVisibility(4);
        } else {
            this.f10254f = null;
        }
        this.i = zzwfVar;
        this.f10250b = str;
        this.f10251c = context;
        this.f10253e = zzbbiVar;
        this.f10252d = new zzcu(new zzag(this));
        this.Q = new zzbai(200L);
        this.w = new SimpleArrayMap<>();
    }

    private final void b(boolean z) {
        zzaxf zzaxfVar;
        zzbgg zzbggVar;
        View findViewById;
        if (this.f10254f == null || (zzaxfVar = this.j) == null || (zzbggVar = zzaxfVar.zzdrv) == null || zzbggVar.zzadl() == null) {
            return;
        }
        if (!z || this.Q.tryAcquire()) {
            if (this.j.zzdrv.zzadl().zzmu()) {
                int[] iArr = new int[2];
                this.f10254f.getLocationOnScreen(iArr);
                zzwu.zzpv();
                int zzb = zzbat.zzb(this.f10251c, iArr[0]);
                zzwu.zzpv();
                int zzb2 = zzbat.zzb(this.f10251c, iArr[1]);
                if (zzb != this.O || zzb2 != this.P) {
                    this.O = zzb;
                    this.P = zzb2;
                    this.j.zzdrv.zzadl().zza(this.O, this.P, !z);
                }
            }
            zzbx zzbxVar = this.f10254f;
            if (zzbxVar == null || (findViewById = zzbxVar.getRootView().findViewById(R.id.content)) == null) {
                return;
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.f10254f.getGlobalVisibleRect(rect);
            findViewById.getGlobalVisibleRect(rect2);
            if (rect.top != rect2.top) {
                this.R = false;
            }
            if (rect.bottom != rect2.bottom) {
                this.S = false;
            }
        }
    }

    public final void a(HashSet<zzaxh> hashSet) {
        this.N = hashSet;
    }

    public final HashSet<zzaxh> a() {
        return this.N;
    }

    public final void a(boolean z) {
        zzaxf zzaxfVar;
        zzbgg zzbggVar;
        if (this.L == 0 && (zzaxfVar = this.j) != null && (zzbggVar = zzaxfVar.zzdrv) != null) {
            zzbggVar.stopLoading();
        }
        zzaxv zzaxvVar = this.f10255g;
        if (zzaxvVar != null) {
            zzaxvVar.cancel();
        }
        zzazb zzazbVar = this.f10256h;
        if (zzazbVar != null) {
            zzazbVar.cancel();
        }
        if (z) {
            this.j = null;
        }
    }
}

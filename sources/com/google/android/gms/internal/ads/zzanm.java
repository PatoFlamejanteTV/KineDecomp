package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzanm extends zzanh {
    private final zzbit zzdon;

    public zzanm(zzbit zzbitVar) {
        this.zzdon = zzbitVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zzcw(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1396342996:
                if (str.equals("banner")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1052618729:
                if (str.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -239580146:
                if (str.equals("rewarded")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 604727084:
                if (str.equals("interstitial")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            return com.google.android.gms.ads.zza.f10313a;
        }
        if (c2 == 1) {
            return com.google.android.gms.ads.zza.f10314b;
        }
        if (c2 == 2) {
            return com.google.android.gms.ads.zza.f10315c;
        }
        if (c2 == 3) {
            return com.google.android.gms.ads.zza.f10316d;
        }
        throw new IllegalArgumentException("Internal Error");
    }

    private static Bundle zzcx(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzbbd.zzeo(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e2) {
            zzbbd.zzb("", e2);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzyp getVideoController() {
        Object obj = this.zzdon;
        if (!(obj instanceof com.google.android.gms.ads.mediation.zzb)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zzb) obj).getVideoController();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void showInterstitial() throws RemoteException {
        zzbiq zzbiqVar = null;
        try {
            zzbiqVar.zzxh();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzamy zzamyVar, zzalm zzalmVar, zzwf zzwfVar) throws RemoteException {
        try {
            Bb bb = new Bb(this, zzamyVar, zzalmVar);
            zzbit zzbitVar = this.zzdon;
            new zzbis((Context) ObjectWrapper.a(iObjectWrapper), str, zzcx(str2), bundle);
            com.google.android.gms.ads.zzc.a(zzwfVar.width, zzwfVar.height, zzwfVar.zzckk);
            bb.zzbw(String.valueOf(zzbitVar.getClass().getSimpleName()).concat(" does not support banner ads."));
        } catch (Throwable th) {
            zzbbd.zzb("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzdon.initialize((Context) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzans zzvi() throws RemoteException {
        zzans.zza(this.zzdon.zzafj());
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzans zzvj() throws RemoteException {
        zzans.zza(this.zzdon.zzafi());
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzvk() throws RemoteException {
        zzbir zzbirVar = null;
        try {
            zzbirVar.zzxh();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzana zzanaVar, zzalm zzalmVar) throws RemoteException {
        try {
            Cb cb = new Cb(this, zzanaVar, zzalmVar);
            zzbit zzbitVar = this.zzdon;
            new zzbis((Context) ObjectWrapper.a(iObjectWrapper), str, zzcx(str2), bundle);
            cb.zzbw(String.valueOf(zzbitVar.getClass().getSimpleName()).concat(" does not support interstitial ads."));
        } catch (Throwable th) {
            zzbbd.zzb("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzane zzaneVar, zzalm zzalmVar) throws RemoteException {
        try {
            Db db = new Db(this, zzaneVar, zzalmVar);
            zzbit zzbitVar = this.zzdon;
            new zzbis((Context) ObjectWrapper.a(iObjectWrapper), str, zzcx(str2), bundle);
            db.zzbw(String.valueOf(zzbitVar.getClass().getSimpleName()).concat(" does not support rewarded ads."));
        } catch (Throwable th) {
            zzbbd.zzb("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzanc zzancVar, zzalm zzalmVar) throws RemoteException {
        try {
            Eb eb = new Eb(this, zzancVar, zzalmVar);
            zzbit zzbitVar = this.zzdon;
            new zzbis((Context) ObjectWrapper.a(iObjectWrapper), str, zzcx(str2), bundle);
            eb.zzbw(String.valueOf(zzbitVar.getClass().getSimpleName()).concat(" does not support native ads."));
        } catch (Throwable th) {
            zzbbd.zzb("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzbiv, com.google.android.gms.internal.ads.Fb] */
    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzwf zzwfVar, zzanj zzanjVar) throws RemoteException {
        try {
            ?? fb = new Fb(this, zzanjVar);
            this.zzdon.zza(new zzbiu((Context) ObjectWrapper.a(iObjectWrapper), new com.google.android.gms.ads.mediation.zza(zzcw(str), bundle2), bundle, com.google.android.gms.ads.zzc.a(zzwfVar.width, zzwfVar.height, zzwfVar.zzckk)), fb);
        } catch (Throwable th) {
            zzbbd.zzb("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            try {
                arrayList.add(new com.google.android.gms.ads.mediation.zza(zzcw(strArr[i]), bundleArr[i]));
            } catch (IndexOutOfBoundsException unused) {
                throw new RemoteException();
            }
        }
    }
}

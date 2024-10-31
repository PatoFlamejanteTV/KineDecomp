package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzark
/* loaded from: classes2.dex */
public final class zzaom {

    @VisibleForTesting
    private zzbiz zzdqo;
    private static final Object sLock = new Object();

    @VisibleForTesting
    private static boolean zztd = false;

    @VisibleForTesting
    private static boolean zzdqn = false;

    @VisibleForTesting
    private final void zzl(Context context) {
        synchronized (sLock) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwy)).booleanValue() && !zzdqn) {
                try {
                    zzdqn = true;
                    this.zzdqo = (zzbiz) zzbbe.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", Pb.f11745a);
                } catch (zzbbg e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final String getVersion(Context context) {
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcwy)).booleanValue()) {
            return null;
        }
        try {
            zzl(context);
            String valueOf = String.valueOf(this.zzdqo.getVersion());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    public final boolean zzk(Context context) {
        synchronized (sLock) {
            if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcwy)).booleanValue()) {
                return false;
            }
            if (zztd) {
                return true;
            }
            try {
                zzl(context);
                boolean zzab = this.zzdqo.zzab(ObjectWrapper.a(context));
                zztd = zzab;
                return zzab;
            } catch (RemoteException e2) {
                e = e2;
                zzbbd.zzd("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e3) {
                e = e3;
                zzbbd.zzd("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        synchronized (sLock) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwy)).booleanValue() && zztd) {
                try {
                    this.zzdqo.zzo(iObjectWrapper);
                } catch (RemoteException | NullPointerException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper) {
        synchronized (sLock) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwy)).booleanValue() && zztd) {
                try {
                    this.zzdqo.zzp(iObjectWrapper);
                } catch (RemoteException | NullPointerException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (sLock) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwy)).booleanValue() && zztd) {
                    try {
                        return this.zzdqo.zza(str, ObjectWrapper.a(webView), str2, str3, str4, str5);
                    } catch (RemoteException | NullPointerException e2) {
                        zzbbd.zzd("#007 Could not call remote method.", e2);
                        return null;
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (sLock) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwy)).booleanValue() && zztd) {
                try {
                    this.zzdqo.zza(iObjectWrapper, ObjectWrapper.a(view));
                } catch (RemoteException | NullPointerException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
        }
    }
}

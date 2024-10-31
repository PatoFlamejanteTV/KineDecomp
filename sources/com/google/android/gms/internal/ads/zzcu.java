package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes2.dex */
public final class zzcu {
    private static final String[] zzry = {"/aclk", "/pcs/click"};
    private String zzru = "googleads.g.doubleclick.net";
    private String zzrv = "/pagead/ads";
    private String zzrw = "ad.doubleclick.net";
    private String[] zzrx = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzcq zzrz;

    public zzcu(zzcq zzcqVar) {
        this.zzrz = zzcqVar;
    }

    private final boolean zza(Uri uri) {
        if (uri != null) {
            try {
                return uri.getHost().equals(this.zzrw);
            } catch (NullPointerException unused) {
                return false;
            }
        }
        throw new NullPointerException();
    }

    public final zzcq zzab() {
        return this.zzrz;
    }

    public final boolean zzb(Uri uri) {
        if (uri != null) {
            try {
                String host = uri.getHost();
                for (String str : this.zzrx) {
                    if (host.endsWith(str)) {
                        return true;
                    }
                }
            } catch (NullPointerException unused) {
            }
            return false;
        }
        throw new NullPointerException();
    }

    public final boolean zzc(Uri uri) {
        if (zzb(uri)) {
            for (String str : zzry) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Uri zza(Uri uri, Context context) throws zzcv {
        return zza(uri, context, null, false, null, null);
    }

    public final void zza(MotionEvent motionEvent) {
        this.zzrz.zza(motionEvent);
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzcv {
        try {
            return zza(uri, context, uri.getQueryParameter("ai"), true, view, activity);
        } catch (UnsupportedOperationException unused) {
            throw new zzcv("Provided Uri is not in a valid state");
        }
    }

    private final Uri zza(Uri uri, Context context, String str, boolean z, View view, Activity activity) throws zzcv {
        String zza;
        try {
            boolean zza2 = zza(uri);
            if (zza2) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzcv("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzcv("Query parameter already exists: ms");
            }
            if (z) {
                zza = this.zzrz.zza(context, str, view, activity);
            } else {
                zza = this.zzrz.zza(context);
            }
            if (zza2) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    int i = indexOf + 1;
                    return Uri.parse(uri2.substring(0, i) + "dc_ms=" + zza + ";" + uri2.substring(i));
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";dc_ms=" + zza + ";" + uri2.substring(indexOf2 + encodedPath.length()));
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 != -1) {
                int i2 = indexOf3 + 1;
                return Uri.parse(uri3.substring(0, i2) + "ms=" + zza + "&" + uri3.substring(i2));
            }
            return uri.buildUpon().appendQueryParameter("ms", zza).build();
        } catch (UnsupportedOperationException unused) {
            throw new zzcv("Provided Uri is not in a valid state");
        }
    }
}

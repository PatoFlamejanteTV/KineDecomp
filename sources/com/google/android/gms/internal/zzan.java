package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class zzan {
    private static final String[] zznC = {"/aclk", "/pcs/click"};
    private zzaj zznD;
    private String zzny = "googleads.g.doubleclick.net";
    private String zznz = "/pagead/ads";
    private String zznA = "ad.doubleclick.net";
    private String[] zznB = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    public zzan(zzaj zzajVar) {
        this.zznD = zzajVar;
    }

    private Uri zza(Uri uri, Context context, String str, boolean z) throws zzao {
        try {
            boolean zza = zza(uri);
            if (zza) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzao("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzao("Query parameter already exists: ms");
            }
            String zzb = z ? this.zznD.zzb(context, str) : this.zznD.zzb(context);
            return zza ? zzb(uri, "dc_ms", zzb) : zza(uri, "ms", zzb);
        } catch (UnsupportedOperationException e) {
            throw new zzao("Provided Uri is not in a valid state");
        }
    }

    private Uri zza(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(uri2.substring(0, indexOf + 1) + str + "=" + str2 + "&" + uri2.substring(indexOf + 1)) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri zzb(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(uri2.substring(0, indexOf + 1) + str + "=" + str2 + ";" + uri2.substring(indexOf + 1));
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";" + str + "=" + str2 + ";" + uri2.substring(encodedPath.length() + indexOf2));
    }

    public Uri zza(Uri uri, Context context) throws zzao {
        try {
            return zza(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new zzao("Provided Uri is not in a valid state");
        }
    }

    public void zza(MotionEvent motionEvent) {
        this.zznD.zza(motionEvent);
    }

    public boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zznA);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public zzaj zzab() {
        return this.zznD;
    }

    public boolean zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String str : this.zznB) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean zzc(Uri uri) {
        if (!zzb(uri)) {
            return false;
        }
        for (String str : zznC) {
            if (uri.getPath().endsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzgr
/* loaded from: classes.dex */
public final class zzij extends zzhz {
    private final Context mContext;
    private final String zzF;
    private String zzIa;
    private final String zzqV;

    public zzij(Context context, String str, String str2) {
        this.zzIa = null;
        this.mContext = context;
        this.zzqV = str;
        this.zzF = str2;
    }

    public zzij(Context context, String str, String str2, String str3) {
        this.zzIa = null;
        this.mContext = context;
        this.zzqV = str;
        this.zzF = str2;
        this.zzIa = str3;
    }

    @Override // com.google.android.gms.internal.zzhz
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        try {
            com.google.android.gms.ads.internal.util.client.zzb.d("Pinging URL: " + this.zzF);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.zzF).openConnection();
            try {
                if (TextUtils.isEmpty(this.zzIa)) {
                    com.google.android.gms.ads.internal.zzp.e().zza(this.mContext, this.zzqV, true, httpURLConnection);
                } else {
                    com.google.android.gms.ads.internal.zzp.e().zza(this.mContext, this.zzqV, true, httpURLConnection, this.zzIa);
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    com.google.android.gms.ads.internal.util.client.zzb.e("Received non-success response code " + responseCode + " from pinging URL: " + this.zzF);
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Error while pinging URL: " + this.zzF + ". " + e.getMessage());
        } catch (IndexOutOfBoundsException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Error while parsing ping URL: " + this.zzF + ". " + e2.getMessage());
        } catch (RuntimeException e3) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Error while pinging URL: " + this.zzF + ". " + e3.getMessage());
        }
    }
}

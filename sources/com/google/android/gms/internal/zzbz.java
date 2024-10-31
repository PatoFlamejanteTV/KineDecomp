package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import com.facebook.internal.ServerProtocol;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzbz {
    private Context mContext;
    private String zzqV;
    private boolean zzvA = zzby.zzuQ.get().booleanValue();
    private String zzvB = zzby.zzuR.get();
    private Map<String, String> zzvC = new LinkedHashMap();

    public zzbz(Context context, String str) {
        this.mContext = null;
        this.zzqV = null;
        this.mContext = context;
        this.zzqV = str;
        this.zzvC.put("s", "gmob_sdk");
        this.zzvC.put("v", "3");
        this.zzvC.put("os", Build.VERSION.RELEASE);
        this.zzvC.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Build.VERSION.SDK);
        this.zzvC.put("device", com.google.android.gms.ads.internal.zzp.e().zzgE());
        this.zzvC.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        zzgy zzC = com.google.android.gms.ads.internal.zzp.k().zzC(this.mContext);
        this.zzvC.put("network_coarse", Integer.toString(zzC.zzGE));
        this.zzvC.put("network_fine", Integer.toString(zzC.zzGF));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zzbV() {
        return this.zzqV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zzdg() {
        return this.zzvA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zzdh() {
        return this.zzvB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> zzdi() {
        return this.zzvC;
    }
}

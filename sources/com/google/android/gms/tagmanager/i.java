package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class i implements zzd {

    /* renamed from: a */
    private final /* synthetic */ zza f14204a;

    public i(zza zzaVar) {
        this.f14204a = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzd
    public final AdvertisingIdClient.Info a() {
        Context context;
        try {
            context = this.f14204a.i;
            return AdvertisingIdClient.getAdvertisingIdInfo(context);
        } catch (GooglePlayServicesNotAvailableException e2) {
            this.f14204a.a();
            zzdi.b("GooglePlayServicesNotAvailableException getting Advertising Id Info", e2);
            return null;
        } catch (GooglePlayServicesRepairableException e3) {
            zzdi.b("GooglePlayServicesRepairableException getting Advertising Id Info", e3);
            return null;
        } catch (IOException e4) {
            zzdi.b("IOException getting Ad Id Info", e4);
            return null;
        } catch (IllegalStateException e5) {
            zzdi.b("IllegalStateException getting Advertising Id Info", e5);
            return null;
        } catch (Exception e6) {
            zzdi.b("Unknown exception. Could not get the Advertising Id Info.", e6);
            return null;
        }
    }
}

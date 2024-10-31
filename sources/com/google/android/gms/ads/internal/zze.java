package com.google.android.gms.ads.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zziz;

@zzgr
/* loaded from: classes.dex */
public class zze {

    /* renamed from: a, reason: collision with root package name */
    private zza f656a;
    private boolean b;
    private boolean c;

    /* loaded from: classes.dex */
    public interface zza {
        void a(String str);
    }

    @zzgr
    /* loaded from: classes.dex */
    public static class zzb implements zza {

        /* renamed from: a, reason: collision with root package name */
        private final zzhs.zza f657a;
        private final zziz b;

        public zzb(zzhs.zza zzaVar, zziz zzizVar) {
            this.f657a = zzaVar;
            this.b = zzizVar;
        }

        @Override // com.google.android.gms.ads.internal.zze.zza
        public void a(String str) {
            com.google.android.gms.ads.internal.util.client.zzb.a("An auto-clicking creative is blocked");
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("https");
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter(ShareConstants.WEB_DIALOG_PARAM_ID, "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter("navigationURL", str);
            }
            if (this.f657a != null && this.f657a.zzHD != null && !TextUtils.isEmpty(this.f657a.zzHD.o)) {
                builder.appendQueryParameter("debugDialog", this.f657a.zzHD.o);
            }
            zzp.e().zzc(this.b.getContext(), this.b.zzhh().b, builder.toString());
        }
    }

    public zze() {
        this.c = zzby.zzus.get().booleanValue();
    }

    public zze(boolean z) {
        this.c = z;
    }

    public void a() {
        this.b = true;
    }

    public void a(zza zzaVar) {
        this.f656a = zzaVar;
    }

    public void a(String str) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Action was blocked because no click was detected.");
        if (this.f656a != null) {
            this.f656a.a(str);
        }
    }

    public boolean b() {
        return !this.c || this.b;
    }
}

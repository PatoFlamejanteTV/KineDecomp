package com.google.android.gms.ads.internal.formats;

import android.text.TextUtils;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zziz;
import java.util.Map;
import org.keyczar.Keyczar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzh f565a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzh zzhVar) {
        this.f565a = zzhVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        zziz zzizVar2;
        zziz zzizVar3;
        zziz zzizVar4;
        zzizVar2 = this.f565a.j;
        zzizVar2.zzhe().zza(new c(this, map));
        String str = map.get("overlayHtml");
        String str2 = map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzizVar4 = this.f565a.j;
            zzizVar4.loadData(str, "text/html", Keyczar.DEFAULT_ENCODING);
        } else {
            zzizVar3 = this.f565a.j;
            zzizVar3.loadDataWithBaseURL(str2, str, "text/html", Keyczar.DEFAULT_ENCODING, null);
        }
    }
}

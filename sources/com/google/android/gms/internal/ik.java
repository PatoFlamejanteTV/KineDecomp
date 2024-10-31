package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqh;

/* loaded from: classes.dex */
class ik extends zzqh.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1627a;
    final /* synthetic */ String b;
    final /* synthetic */ Uri c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ zzqh f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ik(zzqh zzqhVar, GoogleApiClient googleApiClient, int i, String str, Uri uri, String str2, String str3) {
        super(googleApiClient, null);
        this.f = zzqhVar;
        this.f1627a = i;
        this.b = str;
        this.c = uri;
        this.d = str2;
        this.e = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzlb.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
        zzeVar.a(this, this.f1627a, this.b, this.c, this.d, this.e);
    }
}

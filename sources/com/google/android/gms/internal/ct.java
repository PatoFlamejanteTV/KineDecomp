package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.google.android.gms.internal.zzih;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements zzih.zza<com.google.android.gms.ads.internal.formats.zzc> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f1486a;
    final /* synthetic */ double b;
    final /* synthetic */ String c;
    final /* synthetic */ zzgm d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(zzgm zzgmVar, boolean z, double d, String str) {
        this.d = zzgmVar;
        this.f1486a = z;
        this.b = d;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.zzih.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zzc zzfF() {
        this.d.zza(2, this.f1486a);
        return null;
    }

    @Override // com.google.android.gms.internal.zzih.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zzc zzh(InputStream inputStream) {
        byte[] bArr;
        try {
            bArr = zzmt.zzk(inputStream);
        } catch (IOException e) {
            bArr = null;
        }
        if (bArr == null) {
            this.d.zza(2, this.f1486a);
            return null;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (decodeByteArray == null) {
            this.d.zza(2, this.f1486a);
            return null;
        }
        decodeByteArray.setDensity((int) (160.0d * this.b));
        return new com.google.android.gms.ads.internal.formats.zzc(new BitmapDrawable(Resources.getSystem(), decodeByteArray), Uri.parse(this.c), this.b);
    }
}

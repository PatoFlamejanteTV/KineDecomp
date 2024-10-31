package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.common.util.PlatformVersion;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.ac, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0825ac implements zzazy<zzabr> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f12049a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ double f12050b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ boolean f12051c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f12052d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzapw f12053e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0825ac(zzapw zzapwVar, boolean z, double d2, boolean z2, String str) {
        this.f12053e = zzapwVar;
        this.f12049a = z;
        this.f12050b = d2;
        this.f12051c = z2;
        this.f12052d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzazy
    @TargetApi(19)
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzabr zze(InputStream inputStream) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (this.f12050b * 160.0d);
        if (!this.f12051c) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        } catch (Exception e2) {
            zzbbd.zzb("Error grabbing image.", e2);
            bitmap = null;
        }
        if (bitmap == null) {
            this.f12053e.zzh(2, this.f12049a);
            return null;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (PlatformVersion.f() && zzaxz.zzza()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int allocationByteCount = bitmap.getAllocationByteCount();
            long j = uptimeMillis2 - uptimeMillis;
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j);
            sb.append(" on ui thread: ");
            sb.append(z);
            zzaxz.v(sb.toString());
        }
        return new zzabr(new BitmapDrawable(Resources.getSystem(), bitmap), Uri.parse(this.f12052d), this.f12050b);
    }

    @Override // com.google.android.gms.internal.ads.zzazy
    public final /* synthetic */ zzabr zzwf() {
        this.f12053e.zzh(2, this.f12049a);
        return null;
    }
}

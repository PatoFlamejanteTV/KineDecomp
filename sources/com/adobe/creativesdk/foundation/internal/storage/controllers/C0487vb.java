package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetsRecyclerView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.vb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0487vb implements Db.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sa f6507a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f6508b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f6509c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Db f6510d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0487vb(Db db, Sa sa, int i, boolean z) {
        this.f6510d = db;
        this.f6507a = sa;
        this.f6508b = i;
        this.f6509c = z;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.c
    public void a(C0330a c0330a, Bitmap bitmap, boolean z) {
        String str;
        int lastIndexOf;
        if (this.f6507a.f() == this.f6508b) {
            this.f6507a.a(bitmap, this.f6509c ? 0.3f : 1.0f, true);
            Object obj = c0330a.f5278g;
            if (obj instanceof C0533a) {
                Sa sa = this.f6507a;
                if (sa.q != null && sa.p != null) {
                    C0533a c0533a = (C0533a) obj;
                    if (c0533a instanceof AdobeAssetFileInternal) {
                        AdobeAssetFileInternal adobeAssetFileInternal = (AdobeAssetFileInternal) c0533a;
                        if (adobeAssetFileInternal.canStreamVideo()) {
                            long videoDuration = adobeAssetFileInternal.getVideoDuration();
                            String format = String.format("%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(videoDuration)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(videoDuration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(videoDuration))));
                            this.f6507a.r.setVisibility(0);
                            this.f6507a.s.setVisibility(8);
                            this.f6507a.q.setText(format);
                            this.f6507a.p.setImageResource(c.a.a.a.b.d.video_indicator);
                        } else {
                            this.f6507a.r.setVisibility(8);
                            this.f6507a.s.setVisibility(0);
                        }
                    }
                }
            }
            if (c0330a != null) {
                if (c0330a.f5278g instanceof AdobePhotoCollection) {
                    if (bitmap == null) {
                        this.f6507a.l.setImageResource(c.a.a.a.b.d.empty_lightroom);
                        this.f6507a.l.setScaleType(ImageView.ScaleType.CENTER);
                        return;
                    }
                    return;
                }
                if (bitmap != null || (lastIndexOf = (str = c0330a.f5273b).lastIndexOf(46)) < 0) {
                    return;
                }
                this.f6510d.a(this.f6507a, str.substring(lastIndexOf, str.length()).toLowerCase());
            }
        }
    }
}

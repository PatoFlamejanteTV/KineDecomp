package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexvideoeditor.NexImageLoader;

/* compiled from: UniformTimelineView.java */
/* loaded from: classes2.dex */
class W extends c.e.a.a.f {
    final /* synthetic */ UniformTimelineView o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(UniformTimelineView uniformTimelineView, Context context) {
        super(context);
        this.o = uniformTimelineView;
    }

    @Override // c.e.a.a.f
    protected Bitmap a(Object obj) {
        if (obj == null) {
            return null;
        }
        String valueOf = String.valueOf(obj);
        int indexOf = valueOf.indexOf(58);
        String substring = indexOf <= 0 ? null : valueOf.substring(indexOf + 1, valueOf.length());
        if (substring == null) {
            return null;
        }
        if (valueOf.startsWith("large")) {
            int dimensionPixelSize = this.o.getContext().getResources().getDimensionPixelSize(R.dimen.timeline3_primaryTimelineHeight);
            int dimensionPixelSize2 = this.o.getContext().getResources().getDimensionPixelSize(R.dimen.timeline3_primaryMaxThumbWidth);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(substring, options);
            options.inJustDecodeBounds = false;
            float f2 = options.outWidth / options.outHeight;
            float f3 = dimensionPixelSize;
            Bitmap a2 = NexImageLoader.loadBitmap(substring, Math.min(dimensionPixelSize2, (int) (f2 * f3)) * 2, dimensionPixelSize * 2).a();
            return a2 != null ? Bitmap.createScaledBitmap(a2, Math.min(dimensionPixelSize2, (int) ((a2.getWidth() / a2.getHeight()) * f3)), dimensionPixelSize, true) : a2;
        }
        if (!valueOf.startsWith("small")) {
            return null;
        }
        if (substring.startsWith("@solid:") && substring.endsWith(".jpg")) {
            int parseLong = (int) Long.parseLong(substring.substring(7, 15), 16);
            Bitmap createBitmap = Bitmap.createBitmap(ModuleDescriptor.MODULE_VERSION, 180, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawColor(parseLong);
            return createBitmap;
        }
        return NexImageLoader.loadBitmap(substring, ModuleDescriptor.MODULE_VERSION, 180).a();
    }
}

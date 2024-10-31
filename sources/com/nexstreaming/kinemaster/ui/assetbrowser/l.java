package com.nexstreaming.kinemaster.ui.assetbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.IOException;
import kotlin.text.w;

/* compiled from: AssetGroupAdapter.kt */
/* loaded from: classes.dex */
public final class l extends c.e.a.a.f {
    final /* synthetic */ Context o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, Context context2) {
        super(context2);
        this.o = context;
    }

    @Override // c.e.a.a.f
    protected Bitmap a(Object obj) {
        CharSequence b2;
        kotlin.jvm.internal.h.b(obj, ShareConstants.WEB_DIALOG_PARAM_DATA);
        Bitmap bitmap = null;
        if (!(obj instanceof com.nexstreaming.app.general.nexasset.assetpackage.b)) {
            return null;
        }
        String thumbPath = ((com.nexstreaming.app.general.nexasset.assetpackage.b) obj).getThumbPath();
        if (thumbPath != null) {
            b2 = w.b((CharSequence) thumbPath);
            if (b2.toString().length() > 0) {
                return BitmapFactory.decodeFile(thumbPath);
            }
        }
        try {
            bitmap = BitmapFactory.decodeStream(AssetPackageReader.a(KineMasterApplication.f24058f.c().getApplicationContext(), ((com.nexstreaming.app.general.nexasset.assetpackage.b) obj).getPackageURI(), ((com.nexstreaming.app.general.nexasset.assetpackage.b) obj).getAssetId()).g("thumb.jpg"));
        } catch (IOException unused) {
        }
        return bitmap;
    }
}

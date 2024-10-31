package com.nexstreaming.app.general.nexasset.overlay.a;

import android.graphics.RectF;
import android.util.Log;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.nexasset.assetpackage.u;
import com.nexstreaming.app.general.nexasset.assetpackage.y;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: RenderItemOverlayAsset.java */
/* loaded from: classes2.dex */
public class i extends a {

    /* renamed from: b, reason: collision with root package name */
    private int[] f19624b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f19625c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f19626d;

    /* renamed from: e, reason: collision with root package name */
    private int f19627e;

    /* renamed from: f, reason: collision with root package name */
    private int f19628f;

    public i(r rVar) {
        super(rVar);
        this.f19624b = new int[]{-1, -1};
        this.f19625c = new int[]{-1, -1};
        this.f19626d = new int[]{-1, -1};
        try {
            u a2 = y.a(KineMasterApplication.f24056d.getApplicationContext(), rVar.getId());
            this.f19627e = a2.b();
            this.f19628f = a2.a();
        } catch (IOException e2) {
            Log.e("RenderItemOverlayAsset", "Error reading itemdef: " + rVar.getId(), e2);
        } catch (XmlPullParserException e3) {
            Log.e("RenderItemOverlayAsset", "Error reading itemdef: " + rVar.getId(), e3);
        }
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int c() {
        return 0;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int a() {
        int i;
        if (this.f19627e <= 0 || (i = this.f19628f) <= 0) {
            return 700;
        }
        return i;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public int b() {
        int i = this.f19627e;
        if (i <= 0 || this.f19628f <= 0) {
            return 700;
        }
        return i;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.b
    public com.nexstreaming.app.general.nexasset.overlay.a a(LayerRenderer layerRenderer, NexLayerItem.c cVar, RectF rectF, String str, Map<String, String> map) {
        return new h(this, str, rectF);
    }
}

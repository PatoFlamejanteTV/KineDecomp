package com.nexstreaming.app.general.nexasset.overlay.a;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Locale;

/* compiled from: BitmapOverlayAsset.java */
/* loaded from: classes2.dex */
class d implements com.nexstreaming.app.general.nexasset.overlay.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f19601a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int[] f19602b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Bitmap f19603c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ RectF f19604d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ e f19605e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar, int[] iArr, int[] iArr2, Bitmap bitmap, RectF rectF) {
        this.f19605e = eVar;
        this.f19601a = iArr;
        this.f19602b = iArr2;
        this.f19603c = bitmap;
        this.f19604d = rectF;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.a
    public void a(LayerRenderer layerRenderer) {
        NexEditor i = EditorGlobal.i();
        if (i == null || this.f19601a[layerRenderer.l().id] < 0) {
            return;
        }
        i.d(this.f19601a[layerRenderer.l().id], layerRenderer.l().id);
        this.f19601a[layerRenderer.l().id] = -1;
        this.f19602b[layerRenderer.l().id] = 0;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.a
    public boolean a() {
        return false;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.a
    public boolean a(LayerRenderer layerRenderer, String str) {
        return false;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.a
    public void a(LayerRenderer layerRenderer, NexLayerItem.b bVar, int i, int i2, int i3) {
        NexEditor i4;
        if (i3 > 0) {
            if (this.f19602b[layerRenderer.l().id] != i3) {
                if (this.f19601a[layerRenderer.l().id] >= 0) {
                    EditorGlobal.i().d(this.f19601a[layerRenderer.l().id], layerRenderer.l().id);
                }
                this.f19601a[layerRenderer.l().id] = -1;
                this.f19602b[layerRenderer.l().id] = 0;
            }
            if (this.f19601a[layerRenderer.l().id] < 0 && (i4 = EditorGlobal.i()) != null) {
                this.f19601a[layerRenderer.l().id] = i4.a(String.format(Locale.US, "com.nexstreaming.editor.blend_%02d", Integer.valueOf(i3)), layerRenderer.l().id);
                this.f19602b[layerRenderer.l().id] = i3;
            }
        }
        if (this.f19601a[layerRenderer.l().id] >= 0 && i3 > 0) {
            int i5 = this.f19601a[layerRenderer.l().id];
            Bitmap bitmap = this.f19603c;
            int f2 = layerRenderer.f();
            RectF rectF = this.f19604d;
            layerRenderer.a(i5, bitmap, "", f2, 0, 1000, rectF.left, rectF.top, rectF.right, rectF.bottom, layerRenderer.d(), layerRenderer.i());
            return;
        }
        Bitmap bitmap2 = this.f19603c;
        RectF rectF2 = this.f19604d;
        layerRenderer.a(bitmap2, rectF2.left, rectF2.top, rectF2.right, rectF2.bottom);
    }
}

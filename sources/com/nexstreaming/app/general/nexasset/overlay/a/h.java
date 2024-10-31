package com.nexstreaming.app.general.nexasset.overlay.a;

import android.graphics.RectF;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Locale;

/* compiled from: RenderItemOverlayAsset.java */
/* loaded from: classes2.dex */
class h implements com.nexstreaming.app.general.nexasset.overlay.a {

    /* renamed from: a, reason: collision with root package name */
    private String f19620a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f19621b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ RectF f19622c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ i f19623d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, String str, RectF rectF) {
        this.f19623d = iVar;
        this.f19621b = str;
        this.f19622c = rectF;
        this.f19620a = this.f19621b;
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.a
    public void a(LayerRenderer layerRenderer) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        NexEditor i = EditorGlobal.i();
        if (i != null) {
            iArr = this.f19623d.f19624b;
            if (iArr[layerRenderer.l().id] >= 0) {
                iArr5 = this.f19623d.f19624b;
                i.d(iArr5[layerRenderer.l().id], layerRenderer.l().id);
                iArr6 = this.f19623d.f19624b;
                iArr6[layerRenderer.l().id] = -1;
            }
            iArr2 = this.f19623d.f19625c;
            if (iArr2[layerRenderer.l().id] >= 0) {
                iArr3 = this.f19623d.f19625c;
                i.d(iArr3[layerRenderer.l().id], layerRenderer.l().id);
                iArr4 = this.f19623d.f19625c;
                iArr4[layerRenderer.l().id] = -1;
            }
        }
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.a
    public boolean a() {
        return false;
    }

    public void a(LayerRenderer layerRenderer, NexLayerItem.b bVar, int i, int i2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        NexEditor i3;
        int[] iArr4;
        iArr = this.f19623d.f19624b;
        if (iArr[layerRenderer.l().id] < 0 && (i3 = EditorGlobal.i()) != null) {
            iArr4 = this.f19623d.f19624b;
            iArr4[layerRenderer.l().id] = i3.a(this.f19623d.e().getId(), layerRenderer.l().id);
        }
        iArr2 = this.f19623d.f19624b;
        if (iArr2[layerRenderer.l().id] >= 0) {
            iArr3 = this.f19623d.f19624b;
            int i4 = iArr3[layerRenderer.l().id];
            String str = this.f19620a;
            int f2 = layerRenderer.f();
            RectF rectF = this.f19622c;
            layerRenderer.a(i4, str, f2, i, i2, rectF.left, rectF.top, rectF.right, rectF.bottom, layerRenderer.d(), layerRenderer.i());
        }
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.a
    public void a(LayerRenderer layerRenderer, NexLayerItem.b bVar, int i, int i2, int i3) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        NexEditor i4;
        int[] iArr5;
        int[] iArr6;
        int[] iArr7;
        NexEditor i5;
        int[] iArr8;
        int[] iArr9;
        int[] iArr10;
        int[] iArr11;
        int[] iArr12;
        if (i3 > 0) {
            iArr6 = this.f19623d.f19626d;
            if (iArr6[layerRenderer.l().id] > 0) {
                NexEditor i6 = EditorGlobal.i();
                if (i6 != null) {
                    iArr12 = this.f19623d.f19625c;
                    i6.d(iArr12[layerRenderer.l().id], layerRenderer.l().id);
                }
                iArr10 = this.f19623d.f19625c;
                iArr10[layerRenderer.l().id] = -1;
                iArr11 = this.f19623d.f19626d;
                iArr11[layerRenderer.l().id] = -1;
            }
            iArr7 = this.f19623d.f19625c;
            if (iArr7[layerRenderer.l().id] < 0 && (i5 = EditorGlobal.i()) != null) {
                String format = String.format(Locale.US, "com.nexstreaming.editor.blend_%02d", Integer.valueOf(i3));
                iArr8 = this.f19623d.f19625c;
                iArr8[layerRenderer.l().id] = i5.a(format, layerRenderer.l().id);
                iArr9 = this.f19623d.f19626d;
                iArr9[layerRenderer.l().id] = i3;
            }
        }
        iArr = this.f19623d.f19624b;
        if (iArr[layerRenderer.l().id] < 0 && (i4 = EditorGlobal.i()) != null) {
            iArr5 = this.f19623d.f19624b;
            iArr5[layerRenderer.l().id] = i4.a(this.f19623d.e().getId(), layerRenderer.l().id);
        }
        iArr2 = this.f19623d.f19625c;
        if (iArr2[layerRenderer.l().id] >= 0 && i3 > 0) {
            iArr3 = this.f19623d.f19625c;
            int i7 = iArr3[layerRenderer.l().id];
            iArr4 = this.f19623d.f19624b;
            int i8 = iArr4[layerRenderer.l().id];
            String str = this.f19620a;
            int f2 = layerRenderer.f();
            RectF rectF = this.f19622c;
            layerRenderer.a(i7, i8, "range%3Ablend_mode=" + i3, str, f2, i, i2, rectF.left, rectF.top, rectF.right, rectF.bottom, layerRenderer.d(), layerRenderer.i());
            return;
        }
        a(layerRenderer, bVar, i, i2);
    }

    @Override // com.nexstreaming.app.general.nexasset.overlay.a
    public boolean a(LayerRenderer layerRenderer, String str) {
        this.f19620a = str;
        return true;
    }
}

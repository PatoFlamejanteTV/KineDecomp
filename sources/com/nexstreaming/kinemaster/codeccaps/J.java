package com.nexstreaming.kinemaster.codeccaps;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.kinemaster.codeccaps.P;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.List;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
public class J implements NexEditor.d {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f20061a;

    /* renamed from: b, reason: collision with root package name */
    private Canvas f20062b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f20063c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ P f20064d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(P p) {
        this.f20064d = p;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.d
    public void a(LayerRenderer layerRenderer) {
        boolean z;
        int i;
        int i2;
        int i3;
        List list;
        List list2;
        List<P.a> list3;
        int a2;
        boolean z2;
        z = this.f20064d.k;
        if (z) {
            layerRenderer.b(this.f20061a);
            return;
        }
        int f2 = layerRenderer.f();
        i = this.f20064d.A;
        if (f2 > i) {
            z2 = this.f20064d.z;
            if (!z2) {
                this.f20064d.z = true;
                this.f20064d.y = NexEditor.PerformanceCounter.FRAME_DROP.get();
            }
        }
        if (this.f20061a == null || this.f20062b == null || this.f20063c == null) {
            this.f20061a = Bitmap.createBitmap(400, 100, Bitmap.Config.ARGB_8888);
            this.f20063c = new Paint();
            this.f20063c.setColor(-1);
            this.f20063c.setTextSize(60.0f);
            this.f20062b = new Canvas(this.f20061a);
        }
        i2 = this.f20064d.f20076f;
        int i4 = i2 > 0 ? this.f20064d.f20076f : 30;
        int i5 = (int) ((f2 * i4) / 1000);
        int i6 = i4 * 60;
        int i7 = i6 * 60;
        String format = String.format(Locale.ENGLISH, "%02d:%02d:%02d:%02d", Integer.valueOf(i5 / i7), Integer.valueOf((i5 % i7) / i6), Integer.valueOf((i5 % i6) / i4), Integer.valueOf(i5 % i4));
        Canvas canvas = this.f20062b;
        i3 = this.f20064d.x;
        canvas.drawColor(i3);
        this.f20062b.drawText(format, 20.0f, 40.0f, this.f20063c);
        layerRenderer.a(this.f20061a, 640.0f, 360.0f);
        P.n(this.f20064d);
        list = this.f20064d.l;
        if (list.isEmpty()) {
            return;
        }
        list2 = this.f20064d.l;
        int size = list2.size();
        if (size > 4) {
            size = 4;
        }
        int i8 = size < 2 ? 2 : size;
        int i9 = SemanticAnnotations.SemanticType.ST_IDENTIFYING_ID_VALUE / i8;
        int i10 = (i9 * 9) / 16;
        list3 = this.f20064d.l;
        int i11 = 0;
        int i12 = 0;
        for (P.a aVar : list3) {
            if (layerRenderer.f() >= aVar.f20080b + 33 && (a2 = EditorGlobal.i().a(layerRenderer.l().id, aVar.f20081c)) != 0) {
                layerRenderer.x();
                layerRenderer.a(0.8f);
                layerRenderer.b(a2, ((i9 + 10) * i11) + (i9 / 2), ((i10 + 10) * i12) + (i10 / 2), i9, i10);
                layerRenderer.w();
                i11++;
                if (i11 > i8) {
                    i12++;
                    i11 = 0;
                }
            }
        }
    }
}

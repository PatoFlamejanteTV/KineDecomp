package com.nexstreaming.kinemaster.layer.handwriting;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.nexstreaming.kinemaster.wire.KMProto;

/* compiled from: DrawingAction.java */
/* loaded from: classes.dex */
public abstract class b {
    public static b a(KMProto.KMProject.DrawingAction drawingAction) {
        int i = a.f20643a[drawingAction.drawing_action_type.ordinal()];
        if (i == 1) {
            c cVar = new c();
            cVar.b(drawingAction);
            return cVar;
        }
        if (i != 2) {
            return null;
        }
        Stroke stroke = new Stroke();
        stroke.b(drawingAction);
        return stroke;
    }

    public abstract KMProto.KMProject.DrawingAction a();

    public abstract void a(Canvas canvas);

    public abstract void a(Canvas canvas, float f2);

    public abstract void a(RectF rectF);

    public abstract boolean b();
}

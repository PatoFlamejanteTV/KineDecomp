package com.nexstreaming.kinemaster.layer.handwriting;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.nexstreaming.kinemaster.wire.KMProto;

/* compiled from: DrawingAction.java */
/* loaded from: classes.dex */
public abstract class a {
    public abstract void a(Canvas canvas);

    public abstract void a(Canvas canvas, float f);

    public abstract void a(RectF rectF);

    public abstract void a(KMProto.KMProject.DrawingAction drawingAction);

    public abstract boolean a();

    public abstract KMProto.KMProject.DrawingAction b();

    public static a b(KMProto.KMProject.DrawingAction drawingAction) {
        switch (drawingAction.drawing_action_type) {
            case ERASE_ALL:
                b bVar = new b();
                bVar.a(drawingAction);
                return bVar;
            case STROKE:
                Stroke stroke = new Stroke();
                stroke.a(drawingAction);
                return stroke;
            default:
                return null;
        }
    }
}

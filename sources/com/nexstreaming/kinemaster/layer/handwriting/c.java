package com.nexstreaming.kinemaster.layer.handwriting;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import com.nexstreaming.kinemaster.wire.KMProto;

/* compiled from: EraseAll.java */
/* loaded from: classes.dex */
public class c extends b {
    @Override // com.nexstreaming.kinemaster.layer.handwriting.b
    public void a(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    public void b(KMProto.KMProject.DrawingAction drawingAction) {
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.b
    public boolean b() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.b
    public void a(Canvas canvas, float f2) {
        a(canvas);
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.b
    public void a(RectF rectF) {
        rectF.setEmpty();
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.b
    public KMProto.KMProject.DrawingAction a() {
        KMProto.KMProject.DrawingAction.Builder builder = new KMProto.KMProject.DrawingAction.Builder();
        builder.drawing_action_type = KMProto.KMProject.DrawingActionType.ERASE_ALL;
        return builder.build();
    }
}

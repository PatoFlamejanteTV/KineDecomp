package com.nexstreaming.kinemaster.layer.handwriting;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import com.nexstreaming.kinemaster.wire.KMProto;

/* compiled from: EraseAll.java */
/* loaded from: classes.dex */
public class b extends a {
    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public boolean a() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public void a(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public void a(Canvas canvas, float f) {
        a(canvas);
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public void a(RectF rectF) {
        rectF.setEmpty();
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public KMProto.KMProject.DrawingAction b() {
        KMProto.KMProject.DrawingAction.Builder builder = new KMProto.KMProject.DrawingAction.Builder();
        builder.drawing_action_type = KMProto.KMProject.DrawingActionType.ERASE_ALL;
        return builder.build();
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public void a(KMProto.KMProject.DrawingAction drawingAction) {
    }
}

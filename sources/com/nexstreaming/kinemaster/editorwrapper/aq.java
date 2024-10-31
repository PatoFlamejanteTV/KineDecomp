package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* loaded from: classes.dex */
public class aq extends View {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexLayerItem.a f3318a;
    final /* synthetic */ NexLayerItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(NexLayerItem nexLayerItem, Context context, NexLayerItem.a aVar) {
        super(context);
        this.b = nexLayerItem;
        this.f3318a = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(this.f3318a.e, 0.0f);
        path.lineTo(this.f3318a.e, this.f3318a.f / 2);
        path.lineTo((this.f3318a.e / 5) * 3, this.f3318a.f / 2);
        path.lineTo(this.f3318a.e / 2, (this.f3318a.f / 5) * 4);
        path.lineTo((this.f3318a.e / 5) * 2, this.f3318a.f / 2);
        path.lineTo(0.0f, this.f3318a.f / 2);
        paint.setColor(-1);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        canvas.drawPath(path, paint);
        String str = "";
        if (this.f3318a.f3298a == NexLayerItem.DragType.START) {
            str = this.f3318a.l.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(this.b.getDuration()));
        } else if (this.f3318a.f3298a == NexLayerItem.DragType.END) {
            str = this.f3318a.l.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(this.b.getDuration()));
        }
        paint.reset();
        paint.setFlags(1);
        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.setColor(getResources().getColor(R.color.custom_drag_text_color));
        int i = this.f3318a.e;
        int i2 = this.f3318a.f / 2;
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, (i / 2) - (r4.right / 2), i2 + (r4.top / 2), paint);
        super.onDraw(canvas);
    }
}

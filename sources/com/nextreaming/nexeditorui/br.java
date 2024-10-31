package com.nextreaming.nexeditorui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexAudioClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexAudioClipItem.java */
/* loaded from: classes.dex */
public class br extends View {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexAudioClipItem.a f4554a;
    final /* synthetic */ NexAudioClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(NexAudioClipItem nexAudioClipItem, Context context, NexAudioClipItem.a aVar) {
        super(context);
        this.b = nexAudioClipItem;
        this.f4554a = aVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(this.f4554a.e, 0.0f);
        path.lineTo(this.f4554a.e, this.f4554a.f / 2);
        path.lineTo((this.f4554a.e / 5) * 3, this.f4554a.f / 2);
        path.lineTo(this.f4554a.e / 2, (this.f4554a.f / 5) * 4);
        path.lineTo((this.f4554a.e / 5) * 2, this.f4554a.f / 2);
        path.lineTo(0.0f, this.f4554a.f / 2);
        paint.setColor(-1);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        canvas.drawPath(path, paint);
        String str = "";
        if (this.f4554a.f4479a == NexAudioClipItem.DragType.START) {
            Resources resources = this.f4554a.m.getResources();
            i4 = this.b.m_trimTimeStart;
            str = resources.getString(R.string.video_drag_starttrim, EditorGlobal.a(i4));
        } else if (this.f4554a.f4479a == NexAudioClipItem.DragType.END) {
            z = this.b.m_loop;
            if (z) {
                Resources resources2 = this.f4554a.m.getResources();
                i2 = this.b.m_relativeEndTime;
                i3 = this.b.m_relativeStartTime;
                str = resources2.getString(R.string.video_drag_duration, EditorGlobal.a(i2 - i3));
            } else {
                Resources resources3 = this.f4554a.m.getResources();
                i = this.b.m_trimTimeEnd;
                str = resources3.getString(R.string.video_drag_endtrim, EditorGlobal.a(i));
            }
        }
        paint.reset();
        paint.setFlags(1);
        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.setColor(getResources().getColor(R.color.custom_drag_text_color));
        int i5 = this.f4554a.e;
        int i6 = this.f4554a.f / 2;
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, (i5 / 2) - (r4.right / 2), i6 + (r4.top / 2), paint);
        super.onDraw(canvas);
    }
}

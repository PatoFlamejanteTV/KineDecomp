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
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class dm extends View {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem.b f4602a;
    final /* synthetic */ NexVideoClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dm(NexVideoClipItem nexVideoClipItem, Context context, NexVideoClipItem.b bVar) {
        super(context);
        this.b = nexVideoClipItem;
        this.f4602a = bVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        if (this.b.isImage() || this.f4602a.f4499a == NexVideoClipItem.DragType.FXSTART || this.f4602a.f4499a == NexVideoClipItem.DragType.FXEND) {
            path.lineTo(this.f4602a.g, 0.0f);
            path.lineTo(this.f4602a.g, this.f4602a.h / 2);
            path.lineTo((this.f4602a.g / 5) * 3, this.f4602a.h / 2);
            path.lineTo(this.f4602a.g / 2, (this.f4602a.h / 5) * 4);
            path.lineTo((this.f4602a.g / 5) * 2, this.f4602a.h / 2);
            path.lineTo(0.0f, this.f4602a.h / 2);
        } else {
            path.lineTo(this.f4602a.g, 0.0f);
            path.lineTo(this.f4602a.g, (this.f4602a.h / 3) * 2);
            path.lineTo((this.f4602a.g / 5) * 3, (this.f4602a.h / 3) * 2);
            path.lineTo(this.f4602a.g / 2, (this.f4602a.h / 7) * 6);
            path.lineTo((this.f4602a.g / 5) * 2, (this.f4602a.h / 3) * 2);
            path.lineTo(0.0f, (this.f4602a.h / 3) * 2);
        }
        paint.setColor(-1);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        canvas.drawPath(path, paint);
        String str = "";
        if (this.f4602a.f4499a == NexVideoClipItem.DragType.START) {
            if (this.b.isImage()) {
                str = this.f4602a.q.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(this.b.getDuration()));
            } else {
                StringBuilder sb = new StringBuilder();
                Resources resources = this.f4602a.q.getResources();
                i5 = this.b.m_trimmedDuration;
                StringBuilder append = sb.append(resources.getString(R.string.video_drag_duration, EditorGlobal.a((i5 * 100) / this.b.getPlaybackSpeed()))).append('\n');
                Resources resources2 = this.f4602a.q.getResources();
                i6 = this.b.m_trimTimeStart;
                str = append.append(resources2.getString(R.string.video_drag_starttrim, EditorGlobal.a(i6))).toString();
            }
        } else if (this.f4602a.f4499a == NexVideoClipItem.DragType.FXSTART) {
            Resources resources3 = this.f4602a.q.getResources();
            i4 = this.b.m_effectStartTime;
            str = resources3.getString(R.string.video_drag_fxstart, EditorGlobal.a(i4));
        } else if (this.f4602a.f4499a == NexVideoClipItem.DragType.FXEND) {
            Resources resources4 = this.f4602a.q.getResources();
            i3 = this.b.m_effectEndTime;
            str = resources4.getString(R.string.video_drag_fxend, EditorGlobal.a(i3));
        } else if (this.f4602a.f4499a == NexVideoClipItem.DragType.END) {
            if (this.b.isImage()) {
                str = this.f4602a.q.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(this.b.getDuration()));
            } else {
                StringBuilder sb2 = new StringBuilder();
                Resources resources5 = this.f4602a.q.getResources();
                i = this.b.m_trimmedDuration;
                StringBuilder append2 = sb2.append(resources5.getString(R.string.video_drag_duration, EditorGlobal.a((i * 100) / this.b.getPlaybackSpeed()))).append('\n');
                Resources resources6 = this.f4602a.q.getResources();
                i2 = this.b.m_trimTimeEnd;
                str = append2.append(resources6.getString(R.string.video_drag_endtrim, EditorGlobal.a(i2))).toString();
            }
        }
        paint.reset();
        paint.setFlags(1);
        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.setColor(getResources().getColor(R.color.custom_drag_text_color));
        int i7 = this.f4602a.g;
        int i8 = this.f4602a.h / 2;
        if (this.b.isImage() || this.f4602a.f4499a == NexVideoClipItem.DragType.FXSTART || this.f4602a.f4499a == NexVideoClipItem.DragType.FXEND) {
            paint.getTextBounds(str, 0, str.length(), new Rect());
            canvas.drawText(str, (i7 / 2) - (r5.right / 2), i8 + (r5.top / 2), paint);
        } else {
            Rect rect = new Rect();
            int i9 = this.f4602a.h / 3;
            String[] split = str.split("\n");
            for (String str2 : split) {
                paint.getTextBounds(str2, 0, str2.length(), rect);
                canvas.drawText(str2, (i7 / 2) - (rect.right / 2), (rect.top / 3) + i9, paint);
                i9 = (int) (i9 + (paint.descent() - paint.ascent()));
            }
        }
        super.onDraw(canvas);
    }
}

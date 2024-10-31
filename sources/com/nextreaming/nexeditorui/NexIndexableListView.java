package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;

/* loaded from: classes.dex */
public class NexIndexableListView extends ListView {

    /* renamed from: a */
    private boolean f24110a;

    /* renamed from: b */
    private C2344ya f24111b;

    /* renamed from: c */
    private GestureDetector f24112c;

    public NexIndexableListView(Context context) {
        super(context);
        this.f24110a = false;
        this.f24111b = null;
        this.f24112c = null;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        C2344ya c2344ya = this.f24111b;
        if (c2344ya != null) {
            c2344ya.a(canvas);
        }
    }

    @Override // android.widget.AbsListView
    public boolean isFastScrollEnabled() {
        return this.f24110a;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        C2344ya c2344ya = this.f24111b;
        if (c2344ya != null) {
            c2344ya.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C2344ya c2344ya = this.f24111b;
        if (c2344ya != null && c2344ya.a(motionEvent)) {
            return true;
        }
        if (this.f24112c == null) {
            this.f24112c = new GestureDetector(getContext(), new C2346za(this));
        }
        this.f24112c.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        this.f24110a = z;
        if (this.f24110a) {
            if (this.f24111b == null) {
                this.f24111b = new C2344ya(getContext(), this, getPaddingTop(), getPaddingBottom());
            }
            this.f24111b.b();
        } else {
            C2344ya c2344ya = this.f24111b;
            if (c2344ya != null) {
                c2344ya.a();
                this.f24111b = null;
            }
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        C2344ya c2344ya = this.f24111b;
        if (c2344ya != null) {
            c2344ya.a(listAdapter);
        }
    }

    public NexIndexableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24110a = false;
        this.f24111b = null;
        this.f24112c = null;
    }

    public NexIndexableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24110a = false;
        this.f24111b = null;
        this.f24112c = null;
    }
}

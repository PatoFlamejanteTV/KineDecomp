package com.nextreaming.nexeditorui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes.dex */
public class NexEditText extends EditText {

    /* renamed from: a, reason: collision with root package name */
    private a f4480a;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(View view, KeyEvent keyEvent);
    }

    public NexEditText(Context context) {
        super(context);
        this.f4480a = null;
    }

    public NexEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4480a = null;
    }

    public NexEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4480a = null;
    }

    public void setOnBackKeyListener(a aVar) {
        this.f4480a = aVar;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            if (this.f4480a != null) {
                return this.f4480a.a(this, keyEvent);
            }
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            if (!super.dispatchKeyEventPreIme(keyEvent)) {
                if (this.f4480a != null) {
                    return this.f4480a.a(this, keyEvent);
                }
                return false;
            }
            return true;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}

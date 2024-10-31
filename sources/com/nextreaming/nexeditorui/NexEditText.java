package com.nextreaming.nexeditorui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes.dex */
public class NexEditText extends EditText {

    /* renamed from: a */
    private a f24082a;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(View view, KeyEvent keyEvent);
    }

    public NexEditText(Context context) {
        super(context);
        this.f24082a = null;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            a aVar = this.f24082a;
            if (aVar != null) {
                return aVar.a(this, keyEvent);
            }
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            if (super.dispatchKeyEventPreIme(keyEvent)) {
                return true;
            }
            a aVar = this.f24082a;
            if (aVar != null) {
                return aVar.a(this, keyEvent);
            }
            return false;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public void setOnBackKeyListener(a aVar) {
        this.f24082a = aVar;
    }

    public NexEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24082a = null;
    }

    public NexEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24082a = null;
    }
}

package com.firebase.ui.auth.ui;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ImeHelper {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.firebase.ui.auth.ui.ImeHelper$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 implements TextView.OnEditorActionListener {
        final /* synthetic */ int val$imeActionId;
        final /* synthetic */ DonePressedListener val$listener;

        AnonymousClass1(int i, DonePressedListener donePressedListener) {
            i = i;
            donePressedListener = donePressedListener;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if ((keyEvent == null || keyEvent.getKeyCode() != 66) && i != i) {
                return false;
            }
            donePressedListener.onDonePressed();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface DonePressedListener {
        void onDonePressed();
    }

    public static void setImeOnDoneListener(EditText editText, int i, DonePressedListener donePressedListener) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.firebase.ui.auth.ui.ImeHelper.1
            final /* synthetic */ int val$imeActionId;
            final /* synthetic */ DonePressedListener val$listener;

            AnonymousClass1(int i2, DonePressedListener donePressedListener2) {
                i = i2;
                donePressedListener = donePressedListener2;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if ((keyEvent == null || keyEvent.getKeyCode() != 66) && i2 != i) {
                    return false;
                }
                donePressedListener.onDonePressed();
                return true;
            }
        });
    }
}

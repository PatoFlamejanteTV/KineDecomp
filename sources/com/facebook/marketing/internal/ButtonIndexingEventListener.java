package com.facebook.marketing.internal;

import android.util.Log;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.ViewHierarchy;

/* loaded from: classes.dex */
public class ButtonIndexingEventListener {
    private static final String TAG = "com.facebook.marketing.internal.ButtonIndexingEventListener";

    /* loaded from: classes.dex */
    public static class ButtonIndexingAccessibilityDelegate extends CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate {
        private View.AccessibilityDelegate existingDelegate;
        private String mapKey;

        public ButtonIndexingAccessibilityDelegate(View view, String str) {
            if (view == null) {
                return;
            }
            this.existingDelegate = ViewHierarchy.getExistingDelegate(view);
            this.mapKey = str;
            this.supportButtonIndexing = true;
        }

        @Override // com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate, android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            if (i == -1) {
                Log.e(ButtonIndexingEventListener.TAG, "Unsupported action type");
            }
            View.AccessibilityDelegate accessibilityDelegate = this.existingDelegate;
            if (accessibilityDelegate != null && !(accessibilityDelegate instanceof ButtonIndexingAccessibilityDelegate)) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            }
            FacebookSdk.getExecutor().execute(new c(this, view, this.mapKey));
        }
    }

    public static ButtonIndexingAccessibilityDelegate getAccessibilityDelegate(View view, String str) {
        return new ButtonIndexingAccessibilityDelegate(view, str);
    }
}

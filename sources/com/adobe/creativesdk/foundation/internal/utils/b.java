package com.adobe.creativesdk.foundation.internal.utils;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/* compiled from: AdobeCSDKActionBarController.java */
/* loaded from: classes.dex */
public class b {
    public static void a(View view, String str) {
        TextView textView = (TextView) view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_actionbar_title);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public static void a(View view, String str, int i) {
        TextView textView = (TextView) view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_actionbar_title);
        if (textView != null) {
            textView.setTextColor(i);
            textView.setText(str);
        }
    }

    public static void a(View view, int i) {
        TextView textView = (TextView) view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_actionbar_title);
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public static View a(View view) {
        return view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_actionbar_title);
    }

    public static void a(View view, boolean z) {
        Toolbar toolbar;
        if (view == null || (toolbar = (Toolbar) view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_actionbar_toolbar_loki)) == null) {
            return;
        }
        if (z) {
            toolbar.setVisibility(0);
        } else {
            toolbar.setVisibility(8);
        }
    }
}

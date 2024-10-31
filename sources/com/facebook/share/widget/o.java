package com.facebook.share.widget;

import com.facebook.share.widget.ShareDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareDialog.java */
/* loaded from: classes.dex */
public /* synthetic */ class o {

    /* renamed from: a */
    static final /* synthetic */ int[] f409a = new int[ShareDialog.Mode.values().length];

    static {
        try {
            f409a[ShareDialog.Mode.AUTOMATIC.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f409a[ShareDialog.Mode.WEB.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f409a[ShareDialog.Mode.NATIVE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}

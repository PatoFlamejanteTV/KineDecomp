package com.facebook.share.internal;

import com.facebook.share.internal.LikeBoxCountView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeBoxCountView.java */
/* loaded from: classes.dex */
public /* synthetic */ class p {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f373a = new int[LikeBoxCountView.LikeBoxCountViewCaretPosition.values().length];

    static {
        try {
            f373a[LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f373a[LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f373a[LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f373a[LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}

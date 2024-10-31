package com.facebook.appevents.codeless;

import com.facebook.appevents.codeless.internal.EventBinding;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CodelessLoggingEventListener.java */
/* loaded from: classes.dex */
public /* synthetic */ class a {

    /* renamed from: a */
    static final /* synthetic */ int[] f9164a = new int[EventBinding.ActionType.values().length];

    static {
        try {
            f9164a[EventBinding.ActionType.CLICK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f9164a[EventBinding.ActionType.SELECTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f9164a[EventBinding.ActionType.TEXT_CHANGED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

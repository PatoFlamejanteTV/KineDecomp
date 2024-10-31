package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditorEventListener.java */
/* loaded from: classes3.dex */
public /* synthetic */ class Z {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f24685a = new int[NexEditor.PlayState.values().length];

    static {
        try {
            f24685a[NexEditor.PlayState.RUN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f24685a[NexEditor.PlayState.RECORD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

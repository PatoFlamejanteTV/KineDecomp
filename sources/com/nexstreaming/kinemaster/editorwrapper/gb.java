package com.nexstreaming.kinemaster.editorwrapper;

import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public /* synthetic */ class gb {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f20317a = new int[NexEditor.PlayState.values().length];

    static {
        try {
            f20317a[NexEditor.PlayState.IDLE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20317a[NexEditor.PlayState.NONE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20317a[NexEditor.PlayState.RUN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20317a[NexEditor.PlayState.RECORD.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

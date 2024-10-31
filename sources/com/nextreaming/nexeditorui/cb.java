package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public /* synthetic */ class cb {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f24222a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f24223b;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ int[] f24224c;

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ int[] f24225d;

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ int[] f24226e = new int[KMProto.KMProject.TitleStyle.values().length];

    static {
        try {
            f24226e[KMProto.KMProject.TitleStyle.TITLE_STYLE_NONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f24226e[KMProto.KMProject.TitleStyle.TITLE_STYLE_HEADLINE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f24226e[KMProto.KMProject.TitleStyle.TITLE_STYLE_OPENING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f24226e[KMProto.KMProject.TitleStyle.TITLE_STYLE_PLAYING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f24226e[KMProto.KMProject.TitleStyle.TITLE_STYLE_ENDING.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f24225d = new int[NexVideoClipItem.TitleStyle.values().length];
        try {
            f24225d[NexVideoClipItem.TitleStyle.NONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f24225d[NexVideoClipItem.TitleStyle.HEADLINE.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f24225d[NexVideoClipItem.TitleStyle.OPENING.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f24225d[NexVideoClipItem.TitleStyle.PLAYING.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f24225d[NexVideoClipItem.TitleStyle.ENDING.ordinal()] = 5;
        } catch (NoSuchFieldError unused10) {
        }
        f24224c = new int[NexVideoClipItem.DragType.values().length];
        try {
            f24224c[NexVideoClipItem.DragType.FXSTART.ordinal()] = 1;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f24224c[NexVideoClipItem.DragType.FXEND.ordinal()] = 2;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f24224c[NexVideoClipItem.DragType.END.ordinal()] = 3;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f24224c[NexVideoClipItem.DragType.START.ordinal()] = 4;
        } catch (NoSuchFieldError unused14) {
        }
        f24223b = new int[NexVideoClipItem.CropMode.values().length];
        try {
            f24223b[NexVideoClipItem.CropMode.FIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f24223b[NexVideoClipItem.CropMode.FILL.ordinal()] = 2;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f24223b[NexVideoClipItem.CropMode.PAN_RAND.ordinal()] = 3;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            f24223b[NexVideoClipItem.CropMode.PAN_FACE.ordinal()] = 4;
        } catch (NoSuchFieldError unused18) {
        }
        f24222a = new int[MediaItemType.values().length];
        try {
            f24222a[MediaItemType.IMAGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            f24222a[MediaItemType.VIDEO.ordinal()] = 2;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            f24222a[MediaItemType.FILE.ordinal()] = 3;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            f24222a[MediaItemType.FOLDER.ordinal()] = 4;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            f24222a[MediaItemType.SPECIAL.ordinal()] = 5;
        } catch (NoSuchFieldError unused23) {
        }
    }
}

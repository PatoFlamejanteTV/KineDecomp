package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.wg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public /* synthetic */ class C2068wg {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f22756a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f22757b;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ int[] f22758c;

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ int[] f22759d = new int[MediaItemType.values().length];

    static {
        try {
            f22759d[MediaItemType.IMAGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f22759d[MediaItemType.VIDEO.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f22758c = new int[ProjectEditActivity.InsertPosition.values().length];
        try {
            f22758c[ProjectEditActivity.InsertPosition.AfterSelected.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f22758c[ProjectEditActivity.InsertPosition.BeforeSelected.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f22758c[ProjectEditActivity.InsertPosition.CurrentTime.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        f22757b = new int[ProjectEditActivity.TimelineActionButtonMode.values().length];
        try {
            f22757b[ProjectEditActivity.TimelineActionButtonMode.NoItemSelectedScrolledToStart.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f22757b[ProjectEditActivity.TimelineActionButtonMode.NoItemSelectedScrolledToStartExpanded.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f22757b[ProjectEditActivity.TimelineActionButtonMode.SecondaryItemSelected.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f22757b[ProjectEditActivity.TimelineActionButtonMode.SecondaryItemSelectedWithExpanded.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f22757b[ProjectEditActivity.TimelineActionButtonMode.NoItemSelectedScrolledToMidExpanded.ordinal()] = 5;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f22757b[ProjectEditActivity.TimelineActionButtonMode.NoItemSelectedScrolledToMid.ordinal()] = 6;
        } catch (NoSuchFieldError unused11) {
        }
        f22756a = new int[KMIntentData.LayerType.values().length];
        try {
            f22756a[KMIntentData.LayerType.Image.ordinal()] = 1;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f22756a[KMIntentData.LayerType.Video.ordinal()] = 2;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f22756a[KMIntentData.LayerType.Sticker.ordinal()] = 3;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f22756a[KMIntentData.LayerType.Text.ordinal()] = 4;
        } catch (NoSuchFieldError unused15) {
        }
    }
}

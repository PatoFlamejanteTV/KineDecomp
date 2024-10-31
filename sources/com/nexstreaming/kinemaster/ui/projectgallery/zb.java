package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.tracelog.NotifyAppResponse;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public /* synthetic */ class zb {

    /* renamed from: a */
    static final /* synthetic */ int[] f23010a;

    /* renamed from: b */
    static final /* synthetic */ int[] f23011b;

    /* renamed from: c */
    static final /* synthetic */ int[] f23012c;

    /* renamed from: d */
    static final /* synthetic */ int[] f23013d = new int[NotifyAppResponse.NoticeType.values().length];

    static {
        try {
            f23013d[NotifyAppResponse.NoticeType.HTML.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f23013d[NotifyAppResponse.NoticeType.Text.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f23013d[NotifyAppResponse.NoticeType.URL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f23012c = new int[EditorGlobal.VersionType.values().length];
        try {
            f23012c[EditorGlobal.VersionType.Alpha.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f23012c[EditorGlobal.VersionType.Beta.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f23012c[EditorGlobal.VersionType.Eval.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f23012c[EditorGlobal.VersionType.TeamEval.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f23012c[EditorGlobal.VersionType.Dev.ordinal()] = 5;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f23012c[EditorGlobal.VersionType.ShowDemo.ordinal()] = 6;
        } catch (NoSuchFieldError unused9) {
        }
        f23011b = new int[KMCloud.KMCloudReturnValue.values().length];
        try {
            f23011b[KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_LOGIN_FAILED.ordinal()] = 1;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f23011b[KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_LOGOUT_FAILED.ordinal()] = 2;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f23011b[KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_CREATEFOLDER_FAILED.ordinal()] = 3;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f23011b[KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_CREATEFILE_FAILED.ordinal()] = 4;
        } catch (NoSuchFieldError unused13) {
        }
        f23010a = new int[KMCloud.KMCloudState.values().length];
        try {
            f23010a[KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_IN.ordinal()] = 1;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f23010a[KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_OUT.ordinal()] = 2;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f23010a[KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FOLDER.ordinal()] = 3;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f23010a[KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FILE.ordinal()] = 4;
        } catch (NoSuchFieldError unused17) {
        }
    }
}

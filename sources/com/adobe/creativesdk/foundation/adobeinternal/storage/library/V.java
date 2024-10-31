package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public /* synthetic */ class V {

    /* renamed from: a */
    static final /* synthetic */ int[] f4557a;

    /* renamed from: b */
    static final /* synthetic */ int[] f4558b;

    /* renamed from: c */
    static final /* synthetic */ int[] f4559c = new int[AdobeDCXErrorCode.values().length];

    static {
        try {
            f4559c[AdobeDCXErrorCode.AdobeDCXErrorCompositeAlreadyExists.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4559c[AdobeDCXErrorCode.AdobeDCXErrorUnknownComposite.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f4559c[AdobeDCXErrorCode.AdobeDCXErrorDeletedComposite.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f4559c[AdobeDCXErrorCode.AdobeDCXErrorMissingManifest.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f4559c[AdobeDCXErrorCode.AdobeDCXErrorManifestWriteFailure.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f4559c[AdobeDCXErrorCode.AdobeDCXErrorComponentWriteFailure.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f4559c[AdobeDCXErrorCode.AdobeDCXErrorComponentCopyFailure.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f4559c[AdobeDCXErrorCode.AdobeDCXErrorMissingComponentAsset.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        f4558b = new int[AdobeNetworkException.AdobeNetworkErrorCode.values().length];
        try {
            f4558b[AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled.ordinal()] = 1;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f4558b[AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorServiceDisconnected.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f4558b[AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorOffline.ordinal()] = 3;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f4558b[AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNetworkFailure.ordinal()] = 4;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f4558b[AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorRequestForbidden.ordinal()] = 5;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f4558b[AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorAuthenticationFailed.ordinal()] = 6;
        } catch (NoSuchFieldError unused14) {
        }
        f4557a = new int[AdobeAssetErrorCode.values().length];
        try {
            f4557a[AdobeAssetErrorCode.AdobeAssetErrorConflictingChanges.ordinal()] = 1;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f4557a[AdobeAssetErrorCode.AdobeAssetErrorFileReadFailure.ordinal()] = 2;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f4557a[AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse.ordinal()] = 3;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            f4557a[AdobeAssetErrorCode.AdobeAssetErrorForbiddenRequest.ordinal()] = 4;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            f4557a[AdobeAssetErrorCode.AdobeAssetErrorExceededQuota.ordinal()] = 5;
        } catch (NoSuchFieldError unused19) {
        }
    }
}

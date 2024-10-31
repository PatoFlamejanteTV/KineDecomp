package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* loaded from: classes.dex */
public enum AdobeDCXErrorCode {
    AdobeDCXErrorManifestReadFailure(0),
    AdobeDCXErrorManifestFinalWriteFailure(1),
    AdobeDCXErrorManifestWriteFailure(2),
    AdobeDCXErrorInvalidManifest(3),
    AdobeDCXErrorInvalidLocalManifest(4),
    AdobeDCXErrorInvalidRemoteManifest(5),
    AdobeDCXErrorMissingManifest(6),
    AdobeDCXErrorComponentReadFailure(7),
    AdobeDCXErrorComponentWriteFailure(8),
    AdobeDCXErrorComponentCopyFailure(9),
    AdobeDCXErrorMissingComponentAsset(10),
    AdobeDCXErrorUnknownComposite(11),
    AdobeDCXErrorDeletedComposite(12),
    AdobeDCXErrorInvalidJournal(13),
    AdobeDCXErrorIncompleteJournal(14),
    AdobeDCXErrorFailedToStoreBaseManifest(15),
    AdobeDCXErrorFunctionNotImplemented(16),
    AdobeDCXErrorInvalidLocalStoragePath(17),
    AdobeDCXErrorCompositeAlreadyExists(18),
    AdobeDCXErrorDuplicateId(19),
    AdobeDCXErrorCompositeHrefUnassigned(20),
    AdobeDCXErrorDuplicatePath(21),
    AdobeDCXErrorInvalidPath(22),
    AdobeDCXErrorCannotRemoveModifiedComponent(23),
    AdobeDCXErrorAttemptToDeleteIncomingShare(24),
    AdobeDCXErrorUnparsableMetadata(26),
    AdobeDCXErrorLocalStorageSchemeNotSupported(27),
    AdobeDCXInvalidComponentManager(28),
    AdobeDCXErrorOperationCancelled(29),
    AdobeDCXErrorFileIO(30),
    AdobeDCXErrorInstanceCacheConflict(31),
    AdobeDCXErrorFailedToCreateDCXElement(32),
    AdobeDCXErrorNodeIsNotElement(33),
    AdobeDCXErrorElementNotPendingOnBranch(34),
    AdobeDCXErrorPathNotFound(35),
    AdobeDCXErrorUnknownId(36),
    AdobeDCXErrorAttemptToModifyImmutableCompositeBranch(37),
    AdobeDCXErrorManifestFileNotFound(38);

    private int _val;

    AdobeDCXErrorCode(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}

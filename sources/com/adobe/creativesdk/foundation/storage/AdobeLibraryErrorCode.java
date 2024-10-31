package com.adobe.creativesdk.foundation.storage;

/* loaded from: classes.dex */
public enum AdobeLibraryErrorCode {
    AdobeLibraryErrorLocalRootCreateFailure(0),
    AdobeLibraryErrorBadParameter(1),
    AdobeLibraryErrorOperationNotSupported(2),
    AdobeLibraryErrorStartupFailure(3),
    AdobeLibraryErrorLocalLibraryCreateFailure(4),
    AdobeLibraryErrorLocalLibraryDoesNotExist(5),
    AdobeLibraryErrorLibraryCreateFailure(6),
    AdobeLibraryErrorLibraryNotInitialized(7),
    AdobeLibraryErrorLibraryFailedToSave(8),
    AdobeLibraryErrorLibraryEndWithoutBegin(9),
    AdobeLibraryErrorCategoryDoesNotExist(10),
    AdobeLibraryErrorLibraryFailedToAddCategory(11),
    AdobeLibraryErrorLibraryFailedToAddElement(12),
    AdobeLibraryErrorLibraryMaximumElementsReached(13),
    AdobeLibraryErrorLibraryIndexOutOfRange(14),
    AdobeLibraryErrorElementDoesNotExist(15),
    AdobeLibraryErrorLibraryFailedToAddRepresentation(16),
    AdobeLibraryErrorRepresentationDoesNotExist(17),
    AdobeLibraryErrorRepresentationHasNoFile(18),
    AdobeLibraryErrorRepresentationReservedKey(19),
    AdobeLibraryErrorElementMustHaveOnePrimaryRepresentation(20),
    AdobeLibraryErrorCopyingRenditionFile(21),
    AdobeLibraryErrorDeleteLibraryOnServerFailed(22),
    AdobeLibraryErrorNamespaceNotFoundForKey(23),
    AdobeLibraryErrorDownloadingRepresentationAsset(24),
    AdobeLibraryErrorInternalMergeDownloadedLibrary(25),
    AdobeLibraryErrorDownloadingRenditionFile(26),
    AdobeLibraryErrorStartupAlreadyStarted(27),
    AdobeLibraryErrorSyncLibraryDeletedOnServer(28),
    AdobeLibraryErrorSyncNotEnabled(29),
    AdobeLibraryErrorSyncNotAvailableDueToNetwork(30),
    AdobeLibraryErrorSyncNotAvailableDueToUserSession(31),
    AdobeLibraryErrorSyncWriteFailure(32),
    AdobeLibraryErrorSyncUnexpectedError(33),
    AdobeLibraryErrorInvalidLibraryComposite(34),
    AdobeLibraryErrorNoRenditionCandidate(35),
    AdobeLibraryErrorCannotLeaveLibraryOwnedByUser(36),
    AdobeLibraryErrorCannotDeleteLibrarySharedWithUser(37),
    AdobeLibraryErrorLeavingSharedLibrary(38),
    AdobeLibraryErrorCannotShutdownDelegatesExist(39),
    AdobeLibraryErrorURLNotValid(40),
    AdobeLibraryErrorURLNotAllowed(41),
    AdobeLibraryErrorElementCopyFailed(42),
    AdobeLibraryErrorInvalidElement(43),
    AdobeLibraryErrorNoWriteAccess(44),
    AdobeLibraryErrorSyncBookmarksToCloud(45),
    AdobeLibraryErrorReadOnlyLibrary(46),
    AdobeLibraryErrorFailedToAddStockElementDuplicate(47);

    private int _val;

    AdobeLibraryErrorCode(int i) {
        this._val = i;
    }

    public int getValue() {
        return this._val;
    }
}

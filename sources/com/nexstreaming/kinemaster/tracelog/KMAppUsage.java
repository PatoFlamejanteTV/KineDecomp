package com.nexstreaming.kinemaster.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.tracelog.AppUsage;

/* loaded from: classes.dex */
public class KMAppUsage {
    public static AppUsage a(Context context) {
        return d.a(context);
    }

    /* loaded from: classes.dex */
    public enum MetricCategory {
        Theme(27021597764222976L),
        Effect(31525197391593472L),
        Sticker(36028797018963968L),
        UI(40532396646334464L);

        private long value;

        public long getValue() {
            return this.value;
        }

        MetricCategory(long j) {
            this.value = j;
        }

        public static MetricCategory fromMetric(AppUsage.a aVar) {
            long value = 67553994410557440L & aVar.getValue();
            for (MetricCategory metricCategory : values()) {
                if (metricCategory.value == value) {
                    return metricCategory;
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public enum KMMetric implements AppUsage.a {
        ThemeDownloaded(MetricCategory.Theme, AppUsage.MetricType.Counter, 1, true),
        ThemeAppliedInGetStartedMode(MetricCategory.Theme, AppUsage.MetricType.Counter, 2, true),
        ThemeAppliedToExistingProject(MetricCategory.Theme, AppUsage.MetricType.Counter, 3, true),
        ExportWithThemeApplied(MetricCategory.Theme, AppUsage.MetricType.Counter, 4, true),
        StickerAppliedInDrawingEditor(MetricCategory.Sticker, AppUsage.MetricType.Counter, 5, true),
        ClipEffectSelected(MetricCategory.Effect, AppUsage.MetricType.Counter, 6, true),
        ExportWithClipEffectApplied(MetricCategory.Effect, AppUsage.MetricType.Counter, 7, true),
        SecondsSpentInKineMaster(MetricCategory.UI, AppUsage.MetricType.Total, 8, false),
        KineMasterStarted(MetricCategory.UI, AppUsage.MetricType.Counter, 9, false),
        VisitThemeDownloadPage(MetricCategory.UI, AppUsage.MetricType.Counter, 10, true),
        NumberOfProjects(MetricCategory.UI, AppUsage.MetricType.Value, 11, false),
        PeakNumberOfProjects(MetricCategory.UI, AppUsage.MetricType.Peak, 12, false),
        GetStartedModeBegin(MetricCategory.UI, AppUsage.MetricType.Counter, 13, true),
        GetStartedModeFinish(MetricCategory.UI, AppUsage.MetricType.Counter, 14, true),
        SkipGetStartedMode(MetricCategory.UI, AppUsage.MetricType.Counter, 15, true),
        ProjectMangagerTapHelp(MetricCategory.UI, AppUsage.MetricType.Counter, 16, true),
        ProjectMangagerTapExport(MetricCategory.UI, AppUsage.MetricType.Counter, 17, true),
        ProjectMangagerTapPlay(MetricCategory.UI, AppUsage.MetricType.Counter, 18, true),
        ProjectMangagerTapDeleteOK(MetricCategory.UI, AppUsage.MetricType.Counter, 19, true),
        ProjectMangagerTapDeleteCancel(MetricCategory.UI, AppUsage.MetricType.Counter, 20, true),
        NavigateToSettings(MetricCategory.UI, AppUsage.MetricType.Counter, 21, true),
        NavigateToAbout(MetricCategory.UI, AppUsage.MetricType.Counter, 22, true),
        TotalExportedProjectDuration(MetricCategory.UI, AppUsage.MetricType.Total, 23, true),
        PeakExportedProjectDuration(MetricCategory.UI, AppUsage.MetricType.Peak, 24, false),
        ExportSuccess(MetricCategory.UI, AppUsage.MetricType.Counter, 25, true),
        ExportCancel(MetricCategory.UI, AppUsage.MetricType.Counter, 26, true),
        ExportFail(MetricCategory.UI, AppUsage.MetricType.Counter, 27, true),
        StartExportCount(MetricCategory.UI, AppUsage.MetricType.Counter, 28, true),
        CheckForUpdateUsingMobileNetwork(MetricCategory.UI, AppUsage.MetricType.Value, 29, false),
        ResetGuideOverlays(MetricCategory.UI, AppUsage.MetricType.Counter, 30, true),
        ChangeExportLocation(MetricCategory.UI, AppUsage.MetricType.Counter, 31, true),
        MainUndo(MetricCategory.UI, AppUsage.MetricType.Counter, 32, true),
        MainRedo(MetricCategory.UI, AppUsage.MetricType.Counter, 33, true),
        OptionBarUndo(MetricCategory.UI, AppUsage.MetricType.Counter, 34, true),
        OptionBarRedo(MetricCategory.UI, AppUsage.MetricType.Counter, 35, true),
        PreviewPlay(MetricCategory.UI, AppUsage.MetricType.Counter, 36, true),
        PreviewPlayLongPress(MetricCategory.UI, AppUsage.MetricType.Counter, 37, true),
        TimelineOpenSwipeUp(MetricCategory.UI, AppUsage.MetricType.Counter, 38, true),
        TimelineCloseSwipeDown(MetricCategory.UI, AppUsage.MetricType.Counter, 39, true),
        TimelineOpenButton(MetricCategory.UI, AppUsage.MetricType.Counter, 40, true),
        TimelineCloseButton(MetricCategory.UI, AppUsage.MetricType.Counter, 41, true),
        TimelineOpenAuto(MetricCategory.UI, AppUsage.MetricType.Counter, 42, true),
        TimelineCloseAuto(MetricCategory.UI, AppUsage.MetricType.Counter, 43, true),
        RecVideo(MetricCategory.UI, AppUsage.MetricType.Counter, 44, true),
        RecImage(MetricCategory.UI, AppUsage.MetricType.Counter, 45, true),
        RecAudio(MetricCategory.UI, AppUsage.MetricType.Counter, 46, true),
        AddVisualSingleClip(MetricCategory.UI, AppUsage.MetricType.Counter, 47, true),
        AddVisualMultipleClips(MetricCategory.UI, AppUsage.MetricType.Counter, 48, true),
        AddAudio(MetricCategory.UI, AppUsage.MetricType.Counter, 49, true),
        VisualSplitAtPlayhead(MetricCategory.UI, AppUsage.MetricType.Counter, 50, true),
        VisualTrimToRightOfPlayhead(MetricCategory.UI, AppUsage.MetricType.Counter, 51, true),
        VisualTrimToLeftOfPlayhead(MetricCategory.UI, AppUsage.MetricType.Counter, 52, true),
        VisualCaptureAndSave(MetricCategory.UI, AppUsage.MetricType.Counter, 53, true),
        VisualCaptureAndInsert(MetricCategory.UI, AppUsage.MetricType.Counter, 54, true),
        VisualSplitInsertFreezeFrame(MetricCategory.UI, AppUsage.MetricType.Counter, 55, true),
        VisualAdjustCrop(MetricCategory.UI, AppUsage.MetricType.Counter, 56, true),
        VisualDoubleTapResetCrop(MetricCategory.UI, AppUsage.MetricType.Counter, 57, true),
        DeleteVisualClip(MetricCategory.UI, AppUsage.MetricType.Counter, 58, true),
        RearrangeVisualClip(MetricCategory.UI, AppUsage.MetricType.Counter, 59, true),
        AddBookmarkWhilePaused(MetricCategory.UI, AppUsage.MetricType.Counter, 60, true),
        AddBookmarkWhilePlaying(MetricCategory.UI, AppUsage.MetricType.Counter, 61, true),
        GoToBookmark(MetricCategory.UI, AppUsage.MetricType.Counter, 62, true),
        BookmarkLongPressMenu(MetricCategory.UI, AppUsage.MetricType.Counter, 63, true),
        PinchToZoomTimeline(MetricCategory.UI, AppUsage.MetricType.Counter, 64, true),
        EditTransitionFxDuration(MetricCategory.UI, AppUsage.MetricType.Value, 65, true),
        VisualMediaBrowserLongPress(MetricCategory.UI, AppUsage.MetricType.Counter, 66, true),
        AudioMediaBrowserPreviewPlay(MetricCategory.UI, AppUsage.MetricType.Counter, 67, true),
        HandwritingLaunch(MetricCategory.UI, AppUsage.MetricType.Counter, 68, true),
        HandwritingSetColor(MetricCategory.UI, AppUsage.MetricType.Counter, 69, true),
        HandwritingSetWidth(MetricCategory.UI, AppUsage.MetricType.Counter, 70, true),
        HandwritingUseEraserDuringSession(MetricCategory.UI, AppUsage.MetricType.Counter, 71, true),
        HandwritingUsePencilDuringSession(MetricCategory.UI, AppUsage.MetricType.Counter, 72, true),
        HandwritingUseBrushDuringSession(MetricCategory.UI, AppUsage.MetricType.Counter, 73, true),
        HandwritingUseStickerDuringSession(MetricCategory.UI, AppUsage.MetricType.Counter, 74, true),
        HandwritingRotateStickerDuringSession(MetricCategory.UI, AppUsage.MetricType.Counter, 75, true),
        HandwritingResizeStickerDuringSession(MetricCategory.UI, AppUsage.MetricType.Counter, 76, true),
        HandwritingEraseScreenDuringSession(MetricCategory.UI, AppUsage.MetricType.Counter, 77, true),
        NumVisualClips(MetricCategory.UI, AppUsage.MetricType.Peak, 78, false),
        NumAudioClips(MetricCategory.UI, AppUsage.MetricType.Peak, 79, false),
        NumVideoClips(MetricCategory.UI, AppUsage.MetricType.Peak, 80, false),
        NumImageClips(MetricCategory.UI, AppUsage.MetricType.Peak, 81, false),
        NumSolidClips(MetricCategory.UI, AppUsage.MetricType.Peak, 82, false),
        NumSimulAudioClips(MetricCategory.UI, AppUsage.MetricType.Peak, 83, false),
        ExportedProjNumVisualClips(MetricCategory.UI, AppUsage.MetricType.Peak, 84, true),
        ExportedProjNumAudioClips(MetricCategory.UI, AppUsage.MetricType.Peak, 85, true),
        ExportedProjNumSimulAudioClips(MetricCategory.UI, AppUsage.MetricType.Peak, 86, true),
        ExportedProjNumVideoClips(MetricCategory.UI, AppUsage.MetricType.Peak, 87, true),
        ExportedProjNumImageClips(MetricCategory.UI, AppUsage.MetricType.Peak, 88, true),
        ExportedProjNumSolidClips(MetricCategory.UI, AppUsage.MetricType.Peak, 89, true),
        ApplyVideoRotation(MetricCategory.UI, AppUsage.MetricType.Counter, 89, true),
        BrightnessAdjustment(MetricCategory.UI, AppUsage.MetricType.Value, 90, true),
        SaturationAdjustment(MetricCategory.UI, AppUsage.MetricType.Value, 91, true),
        ContrastAdjustment(MetricCategory.UI, AppUsage.MetricType.Value, 92, true),
        VideoVolumeAdj(MetricCategory.UI, AppUsage.MetricType.Value, 93, true),
        VideoMute(MetricCategory.UI, AppUsage.MetricType.Counter, 94, true),
        VideoBGMVolumeDrop(MetricCategory.UI, AppUsage.MetricType.Value, 95, true),
        ApplyEffectTextEntry(MetricCategory.UI, AppUsage.MetricType.Counter, 96, true),
        ApplyEffectCustomColor(MetricCategory.UI, AppUsage.MetricType.Counter, 97, true),
        ApplyVideoClipStartTrim(MetricCategory.UI, AppUsage.MetricType.Counter, 98, true),
        ApplyAudioClipStartTrim(MetricCategory.UI, AppUsage.MetricType.Counter, 99, true),
        ApplyVideoClipEndTrim(MetricCategory.UI, AppUsage.MetricType.Counter, 100, true),
        ApplyAudioClipEndTrim(MetricCategory.UI, AppUsage.MetricType.Counter, 101, true),
        VidVolumeEnvelopeAddPoint(MetricCategory.UI, AppUsage.MetricType.Counter, 102, true),
        ApplyAudioClipVolumeAdj(MetricCategory.UI, AppUsage.MetricType.Counter, 103, true),
        ApplyAudioClipMute(MetricCategory.UI, AppUsage.MetricType.Counter, 104, true),
        ApplyAudioClipLoop(MetricCategory.UI, AppUsage.MetricType.Counter, 105, true),
        ApplyCustomBGM(MetricCategory.UI, AppUsage.MetricType.Counter, 106, true),
        ApplyBookmark(MetricCategory.UI, AppUsage.MetricType.Counter, 107, true),
        ApplyEffectStartEndTimeAdj(MetricCategory.UI, AppUsage.MetricType.Counter, 108, true),
        ExportVideoRotation(MetricCategory.UI, AppUsage.MetricType.Counter, 109, true),
        ExportBrightnessAdjustment(MetricCategory.UI, AppUsage.MetricType.Counter, 110, true),
        ExportSaturationAdjustment(MetricCategory.UI, AppUsage.MetricType.Counter, 111, true),
        ExportContrastAdjustment(MetricCategory.UI, AppUsage.MetricType.Counter, 112, true),
        ExportVideoVolumeAdj(MetricCategory.UI, AppUsage.MetricType.Counter, 113, true),
        ExportVideoMute(MetricCategory.UI, AppUsage.MetricType.Counter, 114, true),
        ExportVideoBGMVolumeDrop(MetricCategory.UI, AppUsage.MetricType.Counter, 115, true),
        ExportEffectTextEntry(MetricCategory.UI, AppUsage.MetricType.Counter, 116, true),
        ExportEffectCustomColor(MetricCategory.UI, AppUsage.MetricType.Counter, 117, true),
        ExportVideoClipStartTrim(MetricCategory.UI, AppUsage.MetricType.Counter, 118, true),
        ExportAudioClipStartTrim(MetricCategory.UI, AppUsage.MetricType.Counter, 119, true),
        ExportVideoClipEndTrim(MetricCategory.UI, AppUsage.MetricType.Counter, 120, true),
        ExportAudioClipEndTrim(MetricCategory.UI, AppUsage.MetricType.Counter, 121, true),
        ExportVolumeEnvelope(MetricCategory.UI, AppUsage.MetricType.Counter, 122, true),
        ExportAudioClipVolumeAdj(MetricCategory.UI, AppUsage.MetricType.Counter, 123, true),
        ExportAudioClipMute(MetricCategory.UI, AppUsage.MetricType.Counter, 124, true),
        ExportAudioClipLoop(MetricCategory.UI, AppUsage.MetricType.Counter, 125, true),
        ExportCustomBGM(MetricCategory.UI, AppUsage.MetricType.Counter, 126, true),
        ExportBookmark(MetricCategory.UI, AppUsage.MetricType.Counter, 127, true),
        ExportEffectStartEndTimeAdj(MetricCategory.UI, AppUsage.MetricType.Counter, 128, true),
        NavigateToDevSettings(MetricCategory.UI, AppUsage.MetricType.Counter, 129, true),
        NavigateToHelpGettingStarted(MetricCategory.UI, AppUsage.MetricType.Counter, 130, true),
        NavigateToHelpTipsAndTricks(MetricCategory.UI, AppUsage.MetricType.Counter, 131, true),
        NavigateToHelpAdvancedFeatures(MetricCategory.UI, AppUsage.MetricType.Counter, 132, true),
        ExportWithLogoClip(MetricCategory.UI, AppUsage.MetricType.Counter, 133, true),
        ExportNoLogoClip(MetricCategory.UI, AppUsage.MetricType.Counter, 134, true),
        TransitionEffectSelected(MetricCategory.Effect, AppUsage.MetricType.Counter, 135, true),
        ExportWithTransitionApplied(MetricCategory.Effect, AppUsage.MetricType.Counter, 136, true),
        DeleteAudioClip(MetricCategory.UI, AppUsage.MetricType.Counter, 137, true),
        MoveAudioClip(MetricCategory.UI, AppUsage.MetricType.Counter, 138, true),
        ShareFBButtonTap(MetricCategory.UI, AppUsage.MetricType.Counter, 139, true),
        ShareGPlusButtonTap(MetricCategory.UI, AppUsage.MetricType.Counter, 140, true),
        ShareFBShowDescDialog(MetricCategory.UI, AppUsage.MetricType.Counter, 141, true),
        ShareFBUploadBegin(MetricCategory.UI, AppUsage.MetricType.Counter, 142, true),
        ShareFBUploadComplete(MetricCategory.UI, AppUsage.MetricType.Counter, 143, true),
        TranscodeStart(MetricCategory.UI, AppUsage.MetricType.Counter, 144, true),
        TranscodeUserCancel(MetricCategory.UI, AppUsage.MetricType.Counter, 145, true),
        TranscodeSuccess(MetricCategory.UI, AppUsage.MetricType.Counter, 146, true),
        TranscodeFail(MetricCategory.UI, AppUsage.MetricType.Counter, 147, true),
        VisualTapCropStartPos(MetricCategory.UI, AppUsage.MetricType.Counter, 148, true),
        VisualTapCropEndPos(MetricCategory.UI, AppUsage.MetricType.Counter, 149, true),
        ShareYoutubeButtonTap(MetricCategory.UI, AppUsage.MetricType.Counter, 150, true),
        ShareYoutubeUploadBegin(MetricCategory.UI, AppUsage.MetricType.Counter, 151, true),
        ShareYoutubeUploadComplete(MetricCategory.UI, AppUsage.MetricType.Counter, 152, true),
        ShareYoutubeUploadFail(MetricCategory.UI, AppUsage.MetricType.Counter, 153, true),
        SubInfo(MetricCategory.UI, AppUsage.MetricType.Counter, 154, true),
        SubAction(MetricCategory.UI, AppUsage.MetricType.Counter, 155, true),
        ThemeDownloadFailed(MetricCategory.UI, AppUsage.MetricType.Counter, 156, true),
        RecVideoKM(MetricCategory.UI, AppUsage.MetricType.Counter, 157, true),
        DeviceInfo(MetricCategory.UI, AppUsage.MetricType.Counter, 158, true),
        OptionBarButtonTap(MetricCategory.UI, AppUsage.MetricType.Counter, 159, true),
        ExtractAudio(MetricCategory.UI, AppUsage.MetricType.Counter, 160, true),
        ApplyColorEffect(MetricCategory.UI, AppUsage.MetricType.Counter, 161, true),
        VideoSpeedControl(MetricCategory.UI, AppUsage.MetricType.Value, 162, true),
        VidVolumeEnvelopeDeletePoint(MetricCategory.UI, AppUsage.MetricType.Counter, 163, true),
        VidVolumeEnvelopeNextPoint(MetricCategory.UI, AppUsage.MetricType.Counter, 164, true),
        VidVolumeEnvelopePrevPoint(MetricCategory.UI, AppUsage.MetricType.Counter, 165, true),
        VidVolumeEnvelopeAdjustVolume(MetricCategory.UI, AppUsage.MetricType.Counter, 166, true),
        CamcordingDone(MetricCategory.UI, AppUsage.MetricType.Counter, 167, true),
        BailReport(MetricCategory.UI, AppUsage.MetricType.Counter, 168, true),
        CloudFolderTap(MetricCategory.UI, AppUsage.MetricType.Counter, 169, true),
        CloudFolderStartDownload(MetricCategory.UI, AppUsage.MetricType.Counter, 170, true),
        CloudFolderFinishDownload(MetricCategory.UI, AppUsage.MetricType.Counter, 171, true),
        CloudFolderCancelDownload(MetricCategory.UI, AppUsage.MetricType.Counter, 172, true),
        CloudFolderFailDownload(MetricCategory.UI, AppUsage.MetricType.Counter, 173, true),
        ProjectMangagerOpenExisting(MetricCategory.UI, AppUsage.MetricType.Counter, 174, true),
        ProjectMangagerActivityCreated(MetricCategory.UI, AppUsage.MetricType.Counter, 175, true),
        FinishEditingProject(MetricCategory.UI, AppUsage.MetricType.Counter, 176, true);

        private boolean flurryReporting;
        private long value;

        @Override // com.nexstreaming.app.general.tracelog.AppUsage.a
        public long getValue() {
            return this.value;
        }

        public String getName() {
            return name();
        }

        @Override // com.nexstreaming.app.general.tracelog.AppUsage.a
        public boolean shouldReportForMode(AppUsage.ReportingMode reportingMode) {
            if (reportingMode == AppUsage.ReportingMode.FLURRY) {
                return this.flurryReporting;
            }
            return true;
        }

        KMMetric(MetricCategory metricCategory, AppUsage.MetricType metricType, int i, boolean z) {
            this.flurryReporting = z;
            this.value = metricType.getValue() | metricCategory.getValue() | ((i & 32767) << 32);
        }
    }
}

package com.nextreaming.nexvideoeditor;

import java.util.Vector;

/* loaded from: classes.dex */
public final class NexVisualClip {
    public String mClipEffectID;
    public String mClipPath;
    public String mFilterID;
    public int mManualVolumeControl;
    public String mThumbnailPath;
    public String mTitle;
    public String mTitleEffectID;
    public int mClipID = 0;
    public int mClipType = 0;
    public int mTotalAudioTime = 0;
    public int mTotalVideoTime = 0;
    public int mTotalTime = 0;
    public int mStartTime = 0;
    public int mEndTime = 0;
    public int mStartTrimTime = 0;
    public int mEndTrimTime = 0;
    public int mWidth = 0;
    public int mHeight = 0;
    public int mExistVideo = 0;
    public int mExistAudio = 0;
    public int mTitleStyle = 0;
    public int mTitleStartTime = 0;
    public int mTitleEndTime = 0;
    public NexRectangle mStartRect = new NexRectangle(0, 0, 0, 0);
    public NexRectangle mEndRect = new NexRectangle(0, 0, 0, 0);
    public NexRectangle mDestRect = new NexRectangle(0, 0, 0, 0);
    public int mAudioOnOff = 0;
    public int mClipVolume = 0;
    public int mBGMVolume = 0;
    public int mRotateState = 0;
    public int mBrightness = 0;
    public int mContrast = 0;
    public int mSaturation = 0;
    public int mTintcolor = 0;
    public int mLUT = 0;
    public int mVignette = 0;
    public int mSpeedControl = 0;
    public int mVoiceChanger = 0;
    public int mCompressor = 0;
    public int mPitchFactor = 0;
    public int mMusicEffector = 0;
    public int mProcessorStrength = -1;
    public int mBassStrength = -1;
    public int mPanLeft = -111;
    public int mPanRight = -111;
    public int mEffectDuration = 0;
    public int mEffectOffset = 0;
    public int mEffectOverlap = 0;
    public int[] mVolumeEnvelopeLevel = null;
    public int[] mVolumeEnvelopeTime = null;
    public float[] mStartMatrix = null;
    public float[] mEndMatrix = null;
    Vector<NexAudioClip> mAudioClipVec = new Vector<>();

    public void setStartRect(int i, int i2, int i3, int i4) {
        this.mStartRect.setRect(i, i2, i3, i4);
    }

    public void setEndRect(int i, int i2, int i3, int i4) {
        this.mEndRect.setRect(i, i2, i3, i4);
    }

    public void setDestRect(int i, int i2, int i3, int i4) {
        this.mDestRect.setRect(i, i2, i3, i4);
    }

    public int addAudioClip(NexAudioClip nexAudioClip) {
        this.mAudioClipVec.add(nexAudioClip);
        return 0;
    }

    public void deleteAudioClip(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mAudioClipVec.size()) {
                if (this.mAudioClipVec.get(i3).mClipID == i) {
                    this.mAudioClipVec.remove(i3);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void clearAudioClips() {
        this.mAudioClipVec.clear();
    }
}

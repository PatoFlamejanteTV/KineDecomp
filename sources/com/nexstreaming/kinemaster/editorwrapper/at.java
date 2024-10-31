package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.Rect;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexAudioClip;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexRectangle;
import com.nextreaming.nexvideoeditor.NexVisualClip;
import java.io.File;

/* compiled from: SingleClipPreview.java */
/* loaded from: classes.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private VideoEditor f3321a;
    private int b;
    private Task d;
    private boolean e = false;
    private Task c = new Task();

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(VideoEditor videoEditor, int i) {
        this.f3321a = videoEditor;
        this.b = i;
        this.c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    public void a(File file) {
        if (!this.e) {
            FileType fromFile = FileType.fromFile(file);
            MediaInfo a2 = MediaInfo.a(file);
            NexEditor a3 = EditorGlobal.a();
            Rect rect = new Rect(0, 0, a2.w(), a2.x());
            a(rect, 1.7777778f);
            NexVisualClip nexVisualClip = new NexVisualClip();
            nexVisualClip.mClipID = 33554431;
            nexVisualClip.mClipPath = file.getAbsolutePath();
            nexVisualClip.mClipType = fromFile.isImage() ? 1 : 4;
            nexVisualClip.mStartTime = 0;
            nexVisualClip.mWidth = a2.w();
            nexVisualClip.mHeight = a2.x();
            nexVisualClip.mTotalTime = a2.y();
            nexVisualClip.mTotalAudioTime = a2.z();
            nexVisualClip.mTotalVideoTime = a2.A();
            nexVisualClip.mExistAudio = a2.r() ? 1 : 0;
            nexVisualClip.mExistVideo = a2.s() ? 1 : 0;
            nexVisualClip.mSpeedControl = 100;
            nexVisualClip.mEndTime = nexVisualClip.mStartTime + nexVisualClip.mTotalTime;
            nexVisualClip.mVolumeEnvelopeLevel = new int[]{100};
            nexVisualClip.mVolumeEnvelopeTime = new int[]{0};
            nexVisualClip.mStartRect = new NexRectangle((rect.left * NexVideoClipItem.ABSTRACT_DIMENSION) / nexVisualClip.mWidth, (rect.top * NexVideoClipItem.ABSTRACT_DIMENSION) / nexVisualClip.mHeight, (rect.right * NexVideoClipItem.ABSTRACT_DIMENSION) / nexVisualClip.mWidth, (rect.bottom * NexVideoClipItem.ABSTRACT_DIMENSION) / nexVisualClip.mHeight);
            nexVisualClip.mEndRect = new NexRectangle((rect.left * NexVideoClipItem.ABSTRACT_DIMENSION) / nexVisualClip.mWidth, (rect.top * NexVideoClipItem.ABSTRACT_DIMENSION) / nexVisualClip.mHeight, (rect.right * NexVideoClipItem.ABSTRACT_DIMENSION) / nexVisualClip.mWidth, (rect.bottom * NexVideoClipItem.ABSTRACT_DIMENSION) / nexVisualClip.mHeight);
            a3.a(new NexVisualClip[]{nexVisualClip}, new NexAudioClip[0]);
        }
    }

    public void a(int i) {
        if (!this.e) {
            Task task = new Task();
            this.c = task;
            EditorGlobal.a().a(i, new au(this, task));
        }
    }

    private static void a(Rect rect, float f) {
        if (rect.width() / rect.height() < f) {
            int height = (int) (rect.height() * f);
            rect.left = rect.centerX() - (height / 2);
            rect.right = height + rect.left;
        } else {
            int width = (int) (rect.width() / f);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = width + rect.top;
        }
    }

    public Task b(int i) {
        if (this.e) {
            return this.d;
        }
        this.d = new Task();
        this.e = true;
        this.c.onComplete(new av(this, i));
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LayerRenderer layerRenderer) {
    }
}

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
public class Da {

    /* renamed from: a, reason: collision with root package name */
    private VideoEditor f20187a;

    /* renamed from: b, reason: collision with root package name */
    private int f20188b;

    /* renamed from: d, reason: collision with root package name */
    private Task f20190d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f20191e = false;

    /* renamed from: c, reason: collision with root package name */
    private Task f20189c = new Task();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Da(VideoEditor videoEditor, int i) {
        this.f20187a = videoEditor;
        this.f20188b = i;
        this.f20189c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LayerRenderer layerRenderer) {
    }

    public void b(int i) {
        if (this.f20191e) {
            return;
        }
        Task task = new Task();
        this.f20189c = task;
        EditorGlobal.i().a(i, new Ba(this, task));
    }

    public void a(File file) {
        if (this.f20191e) {
            return;
        }
        FileType fromFile = FileType.fromFile(file);
        MediaInfo a2 = MediaInfo.a(file);
        NexEditor i = EditorGlobal.i();
        int R = a2.R();
        int v = a2.v();
        if (a2.z() == 90 || a2.z() == 270) {
            R = a2.v();
            v = a2.R();
        }
        Rect rect = new Rect(0, 0, R, v);
        a(rect, EditorGlobal.l());
        NexVisualClip nexVisualClip = new NexVisualClip();
        nexVisualClip.mClipID = 33554431;
        nexVisualClip.mClipPath = file.getAbsolutePath();
        nexVisualClip.mClipType = fromFile.isImage() ? 1 : 4;
        nexVisualClip.mStartTime = 0;
        nexVisualClip.mWidth = a2.R();
        nexVisualClip.mHeight = a2.v();
        nexVisualClip.mTotalTime = a2.r();
        nexVisualClip.mTotalAudioTime = a2.o();
        nexVisualClip.mTotalVideoTime = a2.K();
        nexVisualClip.mExistAudio = a2.S() ? 1 : 0;
        nexVisualClip.mExistVideo = a2.U() ? 1 : 0;
        nexVisualClip.mSpeedControl = 100;
        nexVisualClip.mEndTime = nexVisualClip.mStartTime + nexVisualClip.mTotalTime;
        nexVisualClip.mVolumeEnvelopeLevel = new int[]{100};
        nexVisualClip.mVolumeEnvelopeTime = new int[]{0};
        nexVisualClip.mRotateState = a2.z();
        nexVisualClip.mStartRect = a(rect, R, v, 0);
        nexVisualClip.mEndRect = a(rect, R, v, 0);
        i.a(new NexVisualClip[]{nexVisualClip}, new NexAudioClip[0]);
    }

    private NexRectangle a(Rect rect, int i, int i2, int i3) {
        if (i3 != 90 && i3 != 270) {
            return new NexRectangle((rect.left * NexVideoClipItem.ABSTRACT_DIMENSION) / i, (rect.top * NexVideoClipItem.ABSTRACT_DIMENSION) / i2, (rect.right * NexVideoClipItem.ABSTRACT_DIMENSION) / i, (rect.bottom * NexVideoClipItem.ABSTRACT_DIMENSION) / i2);
        }
        return new NexRectangle((rect.top * NexVideoClipItem.ABSTRACT_DIMENSION) / i2, (rect.left * NexVideoClipItem.ABSTRACT_DIMENSION) / i, (rect.bottom * NexVideoClipItem.ABSTRACT_DIMENSION) / i2, (rect.right * NexVideoClipItem.ABSTRACT_DIMENSION) / i);
    }

    private static void a(Rect rect, float f2) {
        if (rect.width() / rect.height() < f2) {
            int height = (int) (rect.height() * f2);
            rect.left = rect.centerX() - (height / 2);
            rect.right = rect.left + height;
        } else {
            int width = (int) (rect.width() / f2);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = rect.top + width;
        }
    }

    public Task a(int i) {
        if (this.f20191e) {
            return this.f20190d;
        }
        this.f20190d = new Task();
        this.f20191e = true;
        this.f20189c.onComplete(new Ca(this, i));
        return this.f20190d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task a() {
        return this.f20190d;
    }
}

package com.facebook.ads.redexgen.X;

import android.widget.MediaController;

/* loaded from: assets/audience_network.dex */
public class FW implements MediaController.MediaPlayerControl {
    public final /* synthetic */ FS A00;

    public FW(FS fs) {
        this.A00 = fs;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:            return r1;     */
    @Override // android.widget.MediaController.MediaPlayerControl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getAudioSessionId() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.FS r0 = r2.A00
            android.media.MediaPlayer r0 = com.facebook.ads.redexgen.X.FS.A00(r0)
            if (r0 == 0) goto L20
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L22;
                case 4: goto L1d;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.FW r2 = (com.facebook.ads.redexgen.X.FW) r2
            com.facebook.ads.redexgen.X.FS r0 = r2.A00
            android.media.MediaPlayer r0 = com.facebook.ads.redexgen.X.FS.A00(r0)
            int r1 = r0.getAudioSessionId()
            r0 = 3
            goto Lb
        L1d:
            r1 = 0
            r0 = 3
            goto Lb
        L20:
            r0 = 4
            goto Lb
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FW.getAudioSessionId():int");
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        return this.A00.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        return this.A00.getDuration();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0029, code lost:            return r1;     */
    @Override // android.widget.MediaController.MediaPlayerControl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isPlaying() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.FS r0 = r2.A00
            android.media.MediaPlayer r0 = com.facebook.ads.redexgen.X.FS.A00(r0)
            if (r0 == 0) goto L27
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L21;
                case 4: goto L29;
                case 5: goto L24;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.FW r2 = (com.facebook.ads.redexgen.X.FW) r2
            com.facebook.ads.redexgen.X.FS r0 = r2.A00
            android.media.MediaPlayer r0 = com.facebook.ads.redexgen.X.FS.A00(r0)
            boolean r0 = r0.isPlaying()
            if (r0 == 0) goto L1f
            r0 = 3
            goto Lb
        L1f:
            r0 = 5
            goto Lb
        L21:
            r1 = 1
            r0 = 4
            goto Lb
        L24:
            r1 = 0
            r0 = 4
            goto Lb
        L27:
            r0 = 5
            goto Lb
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FW.isPlaying():boolean");
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        this.A00.pause(true);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i) {
        this.A00.seekTo(i);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void start() {
        this.A00.A8Q(QH.A05);
    }
}

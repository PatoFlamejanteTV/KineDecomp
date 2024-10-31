package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
import java.io.IOException;

@TargetApi(14)
/* loaded from: assets/audience_network.dex */
public final class FS extends TextureView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnSeekCompleteListener, TextureView.SurfaceTextureListener, FT {
    public static byte[] A0O;
    public static final String A0P;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;

    @Nullable
    public MediaPlayer A06;
    public Uri A07;
    public Surface A08;
    public View A09;

    @Nullable
    public MediaController A0A;
    public QH A0B;
    public FR A0C;
    public FR A0D;
    public FR A0E;
    public LY A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public final long A0L;
    public final MediaController.MediaPlayerControl A0M;
    public final C0362Ec A0N;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.FS.A0O
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            int r0 = r0 - r4
            int r0 = r0 + (-42)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A0O = new byte[]{122, -94, -94, -102, -97, -104, 83, -108, -97, -86, -108, -84, -90, 83, -89, -101, -91, -94, -86, 83, -108, -95, 83, -104, -85, -106, -104, -93, -89, -100, -94, -95, 83, -86, -100, -89, -101, 83, -90, -104, -89, 121, -94, -91, -104, -102, -91, -94, -88, -95, -105, 83, -94, -95, 83, -127, -94, -88, -102, -108, -89, 83, -108, -107, -94, -87, -104, 97, 83, -90, -94, 83, -86, -104, 83, -90, -100, -97, -104, -95, -89, -97, -84, 83, -100, -102, -95, -94, -91, -104, 83, -100, -89, 97, 95, 105, 93, 95, -94, -75, -79, -81, -98, 95, 93, 119, 93, 95, 124, -92, -92, -100, -95, -102, 85, -106, -95, -84, -106, -82, -88, 85, -87, -99, -89, -92, -84, 85, -106, -93, 85, -102, -83, -104, -102, -91, -87, -98, -92, -93, 85, -84, -98, -87, -99, 85, -88, -102, -87, 119, -106, -104, -96, -100, -89, -92, -86, -93, -103, 121, -89, -106, -84, -106, -105, -95, -102, 85, -92, -93, 85, -125, -92, -86, -100, -106, -87, 85, -106, -105, -92, -85, -102, 99, 85, -88, -92, 85, -84, -102, 85, -88, -98, -95, -102, -93, -87, -95, -82, 85, -98, -100, -93, -92, -89, -102, 85, -98, -87, 99, -16, 3, -2, -1, 9, -70, 13, 14, -5, 14, -1, -70, -3, 2, -5, 8, 1, -1, -2, -70, 14, 9, -70, -35, -10, 7, -7, 12, -10, 7, -6, -75, -10, -8, -8, -6, 1, -6, 7, -10, 9, -2, 4, 3, -75, 10, 3, -10, 11, -10, -2, 1, -10, -9, 1, -6, -21, 9, 22, 22, 23, 28, -56, 24, 26, 13, 24, 9, 26, 13, -56, 21, 13, 12, 17, 9, -56, 24, 20, 9, 33, 13, 26, -56, 31, 17, 28, 16, -56, -5, 29, 26, 14, 9, 11, 13, -4, 13, 32, 28, 29, 26, 13, -30, -56, -34, -16, -16, -30, -15, -80, -36, -30, -39, -47, -37, -108, -31, -115, -33, -46, -31, -33, -42, -46, -29, -46, -115, -29, -42, -47, -46, -36, -115, -42, -37, -45, -36, -33, -38, -50, -31, -42, -36, -37, -50, -63, -68, -67, -57, 9, -80, 5, -10, -17, 2, -80, -82, -56, -82, -80, -54, -27, -19, -16, -23, -24, -92, -8, -13, -92, -13, -12, -23, -14, -92, -27, -9, -9, -23, -8, -9, -92, -117, -92, -105, -104, -94, -101, 86, -86, -91, 86, -103, -94, -91, -87, -101, -2, -6, -17, 7, -13, 0, 102, -63};
    }

    static {
        A03();
        A0P = FS.class.getSimpleName();
    }

    public FS(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A0C = FR.A04;
        this.A0E = FR.A04;
        this.A0D = FR.A04;
        this.A0J = false;
        this.A03 = 0;
        this.A05 = 0;
        this.A04 = 0;
        this.A00 = 1.0f;
        this.A0I = false;
        this.A01 = 3;
        this.A0G = false;
        this.A0K = false;
        this.A02 = 0;
        this.A0H = false;
        this.A0B = QH.A04;
        this.A0M = new FW(this);
        this.A0N = c0362Ec;
    }

    public FS(C0362Ec c0362Ec, AttributeSet attributeSet) {
        super(c0362Ec, attributeSet);
        this.A0C = FR.A04;
        this.A0E = FR.A04;
        this.A0D = FR.A04;
        this.A0J = false;
        this.A03 = 0;
        this.A05 = 0;
        this.A04 = 0;
        this.A00 = 1.0f;
        this.A0I = false;
        this.A01 = 3;
        this.A0G = false;
        this.A0K = false;
        this.A02 = 0;
        this.A0H = false;
        this.A0B = QH.A04;
        this.A0M = new FW(this);
        this.A0N = c0362Ec;
    }

    public FS(C0362Ec c0362Ec, AttributeSet attributeSet, int i) {
        super(c0362Ec, attributeSet, i);
        this.A0C = FR.A04;
        this.A0E = FR.A04;
        this.A0D = FR.A04;
        this.A0J = false;
        this.A03 = 0;
        this.A05 = 0;
        this.A04 = 0;
        this.A00 = 1.0f;
        this.A0I = false;
        this.A01 = 3;
        this.A0G = false;
        this.A0K = false;
        this.A02 = 0;
        this.A0H = false;
        this.A0B = QH.A04;
        this.A0M = new FW(this);
        this.A0N = c0362Ec;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A04() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.FR r1 = r3.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A08
            if (r1 == r0) goto L1f
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r1 = r3.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A07
            if (r1 == r0) goto L17
            r0 = 3
            goto L9
        L17:
            r0 = 5
            goto L9
        L19:
            r2 = 1
            r0 = 4
            goto L9
        L1c:
            r2 = 0
            r0 = 4
            goto L9
        L1f:
            r0 = 5
            goto L9
        L21:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.A04():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0039, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A05() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.FR r1 = r3.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A07
            if (r1 == r0) goto L37
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L28;
                case 3: goto L1c;
                case 4: goto L10;
                case 5: goto Ld;
                case 6: goto L39;
                case 7: goto L34;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r2 = 1
            r0 = 6
            goto L9
        L10:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r1 = r3.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A06
            if (r1 != r0) goto L1a
            r0 = 5
            goto L9
        L1a:
            r0 = 7
            goto L9
        L1c:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r1 = r3.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            if (r1 == r0) goto L26
            r0 = 4
            goto L9
        L26:
            r0 = 5
            goto L9
        L28:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r1 = r3.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A0A
            if (r1 == r0) goto L32
            r0 = 3
            goto L9
        L32:
            r0 = 5
            goto L9
        L34:
            r2 = 0
            r0 = 6
            goto L9
        L37:
            r0 = 5
            goto L9
        L39:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.A05():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A06() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.FR r1 = r3.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A08
            if (r1 == r0) goto L1f
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r1 = r3.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A07
            if (r1 == r0) goto L17
            r0 = 3
            goto L9
        L17:
            r0 = 5
            goto L9
        L19:
            r2 = 1
            r0 = 4
            goto L9
        L1c:
            r2 = 0
            r0 = 4
            goto L9
        L1f:
            r0 = 5
            goto L9
        L21:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.A06():boolean");
    }

    private boolean A07() {
        boolean z = false;
        if (this.A06 == null) {
            return false;
        }
        try {
            this.A06.reset();
            z = true;
            return true;
        } catch (IllegalStateException e) {
            C0511Kb.A06(this.A0N, A02(408, 6, 100), C0512Kc.A1a, new C0514Ke(e));
            return z;
        }
    }

    private boolean A08(@Nullable Surface surface) {
        boolean z = false;
        if (this.A06 == null) {
            return false;
        }
        try {
            this.A06.setSurface(surface);
            z = true;
            return true;
        } catch (IllegalStateException e) {
            C0511Kb.A06(this.A0N, A02(408, 6, 100), C0512Kc.A1b, new C0514Ke(e));
            return z;
        }
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public final void A53() {
        if (!this.A0G) {
            pause(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0061, code lost:            return r10;     */
    @Override // com.facebook.ads.redexgen.X.FT
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A55() {
        /*
            r11 = this;
            r8 = r11
            r7 = 0
            r6 = 0
            r0 = 0
            r5 = 0
            r0 = 0
            r10 = 1
            r9 = 0
            android.media.MediaPlayer r0 = r8.A06
            if (r0 == 0) goto L5f
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L22;
                case 3: goto L1e;
                case 4: goto L61;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L10;
                case 8: goto L10;
                case 9: goto L31;
                case 10: goto L3d;
                case 11: goto L10;
                case 12: goto L10;
                case 13: goto L2c;
                case 14: goto L39;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.FS r8 = (com.facebook.ads.redexgen.X.FS) r8     // Catch: java.lang.RuntimeException -> L4d
            android.media.MediaPlayer r0 = r8.A06     // Catch: java.lang.RuntimeException -> L4d
            android.media.MediaPlayer$TrackInfo[] r7 = r0.getTrackInfo()     // Catch: java.lang.RuntimeException -> L4d
            int r5 = r7.length     // Catch: java.lang.RuntimeException -> L4d
            r6 = r9
            r0 = 9
            goto Ld
        L1e:
            r9 = 0
            r10 = r9
            r0 = 4
            goto Ld
        L22:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r1 >= r0) goto L2a
            r0 = 3
            goto Ld
        L2a:
            r0 = 5
            goto Ld
        L2c:
            int r6 = r6 + 1
            r0 = 9
            goto Ld
        L31:
            if (r6 >= r5) goto L36
            r0 = 10
            goto Ld
        L36:
            r0 = 14
            goto Ld
        L39:
            r9 = 0
            r10 = r9
            r0 = 4
            goto Ld
        L3d:
            android.media.MediaPlayer$TrackInfo[] r7 = (android.media.MediaPlayer.TrackInfo[]) r7     // Catch: java.lang.RuntimeException -> L4d
            r0 = r7[r6]     // Catch: java.lang.RuntimeException -> L4d
            int r1 = r0.getTrackType()     // Catch: java.lang.RuntimeException -> L4d
            r0 = 2
            if (r1 == r0) goto L4b
            r0 = 13
            goto Ld
        L4b:
            r0 = 4
            goto Ld
        L4d:
            r4 = move-exception
            java.lang.String r3 = com.facebook.ads.redexgen.X.FS.A0P
            r2 = 320(0x140, float:4.48E-43)
            r1 = 35
            r0 = 67
            java.lang.String r0 = A02(r2, r1, r0)
            android.util.Log.e(r3, r0, r4)
            r0 = 4
            goto Ld
        L5f:
            r0 = 3
            goto Ld
        L61:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.A55():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public final boolean A56() {
        return this.A0K;
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public final void A8P(int i) {
        this.A0N.A08().A5y(i);
        setVideoState(FR.A09);
        stop();
        this.A03 = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x00be, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.FT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A8Q(com.facebook.ads.redexgen.X.QH r4) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.A8Q(com.facebook.ads.redexgen.X.QH):void");
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public final void destroy() {
        if (this.A06 != null) {
            A08(null);
            this.A06.setOnBufferingUpdateListener(null);
            this.A06.setOnCompletionListener(null);
            this.A06.setOnErrorListener(null);
            this.A06.setOnInfoListener(null);
            this.A06.setOnPreparedListener(null);
            this.A06.setOnVideoSizeChangedListener(null);
            this.A06.setOnSeekCompleteListener(null);
            A07();
            this.A06 = null;
            setVideoState(FR.A04);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.FT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getCurrentPosition() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            android.media.MediaPlayer r0 = r2.A06
            if (r0 == 0) goto L22
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L18;
                case 4: goto L24;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            boolean r0 = r2.A05()
            if (r0 == 0) goto L16
            r0 = 3
            goto L8
        L16:
            r0 = 4
            goto L8
        L18:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            android.media.MediaPlayer r0 = r2.A06
            int r1 = r0.getCurrentPosition()
            r0 = 4
            goto L8
        L22:
            r0 = 4
            goto L8
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.getCurrentPosition():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0026, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.FT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getDuration() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            android.media.MediaPlayer r0 = r2.A06
            if (r0 == 0) goto L24
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L17;
                case 4: goto L26;
                case 5: goto L1a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            boolean r0 = r2.A05()
            if (r0 != 0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 5
            goto L7
        L17:
            r1 = 0
            r0 = 4
            goto L7
        L1a:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            android.media.MediaPlayer r0 = r2.A06
            int r1 = r0.getDuration()
            r0 = 4
            goto L7
        L24:
            r0 = 3
            goto L7
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.getDuration():int");
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public long getInitialBufferTime() {
        return this.A0L;
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public QH getStartReason() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public FR getState() {
        return this.A0C;
    }

    public FR getTargetState() {
        return this.A0E;
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public int getVideoHeight() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public int getVideoWidth() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public float getVolume() {
        return this.A00;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            setVideoState(FR.A03);
            stop();
            C0511Kb.A06(this.A0N, A02(355, 5, 46), C0512Kc.A1l, new C0514Ke(A02(233, 33, 107)));
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (this.A06 != null) {
            this.A06.pause();
        }
        setVideoState(FR.A06);
        seekTo(0);
        this.A03 = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:            return true;     */
    @Override // android.media.MediaPlayer.OnErrorListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onError(android.media.MediaPlayer r7, int r8, int r9) {
        /*
            r6 = this;
            r2 = r6
            com.facebook.ads.redexgen.X.Ec r0 = r2.A0N
            com.facebook.ads.redexgen.X.0c r5 = r0.A08()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r3 = 360(0x168, float:5.04E-43)
            r1 = 11
            r0 = 100
            java.lang.String r0 = A02(r3, r1, r0)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r4 = r0.append(r8)
            r3 = 94
            r1 = 14
            r0 = 19
            java.lang.String r0 = A02(r3, r1, r0)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r4 = r0.append(r9)
            r3 = 414(0x19e, float:5.8E-43)
            r1 = 2
            r0 = 26
            java.lang.String r0 = A02(r3, r1, r0)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r0 = r0.toString()
            r5.A5x(r0)
            int r0 = r2.A01
            if (r0 <= 0) goto L79
            r0 = 2
        L49:
            switch(r0) {
                case 2: goto L4d;
                case 3: goto L5b;
                case 4: goto L7b;
                case 5: goto L6d;
                default: goto L4c;
            }
        L4c:
            goto L49
        L4d:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            com.facebook.ads.redexgen.X.FR r1 = r2.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A0A
            if (r1 != r0) goto L59
            r0 = 3
            goto L49
        L59:
            r0 = 5
            goto L49
        L5b:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            int r0 = r2.A01
            int r0 = r0 + (-1)
            r2.A01 = r0
            r2.stop()
            com.facebook.ads.redexgen.X.QH r0 = r2.A0B
            r2.A8Q(r0)
            r0 = 4
            goto L49
        L6d:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A03
            r2.setVideoState(r0)
            r2.stop()
            r0 = 4
            goto L49
        L79:
            r0 = 5
            goto L49
        L7b:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.onError(android.media.MediaPlayer, int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x004a, code lost:            return r2;     */
    @Override // android.media.MediaPlayer.OnInfoListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInfo(android.media.MediaPlayer r5, int r6, int r7) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = 1
            switch(r6) {
                case 3: goto L48;
                case 701: goto L43;
                case 702: goto L46;
                default: goto L6;
            }
        L6:
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L2e;
                case 3: goto L4a;
                case 4: goto L20;
                case 5: goto L17;
                case 6: goto Lb;
                case 7: goto L31;
                case 8: goto L3a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            boolean r0 = r3.A06()
            if (r0 == 0) goto L15
            r0 = 7
            goto L7
        L15:
            r0 = 2
            goto L7
        L17:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A0A
            r3.setVideoState(r0)
            r0 = 3
            goto L7
        L20:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            r3.A0K = r2
            com.facebook.ads.redexgen.X.FR r1 = r3.A0E
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A0A
            if (r1 != r0) goto L2c
            r0 = 5
            goto L7
        L2c:
            r0 = 3
            goto L7
        L2e:
            r2 = 0
            r0 = 3
            goto L7
        L31:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A0A
            r3.setVideoState(r0)
            r0 = 2
            goto L7
        L3a:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A02
            r3.setVideoState(r0)
            r0 = 2
            goto L7
        L43:
            r0 = 8
            goto L7
        L46:
            r0 = 6
            goto L7
        L48:
            r0 = 4
            goto L7
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.onInfo(android.media.MediaPlayer, int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00d8, code lost:            return;     */
    @Override // android.media.MediaPlayer.OnPreparedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onPrepared(android.media.MediaPlayer r8) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.onPrepared(android.media.MediaPlayer):void");
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        if (this.A0F == null) {
            return;
        }
        this.A0F.A7W(this.A02, this.A03);
        this.A03 = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0058, code lost:            return;     */
    @Override // android.view.TextureView.SurfaceTextureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onSurfaceTextureAvailable(android.graphics.SurfaceTexture r4, int r5, int r6) {
        /*
            r3 = this;
            r2 = r3
            android.view.Surface r0 = r2.A08
            if (r0 != 0) goto L56
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L33;
                case 3: goto L25;
                case 4: goto L19;
                case 5: goto L58;
                case 6: goto La;
                case 7: goto L40;
                case 8: goto L4d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            r0 = 0
            r2.A0J = r0
            com.facebook.ads.redexgen.X.FR r1 = r2.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            if (r1 != r0) goto L17
            r0 = 7
            goto L6
        L17:
            r0 = 5
            goto L6
        L19:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A03
            r2.setVideoState(r0)
            r2.destroy()
            r0 = 5
            goto L6
        L25:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            android.view.Surface r0 = r2.A08
            boolean r0 = r2.A08(r0)
            if (r0 != 0) goto L31
            r0 = 4
            goto L6
        L31:
            r0 = 6
            goto L6
        L33:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            android.graphics.SurfaceTexture r4 = (android.graphics.SurfaceTexture) r4
            android.view.Surface r0 = new android.view.Surface
            r0.<init>(r4)
            r2.A08 = r0
            r0 = 3
            goto L6
        L40:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            com.facebook.ads.redexgen.X.FR r1 = r2.A0D
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            if (r1 == r0) goto L4b
            r0 = 8
            goto L6
        L4b:
            r0 = 5
            goto L6
        L4d:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            com.facebook.ads.redexgen.X.QH r0 = r2.A0B
            r2.A8Q(r0)
            r0 = 5
            goto L6
        L56:
            r0 = 3
            goto L6
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.onSurfaceTextureAvailable(android.graphics.SurfaceTexture, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x005f, code lost:            return true;     */
    @Override // android.view.TextureView.SurfaceTextureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = 0
            r2 = 1
            r5.A08(r3)
            android.view.Surface r0 = r5.A08
            if (r0 == 0) goto L5d
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L35;
                case 3: goto L2b;
                case 4: goto L20;
                case 5: goto L1c;
                case 6: goto L12;
                case 7: goto L40;
                case 8: goto L4e;
                case 9: goto L5f;
                case 10: goto L57;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.FS r5 = (com.facebook.ads.redexgen.X.FS) r5
            com.facebook.ads.redexgen.X.FR r4 = (com.facebook.ads.redexgen.X.FR) r4
            r5.A0D = r4
            r5.A0J = r2
            r0 = 7
            goto Le
        L1c:
            com.facebook.ads.redexgen.X.FR r4 = com.facebook.ads.redexgen.X.FR.A0A
            r0 = 6
            goto Le
        L20:
            com.facebook.ads.redexgen.X.FS r5 = (com.facebook.ads.redexgen.X.FS) r5
            boolean r0 = r5.A0I
            if (r0 == 0) goto L28
            r0 = 5
            goto Le
        L28:
            r0 = 10
            goto Le
        L2b:
            com.facebook.ads.redexgen.X.FS r5 = (com.facebook.ads.redexgen.X.FS) r5
            boolean r0 = r5.A0J
            if (r0 != 0) goto L33
            r0 = 4
            goto Le
        L33:
            r0 = 7
            goto Le
        L35:
            com.facebook.ads.redexgen.X.FS r5 = (com.facebook.ads.redexgen.X.FS) r5
            android.view.Surface r0 = r5.A08
            r0.release()
            r5.A08 = r3
            r0 = 3
            goto Le
        L40:
            com.facebook.ads.redexgen.X.FS r5 = (com.facebook.ads.redexgen.X.FS) r5
            com.facebook.ads.redexgen.X.FR r1 = r5.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            if (r1 == r0) goto L4b
            r0 = 8
            goto Le
        L4b:
            r0 = 9
            goto Le
        L4e:
            com.facebook.ads.redexgen.X.FS r5 = (com.facebook.ads.redexgen.X.FS) r5
            r0 = 0
            r5.pause(r0)
            r0 = 9
            goto Le
        L57:
            com.facebook.ads.redexgen.X.FS r5 = (com.facebook.ads.redexgen.X.FS) r5
            com.facebook.ads.redexgen.X.FR r4 = r5.A0C
            r0 = 6
            goto Le
        L5d:
            r0 = 3
            goto Le
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.onSurfaceTextureDestroyed(android.graphics.SurfaceTexture):boolean");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:            return;     */
    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onVideoSizeChanged(android.media.MediaPlayer r3, int r4, int r5) {
        /*
            r2 = this;
            r1 = r2
            int r0 = r3.getVideoWidth()
            r1.A05 = r0
            int r0 = r3.getVideoHeight()
            r1.A04 = r0
            int r0 = r1.A05
            if (r0 == 0) goto L27
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L20;
                case 4: goto L29;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.FS r1 = (com.facebook.ads.redexgen.X.FS) r1
            int r0 = r1.A04
            if (r0 == 0) goto L1e
            r0 = 3
            goto L12
        L1e:
            r0 = 4
            goto L12
        L20:
            com.facebook.ads.redexgen.X.FS r1 = (com.facebook.ads.redexgen.X.FS) r1
            r1.requestLayout()
            r0 = 4
            goto L12
        L27:
            r0 = 4
            goto L12
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.onVideoSizeChanged(android.media.MediaPlayer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x009b, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onWindowFocusChanged(boolean r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            super.onWindowFocusChanged(r5)
            android.media.MediaPlayer r0 = r3.A06
            if (r0 != 0) goto L98
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L9b;
                case 3: goto L35;
                case 4: goto L27;
                case 5: goto L19;
                case 6: goto Le;
                case 7: goto L3f;
                case 8: goto L4b;
                case 9: goto L50;
                case 10: goto L65;
                case 11: goto L72;
                case 12: goto L20;
                case 13: goto L79;
                case 14: goto L89;
                case 15: goto L5c;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            boolean r0 = r3.A0J
            if (r0 != 0) goto L16
            r0 = 7
            goto La
        L16:
            r0 = 10
            goto La
        L19:
            if (r5 != 0) goto L1d
            r0 = 6
            goto La
        L1d:
            r0 = 13
            goto La
        L20:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r2 = r3.A0C
            r0 = 9
            goto La
        L27:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            android.widget.MediaController r0 = r3.A0A
            boolean r0 = r0.isShowing()
            if (r0 != 0) goto L33
            r0 = 5
            goto La
        L33:
            r0 = 2
            goto La
        L35:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            android.widget.MediaController r0 = r3.A0A
            if (r0 == 0) goto L3d
            r0 = 4
            goto La
        L3d:
            r0 = 5
            goto La
        L3f:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            boolean r0 = r3.A0I
            if (r0 == 0) goto L48
            r0 = 8
            goto La
        L48:
            r0 = 12
            goto La
        L4b:
            com.facebook.ads.redexgen.X.FR r2 = com.facebook.ads.redexgen.X.FR.A0A
            r0 = 9
            goto La
        L50:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r2 = (com.facebook.ads.redexgen.X.FR) r2
            r3.A0D = r2
            r0 = 1
            r3.A0J = r0
            r0 = 10
            goto La
        L5c:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.QH r0 = r3.A0B
            r3.A8Q(r0)
            r0 = 2
            goto La
        L65:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r1 = r3.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            if (r1 == r0) goto L70
            r0 = 11
            goto La
        L70:
            r0 = 2
            goto La
        L72:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            r3.A53()
            r0 = 2
            goto La
        L79:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            r0 = 0
            r3.A0J = r0
            com.facebook.ads.redexgen.X.FR r1 = r3.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            if (r1 != r0) goto L87
            r0 = 14
            goto La
        L87:
            r0 = 2
            goto La
        L89:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r1 = r3.A0D
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            if (r1 == r0) goto L95
            r0 = 15
            goto La
        L95:
            r0 = 2
            goto La
        L98:
            r0 = 3
            goto La
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.onWindowFocusChanged(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0051, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.FT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void pause(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            r2.A0E = r0
            android.media.MediaPlayer r0 = r2.A06
            if (r0 == 0) goto L4e
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L39;
                case 3: goto L51;
                case 4: goto L2a;
                case 5: goto L1f;
                case 6: goto Le;
                case 7: goto L45;
                case 8: goto L30;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            android.media.MediaPlayer r0 = r2.A06
            r0.pause()
            com.facebook.ads.redexgen.X.FR r1 = r2.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A06
            if (r1 == r0) goto L1d
            r0 = 7
            goto La
        L1d:
            r0 = 3
            goto La
        L1f:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            r2.A0D = r0
            r0 = 1
            r2.A0J = r0
            r0 = 6
            goto La
        L2a:
            if (r4 == 0) goto L2e
            r0 = 5
            goto La
        L2e:
            r0 = 6
            goto La
        L30:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A04
            r2.setVideoState(r0)
            r0 = 3
            goto La
        L39:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            boolean r0 = r2.A04()
            if (r0 != 0) goto L43
            r0 = 3
            goto La
        L43:
            r0 = 4
            goto La
        L45:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            r2.setVideoState(r0)
            r0 = 3
            goto La
        L4e:
            r0 = 8
            goto La
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.pause(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0041, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.FT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void seekTo(int r3) {
        /*
            r2 = this;
            r1 = r2
            android.media.MediaPlayer r0 = r1.A06
            if (r0 == 0) goto L3f
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L2d;
                case 4: goto L27;
                case 5: goto L16;
                case 6: goto L41;
                case 7: goto L39;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.FS r1 = (com.facebook.ads.redexgen.X.FS) r1
            boolean r0 = r1.A05()
            if (r0 == 0) goto L14
            r0 = 3
            goto L6
        L14:
            r0 = 7
            goto L6
        L16:
            com.facebook.ads.redexgen.X.FS r1 = (com.facebook.ads.redexgen.X.FS) r1
            int r0 = r1.getCurrentPosition()
            r1.A02 = r0
            r1.A03 = r3
            android.media.MediaPlayer r0 = r1.A06
            r0.seekTo(r3)
            r0 = 6
            goto L6
        L27:
            if (r3 <= 0) goto L2b
            r0 = 5
            goto L6
        L2b:
            r0 = 6
            goto L6
        L2d:
            com.facebook.ads.redexgen.X.FS r1 = (com.facebook.ads.redexgen.X.FS) r1
            int r0 = r1.getDuration()
            if (r3 >= r0) goto L37
            r0 = 4
            goto L6
        L37:
            r0 = 6
            goto L6
        L39:
            com.facebook.ads.redexgen.X.FS r1 = (com.facebook.ads.redexgen.X.FS) r1
            r1.A03 = r3
            r0 = 6
            goto L6
        L3f:
            r0 = 7
            goto L6
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.seekTo(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:            return;     */
    @Override // android.view.TextureView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setBackgroundDrawable(android.graphics.drawable.Drawable r6) {
        /*
            r5 = this;
            r4 = r5
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 24
            if (r1 >= r0) goto L30
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L32;
                case 4: goto L15;
                case 5: goto L1f;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.FS r4 = (com.facebook.ads.redexgen.X.FS) r4
            android.graphics.drawable.Drawable r6 = (android.graphics.drawable.Drawable) r6
            super.setBackgroundDrawable(r6)
            r0 = 3
            goto L8
        L15:
            boolean r0 = com.facebook.ads.internal.settings.AdInternalSettings.isDebugBuild()
            if (r0 == 0) goto L1d
            r0 = 5
            goto L8
        L1d:
            r0 = 3
            goto L8
        L1f:
            java.lang.String r3 = com.facebook.ads.redexgen.X.FS.A0P
            r2 = 108(0x6c, float:1.51E-43)
            r1 = 102(0x66, float:1.43E-43)
            r0 = 11
            java.lang.String r0 = A02(r2, r1, r0)
            android.util.Log.w(r3, r0)
            r0 = 3
            goto L8
        L30:
            r0 = 4
            goto L8
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.setBackgroundDrawable(android.graphics.drawable.Drawable):void");
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public void setBackgroundPlaybackEnabled(boolean z) {
        this.A0G = z;
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public void setControlsAnchorView(View view) {
        this.A09 = view;
        view.setOnTouchListener(new FU(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:            return;     */
    @Override // android.view.TextureView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setForeground(android.graphics.drawable.Drawable r6) {
        /*
            r5 = this;
            r4 = r5
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 24
            if (r1 >= r0) goto L2f
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L31;
                case 4: goto L15;
                case 5: goto L1f;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.FS r4 = (com.facebook.ads.redexgen.X.FS) r4
            android.graphics.drawable.Drawable r6 = (android.graphics.drawable.Drawable) r6
            super.setForeground(r6)
            r0 = 3
            goto L8
        L15:
            boolean r0 = com.facebook.ads.internal.settings.AdInternalSettings.isDebugBuild()
            if (r0 == 0) goto L1d
            r0 = 5
            goto L8
        L1d:
            r0 = 3
            goto L8
        L1f:
            java.lang.String r3 = com.facebook.ads.redexgen.X.FS.A0P
            r2 = 0
            r1 = 94
            r0 = 9
            java.lang.String r0 = A02(r2, r1, r0)
            android.util.Log.w(r3, r0)
            r0 = 3
            goto L8
        L2f:
            r0 = 4
            goto L8
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.setForeground(android.graphics.drawable.Drawable):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.FT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setFullScreen(boolean r3) {
        /*
            r2 = this;
            r1 = r2
            r1.A0I = r3
            boolean r0 = r1.A0I
            if (r0 == 0) goto L22
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L16;
                case 4: goto L24;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.FS r1 = (com.facebook.ads.redexgen.X.FS) r1
            boolean r0 = r1.A0H
            if (r0 != 0) goto L14
            r0 = 3
            goto L8
        L14:
            r0 = 4
            goto L8
        L16:
            com.facebook.ads.redexgen.X.FS r1 = (com.facebook.ads.redexgen.X.FS) r1
            com.facebook.ads.redexgen.X.FV r0 = new com.facebook.ads.redexgen.X.FV
            r0.<init>(r1)
            r1.setOnTouchListener(r0)
            r0 = 4
            goto L8
        L22:
            r0 = 4
            goto L8
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.setFullScreen(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002f, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.FT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setRequestedVolume(float r4) {
        /*
            r3 = this;
            r2 = r3
            r2.A00 = r4
            android.media.MediaPlayer r0 = r2.A06
            if (r0 == 0) goto L2d
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L18;
                case 4: goto L24;
                case 5: goto L2f;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            com.facebook.ads.redexgen.X.FR r1 = r2.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A08
            if (r1 == r0) goto L16
            r0 = 3
            goto L8
        L16:
            r0 = 5
            goto L8
        L18:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            com.facebook.ads.redexgen.X.FR r1 = r2.A0C
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A04
            if (r1 == r0) goto L22
            r0 = 4
            goto L8
        L22:
            r0 = 5
            goto L8
        L24:
            com.facebook.ads.redexgen.X.FS r2 = (com.facebook.ads.redexgen.X.FS) r2
            android.media.MediaPlayer r0 = r2.A06
            r0.setVolume(r4, r4)
            r0 = 5
            goto L8
        L2d:
            r0 = 5
            goto L8
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.setRequestedVolume(float):void");
    }

    public void setVideoMPD(@Nullable String str) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setVideoState(com.facebook.ads.redexgen.X.FR r6) {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.FR r0 = r4.A0C
            if (r6 == r0) goto L4b
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L14;
                case 4: goto L32;
                case 5: goto L40;
                case 6: goto L4d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L12
            r0 = 3
            goto L6
        L12:
            r0 = 4
            goto L6
        L14:
            com.facebook.ads.redexgen.X.FR r6 = (com.facebook.ads.redexgen.X.FR) r6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 210(0xd2, float:2.94E-43)
            r1 = 23
            r0 = 112(0x70, float:1.57E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r6)
            r0.toString()
            r0 = 4
            goto L6
        L32:
            com.facebook.ads.redexgen.X.FS r4 = (com.facebook.ads.redexgen.X.FS) r4
            com.facebook.ads.redexgen.X.FR r6 = (com.facebook.ads.redexgen.X.FR) r6
            r4.A0C = r6
            com.facebook.ads.redexgen.X.LY r0 = r4.A0F
            if (r0 == 0) goto L3e
            r0 = 5
            goto L6
        L3e:
            r0 = 6
            goto L6
        L40:
            com.facebook.ads.redexgen.X.FS r4 = (com.facebook.ads.redexgen.X.FS) r4
            com.facebook.ads.redexgen.X.FR r6 = (com.facebook.ads.redexgen.X.FR) r6
            com.facebook.ads.redexgen.X.LY r0 = r4.A0F
            r0.A7d(r6)
            r0 = 6
            goto L6
        L4b:
            r0 = 6
            goto L6
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.setVideoState(com.facebook.ads.redexgen.X.FR):void");
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public void setVideoStateChangeListener(LY ly) {
        this.A0F = ly;
    }

    @Override // com.facebook.ads.redexgen.X.FT
    public void setup(Uri uri) {
        MediaPlayer mediaPlayer;
        this.A0K = false;
        this.A07 = uri;
        if (this.A06 != null) {
            A07();
            A08(null);
            mediaPlayer = this.A06;
            setVideoState(FR.A04);
        } else {
            mediaPlayer = new MediaPlayer();
        }
        try {
            if (uri.getScheme().equals(A02(315, 5, 83))) {
                AssetFileDescriptor assetFileDescriptor = null;
                try {
                    try {
                        assetFileDescriptor = getContext().getAssets().openFd(uri.getPath().substring(1));
                        mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    } catch (IOException | SecurityException e) {
                        Log.w(A0P, A02(371, 22, 90) + e);
                        setVideoState(FR.A03);
                        if (assetFileDescriptor != null) {
                            try {
                                assetFileDescriptor.close();
                            } catch (IOException e2) {
                                Log.w(A0P, A02(393, 15, 12) + e2);
                            }
                        }
                    }
                } finally {
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e3) {
                            Log.w(A0P, A02(393, 15, 12) + e3);
                        }
                    }
                }
            } else {
                mediaPlayer.setDataSource(uri.toString());
            }
            mediaPlayer.setLooping(false);
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setOnInfoListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnVideoSizeChangedListener(this);
            mediaPlayer.setOnSeekCompleteListener(this);
            mediaPlayer.prepareAsync();
            this.A06 = mediaPlayer;
            setVideoState(FR.A08);
        } catch (Exception e4) {
            setVideoState(FR.A03);
            mediaPlayer.release();
            Log.e(A0P, A02(266, 49, 126) + e4);
        }
        setSurfaceTextureListener(this);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004e, code lost:            r3.setVideoState(com.facebook.ads.redexgen.X.FR.A04);     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0055, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.FT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void stop() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A04
            r3.A0E = r0
            android.media.MediaPlayer r0 = r3.A06
            if (r0 == 0) goto L4c
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1d;
                case 4: goto L23;
                case 5: goto L3d;
                case 6: goto L4e;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            android.media.MediaPlayer r0 = r3.A06
            int r2 = r0.getCurrentPosition()
            if (r2 <= 0) goto L1b
            r0 = 3
            goto Lb
        L1b:
            r0 = 4
            goto Lb
        L1d:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            r3.A03 = r2
            r0 = 4
            goto Lb
        L23:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            android.media.MediaPlayer r0 = r3.A06
            r0.stop()
            r3.A07()
            android.media.MediaPlayer r0 = r3.A06
            r0.release()
            r0 = 0
            r3.A06 = r0
            android.widget.MediaController r0 = r3.A0A
            if (r0 == 0) goto L3b
            r0 = 5
            goto Lb
        L3b:
            r0 = 6
            goto Lb
        L3d:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            android.widget.MediaController r0 = r3.A0A
            r0.hide()
            android.widget.MediaController r1 = r3.A0A
            r0 = 0
            r1.setEnabled(r0)
            r0 = 6
            goto Lb
        L4c:
            r0 = 6
            goto Lb
        L4e:
            com.facebook.ads.redexgen.X.FS r3 = (com.facebook.ads.redexgen.X.FS) r3
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A04
            r3.setVideoState(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FS.stop():void");
    }
}

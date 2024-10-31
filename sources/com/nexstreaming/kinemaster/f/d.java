package com.nexstreaming.kinemaster.f;

import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.kmpackage.ThemeEffectType;
import com.nexstreaming.kinemaster.kmpackage.TransitionEffectAutoSelectContext;
import com.nexstreaming.kinemaster.kmpackage.at;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: ThemeApplicatorFactory.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private static c f3384a = new e();

    public static c a(Theme theme) {
        return theme == null ? f3384a : new a(theme, null);
    }

    /* compiled from: ThemeApplicatorFactory.java */
    /* loaded from: classes.dex */
    public static class a extends com.nexstreaming.kinemaster.f.a {

        /* renamed from: a */
        private final Theme f3386a;
        private int[] b;
        private int c;
        private int d;
        private int e;
        private int f;

        /* synthetic */ a(Theme theme, e eVar) {
            this(theme);
        }

        private a(Theme theme) {
            this.b = new int[3];
            this.c = 0;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.f3386a = theme;
            if (theme.a(ThemeEffectType.OPENING) != null) {
                this.d = this.c;
                int[] iArr = this.b;
                int i = this.c;
                this.c = i + 1;
                iArr[i] = R.string.template_openingtitle_hint;
            }
            if (theme.a(ThemeEffectType.ENDING) != null) {
                this.f = this.c;
                int[] iArr2 = this.b;
                int i2 = this.c;
                this.c = i2 + 1;
                iArr2[i2] = R.string.template_closingtitle_hint;
            }
            if (theme.a(ThemeEffectType.MIDDLE) != null) {
                this.e = this.c;
                int[] iArr3 = this.b;
                int i3 = this.c;
                this.c = i3 + 1;
                iArr3[i3] = R.string.template_midtitle_hint;
            }
        }

        @Override // com.nexstreaming.kinemaster.f.a
        protected boolean a(b bVar, NexTransitionItem nexTransitionItem, NexVideoClipItem nexVideoClipItem, NexVideoClipItem nexVideoClipItem2, int i, int i2) {
            NexTimeline b = bVar.b();
            EffectLibrary a2 = bVar.a();
            int duration = nexTransitionItem.getDuration();
            TransitionEffectAutoSelectContext transitionEffectAutoSelectContext = new TransitionEffectAutoSelectContext();
            transitionEffectAutoSelectContext.effectDuration = nexTransitionItem.getDuration() / 1000.0d;
            transitionEffectAutoSelectContext.endTime = nexTransitionItem.getAbsEndTime() / 1000.0d;
            transitionEffectAutoSelectContext.index = i;
            transitionEffectAutoSelectContext.leftClipDuration = nexVideoClipItem.getDuration() / 1000.0d;
            transitionEffectAutoSelectContext.leftClipHasText = nexVideoClipItem.hasText();
            transitionEffectAutoSelectContext.leftClipIndex = transitionEffectAutoSelectContext.index;
            if (nexVideoClipItem.isImage()) {
                transitionEffectAutoSelectContext.getClass();
                transitionEffectAutoSelectContext.leftClipType = 2;
            } else if (nexVideoClipItem.isPreset()) {
                transitionEffectAutoSelectContext.getClass();
                transitionEffectAutoSelectContext.leftClipType = 3;
            } else {
                transitionEffectAutoSelectContext.getClass();
                transitionEffectAutoSelectContext.leftClipType = 1;
            }
            transitionEffectAutoSelectContext.numberOfClips = (i2 + 1) / 2;
            transitionEffectAutoSelectContext.lastClip = transitionEffectAutoSelectContext.numberOfClips;
            transitionEffectAutoSelectContext.projectDuration = b.getTotalTime();
            transitionEffectAutoSelectContext.rightClipDuration = nexVideoClipItem2.getDuration() / 1000.0d;
            transitionEffectAutoSelectContext.rightClipHasText = nexVideoClipItem2.hasText();
            transitionEffectAutoSelectContext.rightClipIndex = transitionEffectAutoSelectContext.index;
            if (nexVideoClipItem2.isImage()) {
                transitionEffectAutoSelectContext.getClass();
                transitionEffectAutoSelectContext.rightClipType = 2;
            } else if (nexVideoClipItem2.isPreset()) {
                transitionEffectAutoSelectContext.getClass();
                transitionEffectAutoSelectContext.rightClipType = 3;
            } else {
                transitionEffectAutoSelectContext.getClass();
                transitionEffectAutoSelectContext.rightClipType = 1;
            }
            transitionEffectAutoSelectContext.startTime = nexTransitionItem.getAbsStartTime() / 1000.0d;
            transitionEffectAutoSelectContext.versionCode = b.getAppVersionCode();
            NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
            transitionEffectAutoSelectContext.multisample = deviceProfile.getGLMultisample();
            transitionEffectAutoSelectContext.depthBits = deviceProfile.getGLDepthBufferBits();
            String a3 = this.f3386a.a(transitionEffectAutoSelectContext);
            if (a3 == null) {
                a3 = this.f3386a.a(ThemeEffectType.TRANSITION);
            }
            if (a3 != null) {
                if (a3.equals("com.nexstreaming.kinemaster.basic.transition")) {
                    a3 = "com.nexstreaming.kinemaster.builtin.transition.crossfade";
                }
                at b2 = a2.b(a3);
                if (b2 != null) {
                    int m = b2.m();
                    int min = Math.min(nexTransitionItem.getMaximumDuration(), b2.n());
                    if (min >= m && min >= 500) {
                        nexTransitionItem.setTransitionEffectID(a3);
                        boolean z = false;
                        if (nexVideoClipItem != null && nexVideoClipItem2 != null && min > duration && (nexVideoClipItem2.getAbsEndTime() - nexVideoClipItem2.getAbsStartTime()) - min <= min) {
                            z = true;
                        }
                        nexTransitionItem.setDuration(min);
                        if (z) {
                            b.requestCalcTimes();
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00d2  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0136  */
        @Override // com.nexstreaming.kinemaster.f.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected boolean a(com.nexstreaming.kinemaster.f.b r18, com.nextreaming.nexeditorui.NexVideoClipItem r19, int r20, int r21) {
            /*
                Method dump skipped, instructions count: 504
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.f.d.a.a(com.nexstreaming.kinemaster.f.b, com.nextreaming.nexeditorui.NexVideoClipItem, int, int):boolean");
        }

        @Override // com.nexstreaming.kinemaster.f.a
        protected boolean a(b bVar, NexAudioClipItem nexAudioClipItem) {
            return false;
        }

        @Override // com.nexstreaming.kinemaster.f.a
        protected boolean a(b bVar, NexLayerItem nexLayerItem) {
            return false;
        }

        @Override // com.nexstreaming.kinemaster.f.a
        protected boolean a(b bVar, NexTimeline nexTimeline) {
            return false;
        }

        @Override // com.nexstreaming.kinemaster.f.c
        public int a() {
            return this.c;
        }
    }
}

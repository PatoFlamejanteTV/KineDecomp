package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzbdk extends FrameLayout implements zzbdh {
    private final zzbdz zzerc;
    private final FrameLayout zzerd;
    private final zzaba zzere;
    private final Ue zzerf;
    private final long zzerg;
    private zzbdi zzerh;
    private boolean zzeri;
    private boolean zzerj;
    private boolean zzerk;
    private boolean zzerl;
    private long zzerm;
    private long zzern;
    private String zzero;
    private Bitmap zzerp;
    private ImageView zzerq;
    private boolean zzerr;

    public zzbdk(Context context, zzbdz zzbdzVar, int i, boolean z, zzaba zzabaVar, zzbdy zzbdyVar) {
        super(context);
        this.zzerc = zzbdzVar;
        this.zzere = zzabaVar;
        this.zzerd = new FrameLayout(context);
        addView(this.zzerd, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.a(zzbdzVar.zzid());
        this.zzerh = zzbdzVar.zzid().f10265b.zza(context, zzbdzVar, i, z, zzabaVar, zzbdyVar);
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar != null) {
            this.zzerd.addView(zzbdiVar, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcpc)).booleanValue()) {
                zzabl();
            }
        }
        this.zzerq = new ImageView(context);
        this.zzerg = ((Long) zzwu.zzpz().zzd(zzaan.zzcpg)).longValue();
        this.zzerl = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcpe)).booleanValue();
        zzaba zzabaVar2 = this.zzere;
        if (zzabaVar2 != null) {
            zzabaVar2.zzg("spinner_used", this.zzerl ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        this.zzerf = new Ue(this);
        zzbdi zzbdiVar2 = this.zzerh;
        if (zzbdiVar2 != null) {
            zzbdiVar2.zza(this);
        }
        if (this.zzerh == null) {
            zzi("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void zza(zzbdz zzbdzVar, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbdzVar.zza("onVideoEvent", hashMap);
    }

    private final boolean zzabn() {
        return this.zzerq.getParent() != null;
    }

    private final void zzabo() {
        if (this.zzerc.zzabw() == null || !this.zzerj || this.zzerk) {
            return;
        }
        this.zzerc.zzabw().getWindow().clearFlags(128);
        this.zzerj = false;
    }

    public static void zzb(zzbdz zzbdzVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
        zzbdzVar.zza("onVideoEvent", hashMap);
    }

    public final void destroy() {
        this.zzerf.b();
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar != null) {
            zzbdiVar.stop();
        }
        zzabo();
    }

    public final void finalize() throws Throwable {
        try {
            this.zzerf.b();
            if (this.zzerh != null) {
                zzbdi zzbdiVar = this.zzerh;
                Executor executor = zzbcg.zzepo;
                zzbdiVar.getClass();
                executor.execute(Le.a(zzbdiVar));
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdh
    public final void onPaused() {
        zzb("pause", new String[0]);
        zzabo();
        this.zzeri = false;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzerf.c();
        } else {
            this.zzerf.b();
            this.zzern = this.zzerm;
        }
        zzayh.zzelc.post(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.Me

            /* renamed from: a, reason: collision with root package name */
            private final zzbdk f11683a;

            /* renamed from: b, reason: collision with root package name */
            private final boolean f11684b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11683a = this;
                this.f11684b = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11683a.zzas(this.f11684b);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbdh
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzerf.c();
            z = true;
        } else {
            this.zzerf.b();
            this.zzern = this.zzerm;
            z = false;
        }
        zzayh.zzelc.post(new Pe(this, z));
    }

    public final void pause() {
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar == null) {
            return;
        }
        zzbdiVar.pause();
    }

    public final void play() {
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar == null) {
            return;
        }
        zzbdiVar.play();
    }

    public final void seekTo(int i) {
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar == null) {
            return;
        }
        zzbdiVar.seekTo(i);
    }

    public final void setVolume(float f2) {
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar == null) {
            return;
        }
        zzbdiVar.zzerb.setVolume(f2);
        zzbdiVar.zzabd();
    }

    @Override // com.google.android.gms.internal.ads.zzbdh
    public final void zzabe() {
        this.zzerf.c();
        zzayh.zzelc.post(new Ne(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbdh
    public final void zzabf() {
        if (this.zzerc.zzabw() != null && !this.zzerj) {
            this.zzerk = (this.zzerc.zzabw().getWindow().getAttributes().flags & 128) != 0;
            if (!this.zzerk) {
                this.zzerc.zzabw().getWindow().addFlags(128);
                this.zzerj = true;
            }
        }
        this.zzeri = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbdh
    public final void zzabg() {
        zzb("ended", new String[0]);
        zzabo();
    }

    @Override // com.google.android.gms.internal.ads.zzbdh
    public final void zzabh() {
        if (this.zzerr && this.zzerp != null && !zzabn()) {
            this.zzerq.setImageBitmap(this.zzerp);
            this.zzerq.invalidate();
            this.zzerd.addView(this.zzerq, new FrameLayout.LayoutParams(-1, -1));
            this.zzerd.bringChildToFront(this.zzerq);
        }
        this.zzerf.b();
        this.zzern = this.zzerm;
        zzayh.zzelc.post(new Oe(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbdh
    public final void zzabi() {
        if (this.zzeri && zzabn()) {
            this.zzerd.removeView(this.zzerq);
        }
        if (this.zzerp != null) {
            long c2 = com.google.android.gms.ads.internal.zzbv.l().c();
            if (this.zzerh.getBitmap(this.zzerp) != null) {
                this.zzerr = true;
            }
            long c3 = com.google.android.gms.ads.internal.zzbv.l().c() - c2;
            if (zzaxz.zzza()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(c3);
                sb.append("ms");
                zzaxz.v(sb.toString());
            }
            if (c3 > this.zzerg) {
                zzbbd.zzeo("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzerl = false;
                this.zzerp = null;
                zzaba zzabaVar = this.zzere;
                if (zzabaVar != null) {
                    zzabaVar.zzg("spinner_jank", Long.toString(c3));
                }
            }
        }
    }

    public final void zzabj() {
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar == null) {
            return;
        }
        zzbdiVar.zzerb.setMuted(true);
        zzbdiVar.zzabd();
    }

    public final void zzabk() {
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar == null) {
            return;
        }
        zzbdiVar.zzerb.setMuted(false);
        zzbdiVar.zzabd();
    }

    @TargetApi(14)
    public final void zzabl() {
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar == null) {
            return;
        }
        TextView textView = new TextView(zzbdiVar.getContext());
        String valueOf = String.valueOf(this.zzerh.zzaaz());
        textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        this.zzerd.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzerd.bringChildToFront(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzabm() {
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar == null) {
            return;
        }
        long currentPosition = zzbdiVar.getCurrentPosition();
        if (this.zzerm == currentPosition || currentPosition <= 0) {
            return;
        }
        zzb("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
        this.zzerm = currentPosition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzas(boolean z) {
        zzb("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    @Override // com.google.android.gms.internal.ads.zzbdh
    public final void zzcg() {
        if (this.zzerh != null && this.zzern == 0) {
            zzb("canplaythrough", "duration", String.valueOf(r0.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.zzerh.getVideoWidth()), "videoHeight", String.valueOf(this.zzerh.getVideoHeight()));
        }
    }

    public final void zzcz(int i) {
        this.zzerh.zzcz(i);
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.zzerd.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzda(int i) {
        this.zzerh.zzda(i);
    }

    public final void zzdb(int i) {
        this.zzerh.zzdb(i);
    }

    public final void zzdc(int i) {
        this.zzerh.zzdc(i);
    }

    public final void zzer(String str) {
        this.zzero = str;
    }

    @TargetApi(14)
    public final void zzf(MotionEvent motionEvent) {
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar == null) {
            return;
        }
        zzbdiVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzff() {
        if (this.zzerh == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.zzero)) {
            this.zzerh.setVideoPath(this.zzero);
        } else {
            zzb("no_src", new String[0]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdh
    public final void zzi(String str, String str2) {
        zzb("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbdh
    public final void zzm(int i, int i2) {
        if (this.zzerl) {
            int max = Math.max(i / ((Integer) zzwu.zzpz().zzd(zzaan.zzcpf)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzwu.zzpz().zzd(zzaan.zzcpf)).intValue(), 1);
            Bitmap bitmap = this.zzerp;
            if (bitmap != null && bitmap.getWidth() == max && this.zzerp.getHeight() == max2) {
                return;
            }
            this.zzerp = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
            this.zzerr = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzerc.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbdz zzbdzVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("error", str);
        zzbdzVar.zza("onVideoEvent", hashMap);
    }

    public final void zza(float f2, float f3) {
        zzbdi zzbdiVar = this.zzerh;
        if (zzbdiVar != null) {
            zzbdiVar.zza(f2, f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to check method usage
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.MethodNode.getTopParentClass()" because "m" is null
    	at jadx.core.codegen.ClassGen.lambda$skipMethod$4(ClassGen.java:360)
    	at java.base/java.util.stream.ReferencePipeline$2$1.accept(Unknown Source)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline.collect(Unknown Source)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:361)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:327)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
     */
    public static /* synthetic */ void zza(zzbdk zzbdkVar, String str, String[] strArr) {
        zzbdkVar.zzb(str, strArr);
    }
}

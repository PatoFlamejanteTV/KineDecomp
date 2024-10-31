package com.nexstreaming.kinemaster.ui.store.controller;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.crashlytics.android.Crashlytics;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetCategoryAlias;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.util.Locale;

/* compiled from: AssetDetailPreviewFragment.java */
/* loaded from: classes2.dex */
public class Ca extends Fragment implements MediaPlayer.OnPreparedListener, View.OnSystemUiVisibilityChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private long f23417a;

    /* renamed from: b, reason: collision with root package name */
    private int f23418b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f23419c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f23421e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f23422f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f23423g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f23424h;
    private VideoView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ProgressBar m;
    private SeekBar n;
    private View o;
    private View p;
    private a q;
    private TextView r;
    private TextView s;
    private View t;

    /* renamed from: d, reason: collision with root package name */
    private boolean f23420d = true;
    private Runnable u = new Runnable() { // from class: com.nexstreaming.kinemaster.ui.store.controller.s
        @Override // java.lang.Runnable
        public final void run() {
            Ca.this.z();
        }
    };
    private Runnable v = new RunnableC2292za(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AssetDetailPreviewFragment.java */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        final MediaPlayer f23425a;

        a(MediaPlayer mediaPlayer) {
            this.f23425a = mediaPlayer;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            try {
                return this.f23425a.isPlaying();
            } catch (Exception e2) {
                Log.e("AssetDetailPreview", e2.getMessage(), e2);
                return false;
            }
        }

        void b() {
            try {
                this.f23425a.pause();
            } catch (Exception e2) {
                Log.e("AssetDetailPreview", e2.getMessage(), e2);
            }
        }

        void c() {
            try {
                this.f23425a.start();
            } catch (Exception e2) {
                Log.e("AssetDetailPreview", e2.getMessage(), e2);
            }
        }
    }

    private void A() {
        if (this.f23422f || this.i == null) {
            return;
        }
        a aVar = this.q;
        if (aVar != null && aVar.a() && !this.f23419c) {
            this.i.setSystemUiVisibility(1028);
        } else {
            H();
            B();
        }
    }

    private void B() {
        VideoView videoView = this.i;
        if (videoView != null) {
            videoView.removeCallbacks(this.u);
            this.i.postDelayed(this.u, 2500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        a aVar = this.q;
        if (aVar == null) {
            return;
        }
        this.f23423g = aVar.a();
        this.q.b();
        this.f23424h = false;
        this.f23419c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.f23419c && this.f23424h && this.q != null) {
            this.i.seekTo(this.f23418b);
            if (this.f23423g) {
                this.q.c();
                B();
            }
        }
        this.f23419c = false;
    }

    private void E() {
        if (this.i == null) {
            return;
        }
        this.k.animate().alpha(0.0f);
        this.o.animate().alpha(0.0f);
        this.n.setEnabled(false);
        this.p.setEnabled(false);
        this.t.setVisibility(0);
        this.f23420d = false;
    }

    private void F() {
        if (this.i == null) {
            return;
        }
        this.k.animate().alpha(1.0f);
        this.o.animate().alpha(1.0f);
        this.n.setEnabled(true);
        this.p.setEnabled(true);
        this.k.setEnabled(true);
        this.t.setVisibility(8);
        this.f23420d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        a aVar = this.q;
        if (aVar != null) {
            if (aVar.a()) {
                this.q.b();
            } else {
                this.q.c();
                B();
            }
        }
    }

    private void H() {
        VideoView videoView;
        if (this.f23422f || (videoView = this.i) == null) {
            return;
        }
        videoView.setSystemUiVisibility(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m(int i) {
        return String.format(Locale.ENGLISH, "%02d:%02d:%02d", Integer.valueOf(i / 3600000), Integer.valueOf((i % 3600000) / 60000), Integer.valueOf((i % 60000) / 1000));
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(Ca.class.getName());
        this.f23422f = getArguments().getBoolean("isAudio");
        View inflate = layoutInflater.inflate(R.layout.fragment_asset_detail_preview, (ViewGroup) null);
        d(inflate);
        inflate.setOnClickListener(null);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VideoView videoView = this.i;
        if (videoView != null && videoView.isPlaying()) {
            this.i.stopPlayback();
        }
        VideoView videoView2 = this.i;
        if (videoView2 != null) {
            videoView2.removeCallbacks(this.v);
            this.i.removeCallbacks(this.u);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        VideoView videoView = this.i;
        if (videoView != null) {
            videoView.removeCallbacks(this.v);
            this.i.removeCallbacks(this.u);
        }
        super.onPause();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.m.setVisibility(8);
        this.l.setVisibility(4);
        this.q = new a(mediaPlayer);
        this.i.start();
        B();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (this.i != null) {
            this.v.run();
        }
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f23421e) {
            this.f23421e = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        a aVar = this.q;
        if (aVar != null && aVar.a()) {
            this.f23421e = true;
            this.q.b();
        } else {
            this.f23421e = false;
        }
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
        this.f23417a = System.nanoTime();
        if ((i & 4) != 0) {
            E();
        } else {
            F();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        String string = getArguments().getString("imageUrl");
        String string2 = getArguments().getString("videoUrl");
        String string3 = getArguments().getString("audioUrl");
        this.f23422f = getArguments().getBoolean("isAudio");
        String string4 = getArguments().getString("id");
        String string5 = getArguments().getString("index");
        String string6 = getArguments().getString("name");
        String string7 = getArguments().getString("category");
        int maxImportHeight = NexEditorDeviceProfile.getDeviceProfile().getMaxImportHeight(EditorGlobal.i().b(), true);
        String str2 = (!this.f23422f || TextUtils.isEmpty(string3)) ? string2 : string3;
        if (maxImportHeight >= 720 && !TextUtils.isEmpty(str2)) {
            this.i.setVisibility(0);
            this.k.setVisibility(0);
            this.i.setVideoURI(Uri.parse(str2));
            if (str2.equals(string3)) {
                f(string);
                this.j.setVisibility(0);
                str = "audio";
            } else {
                this.j.setVisibility(4);
                str = "video";
            }
            this.i.setOnSystemUiVisibilityChangeListener(this);
        } else {
            f(string);
            this.k.setVisibility(0);
            this.j.setVisibility(0);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
            this.o.setVisibility(8);
            str = MessengerShareContentUtility.MEDIA_IMAGE;
        }
        Crashlytics.log("[AssetDetailPreviewFragment] imageUrl: " + string + " videoUrl: " + string2 + " audioUrl: " + string3 + " assetId: " + string4 + " assetName: " + string6);
        com.nexstreaming.kinemaster.usage.analytics.j.a(string4, string5, string6, str, string7);
    }

    public /* synthetic */ void z() {
        if (isAdded()) {
            A();
        }
    }

    private void d(View view) {
        this.i = (VideoView) view.findViewById(R.id.video_fragment_asset_detail_preview);
        this.j = (ImageView) view.findViewById(R.id.iv_fragment_asset_detail_preview);
        this.l = (ImageView) view.findViewById(R.id.image_load_failed);
        this.n = (SeekBar) view.findViewById(R.id.videoSeekBar);
        this.p = view.findViewById(R.id.playPauseButton);
        this.o = view.findViewById(R.id.playerControls);
        this.r = (TextView) view.findViewById(R.id.elapsedTime);
        this.s = (TextView) view.findViewById(R.id.totalTime);
        this.t = view.findViewById(R.id.shutter_view);
        this.i.setOnPreparedListener(this);
        this.k = (ImageView) view.findViewById(R.id.iv_fragment_asset_detail_preview_close);
        this.m = (ProgressBar) view.findViewById(R.id.pb_fragment_asset_detail_preview);
        this.n.setOnSeekBarChangeListener(new Aa(this));
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Ca.this.a(view2);
            }
        });
        this.i.setOnTouchListener(new View.OnTouchListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.t
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return Ca.this.b(view2, motionEvent);
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Ca.this.b(view2);
            }
        });
        this.i.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.p
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                Ca.this.a(mediaPlayer);
            }
        });
        this.i.setOnKeyListener(new Ba(this));
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Ca.this.c(view2);
            }
        });
        H();
        this.v.run();
    }

    private void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.bumptech.glide.c.a(this).a(str).a(this.j);
            this.l.setVisibility(4);
        } else {
            this.l.setVisibility(0);
        }
    }

    public /* synthetic */ void c(View view) {
        if (isDetached() || isRemoving() || !isVisible()) {
            return;
        }
        try {
            getFragmentManager().popBackStackImmediate();
        } catch (Exception e2) {
            Log.e("AssetDetailPreview", e2.getMessage(), e2);
        }
    }

    public /* synthetic */ boolean b(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        if ((System.nanoTime() - this.f23417a) / 1000000 < 200) {
            return true;
        }
        if (this.f23420d) {
            A();
        } else {
            H();
            B();
        }
        return true;
    }

    public static Fragment a(InterfaceC1821j interfaceC1821j) {
        if (interfaceC1821j == null) {
            return null;
        }
        String p = interfaceC1821j.p();
        String u = interfaceC1821j.u();
        String d2 = interfaceC1821j.d();
        String categoryAliasName = interfaceC1821j.getCategoryAliasName();
        Bundle bundle = new Bundle();
        bundle.putString("imageUrl", p);
        bundle.putString("videoUrl", u);
        bundle.putString("audioUrl", d2);
        bundle.putString("category", categoryAliasName);
        if (categoryAliasName != null) {
            bundle.putBoolean("isAudio", categoryAliasName.equalsIgnoreCase(AssetCategoryAlias.Audio.name()));
        } else {
            bundle.putBoolean("isAudio", false);
        }
        bundle.putString("id", interfaceC1821j.getAssetId());
        bundle.putString("index", Integer.toString(interfaceC1821j.a()));
        String str = interfaceC1821j.j() != null ? interfaceC1821j.j().get("en") : null;
        if (str == null) {
            str = interfaceC1821j.f();
        }
        bundle.putString("name", str);
        Ca ca = new Ca();
        ca.setArguments(bundle);
        return ca;
    }

    public /* synthetic */ void b(View view) {
        if ((System.nanoTime() - this.f23417a) / 1000000 < 200) {
            return;
        }
        if (this.f23420d) {
            A();
        } else {
            H();
            B();
        }
    }

    public /* synthetic */ void a(View view) {
        G();
    }

    public /* synthetic */ void a(MediaPlayer mediaPlayer) {
        if (isDetached() || isRemoving() || !isVisible()) {
            return;
        }
        try {
            getFragmentManager().popBackStackImmediate();
        } catch (Exception e2) {
            Log.e("AssetDetailPreview", e2.getMessage(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        a aVar = this.q;
        if (aVar == null) {
            return;
        }
        if (j > 600) {
            this.f23423g = aVar.a();
        }
        this.q.b();
        this.f23424h = false;
        this.f23419c = true;
    }
}

package com.nexstreaming.kinemaster.camcorder;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class CamcorderActivity extends Activity implements TextureView.SurfaceTextureListener {
    private ListView D;
    private View E;
    private OrientationEventListener G;
    private CamcorderProfile[] L;
    private String M;
    private boolean N;
    private boolean O;

    /* renamed from: a, reason: collision with root package name */
    private Camera f3262a;
    private t b;
    private ImageButton c;
    private ImageButton d;
    private ImageButton e;
    private MediaRecorder f;
    private int i;
    private int j;
    private int k;
    private int l;
    private TextView m;
    private View n;
    private TextView o;
    private View p;
    private SurfaceTexture q;
    private long s;
    private File u;
    private View w;
    private boolean g = false;
    private Camera.CameraInfo h = new Camera.CameraInfo();
    private boolean r = false;
    private boolean t = false;
    private boolean v = false;
    private int x = 0;
    private int y = Integer.MAX_VALUE;
    private int z = 0;
    private int A = 0;
    private int B = Integer.MAX_VALUE;
    private int C = Integer.MAX_VALUE;
    private boolean F = false;
    private int H = -1;
    private int I = -1;
    private String J = "";
    private List<CamcorderProfile> K = null;
    private StringBuilder P = new StringBuilder();
    private Runnable Q = new h(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = Camera.getNumberOfCameras();
        if (this.l < 1) {
            Toast.makeText(this, R.string.no_cameras, 1).show();
            finish();
            return;
        }
        this.L = new CamcorderProfile[this.l];
        for (int i = 0; i < this.l; i++) {
            Camera.getCameraInfo(i, this.h);
            if (this.h.facing == 1 && this.i < 0) {
                this.i = i;
            } else if (this.h.facing == 0 && this.j < 0) {
                this.j = i;
            }
        }
        if (this.j >= 0) {
            this.k = this.j;
        } else if (this.i >= 0) {
            this.k = this.i;
        } else {
            this.k = 0;
        }
        int i2 = PreferenceManager.getDefaultSharedPreferences(this).getInt("CAMCORDER_SEL_CAMERA_INDEX", -1);
        if (i2 >= 0 && i2 < this.l) {
            this.k = i2;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.x = intent.getIntExtra("MIN_SIZE", 0);
            this.y = intent.getIntExtra("MAX_SIZE", Integer.MAX_VALUE);
            this.z = intent.getIntExtra("MIN_WIDTH", 0);
            this.A = intent.getIntExtra("MIN_HEIGHT", 0);
            this.B = intent.getIntExtra("MAX_WIDTH", Integer.MAX_VALUE);
            this.C = intent.getIntExtra("MAX_HEIGHT", Integer.MAX_VALUE);
            this.M = intent.getStringExtra("PROJECT_NAME");
            this.M = intent.getStringExtra("PROJECT_NAME");
            this.N = intent.getBooleanExtra("USE_AS_LAYER", false);
            this.O = intent.getBooleanExtra("IS_SUPPORT_LAYER", false);
        }
        setContentView(R.layout.camcorder_main_activity);
        this.p = findViewById(R.id.record_time_holder);
        this.o = (TextView) findViewById(R.id.record_time);
        this.m = (TextView) findViewById(R.id.cur_resolution);
        this.n = findViewById(R.id.cur_resolution_holder);
        this.D = (ListView) findViewById(R.id.res_list);
        int i3 = 0;
        while (true) {
            if (i3 >= this.l) {
                break;
            }
            this.f3262a = a((this.k + i3) % this.l);
            if (this.f3262a != null) {
                d();
                if (this.K.size() > 0) {
                    this.k = (i3 + this.k) % this.l;
                    break;
                }
                h();
            }
            i3++;
        }
        if (this.f3262a == null) {
            Toast.makeText(this, R.string.camera_in_use, 1).show();
            finish();
            return;
        }
        if (this.K.size() < 1) {
            Toast.makeText(this, R.string.camera_no_support_res, 1).show();
            finish();
            return;
        }
        this.b = new t(this);
        this.c = (ImageButton) findViewById(R.id.btn_rec);
        this.d = (ImageButton) findViewById(R.id.btn_switch);
        this.e = (ImageButton) findViewById(R.id.btn_flash);
        this.e.setVisibility(this.t ? 0 : 4);
        this.w = findViewById(R.id.rec_icon);
        this.E = findViewById(R.id.touch_blocker);
        this.c.setSoundEffectsEnabled(false);
        this.e.setSelected(this.r);
        this.e.setOnClickListener(new a(this));
        if (this.l > 1) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(4);
        }
        this.c.setOnClickListener(new b(this));
        this.d.setOnClickListener(new d(this));
        this.n.setClickable(true);
        this.n.setOnClickListener(new e(this));
        WindowManager windowManager = (WindowManager) getApplication().getSystemService("window");
        this.G = new g(this, this, windowManager);
        switch (windowManager.getDefaultDisplay().getRotation()) {
            case 0:
                this.G.onOrientationChanged(0);
                break;
            case 1:
                this.G.onOrientationChanged(270);
                break;
            case 2:
                this.G.onOrientationChanged(180);
                break;
            case 3:
                this.G.onOrientationChanged(90);
                break;
            default:
                this.G.onOrientationChanged(0);
                break;
        }
        this.G.enable();
        if (getWindow() != null) {
            getWindow().addFlags(128);
        }
        k();
    }

    @Override // android.app.Activity
    protected void onStart() {
        if (this.b != null) {
            this.b.setAspectRatio(b() / c());
            this.b.setSurfaceTextureListener(this);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.camera_preview_holder);
            frameLayout.removeAllViews();
            frameLayout.addView(this.b, new FrameLayout.LayoutParams(-2, -2, 17));
        }
        KMUsage.Activity_Camcording.begin("numcameras", "" + this.l);
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        KMUsage.Activity_Camcording.end();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.F) {
            this.D.setVisibility(4);
            this.E.setVisibility(4);
            this.F = false;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.F) {
            a();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        return this.L[this.k].videoFrameWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        return this.L[this.k].videoFrameHeight;
    }

    private boolean a(CamcorderProfile camcorderProfile) {
        if (camcorderProfile.videoFrameWidth * camcorderProfile.videoFrameHeight < this.x || camcorderProfile.videoFrameWidth * camcorderProfile.videoFrameHeight > this.y || camcorderProfile.videoFrameWidth < this.z || camcorderProfile.videoFrameWidth > this.B || camcorderProfile.videoFrameWidth < this.A || camcorderProfile.videoFrameWidth > this.C) {
            return false;
        }
        if (camcorderProfile.videoCodec == 2 || camcorderProfile.videoCodec == 3) {
            return camcorderProfile.audioCodec == 3 || camcorderProfile.audioCodec == 5 || camcorderProfile.audioCodec == 4;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        CamcorderProfile camcorderProfile;
        boolean z;
        int[] iArr = {6, 5, 4, 7, 3, 0, 1};
        this.K = new ArrayList();
        CamcorderProfile camcorderProfile2 = null;
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            int i2 = iArr[i];
            if (CamcorderProfile.hasProfile(this.k, i2)) {
                CamcorderProfile camcorderProfile3 = CamcorderProfile.get(this.k, i2);
                if (a(camcorderProfile3)) {
                    Iterator<CamcorderProfile> it = this.K.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        CamcorderProfile next = it.next();
                        if (next.videoFrameWidth == camcorderProfile3.videoFrameWidth && next.videoFrameHeight == camcorderProfile3.videoFrameHeight) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.K.add(camcorderProfile3);
                        if (camcorderProfile2 == null || camcorderProfile3.videoFrameWidth * camcorderProfile3.videoFrameHeight > camcorderProfile2.videoFrameWidth * camcorderProfile2.videoFrameHeight) {
                            camcorderProfile = camcorderProfile3;
                            i++;
                            camcorderProfile2 = camcorderProfile;
                        }
                    }
                }
            }
            camcorderProfile = camcorderProfile2;
            i++;
            camcorderProfile2 = camcorderProfile;
        }
        if (this.L[this.k] == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String str = "CAMCORDER_SEL_PROFILE_" + this.k;
            if (defaultSharedPreferences.contains(str)) {
                int i3 = defaultSharedPreferences.getInt(str, camcorderProfile2.quality);
                Iterator<CamcorderProfile> it2 = this.K.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CamcorderProfile next2 = it2.next();
                    if (next2.quality == i3) {
                        camcorderProfile2 = next2;
                        break;
                    }
                }
            }
            if (camcorderProfile2 != null) {
                this.L[this.k] = camcorderProfile2;
                defaultSharedPreferences.edit().putInt(str, camcorderProfile2.quality);
            }
        }
        if (this.L[this.k] != null) {
            this.m.setText(b() + " x " + c());
        }
        List<String> supportedFlashModes = this.f3262a.getParameters().getSupportedFlashModes();
        this.t = supportedFlashModes == null ? false : supportedFlashModes.contains("torch");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Camera a(int i) {
        try {
            return Camera.open(i);
        } catch (Exception e) {
            Log.e("KineCamcorder", "Camera is not available", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.g && this.f3262a != null) {
            Camera.Parameters parameters = this.f3262a.getParameters();
            if (this.t) {
                parameters.setFlashMode(this.r ? "torch" : "off");
            }
            this.f3262a.setParameters(parameters);
            if (!f()) {
                Camera.Parameters parameters2 = this.f3262a.getParameters();
                if (this.t) {
                    parameters2.setFlashMode("off");
                }
                this.f3262a.setParameters(parameters2);
                return;
            }
            try {
                this.f.start();
                this.g = true;
                this.c.setSelected(true);
                this.d.setVisibility(4);
                this.e.setVisibility(4);
                this.n.setVisibility(4);
                this.p.setVisibility(0);
                this.s = System.nanoTime();
                this.v = false;
                this.Q.run();
            } catch (IllegalStateException e) {
                a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.g) {
            CamcorderProfile camcorderProfile = this.L[this.k];
            try {
                this.f.stop();
            } catch (RuntimeException e) {
                Log.w("KineCamcorder", "Failed to stop media recorder", e);
                Toast.makeText(this, R.string.camera_fail_camcord, 1).show();
                if (z) {
                    KMAppUsage.a(this).a(KMAppUsage.KMMetric.CamcordingDone, GraphResponse.SUCCESS_KEY, "no", "duration", AppEventsConstants.EVENT_PARAM_VALUE_NO, "error", String.valueOf(e.getMessage()), "build_device", Build.DEVICE, "api_level", "" + Build.VERSION.SDK_INT, "num_cameras", "" + this.l, "selected_camera", "" + this.k, "profile_size", camcorderProfile.videoFrameWidth + "x" + camcorderProfile.videoFrameHeight, "profile_vbr", "" + camcorderProfile.videoBitRate, "profile_info", "fr=" + camcorderProfile.videoFrameRate + " c=" + camcorderProfile.videoCodec + " abr=" + camcorderProfile.audioBitRate + " ac=" + camcorderProfile.audioCodec + " ff=" + camcorderProfile.fileFormat);
                }
                this.u.delete();
                z = false;
            }
            if (z) {
                KMAppUsage.a(this).a(KMAppUsage.KMMetric.CamcordingDone, GraphResponse.SUCCESS_KEY, "yes", "duration", this.J, "error", "none", "build_device", Build.DEVICE, "api_level", "" + Build.VERSION.SDK_INT, "num_cameras", "" + this.l, "selected_camera", "" + this.k, "profile_size", camcorderProfile.videoFrameWidth + "x" + camcorderProfile.videoFrameHeight, "profile_vbr", "" + camcorderProfile.videoBitRate, "profile_info", "fr=" + camcorderProfile.videoFrameRate + " c=" + camcorderProfile.videoCodec + " abr=" + camcorderProfile.audioBitRate + " ac=" + camcorderProfile.audioCodec + " ff=" + camcorderProfile.fileFormat);
            }
            this.g = false;
            g();
        }
        this.c.setSelected(false);
        if (this.l > 1) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(4);
        }
        this.e.setVisibility(this.t ? 0 : 4);
        this.n.setVisibility(0);
        this.p.setVisibility(4);
        Camera.Parameters parameters = this.f3262a.getParameters();
        if (this.t) {
            parameters.setFlashMode("off");
        }
        this.f3262a.setParameters(parameters);
        if (z) {
            h();
            Intent intent = new Intent(this, (Class<?>) CamcorderPreviewActivity.class);
            intent.putExtra("VIDEO_PATH", this.u.getAbsolutePath());
            intent.putExtra("IS_SUPPORT_LAYER", this.O);
            intent.putExtra("USE_AS_LAYER", this.N);
            startActivityForResult(intent, 50);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        if (i == 50) {
            if (i2 == -1) {
                if (this.u == null && (stringExtra = intent.getStringExtra("VIDEO_PATH")) != null) {
                    this.u = new File(stringExtra);
                }
                boolean booleanExtra = intent != null ? intent.getBooleanExtra("USE_AS_LAYER", false) : false;
                Intent intent2 = new Intent();
                MediaScannerConnection.scanFile(this, new String[]{this.u.getAbsolutePath()}, null, null);
                intent2.putExtra("VIDEO_PATH", this.u.getAbsolutePath());
                intent2.putExtra("USE_AS_LAYER", booleanExtra);
                setResult(-1, intent2);
                h();
                finish();
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    private boolean f() {
        if (this.f3262a == null) {
            return false;
        }
        this.f = new MediaRecorder();
        this.f3262a.unlock();
        this.f.setCamera(this.f3262a);
        this.f.setAudioSource(EditorGlobal.b(this, 5));
        this.f.setVideoSource(1);
        this.f.setProfile(this.L[this.k]);
        this.f.setOrientationHint(c(this.H));
        this.u = b(2);
        this.f.setOutputFile(this.u.getAbsolutePath());
        try {
            this.f.prepare();
            return true;
        } catch (IOException e) {
            Log.d("KineCamcorder", "prepareVideoRecorder - IOException preparing MediaRecorder: " + e.getMessage());
            g();
            return false;
        } catch (IllegalStateException e2) {
            Log.d("KineCamcorder", "prepareVideoRecorder - IllegalStateException preparing MediaRecorder: " + e2.getMessage());
            g();
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.g) {
            this.c.setSelected(false);
            if (this.l > 1) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(4);
            }
            this.e.setVisibility(this.t ? 0 : 4);
            this.n.setVisibility(0);
            this.p.setVisibility(4);
        }
        g();
        h();
        if (this.G != null) {
            this.G.disable();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.G != null) {
            this.G.disable();
            this.G = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (this.f3262a == null) {
            this.f3262a = a(this.k);
            i();
        }
        if (this.G != null) {
            this.G.enable();
        }
        super.onResume();
    }

    private void g() {
        if (this.f != null) {
            if (this.g) {
                try {
                    this.f.stop();
                } catch (Exception e) {
                }
            }
            this.f.reset();
            this.f.release();
            this.f = null;
            this.f3262a.lock();
        }
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f3262a != null) {
            this.f3262a.release();
            this.f3262a = null;
        }
    }

    private File b(int i) {
        return i == 1 ? com.nexstreaming.kinemaster.h.c.b(this.M) : com.nexstreaming.kinemaster.h.c.d(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.q != null && this.f3262a != null) {
            try {
                this.f3262a.setPreviewTexture(this.q);
            } catch (IOException e) {
                Log.w("KineCamcorder", "failed to set preview texture", e);
            }
            this.c.setEnabled(false);
            this.c.postDelayed(new i(this), 1000L);
            this.f3262a.startPreview();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.q = surfaceTexture;
        j();
        i();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        h();
        this.q = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int[] iArr;
        int i;
        int i2;
        float f;
        if (this.f3262a != null) {
            int b = b();
            int c = c();
            float f2 = b / c;
            Camera.Parameters parameters = this.f3262a.getParameters();
            if (parameters.getSupportedPreviewSizes() == null || (Build.MANUFACTURER.equalsIgnoreCase("samsung") && getResources().getDisplayMetrics().density < 1.1f)) {
                parameters.setPreviewSize(b, c);
                Log.i("KineCamcorder", "SET previewSize SIZE = RECORD SIZE: " + b + " x " + c);
            } else {
                Camera.Size preferredPreviewSizeForVideo = parameters.getPreferredPreviewSizeForVideo();
                if (preferredPreviewSizeForVideo != null) {
                    Log.i("KineCamcorder", "preferred size: " + preferredPreviewSizeForVideo.width + " x " + preferredPreviewSizeForVideo.height);
                    int i3 = preferredPreviewSizeForVideo.height * preferredPreviewSizeForVideo.width;
                    if (!Build.MANUFACTURER.equalsIgnoreCase("samsung") || i3 >= (b * c) / 3) {
                        i = i3;
                    } else {
                        Log.i("KineCamcorder", "preferred size too small; overriding");
                        i = ((b * c) * 110) / 100;
                    }
                } else {
                    Log.i("KineCamcorder", "no preferred size: ");
                    i = ((b * c) * 110) / 100;
                }
                int i4 = Integer.MAX_VALUE;
                float f3 = 1000.0f;
                Camera.Size size = null;
                for (Camera.Size size2 : parameters.getSupportedPreviewSizes()) {
                    if (size2.width * size2.height > i) {
                        Log.i("KineCamcorder", "SIZE: " + size2.width + " x " + size2.height + " SKIP - TOO LARGE");
                    } else {
                        int max = Math.max(Math.abs(size2.height - c), Math.abs(size2.width - b));
                        float abs = Math.abs((size2.width / size2.height) - f2);
                        Log.i("KineCamcorder", "SIZE: " + size2.width + " x " + size2.height + " diff=" + max + " maxdiff=" + i4 + " ratioDiff=" + abs);
                        if (abs < 0.05d) {
                            abs = 0.0f;
                        }
                        if (abs < f3) {
                            f = abs;
                            i2 = max;
                        } else if (Math.abs(abs - f3) >= 0.01d || max >= i4) {
                            size2 = size;
                            i2 = i4;
                            f = f3;
                        } else {
                            f = abs;
                            i2 = max;
                        }
                        f3 = f;
                        i4 = i2;
                        size = size2;
                    }
                }
                if (size != null) {
                    parameters.setPreviewSize(size.width, size.height);
                    Log.i("KineCamcorder", "SET previewSize SIZE: " + size.width + " x " + size.height);
                } else {
                    Log.i("KineCamcorder", "SET previewSize SIZE: not found");
                }
            }
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            int[] iArr2 = null;
            Iterator<int[]> it = supportedPreviewFpsRange.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int[] next = it.next();
                if (next[0] >= 30000 && next[1] < 40000) {
                    iArr2 = next;
                    break;
                }
            }
            if (iArr2 == null) {
                Iterator<int[]> it2 = supportedPreviewFpsRange.iterator();
                while (it2.hasNext()) {
                    iArr = it2.next();
                    if (iArr[1] >= 30000 && iArr[1] < 40000) {
                        break;
                    }
                }
            }
            iArr = iArr2;
            if (iArr != null) {
                parameters.setPreviewFpsRange(iArr[0], iArr[1]);
            }
            this.f3262a.setParameters(parameters);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    private int c(int i) {
        int i2;
        if (this.f3262a == null) {
            return 0;
        }
        Camera.getCameraInfo(this.k, this.h);
        if (this.h.facing == 1) {
            if (i == 180 || i == 0) {
                return (this.h.orientation + i) % 360;
            }
            return ((this.h.orientation - i) + 360) % 360;
        }
        if (this.h.facing != 0) {
            return 0;
        }
        if (i == 180 || i == 0) {
            return ((this.h.orientation - i) + 360) % 360;
        }
        if (this.h.orientation == 0) {
            i2 = (this.h.orientation - i) % 360;
        } else {
            i2 = (this.h.orientation + i) % 360;
        }
        return (360 - i2) % 360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        int i;
        int i2 = 0;
        if (this.f3262a != null) {
            Camera.getCameraInfo(this.k, this.h);
            switch (getWindowManager().getDefaultDisplay().getRotation()) {
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = 180;
                    break;
                case 3:
                    i2 = 270;
                    break;
            }
            if (this.h.facing == 1) {
                i = (360 - ((i2 + this.h.orientation) % 360)) % 360;
            } else {
                i = ((this.h.orientation - i2) + 360) % 360;
            }
            this.f3262a.setDisplayOrientation(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        this.e.setRotation(i);
        this.c.setRotation(i);
        this.d.setRotation(i);
        if (i == 0 || i == 180) {
            this.m.setRotation(i);
            this.o.setRotation(i);
        }
    }
}

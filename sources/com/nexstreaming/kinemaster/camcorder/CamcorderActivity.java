package com.nexstreaming.kinemaster.camcorder;

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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActivityChooserView;
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
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class CamcorderActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {
    private ListView D;
    private View E;
    private OrientationEventListener G;
    private com.nexstreaming.app.kinemasterfree.a.g K;
    private CamcorderProfile[] N;
    private String O;
    private boolean P;
    private boolean Q;

    /* renamed from: a */
    private Camera f19969a;

    /* renamed from: b */
    private v f19970b;

    /* renamed from: c */
    private ImageButton f19971c;

    /* renamed from: d */
    private ImageButton f19972d;

    /* renamed from: e */
    private ImageButton f19973e;

    /* renamed from: f */
    private MediaRecorder f19974f;
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

    /* renamed from: g */
    private boolean f19975g = false;

    /* renamed from: h */
    private Camera.CameraInfo f19976h = new Camera.CameraInfo();
    private boolean r = false;
    private boolean t = false;
    private boolean v = false;
    private int x = 0;
    private int y = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int z = 0;
    private int A = 0;
    private int B = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int C = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private boolean F = false;
    private int H = -1;
    private int I = -1;
    private String J = "";
    private boolean L = false;
    private List<CamcorderProfile> M = null;
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private StringBuilder U = new StringBuilder();
    private Runnable V = new h(this);
    private Runnable W = new i(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 50) {
            this.S = false;
            if (i2 != -1) {
                if (i2 == 0) {
                    File file = this.u;
                    if (file != null) {
                        file.delete();
                        this.u = null;
                    }
                    if (this.q != null) {
                        v();
                        B();
                        return;
                    }
                    return;
                }
                return;
            }
            this.T = true;
            File file2 = this.u;
            if (file2 != null) {
                file2.delete();
                this.u = null;
            }
            String stringExtra = intent.getStringExtra("VIDEO_PATH");
            if (stringExtra != null) {
                this.u = new File(stringExtra);
            }
            boolean booleanExtra = intent != null ? intent.getBooleanExtra("USE_AS_LAYER", false) : false;
            Intent intent2 = new Intent();
            intent2.putExtra("USE_AS_LAYER", booleanExtra);
            MediaScannerConnection.scanFile(this, new String[]{this.u.getAbsolutePath()}, null, new j(this, intent2));
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.F) {
            s();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = Camera.getNumberOfCameras();
        int i = this.l;
        if (i < 1) {
            Toast.makeText(this, R.string.no_cameras, 1).show();
            finish();
            return;
        }
        this.N = new CamcorderProfile[i];
        for (int i2 = 0; i2 < this.l; i2++) {
            Camera.getCameraInfo(i2, this.f19976h);
            if (this.f19976h.facing == 1 && this.i < 0) {
                this.i = i2;
            } else if (this.f19976h.facing == 0 && this.j < 0) {
                this.j = i2;
            }
        }
        int i3 = this.j;
        if (i3 >= 0) {
            this.k = i3;
        } else {
            int i4 = this.i;
            if (i4 >= 0) {
                this.k = i4;
            } else {
                this.k = 0;
            }
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.L = defaultSharedPreferences.getBoolean("pref_vidrec_levelmeter", false);
        int i5 = defaultSharedPreferences.getInt("CAMCORDER_SEL_CAMERA_INDEX", -1);
        if (i5 >= 0 && i5 < this.l) {
            this.k = i5;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.x = intent.getIntExtra("MIN_SIZE", 0);
            this.y = intent.getIntExtra("MAX_SIZE", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.z = intent.getIntExtra("MIN_WIDTH", 0);
            this.A = intent.getIntExtra("MIN_HEIGHT", 0);
            this.B = intent.getIntExtra("MAX_WIDTH", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.C = intent.getIntExtra("MAX_HEIGHT", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.O = intent.getStringExtra("PROJECT_NAME");
            this.O = intent.getStringExtra("PROJECT_NAME");
            this.P = intent.getBooleanExtra("USE_AS_LAYER", false);
            this.Q = intent.getBooleanExtra("IS_SUPPORT_LAYER", false);
        }
        this.K = (com.nexstreaming.app.kinemasterfree.a.g) android.databinding.e.a(this, R.layout.camcorder_main_activity);
        this.K.a(0);
        this.K.b(0);
        if (this.L) {
            this.K.G.setVisibility(0);
        } else {
            this.K.G.setVisibility(8);
        }
        this.p = findViewById(R.id.record_time_holder);
        this.o = (TextView) findViewById(R.id.record_time);
        this.m = (TextView) findViewById(R.id.cur_resolution);
        this.n = findViewById(R.id.cur_resolution_holder);
        this.D = (ListView) findViewById(R.id.res_list);
        int i6 = 0;
        while (true) {
            int i7 = this.l;
            if (i6 >= i7) {
                break;
            }
            this.f19969a = c((this.k + i6) % i7);
            if (this.f19969a != null) {
                x();
                if (this.M.size() > 0) {
                    this.k = (this.k + i6) % this.l;
                    break;
                }
                y();
            }
            i6++;
        }
        if (this.f19969a == null) {
            Toast.makeText(this, R.string.camera_in_use, 1).show();
            finish();
            return;
        }
        if (this.M.size() < 1) {
            Toast.makeText(this, R.string.camera_no_support_res, 1).show();
            finish();
            return;
        }
        this.f19970b = new v(this);
        this.f19971c = (ImageButton) findViewById(R.id.btn_rec);
        this.f19972d = (ImageButton) findViewById(R.id.btn_switch);
        this.f19973e = (ImageButton) findViewById(R.id.btn_flash);
        this.f19973e.setVisibility(this.t ? 0 : 4);
        this.w = findViewById(R.id.rec_icon);
        this.E = findViewById(R.id.touch_blocker);
        this.f19971c.setSoundEffectsEnabled(false);
        this.f19973e.setSelected(this.r);
        this.f19973e.setOnClickListener(new a(this));
        if (this.l > 1) {
            this.f19972d.setVisibility(0);
        } else {
            this.f19972d.setVisibility(4);
        }
        this.f19971c.setOnClickListener(new c(this));
        this.f19972d.setOnClickListener(new d(this));
        this.n.setClickable(true);
        this.n.setOnClickListener(new f(this));
        WindowManager windowManager = (WindowManager) getApplication().getSystemService("window");
        this.G = new g(this, this, windowManager);
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation == 0) {
            this.G.onOrientationChanged(0);
        } else if (rotation == 1) {
            this.G.onOrientationChanged(270);
        } else if (rotation == 2) {
            this.G.onOrientationChanged(180);
        } else if (rotation != 3) {
            this.G.onOrientationChanged(0);
        } else {
            this.G.onOrientationChanged(90);
        }
        this.G.enable();
        if (getWindow() != null) {
            getWindow().addFlags(128);
        }
        A();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        OrientationEventListener orientationEventListener = this.G;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.G = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f19975g) {
            this.f19971c.setSelected(false);
            if (this.l > 1) {
                this.f19972d.setVisibility(0);
            } else {
                this.f19972d.setVisibility(4);
            }
            this.f19973e.setVisibility(this.t ? 0 : 4);
            this.n.setVisibility(0);
            this.p.setVisibility(4);
            this.R = true;
        }
        z();
        y();
        OrientationEventListener orientationEventListener = this.G;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (this.f19969a == null) {
            this.f19969a = c(this.k);
            B();
        }
        OrientationEventListener orientationEventListener = this.G;
        if (orientationEventListener != null) {
            orientationEventListener.enable();
        }
        if (this.R && this.u != null) {
            Intent intent = new Intent(this, (Class<?>) CamcorderPreviewActivity.class);
            intent.putExtra("VIDEO_PATH", this.u.getAbsolutePath());
            intent.putExtra("PROJECT_NAME", this.O);
            intent.putExtra("IS_SUPPORT_LAYER", this.Q);
            intent.putExtra("USE_AS_LAYER", this.P);
            this.S = true;
            startActivityForResult(intent, 50);
            this.R = false;
        }
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        v vVar = this.f19970b;
        if (vVar != null) {
            vVar.setAspectRatio(u() / t());
            this.f19970b.setSurfaceTextureListener(this);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.camera_preview_holder);
            frameLayout.removeAllViews();
            frameLayout.addView(this.f19970b, new FrameLayout.LayoutParams(-2, -2, 17));
        }
        super.onStart();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.q = surfaceTexture;
        if (this.S || this.T) {
            return;
        }
        v();
        B();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        y();
        this.q = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void A() {
        int i;
        if (this.f19969a == null) {
            return;
        }
        Camera.getCameraInfo(this.k, this.f19976h);
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f19976h;
        if (cameraInfo.facing == 1) {
            i = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        } else {
            i = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        this.f19969a.setDisplayOrientation(i);
    }

    public void B() {
        Camera camera;
        SurfaceTexture surfaceTexture = this.q;
        if (surfaceTexture == null || (camera = this.f19969a) == null) {
            return;
        }
        try {
            camera.setPreviewTexture(surfaceTexture);
        } catch (IOException e2) {
            Log.w("KineCamcorder", "failed to set preview texture", e2);
        }
        this.f19971c.setEnabled(false);
        this.f19971c.postDelayed(new k(this), 1000L);
        this.f19969a.startPreview();
    }

    public void C() {
        Camera camera;
        if (this.f19975g || (camera = this.f19969a) == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (this.t) {
            parameters.setFlashMode(this.r ? "torch" : "off");
        }
        this.f19969a.setParameters(parameters);
        if (!w()) {
            Camera.Parameters parameters2 = this.f19969a.getParameters();
            if (this.t) {
                parameters2.setFlashMode("off");
            }
            this.f19969a.setParameters(parameters2);
            return;
        }
        try {
            this.f19974f.start();
            this.f19975g = true;
            this.f19971c.setSelected(true);
            this.f19972d.setVisibility(4);
            this.f19973e.setVisibility(4);
            this.n.setVisibility(4);
            this.p.setVisibility(0);
            this.s = System.nanoTime();
            this.v = false;
            this.W.run();
            this.V.run();
        } catch (IllegalStateException unused) {
            d(false);
        }
    }

    public void s() {
        if (this.F) {
            this.D.setVisibility(4);
            this.E.setVisibility(4);
            this.F = false;
        }
    }

    public int t() {
        return this.N[this.k].videoFrameHeight;
    }

    public int u() {
        return this.N[this.k].videoFrameWidth;
    }

    public void v() {
        int[] iArr;
        int i;
        if (this.f19969a == null) {
            return;
        }
        int u = u();
        int t = t();
        float f2 = u / t;
        Camera.Parameters parameters = this.f19969a.getParameters();
        if (parameters.getSupportedPreviewSizes() != null && (!Build.MANUFACTURER.equalsIgnoreCase("samsung") || getResources().getDisplayMetrics().density >= 1.1f)) {
            Camera.Size preferredPreviewSizeForVideo = parameters.getPreferredPreviewSizeForVideo();
            if (preferredPreviewSizeForVideo != null) {
                Log.i("KineCamcorder", "preferred size: " + preferredPreviewSizeForVideo.width + " x " + preferredPreviewSizeForVideo.height);
                i = preferredPreviewSizeForVideo.width * preferredPreviewSizeForVideo.height;
                if (Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
                    int i2 = u * t;
                    if (i < i2 / 3) {
                        Log.i("KineCamcorder", "preferred size too small; overriding");
                        i = (i2 * 110) / 100;
                    }
                }
            } else {
                Log.i("KineCamcorder", "no preferred size: ");
                i = ((u * t) * 110) / 100;
            }
            Camera.Size size = null;
            int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            float f3 = 1000.0f;
            for (Camera.Size size2 : parameters.getSupportedPreviewSizes()) {
                int i4 = size2.width;
                int i5 = size2.height;
                if (i4 * i5 > i) {
                    Log.i("KineCamcorder", "SIZE: " + size2.width + " x " + size2.height + " SKIP - TOO LARGE");
                } else {
                    int max = Math.max(Math.abs(i5 - t), Math.abs(size2.width - u));
                    int i6 = i;
                    float abs = Math.abs((size2.width / size2.height) - f2);
                    Log.i("KineCamcorder", "SIZE: " + size2.width + " x " + size2.height + " diff=" + max + " maxdiff=" + i3 + " ratioDiff=" + abs);
                    int i7 = u;
                    if (abs < 0.05d) {
                        abs = 0.0f;
                    }
                    if (abs < f3 || (Math.abs(abs - f3) < 0.01d && max < i3)) {
                        f3 = abs;
                        size = size2;
                        i3 = max;
                    }
                    u = i7;
                    i = i6;
                }
            }
            if (size != null) {
                parameters.setPreviewSize(size.width, size.height);
                Log.i("KineCamcorder", "SET previewSize SIZE: " + size.width + " x " + size.height);
            } else {
                Log.i("KineCamcorder", "SET previewSize SIZE: not found");
            }
        } else {
            parameters.setPreviewSize(u, t);
            Log.i("KineCamcorder", "SET previewSize SIZE = RECORD SIZE: " + u + " x " + t);
        }
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                iArr = null;
                break;
            }
            int[] next = it.next();
            if (next[0] >= 30000 && next[1] < 40000) {
                iArr = next;
                break;
            }
        }
        if (iArr == null) {
            Iterator<int[]> it2 = supportedPreviewFpsRange.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                int[] next2 = it2.next();
                if (next2[1] >= 30000 && next2[1] < 40000) {
                    iArr = next2;
                    break;
                }
            }
        }
        if (iArr != null) {
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
        this.f19969a.setParameters(parameters);
    }

    private boolean w() {
        if (this.f19969a == null) {
            return false;
        }
        this.f19974f = new MediaRecorder();
        this.f19969a.unlock();
        this.f19974f.setCamera(this.f19969a);
        this.f19974f.setAudioSource(5);
        this.f19974f.setVideoSource(1);
        this.f19974f.setProfile(this.N[this.k]);
        this.f19974f.setOrientationHint(b(this.H));
        this.u = d(2);
        this.f19974f.setOutputFile(this.u.getAbsolutePath());
        try {
            this.f19974f.prepare();
            return true;
        } catch (IOException e2) {
            Log.d("KineCamcorder", "prepareVideoRecorder - IOException preparing MediaRecorder: " + e2.getMessage());
            z();
            return false;
        } catch (IllegalStateException e3) {
            Log.d("KineCamcorder", "prepareVideoRecorder - IllegalStateException preparing MediaRecorder: " + e3.getMessage());
            z();
            return false;
        }
    }

    public void x() {
        int[] iArr;
        boolean z = false;
        int[] iArr2 = new int[0];
        if (Build.VERSION.SDK_INT >= 21) {
            iArr = new int[]{8, 6, 5, 4, 7, 3, 0, 1};
        } else {
            iArr = new int[]{6, 5, 4, 7, 3, 0, 1};
        }
        this.M = new ArrayList();
        int length = iArr.length;
        CamcorderProfile camcorderProfile = null;
        CamcorderProfile camcorderProfile2 = null;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= length) {
                break;
            }
            int i2 = iArr[i];
            if (CamcorderProfile.hasProfile(this.k, i2)) {
                CamcorderProfile camcorderProfile3 = CamcorderProfile.get(this.k, i2);
                if (a(camcorderProfile3)) {
                    Iterator<CamcorderProfile> it = this.M.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        CamcorderProfile next = it.next();
                        if (next.videoFrameWidth == camcorderProfile3.videoFrameWidth && next.videoFrameHeight == camcorderProfile3.videoFrameHeight) {
                            break;
                        }
                    }
                    if (!z2) {
                        this.M.add(camcorderProfile3);
                        if (camcorderProfile3.videoFrameWidth == 1920 && camcorderProfile3.videoFrameHeight == 1080 && camcorderProfile == null) {
                            camcorderProfile = camcorderProfile3;
                        }
                        if (camcorderProfile2 == null || camcorderProfile3.videoFrameWidth * camcorderProfile3.videoFrameHeight > camcorderProfile2.videoFrameWidth * camcorderProfile2.videoFrameHeight) {
                            camcorderProfile2 = camcorderProfile3;
                        }
                    }
                }
            }
            i++;
        }
        if (camcorderProfile == null) {
            camcorderProfile = camcorderProfile2;
        }
        if (this.N[this.k] == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String str = "CAMCORDER_SEL_PROFILE_" + this.k;
            if (defaultSharedPreferences.contains(str)) {
                int i3 = defaultSharedPreferences.getInt(str, camcorderProfile.quality);
                Iterator<CamcorderProfile> it2 = this.M.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CamcorderProfile next2 = it2.next();
                    if (next2.quality == i3) {
                        camcorderProfile = next2;
                        break;
                    }
                }
            }
            if (camcorderProfile != null) {
                this.N[this.k] = camcorderProfile;
                defaultSharedPreferences.edit().putInt(str, camcorderProfile.quality).apply();
            }
        }
        if (this.N[this.k] != null) {
            this.m.setText(u() + " x " + t());
        }
        List<String> supportedFlashModes = this.f19969a.getParameters().getSupportedFlashModes();
        if (supportedFlashModes != null && supportedFlashModes.contains("torch")) {
            z = true;
        }
        this.t = z;
    }

    public void y() {
        Camera camera = this.f19969a;
        if (camera != null) {
            camera.release();
            this.f19969a = null;
        }
    }

    private void z() {
        MediaRecorder mediaRecorder = this.f19974f;
        if (mediaRecorder != null) {
            if (this.f19975g) {
                try {
                    mediaRecorder.stop();
                } catch (Exception unused) {
                }
            }
            this.f19974f.reset();
            this.f19974f.release();
            this.f19974f = null;
            this.f19969a.lock();
        }
        this.f19975g = false;
    }

    public void e(int i) {
        float f2 = i;
        this.f19973e.setRotation(f2);
        this.f19971c.setRotation(f2);
        this.f19972d.setRotation(f2);
        if (i == 0 || i == 180) {
            this.m.setRotation(f2);
            this.o.setRotation(f2);
        }
    }

    private int b(int i) {
        int i2;
        if (this.f19969a == null) {
            return 0;
        }
        Camera.getCameraInfo(this.k, this.f19976h);
        Camera.CameraInfo cameraInfo = this.f19976h;
        int i3 = cameraInfo.facing;
        if (i3 == 1) {
            if (i != 180 && i != 0) {
                return ((cameraInfo.orientation - i) + 360) % 360;
            }
            return (this.f19976h.orientation + i) % 360;
        }
        if (i3 != 0) {
            return 0;
        }
        if (i != 180 && i != 0) {
            int i4 = cameraInfo.orientation;
            if (i4 == 0) {
                i2 = (i4 - i) % 360;
            } else {
                i2 = (i4 + i) % 360;
            }
            return (360 - i2) % 360;
        }
        return ((this.f19976h.orientation - i) + 360) % 360;
    }

    public Camera c(int i) {
        try {
            return Camera.open(i);
        } catch (Exception e2) {
            Log.e("KineCamcorder", "Camera is not available", e2);
            return null;
        }
    }

    public void d(boolean z) {
        if (this.f19975g) {
            CamcorderProfile camcorderProfile = this.N[this.k];
            try {
                this.f19974f.stop();
            } catch (RuntimeException e2) {
                Log.w("KineCamcorder", "Failed to stop media recorder", e2);
                Toast.makeText(this, R.string.camera_fail_camcord, 1).show();
                this.u.delete();
                z = false;
            }
            this.f19975g = false;
            z();
        }
        this.f19971c.setSelected(false);
        if (this.l > 1) {
            this.f19972d.setVisibility(0);
        } else {
            this.f19972d.setVisibility(4);
        }
        this.f19973e.setVisibility(this.t ? 0 : 4);
        this.n.setVisibility(0);
        this.p.setVisibility(4);
        Camera.Parameters parameters = this.f19969a.getParameters();
        if (this.t) {
            parameters.setFlashMode("off");
        }
        this.f19969a.setParameters(parameters);
        if (z) {
            y();
            Intent intent = new Intent(this, (Class<?>) CamcorderPreviewActivity.class);
            intent.putExtra("VIDEO_PATH", this.u.getAbsolutePath());
            intent.putExtra("PROJECT_NAME", this.O);
            intent.putExtra("IS_SUPPORT_LAYER", this.Q);
            intent.putExtra("USE_AS_LAYER", this.P);
            this.S = true;
            startActivityForResult(intent, 50);
        }
    }

    private boolean a(CamcorderProfile camcorderProfile) {
        int i = camcorderProfile.videoFrameWidth;
        int i2 = camcorderProfile.videoFrameHeight;
        if (i * i2 < this.x || i2 * i > this.y || i < this.z || i > this.B || i < this.A || i > this.C) {
            return false;
        }
        int i3 = camcorderProfile.videoCodec;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        int i4 = camcorderProfile.audioCodec;
        return i4 == 3 || i4 == 5 || i4 == 4;
    }

    private File d(int i) {
        if (i == 1) {
            return c.d.b.m.l.b(this.O);
        }
        return c.d.b.m.l.c(this.O);
    }
}

package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.camcorder.CamcorderActivity;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.ba;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class ez extends kp implements FragmentManager.OnBackStackChangedListener, ProjectEditActivity.b, ba.a {
    private static int i = 1;
    private File j;

    /* renamed from: a, reason: collision with root package name */
    private View f3888a = null;
    private View b = null;
    private WeakReference<Dialog> c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f = true;
    private long g = -1;
    private View.OnClickListener h = new gb(this);
    private long k = 0;

    void a(Dialog dialog) {
        this.c = new WeakReference<>(dialog);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        Dialog dialog;
        if (this.c == null || (dialog = this.c.get()) == null) {
            return false;
        }
        return dialog.isShowing();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.pedit_option_panel_default_fragment, viewGroup, false);
        this.b.findViewById(R.id.btn_complete).setOnClickListener(this.h);
        this.b.findViewById(R.id.btn_itemstore).setOnClickListener(this.h);
        this.b.findViewById(R.id.btn_settings).setOnClickListener(this.h);
        this.b.findViewById(R.id.btn_playpause).setOnClickListener(this.h);
        this.b.findViewById(R.id.btn_playpause).setOnLongClickListener(new fa(this));
        this.b.findViewById(R.id.mediabrowser_button_holder).setOnClickListener(this.h);
        this.b.findViewById(R.id.voicerecord_button_holder).setOnClickListener(this.h);
        this.b.findViewById(R.id.audiobrowser_button_holder).setOnClickListener(this.h);
        this.b.findViewById(R.id.btn_camera).setOnClickListener(this.h);
        this.b.findViewById(R.id.camera_button_holder).setOnClickListener(this.h);
        this.b.findViewById(R.id.camcorder_button_holder).setOnClickListener(this.h);
        this.b.findViewById(R.id.btn_camera_back).setOnClickListener(this.h);
        this.b.findViewById(R.id.btn_settings).setVisibility(4);
        this.b.findViewById(R.id.btn_playpause).setVisibility(0);
        a((ProjectEditActivity) getActivity());
        if (getFragmentManager() != null) {
            getFragmentManager().addOnBackStackChangedListener(this);
        }
        this.b.findViewById(R.id.layer_button_holder).setOnTouchListener(new fo(this));
        View findViewById = this.b.findViewById(R.id.multi_touch_zone);
        findViewById.setOnClickListener(new fz(this));
        findViewById.setOnTouchListener(new ga(this));
        if (NexEditorDeviceProfile.getDeviceProfile() != null && NexEditorDeviceProfile.getDeviceProfile().getVideoRecordingMode() == NexEditorDeviceProfile.MediaRecordingMode.Disable) {
            this.b.findViewById(R.id.camcorder_button_holder).setEnabled(false);
            this.b.findViewById(R.id.camcorder_icon).setEnabled(false);
            this.b.findViewById(R.id.camcorder_tv).setEnabled(false);
        }
        if (NexEditorDeviceProfile.getDeviceProfile() != null && NexEditorDeviceProfile.getDeviceProfile().getImageRecordingMode() == NexEditorDeviceProfile.MediaRecordingMode.Disable) {
            this.b.findViewById(R.id.camera_button_holder).setEnabled(false);
            this.b.findViewById(R.id.camera_icon).setEnabled(false);
            this.b.findViewById(R.id.camera_tv).setEnabled(false);
        }
        this.b.findViewById(R.id.btn_itemstore).setVisibility(8);
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ProjectEditActivity)) {
            ((ProjectEditActivity) activity).u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        b(getFragmentManager().beginTransaction()).replace(R.id.optionPanelHolder, new mf()).addToBackStack("voiceRecorder").commit();
        getFragmentManager().executePendingTransactions();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_change_theme, R.drawable.action_icon_change_theme, R.id.action_share, R.drawable.action_icon_share, R.id.action_settings, R.drawable.action_icon_settings);
        g(0);
        i(true);
        j(true);
        k(true);
        l(true);
        m(false);
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.b = null;
        this.f3888a = null;
        this.d = false;
        this.f = true;
        getFragmentManager().removeOnBackStackChangedListener(this);
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, com.nexstreaming.kinemaster.ui.projectedit.a
    public boolean a(int i2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        LayerSubMenuPopup biVar;
        VideoEditor o = o();
        if (this.b != null && o != null && !c()) {
            int[] iArr = new int[2];
            View findViewById = this.b.findViewById(R.id.multi_touch_zone);
            findViewById.getLocationInWindow(iArr);
            if (NexEditorDeviceProfile.getDeviceProfile().getSupportsVideoLayers(o.A())) {
                biVar = new bl(getActivity(), iArr[0], iArr[1] + (findViewById.getHeight() / 2), F());
            } else {
                biVar = new bi(getActivity(), iArr[0], iArr[1] + (findViewById.getHeight() / 2));
            }
            a(biVar);
            biVar.setOnCancelListener(new gc(this));
            biVar.setOnDismissListener(new gd(this));
            biVar.a(new ge(this));
            biVar.setOnShowListener(new gg(this));
            if (biVar.getWindow() != null && biVar.getWindow().getAttributes() != null) {
                biVar.getWindow().getAttributes().windowAnimations = R.anim.abc_popup_enter;
            }
            biVar.show();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        this.f = true;
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Dialog dialog = this.c.get();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        File c;
        KMUsage.EditScreen_RecButton.logEvent("button", "camera");
        if (Build.VERSION.SDK_INT >= 23 && getActivity().checkSelfPermission("android.permission.CAMERA") != 0) {
            if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            }
            this.g = System.nanoTime();
            requestPermissions(new String[]{"android.permission.CAMERA"}, R.id.req_perm_camera);
            return;
        }
        this.j = null;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (Build.VERSION.SDK_INT >= 16 && (c = com.nexstreaming.kinemaster.h.c.c(getActivity())) != null) {
            this.j = c;
            intent.putExtra("output", Uri.fromFile(c));
        }
        KMAppUsage.a(getActivity()).a(KMAppUsage.KMMetric.RecImage);
        try {
            startActivityForResult(intent, 4);
        } catch (ActivityNotFoundException e) {
        }
        this.k = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        KMUsage.EditScreen_RecButton.logEvent("button", "camcorder");
        int maxImportSize = NexEditorDeviceProfile.getDeviceProfile().getMaxImportSize(o().A());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if (NexEditorDeviceProfile.getDeviceProfile().getVideoRecordingMode() == NexEditorDeviceProfile.MediaRecordingMode.UseNative) {
            if (maxImportSize < 2073600 && !defaultSharedPreferences.getBoolean("native_camera_import_warning", false)) {
                new a.C0074a(getActivity()).a(R.string.native_camera_resolution_warning).a(new fc(this)).a(R.string.button_export_fail_ok, new fb(this, defaultSharedPreferences)).a().show();
                return;
            }
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            EditorGlobal.a(intent);
            o().B();
            KMAppUsage.a(getActivity()).a(KMAppUsage.KMMetric.RecVideo);
            startActivityForResult(intent, 2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23 && (getActivity().checkSelfPermission("android.permission.CAMERA") != 0 || getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
            if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            }
            this.g = System.nanoTime();
            requestPermissions(new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, R.id.req_perm_camcord);
            return;
        }
        o().B();
        KMAppUsage.a(getActivity()).a(KMAppUsage.KMMetric.RecVideoKM);
        Intent intent2 = new Intent(getActivity(), (Class<?>) CamcorderActivity.class);
        intent2.putExtra("MAX_SIZE", maxImportSize);
        intent2.putExtra("MIN_WIDTH", 320);
        intent2.putExtra("MIN_HEIGHT", 240);
        intent2.putExtra("PROJECT_NAME", G());
        intent2.putExtra("IS_SUPPORT_LAYER", NexEditorDeviceProfile.getDeviceProfile().getSupportsVideoLayers(o().A()));
        intent2.putExtra("USE_AS_LAYER", o().f().a().getPrimaryItemCount() >= 1);
        startActivityForResult(intent2, 20);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z;
        boolean z2;
        this.f = true;
        this.d = false;
        if (i2 == R.id.req_perm_camcord) {
            boolean z3 = false;
            boolean z4 = false;
            int min = Math.min(strArr.length, iArr.length);
            int i3 = 0;
            while (i3 < min) {
                if (strArr[i3].equals("android.permission.CAMERA")) {
                    boolean z5 = z4;
                    z2 = iArr[i3] == 0;
                    z = z5;
                } else if (strArr[i3].equals("android.permission.RECORD_AUDIO")) {
                    z = iArr[i3] == 0;
                    z2 = z3;
                } else {
                    z = z4;
                    z2 = z3;
                }
                i3++;
                z3 = z2;
                z4 = z;
            }
            if (z3 && z4) {
                I();
            } else if ((System.nanoTime() - this.g) / 1000000 < 190) {
                a(R.string.permission_camera_title, R.string.permission_camera_settings);
            }
        } else if (i2 == R.id.req_perm_voicerec) {
            int min2 = Math.min(strArr.length, iArr.length);
            boolean z6 = false;
            for (int i4 = 0; i4 < min2; i4++) {
                if (strArr[i4].equals("android.permission.RECORD_AUDIO")) {
                    z6 = iArr[i4] == 0;
                }
            }
            if (z6) {
                h();
            } else if ((System.nanoTime() - this.g) / 1000000 < 190) {
                a(R.string.permission_mic_title, R.string.permission_mic_settings);
            }
        } else if (i2 == R.id.req_perm_camera) {
            int min3 = Math.min(strArr.length, iArr.length);
            boolean z7 = false;
            for (int i5 = 0; i5 < min3; i5++) {
                if (strArr[i5].equals("android.permission.CAMERA")) {
                    z7 = iArr[i5] == 0;
                }
            }
            if (z7) {
                H();
            } else if ((System.nanoTime() - this.g) / 1000000 < 190) {
                a(R.string.permission_cameraonly_title, R.string.permission_cameraonly_settings);
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    private void a(int i2, int i3) {
        new a.C0074a(getActivity()).f(i2).a(i3).a(R.string.permission_app_settings, new fe(this)).b(R.string.button_ok, new fd(this)).a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.d) {
            RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.right_panel_camera_holder);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            relativeLayout.startAnimation(scaleAnimation);
            LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.camcorder_button_holder);
            linearLayout.postDelayed(new ff(this, linearLayout, (LinearLayout) this.b.findViewById(R.id.camera_button_holder)), 200L);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(200L);
            ImageButton imageButton = (ImageButton) this.b.findViewById(R.id.btn_camera_back);
            imageButton.startAnimation(scaleAnimation2);
            imageButton.postDelayed(new fg(this), 250L);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) this.b.findViewById(R.id.camera_button_holder);
        ((LinearLayout) this.b.findViewById(R.id.camcorder_button_holder)).startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.camcorder_slide_righttoleft));
        linearLayout2.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.camera_slide_lefttoright));
        ImageButton imageButton2 = (ImageButton) this.b.findViewById(R.id.btn_camera_back);
        imageButton2.postDelayed(new fh(this, imageButton2), 100L);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.b.findViewById(R.id.right_panel_camera_holder);
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation3.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimation3.setDuration(300L);
        relativeLayout2.postOnAnimationDelayed(new fi(this, scaleAnimation3, relativeLayout2), 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        if (this.b == null) {
            return false;
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.right_panel_camera_holder);
        if (relativeLayout.getAnimation() != null) {
            this.e = !relativeLayout.getAnimation().hasEnded();
        }
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.camera_button_holder);
        if (linearLayout.getAnimation() != null) {
            this.e = !linearLayout.getAnimation().hasEnded();
        }
        ImageButton imageButton = (ImageButton) this.b.findViewById(R.id.btn_camera_back);
        if (imageButton.getAnimation() != null) {
            this.e = imageButton.getAnimation().hasEnded() ? false : true;
        }
        return this.e;
    }

    @Override // com.nextreaming.nexeditorui.ba.a
    public boolean l_() {
        if (!this.d) {
            return false;
        }
        this.d = false;
        J();
        return true;
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        View view;
        super.onActivityResult(i2, i3, intent);
        if (intent != null) {
            intent.getData();
        }
        if (i2 == 2 || i2 == 4 || i2 == 20) {
            this.f = true;
            if (i3 == -1) {
                VideoEditor o = o();
                if (i2 == 4 && this.j != null && o != null) {
                    if (!this.j.exists()) {
                        Uri L = L();
                        if (L != null) {
                            L.getPath();
                            o.e().onComplete(new fj(this, AndroidMediaStoreProvider.a(new File(L.getPath()))));
                            return;
                        }
                        return;
                    }
                    Uri L2 = L();
                    if (L2 == null) {
                        MediaScannerConnection.scanFile(getActivity(), new String[]{this.j.getAbsolutePath()}, null, new fk(this, o));
                        return;
                    }
                    try {
                        if (!new File(L2.getPath()).getCanonicalPath().equals(this.j.getCanonicalPath())) {
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    MediaScannerConnection.scanFile(getActivity(), new String[]{this.j.getAbsolutePath()}, null, new fp(this, o));
                    return;
                }
                if (intent != null && intent.getExtras() != null) {
                    Iterator<String> it = intent.getExtras().keySet().iterator();
                    while (it.hasNext()) {
                        intent.getExtras().get(it.next());
                    }
                    if (((Bitmap) intent.getExtras().get(ShareConstants.WEB_DIALOG_PARAM_DATA)) != null) {
                    }
                }
                if (i2 == 2 || i2 == 20) {
                    int i4 = 50;
                    if (Build.MANUFACTURER.trim().equalsIgnoreCase("Nokia")) {
                        i4 = 1300;
                    }
                    new Handler().postDelayed(new ft(this, i2, intent, o), i4);
                } else if (i2 == 4) {
                    Uri L3 = L();
                    if (L3 != null) {
                        String path = L3.getPath();
                        if (((path != null && path.length() > 0 && new File(path).exists()) || path.startsWith("@solid:")) && EditorGlobal.a(path)) {
                            o.e().onComplete(new fw(this, AndroidMediaStoreProvider.a(new File(path))));
                        }
                    } else {
                        return;
                    }
                }
            }
        }
        if (intent != null && i2 == FullScreenInputActivity.a() && getView() != null && (stringExtra = intent.getStringExtra("text")) != null && !stringExtra.equals("") && !stringExtra.trim().equals("")) {
            Paint paint = new Paint();
            Rect rect = new Rect();
            paint.getTextBounds(stringExtra, 0, stringExtra.length(), rect);
            if (rect.width() > 0 && rect.height() > 0 && (view = getView()) != null) {
                view.postDelayed(new fx(this, stringExtra), 60L);
            }
        }
    }

    private Uri L() {
        Uri uri;
        Uri uri2;
        String path;
        File file;
        try {
            Cursor query = getActivity().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id"}, "datetaken >= " + this.k + " AND datetaken < " + (System.currentTimeMillis() + 60000), null, "datetaken DESC");
            if (query == null || query.getCount() <= 0) {
                uri2 = null;
            } else {
                try {
                    uri2 = query.moveToFirst() ? Uri.parse(query.getString(0)) : null;
                    try {
                        query.close();
                    } catch (Exception e) {
                        uri = uri2;
                        e = e;
                        Log.w("OpPanelDefaultFragment", "Error getting last photo taken", e);
                        uri2 = uri;
                        if (uri2 != null) {
                        }
                        return uri2;
                    }
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            uri = null;
        }
        if (uri2 != null || (path = uri2.getPath()) == null || (file = new File(path)) == null || !file.exists() || this.k <= file.lastModified()) {
            return uri2;
        }
        return null;
    }

    @Override // android.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        if (getFragmentManager() != null && getFragmentManager().getBackStackEntryCount() > 0 && this.b != null) {
            this.f = false;
        } else if (getFragmentManager() != null && getFragmentManager().getBackStackEntryCount() < 1 && this.b != null) {
            this.f = true;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity.b
    public void a(ProjectEditActivity projectEditActivity) {
        if (this.b != null) {
            boolean d = projectEditActivity.d(R.id.action_play_pause);
            boolean e = projectEditActivity.e(R.id.action_play_pause);
            View findViewById = this.b.findViewById(R.id.btn_playpause);
            findViewById.setEnabled(d);
            findViewById.setActivated(e);
        }
    }
}

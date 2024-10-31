package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.camcorder.CamcorderActivity;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nextreaming.nexeditorui.C2343y;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import kotlin.TypeCastException;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
public final class Bd extends Bg implements I.a, FragmentManager.OnBackStackChangedListener, ProjectEditActivity.b {
    private com.nexstreaming.kinemaster.ui.a.e A;
    private boolean B;
    private File C;
    private HashMap E;
    private View n;
    private View o;
    private boolean p;
    private boolean q;
    private long s;
    private LinearLayout t;
    private LinearLayout u;
    private LinearLayout v;
    private LinearLayout w;
    private Locale x;
    private AppCompatActivity y;
    private WeakReference<Dialog> z;
    public static final a m = new a(null);
    private static final String l = Bd.class.getSimpleName();
    private boolean r = true;
    private final View.OnClickListener D = new Xd(this);

    /* compiled from: OptionPanelDefaultFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa() {
        if (requireActivity() instanceof ProjectEditActivity) {
            FragmentActivity requireActivity = requireActivity();
            if (requireActivity == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity");
            }
            ((ProjectEditActivity) requireActivity).ta();
        }
    }

    private final void Ba() {
        File a2;
        this.C = null;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (Build.VERSION.SDK_INT >= 16 && (a2 = c.d.b.m.l.a(getActivity())) != null) {
            KineMasterApplication c2 = KineMasterApplication.f24058f.c();
            Uri uriForFile = FileProvider.getUriForFile(c2, c2.getPackageName(), a2);
            if (Build.VERSION.SDK_INT < 21) {
                Iterator<ResolveInfo> it = c2.getPackageManager().queryIntentActivities(intent, 65536).iterator();
                while (it.hasNext()) {
                    c2.grantUriPermission(it.next().activityInfo.packageName, uriForFile, 2);
                }
            }
            this.C = a2;
            intent.putExtra("output", uriForFile);
        }
        KMAppUsage.a(KineMasterApplication.f24058f.c()).a(KMAppUsage.KMMetric.RecImage);
        try {
            startActivityForResult(intent, 4);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
        this.s = System.currentTimeMillis();
    }

    private final void Ca() {
        VideoEditor da = da();
        if (da != null) {
            int maxImportSize = NexEditorDeviceProfile.getDeviceProfile().getMaxImportSize(da.i());
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
            NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
            kotlin.jvm.internal.h.a((Object) deviceProfile, "NexEditorDeviceProfile.getDeviceProfile()");
            if (deviceProfile.getVideoRecordingMode() == NexEditorDeviceProfile.MediaRecordingMode.UseNative) {
                if (maxImportSize < 2073600 && !defaultSharedPreferences.getBoolean("native_camera_import_warning", false)) {
                    e.a aVar = new e.a(getActivity());
                    aVar.c(R.string.native_camera_resolution_warning);
                    aVar.a(DialogInterfaceOnCancelListenerC1856be.f22283a);
                    aVar.c(R.string.button_ok, new DialogInterfaceOnClickListenerC1865ce(this, defaultSharedPreferences));
                    aVar.a().show();
                    return;
                }
                Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
                EditorGlobal.a(intent);
                VideoEditor da2 = da();
                if (da2 != null) {
                    da2.j();
                    KMAppUsage.a(getActivity()).a(KMAppUsage.KMMetric.RecVideo);
                    startActivityForResult(intent, 2);
                    return;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (da() != null) {
                VideoEditor da3 = da();
                if (da3 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                da3.j();
            }
            KMAppUsage.a(getActivity()).a(KMAppUsage.KMMetric.RecVideoKM);
            Intent intent2 = new Intent(getActivity(), (Class<?>) CamcorderActivity.class);
            intent2.putExtra("MAX_SIZE", maxImportSize);
            intent2.putExtra("MIN_WIDTH", ModuleDescriptor.MODULE_VERSION);
            intent2.putExtra("MIN_HEIGHT", 240);
            intent2.putExtra("PROJECT_NAME", U());
            NexEditorDeviceProfile deviceProfile2 = NexEditorDeviceProfile.getDeviceProfile();
            VideoEditor da4 = da();
            if (da4 != null) {
                intent2.putExtra("IS_SUPPORT_LAYER", deviceProfile2.getSupportsVideoLayers(da4.i()));
                if (da() != null) {
                    VideoEditor da5 = da();
                    if (da5 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    if (da5.s() != null) {
                        VideoEditor da6 = da();
                        if (da6 == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        C1780za s = da6.s();
                        kotlin.jvm.internal.h.a((Object) s, "getVideoEditor()!!.project");
                        if (s.a() != null) {
                            VideoEditor da7 = da();
                            if (da7 == null) {
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                            C1780za s2 = da7.s();
                            kotlin.jvm.internal.h.a((Object) s2, "getVideoEditor()!!.project");
                            NexTimeline a2 = s2.a();
                            kotlin.jvm.internal.h.a((Object) a2, "getVideoEditor()!!.project.timeline");
                            intent2.putExtra("USE_AS_LAYER", a2.getPrimaryItemCount() >= 1);
                            startActivityForResult(intent2, 20);
                            return;
                        }
                    }
                }
                intent2.putExtra("USE_AS_LAYER", false);
                startActivityForResult(intent2, 20);
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    private final void Da() {
        Bg.a aVar = Bg.f21786a;
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            kotlin.jvm.internal.h.a((Object) beginTransaction, "fragmentManager!!.beginTransaction()");
            aVar.a(beginTransaction).replace(R.id.optionPanelHolder, new zh()).addToBackStack("voiceRecorder").commitAllowingStateLoss();
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea() {
        if (this.p) {
            View view = this.o;
            if (view != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.right_panel_camera_holder);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(300L);
                relativeLayout.startAnimation(scaleAnimation);
                View view2 = this.o;
                if (view2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.camcorder_button_holder);
                    View view3 = this.o;
                    if (view3 != null) {
                        linearLayout.postDelayed(new RunnableC1874de(this, linearLayout, (LinearLayout) view3.findViewById(R.id.camera_button_holder)), 200L);
                        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                        scaleAnimation2.setDuration(200L);
                        View view4 = this.o;
                        if (view4 != null) {
                            ImageButton imageButton = (ImageButton) view4.findViewById(R.id.btn_camera_back);
                            imageButton.startAnimation(scaleAnimation2);
                            imageButton.postDelayed(new RunnableC1883ee(this), 250L);
                            return;
                        }
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        View view5 = this.o;
        if (view5 != null) {
            LinearLayout linearLayout2 = (LinearLayout) view5.findViewById(R.id.camera_button_holder);
            View view6 = this.o;
            if (view6 != null) {
                ((LinearLayout) view6.findViewById(R.id.camcorder_button_holder)).startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.camcorder_slide_righttoleft));
                linearLayout2.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.camera_slide_lefttoright));
                View view7 = this.o;
                if (view7 != null) {
                    ImageButton imageButton2 = (ImageButton) view7.findViewById(R.id.btn_camera_back);
                    imageButton2.postDelayed(new RunnableC1892fe(this, imageButton2), 100L);
                    View view8 = this.o;
                    if (view8 != null) {
                        if (view8 == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        View findViewById = view8.findViewById(R.id.default_right_panel_holder);
                        kotlin.jvm.internal.h.a((Object) findViewById, "contentView!!.findViewBy…fault_right_panel_holder)");
                        findViewById.setVisibility(0);
                    }
                    View view9 = this.o;
                    if (view9 != null) {
                        RelativeLayout relativeLayout2 = (RelativeLayout) view9.findViewById(R.id.right_panel_camera_holder);
                        float f2 = (float) 0.5d;
                        ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, f2, 1, f2);
                        scaleAnimation3.setInterpolator(new AccelerateDecelerateInterpolator());
                        scaleAnimation3.setDuration(300L);
                        scaleAnimation3.setAnimationListener(new AnimationAnimationListenerC1901ge(relativeLayout2));
                        relativeLayout2.postOnAnimationDelayed(new RunnableC1910he(scaleAnimation3, relativeLayout2), 300L);
                        return;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    private final void Fa() {
        VideoEditor da = da();
        if (this.o == null || da == null || za()) {
            return;
        }
        int[] iArr = new int[2];
        View view = this.o;
        if (view != null) {
            View findViewById = view.findViewById(R.id.multi_touch_zone);
            findViewById.getLocationInWindow(iArr);
            int i = EditorGlobal.a((Activity) requireActivity()).left;
            int i2 = iArr[0] - 0;
            int i3 = iArr[1];
            kotlin.jvm.internal.h.a((Object) findViewById, "view");
            int height = i3 + (findViewById.getHeight() / 2);
            boolean supportsVideoLayers = NexEditorDeviceProfile.getDeviceProfile().getSupportsVideoLayers(da.i());
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.h.a((Object) requireActivity, "requireActivity()");
            DialogC2045ub dialogC2045ub = new DialogC2045ub(requireActivity, i2, height, supportsVideoLayers);
            a(dialogC2045ub);
            dialogC2045ub.setOnCancelListener(new DialogInterfaceOnCancelListenerC1919ie(this));
            dialogC2045ub.setOnDismissListener(new DialogInterfaceOnDismissListenerC1927je(this));
            dialogC2045ub.a(new C1945le(this));
            dialogC2045ub.setOnShowListener(new DialogInterfaceOnShowListenerC1954me(this));
            if (dialogC2045ub.getWindow() != null) {
                Window window = dialogC2045ub.getWindow();
                if (window == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (window.getAttributes() != null) {
                    Window window2 = dialogC2045ub.getWindow();
                    if (window2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    window2.getAttributes().windowAnimations = R.anim.abc_popup_enter;
                }
            }
            dialogC2045ub.show();
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ga() {
        InterfaceC2025f ia;
        if (getActivity() == null || !(getActivity() instanceof ProjectEditActivity)) {
            return;
        }
        float l2 = EditorGlobal.l();
        if (l2 == 0.5625f || l2 == 1.0f) {
            ProjectEditActivity projectEditActivity = (ProjectEditActivity) getActivity();
            if (projectEditActivity != null && projectEditActivity.ha() == 0) {
                View U = projectEditActivity.U();
                kotlin.jvm.internal.h.a((Object) U, "projectEditActivity.getLayoutBase()");
                projectEditActivity.n(U.getWidth());
            }
            if (projectEditActivity != null && projectEditActivity.ga() == 0) {
                projectEditActivity.l(getResources().getDimensionPixelOffset(R.dimen.pedit_big_option_panel_width));
            }
            ViewGroup.LayoutParams layoutParams = (projectEditActivity == null || (ia = projectEditActivity.ia()) == null) ? null : ia.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = projectEditActivity.ha();
                InterfaceC2025f ia2 = projectEditActivity.ia();
                if (ia2 != null) {
                    ia2.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Ha() {
        VideoEditor da = da();
        if (da == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (da.s() == null) {
            return false;
        }
        if (this.B) {
            return true;
        }
        VideoEditor da2 = da();
        if (da2 == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        C1780za s = da2.s();
        kotlin.jvm.internal.h.a((Object) s, "getVideoEditor()!!.project");
        NexTimeline a2 = s.a();
        kotlin.jvm.internal.h.a((Object) a2, "getVideoEditor()!!.project.timeline");
        if (a2.getPrimaryItemCount() < 1) {
            String string = getResources().getString(R.string.add_video_before_layer);
            kotlin.jvm.internal.h.a((Object) string, "resources.getString(R.st…g.add_video_before_layer)");
            a(string, 1);
            return false;
        }
        VideoEditor da3 = da();
        if (da3 != null) {
            da3.M();
            View view = this.o;
            if (view != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layer_button_holder);
                kotlin.jvm.internal.h.a((Object) linearLayout, "layerHolder");
                if (!linearLayout.isSelected() && !za()) {
                    linearLayout.setSelected(true);
                    Fa();
                    return false;
                }
                va();
                return false;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int i) {
        if (i == 8208) {
            Da();
        } else if (i == 8210) {
            Ca();
        } else if (i == 8209) {
            Ba();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va() {
        Dialog dialog;
        WeakReference<Dialog> weakReference = this.z;
        if (weakReference == null) {
            dialog = null;
        } else {
            if (weakReference == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            dialog = weakReference.get();
        }
        if (dialog != null) {
            dialog.dismiss();
            this.z = null;
            this.B = false;
        }
    }

    private final Uri wa() {
        Uri uri;
        String path;
        FragmentActivity activity;
        String[] strArr = {"_data", "_id"};
        String str = "datetaken >= " + this.s + " AND datetaken < " + (System.currentTimeMillis() + 60000);
        try {
            activity = getActivity();
        } catch (Exception e2) {
            e = e2;
            uri = null;
        }
        if (activity != null) {
            kotlin.jvm.internal.h.a((Object) activity, "activity!!");
            Cursor query = activity.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, str, null, "datetaken DESC");
            if (query == null || query.getCount() <= 0) {
                uri = null;
            } else {
                try {
                    uri = query.moveToFirst() ? Uri.parse(query.getString(0)) : null;
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        Log.w(l, "Error getting last photo taken", e);
                        return uri == null ? uri : uri;
                    }
                } finally {
                    query.close();
                }
            }
            if (uri == null && (path = uri.getPath()) != null) {
                File file = new File(path);
                if (!file.exists() || this.s <= file.lastModified()) {
                    return uri;
                }
                return null;
            }
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    private final AppCompatActivity xa() {
        if (this.y == null) {
            FragmentActivity requireActivity = requireActivity();
            if (requireActivity == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.support.v7.app.AppCompatActivity");
            }
            this.y = (AppCompatActivity) requireActivity;
        }
        AppCompatActivity appCompatActivity = this.y;
        if (appCompatActivity != null) {
            return appCompatActivity;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    private final boolean ya() {
        if (this.x == null) {
            this.x = Locale.getDefault();
        }
        Locale locale = this.x;
        if (locale != null) {
            return c.d.b.m.h.a(locale);
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean za() {
        WeakReference<Dialog> weakReference = this.z;
        if (weakReference == null) {
            return false;
        }
        if (weakReference != null) {
            Dialog dialog = weakReference.get();
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    public final void o(boolean z) {
        LinearLayout linearLayout = this.u;
        if (linearLayout != null) {
            linearLayout.setEnabled(z);
            LinearLayout linearLayout2 = this.v;
            if (linearLayout2 != null) {
                linearLayout2.setEnabled(z);
                LinearLayout linearLayout3 = this.w;
                if (linearLayout3 != null) {
                    linearLayout3.setEnabled(z);
                    LinearLayout linearLayout4 = this.u;
                    if (linearLayout4 != null) {
                        C2343y.a(linearLayout4, z);
                        LinearLayout linearLayout5 = this.v;
                        if (linearLayout5 != null) {
                            C2343y.a(linearLayout5, z);
                            LinearLayout linearLayout6 = this.w;
                            if (linearLayout6 != null) {
                                C2343y.a(linearLayout6, z);
                                return;
                            } else {
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                        }
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_share, R.drawable.action_icon_share, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_settings, R.drawable.action_icon_settings);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        o(0);
        l(true);
        k(true);
        j(true);
        h(true);
        i(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x0186, code lost:            if (r2 != false) goto L107;     */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r16, int r17, android.content.Intent r18) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.Bd.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        if (!this.p) {
            return false;
        }
        this.p = false;
        Ea();
        return true;
    }

    @Override // android.support.v4.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        if (getFragmentManager() != null) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a((Object) fragmentManager, "fragmentManager!!");
            if (fragmentManager.getBackStackEntryCount() > 0 && this.o != null) {
                this.r = false;
                return;
            }
        }
        if (getFragmentManager() != null) {
            FragmentManager fragmentManager2 = getFragmentManager();
            if (fragmentManager2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a((Object) fragmentManager2, "fragmentManager!!");
            if (fragmentManager2.getBackStackEntryCount() >= 1 || this.o == null) {
                return;
            }
            this.r = true;
            this.B = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.b(layoutInflater, "inflater");
        this.o = layoutInflater.inflate(R.layout.pedit_option_panel_default_fragment, viewGroup, false);
        View view = this.o;
        if (view != null) {
            view.findViewById(R.id.btn_complete).setOnClickListener(this.D);
            View view2 = this.o;
            if (view2 != null) {
                view2.findViewById(R.id.btn_itemstore).setOnClickListener(this.D);
                View view3 = this.o;
                if (view3 != null) {
                    view3.findViewById(R.id.btn_settings).setOnClickListener(this.D);
                    View view4 = this.o;
                    if (view4 != null) {
                        view4.findViewById(R.id.btn_playpause).setOnClickListener(this.D);
                        View view5 = this.o;
                        if (view5 != null) {
                            view5.findViewById(R.id.btn_playpause).setOnLongClickListener(new Yd(this));
                            View view6 = this.o;
                            if (view6 != null) {
                                this.t = (LinearLayout) view6.findViewById(R.id.mediabrowser_button_holder);
                                LinearLayout linearLayout = this.t;
                                if (linearLayout != null) {
                                    linearLayout.setOnClickListener(this.D);
                                    View view7 = this.o;
                                    if (view7 != null) {
                                        this.u = (LinearLayout) view7.findViewById(R.id.voicerecord_button_holder);
                                        LinearLayout linearLayout2 = this.u;
                                        if (linearLayout2 != null) {
                                            linearLayout2.setOnClickListener(this.D);
                                            View view8 = this.o;
                                            if (view8 != null) {
                                                this.v = (LinearLayout) view8.findViewById(R.id.audiobrowser_button_holder);
                                                LinearLayout linearLayout3 = this.v;
                                                if (linearLayout3 != null) {
                                                    linearLayout3.setOnClickListener(this.D);
                                                    View view9 = this.o;
                                                    if (view9 != null) {
                                                        view9.findViewById(R.id.btn_camera).setOnClickListener(this.D);
                                                        View view10 = this.o;
                                                        if (view10 != null) {
                                                            view10.findViewById(R.id.camera_button_holder).setOnClickListener(this.D);
                                                            View view11 = this.o;
                                                            if (view11 != null) {
                                                                view11.findViewById(R.id.camcorder_button_holder).setOnClickListener(this.D);
                                                                View view12 = this.o;
                                                                if (view12 != null) {
                                                                    view12.findViewById(R.id.btn_camera_back).setOnClickListener(this.D);
                                                                    View view13 = this.o;
                                                                    if (view13 != null) {
                                                                        View findViewById = view13.findViewById(R.id.btn_settings);
                                                                        kotlin.jvm.internal.h.a((Object) findViewById, "contentView!!.findViewBy…<View>(R.id.btn_settings)");
                                                                        findViewById.setVisibility(4);
                                                                        View view14 = this.o;
                                                                        if (view14 != null) {
                                                                            View findViewById2 = view14.findViewById(R.id.btn_playpause);
                                                                            kotlin.jvm.internal.h.a((Object) findViewById2, "contentView!!.findViewBy…View>(R.id.btn_playpause)");
                                                                            findViewById2.setVisibility(0);
                                                                            FragmentActivity activity = getActivity();
                                                                            if (activity != null) {
                                                                                a((ProjectEditActivity) activity);
                                                                                if (getFragmentManager() != null) {
                                                                                    FragmentManager fragmentManager = getFragmentManager();
                                                                                    if (fragmentManager == null) {
                                                                                        kotlin.jvm.internal.h.a();
                                                                                        throw null;
                                                                                    }
                                                                                    fragmentManager.addOnBackStackChangedListener(this);
                                                                                }
                                                                                View view15 = this.o;
                                                                                if (view15 != null) {
                                                                                    this.w = (LinearLayout) view15.findViewById(R.id.layer_button_holder);
                                                                                    LinearLayout linearLayout4 = this.w;
                                                                                    if (linearLayout4 != null) {
                                                                                        linearLayout4.setOnKeyListener(new Zd(this));
                                                                                        LinearLayout linearLayout5 = this.w;
                                                                                        if (linearLayout5 != null) {
                                                                                            linearLayout5.setOnTouchListener(new _d(this));
                                                                                            View view16 = this.o;
                                                                                            if (view16 != null) {
                                                                                                view16.findViewById(R.id.multi_touch_zone).setOnTouchListener(new ViewOnTouchListenerC1847ae(this));
                                                                                                if (NexEditorDeviceProfile.getDeviceProfile() != null) {
                                                                                                    NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
                                                                                                    kotlin.jvm.internal.h.a((Object) deviceProfile, "NexEditorDeviceProfile.getDeviceProfile()");
                                                                                                    if (deviceProfile.getVideoRecordingMode() == NexEditorDeviceProfile.MediaRecordingMode.Disable) {
                                                                                                        View view17 = this.o;
                                                                                                        if (view17 != null) {
                                                                                                            View findViewById3 = view17.findViewById(R.id.camcorder_button_holder);
                                                                                                            kotlin.jvm.internal.h.a((Object) findViewById3, "contentView!!.findViewBy….camcorder_button_holder)");
                                                                                                            findViewById3.setEnabled(false);
                                                                                                            View view18 = this.o;
                                                                                                            if (view18 != null) {
                                                                                                                View findViewById4 = view18.findViewById(R.id.camcorder_icon);
                                                                                                                kotlin.jvm.internal.h.a((Object) findViewById4, "contentView!!.findViewBy…iew>(R.id.camcorder_icon)");
                                                                                                                findViewById4.setEnabled(false);
                                                                                                                View view19 = this.o;
                                                                                                                if (view19 == null) {
                                                                                                                    kotlin.jvm.internal.h.a();
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                View findViewById5 = view19.findViewById(R.id.camcorder_tv);
                                                                                                                kotlin.jvm.internal.h.a((Object) findViewById5, "contentView!!.findViewBy…<View>(R.id.camcorder_tv)");
                                                                                                                findViewById5.setEnabled(false);
                                                                                                            } else {
                                                                                                                kotlin.jvm.internal.h.a();
                                                                                                                throw null;
                                                                                                            }
                                                                                                        } else {
                                                                                                            kotlin.jvm.internal.h.a();
                                                                                                            throw null;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                if (NexEditorDeviceProfile.getDeviceProfile() != null) {
                                                                                                    NexEditorDeviceProfile deviceProfile2 = NexEditorDeviceProfile.getDeviceProfile();
                                                                                                    kotlin.jvm.internal.h.a((Object) deviceProfile2, "NexEditorDeviceProfile.getDeviceProfile()");
                                                                                                    if (deviceProfile2.getImageRecordingMode() == NexEditorDeviceProfile.MediaRecordingMode.Disable) {
                                                                                                        View view20 = this.o;
                                                                                                        if (view20 != null) {
                                                                                                            View findViewById6 = view20.findViewById(R.id.camera_button_holder);
                                                                                                            kotlin.jvm.internal.h.a((Object) findViewById6, "contentView!!.findViewBy….id.camera_button_holder)");
                                                                                                            findViewById6.setEnabled(false);
                                                                                                            View view21 = this.o;
                                                                                                            if (view21 != null) {
                                                                                                                View findViewById7 = view21.findViewById(R.id.camera_icon);
                                                                                                                kotlin.jvm.internal.h.a((Object) findViewById7, "contentView!!.findViewById<View>(R.id.camera_icon)");
                                                                                                                findViewById7.setEnabled(false);
                                                                                                                View view22 = this.o;
                                                                                                                if (view22 == null) {
                                                                                                                    kotlin.jvm.internal.h.a();
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                View findViewById8 = view22.findViewById(R.id.camera_tv);
                                                                                                                kotlin.jvm.internal.h.a((Object) findViewById8, "contentView!!.findViewById<View>(R.id.camera_tv)");
                                                                                                                findViewById8.setEnabled(false);
                                                                                                            } else {
                                                                                                                kotlin.jvm.internal.h.a();
                                                                                                                throw null;
                                                                                                            }
                                                                                                        } else {
                                                                                                            kotlin.jvm.internal.h.a();
                                                                                                            throw null;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                View view23 = this.o;
                                                                                                if (view23 != null) {
                                                                                                    View findViewById9 = view23.findViewById(R.id.btn_itemstore);
                                                                                                    kotlin.jvm.internal.h.a((Object) findViewById9, "contentView!!.findViewBy…View>(R.id.btn_itemstore)");
                                                                                                    findViewById9.setVisibility(0);
                                                                                                    return this.o;
                                                                                                }
                                                                                                kotlin.jvm.internal.h.a();
                                                                                                throw null;
                                                                                            }
                                                                                            kotlin.jvm.internal.h.a();
                                                                                            throw null;
                                                                                        }
                                                                                        kotlin.jvm.internal.h.a();
                                                                                        throw null;
                                                                                    }
                                                                                    kotlin.jvm.internal.h.a();
                                                                                    throw null;
                                                                                }
                                                                                kotlin.jvm.internal.h.a();
                                                                                throw null;
                                                                            }
                                                                            throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity");
                                                                        }
                                                                        kotlin.jvm.internal.h.a();
                                                                        throw null;
                                                                    }
                                                                    kotlin.jvm.internal.h.a();
                                                                    throw null;
                                                                }
                                                                kotlin.jvm.internal.h.a();
                                                                throw null;
                                                            }
                                                            kotlin.jvm.internal.h.a();
                                                            throw null;
                                                        }
                                                        kotlin.jvm.internal.h.a();
                                                        throw null;
                                                    }
                                                    kotlin.jvm.internal.h.a();
                                                    throw null;
                                                }
                                                kotlin.jvm.internal.h.a();
                                                throw null;
                                            }
                                            kotlin.jvm.internal.h.a();
                                            throw null;
                                        }
                                        kotlin.jvm.internal.h.a();
                                        throw null;
                                    }
                                    kotlin.jvm.internal.h.a();
                                    throw null;
                                }
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.o = null;
        this.n = null;
        this.p = false;
        this.r = true;
        requireFragmentManager().removeOnBackStackChangedListener(this);
        super.onDestroyView();
        z();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        Log.d(l, "onPause");
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        kotlin.jvm.internal.h.b(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        kotlin.jvm.internal.h.b(iArr, "grantResults");
        this.r = true;
        this.p = false;
        if (com.nexstreaming.kinemaster.ui.e.b.a(xa(), strArr, iArr)) {
            q(i);
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        Log.d(l, "onResume");
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        this.r = true;
        Log.d(l, "onStart");
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        Log.d(l, "onStop");
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_play_pause, R.drawable.action_play_pause, R.id.action_expand_preview, R.drawable.action_inset_preview);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void z() {
        HashMap hashMap = this.E;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1976p
    public boolean h(int i) {
        WeakReference<Dialog> weakReference;
        if (i != R.id.action_settings) {
            return false;
        }
        if (za() && (weakReference = this.z) != null) {
            if (weakReference != null) {
                Dialog dialog = weakReference.get();
                if (dialog != null && (dialog instanceof LayerSubMenuPopup)) {
                    return true;
                }
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
        this.B = true;
        return false;
    }

    private final com.nexstreaming.kinemaster.ui.a.e b(String[] strArr) {
        if (this.A == null) {
            e.a a2 = com.nexstreaming.kinemaster.ui.e.b.a(xa(), strArr, Ed.f21829a);
            a2.a(new Fd(this));
            this.A = a2.a();
        }
        return this.A;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity.b
    public void a(ProjectEditActivity projectEditActivity) {
        kotlin.jvm.internal.h.b(projectEditActivity, "activity");
        if (this.o == null) {
            return;
        }
        boolean k = projectEditActivity.k(R.id.action_play_pause);
        boolean j = projectEditActivity.j(R.id.action_play_pause);
        View view = this.o;
        if (view != null) {
            View findViewById = view.findViewById(R.id.btn_playpause);
            kotlin.jvm.internal.h.a((Object) findViewById, "playPauseButton");
            findViewById.setEnabled(k);
            findViewById.setActivated(j);
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    private final void a(Dialog dialog) {
        this.z = new WeakReference<>(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String[] strArr) {
        int i;
        if (Arrays.equals(strArr, com.nexstreaming.kinemaster.ui.e.b.f21565c)) {
            i = 8210;
        } else if (Arrays.equals(strArr, com.nexstreaming.kinemaster.ui.e.b.f21564b)) {
            i = 8209;
        } else {
            i = Arrays.equals(strArr, com.nexstreaming.kinemaster.ui.e.b.f21566d) ? 8208 : -1;
        }
        if (Build.VERSION.SDK_INT >= 23 && !com.nexstreaming.kinemaster.ui.e.b.a((Context) xa(), strArr)) {
            if (ya()) {
                com.nexstreaming.kinemaster.ui.e.c.f21570b.a(strArr).a(xa(), new Dd(this, i), true);
            } else if (!com.nexstreaming.kinemaster.ui.e.b.a((Activity) xa(), strArr)) {
                com.nexstreaming.kinemaster.ui.a.e b2 = b(strArr);
                if (b2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                b2.show();
            } else {
                com.nexstreaming.kinemaster.ui.e.b.a(this, strArr, i);
            }
            this.r = true;
            return;
        }
        q(i);
    }
}

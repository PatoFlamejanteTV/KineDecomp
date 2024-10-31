package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import c.d.b.b.d;
import com.crashlytics.android.Crashlytics;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.gson.Gson;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.nexasset.assetpackage.ItemRatioType;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C1709m;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.general.util.u;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.AdManager;
import com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider;
import com.nexstreaming.kinemaster.ad.providers.AdmobNativeUnifiedAdProvider;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdManager;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider;
import com.nexstreaming.kinemaster.codeccaps.C1715c;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediaprep.C1803a;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepState;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.mediabrowser.C1829g;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView;
import com.nexstreaming.kinemaster.ui.settings.C2202xa;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;
import com.nexstreaming.kinemaster.ui.widget.PopoutListMenu;
import com.nexstreaming.kinemaster.ui.widget.ShutterView;
import com.nexstreaming.kinemaster.usage.analytics.ApplyBackEvent;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.InterfaceC2301ca;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexeditorui.ProjectAspectRatio;
import com.nextreaming.nexeditorui.WhichTimeline;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexThemeView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ProjectEditActivity extends com.nextreaming.nexeditorui.I implements VideoEditor.e, VideoEditor.g, VideoEditor.f, com.nexstreaming.kinemaster.ui.mediabrowser.T, InterfaceC2301ca, FragmentManager.OnBackStackChangedListener, VideoEditor.i, VideoEditor.h, MediaPrepManager.a, tb.a, tb.b, C2202xa.c, d.a, com.nexstreaming.app.general.iab.a.a {
    private static boolean H = false;
    private ShutterView Aa;
    private View Ba;
    private RelativeLayout Ca;
    private RelativeLayout Da;
    private View I;
    private LinearLayout J;
    private LinearLayout K;
    private FrameLayout L;
    private VideoEditor M;
    private File N;
    private RelativeLayout O;
    private NexThemeView P;
    private NexThemeView Q;
    private NexThemeView R;
    private View S;
    private com.nexstreaming.kinemaster.ui.projectgallery.O Sa;
    private InterfaceC2025f T;
    private Toast Ta;
    private BannerTimelineView U;
    private View V;
    private ImageButton X;
    private com.nexstreaming.kinemaster.ui.a.r Xa;
    private ImageView Y;
    TimelineActionButtonMode Za;
    private boolean ba;
    private boolean ca;
    private boolean da;
    private boolean ea;
    private boolean fa;
    private boolean ga;
    private boolean ha;
    private int ia;
    private Runnable ib;
    private int ja;
    private View ka;
    private int la;
    private int ma;
    private float pa;
    private float qa;
    private float ra;
    private float sa;
    private WeakReference<InterfaceC1866cf> ta;
    private WeakReference<PopoutListMenu> ua;
    private InterfaceC1866cf va;
    private MediaPrepManager ya;
    private boolean za;
    private boolean W = true;
    private com.nexstreaming.app.general.util.z Z = new com.nexstreaming.app.general.util.z();
    private com.nexstreaming.app.general.util.z aa = new com.nexstreaming.app.general.util.z();
    private Handler na = new Handler();
    private com.nexstreaming.app.general.util.u<Tb> oa = new com.nexstreaming.app.general.util.u<>();
    private List<d> wa = new ArrayList();
    private boolean xa = false;
    private boolean Ea = false;
    private int Fa = -1;
    private boolean Ga = false;
    private boolean Ha = false;
    private int Ia = -1;
    private int Ja = 0;
    private String Ka = null;
    private long La = 0;
    private boolean Ma = false;
    private int Na = 0;
    private boolean Oa = false;
    private boolean Pa = false;
    private int Qa = 80;
    private boolean Ra = false;
    private com.nexstreaming.kinemaster.ui.a.t Ua = null;
    private BroadcastReceiver Va = new C1964nf(this);
    private boolean Wa = false;
    private com.nexstreaming.app.general.util.u<c> Ya = new com.nexstreaming.app.general.util.u<>();
    private VideoEditor.State _a = VideoEditor.State.Idle;
    private boolean ab = false;
    private View bb = null;
    private long cb = 0;
    private AtomicBoolean db = new AtomicBoolean(false);
    private Runnable eb = new RunnableC2058vf(this);
    private boolean fb = false;
    private boolean gb = false;
    private View.OnTouchListener hb = new ViewOnTouchListenerC1858bg(this);
    private TimelineView.d jb = new C1947lg(this);
    private Runnable kb = new RunnableC1974og(this);
    private Runnable lb = new RunnableC1983pg(this);
    private TencentAdListener.NativeExpressAdListener mb = new C2059vg(this);

    /* loaded from: classes2.dex */
    public enum InsertPosition {
        BeforeSelected,
        AfterSelected,
        CurrentTime
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum TimelineActionButtonMode {
        SecondaryItemSelected,
        SecondaryItemSelectedWithExpanded,
        NoItemSelectedScrolledToStart,
        NoItemSelectedScrolledToMid,
        NoItemSelectedScrolledToStartExpanded,
        NoItemSelectedScrolledToMidExpanded
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends View {
        public a(Context context) {
            super(context);
            setBackgroundColor(getResources().getColor(R.color.pedit_background_color));
            setLayoutParams(new LinearLayout.LayoutParams(-1, 1, 0.0f));
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(ProjectEditActivity projectEditActivity);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(VideoEditor videoEditor, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        final int f22025a;

        /* renamed from: b, reason: collision with root package name */
        final int f22026b;

        /* renamed from: c, reason: collision with root package name */
        final int f22027c;

        /* synthetic */ d(int i, int i2, int i3, C1964nf c1964nf) {
            this(i, i2, i3);
        }

        private d(int i, int i2, int i3) {
            this.f22025a = i;
            this.f22026b = i2;
            this.f22027c = i3;
        }
    }

    private ItemRatioType Aa() {
        float l = EditorGlobal.l();
        if (l == 0.5625f) {
            return ItemRatioType.RATIO_9v16;
        }
        if (l == 1.0f) {
            return ItemRatioType.RATIO_1v1;
        }
        return ItemRatioType.RATIO_16v9;
    }

    private void Ba() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Q.getLayoutParams();
        ImageButton imageButton = (ImageButton) findViewById(R.id.expendContractView);
        if (EditorGlobal.l() == 1.7777778f) {
            imageButton.setVisibility(8);
            this.Ra = false;
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.pedit_timeline_preview_view_16_9);
        } else if (EditorGlobal.l() == 1.0f) {
            imageButton.setVisibility(0);
            this.Ra = false;
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.pedit_timeline_preview_view_1_1);
        } else {
            imageButton.setVisibility(0);
            this.Ra = false;
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.pedit_timeline_preview_view_9_16);
        }
        this.Q.setLayoutParams(layoutParams);
    }

    private void Ca() {
        this.M.b((VideoEditor.e) this);
        this.M.b((VideoEditor.g) this);
        this.M.b((VideoEditor.f) this);
        this.M.b((VideoEditor.i) this);
        this.M.b((VideoEditor.h) this);
        this.M.a((VideoEditor.e) this);
        this.M.a((VideoEditor.g) this);
        this.M.a((VideoEditor.f) this);
        this.M.a((VideoEditor.i) this);
        this.M.a((VideoEditor.h) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da() {
        new Handler().postDelayed(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.projectedit.c
            @Override // java.lang.Runnable
            public final void run() {
                ProjectEditActivity.this.ra();
            }
        }, 500L);
    }

    private void Ea() {
        if (this.T instanceof UniformTimelineView) {
            if (oa()) {
                a(new int[]{R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_multi_select, R.drawable.icon_multi_select_normal, R.id.action_expand_preview, R.drawable.action_inset_preview}, (InterfaceC1976p) null);
                m(0);
                d(R.id.action_multi_select);
                this.T.d();
                this.T.invalidate();
                this.T.b();
                f(true);
                return;
            }
            m(R.id.editmode_multi_select);
            c(R.id.action_multi_select);
            this.T.invalidate();
            f(true);
            a(getSupportFragmentManager().beginTransaction()).replace(R.id.iconOptionPanelHolder, new Qb()).addToBackStack(Qb.class.getSimpleName()).commit();
            this.T.b();
        }
    }

    private void Fa() {
        com.nexstreaming.kinemaster.ui.a.t tVar;
        if (this.Ua == null) {
            this.Ua = new com.nexstreaming.kinemaster.ui.a.t(this);
        }
        if (isFinishing() || (tVar = this.Ua) == null || tVar.isShowing()) {
            return;
        }
        this.Ua.a(60000L);
        this.Ua.show();
    }

    private void Ga() {
        this.P.removeCallbacks(this.eb);
        this.P.post(this.eb);
    }

    private void Ha() {
        Ia();
        if (this.Y.getVisibility() == 0) {
            p(this.Qa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ia() {
        if (C()) {
            this.X.setVisibility(8);
            this.Y.setVisibility(8);
            return;
        }
        if (B() == null) {
            this.X.setVisibility(8);
            this.Y.setVisibility(8);
            return;
        }
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f == null || interfaceC2025f.getTimeline() == null) {
            return;
        }
        if (this.T.getTimeline().getPrimaryItemCount() <= 0 && this.Ja <= 0) {
            this.X.setVisibility(8);
            this.Y.setVisibility(8);
            return;
        }
        this.X.setVisibility(0);
        this.Y.setVisibility(0);
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            this.X.setVisibility(8);
        } else {
            this.X.setVisibility(0);
        }
        this.Ja = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NexTimelineItem nexTimelineItem, boolean z) {
    }

    private static int q(int i) {
        switch (i) {
            case R.id.action_align_center_horizontal /* 2131361824 */:
                return R.drawable.action_center_horizontally;
            case R.id.action_align_center_vertical /* 2131361825 */:
                return R.drawable.action_center_vertically;
            case R.id.action_bring_forward /* 2131361835 */:
                return R.drawable.action_bring_to_forward;
            case R.id.action_bring_to_front /* 2131361836 */:
                return R.drawable.action_bring_to_front;
            case R.id.action_capture /* 2131361837 */:
                return R.drawable.action_icon_capture;
            case R.id.action_capture_add_layer /* 2131361838 */:
                return R.drawable.action_capture_add_layer;
            case R.id.action_capture_insert_left /* 2131361839 */:
                return R.drawable.action_capture_insert_left;
            case R.id.action_capture_insert_right /* 2131361840 */:
                return R.drawable.action_capture_insert_right;
            case R.id.action_capture_save /* 2131361841 */:
                return R.drawable.action_capture_save;
            case R.id.action_duplicate_clip /* 2131361849 */:
                return R.drawable.action_duplicate_to_right_side;
            case R.id.action_duplicate_clip_as_layer /* 2131361850 */:
                return R.drawable.action_duplicate_as_layer;
            case R.id.action_redo /* 2131361866 */:
                return R.drawable.action_icon_redo;
            case R.id.action_reverse_clip /* 2131361867 */:
                return R.drawable.action_reverse_clip;
            case R.id.action_send_backward /* 2131361870 */:
                return R.drawable.action_send_backward;
            case R.id.action_send_to_back /* 2131361871 */:
                return R.drawable.action_send_to_back;
            case R.id.action_undo /* 2131361878 */:
                return R.drawable.action_icon_undo;
            default:
                return 0;
        }
    }

    private static int r(int i) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        View findViewById = findViewById(R.id.previewViewLayout);
        View findViewById2 = findViewById(R.id.bookmarkViewHolder);
        if (this.Ra) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.pedit_big_option_panel_width);
            View findViewById3 = findViewById(R.id.optionPanelHolder);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById3.getLayoutParams();
            layoutParams.width = dimensionPixelOffset;
            findViewById3.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.T.getLayoutParams();
            layoutParams2.addRule(1, 0);
            layoutParams2.width = dimensionPixelOffset;
            this.T.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams3.addRule(1, 0);
            layoutParams3.width = dimensionPixelOffset;
            layoutParams3.height = getResources().getDimensionPixelOffset(R.dimen.timeline3_ctsBoxHeight);
            findViewById2.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams4.height = -1;
            layoutParams4.bottomMargin = 0;
            layoutParams4.addRule(2, 0);
            findViewById.setLayoutParams(layoutParams4);
        } else {
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.pedit_option_panel_width);
            View findViewById4 = findViewById(R.id.optionPanelHolder);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById4.getLayoutParams();
            layoutParams5.width = dimensionPixelOffset2;
            findViewById4.setLayoutParams(layoutParams5);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.T.getLayoutParams();
            layoutParams6.addRule(1, R.id.timelineActionBar);
            layoutParams6.width = -1;
            this.T.setLayoutParams(layoutParams6);
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams7.addRule(1, R.id.timelineActionBar);
            layoutParams7.width = -1;
            layoutParams7.height = getResources().getDimensionPixelOffset(R.dimen.timeline3_ctsBoxHeight);
            findViewById2.setLayoutParams(layoutParams7);
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams8.height = -1;
            layoutParams8.bottomMargin = layoutParams6.height + layoutParams6.bottomMargin + layoutParams6.topMargin;
            layoutParams8.addRule(2, 0);
            findViewById.setLayoutParams(layoutParams8);
        }
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1937kf(this, findViewById));
        findViewById.requestLayout();
        findViewById(R.id.assetItemPreviewHolder).requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa() {
        MediaPrepManager mediaPrepManager;
        if (ja().s() == null || (mediaPrepManager = this.ya) == null) {
            return;
        }
        mediaPrepManager.a(ja().s().a());
    }

    private void ya() {
        com.nexstreaming.kinemaster.ui.a.t tVar;
        if (isFinishing() || (tVar = this.Ua) == null || !tVar.isShowing()) {
            return;
        }
        this.Ua.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void za() {
        NexLayerItem.b bVar;
        int i;
        if (this.T.getSelectedItem() == null || !(this.T.getSelectedItem() instanceof NexVideoClipItem)) {
            return;
        }
        NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) this.T.getSelectedItem();
        int i2 = 0;
        VideoLayer videoLayer = null;
        if (nexVideoClipItem.isImage()) {
            ImageLayer fromVideoClipItem = ImageLayer.fromVideoClipItem(nexVideoClipItem);
            fromVideoClipItem.setStartTime(nexVideoClipItem.getAbsStartTime());
            fromVideoClipItem.setEndTime(nexVideoClipItem.getEndOverlap() <= 0 ? nexVideoClipItem.getAbsEndTime() - 1 : nexVideoClipItem.getAbsEndTime());
            fromVideoClipItem.setEndTrim(nexVideoClipItem.getTrimTimeEnd());
            fromVideoClipItem.setStartTrim(nexVideoClipItem.getTrimTimeStart());
            bVar = fromVideoClipItem.getClosestKeyframe(0.0f);
            fromVideoClipItem.setMediaPath(nexVideoClipItem.getMediaPath(), u());
            i2 = fromVideoClipItem.getHeight();
            i = fromVideoClipItem.getWidth();
            videoLayer = fromVideoClipItem;
        } else if (nexVideoClipItem.isVideo()) {
            VideoLayer fromVideoClipItem2 = VideoLayer.fromVideoClipItem(nexVideoClipItem);
            int absStartTime = nexVideoClipItem.getAbsStartTime();
            int absEndTime = nexVideoClipItem.getAbsEndTime();
            if (nexVideoClipItem.getPlaybackSpeed() != 100) {
                absEndTime = (((absEndTime - absStartTime) * nexVideoClipItem.getPlaybackSpeed()) / 100) + absStartTime;
            }
            if (nexVideoClipItem.getPlaybackSpeed() == 100 && nexVideoClipItem.getEndOverlap() <= 0) {
                absEndTime--;
            }
            fromVideoClipItem2.setStartTime(absStartTime);
            fromVideoClipItem2.setEndTime(absEndTime);
            fromVideoClipItem2.setEndTrim(nexVideoClipItem.getTrimTimeEnd());
            fromVideoClipItem2.setStartTrim(nexVideoClipItem.getTrimTimeStart());
            fromVideoClipItem2.setOrientation(MediaInfo.a(nexVideoClipItem.getMediaPath()).z());
            bVar = fromVideoClipItem2.getClosestKeyframe(0.0f);
            i2 = fromVideoClipItem2.getHeight();
            i = fromVideoClipItem2.getWidth();
            videoLayer = fromVideoClipItem2;
        } else {
            bVar = null;
            i = 0;
        }
        if (bVar == null || videoLayer == null) {
            return;
        }
        bVar.f20232c = EditorGlobal.n() / 2;
        bVar.f20233d = EditorGlobal.m() / 2;
        bVar.f20231b = 1.0f;
        bVar.f20234e = -nexVideoClipItem.getRotation();
        int n = (EditorGlobal.n() * 3) / 4;
        int m = (EditorGlobal.m() * 3) / 4;
        if ((bVar.f20234e / 90.0f) % 2.0f != 0.0f) {
            if (i2 > n) {
                bVar.f20231b = n / i2;
            }
            if (i > m) {
                bVar.f20231b = Math.min(bVar.f20231b, m / i);
            }
        } else {
            if (i > n) {
                bVar.f20231b = n / i;
            }
            if (i2 > m) {
                bVar.f20231b = Math.min(bVar.f20231b, m / i2);
            }
        }
        float f2 = bVar.f20231b;
        bVar.f20236g = f2;
        bVar.f20237h = f2;
        ja().a((NexLayerItem) videoLayer);
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap) {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(4096)) {
                    int currentTime = this.T.getCurrentTime() - 5000;
                    InterfaceC2025f interfaceC2025f = this.T;
                    if (currentTime <= 0) {
                        currentTime = 0;
                    }
                    interfaceC2025f.a(currentTime);
                    return true;
                }
                if (!keyEvent.hasModifiers(1)) {
                    return false;
                }
                int currentTime2 = this.T.getCurrentTime() - 100;
                InterfaceC2025f interfaceC2025f2 = this.T;
                if (currentTime2 <= 0) {
                    currentTime2 = 0;
                }
                interfaceC2025f2.a(currentTime2);
                return true;
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(4096)) {
                    int currentTime3 = this.T.getCurrentTime() + 5000;
                    InterfaceC2025f interfaceC2025f3 = this.T;
                    if (currentTime3 > interfaceC2025f3.getTimeline().getTotalTime()) {
                        currentTime3 = this.T.getTimeline().getTotalTime();
                    }
                    interfaceC2025f3.a(currentTime3);
                    return true;
                }
                if (!keyEvent.hasModifiers(1)) {
                    return false;
                }
                int currentTime4 = this.T.getCurrentTime() + 100;
                InterfaceC2025f interfaceC2025f4 = this.T;
                if (currentTime4 > interfaceC2025f4.getTimeline().getTotalTime()) {
                    currentTime4 = this.T.getTimeline().getTotalTime();
                }
                interfaceC2025f4.a(currentTime4);
                return true;
            }
            if (keyCode == 31) {
                if (this.da && this.K.isFocusableInTouchMode()) {
                    s(R.id.action_expand_timeline);
                }
                return true;
            }
            if (keyCode == 32) {
                if (this.Ma) {
                    return false;
                }
                NexTimelineItem selectedItem = this.T.getSelectedItem();
                if (selectedItem != null && L()) {
                    this.Ma = true;
                    j(selectedItem);
                    this.Ma = false;
                }
                return true;
            }
            if (keyCode == 34) {
                if (this.Ma) {
                    return false;
                }
                NexTimelineItem selectedItem2 = this.T.getSelectedItem();
                if (selectedItem2 != null && K()) {
                    this.Ma = true;
                    l(selectedItem2);
                    this.Ma = false;
                }
                return true;
            }
            if (keyCode == 47) {
                if (this.Ma) {
                    return false;
                }
                NexTimelineItem selectedItem3 = this.T.getSelectedItem();
                if (selectedItem3 != null && J()) {
                    this.Ma = true;
                    k(selectedItem3);
                    this.Ma = false;
                }
                return true;
            }
            if (keyCode == 62) {
                if (this.L.isFocusableInTouchMode()) {
                    s(R.id.action_play_pause);
                }
                return true;
            }
            if (keyCode != 67) {
                switch (keyCode) {
                    case 52:
                        if (!this.da && this.K.isFocusableInTouchMode()) {
                            s(R.id.action_expand_timeline);
                        }
                        return true;
                    case 53:
                        if (keyEvent.hasModifiers(4096)) {
                            H();
                        }
                        return true;
                    case 54:
                        if (keyEvent.hasModifiers(4096)) {
                            I();
                        }
                        return true;
                }
            }
            if (this.T.getSelectedIndex() > -1) {
                s(R.id.action_delete);
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public VideoEditor ja() {
        return this.M;
    }

    public void ka() {
        findViewById(R.id.assetItemPreviewHolder).setVisibility(8);
        z().a(this.P);
        ja().H();
    }

    public void la() {
        this.Aa.setVisibility(4);
    }

    public void ma() {
        this.T.b();
    }

    public boolean na() {
        return this.Pa;
    }

    public boolean oa() {
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f instanceof UniformTimelineView) {
            return ((UniformTimelineView) interfaceC2025f).J();
        }
        return false;
    }

    @Override // com.nextreaming.nexeditorui.I, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(ProjectEditActivity.class.getName());
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (oa()) {
            Ea();
            return;
        }
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f instanceof UniformTimelineView) {
            if (this.da && ((UniformTimelineView) interfaceC2025f).getSelectedTrack() == null) {
                c(false, true);
                return;
            }
        } else if (this.da) {
            c(false, true);
            return;
        }
        this.La = System.nanoTime();
        if (this.Pa) {
            return;
        }
        if (getSupportFragmentManager().findFragmentById(android.R.id.content) != null && (getSupportFragmentManager().findFragmentById(android.R.id.content) instanceof com.nexstreaming.kinemaster.ui.settings.tb)) {
            com.nexstreaming.kinemaster.usage.analytics.f.a("Close");
            String z = ((com.nexstreaming.kinemaster.ui.settings.tb) getSupportFragmentManager().findFragmentById(android.R.id.content)).z();
            i(true);
            c(z);
            return;
        }
        ja().M();
        this.Na = 0;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
        if (findFragmentById == null) {
            findFragmentById = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
        }
        com.nexstreaming.kinemaster.usage.analytics.i.a(this.T.getSelectedItem(), findFragmentById, ApplyBackEvent.SYTEM_BACK);
        if (findFragmentById instanceof Xb) {
            if (!C()) {
                Fa.a selectedItem = this.T.getSelectedItem();
                if (selectedItem instanceof NexTimelineItem.c) {
                    if (((NexTimelineItem.c) selectedItem).getBlendMode().getPaidType() == IABManager.BillingType.PREMIUM) {
                        a("blending", "Blending");
                        return;
                    } else {
                        ja().J();
                        super.onBackPressed();
                        return;
                    }
                }
                super.onBackPressed();
                return;
            }
            ja().J();
            super.onBackPressed();
            return;
        }
        super.onBackPressed();
    }

    @Override // android.support.v4.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        WeakReference<PopoutListMenu> weakReference;
        ja().M();
        if (!this.ca && getSupportFragmentManager().getBackStackEntryCount() < 1) {
            this.ta = null;
            this.T.d();
        }
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
        if (findFragmentById != null && getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder) != null) {
            Fragment findFragmentById2 = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
            if (!(findFragmentById2 instanceof Bd) && (findFragmentById2 instanceof Bg)) {
                this.ab = true;
            }
        }
        if (findFragmentById != null && findFragmentById.isRemoving()) {
            findFragmentById = null;
        }
        if (findFragmentById == null) {
            findFragmentById = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
            if (this.ab && findFragmentById != null && !(findFragmentById instanceof Bd) && (findFragmentById instanceof Bg) && findFragmentById.isAdded()) {
                ((Bg) findFragmentById).na();
            }
            this.ab = false;
        }
        if (findFragmentById != null && !(findFragmentById instanceof Bd) && (findFragmentById instanceof Bg) && this.T.getSelectedItem() != null && findFragmentById.isAdded()) {
            Bg bg = (Bg) findFragmentById;
            if (bg.Y() != this.T.getSelectedItem() && this.T.getSelectedItem().getClass() == bg.Z()) {
                bg.a((Bg) this.T.getSelectedItem());
                bg.na();
            }
        }
        if (getSupportFragmentManager().getBackStackEntryCount() < 1 && (weakReference = this.ua) != null) {
            PopoutListMenu popoutListMenu = weakReference.get();
            if (popoutListMenu != null) {
                popoutListMenu.a();
            }
            this.ua = null;
        }
        if (this.ja != 0 && this.T.getWidth() != this.ja && !pa()) {
            ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
            layoutParams.width = this.ja;
            this.T.setLayoutParams(layoutParams);
            this.ja = 0;
        }
        Fragment fragment = getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getFragments().size() - 1);
        if (!(fragment instanceof C2202xa) && !(fragment instanceof C1829g) && !(fragment instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a) && !(fragment instanceof com.nexstreaming.kinemaster.ui.settings.tb)) {
            if (fragment.getClass().getSuperclass().getSimpleName().equals("AssetBrowserBaseFragment")) {
                b(false, true);
            } else {
                b(true, true);
            }
        } else {
            b(false, false);
        }
        if (u().getCurrentFocus() != null) {
            u().getCurrentFocus().clearFocus();
        }
        va();
        Ia();
        x(!y().t());
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            Ha();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        MediaStore.a(this);
        setContentView(R.layout.project_editor_activity);
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        C1715c.b();
        NexEditorDeviceProfile.getDeviceProfile().registerFirebaseAnalytics(z());
        this.Ga = true;
        this.ya = new MediaPrepManager(this, W(), ba().needsFaceDetection());
        this.ya.a(this);
        this.I = findViewById(android.R.id.content);
        this.O = (RelativeLayout) findViewById(R.id.previewViewHolder);
        this.P = (NexThemeView) findViewById(R.id.previewView);
        this.Q = (NexThemeView) findViewById(R.id.previewViewForExpanded);
        this.R = (NexThemeView) findViewById(R.id.effectPreview);
        this.M = new VideoEditor(z(), this, false, this.P);
        Ca();
        this.J = (LinearLayout) findViewById(R.id.projectActionBar);
        this.K = (LinearLayout) findViewById(R.id.timelineActionBar);
        this.L = (FrameLayout) findViewById(R.id.optionPanelHolder);
        this.ka = findViewById(R.id.layoutExpanded);
        this.Aa = (ShutterView) findViewById(R.id.shutter_view);
        this.T = (InterfaceC2025f) findViewById(R.id.timeline);
        this.T.setVisibility(8);
        this.T.setListener(this.jb);
        this.T.setMediaPrepManager(this.ya);
        this.T.setImageWorker(getSupportFragmentManager());
        this.T.setEditor(this.M);
        this.V = findViewById(R.id.timelineGuideLayout);
        this.Ba = findViewById(R.id.bookmark);
        this.Ca = (RelativeLayout) findViewById(R.id.bookmarkViewHolder);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.optionPanelHolder, new Bd()).commit();
        }
        this.Da = (RelativeLayout) findViewById(R.id.previewViewLayout);
        this.J.startAnimation(AnimationUtils.loadAnimation(this, R.anim.projevct_action_bar_translate));
        this.K.startAnimation(AnimationUtils.loadAnimation(this, R.anim.project_bottom_view_translate));
        e(R.id.action_change_theme);
        e(R.id.action_share);
        this.T.startAnimation(AnimationUtils.loadAnimation(this, R.anim.project_bottom_view_translate));
        findViewById(R.id.optionPanelHolder).startAnimation(AnimationUtils.loadAnimation(this, R.anim.project_option_panel_translate));
        this.Da.startAnimation(AnimationUtils.loadAnimation(this, R.anim.project_preview_scale));
        byte[] bArr = com.nexstreaming.app.kinemasterfree.a.f19911a;
        String t = KineMasterApplication.f24056d.t();
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if ((t.charAt(i2) * '!') % 128 != bArr[i2]) {
                i++;
            }
        }
        if (i > 0) {
            String str = "package=" + getPackageName();
            H = true;
            if (EditorGlobal.p) {
                Crashlytics.log("SA " + str);
            }
        }
        this.P.setOnTouchListener(new ViewOnTouchListenerC2092zg(this));
        this.X = (ImageButton) findViewById(R.id.removeWatermarkBtn);
        this.Y = (ImageView) findViewById(R.id.removeWatermarkView);
        this.P.getViewTreeObserver().addOnGlobalLayoutListener(new Ag(this));
        this.X.setOnClickListener(new ViewOnClickListenerC1875df(this));
        if (bundle != null) {
            int i3 = bundle.getInt("SAVE_SELECTED_ITEM_INDEX");
            this.Ja = bundle.getInt("SAVE_PRIMARY_ITEM_COUNT");
            if (i3 >= 0) {
                this.Ia = i3;
                boolean z = bundle.getBoolean("SAVE_PRIMARY_ITEM");
                boolean z2 = bundle.getBoolean("SAVE_SECONDARY_ITEM");
                if (z) {
                    this.Ha = true;
                } else if (z2) {
                    this.Ha = false;
                }
            }
        }
        Task d2 = d(getIntent());
        if (bundle == null && d2 != null && getIntent() != null && getIntent() != null && getIntent().getExtras() != null) {
            d2.onComplete(new C1884ef(this));
        }
        this.Ba.setOnClickListener(new ViewOnClickListenerC1893ff(this));
        this.Ba.setOnLongClickListener(new ViewOnLongClickListenerC1911hf(this));
        a(R.id.action_expand_timeline, R.drawable.action_icon_expand_timeline, R.id.action_seek_to_start, R.drawable.action_icon_seek_to_start);
        if (ja().w() == VideoEditor.State.Idle) {
            c(R.id.action_play_pause);
        }
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        this.Q.setOnTouchListener(this.hb);
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("com.nextreaming.kinemaster.asset.install.completed");
        intentFilter.addAction("com.nextreaming.kinemaster.asset.uninstall.completed");
        registerReceiver(this.Va, intentFilter);
        ja().c(false);
        ja().b(EditorGlobal.a("up"));
        this.Sa = new com.nexstreaming.kinemaster.ui.projectgallery.O(this, w());
        if (!C()) {
            this.U = (BannerTimelineView) findViewById(R.id.timeline);
            if (c.d.b.m.e.f3850a.a()) {
                TencentAdManager tencentAdManager = new TencentAdManager(this, this.mb, TencentAdProvider.Companion.getPE_UNIT_ID());
                tencentAdManager.setContainer();
                tencentAdManager.requestNativeExpressAd();
                this.U.setProvider(tencentAdManager.getTencentNativeExpressAdProvider());
            } else {
                AdManager.a(this).f(AdmobAdProvider.TIMELINE_AD_UNIT_ID);
                this.U.setProvider(AdManager.a(getApplicationContext()).b(AdmobNativeUnifiedAdProvider.class.getSimpleName()));
            }
        }
        Ba();
        ImageButton imageButton = (ImageButton) findViewById(R.id.expendContractView);
        imageButton.setOnClickListener(new Cif(this, imageButton));
        b(true, true);
        wa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        unregisterReceiver(this.Va);
        MediaPrepManager mediaPrepManager = this.ya;
        if (mediaPrepManager != null) {
            mediaPrepManager.b(this);
            this.ya.a();
            this.ya = null;
        }
        getSupportFragmentManager().removeOnBackStackChangedListener(this);
        this.Sa.b();
        y().b((com.nexstreaming.app.general.iab.a.a) this);
        com.nexstreaming.kinemaster.ui.a.r rVar = this.Xa;
        if (rVar != null && rVar.isShowing()) {
            this.Xa.dismiss();
            this.Xa = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (EditorGlobal.f24026e != EditorGlobal.VersionType.ShowDemo) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyEvent.isShiftPressed()) {
            i |= 16777216;
        }
        if (keyEvent.isAltPressed()) {
            i |= 33554432;
        }
        if (keyEvent.isCtrlPressed()) {
            i |= 67108864;
        }
        if (i != 30) {
            switch (i) {
                case 38:
                    if (this.fb) {
                        int currentTimeAndStopFling = this.T.getCurrentTimeAndStopFling();
                        NexTimeline a2 = ja().s().a();
                        int frameFromTime = a2.getFrameFromTime(currentTimeAndStopFling);
                        if (frameFromTime > 0) {
                            frameFromTime--;
                        }
                        this.T.a(a2.getTimeFromFrame(frameFromTime));
                    } else {
                        int r = ja().r();
                        if (r >= 0) {
                            ja().a(-25);
                        } else if (r > -50) {
                            ja().a(-50);
                        } else if (r > -100) {
                            ja().a(-100);
                        } else if (r > -150) {
                            ja().a(-150);
                        } else if (r > -200) {
                            ja().a(-200);
                        } else if (r > -400) {
                            ja().a(-400);
                        } else if (r > -800) {
                            ja().a(-800);
                        } else if (r > -1600) {
                            ja().a(-1600);
                        } else {
                            ja().M();
                        }
                    }
                    return true;
                case 39:
                    this.fb = true;
                    ja().M();
                    return true;
                case 40:
                    if (this.fb) {
                        int currentTimeAndStopFling2 = this.T.getCurrentTimeAndStopFling();
                        NexTimeline a3 = ja().s().a();
                        this.T.a(a3.getTimeFromFrame(a3.getFrameFromTime(currentTimeAndStopFling2) + 1));
                    } else {
                        int r2 = ja().r();
                        if (r2 <= 0) {
                            ja().a(25);
                        } else if (r2 < 50) {
                            ja().a(50);
                        } else if (r2 < 100) {
                            ja().a(100);
                        } else if (r2 < 150) {
                            ja().a(150);
                        } else if (r2 < 200) {
                            ja().a(200);
                        } else if (r2 < 400) {
                            ja().a(400);
                        } else if (r2 < 800) {
                            ja().a(800);
                        } else if (r2 < 1600) {
                            ja().a(SemanticAnnotations.SemanticType.ST_ANONYMOUS_DATA_VALUE);
                        } else {
                            ja().M();
                        }
                    }
                    return true;
                default:
                    return super.onKeyDown(i, keyEvent);
            }
        }
        this.T.getTimeline().toggleBookmark(ja().v());
        ja().J();
        this.T.invalidate();
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 39) {
            return super.onKeyUp(i, keyEvent);
        }
        this.fb = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.app.Activity
    public void onRestart() {
        this.M.F();
        Ca();
        if (this.da && this.ea) {
            z().a(this.Q);
        } else {
            z().a(this.P);
        }
        MediaInfo.k();
        ja().b(ja().v());
        ja().H();
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Crashlytics.log("ProjectEditActivity::onResume");
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        super.onResume();
        if (this.Oa) {
            this.Oa = false;
            InterfaceC2025f interfaceC2025f = this.T;
            if (interfaceC2025f != null) {
                interfaceC2025f.d();
            }
        }
        if ((getApplicationInfo().flags & 2) != 0) {
            H = true;
            if (EditorGlobal.p) {
                Crashlytics.log("SA flag/d");
            }
        }
        NexThemeView nexThemeView = this.P;
        if (nexThemeView != null) {
            nexThemeView.post(this.lb);
        }
        View view = this.Ba;
        if (view != null) {
            view.postDelayed(this.kb, (long) ((Math.random() * 30000.0d) + 1000.0d));
        }
        ja().I();
        ja().b(ja().v());
        InterfaceC2025f interfaceC2025f2 = this.T;
        if (interfaceC2025f2 != null && interfaceC2025f2.getTimeline() != null) {
            x(!y().t());
            if (!this.T.getTimeline().checkResources(this) && this.T.getSelectedItem() != null && !this.T.getSelectedItem().checkResourceState(this)) {
                f(this.T.getSelectedItem());
            }
        }
        this.Qa = c.d.b.b.i.d().h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("SAVE_PRIMARY_ITEM_COUNT", this.T.getTimeline().getPrimaryItemCount());
            bundle.putInt("SAVE_SELECTED_ITEM_INDEX", this.T.getSelectedIndex());
            if (this.T.getSelectedItem() != null && (this.T.getSelectedItem() instanceof NexPrimaryTimelineItem)) {
                bundle.putBoolean("SAVE_PRIMARY_ITEM", true);
            } else if (this.T.getSelectedItem() != null && (this.T.getSelectedItem() instanceof NexSecondaryTimelineItem)) {
                bundle.putBoolean("SAVE_SECONDARY_ITEM", true);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        KMEvents.VIEW_EDIT.trackScreen(this);
        this.Ka = null;
        super.onStart();
        c.d.b.b.i.b().a((d.a) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Crashlytics.log("ProjectEditActivity::onStop");
        long nanoTime = (System.nanoTime() - this.La) / 1000000;
        if (this.Ka == null) {
            if (nanoTime < 1000) {
                this.Ka = "back button";
            } else {
                this.Ka = FacebookRequestErrorClassification.KEY_OTHER;
            }
        }
        this.T.getTimeline();
        try {
            new JSONObject().put("Preview Play Count", this.Na);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ja().M();
        this.Na = 0;
        c.d.b.b.i.b().b(this);
        y().a(IABBasePresent.State.NONE);
        y().b((com.nexstreaming.app.general.iab.a.a) this);
        super.onStop();
    }

    public boolean pa() {
        return this.da;
    }

    public /* synthetic */ void qa() {
        n(true);
    }

    public /* synthetic */ void ra() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
        if (findFragmentById == null) {
            findFragmentById = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
        }
        if (findFragmentById != null) {
            if (findFragmentById instanceof OptionCroppingFragment) {
                s(false);
                q(true);
                r(true);
            } else {
                s(true);
                q(true);
                r(true);
            }
        }
    }

    public void sa() {
        this.Ka = "exit button";
        finish();
    }

    public void ta() {
        if (ja() == null || ja().s() == null) {
            return;
        }
        ja().M();
        float f2 = getResources().getConfiguration().smallestScreenWidthDp;
        C2202xa c2202xa = new C2202xa();
        if (f2 >= 600.0f) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fullscreenFragmentHolder);
            if (findFragmentById == null || !((findFragmentById instanceof C1829g) || (findFragmentById instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a))) {
                View findViewById = findViewById(R.id.popupFragmentBackground);
                findViewById.setVisibility(0);
                findViewById.setBackgroundColor(getResources().getColor(R.color.toolbar_background_color));
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500L);
                findViewById.setOnTouchListener(new ViewOnTouchListenerC1992qg(this));
                findViewById.startAnimation(alphaAnimation);
                getSupportFragmentManager().beginTransaction().replace(R.id.popupFragmentHolder, c2202xa).addToBackStack("ProjectSettings").commit();
                return;
            }
            return;
        }
        Fragment findFragmentById2 = getSupportFragmentManager().findFragmentById(R.id.fullscreenFragmentHolder);
        if (findFragmentById2 == null || !((findFragmentById2 instanceof C1829g) || (findFragmentById2 instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a))) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fullscreenFragmentHolder, c2202xa).addToBackStack("ProjectSettings").commit();
        }
    }

    public void ua() {
        if (this.T.getSelectedItem() == null || !(this.T.getSelectedItem() instanceof NexTransitionItem)) {
            return;
        }
        DurationSpinner durationSpinner = (DurationSpinner) findViewById(R.id.durationSpinner);
        NexTransitionItem nexTransitionItem = (NexTransitionItem) this.T.getSelectedItem();
        if (nexTransitionItem.getEffectItemID().equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
            durationSpinner.setVisibility(4);
            return;
        }
        durationSpinner.setVisibility(0);
        float durationLimit = 30000 < nexTransitionItem.getDurationLimit() ? 30 : nexTransitionItem.getDurationLimit() / 1000;
        durationSpinner.setScrollMaxValue(durationLimit);
        durationSpinner.setMaxValue(durationLimit);
        durationSpinner.a(nexTransitionItem.getEffectDuration() / 1000.0f, false);
    }

    public void va() {
        TimelineActionButtonMode timelineActionButtonMode;
        if (ja() == null || ja().s() == null) {
            return;
        }
        NexTimelineItem selectedItem = this.T.getSelectedItem();
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
        if (findFragmentById != null && !findFragmentById.isRemoving() && findFragmentById.isVisible()) {
            if (!(findFragmentById instanceof com.nexstreaming.kinemaster.ui.assetbrowser.i) && !(findFragmentById instanceof com.nexstreaming.kinemaster.ui.d.h)) {
                f(R.id.action_expand_timeline);
            } else {
                e(R.id.action_expand_timeline);
            }
        } else {
            f(R.id.action_expand_timeline);
        }
        if (this.T.getTimeline().getPrimaryItemCount() < 1) {
            e(R.id.action_share);
            e(R.id.action_change_theme);
            e(R.id.action_play_pause);
            e(R.id.action_capture);
            v(false);
        } else {
            f(R.id.action_share);
            f(R.id.action_change_theme);
            f(R.id.action_play_pause);
            f(R.id.action_capture);
            v(true);
        }
        if (selectedItem == null) {
            if (ja().v() > ja().s().a().getTotalTime() - (this.T.getMSPerPixel() + 33)) {
                timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToMid;
                e(R.id.action_seek_to_end);
                f(R.id.action_seek_to_start);
            } else if (ja().v() > 10) {
                timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToMid;
                if (ja().w().isPlaying()) {
                    e(R.id.action_seek_to_end);
                    e(R.id.action_seek_to_start);
                } else {
                    f(R.id.action_seek_to_end);
                    f(R.id.action_seek_to_start);
                }
            } else {
                timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToStart;
                if (ja().w().isPlaying()) {
                    e(R.id.action_seek_to_end);
                    e(R.id.action_seek_to_start);
                } else {
                    f(R.id.action_seek_to_end);
                    e(R.id.action_seek_to_start);
                }
            }
        } else if (selectedItem instanceof NexSecondaryTimelineItem) {
            TimelineActionButtonMode timelineActionButtonMode2 = TimelineActionButtonMode.SecondaryItemSelected;
            e(R.id.action_seek_to_end);
            e(R.id.action_seek_to_start);
            if (this.da) {
                e(R.id.action_play_pause);
            }
            if (((NexSecondaryTimelineItem) selectedItem).getPinned()) {
                c(R.id.action_pin);
            } else {
                d(R.id.action_pin);
            }
            timelineActionButtonMode = timelineActionButtonMode2;
        } else if (selectedItem instanceof NexPrimaryTimelineItem) {
            e(R.id.action_seek_to_end);
            e(R.id.action_seek_to_start);
            if (this.da) {
                e(R.id.action_play_pause);
            }
            if (selectedItem instanceof NexTransitionItem) {
                e(R.id.action_expand_timeline);
            }
            timelineActionButtonMode = ja().v() > ja().s().a().getTotalTime() + (-33) ? TimelineActionButtonMode.NoItemSelectedScrolledToMid : ja().v() > 10 ? TimelineActionButtonMode.NoItemSelectedScrolledToMid : TimelineActionButtonMode.NoItemSelectedScrolledToStart;
        } else {
            timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToMid;
            e(R.id.action_seek_to_end);
            e(R.id.action_seek_to_start);
        }
        if (timelineActionButtonMode == TimelineActionButtonMode.NoItemSelectedScrolledToMid && this.da) {
            timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToMidExpanded;
        }
        if (timelineActionButtonMode == TimelineActionButtonMode.NoItemSelectedScrolledToStart && this.da) {
            timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToStartExpanded;
        }
        if (timelineActionButtonMode == TimelineActionButtonMode.SecondaryItemSelected && this.da) {
            timelineActionButtonMode = TimelineActionButtonMode.SecondaryItemSelectedWithExpanded;
        }
        if (timelineActionButtonMode != this.Za) {
            this.Za = timelineActionButtonMode;
            switch (C2068wg.f22757b[this.Za.ordinal()]) {
                case 1:
                    a(R.id.action_expand_timeline, R.drawable.action_icon_expand_timeline, R.id.action_seek_to_end, R.drawable.action_icon_seek_to_end);
                    return;
                case 2:
                    a(R.id.action_expand_timeline, R.drawable.action_collapse_timeline, R.id.action_seek_to_end, R.drawable.action_icon_seek_to_end);
                    return;
                case 3:
                    a(R.id.action_expand_timeline, R.drawable.action_icon_expand_timeline, R.id.action_pin, R.drawable.action_icon_pin);
                    return;
                case 4:
                    a(R.id.action_expand_timeline, R.drawable.action_collapse_timeline, R.id.action_pin, R.drawable.action_icon_pin);
                    return;
                case 5:
                    a(R.id.action_expand_timeline, R.drawable.action_collapse_timeline, R.id.action_seek_to_start, R.drawable.action_icon_seek_to_start);
                    return;
                case 6:
                    a(R.id.action_expand_timeline, R.drawable.action_icon_expand_timeline, R.id.action_seek_to_start, R.drawable.action_icon_seek_to_start);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final int i) {
        if (getResources() == null) {
            return;
        }
        final Configuration configuration = getResources().getConfiguration();
        if (configuration.screenWidthDp < configuration.screenHeightDp) {
            return;
        }
        this.I.post(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.projectedit.d
            @Override // java.lang.Runnable
            public final void run() {
                ProjectEditActivity.this.a(configuration, i);
            }
        });
    }

    private void v(boolean z) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
        if (findFragmentById instanceof Bd) {
            ((Bd) findFragmentById).o(z);
        }
    }

    private void w(boolean z) {
        if (z && this.ea) {
            if (C()) {
                ja().c(false);
                ja().b(EditorGlobal.a("up"));
            } else {
                ja().c(true);
                ja().b(EditorGlobal.a("std"));
            }
            z().a(this.Q);
            ja().H();
            this.P.setVisibility(8);
            this.Q.a(new Xf(this));
            this.na.postDelayed(new Yf(this), 50L);
            return;
        }
        z().a(this.P);
        ja().c(false);
        ja().b(EditorGlobal.a("up"));
        ja().H();
        this.P.setVisibility(0);
        this.P.a(new Zf(this));
        this.na.postDelayed(new RunnableC1849ag(this), 50L);
    }

    private void x(boolean z) {
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f != null) {
            interfaceC2025f.a(z, this);
            this.T.f();
            this.T.invalidate();
            this.T.b();
        }
    }

    public void H() {
        if (ja().w().isPlaying()) {
            ja().M().onComplete(new C2050ug(this));
        } else {
            ja().G();
        }
    }

    public void I() {
        if (ja().w().isPlaying()) {
            ja().M().onComplete(new C2018tg(this));
        } else {
            ja().O();
        }
    }

    public boolean J() {
        return this.T.a();
    }

    public boolean K() {
        return this.T.j();
    }

    public boolean L() {
        return this.T.h();
    }

    public void M() {
        TimelineView.d dVar = this.jb;
        if (dVar != null) {
            dVar.a();
        }
    }

    public boolean N() {
        if (!c.d.b.k.i.h()) {
            return false;
        }
        Toast toast = this.Ta;
        if (toast != null) {
            toast.cancel();
        }
        this.Ta = Toast.makeText(this, R.string.unavailable_busy_transcoding, 1);
        this.Ta.show();
        return true;
    }

    public void O() {
        this.T.i();
    }

    public void P() {
        NexTimelineItem selectedItem = this.T.getSelectedItem();
        if (selectedItem instanceof NexTransitionItem) {
            ((NexTransitionItem) selectedItem).clearTransitionEffect();
            ja().c(selectedItem);
            this.T.b(selectedItem);
        } else {
            ja().a(selectedItem);
        }
        this.T.d();
        ja().H();
        this.T.g();
        if (selectedItem instanceof NexPrimaryTimelineItem) {
            this.T.e();
        } else {
            this.T.invalidate();
        }
        this.T.b();
    }

    public void Q() {
        if ((this.T instanceof UniformTimelineView) && oa()) {
            for (com.nexstreaming.kinemaster.editorwrapper.Fa fa : X()) {
                if (fa instanceof NexTimelineItem) {
                    ja().a((NexTimelineItem) fa);
                }
            }
            this.T.d();
            ja().H();
            this.T.g();
            this.T.b();
        }
    }

    public void R() {
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f instanceof UniformTimelineView) {
            com.nexstreaming.kinemaster.editorwrapper.Ea selectedTrack = ((UniformTimelineView) interfaceC2025f).getSelectedTrack();
            Iterator<NexSecondaryTimelineItem> it = this.T.getTimeline().getSecondaryItemsByTrackId(selectedTrack.c()).iterator();
            while (it.hasNext()) {
                ja().a((NexTimelineItem) it.next());
            }
            this.T.getTimeline().removeTrack(selectedTrack.d());
            this.T.d();
            ja().H();
            this.T.g();
            this.T.invalidate();
            this.T.b();
        }
    }

    public int S() {
        return this.T.getCurrentTime();
    }

    public int T() {
        return this.T.getCurrentTimeAndStopFling();
    }

    public View U() {
        return this.ka;
    }

    public MediaPrepManager V() {
        return this.ya;
    }

    public MediaStore W() {
        return KineMasterApplication.f24056d.p();
    }

    public Set<com.nexstreaming.kinemaster.editorwrapper.Fa> X() {
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f instanceof UniformTimelineView) {
            return ((UniformTimelineView) interfaceC2025f).getSelectedItems();
        }
        return null;
    }

    public View Y() {
        return this.P;
    }

    public int Z() {
        NexThemeView nexThemeView = this.P;
        if (nexThemeView == null) {
            return 0;
        }
        return nexThemeView.getHeight();
    }

    public int aa() {
        NexThemeView nexThemeView = this.P;
        if (nexThemeView == null) {
            return 0;
        }
        return nexThemeView.getWidth();
    }

    public NexVideoClipItem.CropMode ba() {
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f != null && interfaceC2025f.getTimeline() != null) {
            return this.T.getTimeline().getProjectDefaultCropMode();
        }
        return NexVideoClipItem.CropMode.fromString(PreferenceManager.getDefaultSharedPreferences(this).getString("add_img_def_crop", NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE));
    }

    public int ca() {
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f != null && interfaceC2025f.getTimeline() != null) {
            return this.T.getTimeline().getProjectDefaultLayerDuration();
        }
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("add_layer_def_duration", "4500"));
    }

    public int da() {
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f != null && interfaceC2025f.getTimeline() != null) {
            return this.T.getTimeline().getProjectDefaultPhotoDuration();
        }
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("add_img_def_duration", "4500"));
    }

    public int ea() {
        return this.T.getTimeline().getTotalTime();
    }

    public SurfaceView fa() {
        return (SurfaceView) findViewById(R.id.scratchSurfaceView);
    }

    public int ga() {
        return this.ja;
    }

    public int ha() {
        return this.ma;
    }

    public InterfaceC2025f ia() {
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I
    public void j(boolean z) {
        if (Build.VERSION.SDK_INT < 23 || com.nexstreaming.kinemaster.ui.e.b.a((Context) this, com.nexstreaming.kinemaster.ui.e.b.f21563a)) {
            y().a(IABBasePresent.State.SEND_RESULT);
            super.j(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem != 0) {
            ((NexTimelineItem.u) nexTimelineItem).trimToRight(T());
            if (nexTimelineItem instanceof NexVideoClipItem) {
                m(false);
            }
            e(nexTimelineItem);
            c(nexTimelineItem);
        }
    }

    public void m(boolean z) {
        InterfaceC2025f interfaceC2025f = this.T;
        interfaceC2025f.a(interfaceC2025f.getSelectedItem(), z, false);
    }

    public int n(boolean z) {
        return this.T.a(z);
    }

    public void o(int i) {
        this.Aa.setVisibility(0);
    }

    public void q(boolean z) {
        a(this.J, z);
    }

    public void r(boolean z) {
        a(this.K, z);
    }

    public void s(boolean z) {
        this.T.setEnabled(z);
        this.Ba.setEnabled(z);
    }

    public void t(boolean z) {
        findViewById(R.id.assetItemPreviewHolder).setVisibility(0);
        z().a(this.R);
        if (z) {
            DurationSpinner durationSpinner = (DurationSpinner) findViewById(R.id.durationSpinner);
            ua();
            durationSpinner.setOnValueChangeListener(new C2076xg(this));
        } else {
            findViewById(R.id.durationSpinner).setVisibility(4);
        }
        z().a(new C2084yg(this));
        ja().H();
    }

    public void u(boolean z) {
        this.T.setSuppressScrollEvents(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(NexTimelineItem nexTimelineItem) {
        String effectItemID;
        com.nexstreaming.app.general.nexasset.assetpackage.r a2;
        if (nexTimelineItem == null || !(nexTimelineItem instanceof NexTransitionItem) || (effectItemID = ((NexTransitionItem) nexTimelineItem).getEffectItemID()) == null || effectItemID.compareTo("null") == 0 || effectItemID.compareTo(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE) == 0 || (a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(effectItemID)) == null) {
            return true;
        }
        Iterator<? extends com.nexstreaming.app.general.nexasset.assetpackage.r> it = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(a2.getAssetPackage().getAssetId(), a2.getCategory(), Aa()).iterator();
        while (it.hasNext()) {
            if (effectItemID.contains(it.next().getId())) {
                return true;
            }
        }
        return false;
    }

    public void e(int i) {
        if (this.Z.a(i)) {
            View findViewWithTag = this.J.findViewWithTag(Integer.valueOf(i));
            if (findViewWithTag == null) {
                findViewWithTag = this.K.findViewWithTag(Integer.valueOf(i));
            }
            if (findViewWithTag != null) {
                findViewWithTag.setEnabled(false);
            }
            Ga();
        }
    }

    public void f(int i) {
        if (this.Z.c(i)) {
            LinearLayout linearLayout = this.J;
            View findViewWithTag = linearLayout.findViewWithTag(Integer.valueOf(i));
            if (findViewWithTag == null) {
                linearLayout = this.K;
                findViewWithTag = linearLayout.findViewWithTag(Integer.valueOf(i));
            }
            if (findViewWithTag != null && linearLayout.isEnabled()) {
                findViewWithTag.setEnabled(true);
            }
            Ga();
        }
    }

    public void g(NexTimelineItem nexTimelineItem) {
        h(nexTimelineItem);
    }

    public void h(NexTimelineItem nexTimelineItem) {
        int endTrim;
        String str;
        int i;
        String str2;
        if (this.db.compareAndSet(false, true)) {
            if (nexTimelineItem instanceof NexVideoClipItem) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexTimelineItem;
                String mediaPath = nexVideoClipItem.getMediaPath();
                str = mediaPath;
                i = nexVideoClipItem.getTrimTimeStart();
                endTrim = nexVideoClipItem.getDuration() - nexVideoClipItem.getTrimTimeEnd();
                str2 = "primary";
            } else {
                if (!(nexTimelineItem instanceof VideoLayer)) {
                    return;
                }
                VideoLayer videoLayer = (VideoLayer) nexTimelineItem;
                String mediaPath2 = videoLayer.getMediaPath();
                int r = videoLayer.getMediaInfo().r();
                NexLayerItem nexLayerItem = (NexLayerItem) nexTimelineItem;
                int startTrim = nexLayerItem.getStartTrim();
                endTrim = r - nexLayerItem.getEndTrim();
                str = mediaPath2;
                i = startTrim;
                str2 = "layer";
            }
            String absolutePath = EditorGlobal.g(u()).getAbsolutePath();
            File externalCacheDir = u().getExternalCacheDir();
            if (externalCacheDir != null) {
                File file = new File(externalCacheDir.getAbsolutePath(), ".tmpReverse");
                file.mkdir();
                File file2 = new File(file, "reverse.tmp");
                if (file2.exists()) {
                    file2.delete();
                }
                absolutePath = file2.getAbsolutePath();
            }
            String str3 = absolutePath;
            if (str == null || str.length() <= 0) {
                return;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            File a2 = c.d.b.k.b.a(u(), new File(str), i, endTrim);
            ReverseController a3 = ReverseController.f22057b.a(this, str, a2.getAbsolutePath(), str3, i, endTrim, C1709m.a(a2), new C2008sf(this, valueOf, nexTimelineItem, str2, endTrim, i));
            com.nexstreaming.kinemaster.ui.a.m a4 = com.nexstreaming.kinemaster.ui.a.m.f21351b.a(new Bundle());
            a4.a(a3);
            a4.setCancelable(false);
            a4.show(getSupportFragmentManager(), "ReverseDialog");
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.tb.b
    public void i() {
        Fa();
    }

    public boolean k(int i) {
        return !this.Z.b(i);
    }

    public void m(int i) {
        this.T.setEditingMode(i);
    }

    public void o(boolean z) {
        this.P.setEnabled(z);
    }

    private Task c(Intent intent) {
        ArrayList arrayList;
        Task task = new Task();
        MediaStore W = W();
        if (intent != null && W != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("ProjectEditActivity.titles");
            String stringExtra = intent.getStringExtra("ProjectEditActivity.musicPath");
            String stringExtra2 = intent.getStringExtra("ProjectEditActivity.musicName");
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("ProjectEditActivity.primaryClips");
            String stringExtra3 = intent.getStringExtra("ProjectEditActivity.theme");
            HashSet<com.nexstreaming.kinemaster.mediastore.item.c> hashSet = null;
            c.d.b.i.a a2 = stringExtra3 != null ? c.d.b.i.b.a(stringExtra3) : null;
            if (stringArrayListExtra2 != null) {
                ArrayList arrayList2 = new ArrayList(stringArrayListExtra2.size());
                hashSet = new HashSet();
                Iterator<String> it = stringArrayListExtra2.iterator();
                while (it.hasNext()) {
                    MediaStoreItemId mediaStoreItemId = new MediaStoreItemId(it.next());
                    com.nexstreaming.kinemaster.mediastore.item.c b2 = W.b(mediaStoreItemId);
                    arrayList2.add(mediaStoreItemId);
                    if (b2 != null) {
                        hashSet.add(b2);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (hashSet != null && hashSet.size() >= 1) {
                int[] iArr = {hashSet.size()};
                HashMap hashMap = new HashMap();
                for (com.nexstreaming.kinemaster.mediastore.item.c cVar : hashSet) {
                    W.a(cVar, new Mf(this, hashMap, cVar.getId(), iArr, arrayList, stringArrayListExtra, stringExtra, stringExtra2, a2, task));
                    stringExtra = stringExtra;
                    stringExtra2 = stringExtra2;
                    iArr = iArr;
                }
            } else {
                a(arrayList, stringArrayListExtra, stringExtra, stringExtra2, a2, (Map<MediaStoreItemId, Bitmap>) null);
                task.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
            }
        }
        return task;
    }

    private Task d(Intent intent) {
        String str;
        String str2;
        this.N = null;
        if (intent == null) {
            return null;
        }
        String string = EditorGlobal.t() ? "Demo Project" : getResources().getString(R.string.default_project_name);
        if (intent.getData() != null && intent.getData().toString() != null) {
            try {
                this.N = new File(new URI(intent.getData().toString()));
            } catch (URISyntaxException e2) {
                Log.e("ProjectEditActivity", "", e2);
            }
        }
        File file = this.N;
        if (file != null && file.exists()) {
            Task a2 = ja().a(this.N);
            a2.onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.ui.projectedit.f
                @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
                public final void onTaskEvent(Task task, Task.Event event) {
                    ProjectEditActivity.this.a(task, event);
                }
            }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.projectedit.b
                @Override // com.nexstreaming.app.general.task.Task.OnFailListener
                public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
                    ProjectEditActivity.this.a(task, event, taskError);
                }
            });
            return a2;
        }
        if (this.N == null) {
            int i = 0;
            while (true) {
                if (i >= 10000) {
                    break;
                }
                String absolutePath = EditorGlobal.o().getAbsolutePath();
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (i > 0) {
                    str = " " + i;
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(VideoEditor.u());
                File file2 = new File(absolutePath, sb.toString());
                String absolutePath2 = EditorGlobal.o().getAbsolutePath();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                if (i > 0) {
                    str2 = " " + i;
                } else {
                    str2 = "";
                }
                sb2.append(str2);
                sb2.append(".nexvideoproject");
                File file3 = new File(absolutePath2, sb2.toString());
                if (!file2.exists() && !file3.exists()) {
                    this.N = file2;
                    break;
                }
                i++;
            }
        }
        this.Pa = true;
        if (this.N == null) {
            Log.e("ProjectEditActivity", "Project File is NULL");
        }
        return ja().b(this.N).onComplete(new _f(this, intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem instanceof NexVideoClipItem) {
            ((NexVideoClipItem) nexTimelineItem).setEffectItem(null);
        } else if (nexTimelineItem instanceof NexTransitionItem) {
            ((NexTransitionItem) nexTimelineItem).setEffectItem(null);
        }
    }

    private void s(int i) {
        a(i, (InterfaceC1976p) null);
    }

    public void g(int i) {
        a(i, (InterfaceC1976p) null);
    }

    public View i(int i) {
        View findViewWithTag = this.J.findViewWithTag(Integer.valueOf(i));
        return findViewWithTag == null ? this.K.findViewWithTag(Integer.valueOf(i)) : findViewWithTag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem != 0) {
            ((NexTimelineItem.u) nexTimelineItem).trimToLeft(T());
            if (nexTimelineItem instanceof NexVideoClipItem) {
                l(false);
                ja().b(S());
            }
            e(nexTimelineItem);
            c(nexTimelineItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I
    public void g(boolean z) {
        Fragment findFragmentById;
        super.g(z);
        if (z) {
            this.M.c(false);
            ja().b(EditorGlobal.a("up"));
            ja().H();
            this.X.setVisibility(8);
            this.Y.setVisibility(8);
        } else {
            this.M.c(false);
            ja().b(EditorGlobal.a("up"));
            Ia();
        }
        NexTimelineItem selectedItem = this.T.getSelectedItem();
        if (selectedItem != null && (findFragmentById = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder)) != null && (findFragmentById instanceof Bg) && findFragmentById.isAdded() && selectedItem != null) {
            Bg bg = (Bg) findFragmentById;
            if (selectedItem.getClass() == bg.Z()) {
                bg.a((Bg) selectedItem);
            }
        }
        Fragment findFragmentById2 = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
        if (findFragmentById2 != null && (findFragmentById2 instanceof com.nexstreaming.kinemaster.ui.assetbrowser.i) && findFragmentById2.isAdded()) {
            ((com.nexstreaming.kinemaster.ui.assetbrowser.i) findFragmentById2).Ca();
        }
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f != null) {
            interfaceC2025f.setPurchaseType(B());
        }
        x(!z);
    }

    public boolean j(int i) {
        return this.aa.b(i);
    }

    public void b(c cVar) {
        this.Ya.b(cVar);
    }

    public void i(NexTimelineItem nexTimelineItem) {
        this.Wa = false;
        this.T.b(nexTimelineItem, true);
        this.T.setSelectedItem(nexTimelineItem);
    }

    public void j(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem != null) {
            ja().a(nexTimelineItem, T(), W());
            if (nexTimelineItem instanceof NexVideoClipItem) {
                l(false);
            }
            this.T.b();
            ja().H();
            c(nexTimelineItem);
        }
    }

    public void p(boolean z) {
        this.xa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task b(Intent intent, com.nexstreaming.kinemaster.ui.a.r rVar) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null && action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) {
                return a(intent, rVar);
            }
            return c(intent);
        }
        return Task.COMPLETED_TASK;
    }

    public void l(boolean z) {
        InterfaceC2025f interfaceC2025f = this.T;
        interfaceC2025f.a(interfaceC2025f.getSelectedItem(), z);
    }

    public void e(NexTimelineItem nexTimelineItem) {
        this.T.b(nexTimelineItem);
    }

    public void l(int i) {
        this.ja = i;
    }

    public void f(NexTimelineItem nexTimelineItem) {
        this.T.d();
        this.Wa = false;
        this.T.b(nexTimelineItem, true);
        this.T.setSelectedItem(nexTimelineItem);
    }

    public void b(int[] iArr, InterfaceC1976p interfaceC1976p) {
        a(this.K, iArr, interfaceC1976p, (List<d>) null);
    }

    public void n(int i) {
        this.ma = i;
    }

    public void b(int i, boolean z) {
        if (z) {
            f(i);
        } else {
            e(i);
        }
    }

    public void b(int i, int i2) {
        this.T.a(i, i2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.nexstreaming.kinemaster.mediastore.item.c cVar, NexTimelineItem nexTimelineItem) {
        ImageLayer imageLayer = new ImageLayer();
        int v = ja().v();
        int ca = ca();
        imageLayer.setSplitScreenType(c.d.b.l.a.f3846a.a());
        imageLayer.setRelativeStartTime(v);
        imageLayer.setRelativeEndTime(v + ca);
        SplitScreenType splitScreenType = imageLayer.getSplitScreenType();
        imageLayer.setSplitScreenType(SplitScreenType.OFF);
        NexLayerItem.b closestKeyframe = imageLayer.getClosestKeyframe(0.0f);
        closestKeyframe.f20232c = EditorGlobal.n() / 2.0f;
        closestKeyframe.f20233d = EditorGlobal.m() / 2.0f;
        closestKeyframe.f20231b = 1.0f;
        closestKeyframe.f20234e = 0.0f;
        imageLayer.setMediaPath(cVar.getPath(), u());
        if (nexTimelineItem != null) {
            imageLayer.setRelativeStartTime(nexTimelineItem.getAbsStartTime());
            imageLayer.setRelativeEndTime(nexTimelineItem.getAbsEndTime());
            imageLayer.copyOptions(nexTimelineItem);
            if (imageLayer.getSplitScreenType() != SplitScreenType.OFF) {
                imageLayer.fitKeyframeToSplitscreenRect(imageLayer.getSplitScreenKeyframe());
            }
        } else {
            int height = imageLayer.getHeight();
            int width = imageLayer.getWidth();
            int n = (EditorGlobal.n() * 3) / 4;
            int m = (EditorGlobal.m() * 3) / 4;
            if (width > n) {
                closestKeyframe.f20231b = n / width;
            }
            if (height > m) {
                closestKeyframe.f20231b = Math.min(closestKeyframe.f20231b, m / height);
            }
            float f2 = closestKeyframe.f20231b;
            closestKeyframe.f20236g = f2;
            closestKeyframe.f20237h = f2;
            imageLayer.setSplitScreenType(splitScreenType);
            if (imageLayer.getSplitScreenType() != SplitScreenType.OFF) {
                imageLayer.fitKeyframeToSplitscreenRect(imageLayer.getSplitScreenKeyframe());
            }
        }
        ja().a((NexLayerItem) imageLayer);
        i(imageLayer);
        b(imageLayer);
        new Handler().post(new RunnableC1991qf(this, imageLayer));
        ja().J();
    }

    @Override // c.d.b.b.d.a
    public void a(c.d.b.b.d dVar, c.d.b.b.a.e eVar) {
        Ha();
    }

    public void a(c cVar) {
        this.Ya.a((com.nexstreaming.app.general.util.u<c>) cVar);
    }

    public static Intent a(Context context, File file) {
        Intent intent = new Intent(context, (Class<?>) ProjectEditActivity.class);
        intent.setData(Uri.fromFile(file));
        return intent;
    }

    public static Intent a(Context context, List<com.nexstreaming.kinemaster.mediastore.item.c> list, ArrayList<String> arrayList, String str, String str2, c.d.b.i.a aVar, File file) {
        Intent intent = new Intent(context, (Class<?>) ProjectEditActivity.class);
        intent.setAction("assistant");
        if (list != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<com.nexstreaming.kinemaster.mediastore.item.c> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().getId().toString());
            }
            intent.putStringArrayListExtra("ProjectEditActivity.primaryClips", arrayList2);
        }
        if (arrayList != null) {
            intent.putStringArrayListExtra("ProjectEditActivity.titles", arrayList);
        }
        if (str != null) {
            intent.putExtra("ProjectEditActivity.musicPath", str);
        }
        if (str2 != null) {
            intent.putExtra("ProjectEditActivity.musicName", str2);
        }
        if (aVar != null) {
            intent.putExtra("ProjectEditActivity.theme", aVar.getId());
        }
        intent.setData(Uri.fromFile(file));
        return intent;
    }

    public float d(NexTimelineItem nexTimelineItem) {
        if (this.T.a(nexTimelineItem) != null) {
            return r2.width();
        }
        return 0.0f;
    }

    public void d(int i) {
        if (this.aa.c(i)) {
            View findViewWithTag = this.J.findViewWithTag(Integer.valueOf(i));
            if (findViewWithTag == null) {
                findViewWithTag = this.K.findViewWithTag(Integer.valueOf(i));
            }
            if (findViewWithTag != null) {
                findViewWithTag.setActivated(false);
            }
            Ga();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.C2202xa.c
    public void c(boolean z) {
        if (z) {
            ja().N();
            ja().H();
            ja().J();
        }
        if (getResources().getConfiguration().smallestScreenWidthDp < 600.0f || findViewById(R.id.popupFragmentBackground) == null) {
            return;
        }
        findViewById(R.id.popupFragmentBackground).setBackgroundColor(0);
        findViewById(R.id.popupFragmentBackground).setVisibility(8);
    }

    private Boolean d(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.equals("OptionBlendModeHeaderView") && !str.equals("timelineSelect") && !str.equals("OptionGroupColorFilterHeaderView") && !str.equals(com.nexstreaming.kinemaster.ui.projectedit.audioeffect.w.class.getSimpleName())) {
            return false;
        }
        return true;
    }

    private Task a(Intent intent, com.nexstreaming.kinemaster.ui.a.r rVar) {
        String stringExtra;
        KMIntentData kMIntentData;
        KMIntentData.Project project;
        Task task = new Task();
        ba();
        int da = da();
        MediaStore W = W();
        if (W != null && intent != null && (stringExtra = intent.getStringExtra(KMIntentData.KEY_KINEMASTER_INTENT_PROJET_DATA)) != null && (kMIntentData = (KMIntentData) new Gson().fromJson(stringExtra, KMIntentData.class)) != null && (project = kMIntentData.project) != null) {
            new AsyncTaskC2075xf(this, project, rVar, W, da, task).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        return task;
    }

    public void h(int i) {
        if (i != R.id.action_play_pause) {
            return;
        }
        ja().a(true);
        a(i, (InterfaceC1976p) null);
    }

    private void c(com.nexstreaming.kinemaster.mediastore.item.c cVar, NexTimelineItem nexTimelineItem) {
        if (cVar == null) {
            return;
        }
        MediaInfo a2 = MediaInfo.a(cVar.getPath());
        VideoLayer fromMediaStoreItem = VideoLayer.fromMediaStoreItem(cVar);
        if (nexTimelineItem != null) {
            if (a2.r() < nexTimelineItem.getDuration()) {
                fromMediaStoreItem.setStartTime(nexTimelineItem.getAbsStartTime());
                fromMediaStoreItem.setEndTime(nexTimelineItem.getAbsStartTime() + a2.r());
            } else {
                fromMediaStoreItem.setStartTime(nexTimelineItem.getAbsStartTime());
                fromMediaStoreItem.setEndTime(nexTimelineItem.getAbsEndTime());
                fromMediaStoreItem.setEndTrim(a2.r() - (fromMediaStoreItem.getEndTime() - fromMediaStoreItem.getStartTime()));
            }
            fromMediaStoreItem.setOrientation(a2.z());
            fromMediaStoreItem.copyOptions(nexTimelineItem);
            ja().a((NexLayerItem) fromMediaStoreItem);
            fromMediaStoreItem.setZOrder(((NexLayerItem) nexTimelineItem).getZOrder());
        } else {
            int v = ja().v();
            fromMediaStoreItem.setStartTime(v);
            fromMediaStoreItem.setEndTime(v + fromMediaStoreItem.getIntinsicDuration());
            SplitScreenType splitScreenType = fromMediaStoreItem.getSplitScreenType();
            fromMediaStoreItem.setSplitScreenType(SplitScreenType.OFF);
            NexLayerItem.b closestKeyframe = fromMediaStoreItem.getClosestKeyframe(0.0f);
            closestKeyframe.f20232c = EditorGlobal.n() / 2;
            closestKeyframe.f20233d = EditorGlobal.m() / 2;
            closestKeyframe.f20231b = 1.0f;
            closestKeyframe.f20234e = -a2.z();
            fromMediaStoreItem.setOrientation(a2.z());
            int height = fromMediaStoreItem.getHeight();
            int width = fromMediaStoreItem.getWidth();
            int n = (EditorGlobal.n() * 3) / 4;
            int m = (EditorGlobal.m() * 3) / 4;
            if ((closestKeyframe.f20234e / 90.0f) % 2.0f != 0.0f) {
                if (height > n) {
                    closestKeyframe.f20231b = n / height;
                }
                if (width > m) {
                    closestKeyframe.f20231b = Math.min(closestKeyframe.f20231b, m / width);
                }
            } else {
                if (width > n) {
                    closestKeyframe.f20231b = n / width;
                }
                if (height > m) {
                    closestKeyframe.f20231b = Math.min(closestKeyframe.f20231b, m / height);
                }
            }
            float f2 = closestKeyframe.f20231b;
            closestKeyframe.f20236g = f2;
            closestKeyframe.f20237h = f2;
            fromMediaStoreItem.setSplitScreenType(splitScreenType);
            ja().a((NexLayerItem) fromMediaStoreItem);
        }
        b(fromMediaStoreItem);
        if (nexTimelineItem != null) {
            ja().b(nexTimelineItem);
        }
        new Handler().post(new RunnableC1982pf(this, fromMediaStoreItem));
        ja().J();
        ja().N();
        ja().H();
    }

    public /* synthetic */ void a(Task task, Task.Event event) {
        ProjectAspectRatio projectRatio = this.T.getTimeline().getProjectRatio();
        if (projectRatio == ProjectAspectRatio.R_9_16) {
            EditorGlobal.a(0.5625f);
        } else if (projectRatio == ProjectAspectRatio.SQUARE) {
            EditorGlobal.a(1.0f);
        } else {
            EditorGlobal.a(1.7777778f);
        }
        Ba();
        wa();
    }

    public /* synthetic */ void a(Task task, Task.Event event, final Task.TaskError taskError) {
        e.a aVar = new e.a(this);
        aVar.c(R.string.load_project_fail);
        aVar.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectedit.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ProjectEditActivity.this.a(taskError, dialogInterface, i);
            }
        });
        aVar.a().show();
    }

    public /* synthetic */ void b(Task task, Task.Event event) {
        this.Na++;
        ja().D().onFailure(new C2067wf(this));
    }

    public /* synthetic */ void a(Task.TaskError taskError, DialogInterface dialogInterface, int i) {
        Crashlytics.log("newProjectTask.onFailure() - " + taskError.getMessage());
        dialogInterface.dismiss();
        finish();
    }

    public void b(NexTimelineItem nexTimelineItem) {
        this.T.a(nexTimelineItem, TimelineView.AnimType.AddClip, 350);
        this.T.invalidate();
        this.T.b();
    }

    private boolean a(c.d.b.i.a aVar, ArrayList<String> arrayList, boolean z) {
        return c.d.b.j.e.a(aVar).a(this, ja().s(), arrayList);
    }

    private Boolean b(Fragment fragment) {
        if (!(fragment instanceof Xb) && !(fragment instanceof com.nexstreaming.kinemaster.ui.d.h) && !(fragment instanceof com.nexstreaming.kinemaster.ui.projectedit.audioeffect.w)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaStoreItemId> list, ArrayList<String> arrayList, String str, String str2, c.d.b.i.a aVar, Map<MediaStoreItemId, Bitmap> map) {
        boolean z;
        c.d.b.i.a aVar2;
        boolean z2;
        ArrayList<String> arrayList2;
        if (list != null) {
            this.ya.a(list);
            for (int i = 0; i < list.size(); i++) {
                MediaStoreItemId mediaStoreItemId = list.get(i);
                a(mediaStoreItemId, W().b(mediaStoreItemId), map == null ? null : map.get(mediaStoreItemId), InsertPosition.CurrentTime, true, false);
            }
            z = true;
        } else {
            z = false;
        }
        if (str != null) {
            NexAudioClipItem a2 = ja().a(ja().v(), str, false);
            a2.setTitle(str2);
            a2.setPinned(true);
            a2.setLoop(true);
            a2.setExtendToEnd(true);
            a2.setBGM(true);
            arrayList2 = arrayList;
            aVar2 = aVar;
            z2 = true;
        } else {
            aVar2 = aVar;
            z2 = z;
            arrayList2 = arrayList;
        }
        if (a(aVar2, arrayList2, false) ? true : z2) {
            ja().N();
            ja().k();
            ja().K();
            return;
        }
        ja().a(ja().s());
    }

    public void b(boolean z, boolean z2) {
        this.J.setFocusable(z2);
        this.J.setFocusableInTouchMode(z2);
        this.K.setFocusable(z2);
        this.K.setFocusableInTouchMode(z2);
        this.L.setFocusable(z);
        this.L.setFocusableInTouchMode(z);
        this.Da.setFocusable(z);
        this.Da.setFocusableInTouchMode(z);
        this.Ca.setFocusable(z);
        this.Ca.setFocusableInTouchMode(z);
        if (z) {
            this.L.setDescendantFocusability(262144);
            this.Da.setDescendantFocusability(262144);
            this.Ca.setDescendantFocusability(262144);
        } else if (!z) {
            this.L.setDescendantFocusability(393216);
            this.Da.setDescendantFocusability(393216);
            this.Ca.setDescendantFocusability(393216);
        }
        if (z2) {
            this.J.setDescendantFocusability(262144);
            this.K.setDescendantFocusability(262144);
        } else {
            if (z2) {
                return;
            }
            this.J.setDescendantFocusability(393216);
            this.K.setDescendantFocusability(393216);
        }
    }

    @Override // com.nexstreaming.kinemaster.mediaprep.MediaPrepManager.a
    public void a(MediaStoreItemId mediaStoreItemId, C1803a c1803a) {
        Runnable runnable;
        boolean C = ja().C();
        if (c1803a.f20781a == MediaPrepState.Completed && c1803a.f20787g != null) {
            NexTimelineItem selectedItem = this.T.getSelectedItem();
            boolean z = (selectedItem == null || selectedItem.isClipReady() || !mediaStoreItemId.equals(selectedItem.getMediaMSID())) ? false : true;
            NexVideoClipItem.CropMode ba = ba();
            int da = da();
            NexTimeline.c beginTimeChange = this.T.getTimeline().beginTimeChange();
            try {
                ja().s().a().applyFinalPathForMSID(mediaStoreItemId, c1803a.f20787g, ba, da);
                beginTimeChange.apply();
                ja().N();
                this.T.f();
                ja().K();
                if (z) {
                    this.Wa = false;
                    this.T.d();
                    new Handler().post(new RunnableC2009sg(this, selectedItem));
                }
            } catch (IllegalStateException unused) {
                e.a aVar = new e.a(u());
                aVar.a(getString(R.string.mediabrowser_video_notsupport));
                aVar.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectedit.e
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ProjectEditActivity.this.a(dialogInterface, i);
                    }
                });
                aVar.a().show();
            }
        } else if (c1803a.f20781a == MediaPrepState.UserInterventionRequired && (runnable = c1803a.f20786f) != null) {
            runnable.run();
        } else {
            MediaPrepState mediaPrepState = c1803a.f20781a;
            if (mediaPrepState == MediaPrepState.UserInterventionCancel) {
                NexTimeline.c beginTimeChange2 = this.T.getTimeline().beginTimeChange();
                NexTimeline a2 = ja().s().a();
                ArrayList arrayList = new ArrayList();
                int primaryItemCount = a2.getPrimaryItemCount();
                NexPrimaryTimelineItem nexPrimaryTimelineItem = null;
                NexPrimaryTimelineItem nexPrimaryTimelineItem2 = null;
                for (int i = 0; i < primaryItemCount; i++) {
                    NexPrimaryTimelineItem primaryItem = a2.getPrimaryItem(i);
                    if (mediaStoreItemId.equals(primaryItem.getMediaMSID())) {
                        if (nexPrimaryTimelineItem == null) {
                            nexPrimaryTimelineItem = nexPrimaryTimelineItem2;
                        }
                        arrayList.add(primaryItem);
                    } else {
                        nexPrimaryTimelineItem2 = primaryItem;
                    }
                }
                int secondaryItemCount = a2.getSecondaryItemCount();
                for (int i2 = 0; i2 < secondaryItemCount; i2++) {
                    NexSecondaryTimelineItem secondaryItem = a2.getSecondaryItem(i2);
                    if (mediaStoreItemId.equals(secondaryItem.getMediaMSID())) {
                        arrayList.add(secondaryItem);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ja().b((NexTimelineItem) it.next());
                }
                beginTimeChange2.apply();
                ja().N();
                this.T.f();
                if (arrayList.size() > 0) {
                    if (nexPrimaryTimelineItem != null) {
                        this.T.a((NexTimelineItem) nexPrimaryTimelineItem, true, false);
                    } else {
                        this.T.a(0);
                    }
                }
                ja().K();
                xa();
            } else if (mediaPrepState == MediaPrepState.Downloading || mediaPrepState == MediaPrepState.Transcoding || mediaPrepState == MediaPrepState.FailDownload || mediaPrepState == MediaPrepState.FailTranscoding || mediaPrepState == MediaPrepState.FailedCanRetry) {
                NexTimelineItem selectedItem2 = this.T.getSelectedItem();
                Bg bg = (Bg) getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
                if (bg != null && (bg instanceof Ad) && selectedItem2 != null) {
                    bg.na();
                }
            }
        }
        if (C != ja().C()) {
            if (ja().v() != this.T.getCurrentTime()) {
                ja().a(this.T.getCurrentTime(), true);
            }
            ja().H();
        }
        this.T.invalidate();
    }

    public void c(int i) {
        if (this.aa.a(i)) {
            View findViewWithTag = this.J.findViewWithTag(Integer.valueOf(i));
            if (findViewWithTag == null) {
                findViewWithTag = this.K.findViewWithTag(Integer.valueOf(i));
            }
            if (findViewWithTag != null) {
                findViewWithTag.setActivated(true);
            }
            Ga();
        }
    }

    public void c(NexTimelineItem nexTimelineItem) {
        ja().H();
        ja().c(nexTimelineItem);
        ja().J();
    }

    public void c(final boolean z, boolean z2) {
        this.Ya.a(new u.a() { // from class: com.nexstreaming.kinemaster.ui.projectedit.j
            @Override // com.nexstreaming.app.general.util.u.a
            public final void a(Object obj) {
                ProjectEditActivity.this.a(z, (ProjectEditActivity.c) obj);
            }
        });
        if (z == this.da) {
            return;
        }
        this.gb = true;
        this.da = z;
        this.T.setExpanded(z);
        if (this.la == 0) {
            this.la = this.ka.getHeight();
        }
        if (this.ma == 0) {
            this.ma = this.ka.getWidth();
        }
        if (this.ia == 0) {
            this.ia = this.T.getHeight();
        }
        if (this.ja == 0) {
            this.ja = getResources().getDimensionPixelOffset(R.dimen.pedit_big_option_panel_width);
        }
        Fragment fragment = getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getFragments().size() - 1);
        if (fragment instanceof Bg) {
            Bg bg = (Bg) fragment;
            if (z) {
                bg.pa();
            } else {
                bg.oa();
            }
        } else if (z) {
            a(new int[]{R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_play_pause, R.drawable.action_play_pause, R.id.action_expand_preview, R.drawable.action_inset_preview}, (InterfaceC1976p) null);
        } else {
            a(new int[]{R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_play_pause, R.drawable.action_play_pause, R.id.action_share, R.drawable.action_icon_share}, (InterfaceC1976p) null);
        }
        if (z) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.aboveTimelineFragmentHolder);
            Fragment findFragmentById2 = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
            if ((findFragmentById instanceof C1829g) || (findFragmentById instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a) || (findFragmentById2 instanceof zh)) {
                i(true);
            }
        }
        NexTimelineItem selectedItem = ia().getSelectedItem();
        if ((selectedItem instanceof NexTransitionItem) && ((NexTransitionItem) selectedItem).getDurationLimit() >= 100) {
            if (z) {
                ka();
            } else {
                t(true);
            }
        }
        w(this.da);
        if (z2) {
            int height = this.T.getHeight();
            int i = this.da ? this.la : this.ia;
            int width = this.T.getWidth();
            int i2 = this.da ? this.ma : this.ja;
            this.T.setExpandingAnimation(true);
            Vf vf = new Vf(this, height, i, width, i2);
            vf.setDuration(150L);
            vf.setAnimationListener(new Wf(this));
            this.T.startAnimation(vf);
            this.T.l();
        } else {
            ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
            layoutParams.height = this.da ? this.la : this.ia;
            layoutParams.width = this.da ? this.ma : this.ja;
            this.T.setLayoutParams(layoutParams);
            this.gb = false;
        }
        if (z) {
            View findViewById = findViewById(R.id.bookmarkViewHolder);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            marginLayoutParams.bottomMargin = this.la - getResources().getDimensionPixelOffset(R.dimen.timeline3_bookmark_view_expand_bottomMargin_diff);
            findViewById.setLayoutParams(marginLayoutParams);
        } else {
            View findViewById2 = findViewById(R.id.bookmarkViewHolder);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
            marginLayoutParams2.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.timeline3_bookmark_view_bottomMargin);
            findViewById2.setLayoutParams(marginLayoutParams2);
        }
        va();
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        ja().s().a().clearTimeline();
        ja().O();
        ja().j();
        if (!ja().h()) {
            ja().k();
        }
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Fragment fragment) {
        if (fragment instanceof InterfaceC1866cf) {
            this.ta = new WeakReference<>((InterfaceC1866cf) fragment);
        }
    }

    public void a(int[] iArr, InterfaceC1976p interfaceC1976p) {
        a(this.J, iArr, interfaceC1976p, this.wa);
    }

    public void a(int... iArr) {
        b(iArr, (InterfaceC1976p) null);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        if (ja().w().isPlaying() && !this.za) {
            int i3 = this.Fa;
            if (i3 >= 0 && Math.abs(i2 - i3) < 15) {
                return;
            }
            this.T.a(i2);
            this.Fa = i2;
        }
        va();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0103 A[Catch: all -> 0x0170, TryCatch #0 {all -> 0x0170, blocks: (B:3:0x0004, B:5:0x000e, B:6:0x0140, B:7:0x0148, B:9:0x014e, B:12:0x0158, B:21:0x001a, B:23:0x003b, B:25:0x0049, B:26:0x005a, B:28:0x005e, B:30:0x0062, B:32:0x0066, B:33:0x007a, B:35:0x007e, B:36:0x00ab, B:37:0x00ad, B:39:0x00bb, B:41:0x00c5, B:43:0x00cf, B:45:0x00d3, B:48:0x00ff, B:50:0x0103, B:51:0x0105, B:53:0x0119, B:55:0x0124, B:57:0x00e3, B:59:0x00ed, B:61:0x00f7, B:63:0x00fb), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0119 A[Catch: all -> 0x0170, TryCatch #0 {all -> 0x0170, blocks: (B:3:0x0004, B:5:0x000e, B:6:0x0140, B:7:0x0148, B:9:0x014e, B:12:0x0158, B:21:0x001a, B:23:0x003b, B:25:0x0049, B:26:0x005a, B:28:0x005e, B:30:0x0062, B:32:0x0066, B:33:0x007a, B:35:0x007e, B:36:0x00ab, B:37:0x00ad, B:39:0x00bb, B:41:0x00c5, B:43:0x00cf, B:45:0x00d3, B:48:0x00ff, B:50:0x0103, B:51:0x0105, B:53:0x0119, B:55:0x0124, B:57:0x00e3, B:59:0x00ed, B:61:0x00f7, B:63:0x00fb), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124 A[Catch: all -> 0x0170, TryCatch #0 {all -> 0x0170, blocks: (B:3:0x0004, B:5:0x000e, B:6:0x0140, B:7:0x0148, B:9:0x014e, B:12:0x0158, B:21:0x001a, B:23:0x003b, B:25:0x0049, B:26:0x005a, B:28:0x005e, B:30:0x0062, B:32:0x0066, B:33:0x007a, B:35:0x007e, B:36:0x00ab, B:37:0x00ad, B:39:0x00bb, B:41:0x00c5, B:43:0x00cf, B:45:0x00d3, B:48:0x00ff, B:50:0x0103, B:51:0x0105, B:53:0x0119, B:55:0x0124, B:57:0x00e3, B:59:0x00ed, B:61:0x00f7, B:63:0x00fb), top: B:2:0x0004 }] */
    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity.c():void");
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.f
    public void a(VideoEditor.State state) {
        if (isFinishing()) {
            return;
        }
        this._a = state;
        this.Fa = -1;
        if (state.isPlaying() && !this.Ea) {
            getWindow().addFlags(128);
            this.Ea = true;
        } else if (!state.isPlaying() && this.Ea) {
            getWindow().clearFlags(128);
            this.Ea = false;
        }
        this.T.setPlaying(state == VideoEditor.State.Playing);
        if (state == VideoEditor.State.Idle) {
            f(R.id.action_play_pause);
            c(R.id.action_play_pause);
        } else if (state == VideoEditor.State.PreparingToPlay) {
            e(R.id.action_play_pause);
            c(R.id.action_play_pause);
        } else if (state != VideoEditor.State.Playing && state != VideoEditor.State.ReversePlay) {
            c(R.id.action_play_pause);
            e(R.id.action_play_pause);
        } else {
            f(R.id.action_play_pause);
            d(R.id.action_play_pause);
        }
        View view = this.S;
        if (view != null) {
            if (state != VideoEditor.State.Playing && state != VideoEditor.State.ReversePlay) {
                view.setVisibility(0);
            } else {
                this.S.setVisibility(8);
            }
            if (state == VideoEditor.State.Idle) {
                this.S.setEnabled(true);
            } else if (state == VideoEditor.State.PreparingToPlay) {
                this.S.setEnabled(false);
            } else {
                this.S.setEnabled(false);
            }
        }
        va();
        ((TimelineView) this.T).n();
    }

    public /* synthetic */ void a(Configuration configuration, int i) {
        if (C() || configuration.screenWidthDp <= configuration.screenHeightDp || C() || this.I.getMeasuredWidth() <= this.I.getMeasuredHeight()) {
            return;
        }
        Rect rect = new Rect();
        this.O.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        this.P.getGlobalVisibleRect(rect2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Y.getLayoutParams();
        int measuredWidth = (int) (this.P.getMeasuredWidth() * (this.P.getMeasuredWidth() > this.P.getMeasuredHeight() ? 0.025f : 0.035f));
        int top = this.P.getTop() + measuredWidth;
        int i2 = (rect.right - rect2.right) + measuredWidth;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.km_watermark, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        float f2 = this.P.getMeasuredWidth() > this.P.getMeasuredHeight() ? 0.25f : 0.35f;
        if (Resources.getSystem().getConfiguration().locale.toString().startsWith("zh")) {
            f2 = this.P.getMeasuredWidth() > this.P.getMeasuredHeight() ? 0.15f : 0.25f;
        }
        int measuredWidth2 = (int) (i3 * (((int) (this.P.getMeasuredWidth() * f2)) / i4));
        float f3 = Resources.getSystem().getConfiguration().locale.toString().startsWith("zh") ? 0.5f : 0.15f;
        layoutParams.width = (int) ((((int) (measuredWidth2 * f3)) * i) / 100.0f);
        layoutParams.height = (int) ((((int) (r5 * f3)) * i) / 100.0f);
        layoutParams.setMargins(0, top, i2, 0);
        this.Y.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.X.getLayoutParams();
        int measuredHeight = (layoutParams.topMargin + (layoutParams.height / 2)) - (this.X.getMeasuredHeight() / 4);
        if (measuredHeight < 0) {
            measuredHeight = 0;
        }
        int i5 = EditorGlobal.a((Activity) this).left;
        layoutParams2.leftMargin = rect2.right - 0;
        layoutParams2.topMargin = measuredHeight;
        this.X.setLayoutParams(layoutParams2);
    }

    protected void c(String str) {
        if (this.T == null || getSupportFragmentManager() == null) {
            return;
        }
        NexTimelineItem selectedItem = this.T.getSelectedItem();
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
        if (findFragmentById == null) {
            findFragmentById = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
        }
        if (selectedItem != null && !str.equals("assetBrowser") && !str.equals("timelineSelect") && !str.equals("OptionGroupColorFilterHeaderView") && !str.equals("OptionBlendModeHeaderView") && !str.equals("blending") && (findFragmentById instanceof Bg)) {
            ((Bg) findFragmentById).a((Bg) selectedItem);
            VideoEditor ja = ja();
            if (ja != null) {
                ja.J();
            }
        }
        if (b(findFragmentById).booleanValue()) {
            if (d(str).booleanValue()) {
                f(true);
            } else {
                i(true);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.i
    public void a(boolean z, boolean z2) {
        b(R.id.action_undo, z);
        b(R.id.action_redo, z2);
    }

    public void a(CharSequence charSequence, int i) {
        Toast makeText = Toast.makeText(u(), charSequence, i);
        if (this.cb == 0 || System.currentTimeMillis() - this.cb >= 4000) {
            makeText.show();
            this.cb = System.currentTimeMillis();
        }
    }

    public void a(int i, int i2, int i3) {
        this.T.a(i, i2, i2);
    }

    @Override // com.nextreaming.nexeditorui.InterfaceC2301ca
    public void a(String str, String str2, int i) {
        Fragment findFragmentById;
        if (PreferenceManager.getDefaultSharedPreferences(u()).getBoolean("pref_abrowser_full", false) && (findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fullscreenFragmentHolder)) != null && ((findFragmentById instanceof C1829g) || (findFragmentById instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a))) {
            i(true);
        }
        if (str != null) {
            NexAudioClipItem a2 = ja().a(ja().v(), str, false);
            a2.setTitle(str2);
            this.T.a(a2, TimelineView.AnimType.AddClip, 350);
            ja().H();
            this.T.invalidate();
            this.T.b();
            xa();
            new Handler().post(new RunnableC1946lf(this, a2));
            ja().J();
        }
    }

    public void a(MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, Bitmap bitmap) {
        a(mediaStoreItemId, cVar, bitmap, InsertPosition.CurrentTime, true, false, true);
    }

    public void a(MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, Bitmap bitmap, InsertPosition insertPosition, boolean z, boolean z2) {
        a(mediaStoreItemId, cVar, bitmap, insertPosition, z, false, z2);
    }

    public void a(MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, Bitmap bitmap, InsertPosition insertPosition, boolean z, boolean z2, boolean z3) {
        int c2;
        int i;
        int da = da();
        int selectedIndex = this.T.getSelectedTimeline() == WhichTimeline.PRIMARY ? this.T.getSelectedIndex() : -1;
        int i2 = C2068wg.f22758c[insertPosition.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                c2 = this.T.c();
            } else {
                if (selectedIndex < 0) {
                    c2 = this.T.c();
                }
                i = selectedIndex;
            }
            i = c2;
        } else if (selectedIndex < 0) {
            c2 = this.T.c();
            i = c2;
        } else {
            selectedIndex += 2;
            i = selectedIndex;
        }
        xa();
        NexVideoClipItem a2 = ja().a(i, mediaStoreItemId, cVar, da, z2);
        String str = a2.isSolid() ? "Background" : a2.isImage() ? "Image" : "Video";
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("name", "Local");
        hashMap.put("result", "Success");
        KMEvents.EDIT_ADD_MEDIA.logEvent(hashMap);
        if (bitmap != null) {
            ja().s().a().getThumbnailCache().put(a2.getUniqueId(), bitmap);
        }
        if (z) {
            b(a2);
            this.T.a((NexTimelineItem) a2, true, true);
        }
        xa();
        if (z3 && bitmap != null) {
            ja().J();
        }
        Ia();
    }

    public void a(final NexTimelineItem nexTimelineItem, final com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        if (nexTimelineItem instanceof NexLayerItem) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.projectedit.a
                @Override // java.lang.Runnable
                public final void run() {
                    ProjectEditActivity.this.a(cVar, nexTimelineItem);
                }
            });
        } else if (nexTimelineItem instanceof NexVideoClipItem) {
            W().a(cVar, new C1955mf(this, cVar, nexTimelineItem));
        }
    }

    public /* synthetic */ void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, NexTimelineItem nexTimelineItem) {
        c(cVar, nexTimelineItem);
        ja().H();
        this.T.g();
        this.T.invalidate();
        this.T.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId r9, com.nexstreaming.kinemaster.mediastore.item.c r10, android.graphics.Bitmap r11, com.nextreaming.nexeditorui.NexTimelineItem r12, boolean r13, boolean r14, boolean r15) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.nextreaming.nexeditorui.NexPrimaryTimelineItem
            if (r0 == 0) goto L13
            com.nexstreaming.kinemaster.ui.projectedit.timeline.f r0 = r8.T
            com.nextreaming.nexeditorui.NexTimeline r0 = r0.getTimeline()
            r1 = r12
            com.nextreaming.nexeditorui.NexPrimaryTimelineItem r1 = (com.nextreaming.nexeditorui.NexPrimaryTimelineItem) r1
            int r0 = r0.getIndexOfPrimaryItem(r1)
        L11:
            r3 = r0
            goto L27
        L13:
            boolean r0 = r12 instanceof com.nextreaming.nexeditorui.NexSecondaryTimelineItem
            if (r0 == 0) goto L25
            com.nexstreaming.kinemaster.ui.projectedit.timeline.f r0 = r8.T
            com.nextreaming.nexeditorui.NexTimeline r0 = r0.getTimeline()
            r1 = r12
            com.nextreaming.nexeditorui.NexSecondaryTimelineItem r1 = (com.nextreaming.nexeditorui.NexSecondaryTimelineItem) r1
            int r0 = r0.getIndexOfSecondaryItem(r1)
            goto L11
        L25:
            r0 = 0
            r3 = 0
        L27:
            r8.xa()
            com.nexstreaming.kinemaster.editorwrapper.VideoEditor r1 = r8.ja()
            r2 = r12
            com.nextreaming.nexeditorui.NexVideoClipItem r2 = (com.nextreaming.nexeditorui.NexVideoClipItem) r2
            r7 = 1
            r4 = r9
            r5 = r10
            r6 = r14
            com.nextreaming.nexeditorui.NexVideoClipItem r9 = r1.a(r2, r3, r4, r5, r6, r7)
            com.nexstreaming.kinemaster.ui.projectedit.timeline.f r10 = r8.T
            r10.setSelectedItem(r9)
            if (r11 == 0) goto L57
            com.nexstreaming.kinemaster.editorwrapper.VideoEditor r10 = r8.ja()
            com.nexstreaming.kinemaster.editorwrapper.za r10 = r10.s()
            com.nextreaming.nexeditorui.NexTimeline r10 = r10.a()
            android.util.LruCache r10 = r10.getThumbnailCache()
            java.util.UUID r12 = r9.getUniqueId()
            r10.put(r12, r11)
        L57:
            if (r13 == 0) goto L62
            r8.b(r9)
            com.nexstreaming.kinemaster.ui.projectedit.timeline.f r10 = r8.T
            r12 = 1
            r10.a(r9, r12, r12)
        L62:
            if (r15 == 0) goto L6d
            if (r11 == 0) goto L6d
            com.nexstreaming.kinemaster.editorwrapper.VideoEditor r9 = r8.ja()
            r9.J()
        L6d:
            r8.Ia()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity.a(com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c, android.graphics.Bitmap, com.nextreaming.nexeditorui.NexTimelineItem, boolean, boolean, boolean):void");
    }

    public void a(MediaStoreItemId mediaStoreItemId) {
        c(W().b(mediaStoreItemId), (NexTimelineItem) null);
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.T
    public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar, int i) {
        Fragment findFragmentById;
        if (PreferenceManager.getDefaultSharedPreferences(u()).getBoolean("pref_mbrowser_full", false) && (findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fullscreenFragmentHolder)) != null && ((findFragmentById instanceof C1829g) || (findFragmentById instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a))) {
            i(true);
        }
        if (i == R.id.req_add_visual_clip) {
            W().a(cVar, new C2017tf(this, cVar));
            return;
        }
        if (i == R.id.req_add_image_layer) {
            if (this.T.getSelectedItem() != null) {
                NexTimelineItem selectedItem = this.T.getSelectedItem();
                if (selectedItem instanceof ImageLayer) {
                    ((ImageLayer) selectedItem).setMediaPath(cVar.getPath(), u());
                    this.T.b(selectedItem);
                    ja().J();
                    return;
                }
                return;
            }
            int i2 = C2068wg.f22759d[cVar.getType().ordinal()];
            if (i2 == 1) {
                b(cVar, (NexTimelineItem) null);
            } else {
                if (i2 != 2) {
                    return;
                }
                c(cVar, (NexTimelineItem) null);
            }
        }
    }

    private void a(LinearLayout linearLayout, boolean z) {
        linearLayout.setEnabled(z);
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt != null) {
                if (!z) {
                    childAt.setEnabled(false);
                } else {
                    Object tag = childAt.getTag();
                    if (tag != null && (tag instanceof Integer)) {
                        if (this.Z.b(((Integer) tag).intValue())) {
                            childAt.setEnabled(false);
                        } else {
                            childAt.setEnabled(true);
                        }
                    }
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.h
    public void a(NexTimelineItem nexTimelineItem) {
        this.T.b(nexTimelineItem);
    }

    private void a(LinearLayout linearLayout, int[] iArr, InterfaceC1976p interfaceC1976p, List<d> list) {
        int i;
        C1964nf c1964nf = null;
        WeakReference weakReference = interfaceC1976p == null ? null : new WeakReference(interfaceC1976p);
        linearLayout.removeAllViews();
        if (list != null) {
            list.clear();
        }
        if (iArr != null) {
            Resources resources = getResources();
            int i2 = 0;
            int i3 = 0;
            boolean z = true;
            while (i2 < iArr.length) {
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                do {
                    int i7 = iArr[i2];
                    if (i7 != 0) {
                        String resourceTypeName = resources.getResourceTypeName(i7);
                        if ("id".equals(resourceTypeName)) {
                            if (i4 != 0) {
                                break;
                            } else {
                                i4 = i7;
                            }
                        } else if ("string".equals(resourceTypeName)) {
                            i6 = i7;
                        } else if ("drawable".equals(resourceTypeName)) {
                            i5 = i7;
                        } else {
                            Log.w("ProjectEditActivity", "Unknown resource type : '" + resourceTypeName + "'");
                        }
                    }
                    i2++;
                } while (i2 < iArr.length);
                if (i5 == 0) {
                    i5 = q(i4);
                }
                if (i6 == 0) {
                    i6 = r(i6);
                }
                if (i6 == 0) {
                    i3++;
                    if (z) {
                        z = false;
                    } else {
                        linearLayout.addView(new a(this));
                    }
                    IconButton iconButton = new IconButton(this);
                    iconButton.setBackgroundResource(R.drawable.pedit_button_color);
                    Drawable drawable = getResources().getDrawable(i5);
                    iconButton.setImageDrawable(drawable);
                    if (drawable.isStateful()) {
                        iconButton.setIconColorStateList(R.color.pedit_icon_color_non_activated);
                    } else {
                        iconButton.setIconColorStateList(R.color.pedit_icon_color);
                    }
                    iconButton.setOnClickListener(new C2049uf(this, linearLayout, weakReference, i4));
                    if (!linearLayout.isEnabled() || this.Z.b(i4)) {
                        iconButton.setEnabled(false);
                    }
                    if (this.aa.b(i4)) {
                        iconButton.setActivated(true);
                    }
                    iconButton.setTag(Integer.valueOf(i4));
                    if (i4 == R.id.action_undo || i4 == R.id.action_redo) {
                        iconButton.setNextFocusRightId(R.id.removeWatermarkBtn);
                    }
                    linearLayout.addView(iconButton, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                } else if (list != null) {
                    list.add(new d(i4, i6, i5, c1964nf));
                }
            }
            i = i3;
        } else {
            i = 0;
        }
        linearLayout.setWeightSum(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, InterfaceC1976p interfaceC1976p) {
        WeakReference weakReference;
        if (i != R.id.action_delete) {
            if (i != R.id.action_general) {
                if (i != R.id.action_undo) {
                    switch (i) {
                        case R.id.action_align_center_horizontal /* 2131361824 */:
                            NexTimelineItem selectedItem = this.T.getSelectedItem();
                            if (selectedItem == null || !(selectedItem instanceof NexLayerItem)) {
                                return;
                            }
                            NexLayerItem nexLayerItem = (NexLayerItem) selectedItem;
                            nexLayerItem.getClosestKeyframe(nexLayerItem.getScaledTime(ja().v())).f20232c = EditorGlobal.n() / 2;
                            ja().a(NexEditor.FastPreviewOption.normal, 0, true);
                            ja().J();
                            return;
                        case R.id.action_align_center_vertical /* 2131361825 */:
                            NexTimelineItem selectedItem2 = this.T.getSelectedItem();
                            if (selectedItem2 == null || !(selectedItem2 instanceof NexLayerItem)) {
                                return;
                            }
                            NexLayerItem nexLayerItem2 = (NexLayerItem) selectedItem2;
                            nexLayerItem2.getClosestKeyframe(nexLayerItem2.getScaledTime(ja().v())).f20233d = EditorGlobal.m() / 2;
                            ja().a(NexEditor.FastPreviewOption.normal, 0, true);
                            ja().J();
                            return;
                        case R.id.action_animation /* 2131361826 */:
                            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
                            if (findFragmentById != null && (findFragmentById instanceof C1978pb)) {
                                getSupportFragmentManager().popBackStack();
                                return;
                            }
                            C1978pb c1978pb = new C1978pb();
                            c1978pb.a((C1978pb) this.T.getSelectedItem());
                            a(getSupportFragmentManager().beginTransaction()).setTransition(4097).replace(R.id.optionPanelHolder, c1978pb).addToBackStack("layerAnimation").commit();
                            return;
                        default:
                            switch (i) {
                                case R.id.action_bring_forward /* 2131361835 */:
                                    NexTimelineItem selectedItem3 = this.T.getSelectedItem();
                                    if (selectedItem3 == null || !(selectedItem3 instanceof NexLayerItem)) {
                                        return;
                                    }
                                    ja().a((NexLayerItem) selectedItem3, this.T.getCurrentTime());
                                    ja().H();
                                    ja().J();
                                    return;
                                case R.id.action_bring_to_front /* 2131361836 */:
                                    NexTimelineItem selectedItem4 = this.T.getSelectedItem();
                                    if (selectedItem4 == null || !(selectedItem4 instanceof NexLayerItem)) {
                                        return;
                                    }
                                    ja().b((NexLayerItem) selectedItem4);
                                    ja().H();
                                    ja().J();
                                    return;
                                case R.id.action_capture /* 2131361837 */:
                                    weakReference = interfaceC1976p != null ? new WeakReference(interfaceC1976p) : null;
                                    PopoutListMenu popoutListMenu = new PopoutListMenu(u());
                                    popoutListMenu.a(R.id.action_capture_save, R.string.vclip_capture_save, R.drawable.action_capture_save);
                                    popoutListMenu.a(R.id.action_capture_insert_right, R.string.vclip_capture_insert_right, R.drawable.action_capture_insert_right);
                                    popoutListMenu.a(R.id.action_capture_add_layer, R.string.capture_as_layer, R.drawable.action_capture_add_layer);
                                    popoutListMenu.a(i(i), 21);
                                    popoutListMenu.a(new C2091zf(this, weakReference));
                                    return;
                                case R.id.action_capture_add_layer /* 2131361838 */:
                                    s(false);
                                    q(false);
                                    r(false);
                                    this.Aa.a(300L);
                                    ja().a(fa()).onResultAvailable(new Bf(this)).onFailure((Task.OnFailListener) new Af(this));
                                    return;
                                case R.id.action_capture_insert_left /* 2131361839 */:
                                    s(false);
                                    q(false);
                                    r(false);
                                    this.Aa.a(300L);
                                    ja().a(fa()).onResultAvailable(new Lf(this)).onFailure((Task.OnFailListener) new Jf(this));
                                    return;
                                case R.id.action_capture_insert_right /* 2131361840 */:
                                    s(false);
                                    q(false);
                                    r(false);
                                    this.Aa.a(300L);
                                    ja().a(fa()).onResultAvailable(new Rf(this)).onFailure((Task.OnFailListener) new Pf(this));
                                    return;
                                case R.id.action_capture_save /* 2131361841 */:
                                    s(false);
                                    q(false);
                                    r(false);
                                    this.Aa.a(300L);
                                    ja().a(fa()).onResultAvailable(new If(this)).onFailure((Task.OnFailListener) new Hf(this));
                                    return;
                                case R.id.action_capture_split_insert /* 2131361842 */:
                                    int T = T();
                                    s(false);
                                    q(false);
                                    r(false);
                                    this.Aa.a(300L);
                                    ja().a(fa()).onResultAvailable(new Gf(this, T)).onFailure((Task.OnFailListener) new Cf(this));
                                    return;
                                default:
                                    switch (i) {
                                        case R.id.action_duplicate_clip /* 2131361849 */:
                                            NexTimelineItem selectedItem5 = this.T.getSelectedItem();
                                            if (selectedItem5 instanceof NexPrimaryTimelineItem) {
                                                ja().a((VideoEditor) selectedItem5);
                                            } else if (selectedItem5 instanceof NexSecondaryTimelineItem) {
                                                ja().a((VideoEditor) selectedItem5);
                                            }
                                            ja().N();
                                            Fragment findFragmentById2 = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
                                            if (findFragmentById2 == null) {
                                                findFragmentById2 = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
                                            }
                                            if (!b(findFragmentById2).booleanValue()) {
                                                ja().J();
                                            }
                                            this.T.f();
                                            this.T.invalidate();
                                            this.T.d();
                                            return;
                                        case R.id.action_duplicate_clip_as_layer /* 2131361850 */:
                                            if (this.T.getSelectedItem() instanceof NexVideoClipItem) {
                                                za();
                                                ja().N();
                                                Fragment findFragmentById3 = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
                                                if (findFragmentById3 == null) {
                                                    findFragmentById3 = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
                                                }
                                                if (!b(findFragmentById3).booleanValue()) {
                                                    ja().J();
                                                }
                                                this.T.f();
                                                this.T.invalidate();
                                                this.T.d();
                                                return;
                                            }
                                            return;
                                        case R.id.action_expand_preview /* 2131361851 */:
                                            this.ea = !this.ea;
                                            w(this.da);
                                            if (this.ea) {
                                                c(R.id.action_expand_preview);
                                                return;
                                            } else {
                                                d(R.id.action_expand_preview);
                                                return;
                                            }
                                        case R.id.action_expand_timeline /* 2131361852 */:
                                            c(!pa(), true);
                                            return;
                                        default:
                                            switch (i) {
                                                case R.id.action_multi_select /* 2131361861 */:
                                                    Ea();
                                                    return;
                                                case R.id.action_overflow /* 2131361862 */:
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case R.id.action_pin /* 2131361864 */:
                                                            NexTimelineItem selectedItem6 = this.T.getSelectedItem();
                                                            if (selectedItem6 == null || !(selectedItem6 instanceof NexSecondaryTimelineItem)) {
                                                                return;
                                                            }
                                                            ((NexSecondaryTimelineItem) selectedItem6).setPinned(!r9.getPinned());
                                                            ja().J();
                                                            this.T.b(selectedItem6);
                                                            va();
                                                            return;
                                                        case R.id.action_play_pause /* 2131361865 */:
                                                            if (ja().w() != VideoEditor.State.Idle && ja().w() != VideoEditor.State.PreparingToPlay) {
                                                                if (ja().w().isPlaying()) {
                                                                    ja().M();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            if (N()) {
                                                                return;
                                                            }
                                                            if (ja().C()) {
                                                                Toast.makeText(this, R.string.file_prep_busy, 0).show();
                                                                return;
                                                            }
                                                            Fragment findFragmentById4 = getSupportFragmentManager().findFragmentById(R.id.aboveTimelineFragmentHolder);
                                                            if (findFragmentById4 != null && ((findFragmentById4 instanceof C1829g) || (findFragmentById4 instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a))) {
                                                                i(true);
                                                            }
                                                            if (this.T.k()) {
                                                                ja().b(0).onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.ui.projectedit.g
                                                                    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
                                                                    public final void onTaskEvent(Task task, Task.Event event) {
                                                                        ProjectEditActivity.this.b(task, event);
                                                                    }
                                                                });
                                                                return;
                                                            } else {
                                                                this.Na++;
                                                                ja().D().onFailure(new C2083yf(this));
                                                                return;
                                                            }
                                                        case R.id.action_redo /* 2131361866 */:
                                                            H();
                                                            return;
                                                        case R.id.action_reverse_clip /* 2131361867 */:
                                                            NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) this.T.getSelectedItem();
                                                            File a2 = c.d.b.k.b.a(u(), new File(nexVideoClipItem.getMediaPath()));
                                                            if (a2.exists()) {
                                                                NexVideoClipItem nexVideoClipItem2 = (NexVideoClipItem) ja().a((VideoEditor) nexVideoClipItem, this.T.c() > this.T.getSelectedIndex());
                                                                if (nexVideoClipItem2 != null) {
                                                                    ja().N();
                                                                    nexVideoClipItem2.setReversePath(a2.getAbsolutePath());
                                                                    nexVideoClipItem2.setReverseState(true);
                                                                    nexVideoClipItem2.setTrimStart(nexVideoClipItem.getTrimTimeEnd() - (nexVideoClipItem.getDuration() - nexVideoClipItem2.getDuration()));
                                                                    nexVideoClipItem2.setTrimEnd(nexVideoClipItem.getTrimTimeStart());
                                                                    ja().c(nexVideoClipItem2);
                                                                    ja().J();
                                                                    this.T.f();
                                                                    this.T.invalidate();
                                                                    this.T.d();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        case R.id.action_seek_to_end /* 2131361868 */:
                                                            a(ja().s().a().getTotalTime(), true);
                                                            return;
                                                        case R.id.action_seek_to_start /* 2131361869 */:
                                                            a(0, true);
                                                            ja().b(0);
                                                            return;
                                                        case R.id.action_send_backward /* 2131361870 */:
                                                            this.T.getCurrentTime();
                                                            NexTimelineItem selectedItem7 = this.T.getSelectedItem();
                                                            if (selectedItem7 == null || !(selectedItem7 instanceof NexLayerItem)) {
                                                                return;
                                                            }
                                                            ja().b((NexLayerItem) selectedItem7, this.T.getCurrentTime());
                                                            ja().H();
                                                            ja().J();
                                                            return;
                                                        case R.id.action_send_to_back /* 2131361871 */:
                                                            NexTimelineItem selectedItem8 = this.T.getSelectedItem();
                                                            if (selectedItem8 == null || !(selectedItem8 instanceof NexLayerItem)) {
                                                                return;
                                                            }
                                                            ja().e((NexLayerItem) selectedItem8);
                                                            ja().H();
                                                            ja().J();
                                                            return;
                                                        case R.id.action_settings /* 2131361872 */:
                                                            ta();
                                                            return;
                                                        case R.id.action_share /* 2131361873 */:
                                                            if (this.T.getTimeline().getPrimaryItemCount() < 1) {
                                                                return;
                                                            }
                                                            ja().M();
                                                            this.Sa.a(this.N, y().e(), true).onComplete(new Uf(this));
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    I();
                    return;
                }
            }
            if (getSupportFragmentManager() == null || getSupportFragmentManager().getBackStackEntryCount() >= 1) {
                weakReference = interfaceC1976p != null ? new WeakReference(interfaceC1976p) : null;
                PopoutListMenu popoutListMenu2 = new PopoutListMenu(u());
                if (this.ua == null) {
                    this.ua = new WeakReference<>(popoutListMenu2);
                }
                for (d dVar : this.wa) {
                    popoutListMenu2.a(dVar.f22025a, dVar.f22026b, dVar.f22027c);
                }
                popoutListMenu2.a(i(i), 21);
                popoutListMenu2.a(new Sf(this, weakReference));
                popoutListMenu2.a(new Tf(this));
                return;
            }
            return;
        }
        InterfaceC2025f interfaceC2025f = this.T;
        if ((interfaceC2025f instanceof UniformTimelineView) && ((UniformTimelineView) interfaceC2025f).getSelectedTrack() != null) {
            R();
        } else if (oa()) {
            Q();
        } else {
            P();
        }
        ja().J();
        xa();
    }

    public void a(int i, boolean z) {
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f instanceof UniformTimelineView) {
            ((UniformTimelineView) interfaceC2025f).c(i, z);
        } else {
            interfaceC2025f.a(i, z);
        }
    }

    public /* synthetic */ void a(boolean z, c cVar) {
        cVar.a(ja(), z);
        VideoEditor.State state = this._a;
        if (state == VideoEditor.State.Playing || state == VideoEditor.State.ReversePlay || state == VideoEditor.State.Exporting || z) {
            return;
        }
        ja().b(this.T.getCurrentTime());
    }

    public static FragmentTransaction a(FragmentTransaction fragmentTransaction) {
        return fragmentTransaction.setCustomAnimations(R.animator.optpanel_slide_in_from_right, R.animator.optpanel_fade_out, R.animator.optpanel_fade_in, R.animator.optpanel_slide_out_to_right);
    }

    public static FragmentTransaction a(FragmentTransaction fragmentTransaction, boolean z) {
        return fragmentTransaction.setCustomAnimations(z ? R.animator.optpanel_expanded_slide_in_from_right : R.animator.optpanel_slide_in_from_right, R.animator.optpanel_fade_out, R.animator.optpanel_fade_in, z ? R.animator.optpanel_expanded_slide_out_from_right : R.animator.optpanel_slide_out_to_right);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.e
    public void a(File file) {
        this.N = file;
    }

    public void a(Tb tb) {
        this.oa.a((com.nexstreaming.app.general.util.u<Tb>) tb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, com.nexstreaming.kinemaster.ui.settings.tb.a(y(), 0, str, str2, 0), com.nexstreaming.kinemaster.ui.settings.tb.f23200a).addToBackStack(com.nexstreaming.kinemaster.ui.settings.tb.f23200a).commitAllowingStateLoss();
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, int i, boolean z2) {
        if (!z) {
            ya();
        }
        if (!c.d.b.m.i.f(this) && z2) {
            ya();
            Toast.makeText(this, getString(R.string.theme_download_server_connection_error), 0).show();
        }
        g(y().t());
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap, IABError iABError, String str) {
        ya();
        runOnUiThread(new RunnableC2000rg(this, linkedHashMap != null && y().t()));
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, Purchase purchase, String str) {
        super.b(z, purchase, str);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if (findFragmentById instanceof com.nexstreaming.kinemaster.ui.settings.tb) {
            String z2 = ((com.nexstreaming.kinemaster.ui.settings.tb) findFragmentById).z();
            if (z) {
                try {
                    i(true);
                    Fragment findFragmentById2 = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
                    if (findFragmentById2 == null) {
                        findFragmentById2 = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
                    }
                    if (b(findFragmentById2).booleanValue()) {
                        ja().c(ia().getSelectedItem());
                        ja().H();
                        ja().J();
                        if (d(z2).booleanValue()) {
                            e(true);
                            return;
                        }
                        h(true);
                    }
                    if (z2.equals("selected_reverse")) {
                        h(this.T.getSelectedItem());
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    Fragment findFragmentById3 = getSupportFragmentManager().findFragmentById(android.R.id.content);
                    if (findFragmentById3 instanceof com.nexstreaming.kinemaster.ui.settings.tb) {
                        ((com.nexstreaming.kinemaster.ui.settings.tb) findFragmentById3).b(true);
                        return;
                    }
                    return;
                }
            }
            if (z2.equals("selected_reverse")) {
                KMEvents.EDIT_REVERSE_VIDEO.trackReverse("cancel_purchase");
                return;
            }
            Fragment findFragmentById4 = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
            if (findFragmentById4 == null) {
                findFragmentById4 = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
            }
            if (b(findFragmentById4).booleanValue()) {
                if (d(z2).booleanValue()) {
                    e(true);
                } else {
                    h(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I
    public void a(Context context) {
        super.a(context);
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.tb.a
    public void a(String str) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
        if (findFragmentById == null) {
            findFragmentById = getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
        }
        if (b(findFragmentById).booleanValue()) {
            if (d(str).booleanValue()) {
                e(true);
                return;
            }
            i(false);
        }
        i(false);
    }

    public void a(UniformTimelineView.c cVar) {
        InterfaceC2025f interfaceC2025f = this.T;
        if (interfaceC2025f instanceof UniformTimelineView) {
            ((UniformTimelineView) interfaceC2025f).setMulitSelectListener(cVar);
        }
    }
}

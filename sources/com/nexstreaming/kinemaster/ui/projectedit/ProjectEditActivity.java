package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepState;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nexstreaming.kinemaster.ui.settings.aw;
import com.nexstreaming.kinemaster.ui.share.ShareActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexeditorui.ProjectSettingsPopup;
import com.nextreaming.nexeditorui.WhichTimeline;
import com.nextreaming.nexeditorui.newproject.b.f;
import com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment;
import com.nextreaming.nexvideoeditor.NexThemeView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ProjectEditActivity extends com.nextreaming.nexeditorui.aw implements FragmentManager.OnBackStackChangedListener, VideoEditor.e, VideoEditor.f, VideoEditor.g, VideoEditor.h, VideoEditor.i, MediaPrepManager.a, aw.a, com.nextreaming.nexeditorui.bp, f.a, MediaBrowserFragment.b {
    private float B;
    private float C;
    private float D;
    private float E;
    private WeakReference<ht> F;
    private WeakReference<com.nexstreaming.kinemaster.ui.widget.g> G;
    private ht H;
    private MediaPrepManager K;
    private boolean L;
    private TextView M;
    private View N;
    private Toast Z;

    /* renamed from: a */
    TimelineActionButtonMode f3741a;
    private Runnable ad;
    private LinearLayout e;
    private LinearLayout f;
    private VideoEditor g;
    private File h;
    private NexThemeView i;
    private NexThemeView j;
    private TimelineView k;
    private ImageView l;
    private ImageView m;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private View x;
    private int y;
    private com.nexstreaming.app.general.util.q n = new com.nexstreaming.app.general.util.q();
    private com.nexstreaming.app.general.util.q o = new com.nexstreaming.app.general.util.q();
    private Handler z = new Handler();
    private com.nexstreaming.app.general.util.m<cd> A = new com.nexstreaming.app.general.util.m<>();
    private List<d> I = new ArrayList();
    private boolean J = false;
    private boolean O = false;
    private int P = -1;
    private boolean Q = false;
    private boolean R = false;
    private int S = -1;
    private int T = 0;
    private String U = null;
    private long V = 0;
    private int W = 0;
    private BroadcastReceiver X = new hu(this);
    private boolean Y = false;
    private long aa = 0;
    private Runnable ab = new ik(this);
    private View.OnTouchListener ac = new jv(this);
    private TimelineView.d ae = new jw(this);

    /* loaded from: classes.dex */
    public enum InsertPosition {
        BeforeSelected,
        AfterSelected,
        CurrentTime
    }

    /* loaded from: classes.dex */
    public enum TimelineActionButtonMode {
        SecondaryItemSelected,
        NoItemSelectedScrolledToStart,
        NoItemSelectedScrolledToMid,
        NoItemSelectedScrolledToStartExpanded,
        NoItemSelectedScrolledToMidExpanded
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(ProjectEditActivity projectEditActivity);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(NexVideoClipItem nexVideoClipItem);
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("SAVE_PRIMARY_ITEM_COUNT", this.k.getTimeline().getPrimaryItemCount());
            bundle.putInt("SAVE_SELECTED_ITEM_INDEX", this.k.getSelectedIndex());
            if (this.k.getSelectedItem() != null && (this.k.getSelectedItem() instanceof NexPrimaryTimelineItem)) {
                bundle.putBoolean("SAVE_PRIMARY_ITEM", true);
            } else if (this.k.getSelectedItem() != null && (this.k.getSelectedItem() instanceof NexSecondaryTimelineItem)) {
                bundle.putBoolean("SAVE_SECONDARY_ITEM", true);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    public static Intent a(Context context, File file) {
        Intent intent = new Intent(context, (Class<?>) ProjectEditActivity.class);
        intent.setData(Uri.fromFile(file));
        return intent;
    }

    public static Intent a(Context context, List<MediaStoreItem> list, ArrayList<String> arrayList, String str, String str2, Theme theme, File file) {
        Intent intent = new Intent(context, (Class<?>) ProjectEditActivity.class);
        intent.setAction("assistant");
        if (list != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<MediaStoreItem> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().c().toString());
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
        if (theme != null) {
            intent.putExtra("ProjectEditActivity.theme", theme.i());
        }
        intent.setData(Uri.fromFile(file));
        return intent;
    }

    private void a(Intent intent) {
        String stringExtra;
        KMIntentData kMIntentData;
        MediaStoreItem a2;
        MediaStore x = x();
        if (x != null && intent != null && (stringExtra = intent.getStringExtra(KMIntentData.KEY_KINEMASTER_INTENT_PROJET_DATA)) != null && (kMIntentData = (KMIntentData) new Gson().fromJson(stringExtra, KMIntentData.class)) != null) {
            KMIntentData.Project project = kMIntentData.project;
            Task task = new Task();
            task.onComplete(new ig(this, project));
            if (project.visualClips != null && project.visualClips.size() > 0) {
                int size = project.visualClips.size() - 1;
                while (size >= 0) {
                    KMIntentData.VisualClip visualClip = project.visualClips.get(size);
                    boolean z = size <= 0;
                    if (visualClip != null) {
                        MSID a3 = com.nexstreaming.kinemaster.mediastore.v2.providers.j.a(this, visualClip.path);
                        if (a3 == null) {
                            a3 = AndroidMediaStoreProvider.a(new File(visualClip.path));
                        }
                        if (a3 != null && (a2 = x.a(a3)) != null) {
                            x.a(a2, new is(this, a2, visualClip, z, task));
                        }
                    }
                    size--;
                }
                return;
            }
            task.signalEvent(Task.Event.COMPLETE);
        }
    }

    private void b(Intent intent) {
        MediaStore x = x();
        if (intent != null && x != null) {
            ArrayList arrayList = null;
            HashSet<MediaStoreItem> hashSet = null;
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("ProjectEditActivity.titles");
            String stringExtra = intent.getStringExtra("ProjectEditActivity.musicPath");
            String stringExtra2 = intent.getStringExtra("ProjectEditActivity.musicName");
            Theme theme = null;
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("ProjectEditActivity.primaryClips");
            String stringExtra3 = intent.getStringExtra("ProjectEditActivity.theme");
            EffectLibrary a2 = EffectLibrary.a(this);
            if (stringExtra3 != null) {
                theme = a2.e(stringExtra3);
            }
            if (stringArrayListExtra2 != null) {
                ArrayList arrayList2 = new ArrayList(stringArrayListExtra2.size());
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = stringArrayListExtra2.iterator();
                while (it.hasNext()) {
                    MSID msid = new MSID(it.next());
                    MediaStoreItem a3 = x.a(msid);
                    arrayList2.add(msid);
                    if (a3 != null) {
                        hashSet2.add(a3);
                    }
                }
                hashSet = hashSet2;
                arrayList = arrayList2;
            }
            if (hashSet == null || hashSet.size() < 1) {
                a(arrayList, stringArrayListExtra, stringExtra, stringExtra2, theme, null);
                return;
            }
            int[] iArr = {hashSet.size()};
            HashMap hashMap = new HashMap();
            for (MediaStoreItem mediaStoreItem : hashSet) {
                x.b(mediaStoreItem).onResultAvailable(new kc(this, hashMap, mediaStoreItem.c(), iArr, arrayList, stringArrayListExtra, stringExtra, stringExtra2, theme)).onFailure((Task.OnFailListener) new jm(this, iArr, arrayList, stringArrayListExtra, stringExtra, stringExtra2, theme, hashMap));
            }
        }
    }

    private Task c(Intent intent) {
        this.h = null;
        if (intent == null) {
            return null;
        }
        intent.getAction();
        String string = getResources().getString(R.string.default_project_name);
        if (intent.getData() != null && intent.getData().toString() != null) {
            try {
                this.h = new File(new URI(intent.getData().toString()));
            } catch (URISyntaxException e) {
                Log.e("ProjectEditActivity", "", e);
            }
        }
        if (this.h != null && this.h.exists()) {
            p().b(this.h);
            return null;
        }
        if (this.h == null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 10000) {
                    break;
                }
                File file = new File(EditorGlobal.j().getAbsolutePath(), string + (i2 > 0 ? " " + i2 : "") + VideoEditor.a());
                File file2 = new File(EditorGlobal.j().getAbsolutePath(), string + (i2 > 0 ? " " + i2 : "") + ".nexvideoproject");
                if (file.exists() || file2.exists()) {
                    i = i2 + 1;
                } else {
                    this.h = file;
                    break;
                }
            }
        }
        return p().a(this.h, new km(this, intent)).onComplete(new kl(this, intent));
    }

    public void d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null && action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) {
                a(intent);
            } else {
                b(intent);
            }
        }
    }

    public boolean a(Theme theme, ArrayList<String> arrayList, boolean z) {
        boolean z2;
        File h;
        boolean z3;
        boolean z4;
        if (!z || (h = EffectLibrary.a(this).h(theme.i())) == null) {
            z2 = false;
        } else {
            NexTimeline a2 = p().f().a();
            int secondaryItemCount = a2.getSecondaryItemCount();
            int i = 0;
            while (true) {
                if (i >= secondaryItemCount) {
                    z3 = false;
                    z4 = false;
                    z2 = false;
                    break;
                }
                NexSecondaryTimelineItem secondaryItem = a2.getSecondaryItem(i);
                if (secondaryItem instanceof NexAudioClipItem) {
                    NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) secondaryItem;
                    if (nexAudioClipItem.getAbsStartTime() < 500 && nexAudioClipItem.getMediaPath().endsWith(".tmp") && nexAudioClipItem.isLoop() && nexAudioClipItem.isExtendToEnd() && nexAudioClipItem.isBGM()) {
                        p().c(nexAudioClipItem);
                        z3 = false;
                        z4 = true;
                        z2 = true;
                        break;
                    }
                    if (nexAudioClipItem.isBGM()) {
                        z3 = true;
                        z4 = false;
                        z2 = false;
                        break;
                    }
                }
                i++;
            }
            if (z4 || !z3) {
                NexAudioClipItem a3 = p().a(p().u(), h.getAbsolutePath(), false);
                a3.setTitle(theme.a(this));
                a3.setPinned(true);
                a3.setLoop(true);
                a3.setExtendToEnd(true);
                a3.setBGM(true);
                z2 = true;
            }
        }
        if (com.nexstreaming.kinemaster.f.d.a(theme).a(this, p().f(), arrayList)) {
            return true;
        }
        return z2;
    }

    public void a(List<MSID> list, ArrayList<String> arrayList, String str, String str2, Theme theme, Map<MSID, Bitmap> map) {
        boolean z = false;
        if (list != null) {
            this.K.a(list);
            for (int size = list.size() - 1; size >= 0; size--) {
                MSID msid = list.get(size);
                a(msid, x().a(msid), map == null ? null : map.get(msid), InsertPosition.CurrentTime, false, false, (c) null);
            }
            z = true;
        }
        if (str != null) {
            NexAudioClipItem a2 = p().a(p().u(), str, false);
            a2.setTitle(str2);
            a2.setPinned(true);
            a2.setLoop(true);
            a2.setExtendToEnd(true);
            a2.setBGM(true);
            z = true;
        }
        if (a(theme, arrayList, false)) {
            z = true;
        }
        if (z) {
            p().C();
            p().k();
            p().m();
            return;
        }
        p().a(p().f());
    }

    @Override // com.nexstreaming.kinemaster.mediaprep.MediaPrepManager.a
    public void a(MSID msid, com.nexstreaming.kinemaster.mediaprep.a aVar) {
        NexPrimaryTimelineItem nexPrimaryTimelineItem;
        NexPrimaryTimelineItem nexPrimaryTimelineItem2 = null;
        if (aVar.f3523a == MediaPrepState.Completed && aVar.g != null) {
            NexTimelineItem selectedItem = this.k.getSelectedItem();
            boolean z = (selectedItem == null || selectedItem.isClipReady() || !msid.equals(selectedItem.getMediaMSID())) ? false : true;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            NexVideoClipItem.CropMode fromString = NexVideoClipItem.CropMode.fromString(defaultSharedPreferences.getString("add_img_def_crop", "panface"));
            int parseInt = Integer.parseInt(defaultSharedPreferences.getString("add_img_def_duration", "6000"));
            NexTimeline.c beginTimeChange = this.k.getTimeline().beginTimeChange();
            p().f().a().applyFinalPathForMSID(msid, aVar.g, fromString, parseInt);
            beginTimeChange.a();
            p().C();
            this.k.e();
            p().m();
            if (z) {
                this.Y = false;
                this.k.k();
                new Handler().post(new kn(this, selectedItem));
            }
        } else if (aVar.f3523a == MediaPrepState.UserInterventionRequired && aVar.f != null) {
            aVar.f.run();
        } else if (aVar.f3523a == MediaPrepState.UserInterventionCancel) {
            NexTimeline.c beginTimeChange2 = this.k.getTimeline().beginTimeChange();
            NexTimeline a2 = p().f().a();
            ArrayList arrayList = new ArrayList();
            int primaryItemCount = a2.getPrimaryItemCount();
            int i = 0;
            NexPrimaryTimelineItem nexPrimaryTimelineItem3 = null;
            while (i < primaryItemCount) {
                NexPrimaryTimelineItem primaryItem = a2.getPrimaryItem(i);
                if (msid.equals(primaryItem.getMediaMSID())) {
                    nexPrimaryTimelineItem = nexPrimaryTimelineItem2 == null ? nexPrimaryTimelineItem3 : nexPrimaryTimelineItem2;
                    arrayList.add(primaryItem);
                } else {
                    nexPrimaryTimelineItem = nexPrimaryTimelineItem2;
                    nexPrimaryTimelineItem3 = primaryItem;
                }
                i++;
                nexPrimaryTimelineItem2 = nexPrimaryTimelineItem;
            }
            int secondaryItemCount = a2.getSecondaryItemCount();
            for (int i2 = 0; i2 < secondaryItemCount; i2++) {
                NexSecondaryTimelineItem secondaryItem = a2.getSecondaryItem(i2);
                if (msid.equals(secondaryItem.getMediaMSID())) {
                    arrayList.add(secondaryItem);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                p().c((NexTimelineItem) it.next());
            }
            beginTimeChange2.a();
            p().C();
            this.k.e();
            if (arrayList.size() > 0) {
                if (nexPrimaryTimelineItem2 != null) {
                    this.k.a((NexTimelineItem) nexPrimaryTimelineItem2, true, false);
                } else {
                    this.k.c(0);
                }
            }
            p().m();
            M();
        } else if (aVar != null && (aVar.f3523a == MediaPrepState.Downloading || aVar.f3523a == MediaPrepState.Transcoding || aVar.f3523a == MediaPrepState.FailDownload || aVar.f3523a == MediaPrepState.FailTranscoding || aVar.f3523a == MediaPrepState.FailedCanRetry)) {
            NexTimelineItem selectedItem2 = this.k.getSelectedItem();
            kp kpVar = (kp) getFragmentManager().findFragmentById(R.id.optionPanelHolder);
            if (kpVar != null && (kpVar instanceof ex) && selectedItem2 != null) {
                kpVar.f();
            }
        }
        this.k.invalidate();
    }

    @Override // com.nextreaming.nexeditorui.newproject.b.f.a
    public void a(Theme theme) {
        if (theme != null) {
            new a.C0074a(this).f(R.string.theme_change_warning_title).a(R.string.theme_change_warning_text).a(R.string.theme_change_warning_ok, new hv(this, theme)).b(R.string.button_cancel, new ko(this)).a().show();
        }
    }

    @Override // com.nextreaming.nexeditorui.newproject.b.f.a
    public void b() {
    }

    public void a(int i) {
        this.M.setText(i);
        this.M.setVisibility(0);
    }

    public void c() {
        this.M.setVisibility(4);
    }

    public SurfaceView d() {
        return (SurfaceView) findViewById(R.id.scratchSurfaceView);
    }

    public void e() {
        this.U = "exit button";
        finish();
    }

    public boolean a(String str) {
        String mediaPath;
        if (this.k == null || this.k.getTimeline() == null) {
            return false;
        }
        NexTimeline timeline = this.k.getTimeline();
        for (int i = 0; i < timeline.getPrimaryItemCount(); i++) {
            if (timeline.getPrimaryItem(i) != null && (timeline.getPrimaryItem(i) instanceof NexVideoClipItem)) {
                String mediaPath2 = ((NexVideoClipItem) timeline.getPrimaryItem(i)).getMediaPath();
                if (str != null && mediaPath2 != null && mediaPath2.equals(str)) {
                    return true;
                }
            }
        }
        for (int i2 = 0; i2 < timeline.getSecondaryItemCount(); i2++) {
            if (timeline.getSecondaryItem(i2) != null && ((timeline.getSecondaryItem(i2) instanceof VideoLayer) || (timeline.getSecondaryItem(i2) instanceof ImageLayer))) {
                if (timeline.getSecondaryItem(i2) instanceof VideoLayer) {
                    mediaPath = ((VideoLayer) timeline.getSecondaryItem(i2)).getMediaPath();
                } else if (timeline.getSecondaryItem(i2) instanceof ImageLayer) {
                    mediaPath = ((ImageLayer) timeline.getSecondaryItem(i2)).getMediaPath();
                } else {
                    continue;
                }
                if (str != null && mediaPath != null && mediaPath.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public float b(NexTimelineItem nexTimelineItem) {
        if (this.k.a(nexTimelineItem) != null) {
            return r0.width();
        }
        return 0.0f;
    }

    public boolean f() {
        if (!com.nexstreaming.kinemaster.g.b.a()) {
            return false;
        }
        if (this.Z != null) {
            this.Z.cancel();
        }
        this.Z = Toast.makeText(this, R.string.unavailable_busy_transcoding, 1);
        this.Z.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.aw, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.project_editor_activity);
        this.Q = true;
        this.K = new MediaPrepManager(this, x(), NexVideoClipItem.CropMode.fromString(PreferenceManager.getDefaultSharedPreferences(this).getString("add_img_def_crop", "panface")).needsFaceDetection());
        this.K.a(this);
        this.i = (NexThemeView) findViewById(R.id.previewView);
        this.j = (NexThemeView) findViewById(R.id.previewViewForExpanded);
        this.g = new VideoEditor(E(), this, false, this.i);
        N();
        this.e = (LinearLayout) findViewById(R.id.projectActionBar);
        this.f = (LinearLayout) findViewById(R.id.timelineActionBar);
        this.x = findViewById(R.id.layoutBase);
        this.M = (TextView) findViewById(R.id.previewViewCover);
        this.k = (TimelineView) findViewById(R.id.timeline);
        this.k.setVisibility(8);
        this.k.setListener(this.ae);
        this.k.setMediaPrepManager(this.K);
        this.N = findViewById(R.id.bookmark);
        if (bundle == null) {
            getFragmentManager().beginTransaction().replace(R.id.optionPanelHolder, new ez()).commit();
        }
        View findViewById = findViewById(R.id.previewViewLayout);
        this.e.startAnimation(AnimationUtils.loadAnimation(this, R.anim.projevct_action_bar_translate));
        this.f.startAnimation(AnimationUtils.loadAnimation(this, R.anim.project_bottom_view_translate));
        b(R.id.action_change_theme);
        b(R.id.action_share);
        this.k.startAnimation(AnimationUtils.loadAnimation(this, R.anim.project_bottom_view_translate));
        findViewById(R.id.optionPanelHolder).startAnimation(AnimationUtils.loadAnimation(this, R.anim.project_option_panel_translate));
        findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.anim.project_preview_scale));
        this.i.setOnTouchListener(new hw(this));
        this.l = (ImageView) findViewById(R.id.removeWatermarkBtn);
        this.m = (ImageView) findViewById(R.id.removeWatermarkView);
        this.i.addOnLayoutChangeListener(new hx(this));
        this.l.setOnClickListener(new hy(this));
        if (bundle != null) {
            int i = bundle.getInt("SAVE_SELECTED_ITEM_INDEX");
            this.T = bundle.getInt("SAVE_PRIMARY_ITEM_COUNT");
            if (i >= 0) {
                this.S = i;
                boolean z = bundle.getBoolean("SAVE_PRIMARY_ITEM");
                boolean z2 = bundle.getBoolean("SAVE_SECONDARY_ITEM");
                if (z) {
                    this.R = true;
                } else if (z2) {
                    this.R = false;
                }
            }
        }
        Task c2 = c(getIntent());
        if (bundle == null && c2 != null && getIntent() != null && getIntent() != null && getIntent().getExtras() != null) {
            c2.onComplete(new hz(this));
        }
        this.N.setOnClickListener(new ia(this));
        this.N.setOnLongClickListener(new ib(this));
        a(R.id.action_expand_timeline, R.drawable.action_icon_expand_timeline, R.id.action_seek_to_start, R.drawable.action_icon_seek_to_start);
        if (p().t() == VideoEditor.State.Idle) {
            f(R.id.action_play_pause);
        }
        getFragmentManager().addOnBackStackChangedListener(this);
        this.j.setOnTouchListener(this.ac);
        registerReceiver(this.X, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        p().c(false);
        p().a(EditorGlobal.c("up"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.aw, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        KMUsage.Activity_EditScreen.begin();
        KMUsage.timeEvent(this, "Exit Project");
        this.U = null;
        super.onStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Fragment fragment) {
        if (fragment instanceof ht) {
            this.F = new WeakReference<>((ht) fragment);
        }
        if (this.r) {
            a(new int[]{R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_play_pause, R.drawable.action_play_pause, R.id.action_expand_preview, R.drawable.action_inset_preview}, (com.nexstreaming.kinemaster.ui.projectedit.a) null);
        }
    }

    public View g() {
        return this.i;
    }

    public int h() {
        if (this.i == null) {
            return 0;
        }
        return this.i.getWidth();
    }

    public int i() {
        if (this.i == null) {
            return 0;
        }
        return this.i.getHeight();
    }

    public void j() {
        TimelineActionButtonMode timelineActionButtonMode;
        if (p() != null && p().f() != null) {
            if (this.k.getTimeline().getPrimaryItemCount() < 1) {
                b(R.id.action_share);
                b(R.id.action_change_theme);
            } else {
                c(R.id.action_share);
                c(R.id.action_change_theme);
            }
            NexTimelineItem selectedItem = this.k.getSelectedItem();
            if (selectedItem == null) {
                if (p().u() > p().f().a().getTotalTime() - (this.k.getMSPerPixel() + 33)) {
                    timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToMid;
                    b(R.id.action_seek_to_end);
                    c(R.id.action_seek_to_start);
                } else if (p().u() > 10) {
                    timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToMid;
                    if (p().t() == VideoEditor.State.Playing) {
                        b(R.id.action_seek_to_end);
                        b(R.id.action_seek_to_start);
                    } else {
                        c(R.id.action_seek_to_end);
                        c(R.id.action_seek_to_start);
                    }
                } else {
                    timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToStart;
                    if (p().t() == VideoEditor.State.Playing) {
                        b(R.id.action_seek_to_end);
                        b(R.id.action_seek_to_start);
                    } else {
                        c(R.id.action_seek_to_end);
                        b(R.id.action_seek_to_start);
                    }
                }
            } else if (selectedItem instanceof NexSecondaryTimelineItem) {
                TimelineActionButtonMode timelineActionButtonMode2 = TimelineActionButtonMode.SecondaryItemSelected;
                b(R.id.action_seek_to_end);
                b(R.id.action_seek_to_start);
                if (((NexSecondaryTimelineItem) selectedItem).getPinned()) {
                    f(R.id.action_pin);
                    timelineActionButtonMode = timelineActionButtonMode2;
                } else {
                    g(R.id.action_pin);
                    timelineActionButtonMode = timelineActionButtonMode2;
                }
            } else if (selectedItem instanceof NexPrimaryTimelineItem) {
                b(R.id.action_seek_to_end);
                b(R.id.action_seek_to_start);
                timelineActionButtonMode = p().u() > p().f().a().getTotalTime() + (-33) ? TimelineActionButtonMode.NoItemSelectedScrolledToMid : p().u() > 10 ? TimelineActionButtonMode.NoItemSelectedScrolledToMid : TimelineActionButtonMode.NoItemSelectedScrolledToStart;
            } else {
                timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToMid;
                b(R.id.action_seek_to_end);
                b(R.id.action_seek_to_start);
            }
            if (timelineActionButtonMode == TimelineActionButtonMode.NoItemSelectedScrolledToMid && this.r) {
                timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToMidExpanded;
            }
            if (timelineActionButtonMode == TimelineActionButtonMode.NoItemSelectedScrolledToStart && this.r) {
                timelineActionButtonMode = TimelineActionButtonMode.NoItemSelectedScrolledToStartExpanded;
            }
            if (timelineActionButtonMode != this.f3741a) {
                this.f3741a = timelineActionButtonMode;
                switch (this.f3741a) {
                    case NoItemSelectedScrolledToStart:
                        a(R.id.action_expand_timeline, R.drawable.action_icon_expand_timeline, R.id.action_seek_to_end, R.drawable.action_icon_seek_to_end);
                        return;
                    case NoItemSelectedScrolledToStartExpanded:
                        a(R.id.action_expand_timeline, R.drawable.action_collapse_timeline, R.id.action_seek_to_end, R.drawable.action_icon_seek_to_end);
                        return;
                    case SecondaryItemSelected:
                        a(R.id.action_expand_timeline, R.drawable.action_icon_expand_timeline, R.id.action_pin, R.drawable.action_icon_pin);
                        return;
                    case NoItemSelectedScrolledToMidExpanded:
                        a(R.id.action_expand_timeline, R.drawable.action_collapse_timeline, R.id.action_seek_to_start, R.drawable.action_icon_seek_to_start);
                        return;
                    default:
                        a(R.id.action_expand_timeline, R.drawable.action_icon_expand_timeline, R.id.action_seek_to_start, R.drawable.action_icon_seek_to_start);
                        return;
                }
            }
        }
    }

    public void a(int[] iArr, com.nexstreaming.kinemaster.ui.projectedit.a aVar) {
        a(this.e, iArr, aVar, this.I);
    }

    public void a(int... iArr) {
        b(iArr, (com.nexstreaming.kinemaster.ui.projectedit.a) null);
    }

    public void b(int[] iArr, com.nexstreaming.kinemaster.ui.projectedit.a aVar) {
        a(this.f, iArr, aVar, (List<d>) null);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        if (p().t() == VideoEditor.State.Playing && !this.L) {
            if (this.P < 0 || Math.abs(i2 - this.P) >= 15) {
                this.k.c(i2);
                this.P = i2;
            } else {
                return;
            }
        }
        j();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.f
    public void a(VideoEditor.State state) {
        this.P = -1;
        if (state == VideoEditor.State.Playing && !this.O) {
            getWindow().addFlags(128);
            this.O = true;
        } else if (state != VideoEditor.State.Playing && this.O) {
            getWindow().clearFlags(128);
            this.O = false;
        }
        this.k.setPlaying(state == VideoEditor.State.Playing);
        if (state == VideoEditor.State.Idle) {
            c(R.id.action_play_pause);
            f(R.id.action_play_pause);
        } else if (state == VideoEditor.State.PreparingToPlay) {
            b(R.id.action_play_pause);
            f(R.id.action_play_pause);
        } else if (state == VideoEditor.State.Playing) {
            c(R.id.action_play_pause);
            g(R.id.action_play_pause);
        } else {
            f(R.id.action_play_pause);
            b(R.id.action_play_pause);
        }
        j();
    }

    @Override // android.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        p().p();
        if (!this.q && getFragmentManager().getBackStackEntryCount() < 1) {
            this.F = null;
            this.k.k();
        }
        Fragment findFragmentById = getFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
        if (findFragmentById == null) {
            findFragmentById = getFragmentManager().findFragmentById(R.id.optionPanelHolder);
        }
        if (findFragmentById != null && !(findFragmentById instanceof ez) && (findFragmentById instanceof kp) && this.k.getSelectedItem() != null && findFragmentById.isAdded() && ((kp) findFragmentById).m() != this.k.getSelectedItem() && this.k.getSelectedItem().getClass() == ((kp) findFragmentById).g()) {
            ((kp) findFragmentById).a(this.k.getSelectedItem());
            ((kp) findFragmentById).f();
        }
        if (getFragmentManager().getBackStackEntryCount() < 1 && this.G != null) {
            com.nexstreaming.kinemaster.ui.widget.g gVar = this.G.get();
            if (gVar != null) {
                gVar.a();
            }
            this.G = null;
        }
        J();
    }

    private void J() {
        if (B()) {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            return;
        }
        if (C() == null) {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            return;
        }
        if (this.k != null && this.k.getTimeline() != null) {
            if (this.k.getTimeline().getPrimaryItemCount() > 0 || this.T > 0) {
                this.l.setVisibility(0);
                this.m.setVisibility(0);
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    this.l.setVisibility(8);
                } else {
                    this.l.setVisibility(0);
                }
                this.T = 0;
                return;
            }
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        }
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onBackPressed() {
        if (this.r) {
            b(false, true);
            return;
        }
        this.V = System.nanoTime();
        if (getFragmentManager().findFragmentById(android.R.id.content) != null && (getFragmentManager().findFragmentById(android.R.id.content) instanceof com.nexstreaming.kinemaster.ui.settings.aw) && getFragmentManager().popBackStackImmediate()) {
            v();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.i
    public void a(boolean z, boolean z2) {
        a(R.id.action_undo, z);
        a(R.id.action_redo, z2);
    }

    public void a(CharSequence charSequence, int i) {
        Toast makeText = Toast.makeText(D(), charSequence, i);
        if (this.aa == 0 || System.currentTimeMillis() - this.aa >= 4000) {
            makeText.show();
            this.aa = System.currentTimeMillis();
        }
    }

    public void a(int i, boolean z) {
        if (z) {
            c(i);
        } else {
            b(i);
        }
    }

    public void b(int i, int i2) {
        this.k.a(i, i2, i2);
    }

    public void a(int i, int i2, int i3) {
        this.k.a(i, i2, i2);
    }

    public void k() {
        this.k.g();
    }

    @Override // com.nextreaming.nexeditorui.bp
    public void a(String str, String str2, int i) {
        Fragment findFragmentById;
        if (PreferenceManager.getDefaultSharedPreferences(D()).getBoolean("pref_abrowser_full", false) && (findFragmentById = getFragmentManager().findFragmentById(R.id.fullscreenFragmentHolder)) != null && ((findFragmentById instanceof MediaBrowserFragment) || (findFragmentById instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a))) {
            getFragmentManager().popBackStackImmediate();
        }
        if (str != null) {
            NexAudioClipItem a2 = p().a(p().u(), str, false);
            KMUsage.trackAddMedia(D(), false, "Audio", a2);
            a2.setTitle(str2);
            this.k.a(a2, TimelineView.AnimType.AddClip, 350);
            p().n();
            this.k.invalidate();
            M();
            new Handler().post(new id(this, a2));
            p().l();
        }
    }

    public void a(MSID msid, MediaStoreItem mediaStoreItem, Bitmap bitmap) {
        a(msid, mediaStoreItem, bitmap, InsertPosition.CurrentTime, true, true, (c) null);
    }

    public void a(MSID msid, MediaStoreItem mediaStoreItem, Bitmap bitmap, InsertPosition insertPosition, boolean z, boolean z2, c cVar) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        NexVideoClipItem.CropMode.fromString(defaultSharedPreferences.getString("add_img_def_crop", "panface"));
        int parseInt = Integer.parseInt(defaultSharedPreferences.getString("add_img_def_duration", "6000"));
        int selectedIndex = this.k.getSelectedTimeline() == WhichTimeline.PRIMARY ? this.k.getSelectedIndex() : -1;
        switch (insertPosition) {
            case AfterSelected:
                if (selectedIndex < 0) {
                    selectedIndex = this.k.b();
                    break;
                } else {
                    selectedIndex += 2;
                    break;
                }
            case BeforeSelected:
                if (selectedIndex < 0) {
                    selectedIndex = this.k.b();
                    break;
                }
                break;
            default:
                selectedIndex = this.k.b();
                break;
        }
        M();
        NexVideoClipItem a2 = p().a(selectedIndex, msid, mediaStoreItem, parseInt);
        if (cVar != null && cVar.a(a2)) {
            p().a((NexTimelineItem) a2);
        }
        if (bitmap != null) {
            p().f().a().getThumbnailCache().put(a2.getUniqueId(), bitmap);
        }
        if (z) {
            d(a2);
            this.k.a((NexTimelineItem) a2, true, true);
        }
        M();
        if (z2 && bitmap != null) {
            p().l();
        }
        J();
    }

    public void a(MSID msid) {
        a(x().a(msid));
    }

    private void a(MediaStoreItem mediaStoreItem) {
        int u = p().u();
        MediaInfo a2 = MediaInfo.a(mediaStoreItem.h());
        VideoLayer fromMediaStoreItem = VideoLayer.fromMediaStoreItem(mediaStoreItem);
        fromMediaStoreItem.setStartTime(u);
        fromMediaStoreItem.setEndTime(u + fromMediaStoreItem.getIntinsicDuration());
        NexLayerItem.b closestKeyframe = fromMediaStoreItem.getClosestKeyframe(0.0f);
        closestKeyframe.c = 640.0f;
        closestKeyframe.d = 360.0f;
        closestKeyframe.b = 1.0f;
        closestKeyframe.e = -a2.C();
        int height = fromMediaStoreItem.getHeight();
        int width = fromMediaStoreItem.getWidth();
        if ((closestKeyframe.e / 90.0f) % 2.0f != 0.0f) {
            if (height > 1440) {
                closestKeyframe.b = 1440.0f / height;
            }
            if (width > 540) {
                closestKeyframe.b = Math.min(closestKeyframe.b, 540.0f / width);
            }
        } else {
            if (width > 1440) {
                closestKeyframe.b = 1440.0f / width;
            }
            if (height > 540) {
                closestKeyframe.b = Math.min(closestKeyframe.b, 540.0f / height);
            }
        }
        p().a((NexLayerItem) fromMediaStoreItem);
        c(fromMediaStoreItem);
        d(fromMediaStoreItem);
        new Handler().post(new ie(this, fromMediaStoreItem));
        p().l();
        p().C();
        p().n();
    }

    public void b(MediaStoreItem mediaStoreItem) {
        new Random();
        int u = p().u();
        ImageLayer imageLayer = new ImageLayer();
        int parseInt = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("add_layer_def_duration", "6000"));
        imageLayer.setRelativeStartTime(u);
        imageLayer.setRelativeEndTime(u + parseInt);
        NexLayerItem.b closestKeyframe = imageLayer.getClosestKeyframe(0.0f);
        closestKeyframe.c = 640.0f;
        closestKeyframe.d = 360.0f;
        closestKeyframe.b = 1.0f;
        closestKeyframe.e = 0.0f;
        imageLayer.setMediaPath(mediaStoreItem.h(), D());
        int height = imageLayer.getHeight();
        int width = imageLayer.getWidth();
        if (width > 1440) {
            closestKeyframe.b = 1440.0f / width;
        }
        if (height > 540) {
            closestKeyframe.b = Math.min(closestKeyframe.b, 540.0f / height);
        }
        p().a((NexLayerItem) imageLayer);
        c(imageLayer);
        d(imageLayer);
        new Handler().post(new Cif(this, imageLayer));
        p().l();
    }

    @Override // com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment.b
    public boolean b(String str) {
        return a(str);
    }

    @Override // com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment.b
    public void a(MediaStoreItem mediaStoreItem, int i) {
        Fragment findFragmentById;
        if (PreferenceManager.getDefaultSharedPreferences(D()).getBoolean("pref_mbrowser_full", false) && (findFragmentById = getFragmentManager().findFragmentById(R.id.fullscreenFragmentHolder)) != null && ((findFragmentById instanceof MediaBrowserFragment) || (findFragmentById instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a))) {
            getFragmentManager().popBackStackImmediate();
        }
        if (i == R.id.req_add_visual_clip) {
            x().b(mediaStoreItem).onResultAvailable(new ii(this, mediaStoreItem)).onFailure((Task.OnFailListener) new ih(this, mediaStoreItem));
            return;
        }
        if (i == R.id.req_add_image_layer) {
            if (this.k.getSelectedItem() != null) {
                NexTimelineItem selectedItem = this.k.getSelectedItem();
                if (selectedItem instanceof ImageLayer) {
                    ((ImageLayer) selectedItem).setMediaPath(mediaStoreItem.h(), D());
                    this.k.b(selectedItem);
                    p().l();
                    return;
                }
                return;
            }
            switch (mediaStoreItem.b()) {
                case IMAGE:
                    b(mediaStoreItem);
                    return;
                case VIDEO:
                    a(mediaStoreItem);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3742a;

        static {
            try {
                d[MediaItemType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                d[MediaItemType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            c = new int[InsertPosition.values().length];
            try {
                c[InsertPosition.AfterSelected.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                c[InsertPosition.BeforeSelected.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                c[InsertPosition.CurrentTime.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            b = new int[TimelineActionButtonMode.values().length];
            try {
                b[TimelineActionButtonMode.NoItemSelectedScrolledToStart.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                b[TimelineActionButtonMode.NoItemSelectedScrolledToStartExpanded.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                b[TimelineActionButtonMode.SecondaryItemSelected.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                b[TimelineActionButtonMode.NoItemSelectedScrolledToMidExpanded.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                b[TimelineActionButtonMode.NoItemSelectedScrolledToMid.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            f3742a = new int[KMIntentData.LayerType.values().length];
            try {
                f3742a[KMIntentData.LayerType.Image.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f3742a[KMIntentData.LayerType.Video.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f3742a[KMIntentData.LayerType.Sticker.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f3742a[KMIntentData.LayerType.Text.ordinal()] = 4;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment.b
    public boolean b(MediaStoreItem mediaStoreItem, int i) {
        if (i != R.id.req_add_image_layer || this.k.getTimeline().getPrimaryItemCount() >= 1) {
            return true;
        }
        a(getResources().getString(R.string.add_video_before_layer), 1);
        return false;
    }

    public void b(boolean z) {
        this.k.setEnabled(z);
        this.N.setEnabled(z);
    }

    public void c(boolean z) {
        a(this.f, z);
    }

    public void d(boolean z) {
        a(this.e, z);
    }

    public void e(boolean z) {
        this.i.setEnabled(z);
    }

    public void f(boolean z) {
        this.J = z;
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
                        if (this.n.b(((Integer) tag).intValue())) {
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
        this.k.b(nexTimelineItem);
    }

    /* loaded from: classes.dex */
    public static class a extends View {
        public a(Context context) {
            super(context);
            setBackgroundColor(getResources().getColor(R.color.pedit_background_color));
            setLayoutParams(new LinearLayout.LayoutParams(-1, 1, 0.0f));
        }
    }

    private static int l(int i) {
        switch (i) {
            case R.id.action_bring_to_front /* 2131820550 */:
                return R.drawable.action_bring_to_front;
            case R.id.action_capture /* 2131820551 */:
                return R.drawable.action_icon_capture;
            case R.id.action_capture_add_layer /* 2131820552 */:
                return R.drawable.action_capture_add_layer;
            case R.id.action_capture_insert_left /* 2131820553 */:
                return R.drawable.action_capture_insert_left;
            case R.id.action_capture_insert_right /* 2131820554 */:
                return R.drawable.action_capture_insert_right;
            case R.id.action_capture_save /* 2131820555 */:
                return R.drawable.action_capture_save;
            case R.id.action_duplicate_clip /* 2131820560 */:
                return R.drawable.action_duplicate_clip;
            case R.id.action_redo /* 2131820571 */:
                return R.drawable.action_icon_redo;
            case R.id.action_reverse_clip /* 2131820572 */:
                return R.drawable.action_reverse_clip;
            case R.id.action_send_to_back /* 2131820575 */:
                return R.drawable.action_send_to_back;
            case R.id.action_undo /* 2131820581 */:
                return R.drawable.action_icon_undo;
            default:
                return 0;
        }
    }

    private static int m(int i) {
        return 0;
    }

    public int l() {
        return this.k.getCurrentTimeAndStopFling();
    }

    public int m() {
        return this.k.getCurrentTime();
    }

    private void a(LinearLayout linearLayout, int[] iArr, com.nexstreaming.kinemaster.ui.projectedit.a aVar, List<d> list) {
        WeakReference weakReference = aVar == null ? null : new WeakReference(aVar);
        linearLayout.removeAllViews();
        if (list != null) {
            list.clear();
        }
        int i = 0;
        if (iArr != null) {
            int i2 = 0;
            Resources resources = getResources();
            boolean z = true;
            while (i2 < iArr.length) {
                int i3 = 0;
                int i4 = 0;
                int i5 = i2;
                int i6 = 0;
                do {
                    int i7 = iArr[i5];
                    if (i7 != 0) {
                        String resourceTypeName = resources.getResourceTypeName(i7);
                        if (ShareConstants.WEB_DIALOG_PARAM_ID.equals(resourceTypeName)) {
                            if (i4 != 0) {
                                break;
                            } else {
                                i4 = i7;
                            }
                        } else if ("string".equals(resourceTypeName)) {
                            i6 = i7;
                        } else if ("drawable".equals(resourceTypeName)) {
                            i3 = i7;
                        } else {
                            Log.w("ProjectEditActivity", "Unknown resource type : '" + resourceTypeName + "'");
                        }
                    }
                    i5++;
                } while (i5 < iArr.length);
                int i8 = i6;
                i2 = i5;
                int i9 = i4;
                int i10 = i3;
                int i11 = i8;
                if (i10 == 0) {
                    i10 = l(i9);
                }
                if (i11 == 0) {
                    i11 = m(i11);
                }
                if (i11 != 0) {
                    if (list != null) {
                        list.add(new d(i9, i11, i10, null));
                    }
                } else {
                    i++;
                    if (z) {
                        z = false;
                    } else {
                        linearLayout.addView(new a(this));
                    }
                    IconButton iconButton = new IconButton(this);
                    iconButton.setBackgroundResource(R.drawable.pedit_button_color);
                    Drawable drawable = getResources().getDrawable(i10);
                    iconButton.setImageDrawable(drawable);
                    if (drawable.isStateful()) {
                        iconButton.setIconColorStateList(R.color.pedit_icon_color_non_activated);
                    } else {
                        iconButton.setIconColorStateList(R.color.pedit_icon_color);
                    }
                    iconButton.setOnClickListener(new ij(this, linearLayout, weakReference, i9));
                    if (!linearLayout.isEnabled() || this.n.b(i9)) {
                        iconButton.setEnabled(false);
                    }
                    if (this.o.b(i9)) {
                        iconButton.setActivated(true);
                    }
                    iconButton.setTag(Integer.valueOf(i9));
                    linearLayout.addView(iconButton, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                }
            }
        }
        linearLayout.setWeightSum(i);
    }

    private void K() {
        this.i.removeCallbacks(this.ab);
        this.i.post(this.ab);
    }

    public void b(int i) {
        if (this.n.a(i)) {
            View findViewWithTag = this.e.findViewWithTag(Integer.valueOf(i));
            if (findViewWithTag == null) {
                findViewWithTag = this.f.findViewWithTag(Integer.valueOf(i));
            }
            if (findViewWithTag != null) {
                findViewWithTag.setEnabled(false);
            }
            K();
        }
    }

    public void c(int i) {
        if (this.n.c(i)) {
            LinearLayout linearLayout = this.e;
            View findViewWithTag = linearLayout.findViewWithTag(Integer.valueOf(i));
            if (findViewWithTag == null) {
                linearLayout = this.f;
                findViewWithTag = linearLayout.findViewWithTag(Integer.valueOf(i));
            }
            if (findViewWithTag != null && linearLayout.isEnabled()) {
                findViewWithTag.setEnabled(true);
            }
            K();
        }
    }

    public boolean d(int i) {
        return !this.n.b(i);
    }

    public boolean e(int i) {
        return this.o.b(i);
    }

    public void f(int i) {
        if (this.o.a(i)) {
            View findViewWithTag = this.e.findViewWithTag(Integer.valueOf(i));
            if (findViewWithTag == null) {
                findViewWithTag = this.f.findViewWithTag(Integer.valueOf(i));
            }
            if (findViewWithTag != null) {
                findViewWithTag.setActivated(true);
            }
            K();
        }
    }

    public void g(int i) {
        if (this.o.c(i)) {
            View findViewWithTag = this.e.findViewWithTag(Integer.valueOf(i));
            if (findViewWithTag == null) {
                findViewWithTag = this.f.findViewWithTag(Integer.valueOf(i));
            }
            if (findViewWithTag != null) {
                findViewWithTag.setActivated(false);
            }
            K();
        }
    }

    public View h(int i) {
        View findViewWithTag = this.e.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag == null) {
            return this.f.findViewWithTag(Integer.valueOf(i));
        }
        return findViewWithTag;
    }

    public void i(int i) {
        a(i, (com.nexstreaming.kinemaster.ui.projectedit.a) null);
    }

    public void j(int i) {
        switch (i) {
            case R.id.action_play_pause /* 2131820570 */:
                p().a(true);
                a(i, (com.nexstreaming.kinemaster.ui.projectedit.a) null);
                return;
            default:
                return;
        }
    }

    public void a(int i, com.nexstreaming.kinemaster.ui.projectedit.a aVar) {
        switch (i) {
            case R.id.action_animation /* 2131820546 */:
                Fragment findFragmentById = getFragmentManager().findFragmentById(R.id.optionPanelHolder);
                if (findFragmentById != null && (findFragmentById instanceof az)) {
                    getFragmentManager().popBackStack();
                    return;
                }
                az azVar = new az();
                azVar.a(this.k.getSelectedItem());
                a(getFragmentManager().beginTransaction()).setTransition(4097).replace(R.id.optionPanelHolder, azVar).addToBackStack("layerAnimation").commit();
                return;
            case R.id.action_apply_style_to_all /* 2131820547 */:
            case R.id.action_bar_activity_content /* 2131820548 */:
            case R.id.action_bar_spinner /* 2131820549 */:
            case R.id.action_copy_style /* 2131820558 */:
            case R.id.action_fullscreen /* 2131820563 */:
            case R.id.action_menu_divider /* 2131820565 */:
            case R.id.action_menu_presenter /* 2131820566 */:
            case R.id.action_paste_style /* 2131820568 */:
            case R.id.action_step_redo /* 2131820578 */:
            case R.id.action_step_undo /* 2131820579 */:
            case R.id.action_test /* 2131820580 */:
            default:
                return;
            case R.id.action_bring_to_front /* 2131820550 */:
                NexTimelineItem selectedItem = this.k.getSelectedItem();
                if (selectedItem != null && (selectedItem instanceof NexLayerItem)) {
                    p().b((NexLayerItem) selectedItem);
                    p().n();
                    p().l();
                    return;
                }
                return;
            case R.id.action_capture /* 2131820551 */:
                WeakReference weakReference = aVar != null ? new WeakReference(aVar) : null;
                com.nexstreaming.kinemaster.ui.widget.g gVar = new com.nexstreaming.kinemaster.ui.widget.g(D());
                gVar.a(R.id.action_capture_save, R.string.vclip_capture_save, R.drawable.action_capture_save);
                gVar.a(R.id.action_capture_insert_left, R.string.vclip_capture_insert_left, R.drawable.action_capture_insert_left);
                gVar.a(R.id.action_capture_insert_right, R.string.vclip_capture_insert_right, R.drawable.action_capture_insert_right);
                gVar.a(R.id.action_capture_add_layer, R.string.capture_as_layer, R.drawable.action_capture_add_layer);
                gVar.a(h(i), 21);
                gVar.a(new iq(this, weakReference));
                return;
            case R.id.action_capture_add_layer /* 2131820552 */:
                b(false);
                d(false);
                c(false);
                this.M.setText(R.string.please_wait_capturing);
                this.M.setVisibility(0);
                p().a(d()).onResultAvailable(new iu(this)).onFailure((Task.OnFailListener) new ir(this));
                return;
            case R.id.action_capture_insert_left /* 2131820553 */:
                b(false);
                d(false);
                c(false);
                this.M.setText(R.string.please_wait_capturing);
                this.M.setVisibility(0);
                p().a(d()).onResultAvailable(new je(this)).onFailure((Task.OnFailListener) new jd(this));
                return;
            case R.id.action_capture_insert_right /* 2131820554 */:
                b(false);
                d(false);
                c(false);
                this.M.setText(R.string.please_wait_capturing);
                this.M.setVisibility(0);
                p().a(d()).onResultAvailable(new ji(this)).onFailure((Task.OnFailListener) new jh(this));
                return;
            case R.id.action_capture_save /* 2131820555 */:
                b(false);
                d(false);
                c(false);
                this.M.setText(R.string.please_wait_capturing);
                this.M.setVisibility(0);
                p().a(d()).onResultAvailable(new jc(this)).onFailure((Task.OnFailListener) new jb(this));
                return;
            case R.id.action_capture_split_insert /* 2131820556 */:
                int l = l();
                b(false);
                d(false);
                c(false);
                this.M.setText(R.string.please_wait_capturing);
                this.M.setVisibility(0);
                p().a(d()).onResultAvailable(new iw(this, l)).onFailure((Task.OnFailListener) new iv(this));
                return;
            case R.id.action_change_theme /* 2131820557 */:
                VideoEditor p = p();
                if (p != null && p.f() != null && !f() && p().f().a().getPrimaryItemCount() >= 1) {
                    Fragment findFragmentById2 = getFragmentManager().findFragmentById(R.id.aboveTimelineFragmentHolder);
                    if (findFragmentById2 != null && ((findFragmentById2 instanceof MediaBrowserFragment) || (findFragmentById2 instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a))) {
                        getFragmentManager().popBackStack();
                    }
                    Fragment findFragmentById3 = getFragmentManager().findFragmentById(R.id.optionPanelHolder);
                    if (findFragmentById3 != null && (findFragmentById3 instanceof mf)) {
                        getFragmentManager().popBackStack();
                    }
                    getFragmentManager().beginTransaction().replace(R.id.fullscreenFragmentHolder, com.nextreaming.nexeditorui.newproject.b.f.a((String) null, true)).addToBackStack("themeBrowser").commit();
                    return;
                }
                return;
            case R.id.action_delete /* 2131820559 */:
                n();
                p().l();
                M();
                return;
            case R.id.action_duplicate_clip /* 2131820560 */:
                NexTimelineItem selectedItem2 = this.k.getSelectedItem();
                if (selectedItem2 != null && (selectedItem2 instanceof NexPrimaryTimelineItem)) {
                    p().a((VideoEditor) selectedItem2);
                } else if (selectedItem2 != null && (selectedItem2 instanceof NexSecondaryTimelineItem)) {
                    p().a((VideoEditor) selectedItem2);
                }
                p().C();
                p().l();
                this.k.e();
                this.k.invalidate();
                this.k.k();
                return;
            case R.id.action_expand_preview /* 2131820561 */:
                this.s = this.s ? false : true;
                k(this.r);
                if (this.s) {
                    f(R.id.action_expand_preview);
                    return;
                } else {
                    g(R.id.action_expand_preview);
                    return;
                }
            case R.id.action_expand_timeline /* 2131820562 */:
                b(o() ? false : true, true);
                return;
            case R.id.action_general /* 2131820564 */:
            case R.id.action_overflow /* 2131820567 */:
                if (getFragmentManager() == null || getFragmentManager().getBackStackEntryCount() >= 1) {
                    WeakReference weakReference2 = aVar == null ? null : new WeakReference(aVar);
                    com.nexstreaming.kinemaster.ui.widget.g gVar2 = new com.nexstreaming.kinemaster.ui.widget.g(D());
                    if (this.G == null) {
                        this.G = new WeakReference<>(gVar2);
                    }
                    for (d dVar : this.I) {
                        gVar2.a(dVar.f3743a, dVar.b, dVar.c);
                    }
                    gVar2.a(h(i), 21);
                    gVar2.a(new jl(this, weakReference2));
                    gVar2.a(new jn(this));
                    return;
                }
                return;
            case R.id.action_pin /* 2131820569 */:
                NexTimelineItem selectedItem3 = this.k.getSelectedItem();
                if (selectedItem3 != null && (selectedItem3 instanceof NexSecondaryTimelineItem)) {
                    NexSecondaryTimelineItem nexSecondaryTimelineItem = (NexSecondaryTimelineItem) selectedItem3;
                    nexSecondaryTimelineItem.setPinned(!nexSecondaryTimelineItem.getPinned());
                    p().l();
                    this.k.b(selectedItem3);
                    j();
                    return;
                }
                return;
            case R.id.action_play_pause /* 2131820570 */:
                if (p().t() == VideoEditor.State.Idle) {
                    if (!f()) {
                        if (p().F()) {
                            Toast.makeText(this, R.string.file_prep_busy, 0).show();
                            return;
                        }
                        Fragment findFragmentById4 = getFragmentManager().findFragmentById(R.id.aboveTimelineFragmentHolder);
                        if (findFragmentById4 != null && ((findFragmentById4 instanceof MediaBrowserFragment) || (findFragmentById4 instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a))) {
                            getFragmentManager().popBackStackImmediate();
                        }
                        if (this.k.getCurrentTime() >= this.k.getTimeline().getTotalTime() - 200) {
                            p().a(0);
                        }
                        KMUsage.EditScreen_PreviewPlay.logEvent();
                        this.W++;
                        p().r();
                        return;
                    }
                    return;
                }
                if (p().t() == VideoEditor.State.Playing) {
                    p().p();
                    return;
                }
                return;
            case R.id.action_redo /* 2131820571 */:
                if (p().t() == VideoEditor.State.Playing) {
                    p().p().onComplete(new im(this));
                    return;
                } else {
                    p().j();
                    return;
                }
            case R.id.action_reverse_clip /* 2131820572 */:
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) this.k.getSelectedItem();
                File file = new File(nexVideoClipItem.getMediaPath());
                File a2 = com.nexstreaming.kinemaster.g.a.a(D(), file);
                if (a2.exists()) {
                    NexVideoClipItem nexVideoClipItem2 = (NexVideoClipItem) p().a((VideoEditor) nexVideoClipItem, this.k.b() > this.k.getSelectedIndex());
                    if (nexVideoClipItem2 != null) {
                        p().C();
                        nexVideoClipItem2.setReversePath(a2.getAbsolutePath());
                        nexVideoClipItem2.setReverseState(true);
                        nexVideoClipItem2.setTrimStart(nexVideoClipItem.getTrimTimeEnd() - (nexVideoClipItem.getDuration() - nexVideoClipItem2.getDuration()));
                        nexVideoClipItem2.setTrimEnd(nexVideoClipItem.getTrimTimeStart());
                        p().a((NexTimelineItem) nexVideoClipItem2);
                        p().l();
                        this.k.e();
                        this.k.invalidate();
                        this.k.k();
                        return;
                    }
                    return;
                }
                NexExportProfile transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.a().i());
                a(transcodeProfile, nexVideoClipItem).onComplete(new io(this, file, a2, transcodeProfile, nexVideoClipItem)).onFailure(new in(this));
                return;
            case R.id.action_seek_to_end /* 2131820573 */:
                b(p().f().a().getTotalTime(), true);
                return;
            case R.id.action_seek_to_start /* 2131820574 */:
                b(0, true);
                p().a(0);
                return;
            case R.id.action_send_to_back /* 2131820575 */:
                NexTimelineItem selectedItem4 = this.k.getSelectedItem();
                if (selectedItem4 != null && (selectedItem4 instanceof NexLayerItem)) {
                    p().c((NexLayerItem) selectedItem4);
                    p().n();
                    p().l();
                    return;
                }
                return;
            case R.id.action_settings /* 2131820576 */:
                u();
                return;
            case R.id.action_share /* 2131820577 */:
                if (this.k.getTimeline().getPrimaryItemCount() >= 1) {
                    p().p();
                    Intent intent = new Intent(this, (Class<?>) ShareActivity.class);
                    intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "edit_screen");
                    intent.setData(Uri.fromFile(this.h));
                    startActivity(intent);
                    return;
                }
                return;
            case R.id.action_undo /* 2131820581 */:
                if (p().t() == VideoEditor.State.Playing) {
                    p().p().onComplete(new il(this));
                    return;
                } else {
                    p().i();
                    return;
                }
        }
    }

    public void L() {
        new Handler().postDelayed(new jo(this), 500L);
    }

    public void n() {
        NexTimelineItem selectedItem = this.k.getSelectedItem();
        if (selectedItem instanceof NexTransitionItem) {
            ((NexTransitionItem) selectedItem).clearTransitionEffect();
            p().a(selectedItem);
            this.k.b(selectedItem);
        } else {
            p().b(selectedItem);
        }
        this.k.k();
        p().n();
        this.k.a();
        if (selectedItem instanceof NexPrimaryTimelineItem) {
            this.k.d();
        } else {
            this.k.invalidate();
        }
    }

    public void c(NexTimelineItem nexTimelineItem) {
        this.Y = false;
        this.k.a(nexTimelineItem, true);
        this.k.setSelectedItem(nexTimelineItem);
    }

    public void d(NexTimelineItem nexTimelineItem) {
        this.k.a(nexTimelineItem, TimelineView.AnimType.AddClip, 350);
        this.k.invalidate();
    }

    public void b(int i, boolean z) {
        this.k.a(i, z);
    }

    public int g(boolean z) {
        return this.k.a(z);
    }

    public void h(boolean z) {
        this.k.setSuppressScrollEvents(z);
    }

    public void i(boolean z) {
        this.k.b(this.k.getSelectedItem(), z);
    }

    public void j(boolean z) {
        this.k.a(this.k.getSelectedItem(), z, false);
    }

    public void k(int i) {
        this.k.setEditingMode(i);
    }

    public void b(boolean z, boolean z2) {
        if (z != this.r) {
            if (this.y == 0) {
                this.y = this.x.getHeight();
            }
            if (!this.r && this.w == 0) {
                this.w = this.k.getHeight();
            }
            this.r = z;
            if (this.r && !this.q) {
                this.k.k();
                getFragmentManager().popBackStackImmediate();
            }
            if (this.r) {
                a(new int[]{R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_play_pause, R.drawable.action_play_pause, R.id.action_expand_preview, R.drawable.action_inset_preview}, (com.nexstreaming.kinemaster.ui.projectedit.a) null);
            } else {
                a(new int[]{R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_change_theme, R.drawable.action_icon_change_theme, R.id.action_share, R.drawable.action_icon_share, R.id.action_settings, R.drawable.action_icon_settings}, (com.nexstreaming.kinemaster.ui.projectedit.a) null);
            }
            k(this.r);
            if (z2) {
                int height = this.k.getHeight();
                int i = this.r ? this.y : this.w;
                this.k.setExpandingAnimation(true);
                jp jpVar = new jp(this, height, i);
                jpVar.setDuration(150L);
                jpVar.setAnimationListener(new jq(this));
                this.k.startAnimation(jpVar);
                this.k.f();
            } else {
                ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
                layoutParams.height = this.r ? this.y : this.w;
                this.k.setLayoutParams(layoutParams);
            }
            if (this.r) {
                View findViewById = findViewById(R.id.bookmarkViewHolder);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
                marginLayoutParams.bottomMargin = this.y - getResources().getDimensionPixelOffset(R.dimen.timeline3_bookmark_view_expand_bottomMargin_diff);
                findViewById.setLayoutParams(marginLayoutParams);
            } else {
                View findViewById2 = findViewById(R.id.bookmarkViewHolder);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
                marginLayoutParams2.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.timeline3_bookmark_view_bottomMargin);
                findViewById2.setLayoutParams(marginLayoutParams2);
            }
            j();
        }
    }

    private void k(boolean z) {
        if (z && this.s) {
            if (B()) {
                p().c(false);
                p().a(EditorGlobal.c("up"));
            } else {
                p().c(true);
                p().a(EditorGlobal.c("std"));
            }
            E().a(this.j);
            p().n();
            this.i.setVisibility(8);
            this.j.a(new jr(this));
            this.z.postDelayed(new js(this), 50L);
            return;
        }
        E().a(this.i);
        p().c(false);
        p().a(EditorGlobal.c("up"));
        p().n();
        this.i.setVisibility(0);
        this.i.a(new jt(this));
        this.z.postDelayed(new ju(this), 50L);
    }

    public boolean o() {
        return this.r;
    }

    public VideoEditor p() {
        return this.g;
    }

    public static FragmentTransaction a(FragmentTransaction fragmentTransaction) {
        return fragmentTransaction.setCustomAnimations(R.animator.optpanel_slide_in_from_right, R.animator.optpanel_fade_out, R.animator.optpanel_fade_in, R.animator.optpanel_slide_out_to_right);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0176, code lost:            if ((r1 instanceof com.nexstreaming.kinemaster.ui.projectedit.ez) == false) goto L137;     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0180, code lost:            if (getFragmentManager().popBackStackImmediate() == false) goto L152;     */
    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity.a():void");
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.e
    public void a(File file) {
        this.h = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.aw, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStop() {
        long nanoTime = (System.nanoTime() - this.V) / 1000000;
        if (this.U == null) {
            if (nanoTime < 1000) {
                this.U = "back button";
            } else {
                this.U = FacebookRequestErrorClassification.KEY_OTHER;
            }
        }
        KMUsage.Activity_EditScreen.end();
        NexTimeline timeline = this.k.getTimeline();
        KMUsage.EditScreen_OnStop.logEvent("exitMethod", this.U);
        KMUsage.logProjectStats(timeline, KMUsage.EditScreen_OnStop_ProjStatsA_NOSUB, KMUsage.EditScreen_OnStop_ProjStatsB_NOSUB, KMUsage.EditScreen_OnStop_ProjStatsA_SUB, KMUsage.EditScreen_OnStop_ProjStatsB_SUB, B());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Preview Play Count", this.W);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        KMUsage.trackMixpanelProjectEvent(this, timeline, "Exit Project", jSONObject);
        p().p();
        this.W = 0;
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.aw, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onDestroy() {
        unregisterReceiver(this.X);
        this.K.b();
        this.K = null;
        getFragmentManager().removeOnBackStackChangedListener(this);
        super.onDestroy();
    }

    @Override // com.nextreaming.nexeditorui.ba
    public void a(boolean z) {
        Fragment findFragmentById;
        super.a(z);
        if (z) {
            this.g.c(false);
            p().a(EditorGlobal.c("up"));
            p().n();
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        } else {
            this.g.c(false);
            p().a(EditorGlobal.c("up"));
            J();
        }
        NexTimelineItem selectedItem = this.k.getSelectedItem();
        if (selectedItem != null && (findFragmentById = getFragmentManager().findFragmentById(R.id.optionPanelHolder)) != null && (findFragmentById instanceof kp) && selectedItem != null && selectedItem.getClass() == ((kp) findFragmentById).g()) {
            ((kp) findFragmentById).a(selectedItem);
        }
    }

    private void M() {
        if (p().f() != null && this.K != null) {
            this.K.a(p().f().a());
        }
    }

    public void e(NexTimelineItem nexTimelineItem) {
        this.k.b(nexTimelineItem);
    }

    public void a(cd cdVar) {
        this.A.a((com.nexstreaming.app.general.util.m<cd>) cdVar);
    }

    public boolean q() {
        return this.k.h();
    }

    public boolean r() {
        return this.k.i();
    }

    public boolean s() {
        return this.k.j();
    }

    public MediaPrepManager t() {
        return this.K;
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a */
        final int f3743a;
        final int b;
        final int c;

        /* synthetic */ d(int i, int i2, int i3, hu huVar) {
            this(i, i2, i3);
        }

        private d(int i, int i2, int i3) {
            this.f3743a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    private void N() {
        this.g.b((VideoEditor.e) this);
        this.g.b((VideoEditor.g) this);
        this.g.b((VideoEditor.f) this);
        this.g.b((VideoEditor.i) this);
        this.g.b((VideoEditor.h) this);
        this.g.a((VideoEditor.e) this);
        this.g.a((VideoEditor.g) this);
        this.g.a((VideoEditor.f) this);
        this.g.a((VideoEditor.i) this);
        this.g.a((VideoEditor.h) this);
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onRestart() {
        this.g.b();
        N();
        if (this.r && this.s) {
            E().a(this.j);
        } else {
            E().a(this.i);
        }
        MediaInfo.a();
        p().a(p().u());
        p().n();
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.aw, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onResume() {
        super.onResume();
        p().o();
    }

    public void u() {
        if (p() != null && p().f() != null) {
            p().p();
            KMUsage.EditScreen_ProjectSettings.logEvent();
            ProjectSettingsPopup projectSettingsPopup = new ProjectSettingsPopup(D());
            projectSettingsPopup.a(p().f().a());
            projectSettingsPopup.a(new kf(this));
            projectSettingsPopup.setOnDismissListener(new kg(this));
            projectSettingsPopup.show();
        }
    }

    private Task a(NexExportProfile nexExportProfile, NexVideoClipItem nexVideoClipItem) {
        long max = Math.max(1L, (nexVideoClipItem.getDuration() / 1000) * (nexExportProfile.bitrate() / 8));
        Task task = new Task();
        MediaInfo a2 = MediaInfo.a(new File(nexVideoClipItem.getMediaPath()));
        a2.g().onResultAvailable(new ki(this, nexVideoClipItem, a2, max, task)).onFailure((Task.OnFailListener) new kh(this, task));
        return task;
    }

    public void O() {
        if (A() != null) {
            if (!A().E() || (A().D() && F())) {
                Fragment findFragmentById = getFragmentManager().findFragmentById(android.R.id.content);
                if (findFragmentById != null && (findFragmentById instanceof com.nexstreaming.kinemaster.ui.settings.aw)) {
                    getFragmentManager().popBackStackImmediate();
                }
                getFragmentManager().beginTransaction().replace(android.R.id.content, com.nexstreaming.kinemaster.ui.settings.aw.a(A(), 0, "videoLayer"), com.nexstreaming.kinemaster.ui.settings.aw.f4229a).addToBackStack(com.nexstreaming.kinemaster.ui.settings.aw.f4229a).commitAllowingStateLoss();
                return;
            }
            A().a(new kk(this));
        }
    }

    @Override // com.nextreaming.nexeditorui.ba, com.nexstreaming.app.general.iab.IABHelper.a
    public void a(boolean z, Purchase purchase, String str) {
        super.a(z, purchase, str);
        if (z) {
            try {
                getFragmentManager().popBackStackImmediate();
            } catch (Exception e) {
                Fragment findFragmentById = getFragmentManager().findFragmentById(android.R.id.content);
                if (findFragmentById != null && (findFragmentById instanceof com.nexstreaming.kinemaster.ui.settings.aw)) {
                    ((com.nexstreaming.kinemaster.ui.settings.aw) findFragmentById).a(true);
                }
            }
        }
    }

    protected void v() {
        NexTimelineItem selectedItem;
        if (this.k != null && getFragmentManager() != null && (selectedItem = this.k.getSelectedItem()) != null) {
            Fragment findFragmentById = getFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
            if (findFragmentById == null) {
                findFragmentById = getFragmentManager().findFragmentById(R.id.optionPanelHolder);
            }
            if (findFragmentById != null && (findFragmentById instanceof kp)) {
                ((kp) findFragmentById).a(selectedItem);
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.ba
    public void a(Context context) {
        super.a(context);
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.aw.a
    public void w() {
        if (getFragmentManager().popBackStackImmediate()) {
        }
    }
}

package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetCategoryAlias;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.store.controller.Ja;
import com.nexstreaming.kinemaster.ui.store.view.ExpandableLayout;
import com.nexstreaming.kinemaster.usage.AssetDownloadResult;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AudioPageAssetListAdapter.java */
/* loaded from: classes2.dex */
public class Ja extends RecyclerView.Adapter implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    /* renamed from: c, reason: collision with root package name */
    private RecyclerView f23452c;

    /* renamed from: e, reason: collision with root package name */
    private Context f23454e;

    /* renamed from: f, reason: collision with root package name */
    private b f23455f;

    /* renamed from: g, reason: collision with root package name */
    private b f23456g;
    private com.nexstreaming.app.general.service.download.i i;
    private IABManager j;
    private b k;
    private InterfaceC1821j l;
    private boolean m;
    private MediaPlayer n;
    private final String o = "audio";

    /* renamed from: d, reason: collision with root package name */
    private List<InterfaceC1821j> f23453d = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private c.d.a.a.d.a.d f23457h = c.d.a.a.d.a.d.a(KineMasterApplication.i());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AudioPageAssetListAdapter.java */
    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.ViewHolder {
        TextView s;

        public a(View view) {
            super(view);
            this.s = (TextView) view.findViewById(R.id.licence);
            Spannable spannable = (Spannable) Html.fromHtml(this.s.getText().toString().replace("http://kinemaster.com", "https://support.kinemaster.com/hc/ko/articles/115000073001"));
            for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
                spannable.setSpan(new Ia(this), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 0);
            }
            this.s.setText(spannable);
            this.s.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AudioPageAssetListAdapter.java */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        ProgressBar A;
        ViewGroup B;
        CheckBox C;
        SpinKitView D;
        TextView s;
        TextView t;
        TextView u;
        TextView v;
        ExpandableLayout w;
        TextView x;
        ImageView y;
        ViewGroup z;

        public b(View view) {
            super(view);
            this.s = (TextView) view.findViewById(R.id.title);
            this.t = (TextView) view.findViewById(R.id.type);
            this.u = (TextView) view.findViewById(R.id.size);
            this.v = (TextView) view.findViewById(R.id.description);
            this.w = (ExpandableLayout) view.findViewById(R.id.description_view);
            this.y = (ImageView) view.findViewById(R.id.thumbnail);
            this.z = (ViewGroup) view.findViewById(R.id.download_button_group_view);
            this.x = (TextView) view.findViewById(R.id.tv_fragment_asset_detail_action);
            this.B = (ViewGroup) view.findViewById(R.id.play_control_viewgroup);
            this.C = (CheckBox) view.findViewById(R.id.play_control_checkbox);
            this.A = (ProgressBar) view.findViewById(R.id.pb_fragment_asset_detail_progress);
            this.D = (SpinKitView) view.findViewById(R.id.play_control_progress);
        }
    }

    public Ja(boolean z, com.nexstreaming.app.general.service.download.i iVar, IABManager iABManager) {
        this.m = z;
        this.i = iVar;
        this.j = iABManager;
        g();
        if (this.m) {
            this.f23453d.add(0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(View view) {
    }

    private boolean c(int i) {
        return i == 0 && this.m;
    }

    private void d(b bVar) {
        if (!bVar.w.a()) {
            bVar.itemView.setBackgroundColor(ContextCompat.getColor(this.f23454e, R.color.km_white));
        }
        bVar.s.setTextColor(ContextCompat.getColor(this.f23454e, R.color.dark));
        bVar.C.setVisibility(0);
        bVar.C.setChecked(false);
        bVar.D.setVisibility(8);
    }

    private void k() {
        try {
            this.n.stop();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(InterfaceC1821j interfaceC1821j, final b bVar, View view) {
        ResultTask<InterfaceC1821j> a2 = KineMasterApplication.f24056d.q().a(interfaceC1821j.a(), true);
        a2.onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.F
            @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
            public final void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
                Ja.this.a(bVar, resultTask, event, (InterfaceC1821j) obj);
            }
        });
        a2.onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.B
            @Override // com.nexstreaming.app.general.task.Task.OnFailListener
            public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
                Ja.a(Ja.b.this, task, event, taskError);
            }
        });
    }

    public void b(List<InterfaceC1821j> list) {
        this.f23453d = list;
    }

    public void f() {
        InterfaceC1821j interfaceC1821j;
        b bVar = this.k;
        if (bVar == null || (interfaceC1821j = this.l) == null) {
            return;
        }
        a(bVar, interfaceC1821j);
        this.k = null;
        this.l = null;
    }

    public void g() {
        this.n = new MediaPlayer();
        this.n.setOnErrorListener(this);
        this.n.setOnPreparedListener(this);
        this.n.setOnCompletionListener(this);
        this.n.reset();
        this.n.setAudioStreamType(3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f23453d.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    public void h() {
        MediaPlayer mediaPlayer = this.n;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    public void i() {
        b bVar;
        if (this.n == null || (bVar = this.f23456g) == null) {
            return;
        }
        d(bVar);
        k();
    }

    public void j() {
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f23452c = recyclerView;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        if (c(i)) {
            return;
        }
        final b bVar = (b) viewHolder;
        final InterfaceC1821j interfaceC1821j = this.f23453d.get(i);
        if (!TextUtils.isEmpty(interfaceC1821j.p())) {
            com.bumptech.glide.c.b(this.f23454e).a(interfaceC1821j.p() + "_cs").a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().a(new f.a.a.a.b(20), new com.bumptech.glide.load.resource.bitmap.j())).a(bVar.y);
        }
        bVar.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, KineMasterApplication.m().q().a(interfaceC1821j) ? ContextCompat.getDrawable(this.f23454e, R.drawable.ic_assetmusic_new_and) : null, (Drawable) null);
        bVar.s.setCompoundDrawablePadding(this.f23454e.getResources().getDimensionPixelSize(R.dimen.store_new_badge_drawable_padding));
        bVar.s.setText(com.nexstreaming.app.general.util.J.a(this.f23454e, interfaceC1821j.j()));
        String priceType = interfaceC1821j.getPriceType();
        char c2 = 65535;
        int hashCode = priceType.hashCode();
        if (hashCode != 2198156) {
            if (hashCode != 2479852) {
                if (hashCode == 1346201143 && priceType.equals("Premium")) {
                    c2 = 1;
                }
            } else if (priceType.equals("Paid")) {
                c2 = 2;
            }
        } else if (priceType.equals("Free")) {
            c2 = 0;
        }
        if (c2 == 0) {
            bVar.t.setText(R.string.sub_use_free);
            bVar.t.setTextColor(ContextCompat.getColor(this.f23454e, R.color.gunmetal));
        } else if (c2 == 1) {
            bVar.t.setText(R.string.asset_premium);
            bVar.t.setTextColor(ContextCompat.getColor(this.f23454e, R.color.grapefruit));
        } else if (c2 != 2) {
            bVar.t.setText(R.string.sub_use_free);
            bVar.t.setTextColor(ContextCompat.getColor(this.f23454e, R.color.gunmetal));
        } else {
            bVar.t.setText(R.string.sub_account_type_paid);
            bVar.t.setTextColor(ContextCompat.getColor(this.f23454e, R.color.grapefruit));
        }
        bVar.u.setText(EditorGlobal.a(this.f23454e, interfaceC1821j.h()));
        bVar.v.setText(com.nexstreaming.app.general.util.J.a(this.f23454e, interfaceC1821j.m()));
        if (this.f23457h.b(interfaceC1821j.getAssetId())) {
            bVar.x.setText(R.string.themecat_installed);
            bVar.x.setEnabled(false);
            bVar.A.setVisibility(4);
            bVar.z.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.D
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Ja.a(view);
                }
            });
        } else {
            bVar.z.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.G
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Ja.this.a(interfaceC1821j, bVar, view);
                }
            });
        }
        bVar.B.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ja.this.a(bVar, interfaceC1821j, view);
            }
        });
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ja.this.a(bVar, i, view);
            }
        });
        bVar.w.setListener(new ExpandableLayout.c() { // from class: com.nexstreaming.kinemaster.ui.store.controller.u
            @Override // com.nexstreaming.kinemaster.ui.store.view.ExpandableLayout.c
            public final void a(float f2, ExpandableLayout.State state) {
                Ja.this.a(i, f2, state);
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        d(this.f23456g);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.f23454e = viewGroup.getContext();
        if (c(i)) {
            return new a(LayoutInflater.from(this.f23454e).inflate(R.layout.audio_muserk_category, viewGroup, false));
        }
        return new b(LayoutInflater.from(this.f23454e).inflate(R.layout.audio_asset_item, viewGroup, false));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.n.reset();
        d(this.f23456g);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        c(this.f23456g);
        this.n.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(b bVar, Task task, Task.Event event, Task.TaskError taskError) {
        bVar.z.setEnabled(true);
        bVar.x.setVisibility(0);
        bVar.x.setEnabled(true);
        bVar.x.setText(R.string.check_before_download_download);
        bVar.A.setVisibility(4);
        bVar.A.setProgress(0);
    }

    private void c(b bVar) {
        bVar.C.setVisibility(0);
        bVar.C.setChecked(true);
        bVar.D.setVisibility(8);
    }

    public /* synthetic */ void a(b bVar, ResultTask resultTask, Task.Event event, InterfaceC1821j interfaceC1821j) {
        char c2;
        String priceType = interfaceC1821j.getPriceType();
        int hashCode = priceType.hashCode();
        if (hashCode == 2198156) {
            if (priceType.equals("Free")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 2479852) {
            if (hashCode == 1346201143 && priceType.equals("Premium")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (priceType.equals("Paid")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            a(bVar, interfaceC1821j);
            return;
        }
        if (c2 != 1) {
            return;
        }
        PurchaseType A = this.j.A();
        if (A != null && 2 == A.getLevel()) {
            a(bVar, interfaceC1821j);
            return;
        }
        com.nexstreaming.kinemaster.ui.f.a.b.a().a(new com.nexstreaming.kinemaster.ui.f.a.a("RX_EVENT_SHOW_SUBSCRIPTION", null));
        this.k = bVar;
        this.l = interfaceC1821j;
    }

    private void b(b bVar) {
        if (!bVar.w.a()) {
            bVar.itemView.setBackgroundColor(ContextCompat.getColor(this.f23454e, R.color.pale_grey));
        }
        bVar.s.setTextColor(ContextCompat.getColor(this.f23454e, R.color.grapefruit));
        bVar.C.setVisibility(4);
        bVar.D.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, Task task, Task.Event event, Task.TaskError taskError) {
        bVar.z.setEnabled(true);
        bVar.x.setVisibility(0);
        bVar.x.setEnabled(true);
        bVar.x.setText(R.string.check_before_download_download);
        bVar.A.setVisibility(4);
        bVar.A.setProgress(0);
    }

    public /* synthetic */ void a(b bVar, InterfaceC1821j interfaceC1821j, View view) {
        if (bVar == this.f23456g) {
            if (!bVar.C.isChecked()) {
                b(bVar);
                a(interfaceC1821j);
            } else {
                d(bVar);
                k();
            }
        } else {
            b bVar2 = this.f23455f;
            if (bVar2 != null) {
                a(bVar2);
                this.f23455f = bVar;
            }
            b bVar3 = this.f23456g;
            if (bVar3 != null) {
                d(bVar3);
                k();
            }
            b(bVar);
            a(interfaceC1821j);
        }
        this.f23456g = bVar;
        this.f23455f = bVar;
    }

    public /* synthetic */ void a(b bVar, int i, View view) {
        if (bVar == this.f23455f) {
            if (bVar.w.a()) {
                a(bVar);
            } else {
                a(bVar, i);
            }
        } else {
            b bVar2 = this.f23456g;
            if (bVar2 != null) {
                d(bVar2);
                k();
                this.f23456g = bVar;
            }
            b bVar3 = this.f23455f;
            if (bVar3 != null) {
                a(bVar3);
            }
            a(bVar, i);
        }
        this.f23455f = bVar;
        this.f23456g = bVar;
    }

    public /* synthetic */ void a(int i, float f2, ExpandableLayout.State state) {
        if (state == ExpandableLayout.State.EXPANDED) {
            this.f23452c.smoothScrollToPosition(i);
        }
    }

    private void a(final b bVar, final InterfaceC1821j interfaceC1821j) {
        bVar.z.setEnabled(false);
        bVar.x.setVisibility(4);
        bVar.A.setVisibility(0);
        this.i.a(new com.nexstreaming.app.general.service.download.k(String.valueOf(interfaceC1821j.a()), com.nexstreaming.app.general.util.J.a(this.f23454e, interfaceC1821j.j(), interfaceC1821j.f()), interfaceC1821j.p(), interfaceC1821j.l(), this.f23457h.a(interfaceC1821j.a()), interfaceC1821j.h())).onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.v
            @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
            public final void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
                Ja.this.a(interfaceC1821j, bVar, resultTask, event, (com.nexstreaming.app.general.service.download.k) obj);
            }
        }).onProgress(new Task.OnProgressListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.y
            @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
            public final void onProgress(Task task, Task.Event event, int i, int i2) {
                Ja.a(Ja.b.this, task, event, i, i2);
            }
        }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.A
            @Override // com.nexstreaming.app.general.task.Task.OnFailListener
            public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
                Ja.this.a(bVar, interfaceC1821j, task, event, taskError);
            }
        });
    }

    public /* synthetic */ void a(InterfaceC1821j interfaceC1821j, final b bVar, ResultTask resultTask, Task.Event event, com.nexstreaming.app.general.service.download.k kVar) {
        com.nexstreaming.kinemaster.usage.analytics.j.a(interfaceC1821j, AssetDownloadResult.SUCCESS);
        bVar.x.setEnabled(false);
        bVar.x.setVisibility(0);
        bVar.x.setText(R.string.installing_assets);
        bVar.A.setVisibility(4);
        this.f23457h.a(interfaceC1821j).onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.x
            @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
            public final void onTaskEvent(Task task, Task.Event event2) {
                Ja.a(Ja.b.this, task, event2);
            }
        }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.w
            @Override // com.nexstreaming.app.general.task.Task.OnFailListener
            public final void onFail(Task task, Task.Event event2, Task.TaskError taskError) {
                Ja.b(Ja.b.this, task, event2, taskError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, Task task, Task.Event event) {
        bVar.x.setText(R.string.themecat_installed);
        bVar.x.setEnabled(false);
        bVar.x.setVisibility(0);
        bVar.A.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, Task task, Task.Event event, int i, int i2) {
        bVar.x.setVisibility(4);
        bVar.A.setProgress(i);
        bVar.A.setMax(i2);
    }

    public /* synthetic */ void a(b bVar, InterfaceC1821j interfaceC1821j, Task task, Task.Event event, Task.TaskError taskError) {
        bVar.z.setEnabled(true);
        bVar.x.setVisibility(0);
        bVar.x.setEnabled(true);
        bVar.A.setVisibility(4);
        e.a aVar = new e.a(this.f23454e);
        aVar.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        aVar.a(taskError.getLocalizedMessage(this.f23454e));
        if (PreferenceManager.getDefaultSharedPreferences(this.f23454e).getBoolean("asset_dev_mode", false) && taskError.getException() != null) {
            aVar.b(taskError.getException().getMessage());
        }
        aVar.a().show();
        com.nexstreaming.kinemaster.usage.analytics.j.a(interfaceC1821j, AssetDownloadResult.DOWNLOAD_FAIL);
    }

    private void a(b bVar) {
        if (!bVar.C.isChecked()) {
            this.f23455f.itemView.setBackgroundColor(ContextCompat.getColor(this.f23454e, R.color.km_white));
        }
        this.f23455f.w.a(true);
    }

    private void a(b bVar, int i) {
        if (!bVar.C.isChecked()) {
            bVar.itemView.setBackgroundColor(ContextCompat.getColor(this.f23454e, R.color.pale_grey));
        }
        bVar.w.b(true);
        com.nexstreaming.kinemaster.usage.analytics.j.a(this.f23453d.get(i));
    }

    private void a(InterfaceC1821j interfaceC1821j) {
        String categoryAliasName = interfaceC1821j.getCategoryAliasName();
        if (TextUtils.isEmpty(categoryAliasName)) {
            categoryAliasName = AssetCategoryAlias.Audio.name();
        }
        com.nexstreaming.kinemaster.usage.analytics.j.a(interfaceC1821j.getAssetId(), Integer.toString(interfaceC1821j.a()), interfaceC1821j.f(), "audio", categoryAliasName);
        try {
            this.n.reset();
            if (interfaceC1821j.d() != null) {
                this.n.setDataSource(interfaceC1821j.d());
            } else if (interfaceC1821j.u() != null) {
                this.n.setDataSource(interfaceC1821j.u());
            }
            this.n.prepareAsync();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

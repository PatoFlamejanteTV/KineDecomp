package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import com.adobe.creativesdk.foundation.internal.utils.CreativeSDKTextView;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.C0578la;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observer;

/* loaded from: classes.dex */
public class AdobeShowUploadTasksActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5512a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f5513b = "AdobeShowUploadTasksActivity";

    /* renamed from: c, reason: collision with root package name */
    private RecyclerView f5514c;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f5515d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayoutManager f5516e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f5517f;

    /* renamed from: g, reason: collision with root package name */
    private b f5518g;

    /* renamed from: h, reason: collision with root package name */
    private a f5519h;
    private CreativeSDKTextView i;
    private Toolbar j;
    private Observer k;
    protected com.adobe.creativesdk.foundation.internal.storage.controllers.c.b l;
    private Map<String, ?> m = null;
    private ArrayList<String> n = null;
    private ArrayList<?> o = null;
    private List<d> p = new ArrayList();
    private List<e> q = new ArrayList();
    private List<Observer> r = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum EndPointType {
        AdobeAssetFolder,
        AdobeDCXManifest,
        AdobePhotoCollection
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.Adapter<c> {
        protected a() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c cVar, int i) {
            if (AdobeShowUploadTasksActivity.this.n != null || i < AdobeShowUploadTasksActivity.this.n.size()) {
                String str = (String) AdobeShowUploadTasksActivity.this.n.get(i);
                Boolean bool = (Boolean) AdobeShowUploadTasksActivity.this.o.get(i);
                String e2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.e(str);
                cVar.s.setText(str.substring(str.lastIndexOf("/") + 1));
                cVar.v.setImageBitmap(AdobeShowUploadTasksActivity.this.b(e2, str, AdobeShowUploadTasksActivity.this.getResources().getDimensionPixelSize(c.a.a.a.b.c.upload_preview_width)));
                cVar.w.setOnClickListener(null);
                cVar.t.setVisibility(4);
                cVar.u.setVisibility(0);
                if (bool.booleanValue()) {
                    cVar.u.setText(AdobeShowUploadTasksActivity.this.getString(c.a.a.a.b.i.upload_success_status));
                    cVar.w.setImageDrawable(AdobeShowUploadTasksActivity.this.getResources().getDrawable(c.a.a.a.b.d.ic_check_blue_24dp));
                } else {
                    cVar.u.setText(AdobeShowUploadTasksActivity.this.getString(c.a.a.a.b.i.upload_failed_status));
                    cVar.w.setImageDrawable(AdobeShowUploadTasksActivity.this.getResources().getDrawable(c.a.a.a.b.d.ic_report_problem_red_24dp));
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (AdobeShowUploadTasksActivity.this.m == null) {
                return 0;
            }
            return AdobeShowUploadTasksActivity.this.m.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public c onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(c.a.a.a.b.g.adobe_uploadingtasks_recycler_row_item, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.Adapter<c> {
        protected b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AdobeUploadAssetData adobeUploadAssetData, c cVar, EndPointType endPointType, String str, int i) {
            if (adobeUploadAssetData != null) {
                if (adobeUploadAssetData.e() || cVar.x.booleanValue()) {
                    cVar.w.setOnClickListener(null);
                    cVar.t.setVisibility(4);
                    cVar.u.setVisibility(0);
                    if (adobeUploadAssetData.d() == AdobeUploadAssetData.UploadStatus.Completed) {
                        cVar.u.setText(AdobeShowUploadTasksActivity.this.getString(c.a.a.a.b.i.upload_success_status));
                        cVar.w.setImageDrawable(AdobeShowUploadTasksActivity.this.getResources().getDrawable(c.a.a.a.b.d.ic_check_blue_24dp));
                        return;
                    }
                    cVar.u.setText(AdobeShowUploadTasksActivity.this.getString(c.a.a.a.b.i.upload_failed_status));
                    cVar.w.setImageDrawable(AdobeShowUploadTasksActivity.this.getResources().getDrawable(c.a.a.a.b.d.ic_report_problem_red_24dp));
                    if (adobeUploadAssetData.e()) {
                        return;
                    }
                    a(endPointType, str, adobeUploadAssetData);
                    return;
                }
                int c2 = (int) adobeUploadAssetData.c();
                cVar.t.setProgress(c2);
                if (c2 != 100 || adobeUploadAssetData.e()) {
                    return;
                }
                cVar.w.setOnClickListener(null);
                cVar.w.setImageDrawable(AdobeShowUploadTasksActivity.this.getResources().getDrawable(c.a.a.a.b.d.ic_loop_black_24dp));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (AdobeShowUploadTasksActivity.this.q == null) {
                return 0;
            }
            return AdobeShowUploadTasksActivity.this.q.size();
        }

        public void a(AdobeUploadAssetData adobeUploadAssetData, c cVar, EndPointType endPointType, String str, int i) {
            AdobeShowUploadTasksActivity.this.runOnUiThread(new L(this, adobeUploadAssetData, cVar, endPointType, str, i));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public c onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(c.a.a.a.b.g.adobe_uploadingtasks_recycler_row_item, viewGroup, false));
        }

        public void a(EndPointType endPointType, String str, AdobeUploadAssetData adobeUploadAssetData) {
            if (endPointType.equals(EndPointType.AdobeAssetFolder)) {
                com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(C0578la.class).a(str).a(adobeUploadAssetData);
            } else if (endPointType.equals(EndPointType.AdobeDCXManifest)) {
                com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.class).a(str).a(adobeUploadAssetData);
            } else {
                com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(AdobePhotoCollection.class).a(str).a(adobeUploadAssetData);
            }
        }

        public void a(AdobeUploadAssetData adobeUploadAssetData, c cVar) {
            cVar.s.setText(adobeUploadAssetData.f5273b);
            int dimensionPixelSize = AdobeShowUploadTasksActivity.this.getResources().getDimensionPixelSize(c.a.a.a.b.c.upload_preview_width);
            String b2 = adobeUploadAssetData.b();
            if (b2 == null) {
                b2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.e(adobeUploadAssetData.a().getPath());
            }
            if (cVar.v.getDrawable() == null) {
                cVar.v.setImageBitmap(AdobeShowUploadTasksActivity.this.b(b2, adobeUploadAssetData.a().getPath(), dimensionPixelSize));
            }
        }

        public void a(EndPointType endPointType, String str, AdobeUploadAssetData adobeUploadAssetData, c cVar, int i) {
            cVar.w.setOnClickListener(new M(this, cVar, adobeUploadAssetData, endPointType, str, i));
        }

        public void a(int i, c cVar) {
            e eVar = (e) AdobeShowUploadTasksActivity.this.q.get(i);
            AdobeUploadAssetData adobeUploadAssetData = eVar.f5526b;
            a(adobeUploadAssetData, cVar);
            a(eVar.f5525a, eVar.f5527c, adobeUploadAssetData, cVar, i);
            a(adobeUploadAssetData, cVar, eVar.f5525a, eVar.f5527c, i);
            if (eVar.f5525a.equals(EndPointType.AdobeAssetFolder)) {
                com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(C0578la.class).a(eVar.f5527c);
                N n = new N(this, cVar, eVar, i);
                AdobeShowUploadTasksActivity.this.r.add(i, n);
                a2.a(adobeUploadAssetData, n);
                return;
            }
            if (eVar.f5525a.equals(EndPointType.AdobeDCXManifest)) {
                com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t a3 = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.class).a(eVar.f5527c);
                O o = new O(this, cVar, eVar, i);
                AdobeShowUploadTasksActivity.this.r.add(i, o);
                a3.a(adobeUploadAssetData, o);
                return;
            }
            com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t a4 = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(AdobePhotoCollection.class).a(eVar.f5527c);
            P p = new P(this, cVar, eVar, i);
            AdobeShowUploadTasksActivity.this.r.add(i, p);
            a4.a(adobeUploadAssetData, p);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c cVar, int i) {
            a(i, cVar);
        }

        public boolean a(AdobeUploadAssetData adobeUploadAssetData) {
            if (((int) adobeUploadAssetData.c()) == 100) {
                return false;
            }
            return adobeUploadAssetData.d() == AdobeUploadAssetData.UploadStatus.YetToStart || adobeUploadAssetData.d() == AdobeUploadAssetData.UploadStatus.Started || adobeUploadAssetData.d() == AdobeUploadAssetData.UploadStatus.InProgress;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class c extends RecyclerView.ViewHolder {
        private TextView s;
        private ProgressBar t;
        private TextView u;
        private ImageView v;
        private ImageView w;
        private Boolean x;
        private Boolean y;

        public c(View view) {
            super(view);
            this.x = false;
            this.y = true;
            this.s = (TextView) view.findViewById(c.a.a.a.b.e.upload_asset_title);
            this.w = (ImageView) view.findViewById(c.a.a.a.b.e.upload_cancel_image);
            this.t = (ProgressBar) view.findViewById(c.a.a.a.b.e.uploading_progress_bar);
            this.v = (ImageView) view.findViewById(c.a.a.a.b.e.upload_asset_img);
            this.u = (TextView) view.findViewById(c.a.a.a.b.e.upload_asset_text_status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        EndPointType f5522a;

        /* renamed from: b, reason: collision with root package name */
        String f5523b;

        public d(String str, EndPointType endPointType) {
            this.f5522a = endPointType;
            this.f5523b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        EndPointType f5525a;

        /* renamed from: b, reason: collision with root package name */
        AdobeUploadAssetData f5526b;

        /* renamed from: c, reason: collision with root package name */
        String f5527c;

        public e(AdobeUploadAssetData adobeUploadAssetData, EndPointType endPointType, String str) {
            this.f5525a = endPointType;
            this.f5526b = adobeUploadAssetData;
            this.f5527c = str;
        }
    }

    private void A() {
        this.f5516e = new LinearLayoutManager(this);
        this.f5515d.setLayoutManager(this.f5516e);
        this.f5519h = new a();
        this.f5515d.setAdapter(this.f5519h);
        this.f5515d.setItemAnimator(null);
    }

    private void B() {
        setSupportActionBar(this.j);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, c.a.a.a.b.b.adobe_loki_status_bar));
        }
    }

    private void x() {
        for (int i = 0; i < this.p.size(); i++) {
            d dVar = this.p.get(i);
            if (dVar.f5522a.equals(EndPointType.AdobeAssetFolder)) {
                com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(C0578la.class).a(dVar.f5523b);
                if (a2 != null) {
                    a(a2.a(), EndPointType.AdobeAssetFolder, dVar.f5523b);
                }
            } else if (dVar.f5522a.equals(EndPointType.AdobeDCXManifest)) {
                com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t a3 = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.class).a(dVar.f5523b);
                if (a3 != null) {
                    a(a3.a(), EndPointType.AdobeDCXManifest, dVar.f5523b);
                }
            } else {
                com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t a4 = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(AdobePhotoCollection.class).a(dVar.f5523b);
                if (a4 != null) {
                    a(a4.a(), EndPointType.AdobePhotoCollection, dVar.f5523b);
                }
            }
        }
    }

    private void y() {
        this.m = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.q.b();
        v();
    }

    private void z() {
        this.f5516e = new LinearLayoutManager(this);
        this.f5514c.setLayoutManager(this.f5516e);
        this.f5518g = new b();
        this.f5514c.setAdapter(this.f5518g);
        this.f5514c.setItemAnimator(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.a.a.a.b.g.activity_adobe_show_upload_tasks);
        this.i = (CreativeSDKTextView) findViewById(c.a.a.a.b.e.adobe_csdk_actionbar_title_upload);
        this.f5514c = (RecyclerView) findViewById(c.a.a.a.b.e.adobe_uploading_tasks_RecyclerView);
        this.f5515d = (RecyclerView) findViewById(c.a.a.a.b.e.adobe_uploads_history_RecyclerView);
        this.j = (Toolbar) findViewById(c.a.a.a.b.e.upload_toolbar);
        this.f5517f = (RelativeLayout) findViewById(c.a.a.a.b.e.uploads_empty_state_view);
        this.l = new com.adobe.creativesdk.foundation.internal.storage.controllers.c.b();
        B();
        this.p.clear();
        this.q.clear();
        this.r.clear();
        u();
        w();
        x();
        y();
        z();
        A();
        this.f5518g.notifyDataSetChanged();
        this.f5519h.notifyDataSetChanged();
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        f5512a = true;
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a().booleanValue()) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.f6459a = false;
            c(getString(c.a.a.a.b.i.upload_activity_title_finished));
        } else {
            com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.f6459a = true;
            c(getString(c.a.a.a.b.i.upload_activity_title_running));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        f5512a = false;
        super.onStop();
    }

    public void t() {
        Map<String, ?> map;
        if (this.q.size() == 0 && ((map = this.m) == null || map.size() == 0)) {
            this.f5514c.setVisibility(8);
            this.f5515d.setVisibility(8);
            this.f5517f.setVisibility(0);
        } else {
            if (this.q.size() == 0) {
                this.f5514c.setVisibility(8);
                return;
            }
            Map<String, ?> map2 = this.m;
            if (map2 == null || map2.size() == 0) {
                this.f5515d.setVisibility(8);
            }
        }
    }

    public void u() {
        a(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(C0578la.class).b(), EndPointType.AdobeAssetFolder);
        a(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.class).b(), EndPointType.AdobeDCXManifest);
        a(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(AdobePhotoCollection.class).b(), EndPointType.AdobePhotoCollection);
    }

    public void v() {
        Map<String, ?> map = this.m;
        if (map == null || map.size() <= 0) {
            return;
        }
        this.n = new ArrayList<>(this.m.keySet());
        this.o = new ArrayList<>(this.m.values());
        this.f5515d.setVisibility(0);
    }

    protected void w() {
        if (this.k == null) {
            this.k = new K(this);
        }
        this.l.a(AdobeInternalNotificationID.AdobeNoUploadSessions, this.k);
        this.l.a(AdobeInternalNotificationID.AdobeUploadSessionsActive, this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        this.i.setText(str);
    }

    protected Bitmap b(String str, String str2, int i) {
        Bitmap bitmap = null;
        if (str != null) {
            try {
                if (str.contains("image/")) {
                    int i2 = i * 2;
                    bitmap = ThumbnailUtils.extractThumbnail(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.v.a(str2, i2, i2), i, i);
                } else if (str.contains("video/")) {
                    bitmap = ThumbnailUtils.extractThumbnail(ThumbnailUtils.createVideoThumbnail(str2, 1), i, i);
                }
            } catch (Exception e2) {
                Log.e(f5513b, e2.getMessage());
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e(f5513b, e3.getMessage());
                return null;
            }
        }
        if (bitmap != null) {
            return bitmap;
        }
        String str3 = "." + com.adobe.creativesdk.foundation.internal.storage.model.util.i.d(str2);
        Log.e(f5513b, str3);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) com.adobe.creativesdk.foundation.internal.utils.a.a(getApplicationContext(), str3);
        if (bitmapDrawable != null) {
            return ThumbnailUtils.extractThumbnail(bitmapDrawable.getBitmap(), i, i);
        }
        return ThumbnailUtils.extractThumbnail(((BitmapDrawable) com.adobe.creativesdk.foundation.internal.utils.a.a(getApplicationContext())).getBitmap(), i, i);
    }

    private void a(List<String> list, EndPointType endPointType) {
        for (int i = 0; i < list.size(); i++) {
            this.p.add(new d(list.get(i), endPointType));
        }
    }

    private void a(List<AdobeUploadAssetData> list, EndPointType endPointType, String str) {
        for (int i = 0; i < list.size(); i++) {
            this.q.add(new e(list.get(i), endPointType, str));
        }
    }
}

package com.nexstreaming.kinemaster.ui.share;

import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdContainer;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* compiled from: ExportedVideoListAdapter.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.ga */
/* loaded from: classes2.dex */
public class C2220ga extends BaseAdapter {

    /* renamed from: a */
    private int f23343a = -1;

    /* renamed from: b */
    private ArrayList<V> f23344b = new ArrayList<>();

    /* renamed from: c */
    private View.OnClickListener f23345c;

    /* renamed from: d */
    private FrameLayout f23346d;

    /* compiled from: ExportedVideoListAdapter.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.share.ga$a */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a */
        TextView f23347a;

        /* renamed from: b */
        TextView f23348b;

        /* renamed from: c */
        ImageButton f23349c;

        /* renamed from: d */
        ImageButton f23350d;

        /* renamed from: e */
        ImageButton f23351e;

        private a() {
        }

        /* synthetic */ a(C2218fa c2218fa) {
            this();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.f23345c = onClickListener;
    }

    public boolean b() {
        if (this.f23346d != null) {
            if (this.f23344b.size() == 1 && this.f23344b.get(0) == null) {
                return true;
            }
            if (this.f23344b.size() > 1 && this.f23344b.get(1) == null) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<V> arrayList = this.f23344b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<V> arrayList = this.f23344b;
        if (arrayList == null || arrayList.size() <= i) {
            return null;
        }
        return this.f23344b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        V v = this.f23344b.get(i);
        if (getCount() == 1 && (frameLayout2 = this.f23346d) != null && i == 0) {
            return frameLayout2;
        }
        if (getCount() > 1 && (frameLayout = this.f23346d) != null && i == 1) {
            return frameLayout;
        }
        if (view != null && !(view instanceof UnifiedNativeAdView) && !(view instanceof TencentAdContainer)) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exported_video_list_item, viewGroup, false);
            aVar = new a();
            aVar.f23347a = (TextView) view.findViewById(R.id.video_name);
            aVar.f23348b = (TextView) view.findViewById(R.id.version_detail);
            aVar.f23349c = (ImageButton) view.findViewById(R.id.play_button);
            aVar.f23350d = (ImageButton) view.findViewById(R.id.share_button);
            aVar.f23351e = (ImageButton) view.findViewById(R.id.delete_button);
            view.setTag(aVar);
        }
        File file = new File(v.f23316e);
        String substring = file.getName().substring(0, file.getName().lastIndexOf(46));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        if (Locale.KOREA.getCountry().equals(view.getContext().getResources().getConfiguration().locale.getCountry())) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
            Date date = new Date(file.lastModified());
            substring = substring.replace(simpleDateFormat.format(date), simpleDateFormat2.format(date));
        }
        aVar.f23347a.setText(substring);
        aVar.f23347a.setTextColor(ContextCompat.getColor(viewGroup.getContext(), i == this.f23343a ? R.color.export_file_list_text_selected_color : android.R.color.white));
        aVar.f23347a.setEllipsize(i == this.f23343a ? TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.END);
        aVar.f23347a.setSelected(i == this.f23343a);
        aVar.f23348b.setText(viewGroup.getContext().getString(R.string.project_version_info, String.format(Locale.US, "%d      %s", Integer.valueOf(v.f23314c), simpleDateFormat.format(new Date(v.f23315d)))));
        aVar.f23348b.setVisibility(this.f23343a != i ? 8 : 0);
        aVar.f23351e.setOnClickListener(this.f23345c);
        aVar.f23350d.setOnClickListener(this.f23345c);
        aVar.f23349c.setOnClickListener(this.f23345c);
        view.setOnClickListener(this.f23345c);
        return view;
    }

    public void a(ArrayList<V> arrayList) {
        if (this.f23344b.size() > 0) {
            this.f23344b.clear();
        }
        this.f23344b.addAll(arrayList);
        FrameLayout frameLayout = this.f23346d;
        if (frameLayout != null) {
            a(frameLayout);
        }
        notifyDataSetChanged();
    }

    public void a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            if (this.f23346d != null) {
                if (this.f23344b.size() == 1 && this.f23344b.get(0) == null) {
                    this.f23344b.remove(0);
                } else if (this.f23344b.size() >= 2 && this.f23344b.get(1) == null) {
                    this.f23344b.remove(1);
                }
            }
        } else if (this.f23344b.size() == 0) {
            this.f23344b.add(0, null);
        } else if (this.f23344b.size() >= 1) {
            if (this.f23344b.size() == 1 && this.f23344b.get(0) != null) {
                this.f23344b.add(1, null);
            } else if (this.f23344b.size() > 1 && this.f23344b.get(1) != null) {
                this.f23344b.add(1, null);
            }
        }
        this.f23346d = frameLayout;
        notifyDataSetChanged();
    }

    public int a() {
        return this.f23343a;
    }

    public void a(int i) {
        this.f23343a = i;
        notifyDataSetChanged();
    }
}

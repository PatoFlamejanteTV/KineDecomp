package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.File;
import java.text.Normalizer;
import java.util.List;
import java.util.Locale;

/* compiled from: SongAdapter.java */
/* loaded from: classes.dex */
public class q extends BaseAdapter implements SectionIndexer {

    /* renamed from: a, reason: collision with root package name */
    private List<n> f3683a;
    private a e;
    private String[] b = null;
    private int[] c = null;
    private int[] d = null;
    private int f = -1;
    private View.OnClickListener g = new r(this);

    /* compiled from: SongAdapter.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(q qVar, n nVar, int i);

        void b(q qVar, n nVar, int i);
    }

    public q(List<n> list, a aVar) {
        this.f3683a = list;
        this.e = aVar;
        a();
    }

    public void a(int i) {
        this.f = i;
        notifyDataSetChanged();
    }

    private void a() {
        String upperCase;
        char charAt;
        if (this.f3683a.size() == 0) {
            this.b = new String[0];
            return;
        }
        char[] cArr = new char[this.f3683a.size()];
        this.c = new int[this.f3683a.size()];
        this.d = new int[this.f3683a.size()];
        int i = 0;
        char c = 0;
        for (int i2 = 0; i2 < this.f3683a.size(); i2++) {
            String a2 = this.f3683a.get(i2).a();
            if (a2 == null) {
                String c2 = this.f3683a.get(i2).c();
                if (c2 == null) {
                    upperCase = "";
                } else {
                    upperCase = new File(c2).getName();
                }
            } else {
                upperCase = Normalizer.normalize(a2, Normalizer.Form.NFD).toUpperCase();
            }
            if (upperCase.length() < 1) {
                charAt = '?';
            } else {
                charAt = upperCase.charAt(0);
            }
            if (c != charAt) {
                if (c != 0) {
                    i++;
                }
                this.c[i] = i2;
                cArr[i] = charAt;
                c = charAt;
            }
            this.d[i2] = this.c[i];
        }
        this.b = new String[i + 1];
        for (int i3 = 0; i3 < i + 1; i3++) {
            this.b[i3] = Character.toString(cArr[i3]);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3683a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3683a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        n nVar = this.f3683a.get(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.n2_amediabrowser_audio_text_new, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.AlbumName)).setText(nVar.a());
        ((TextView) view.findViewById(R.id.Duration)).setText(b(nVar.b()));
        View findViewById = view.findViewById(R.id.Play);
        View findViewById2 = view.findViewById(R.id.AddAudio);
        findViewById.setFocusable(false);
        findViewById2.setFocusable(false);
        findViewById.setOnClickListener(this.g);
        findViewById2.setOnClickListener(this.g);
        findViewById.setSelected(i == this.f);
        return view;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        if (this.c == null || i < 0 || i >= this.c.length) {
            return -1;
        }
        return this.c[i];
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        if (this.c == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.b.length; i2++) {
            if (this.c[i2] < i) {
                return i2 - 1;
            }
        }
        return this.b.length;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.b;
    }

    private static String b(int i) {
        if (i < 0) {
            return "?:??";
        }
        int i2 = (i % 3600000) / 60000;
        int i3 = ((i % 3600000) % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
        if (i2 == 0 && i3 == 0 && i > 0) {
            i3 = 1;
        }
        return String.format(Locale.US, "%d:%02d", Integer.valueOf(i2), Integer.valueOf(i3));
    }
}

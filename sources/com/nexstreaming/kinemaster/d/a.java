package com.nexstreaming.kinemaster.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.af;
import com.nextreaming.nexeditorui.ba;
import java.lang.ref.WeakReference;

/* compiled from: PurchaseDialog.java */
@Deprecated
/* loaded from: classes.dex */
public class a extends Dialog {
    private static WeakReference<a> b;

    /* renamed from: a */
    WeakReference<ba> f3292a;
    private TextView c;
    private TextView d;
    private TextView e;
    private View f;
    private View g;
    private View h;
    private af i;
    private String j;
    private View.OnClickListener k;
    private View.OnClickListener l;

    public static a a() {
        if (b != null) {
            return b.get();
        }
        return null;
    }

    public a(ba baVar, String str) {
        super(baVar, 16973840);
        this.k = new b(this);
        this.l = new c(this);
        this.j = str;
        a a2 = a();
        if (a2 != null) {
            a2.dismiss();
        }
        this.f3292a = new WeakReference<>(baVar);
        this.i = baVar.A();
        b = new WeakReference<>(this);
    }

    public af b() {
        return this.i;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.purchase_dialog);
        this.c = (TextView) findViewById(R.id.sub_just_a_month_price);
        this.d = (TextView) findViewById(R.id.sub_monthly_price);
        this.e = (TextView) findViewById(R.id.sub_annual_price);
        this.f = findViewById(R.id.button_sub_30days);
        this.g = findViewById(R.id.button_sub_monthly);
        this.h = findViewById(R.id.button_sub_annual);
        ((TextView) findViewById(R.id.message)).setText(NexEditorDeviceProfile.getDeviceProfile().getSupportsVideoLayers(EditorGlobal.a().i()) ? R.string.sub_explain_vlayer : R.string.sub_explain);
        if (this.f3292a.get() != null) {
            if (b() != null && b().g() != null && b().h() != null && b().i() != null) {
                this.c.setText(b().g().c());
                this.d.setText(b().h().c());
                this.e.setText(b().i().c());
                this.f.setOnClickListener(this.k);
                this.g.setOnClickListener(this.k);
                this.h.setOnClickListener(this.k);
                return;
            }
            if (b() != null) {
                b().a((DialogInterface.OnClickListener) null);
            }
            this.f.setOnClickListener(this.l);
            this.g.setOnClickListener(this.l);
            this.h.setOnClickListener(this.l);
        }
    }

    public void a(SKUDetails sKUDetails) {
        ba baVar = this.f3292a.get();
        if (baVar != null) {
            baVar.a(sKUDetails, this.j);
        }
    }
}

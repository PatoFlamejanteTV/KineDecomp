package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ShareSubscriptionActivity extends ad {

    /* renamed from: a, reason: collision with root package name */
    private int f4283a;
    private ImageView b;
    private ImageView c;
    private NexExportProfile e;
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private boolean k;
    private boolean l;
    private View m;
    private View n;
    private View o;
    private View p;
    private View q;
    private View.OnClickListener r = new cj(this);
    private View.OnClickListener s = new ck(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.share_subscription_activity);
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("exportProfile");
            if (serializableExtra != null && (serializableExtra instanceof NexExportProfile)) {
                this.e = (NexExportProfile) serializableExtra;
            }
            this.f4283a = intent.getIntExtra("kinemaster.shareTo", -1);
        }
        ((TextView) findViewById(R.id.sub_explain_text)).setText(NexEditorDeviceProfile.getDeviceProfile().getSupportsVideoLayers(EditorGlobal.a().i()) ? R.string.sub_explain_vlayer : R.string.sub_explain);
        this.b = (ImageView) findViewById(R.id.freeThumbnailView);
        this.c = (ImageView) findViewById(R.id.promoThumbnailView);
        this.f = findViewById(R.id.freeButton);
        this.g = (TextView) findViewById(R.id.sub_just_a_month_price);
        this.h = (TextView) findViewById(R.id.sub_monthly_price);
        this.i = (TextView) findViewById(R.id.sub_annual_price);
        this.p = findViewById(R.id.button_sub_30days);
        this.o = findViewById(R.id.button_sub_monthly);
        this.n = findViewById(R.id.button_sub_annual);
        this.q = findViewById(R.id.button_sub_promo);
        this.j = findViewById(R.id.purchase_ui_wrapper);
        this.m = findViewById(R.id.payBtnHolder);
        this.j.setVisibility(4);
        a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Intent intent = new Intent(this, (Class<?>) ShareQualityActivity.class);
        f().a(intent);
        intent.putExtras(getIntent());
        intent.setData(getIntent().getData());
        intent.putExtra("kinemaster.shareTo", this.f4283a);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba
    public void a(boolean z) {
        super.a(z);
        this.l = true;
        l();
    }

    private void l() {
        if (this.l && this.k) {
            if (B()) {
                k();
                return;
            }
            this.j.setVisibility(0);
            this.f.setOnClickListener(new ch(this));
            this.g.setText(" ");
            this.h.setText(" ");
            this.i.setText(" ");
            this.q.setOnClickListener(new ci(this));
            if (A() != null && A().g() != null && A().h() != null && A().i() != null) {
                this.g.setText(A().g().c());
                this.h.setText(A().h().c());
                this.i.setText(A().i().c());
                this.p.setOnClickListener(this.r);
                this.o.setOnClickListener(this.r);
                this.n.setOnClickListener(this.r);
                return;
            }
            this.m.setAlpha(0.2f);
            this.p.setOnClickListener(this.s);
            this.o.setOnClickListener(this.s);
            this.n.setOnClickListener(this.s);
            if (A() != null) {
                A().a((DialogInterface.OnClickListener) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.share.ad
    public void a() {
        this.k = true;
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.share.ad
    public void b(Bitmap bitmap) {
        this.b.setImageBitmap(a(bitmap, R.drawable.sub_mask_plain, R.drawable.sub_border_plain));
        this.c.setImageBitmap(a(bitmap, R.drawable.sub_mask_reflection, R.drawable.sub_border_ribbons));
    }

    private Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        Paint paint = new Paint();
        Drawable drawable = getResources().getDrawable(i);
        Drawable drawable2 = getResources().getDrawable(i2);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
        drawable.draw(canvas);
        Rect rect = new Rect(0, 0, createBitmap.getWidth(), (createBitmap.getHeight() * 213) / 260);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        canvas.save();
        canvas.scale(1.0f, -1.0f, 0.0f, (createBitmap.getHeight() * 213) / 260);
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        canvas.restore();
        drawable2.setBounds(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
        drawable2.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        KMUsage.Activity_Subscription.begin();
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.share.ad, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStop() {
        KMUsage.Activity_Subscription.end();
        super.onStop();
    }
}

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
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ShareSubscriptionActivity extends na {
    private int L;
    private ImageView M;
    private ImageView N;
    private NexExportProfile O;
    private View P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private View T;
    private boolean U;
    private boolean V;
    private View W;
    private View X;
    private View Y;
    private View Z;
    private View aa;
    private View.OnClickListener ba = new Ha(this);
    private View.OnClickListener ca = new Ia(this);

    public void L() {
        Intent intent = new Intent(this, (Class<?>) ExportAndShareActivity.class);
        G().a(intent);
        intent.putExtras(getIntent());
        intent.setData(getIntent().getData());
        intent.putExtra("kinemaster.shareTo", this.L);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    private void M() {
        if (this.V && this.U) {
            if (C()) {
                L();
                return;
            }
            this.T.setVisibility(0);
            this.P.setOnClickListener(new Fa(this));
            this.Q.setText(" ");
            this.R.setText(" ");
            this.S.setText(" ");
            this.aa.setOnClickListener(new Ga(this));
            if (y() != null && y().k() != null && y().o() != null && y().s() != null) {
                this.Q.setText(y().k().c());
                this.R.setText(y().o().c());
                this.S.setText(y().s().c());
                this.Z.setOnClickListener(this.ba);
                this.Y.setOnClickListener(this.ba);
                this.X.setOnClickListener(this.ba);
                return;
            }
            this.W.setAlpha(0.2f);
            this.Z.setOnClickListener(this.ca);
            this.Y.setOnClickListener(this.ca);
            this.X.setOnClickListener(this.ca);
            if (y() != null) {
                y().a((DialogInterface.OnClickListener) null);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.na
    public void J() {
        this.U = true;
        M();
    }

    @Override // com.nextreaming.nexeditorui.I
    public void g(boolean z) {
        super.g(z);
        this.V = true;
        M();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.share_subscription_activity);
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("exportProfile");
            if (serializableExtra != null && (serializableExtra instanceof NexExportProfile)) {
                this.O = (NexExportProfile) serializableExtra;
            }
            this.L = intent.getIntExtra("kinemaster.shareTo", -1);
        }
        this.M = (ImageView) findViewById(R.id.freeThumbnailView);
        this.N = (ImageView) findViewById(R.id.promoThumbnailView);
        this.P = findViewById(R.id.freeButton);
        this.Q = (TextView) findViewById(R.id.sub_just_a_month_price);
        this.R = (TextView) findViewById(R.id.sub_monthly_price);
        this.S = (TextView) findViewById(R.id.sub_annual_price);
        this.Z = findViewById(R.id.button_sub_30days);
        this.Y = findViewById(R.id.button_sub_monthly);
        this.X = findViewById(R.id.button_sub_annual);
        this.aa = findViewById(R.id.button_sub_promo);
        this.T = findViewById(R.id.purchase_ui_wrapper);
        this.W = findViewById(R.id.payBtnHolder);
        this.T.setVisibility(4);
        a(bundle);
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.na, com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.na
    public void a(Bitmap bitmap) {
        this.M.setImageBitmap(a(bitmap, R.drawable.sub_mask_plain, R.drawable.sub_border_plain));
        this.N.setImageBitmap(a(bitmap, R.drawable.sub_mask_reflection, R.drawable.sub_border_ribbons));
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
}

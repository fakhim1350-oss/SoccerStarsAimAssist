package com.soccerstars.aimassist;
import android.app.*;import android.content.*;import android.media.projection.MediaProjectionManager;import android.net.Uri;import android.os.*;import android.provider.Settings;import android.graphics.Color;import android.widget.*;
public class MainActivity extends Activity{
 static final int REQ=77;TextView status;
 public void onCreate(Bundle b){super.onCreate(b);LinearLayout l=new LinearLayout(this);l.setOrientation(LinearLayout.VERTICAL);l.setPadding(28,28,28,28);l.setBackgroundColor(Color.rgb(20,20,20));
 TextView t=new TextView(this);t.setText("Soccer Stars Aim Assist");t.setTextColor(Color.WHITE);t.setTextSize(24);l.addView(t);
 status=new TextView(this);status.setText("Overlay را فعال کنید، سپس شروع را بزنید.");status.setTextColor(Color.LTGRAY);status.setTextSize(16);l.addView(status);
 Button o=new Button(this);o.setText("اجازه نمایش روی سایر برنامه‌ها");o.setOnClickListener(v->{if(!Settings.canDrawOverlays(this))startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,Uri.parse("package:"+getPackageName())));});l.addView(o);
 Button s=new Button(this);s.setText("شروع Aim Assist");s.setOnClickListener(v->startCapture());l.addView(s);setContentView(l);}
 void startCapture(){if(!Settings.canDrawOverlays(this)){status.setText("ابتدا Overlay را فعال کنید.");return;}MediaProjectionManager m=(MediaProjectionManager)getSystemService(MEDIA_PROJECTION_SERVICE);startActivityForResult(m.createScreenCaptureIntent(),REQ);}
 protected void onActivityResult(int r,int c,Intent d){super.onActivityResult(r,c,d);if(r==REQ&&c==RESULT_OK&&d!=null){Intent i=new Intent(this,CaptureService.class);i.putExtra("code",c);i.putExtra("data",d);if(Build.VERSION.SDK_INT>=26)startForegroundService(i);else startService(i);status.setText("فعال شد؛ اکنون Soccer Stars را باز کنید.");}}
}
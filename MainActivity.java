package com.soccerstars.aimassist;
import android.app.Activity; import android.content.Intent; import android.media.projection.MediaProjectionManager; import android.net.Uri; import android.os.Bundle; import android.provider.Settings; import android.widget.*;
public class MainActivity extends Activity {
 static final int REQ=1001; TextView status;
 public void onCreate(Bundle b){super.onCreate(b); LinearLayout r=new LinearLayout(this);r.setOrientation(LinearLayout.VERTICAL);r.setPadding(32,32,32,32);
 TextView t=new TextView(this);t.setText("Soccer Stars Aim Assist");t.setTextSize(24);r.addView(t);
 status=new TextView(this);status.setText("ابتدا Overlay را فعال کنید.");r.addView(status);
 Button o=new Button(this);o.setText("اجازه نمایش روی سایر برنامه‌ها");o.setOnClickListener(v->overlay());r.addView(o);
 Button s=new Button(this);s.setText("شروع پایش");s.setOnClickListener(v->capture());r.addView(s);
 Button x=new Button(this);x.setText("توقف");x.setOnClickListener(v->{stopService(new Intent(this,CaptureService.class));status.setText("پایش متوقف شد.");});r.addView(x);setContentView(r);}
 void overlay(){if(!Settings.canDrawOverlays(this))startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:"+getPackageName())));}
 void capture(){if(!Settings.canDrawOverlays(this)){overlay();return;} MediaProjectionManager m=(MediaProjectionManager)getSystemService(MEDIA_PROJECTION_SERVICE);startActivityForResult(m.createScreenCaptureIntent(),REQ);}
 protected void onActivityResult(int r,int c,Intent d){super.onActivityResult(r,c,d);if(r!=REQ)return;if(c!=RESULT_OK||d==null){status.setText("Screen Capture لغو شد.");return;}Intent s=new Intent(this,CaptureService.class);s.putExtra("resultCode",c);s.putExtra("projectionData",d);startForegroundService(s);status.setText("پایش فعال شد.");}
}

package br.com.amigooculto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SlidingDrawer;

public class Splash extends Activity  {
	
	protected int splashTime = 2000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		Thread splashTread = new Thread(){
			@Override
			public void run() {
				try{
					synchronized (this) {
						wait(splashTime);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					finish();
					Intent i = new Intent(Splash.this, Principal.class);  
					startActivity(i);
					stop();
				}
				
			};
		};
		splashTread.start();
	}

}

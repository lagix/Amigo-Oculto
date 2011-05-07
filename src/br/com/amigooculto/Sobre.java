package br.com.amigooculto;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Sobre extends Activity implements OnClickListener {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sobre);
		
		Button btnVoltar = (Button)findViewById(R.id.btnVoltar);
		btnVoltar.setOnClickListener(this);
		
		Button btnEMail = (Button)findViewById(R.id.btnCritica);
		btnEMail.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btnVoltar:finish();break;
			case R.id.btnCritica:eMail();break;
		}
	}
	
	public void eMail() {
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.setType("plain/text");  
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"brunodila@gmail.com"});  
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, R.string.btnCritica);  
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");  

		startActivity(Intent.createChooser(emailIntent, "Send mail..."));		
	}
}

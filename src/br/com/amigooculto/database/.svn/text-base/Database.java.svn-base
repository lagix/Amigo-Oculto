package br.com.amigooculto.database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Database extends Activity {

	private SQLiteDatabase db = null;

	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		db =openOrCreateDatabase("amigo_oculto_db", MODE_PRIVATE, null);
		
		criarTabelas();
	}
	
	private void criarTabelas() {
		//Criando tabela de configuração dos emails
		db.execSQL("CREATE TABLE IF NOT EXISTS emailSetting (_id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, senha TEXT);");
	}	
	
	private void inserir() {
		// Since SQL doesn't allow inserting a completely empty row, the second parameter of db.insert defines the column that will receive NULL if cv is empty
		ContentValues cv=new ContentValues();
		cv.put("YourColumnName", "YourColumnValue");
		db.insert("MyTableName", "YourColumnName", cv);
	}
}

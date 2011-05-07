package br.com.amigooculto;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Lista extends Activity implements OnItemClickListener {
	
	private ListView lstContatos;
	private List<String> contatos = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.lista);
		
		lstContatos = (ListView)findViewById(R.id.lstContatos);
		addContatosNaLista();
		lstContatos.setAdapter(new ArrayAdapter<String>(this,R.layout.item_lista,contatos));
		lstContatos.setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		
		String nomeContato = lstContatos.getItemAtPosition(position).toString(); 
		String idContato= getIdContato(nomeContato);
		
		finish(nomeContato,getTelefoneContato(idContato),getEMail(idContato));
	}
	
	protected void addContatosNaLista(){
		contatos = new ArrayList<String>();
		
		Cursor cursor = getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI,null, null, null, 
					ContactsContract.Contacts.DISPLAY_NAME); 
		while (cursor.moveToNext()) {
		   //String contactId = cursor.getString(cursor.getColumnIndex( 
		   //ContactsContract.Contacts._ID)); 
		   
		   String name = cursor.getString(
                   cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
		   
		   String hasPhone = cursor.getString(cursor.getColumnIndex(
				   ContactsContract.Contacts.HAS_PHONE_NUMBER)); 
		   
		   if (hasPhone.equalsIgnoreCase("1")) { 
			   contatos.add(name);
		   }
		}
	}
	
	public String getIdContato(String nome){
		String idContato = null;
		
		Cursor cursor = getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI,null, 
				null, null, null); 
		while (cursor.moveToNext()) {
		   String contactId = cursor.getString(cursor.getColumnIndex( 
		   ContactsContract.Contacts._ID)); 
		   
		   String name = cursor.getString(
                   cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
		   
		   if (name.equals(nome)) {
			   idContato = contactId;
		   }
		}
		return idContato;
	}
	
	public String getTelefoneContato(String id) {
		
		Cursor cursor = getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI,null, 
				ContactsContract.Contacts._ID + " = " + id, null, null); 
		
		cursor.moveToNext();
		
		String hasPhone = cursor.getString(cursor.getColumnIndex(
				   ContactsContract.Contacts.HAS_PHONE_NUMBER)); 
		   if (hasPhone.equalsIgnoreCase("1")) { 
		      // You know it has a number so now query it like this
		      Cursor phones = getContentResolver().query(
		    		  ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
		    		  null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ 
		    		  id, null, null);
		      
		      String phoneNumber = "-";
		      
		      while (phones.moveToNext()) {
		         phoneNumber = phones.getString(
		        		 phones.getColumnIndex( ContactsContract.CommonDataKinds.Phone.NUMBER));
		      } 
		      phones.close();
		      
		      return phoneNumber;
		   }
		   else {
			   return null;
		   }
	}
	
	public String getEMail(String id) {
		Cursor cursor = getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI,null, 
				ContactsContract.Contacts._ID + " = " + id, null, null); 
		
		cursor.moveToNext();
		
		Cursor emails = getContentResolver().query(
				   ContactsContract.CommonDataKinds.Email.CONTENT_URI, 
				   null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + 
				   id, null, null);
		
		String emailAddress = null;
		   while (emails.moveToNext()) {
		      // This would allow you get several email addresses 
		      emailAddress = emails.getString( 
		      emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
		   } 
		   emails.close();
		   
		   return emailAddress;
	}
	
	public void finish(String nome, String telefone, String eMail) {
		Intent data = new Intent();
		data.putExtra("returnNome", nome);
		data.putExtra("returnTelefone", telefone);
		data.putExtra("returnEMail", eMail);
		setResult(RESULT_OK, data);
		super.finish();
	}

}

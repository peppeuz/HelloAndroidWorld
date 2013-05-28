package com.example.helloandroidworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Context ctx = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button chiudi = (Button) findViewById(R.id.chiudi);
        Button notifica = (Button) findViewById(R.id.notifica);
        notifica.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                creaNotifica(view);
            }
        });
		chiudi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctx);
					alertDialogBuilder.setTitle("Alert di prova");
					//inseriamo qui il titolo della Dialog Box
		 			alertDialogBuilder
						.setMessage("Sei sicuro di voler uscire?")
						//inseriamo qui la domanda da porre all'utente
						.setCancelable(false)
						.setPositiveButton("Sì",new DialogInterface.OnClickListener() {
							//scriviamo qui il testo del bottone per confermare e l'azione da eseguire
							public void onClick(DialogInterface dialog,int id) {
							MainActivity.this.finish();
							}
						  })
						.setNegativeButton("No",new DialogInterface.OnClickListener() {
							//scriviamo qui il testo del bottone per annullare e l'azione da eseguire
							public void onClick(DialogInterface dialog,int id) {
								dialog.cancel();
							}
						});
						AlertDialog alertDialog = alertDialogBuilder.create();
						alertDialog.show();
						//con questi due metodi viene effettivamente generato l'alert e successivamente mostrato
			}
		});
	}


    public void creaNotifica(View view) {
        //Definiamo i due intent da lanciare
        Intent intent1 = new Intent(this, SecondActivity.class);
        PendingIntent pending1 = PendingIntent.getActivity(this, 0, intent1, 0);

        Intent intent2 = new Intent(Intent.ACTION_DIAL, null);
        PendingIntent pending2 = PendingIntent.getActivity(this, 0, intent2, 0);

        // Chiamiamo il Notification Builder e settiamo titolo, testo, testo con notifica espansa e gli intent da lanciare
        Notification provaNotifica = new Notification.Builder(this)
                .setContentTitle("Titolo")
                .setContentText("Notifica di prova")
                .setSmallIcon(R.drawable.ic_launcher)
                .setStyle(new Notification.BigTextStyle().bigText(getResources().getString(R.string.testo_notifica)))
                .setContentIntent(pending1)
                .addAction(R.drawable.ic_launcher, "Lancia", pending1)
                .addAction(R.drawable.ic_launcher, "Chiama", pending2)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        //Cancella la notifica automaticamente quando cliccata
        provaNotifica.flags |= Notification.FLAG_AUTO_CANCEL;

        //Avvia la notifica
        notificationManager.notify(0, provaNotifica);

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void cambia (View view){
		Intent cambioActivity;
		cambioActivity = new Intent (this, SecondActivity.class);
		startActivity(cambioActivity);
		
	}
	
	

}

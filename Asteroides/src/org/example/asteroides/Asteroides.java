package org.example.asteroides;

import org.example.asteroides.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Asteroides extends Activity {
	//Creamos algunas variables como botones y el almacen de puntuaciones
	private Button bAcercaDe;
	private Button bSalir;
	public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();
	
	@Override public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//asignamos los botones a los objetos creados
		 bAcercaDe =  (Button) findViewById(R.id.button03);
		 bSalir = (Button) findViewById(R.id.button4);
		 
		 //Creamos el listener, equivalente al onClick del xml
		 bSalir.setOnClickListener(new OnClickListener() {
			 public void onClick(View view){
				 //finish();
				 lanzarPuntuaciones(view);
			 }
		 }
		 );
	        bAcercaDe.setOnClickListener(new OnClickListener() {

	                   public void onClick(View view) {

	                        lanzarAcercaDe(null);

	                  }

	            });
	}


	@Override public boolean onCreateOptionsMenu(Menu menu) {
	       super.onCreateOptionsMenu(menu);
	       MenuInflater inflater = getMenuInflater();
	       inflater.inflate(R.menu.menu, menu);
	       return true; /** true -> el menú ya está visible */
	    }
	   
	    @Override public boolean onOptionsItemSelected(MenuItem item) {
	             switch (item.getItemId()) {
	             case R.id.acercaDe:
	                    lanzarAcercaDe(null);
	                    break;
	             case R.id.config:
	                    lanzarPreferencias(null);
	                    break;
	             }
	             return true; /** true -> consumimos el item, no se propaga*/
	    }
	
//que hacen los botones
	public void lanzarAcercaDe(View view){
	      Intent i = new Intent(this, AcercaDe.class);
          startActivity(i);
	 }
	public void lanzarPreferencias(View view){
		Intent i = new Intent(this, Preferencias.class);
		startActivity(i);
	 }
	public void lanzarPuntuaciones(View view) {
		Intent i = new Intent(this, Puntuaciones.class);
		startActivity(i);
		}
	public void lanzarJuego(View view) {
		Intent i = new Intent(this, Juego.class);
		startActivity(i);
		}

}

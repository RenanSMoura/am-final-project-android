package br.com.notifycar.repository.api;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Desenvolvimento on 25/09/2016.
 */
public class BloqueioDesbloqueioVeiculoTask extends AsyncTask<String, Void, String> {

    private String aux;
    private String urlSafe;
    private Activity activity;

    public BloqueioDesbloqueioVeiculoTask(String urlSafe, String aux, Activity activity){
        this.aux = aux;
        this.urlSafe = urlSafe;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        try{
            URL url = new URL(urlSafe + "/" + aux);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        String lock = "lock";
        String reset = "reset";

        if(aux.equals(lock)) {
            Toast.makeText(activity, "Veiculo Bloqueado com Sucesso!", Toast.LENGTH_LONG).show();
        } else if(aux.equals(reset)){
            Toast.makeText(activity, "Veiculo Desbloqueado com Sucesso!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(activity, "ERRO!", Toast.LENGTH_LONG).show();
        }
    }
}
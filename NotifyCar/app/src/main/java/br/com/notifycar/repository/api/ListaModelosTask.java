package br.com.notifycar.repository.api;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import br.com.notifycar.R;
import br.com.notifycar.helper.CamposHelper;
import br.com.notifycar.interfacetask.AsyncResponseModelos;
import br.com.notifycar.model.Modelo;
import br.com.notifycar.util.UtilJson;

/**
 * Created by Desenvolvimento on 06/10/2016.
 */
public class ListaModelosTask extends AsyncTask<String, Void, String> {


    private String json = "";

    private Activity activity;

    public ListaModelosTask(Activity activity){
        this.activity = activity;

    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        try {
            url = new URL("http://notifycar-api.mybluemix.net/modelo");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            int codigo = conn.getResponseCode();
            if (codigo == 200) {
                InputStream conteudo = conn.getInputStream();
                json = UtilJson.toString(conteudo);
            }
        }catch (Exception e){
            e.getMessage();
        }
        return json;
    }

    @Override
    protected void onPostExecute(String json) {

        try {
            Spinner spites = (Spinner) activity.findViewById(R.id.spinnerModelos);
            Modelo modelo;
            ArrayList<Modelo> modelos = new ArrayList<>();
            JSONArray lsModelos = new JSONArray(json);
            for (int i = 0; i < lsModelos.length(); i++) {
                modelo = new Modelo();
                modelo.set_id(lsModelos.getJSONObject(i).getString("_id"));
                modelo.setNome(lsModelos.getJSONObject(i).getString("nome"));
                modelos.add(modelo);
            }
            ArrayAdapter<Modelo> adp = new ArrayAdapter<Modelo>(activity, R.layout.spinner_item,modelos);
            spites.setAdapter(adp);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}

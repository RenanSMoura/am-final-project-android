package br.com.notifycar.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.notifycar.R;
import br.com.notifycar.repository.api.CadastroDispositivoTask;

public class CadastroDispositivoActivity extends AppCompatActivity implements View.OnClickListener {
    private String veiculoId;
    private Button btnCadastrarDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_dispositivo);


        btnCadastrarDevice = (Button) findViewById(R.id.btnCadastroDevice);

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        veiculoId = bundle.getString("veiculoId");

        btnCadastrarDevice.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnCadastroDevice:
                CadastroDispositivoTask task = new CadastroDispositivoTask(this, veiculoId);
                task.execute();
                break;
            default:
                break;
        }
    }
}

package ifpi.edu.br.saudecomp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import ifpi.edu.br.saudecomp.dao.ExameDAO;
import ifpi.edu.br.saudecomp.dao.PacienteDAO;
import ifpi.edu.br.saudecomp.modelo.Exame;

public class ExameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exame);
    }

    public void exameClick(View elementoClicado){

        EditText editNome = (EditText)findViewById(R.id.nome_clini_exame);
        EditText editData = (EditText)findViewById(R.id.data_exame);
        Spinner editTipo = (Spinner)findViewById(R.id.tipo_exame);
        Spinner editStatus = (Spinner)findViewById(R.id.status_exame);

        String nome = editNome.getText().toString();
        String data = editData.getText().toString();
        String tipo = editTipo.getSelectedItem().toString();
        String status = editStatus.getSelectedItem().toString();

        Exame exame = new Exame(nome,data, tipo,status);

        ExameDAO dao = new ExameDAO(new PacienteDAO(getApplication()));
        dao.inserirExame(exame);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Exame Agendado:");
        builder.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.show();
    }
}

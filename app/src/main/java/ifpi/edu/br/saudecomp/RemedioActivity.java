package ifpi.edu.br.saudecomp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ifpi.edu.br.saudecomp.dao.PacienteDAO;
import ifpi.edu.br.saudecomp.dao.RemedioDAO;
import ifpi.edu.br.saudecomp.modelo.Remedio;

public class RemedioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedio);
    }

    public void remedioClick(View elementoClicado){

        EditText editNome = (EditText)findViewById(R.id.nome_remedio);
        EditText editModoUso = (EditText)findViewById(R.id.modo_uso);

        String nome = editNome.getText().toString();
        String modoUso = editModoUso.getText().toString();

        Remedio remedio = new Remedio(nome,modoUso);

        RemedioDAO dao = new RemedioDAO(new PacienteDAO(getApplication()));
        dao.inserirRemedio(remedio);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Remedio Adicionado ");
        builder.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.show();
    }
}

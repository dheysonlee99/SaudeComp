package ifpi.edu.br.saudecomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import ifpi.edu.br.saudecomp.dao.PacienteDAO;
import ifpi.edu.br.saudecomp.dao.RemedioDAO;
import ifpi.edu.br.saudecomp.modelo.Paciente;
import ifpi.edu.br.saudecomp.modelo.Remedio;

public class ListaRemedioActivity extends AppCompatActivity {


    private Remedio remedio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_remedio);
        

    }


}

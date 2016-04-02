package ifpi.edu.br.saudecomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import ifpi.edu.br.saudecomp.dao.PacienteDAO;
import ifpi.edu.br.saudecomp.modelo.Consulta;
import ifpi.edu.br.saudecomp.modelo.Paciente;

public class ListaConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consulta);
    }



    @Override
    protected void onResume() {
        super.onResume();

        recarregarDados();

    }

    private void recarregarDados() {
        ListView listConsultas = (ListView) findViewById(R.id.list_consulta);
        PacienteDAO dao = new PacienteDAO(this);
        List<Consulta> consultas = dao.listar();

        ArrayAdapter<Consulta> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, consultas);

        listConsultas.setAdapter(adapter);
    }
}

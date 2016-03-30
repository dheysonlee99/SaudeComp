package ifpi.edu.br.saudecomp;



import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import java.util.zip.Inflater;
import android.widget.AdapterView;
import android.view.View;
import android.widget.ArrayAdapter;

import ifpi.edu.br.saudecomp.modelo.Paciente;
import ifpi.edu.br.saudecomp.dao.PacienteDAO;
import ifpi.edu.br.saudecomp.ConsultaActivity;


public class SaudeActivity extends AppCompatActivity {

    private Paciente p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);
        ListView listPacientes = (ListView) findViewById(R.id.list_pacientes);
        registerForContextMenu(listPacientes);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.cadastre_se) {
            //Toast.makeText(ListaVeiculosActivity.this, "Novo Paciente", Toast.LENGTH_SHORT).show();
            Intent irParaForm = new Intent(this, CadastroActivity.class);
            startActivity(irParaForm);
        } else if (item.getItemId() == R.id.apagar) {
            Toast.makeText(SaudeActivity.this, "Apagar todos..", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();

        recarregarDados();

    }

    private void recarregarDados() {
        ListView listPacientes = (ListView) findViewById(R.id.list_pacientes);
        PacienteDAO dao = new PacienteDAO(this);
        List<Paciente> pacientes = dao.lista();

        ArrayAdapter<Paciente> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pacientes);

        listPacientes.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem item = menu.add("Agendar Consulta");

        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent irParaConsult = new Intent(SaudeActivity.this,ConsultaActivity.class);
                startActivity(irParaConsult);
                Toast.makeText(SaudeActivity.this, "Vc clicou no agendar consulta...", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}

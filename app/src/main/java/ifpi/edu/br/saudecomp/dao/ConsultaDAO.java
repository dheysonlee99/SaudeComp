package ifpi.edu.br.saudecomp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import ifpi.edu.br.saudecomp.ConsultaActivity;
import ifpi.edu.br.saudecomp.modelo.Consulta;
import ifpi.edu.br.saudecomp.dao.PacienteDAO;

/**
 * Created by programador on 30/03/16.
 */

public class ConsultaDAO  {

    private PacienteDAO Ass;

    public ConsultaDAO(PacienteDAO Ass) {
        this.Ass = Ass;
    }

    public void inserirConsulta(Consulta consulta){
        ContentValues cv = new ContentValues();
        cv.put("nome", consulta.getNome());
        cv.put("data", consulta.getData());
        cv.put("especialidade", consulta.getEspecialidade());
        cv.put("status", consulta.getStatus());

        Ass.getWritableDatabase().insert("Consulta", null, cv);
    }

    public void remover(Consulta consulta){
        String[] args = {String.valueOf(consulta.getId())};
        Ass.getWritableDatabase().delete("Consulta", "id = ?", args);
    }

}

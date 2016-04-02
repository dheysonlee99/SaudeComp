package ifpi.edu.br.saudecomp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import ifpi.edu.br.saudecomp.ConsultaActivity;
import ifpi.edu.br.saudecomp.modelo.Consulta;
import ifpi.edu.br.saudecomp.dao.PacienteDAO;
import ifpi.edu.br.saudecomp.modelo.Paciente;

/**
 * Created by programador on 30/03/16.
 */

public class ConsultaDAO  {

    private PacienteDAO ass;

    public ConsultaDAO(PacienteDAO ass){
        this.ass = ass;
    }

    public void inserirConsulta(Consulta consulta){
        ContentValues cv = new ContentValues();
        cv.put("nome", consulta.getNome());
        cv.put("data", consulta.getData());
        cv.put("especialidade", consulta.getEspecialidade());
        cv.put("status", consulta.getStatus());

        ass.getWritableDatabase().insert("Consulta", null, cv);
    }

    public List<Consulta> listar() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM Consulta;";
        Cursor c = ass.getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String nome = c.getString(c.getColumnIndex("nome"));
            String data = c.getString(c.getColumnIndex("data"));
            String especialidade = c.getString(c.getColumnIndex("especialidade"));
            String status = c.getString(c.getColumnIndex("status"));
            Consulta consulta = new Consulta(nome, data,especialidade, status);
            consulta.setId(id);
            consultas.add(consulta);
        }

        return consultas;
    }

    public void remover(Consulta consulta){
        String[] args = {String.valueOf(consulta.getId())};
        ass.getWritableDatabase().delete("Consulta", "id = ?", args);
    }

}

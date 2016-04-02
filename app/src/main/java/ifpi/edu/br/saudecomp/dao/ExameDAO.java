package ifpi.edu.br.saudecomp.dao;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import ifpi.edu.br.saudecomp.modelo.Consulta;
import ifpi.edu.br.saudecomp.modelo.Exame;
import ifpi.edu.br.saudecomp.modelo.Remedio;

/**
 * Created by programador on 31/03/16.
 */
public class ExameDAO {

    private PacienteDAO ass;

    public ExameDAO(PacienteDAO ass){
        this.ass = ass;
    }

    public void inserirExame(Exame exame){

        ContentValues cv = new ContentValues();
        cv.put("nome", exame.getNomeLocal());
        cv.put("data",exame.getData());
        cv.put("tipo",exame.getStatus());
        ass.getWritableDatabase().insert("Exame",null,cv);
    }


    public List<Exame> listar() {
        List<Exame> exames = new ArrayList<>();
        String sql = "SELECT * FROM Exame;";
        Cursor c = ass.getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String nome = c.getString(c.getColumnIndex("nome"));
            String data = c.getString(c.getColumnIndex("data"));
            String tipo = c.getString(c.getColumnIndex("tipo"));
            String status = c.getString(c.getColumnIndex("status"));
            Exame exame = new Exame(nome, data,tipo, status);
            exame.setId(id);
            exames.add(exame);
        }

        return exames;
    }
    public void removerExame(Exame exame){
        String[] args = {String.valueOf(exame.getId())};

        ass.getWritableDatabase().delete("Exame",null, args);

    }


}

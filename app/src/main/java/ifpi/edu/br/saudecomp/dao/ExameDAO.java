package ifpi.edu.br.saudecomp.dao;

import android.content.ContentValues;

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
    public void removerExame(Exame exame){
        String[] args = {String.valueOf(exame.getId())};

        ass.getWritableDatabase().delete("Exame",null, args);

    }


}

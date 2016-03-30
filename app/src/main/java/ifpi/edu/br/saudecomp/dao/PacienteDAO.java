package ifpi.edu.br.saudecomp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ifpi.edu.br.saudecomp.modelo.Paciente;

/**
 * Created by programador on 29/03/16.
 */
public class PacienteDAO extends SQLiteOpenHelper {

    public PacienteDAO(Context context) {
        super(context,"Pacientes.bd", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE Paciente " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR (50), " +
                "numeroSus VARCHAR (50), " +
                "sexo VARCHAR (50)," +
                "idade INTEGER );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS Paciente;";
        db.execSQL(sql);
        onCreate(db);

    }

    public void inserir(Paciente paciente) {
        ContentValues cv = new ContentValues();
        cv.put("nome", paciente.getNome());
        cv.put("numeroSus", paciente.getSusNumero());
        cv.put("idade", paciente.getIdade());
        cv.put("sexo", paciente.getSexo());

        getWritableDatabase().insert("Paciente", null, cv);

    }

    public List<Paciente> lista() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM Paciente;";
        Cursor c = getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String nome = c.getString(c.getColumnIndex("nome"));
            String sus = c.getString(c.getColumnIndex("numeroSus"));
            String idade = c.getString(c.getColumnIndex("idade"));
            String sexo = c.getString(c.getColumnIndex("sexo"));
            Paciente p = new Paciente(nome, sus,idade, sexo);
            p.setId(id);
            pacientes.add(p);
        }

        return pacientes;
    }
   
}
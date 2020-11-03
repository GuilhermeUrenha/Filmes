package com.example.filmes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_FILME = "bd_filmes";

    private static final String TABELA_FILME = "tb_filme";
    private static final String COLUNA_CODIGO = "codigo";
    private static final String COLUNA_TITULO = "titulo";
    private static final String COLUNA_DIRETOR = "diretor";
    private static final String COLUNA_ATORES = "atores";
    private static final String COLUNA_GENERO = "genero";
    private static final String COLUNA_FAIXA = "faixa";
    private static final String COLUNA_LANCA = "lancamento";
    private static final String COLUNA_DURACAO = "duracao";
    private static final String COLUNA_SINOPSE = "sinopse";
    private static final String COLUNA_PAIS = "pais";
    private static final String COLUNA_LINGUA = "lingua";
    private static final String COLUNA_PREMIOS = "premios";

    public BancoDados(Context context) {
        super(context, BANCO_FILME, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_COLUNA = "create table "+ TABELA_FILME +" ("
                + COLUNA_CODIGO +" integer primary key, "
                + COLUNA_TITULO +" text, "
                + COLUNA_DIRETOR +" text, "
                + COLUNA_GENERO +" text,"
                + COLUNA_ATORES +" text,"
                + COLUNA_FAIXA +" text,"
                + COLUNA_LANCA +" text,"
                + COLUNA_DURACAO +" text,"
                + COLUNA_SINOPSE +" text,"
                + COLUNA_PAIS +" text,"
                + COLUNA_LINGUA +" text,"
                + COLUNA_PREMIOS +" text"
                + ")";

        db.execSQL(QUERY_COLUNA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //

    void addFilme(Filme filme){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUNA_TITULO, filme.getTitulo());
        values.put(COLUNA_DIRETOR, filme.getDiretor());
        values.put(COLUNA_ATORES, filme.getAtores());
        values.put(COLUNA_GENERO, filme.getGenero());
        values.put(COLUNA_FAIXA, filme.getFaixa());
        values.put(COLUNA_LANCA, filme.getLancamento());
        values.put(COLUNA_DURACAO, filme.getDuracao());
        values.put(COLUNA_SINOPSE, filme.getSinopse());
        values.put(COLUNA_PAIS, filme.getPais());
        values.put(COLUNA_LINGUA, filme.getLingua());
        values.put(COLUNA_PREMIOS, filme.getPremios());

        db.insert(TABELA_FILME, null, values);
        db.close();
    }

    void apagarFilme(Filme filme){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABELA_FILME, COLUNA_CODIGO +" = ?", new String[]{ String.valueOf(filme.getCodigo()) });
        db.close();
    }

    Filme selecionarFilme(int codigo){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(
                        TABELA_FILME,
                        new String[]{ COLUNA_CODIGO, COLUNA_TITULO, COLUNA_DIRETOR, COLUNA_ATORES, COLUNA_GENERO, COLUNA_FAIXA, COLUNA_LANCA, COLUNA_DURACAO, COLUNA_SINOPSE, COLUNA_PAIS, COLUNA_LINGUA, COLUNA_PREMIOS },
                        COLUNA_CODIGO +" = ?",
                        new String[]{ String.valueOf(codigo) },
                        null, null, null, null
                );

        if(cursor != null){
            cursor.moveToFirst();
        }
        Filme filme =
                new Filme(Integer.parseInt(
                        cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11)
                );

        return filme;
    }

    void atualizarFilme(Filme filme){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUNA_TITULO, filme.getTitulo());
        values.put(COLUNA_DIRETOR, filme.getDiretor());
        values.put(COLUNA_ATORES, filme.getAtores());
        values.put(COLUNA_GENERO, filme.getGenero());
        values.put(COLUNA_FAIXA, filme.getFaixa());
        values.put(COLUNA_LANCA, filme.getLancamento());
        values.put(COLUNA_DURACAO, filme.getDuracao());
        values.put(COLUNA_SINOPSE, filme.getSinopse());
        values.put(COLUNA_PAIS, filme.getPais());
        values.put(COLUNA_LINGUA, filme.getLingua());
        values.put(COLUNA_PREMIOS, filme.getPremios());


        db.update(TABELA_FILME, values, COLUNA_CODIGO +" = ?",
                new String[]{ String.valueOf(filme.getCodigo()) });
    }

    public List<Filme> listaTodosFilmes(){
        List<Filme> listaFilmes = new ArrayList<Filme>();

        String query = "select * from "+ TABELA_FILME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            do{
                Filme filme = new Filme();
                filme.setCodigo(Integer.parseInt(c.getString(0)));
                filme.setTitulo(c.getString(1));
                filme.setDiretor(c.getString(2));
                filme.setAtores(c.getString(3));
                filme.setGenero(c.getString(4));
                filme.setFaixa(c.getString(5));
                filme.setLancamento(c.getString(6));
                filme.setDuracao(c.getString(7));
                filme.setSinopse(c.getString(8));
                filme.setPais(c.getString(9));
                filme.setLingua(c.getString(10));
                filme.setPremios(c.getString(11));

                listaFilmes.add(filme);
            } while(c.moveToNext());
        }

        return listaFilmes;
    }
}

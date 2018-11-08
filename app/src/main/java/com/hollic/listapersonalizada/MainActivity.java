package com.hollic.listapersonalizada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Curso> cursos = todosOsCursos();

        ListView listaDeCursos = (ListView) findViewById(R.id.lista);

        //chamada da nossa implementação
        AdapterCursosPersonalizado adapter =
                new AdapterCursosPersonalizado(cursos, this);

        listaDeCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i+1)
                {
                    case 1:
                        startActivity(new Intent(MainActivity.this, Curso1Activity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, Curso2Activity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, Curso3Activity.class));
                        break;
                }
            }
        });

        listaDeCursos.setAdapter(adapter);
    }

    public List<Curso> todosOsCursos() {

        List<Curso> cursos = new ArrayList<>();

        Curso curso1 = new Curso("HTML5 Básico",
                "Curso básico de programação WEB.");
        Curso curso2 = new Curso("ReactJS",
                "ReactJS a revolução do front-end.");
        Curso curso3 = new Curso("CSS3",
                "CSS3 e uma internet mais bela.");

        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);

        return cursos;
    }
}

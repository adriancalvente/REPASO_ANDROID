package com.example.repaso1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FRAGMENTO1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FRAGMENTO1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FRAGMENTO1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FRAGMENTO1.
     */
    // TODO: Rename and change types and number of parameters
    public static FRAGMENTO1 newInstance(String param1, String param2) {
        FRAGMENTO1 fragment = new FRAGMENTO1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_f_r_a_g_m_e_n_t_o1, container, false);
        RadioButton valor1 = root.findViewById(R.id.valor1);
        RadioButton valor2 = root.findViewById(R.id.valor2);
        RadioButton valor3 = root.findViewById(R.id.valor3);
        Button calcular = root.findViewById(R.id.button);
        EditText c1 = root.findViewById(R.id.editTextNumber);
        EditText c2 = root.findViewById(R.id.editTextNumber2);
        if (valor1.isChecked()) {
            cambiarWeb("https://es.wikipedia.org/wiki/Suma_(desambiguaci%C3%B3n)");
        }
        if (valor2.isChecked()) {
            cambiarWeb("https://es.wikipedia.org/wiki/Resta");

        }
        if (valor3.isChecked()) {
            cambiarWeb("https://es.wikipedia.org/wiki/Multiplicaci%C3%B3n");

        }

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valor1.isChecked()) {
                    cambiarWeb("https://es.wikipedia.org/wiki/Suma_(desambiguaci%C3%B3n)");
                    int suma = Integer.parseInt(c1.getText().toString()) + Integer.parseInt(c2.getText().toString());
                    Intent intent=new Intent(getActivity(), actividad2.class);
                    intent.putExtra("Resultado",suma);
                    startActivity(intent);
                }
                if (valor2.isChecked()) {
                    cambiarWeb("https://es.wikipedia.org/wiki/Resta");
                    int resta = Integer.parseInt(c1.getText().toString()) - Integer.parseInt(c2.getText().toString());
                    Intent intent=new Intent(getActivity(), actividad2.class);
                    intent.putExtra("Resultado",resta);
                    startActivity(intent);
                }
                if (valor3.isChecked()) {
                    cambiarWeb("https://es.wikipedia.org/wiki/Multiplicaci%C3%B3n");
                    int mult = Integer.parseInt(c1.getText().toString()) * Integer.parseInt(c2.getText().toString());
                    Intent intent=new Intent(getActivity(), actividad2.class);
                    intent.putExtra("Resultado",mult);
                    startActivity(intent);
                }
            }
        });

        return root;
    }
    public void cambiarWeb(String web) {
        //Le pasamos a esta actividad el webview del otro fragmento
        Activity ac = (Activity) getActivity();
        assert ac != null;
        WebView web1 = ac.findViewById(R.id.web);
        web1.loadUrl(web);
    }

}
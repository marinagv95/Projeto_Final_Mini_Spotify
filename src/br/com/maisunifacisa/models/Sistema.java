package br.com.maisunifacisa.models;


import java.util.ArrayList;


public class Sistema {
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public void criarUsuario(Usuario usuario) {
        usuarios.add(usuario);

    }

    public String listarTodosUsuarios() {
        String retorno = "";
        for (int i = 0; i < usuarios.size(); i++) {
            retorno += (i + 1) + " - " + usuarios.get(i).toString() + "\n";
        }
        return retorno;
    }

}

package org.mozdevz.grupo3;

import org.mozdevz.grupo3.model.Genero;
import org.mozdevz.grupo3.model.Medico;
import org.mozdevz.grupo3.servico.MedicoServico;

public class Teste {
    public static void main(String[] args){
        Medico m = new Medico();
        m.setNome("Adelino José");
        m.setApelido("Ngomacha");
        m.setGenero(Genero.MASCULINO);
        m.setTipoID("BI");
        m.setNrID("6546546516516Q");
        
        MedicoServico.guardar(m);
        
    }
}

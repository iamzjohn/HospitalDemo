package org.mozdevz.grupo3.servico;

import java.util.Calendar;

/**
 *
 * @author Adelino José
 */
public class GeradorCodigosServico {

    public static final int DOENTE = 0;
    public static final int MEDICO = 1;
    public static final int SECRETARIA = 2;
    

    private GeradorCodigosServico() {
    }

    public static String gerarCodigo(int tipoEntidade, int id) {
        String codigoGerado = "";
        String mID = (id < 9) ? "0" + id : String.valueOf(id);
        int anoActual = Calendar.getInstance().get(Calendar.YEAR);
        switch (tipoEntidade) {
            case DOENTE: {
                codigoGerado = "FC" + anoActual + mID;
                break;
            }
            case MEDICO: {
                codigoGerado = "MDC" + mID;
                break;
            }
            case SECRETARIA: {
                codigoGerado = "SRT" + anoActual + mID;
                break;
            }
            default:
                return "-vazio-";
        }
        return codigoGerado;
    }
}

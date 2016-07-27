package org.mozdevz.grupo3.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe com varios metodos e constantes uteis para realizacao de certas
 * tarefas.
 *
 * @author Adelino Jos'e Ngomacha
 */
public class Utilitarios {

    /**
     * Dias da semana em formato abreviado.
     */
    public static final String[] DIAS_SEMANA = new String[]{
        "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb", "Dom"};

    /**
     * Meses do ano.
     */
    public static final String[] MESES = new String[]{
        "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    /**
     * Calcular a diferenca, em meses, entre duas datas
     *
     * @param data0
     * @param data1
     * @return Numero de meses de diferenca
     */
    public static int diferencaEmMeses(Calendar data0, Calendar data1) {
        int ano0 = data0.get(Calendar.YEAR);
        int ano1 = data1.get(Calendar.YEAR);
        int diferencaAnos = Math.abs(ano0 - ano1);

        int mes0 = data0.get(Calendar.MONTH);
        int mes1 = data1.get(Calendar.MONTH);

        int restoData0 = 11 - mes0;
        int restoData1 = 11 - mes1;

        int diferencaMeses = Math.abs(restoData0 - restoData1) + Math.abs(mes0 - mes1);

        while (diferencaAnos > 1) {
            diferencaMeses += 12;
            diferencaAnos--;
        }

        return diferencaMeses;
    }

    public static String formatarData(Date data) {
        Locale mLocale = new Locale("pt", "PT");
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("dd-MMMM-YYYY", mLocale);
        return caractereMaisculo(3, mSimpleDateFormat.format(data));
    }

    public static String formatarDataReduzida(Date data) {
        Locale mLocale = new Locale("pt", "PT");
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("dd-MMMM", mLocale);
        return caractereMaisculo(3, mSimpleDateFormat.format(data));
    }

    public static String formatarDataHora(Date data) {
        Locale mLocale = new Locale("pt", "PT");
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("dd-MMMM-YYYY - HH'h'mm", mLocale);
        return caractereMaisculo(3, mSimpleDateFormat.format(data));
    }

    public static String formatarHora(Date data) {
        Locale mLocale = new Locale("pt", "PT");
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("HH'h'mm", mLocale);
        return caractereMaisculo(3, mSimpleDateFormat.format(data));
    }

    /**
     * Transforma o caractere que esta em determinada posicao numa String em
     * maiuscula.
     *
     * @param posicaoCaractere
     * @param string
     * @return String com caractere escolhido colocado em maiuscula
     */
    public static String caractereMaisculo(int posicaoCaractere, String string) {
        String stringFinal = "";
        for (int i = 0; i < string.length(); i++) {
            if (i == posicaoCaractere) {
                stringFinal += Character.toUpperCase(string.charAt(posicaoCaractere));
            } else {
                stringFinal += string.charAt(i);
            }
        }
        return stringFinal;
    }

    /**
     * Obter o Calendar de um objecto Date.
     *
     * @param data
     * @return Calendario
     */
    public static Calendar getCalendario(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return cal;
    }

    public static Date agora() {
        return Calendar.getInstance().getTime();
    }

    /**
     * Criar um directorio. Se o directorio ja existe, nao acontece nada. Se o
     * directorio ainda nao existe, ele sera criado.
     *
     * @param directorio Nome do directorio por criar
     */
    public static void criarDirectorioSeNaoExiste(String directorio) {
        if (directorio != null) {
            File mPasta = new File(directorio);
            if (!mPasta.exists()) {
                try {
                    mPasta.mkdir();
                } catch (SecurityException e) {
                    Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    /**
     * Retornar um valor numerico no formato "0,000.00 MT".
     *
     * @param numero
     * @return
     */
    public static String formatarDinheiro(double numero) {
        return String.format("%(,.2f", numero) + " MT";
    }

    public static String formatarDinheiroSemMoeda(double numero) {
        return String.format("%(,.2f", numero);
    }

    public static String formatarNumero(double numero) {
        if (numero == (long) numero) {
            return String.format("%d", (long) numero);
        } else {
            return String.format("%(,.2f", numero);
        }
    }

    /**
     * Obter o valor em extenso de um numero.
     *
     * @param numero Numero por obter o valor em extenso
     * @return Valor em extenso do numero fornecido
     */
    public static String getValorExtenso(double numero) {
        NumerosEmExtenso extenso = new NumerosEmExtenso();
        extenso.setNumber(numero);
        return extenso.toString();
    }

    /**
     * Calcular a idade com base na data de nascimento fornecida.
     *
     * @param dataNascimento Data de Nascimento do individuo
     * @return Idade do individuo
     */
    public static int idade(Date dataNascimento) {
        return Calendar.getInstance().get(Calendar.YEAR) - getCalendario(dataNascimento).get(Calendar.YEAR);
    }

    public static Calendar getCalendario() {
        return Calendar.getInstance();
    }

    /**
     * Obter o numero de dias que separa uma data da data actual.
     *
     * @param d
     * @return Numero de dias que separam as datas
     */
    public static int getNumeroDeDiasQueSePassaram(Date d) {
        Calendar dataHoje = Calendar.getInstance();
        Calendar data = getCalendario(d);
        int nrDias = (int) TimeUnit.MILLISECONDS.toDays(dataHoje.getTimeInMillis() - data.getTimeInMillis());
        return nrDias;
    }

    /**
     * Obter o numero de horas que separa uma data da data actual.
     *
     * @param d
     * @return Numero de horas que separam as datas
     */
    public static int getNumeroDeHorasQueSePassaram(Date d) {
        Calendar dataHoje = Calendar.getInstance();
        Calendar data = getCalendario(d);
        int nrHoras = (int) TimeUnit.MILLISECONDS.toHours(dataHoje.getTimeInMillis() - data.getTimeInMillis());
        return nrHoras;
    }
}


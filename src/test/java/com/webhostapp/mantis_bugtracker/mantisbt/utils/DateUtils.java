package com.webhostapp.mantis_bugtracker.mantisbt.utils;

import com.webhostapp.mantis_bugtracker.mantisbt.enums.FormatoData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private DateUtils() {
        throw new IllegalStateException("DateUtils class");
    }

    public static String dataAtualFormatada(FormatoData formato) {
        SimpleDateFormat formatador = new SimpleDateFormat(formato.valor());
        Date data = new Date();
        return formatador.format(data);
    }
}

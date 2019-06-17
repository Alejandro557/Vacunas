/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.helperBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Fecha {

    private Date date = new Date(Calendar.getInstance().getTimeInMillis());
    private SimpleDateFormat formato = new SimpleDateFormat("YYYY-mm-dd");

    public Date getFecha() {
        return date;
    }
    
    public String convertirFecha(Date fecha) {
        return formato.format(fecha);
    }
    
}

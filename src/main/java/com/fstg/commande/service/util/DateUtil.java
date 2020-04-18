/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.commande.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class DateUtil {
    
    private static String FORMAT_YY_MM_DD="yyyy-MM-dd" ;
    private static String FORMAT_YY="yyyy" ;
    
    public static Date parse(String dateAsString){
        try {
            SimpleDateFormat simpleDateFormat  = new SimpleDateFormat(FORMAT_YY_MM_DD);
            return  simpleDateFormat.parse(dateAsString);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public static Date parseAnnee(String dateAsString){
        try {
            SimpleDateFormat simpleDateFormat  = new SimpleDateFormat(FORMAT_YY);
            return  simpleDateFormat.parse(dateAsString);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

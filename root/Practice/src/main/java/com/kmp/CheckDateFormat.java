package com.kmp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

public class CheckDateFormat {
    /**
     * Number of tokens.
     */
    private static final int NTOKENS = 3;

    static Formatter fromString(final String format, final String in) {
        final String[] tokens = in.split("[\\-/]");
        if (tokens.length == NTOKENS) {
            switch (format) {
                case "YY_MM_DD":
                    System.out.println("YY_MM_DD");
                case "DD_MM_YY":
                    System.out.println("DD_MM_YY");
                case "MM_DD_YY":
                    System.out.println("MM_DD_YY");
                default:
                    // Nothing.
            }
        }

        // Invalid.

        return null;
    }

    public static void main(String args[]) {
      /*  Date d = new Date();
//        String a = String.valueOf(d.getTime());
        System.out.println(d);


        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String date = "2019-08-14T09:53:58.909+0530";

//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            System.out.println("parsed: "+simpleDateFormat.parse(date));
//            Date dd = simpleDateFormat.parse("1565777415404");
//            System.out.println(" :" + dd);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        java8DataMethods();
    }

    public static void java8DataMethods(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate localDate = LocalDate.parse("16-Sep-2019", formatter);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.of(0, 0, 0));
        String dateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault())
                .truncatedTo(ChronoUnit.MINUTES)
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(dateTime);
    }

    private static Date getRelativeDate(String serviceRequestedDate) {
        List<String> patternList = java.util.Arrays.asList("E MMM dd HH:mm:ss Z yyyy", "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", "yyyy-MM-dd'T'HH:mm:ssz", "yyyy-MM-dd'T'HH:mm:ss.SSSz",
                "yyyy-MM-dd HH:mm:ss.SSS", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd HH:mm:ssz", "yyyy-MM-dd HH:mm:ss.SSSz");

        Date relativeDate = null;
        for(String pattern : patternList) {
            relativeDate = getParsedDate(pattern, serviceRequestedDate);
            if(null != relativeDate) {
                break;
            }

        }
        return relativeDate;
    }

    private static Date getParsedDate(String pattern, String serviceRequestedDate) {
        Date parsedDate = null;
        try {
            DateFormat formatter = new SimpleDateFormat(pattern);
            parsedDate = formatter.parse(serviceRequestedDate);
        }
        catch (ParseException e) {
            //Ignore date if value is not configured in right format.
            return null;
        }
        return parsedDate;
    }


}



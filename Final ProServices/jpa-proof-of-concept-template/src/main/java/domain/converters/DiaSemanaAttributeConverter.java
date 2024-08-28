package domain.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.DayOfWeek;

@Converter
public class DiaSemanaAttributeConverter implements AttributeConverter<DayOfWeek, String> {

  @Override
  public String convertToDatabaseColumn(DayOfWeek dayOfWeek) {
    String dia = "";

    switch (dayOfWeek){

      case MONDAY -> {
        dia = "Lunes";
      }
      case TUESDAY -> {
        dia = "Martes";
      }
      case WEDNESDAY -> {
        dia = "Miercoles";
      }
      case THURSDAY -> {
        dia = "Jueves";
      }
      case FRIDAY -> {
        dia = "Viernes";
      }
      case SATURDAY -> {
        dia = "Sabado";
      }
      case SUNDAY -> {
        dia = "Domingo";
      }
    }
    return dia;
  }

  @Override
  public DayOfWeek convertToEntityAttribute(String s) {
    DayOfWeek dia = DayOfWeek.MONDAY;

    switch (s){
      case "Lunes" -> {
        dia = DayOfWeek.MONDAY;
      }
      case "Martes" -> {
        dia = DayOfWeek.TUESDAY;
      }
      case "Miercoles" -> {
        dia = DayOfWeek.WEDNESDAY;
      }
      case "Jueves" -> {
        dia = DayOfWeek.THURSDAY;
      }
      case "Viernes" -> {
        dia = DayOfWeek.FRIDAY;
      }
      case "Sabado" -> {
        dia = DayOfWeek.SATURDAY;
      }
      case "Domingo" -> {
        dia = DayOfWeek.SUNDAY;
      }
    }

    return dia;
  }
}

package domain.converters;

import domain.models.entities.mediosDeNotificacion.EmailSender;
import domain.models.entities.mediosDeNotificacion.IMedioDeNotificacion;
import domain.models.entities.mediosDeNotificacion.WppSender;

import javax.persistence.AttributeConverter;

public class MedioDeNotificacionAttributeConverter implements AttributeConverter<IMedioDeNotificacion, String> {

  @Override
  public String convertToDatabaseColumn(IMedioDeNotificacion iMedioDeNotificacion) {
    if(iMedioDeNotificacion == null){
      return null;
    }
    String descripcionMedioDeNotificacion = "";

    if(iMedioDeNotificacion instanceof WppSender){
      descripcionMedioDeNotificacion = "WPP";
    }
    else if(iMedioDeNotificacion instanceof EmailSender){
      descripcionMedioDeNotificacion = "EMAIL";
    }
    return descripcionMedioDeNotificacion;
  }

  @Override
  public IMedioDeNotificacion convertToEntityAttribute(String s) {
    if(s == null){
      return null;
    }
    IMedioDeNotificacion medioDeNotificacion = null;
    switch (s){
      case "WPP":
        medioDeNotificacion = new WppSender();
        break;
      case "EMAIL":
        medioDeNotificacion = new EmailSender();
        break;
    }
    return medioDeNotificacion;
  }
}

package entidade;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import org.postgresql.util.PGobject;

@Converter(autoApply = true)
public class Conversor implements AttributeConverter<Endereco, PGobject> {
    @Override
    public PGobject convertToDatabaseColumn(Endereco endereco){
        try{
            return endereco.inserirBD();
            
        }catch (SQLException ex){
            Logger.getLogger(Conversor.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
    }
    
    @Override
    public Endereco convertToEntityAttribute(PGobject dbData){
        try {
            return Endereco.retirarBD(dbData);
        } catch (SQLException ex) {
            Logger.getLogger(Conversor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}

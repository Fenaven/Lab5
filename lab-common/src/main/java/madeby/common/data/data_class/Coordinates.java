package madeby.common.data.data_class;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@XmlRootElement
public class Coordinates {
    public static final Double MAX_X = 274.0;
    @NonNull
    private Double x; //Максимальное значение поля: 274, Поле не может быть null
    @NonNull
    private Long y; //Поле не может быть null

    @Override
    public String toString() {
        return "\tCoordinates" + "\n\t\tx=" + x + "\n\t\ty=" + y + "\n";

    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Long y) {
        this.y = y;
    }

    @XmlElement
    public Double getX() {
        return x;
    }

    @XmlElement
    public Long getY() {
        return y;
    }
}

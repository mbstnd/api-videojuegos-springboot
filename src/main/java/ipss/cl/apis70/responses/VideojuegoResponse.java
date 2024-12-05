package ipss.cl.apis70.responses;

import ipss.cl.apis70.models.Videojuego;
import lombok.Data;

@Data
public class VideojuegoResponse {

  private int status;
  private String message;
  private Videojuego videojuego;

}

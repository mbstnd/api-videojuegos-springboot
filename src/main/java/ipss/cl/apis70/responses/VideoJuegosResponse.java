package ipss.cl.apis70.responses;

import java.util.List;

import ipss.cl.apis70.models.Videojuego;
import lombok.Data;

@Data
public class VideoJuegosResponse {
  private int status;
  private String message;
  private List<Videojuego> videojuego;

}

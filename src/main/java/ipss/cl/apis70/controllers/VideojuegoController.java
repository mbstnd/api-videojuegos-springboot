package ipss.cl.apis70.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import ipss.cl.apis70.models.Videojuego;
import ipss.cl.apis70.responses.VideojuegoResponse;
import ipss.cl.apis70.services.VideojuegoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("api")
public class VideojuegoController {
  @Autowired
  private VideojuegoService videojuegoService;

  // Crear

  @PostMapping(value = "crear", produces = "application/json")
  public ResponseEntity<Object> createVideoJuego(@RequestBody Videojuego videojuego) {
    videojuegoService.crear(videojuego);

    // Crear Estructura de Respuesta
    VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
    videojuegoResponse.setStatus(200);
    videojuegoResponse.setMessage("VideoJuego Creado correctamente");
    videojuegoResponse.setVideojuego(videojuego);

    return ResponseEntity.ok()
        .body(videojuegoResponse);
  }

}

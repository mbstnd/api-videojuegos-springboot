package ipss.cl.apis70.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import ipss.cl.apis70.models.Videojuego;
import ipss.cl.apis70.responses.VideoJuegosResponse;
import ipss.cl.apis70.responses.VideojuegoResponse;
import ipss.cl.apis70.services.VideojuegoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("api")
public class VideojuegoController {
  @Autowired
  private VideojuegoService videojuegoService;

  // Crear

  @PostMapping(value = "create", produces = "application/json")
  public ResponseEntity<Object> createVideoJuego(@RequestBody Videojuego videojuego) {

    if (videojuego.getTitle() == null || videojuego.getTitle().isEmpty()) {
      throw new RuntimeException("El título del videojuego es obligatorio");
    }
    videojuegoService.create(videojuego);

    // Crear Estructura de Respuesta
    VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
    videojuegoResponse.setStatus(200);
    videojuegoResponse.setMessage("El videojuego ha sido creado exitosamente.");
    videojuegoResponse.setVideojuego(videojuego);

    return ResponseEntity.ok()
        .body(videojuegoResponse);
  }

  // Listar

  @GetMapping(value = "getAll", produces = "application/json")
  public ResponseEntity<Object> getVideoJuegos() {
    VideoJuegosResponse videoJuegosResponse = new VideoJuegosResponse();
    videoJuegosResponse.setStatus(200);
    videoJuegosResponse.setMessage("Lista de videojuegos disponibles obtenida exitosamente.");
    videoJuegosResponse.setVideojuego(videojuegoService.listAll());

    return ResponseEntity.ok()
        .body(videoJuegosResponse);
  }

  // Buscar por Id

  @GetMapping(value = "getById/{id}", produces = "application/json")
  public ResponseEntity<Object> getVideoJuego(@PathVariable String id) {
    VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
    videojuegoResponse.setStatus(200);
    videojuegoResponse.setMessage("El videojuego fue encontrado exitosamente.");
    videojuegoResponse.setVideojuego(videojuegoService.find(id));

    return ResponseEntity.ok()
        .body(videojuegoResponse);
  }

  // Actualizar
  // Recibo por el PathVarriable el id y el objeto que viene por el body que es un
  // videojuego y viene con su estructura.

  @PutMapping(value = "update/{id}", produces = "application/json")
  public ResponseEntity<Object> setVideoJuego(@PathVariable String id, @RequestBody Videojuego videojuegoRequest) {
    VideojuegoResponse videojuegoResponse = new VideojuegoResponse(); // Crea estructura de Response.
    Videojuego videojuego = new Videojuego(); // Crea una instancia de videojuego para asignar a una variable con la
                                              // estructura de videojuego.

    videojuego = videojuegoService.find(id); // Busca en la BD de acuerdo al id que recibe por parametro.
    videojuego.setTitle(videojuegoRequest.getTitle());
    videojuego.setFabricante(videojuegoRequest.getFabricante());
    videojuegoService.create(videojuego);

    videojuegoResponse.setStatus(200);
    videojuegoResponse.setMessage("El videojuego ha sido actualizado correctamente.");
    videojuegoResponse.setVideojuego(videojuego);

    return ResponseEntity.ok()
        .body(videojuegoResponse);

  }

  // Eliminar

  @DeleteMapping(value = "delete/{id}", produces = "application/json")
  public ResponseEntity<Object> deleteVideoJuego(@PathVariable String id) {
    VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
    videojuegoService.delete(id);

    videojuegoResponse.setStatus(200);
    videojuegoResponse.setMessage("El videojuego ha sido eliminado correctamente.");

    return ResponseEntity.ok()
        .body(videojuegoResponse);

  }

}
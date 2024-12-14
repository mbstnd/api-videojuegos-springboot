package ipss.cl.apis70.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipss.cl.apis70.models.Videojuego;
import ipss.cl.apis70.repositories.VideojuegoRepository;

@Service
public class VideojuegoService {
  @Autowired
  public VideojuegoRepository videojuegoRepository;

  // Crear

  public Videojuego create(Videojuego videojuego) {
    return videojuegoRepository.save(videojuego);
  }

  // Listar

  public List<Videojuego> listAll() {
    return videojuegoRepository.findAll();
  }

  // Buscar

  public Videojuego find(String id) {
    return videojuegoRepository.findById(id).orElse(null);
  }

  // Eliminar

  public void delete(String id) {
    videojuegoRepository.deleteById(id);
  }

}
